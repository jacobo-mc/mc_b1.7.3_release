package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class McRegionChunkLoader implements IChunkLoader {
    private final File field_22184_a;

    public McRegionChunkLoader(File var1) {
        this.field_22184_a = var1;
    }

    public Chunk func_813_a(World var1, int var2, int var3) throws IOException {
        DataInputStream var4 = RegionFileCache.func_22194_c(this.field_22184_a, var2, var3);
        if (var4 != null) {
            NBTTagCompound var5 = CompressedStreamTools.func_1141_a(var4);
            if (!var5.func_751_b("Level")) {
                System.out.println("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
                return null;
            } else if (!var5.func_743_k("Level").func_751_b("Blocks")) {
                System.out.println("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
                return null;
            } else {
                Chunk var6 = ChunkLoader.func_816_a(var1, var5.func_743_k("Level"));
                if (!var6.func_1017_a(var2, var3)) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.field_1531_j + ", " + var6.field_1530_k + ")");
                    var5.func_758_a("xPos", var2);
                    var5.func_758_a("zPos", var3);
                    var6 = ChunkLoader.func_816_a(var1, var5.func_743_k("Level"));
                }

                var6.func_25124_i();
                return var6;
            }
        } else {
            return null;
        }
    }

    public void func_812_a(World var1, Chunk var2) throws IOException {
        var1.func_663_l();

        try {
            DataOutputStream var3 = RegionFileCache.func_22190_d(this.field_22184_a, var2.field_1531_j, var2.field_1530_k);
            NBTTagCompound var4 = new NBTTagCompound();
            NBTTagCompound var5 = new NBTTagCompound();
            var4.func_762_a("Level", var5);
            ChunkLoader.func_818_a(var2, var1, var5);
            CompressedStreamTools.func_1139_a(var4, var3);
            var3.close();
            WorldInfo var6 = var1.func_22144_v();
            var6.func_22297_b(var6.func_22306_g() + (long)RegionFileCache.func_22191_b(this.field_22184_a, var2.field_1531_j, var2.field_1530_k));
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public void func_815_b(World var1, Chunk var2) throws IOException {
    }

    public void func_814_a() {
    }

    public void func_811_b() {
    }
}
