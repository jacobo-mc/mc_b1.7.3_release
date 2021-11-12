package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChunkProvider implements IChunkProvider {
    private Set field_28065_a = new HashSet();
    private Chunk field_28064_b;
    private IChunkProvider field_28070_c;
    private IChunkLoader field_28069_d;
    private Map field_28068_e = new HashMap();
    private List field_28067_f = new ArrayList();
    private World field_28066_g;

    public ChunkProvider(World var1, IChunkLoader var2, IChunkProvider var3) {
        this.field_28064_b = new EmptyChunk(var1, new byte['\u8000'], 0, 0);
        this.field_28066_g = var1;
        this.field_28069_d = var2;
        this.field_28070_c = var3;
    }

    public boolean func_537_a(int var1, int var2) {
        return this.field_28068_e.containsKey(ChunkCoordIntPair.func_22011_a(var1, var2));
    }

    public Chunk func_538_d(int var1, int var2) {
        int var3 = ChunkCoordIntPair.func_22011_a(var1, var2);
        this.field_28065_a.remove(var3);
        Chunk var4 = (Chunk)this.field_28068_e.get(var3);
        if (var4 == null) {
            var4 = this.func_28061_d(var1, var2);
            if (var4 == null) {
                if (this.field_28070_c == null) {
                    var4 = this.field_28064_b;
                } else {
                    var4 = this.field_28070_c.func_533_b(var1, var2);
                }
            }

            this.field_28068_e.put(var3, var4);
            this.field_28067_f.add(var4);
            if (var4 != null) {
                var4.func_4143_d();
                var4.func_995_d();
            }

            if (!var4.field_1527_n && this.func_537_a(var1 + 1, var2 + 1) && this.func_537_a(var1, var2 + 1) && this.func_537_a(var1 + 1, var2)) {
                this.func_534_a(this, var1, var2);
            }

            if (this.func_537_a(var1 - 1, var2) && !this.func_533_b(var1 - 1, var2).field_1527_n && this.func_537_a(var1 - 1, var2 + 1) && this.func_537_a(var1, var2 + 1) && this.func_537_a(var1 - 1, var2)) {
                this.func_534_a(this, var1 - 1, var2);
            }

            if (this.func_537_a(var1, var2 - 1) && !this.func_533_b(var1, var2 - 1).field_1527_n && this.func_537_a(var1 + 1, var2 - 1) && this.func_537_a(var1, var2 - 1) && this.func_537_a(var1 + 1, var2)) {
                this.func_534_a(this, var1, var2 - 1);
            }

            if (this.func_537_a(var1 - 1, var2 - 1) && !this.func_533_b(var1 - 1, var2 - 1).field_1527_n && this.func_537_a(var1 - 1, var2 - 1) && this.func_537_a(var1, var2 - 1) && this.func_537_a(var1 - 1, var2)) {
                this.func_534_a(this, var1 - 1, var2 - 1);
            }
        }

        return var4;
    }

    public Chunk func_533_b(int var1, int var2) {
        Chunk var3 = (Chunk)this.field_28068_e.get(ChunkCoordIntPair.func_22011_a(var1, var2));
        return var3 == null ? this.func_538_d(var1, var2) : var3;
    }

    private Chunk func_28061_d(int var1, int var2) {
        if (this.field_28069_d == null) {
            return null;
        } else {
            try {
                Chunk var3 = this.field_28069_d.func_813_a(this.field_28066_g, var1, var2);
                if (var3 != null) {
                    var3.field_1522_s = this.field_28066_g.func_22139_r();
                }

                return var3;
            } catch (Exception var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    private void func_28063_a(Chunk var1) {
        if (this.field_28069_d != null) {
            try {
                this.field_28069_d.func_815_b(this.field_28066_g, var1);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    private void func_28062_b(Chunk var1) {
        if (this.field_28069_d != null) {
            try {
                var1.field_1522_s = this.field_28066_g.func_22139_r();
                this.field_28069_d.func_812_a(this.field_28066_g, var1);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }

    public void func_534_a(IChunkProvider var1, int var2, int var3) {
        Chunk var4 = this.func_533_b(var2, var3);
        if (!var4.field_1527_n) {
            var4.field_1527_n = true;
            if (this.field_28070_c != null) {
                this.field_28070_c.func_534_a(var1, var2, var3);
                var4.func_1006_f();
            }
        }

    }

    public boolean func_535_a(boolean var1, IProgressUpdate var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < this.field_28067_f.size(); ++var4) {
            Chunk var5 = (Chunk)this.field_28067_f.get(var4);
            if (var1 && !var5.field_1525_p) {
                this.func_28063_a(var5);
            }

            if (var5.func_1012_a(var1)) {
                this.func_28062_b(var5);
                var5.field_1526_o = false;
                ++var3;
                if (var3 == 24 && !var1) {
                    return false;
                }
            }
        }

        if (var1) {
            if (this.field_28069_d == null) {
                return true;
            }

            this.field_28069_d.func_811_b();
        }

        return true;
    }

    public boolean func_532_a() {
        for(int var1 = 0; var1 < 100; ++var1) {
            if (!this.field_28065_a.isEmpty()) {
                Integer var2 = (Integer)this.field_28065_a.iterator().next();
                Chunk var3 = (Chunk)this.field_28068_e.get(var2);
                var3.func_998_e();
                this.func_28062_b(var3);
                this.func_28063_a(var3);
                this.field_28065_a.remove(var2);
                this.field_28068_e.remove(var2);
                this.field_28067_f.remove(var3);
            }
        }

        if (this.field_28069_d != null) {
            this.field_28069_d.func_814_a();
        }

        return this.field_28070_c.func_532_a();
    }

    public boolean func_536_b() {
        return true;
    }

    public String func_21109_c() {
        return "ServerChunkCache: " + this.field_28068_e.size() + " Drop: " + this.field_28065_a.size();
    }
}
