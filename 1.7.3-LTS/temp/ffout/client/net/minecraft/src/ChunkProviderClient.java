package net.minecraft.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChunkProviderClient implements IChunkProvider {
    private Chunk field_887_a;
    private Map field_886_b = new HashMap();
    private List field_889_c = new ArrayList();
    private World field_888_d;

    public ChunkProviderClient(World var1) {
        this.field_887_a = new EmptyChunk(var1, new byte['\u8000'], 0, 0);
        this.field_888_d = var1;
    }

    public boolean func_537_a(int var1, int var2) {
        if (this != null) {
            return true;
        } else {
            ChunkCoordIntPair var3 = new ChunkCoordIntPair(var1, var2);
            return this.field_886_b.containsKey(var3);
        }
    }

    public void func_539_c(int var1, int var2) {
        Chunk var3 = this.func_533_b(var1, var2);
        if (!var3.func_21167_h()) {
            var3.func_998_e();
        }

        this.field_886_b.remove(new ChunkCoordIntPair(var1, var2));
        this.field_889_c.remove(var3);
    }

    public Chunk func_538_d(int var1, int var2) {
        ChunkCoordIntPair var3 = new ChunkCoordIntPair(var1, var2);
        byte[] var4 = new byte['\u8000'];
        Chunk var5 = new Chunk(this.field_888_d, var4, var1, var2);
        Arrays.fill(var5.field_1535_f.field_1109_a, (byte)-1);
        this.field_886_b.put(var3, var5);
        var5.field_1538_c = true;
        return var5;
    }

    public Chunk func_533_b(int var1, int var2) {
        ChunkCoordIntPair var3 = new ChunkCoordIntPair(var1, var2);
        Chunk var4 = (Chunk)this.field_886_b.get(var3);
        return var4 == null ? this.field_887_a : var4;
    }

    public boolean func_535_a(boolean var1, IProgressUpdate var2) {
        return true;
    }

    public boolean func_532_a() {
        return false;
    }

    public boolean func_536_b() {
        return false;
    }

    public void func_534_a(IChunkProvider var1, int var2, int var3) {
    }

    public String func_21109_c() {
        return "MultiplayerChunkCache: " + this.field_886_b.size();
    }
}
