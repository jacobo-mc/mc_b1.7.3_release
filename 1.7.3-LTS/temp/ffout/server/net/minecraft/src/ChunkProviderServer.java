package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChunkProviderServer implements IChunkProvider {
    private Set field_725_a = new HashSet();
    private Chunk field_724_b;
    private IChunkProvider field_730_c;
    private IChunkLoader field_729_d;
    public boolean field_28068_a = false;
    private Map field_728_e = new HashMap();
    private List field_727_f = new ArrayList();
    private WorldServer field_726_g;

    public ChunkProviderServer(WorldServer var1, IChunkLoader var2, IChunkProvider var3) {
        this.field_724_b = new EmptyChunk(var1, new byte['\u8000'], 0, 0);
        this.field_726_g = var1;
        this.field_729_d = var2;
        this.field_730_c = var3;
    }

    public boolean func_365_a(int var1, int var2) {
        return this.field_728_e.containsKey(ChunkCoordIntPair.func_22006_a(var1, var2));
    }

    public void func_374_c(int var1, int var2) {
        ChunkCoordinates var3 = this.field_726_g.func_22078_l();
        int var4 = var1 * 16 + 8 - var3.field_22216_a;
        int var5 = var2 * 16 + 8 - var3.field_528_b;
        short var6 = 128;
        if (var4 < -var6 || var4 > var6 || var5 < -var6 || var5 > var6) {
            this.field_725_a.add(ChunkCoordIntPair.func_22006_a(var1, var2));
        }

    }

    public Chunk func_376_d(int var1, int var2) {
        int var3 = ChunkCoordIntPair.func_22006_a(var1, var2);
        this.field_725_a.remove(var3);
        Chunk var4 = (Chunk)this.field_728_e.get(var3);
        if (var4 == null) {
            var4 = this.func_4063_e(var1, var2);
            if (var4 == null) {
                if (this.field_730_c == null) {
                    var4 = this.field_724_b;
                } else {
                    var4 = this.field_730_c.func_363_b(var1, var2);
                }
            }

            this.field_728_e.put(var3, var4);
            this.field_727_f.add(var4);
            if (var4 != null) {
                var4.func_4053_c();
                var4.func_358_c();
            }

            if (!var4.field_681_n && this.func_365_a(var1 + 1, var2 + 1) && this.func_365_a(var1, var2 + 1) && this.func_365_a(var1 + 1, var2)) {
                this.func_4055_a(this, var1, var2);
            }

            if (this.func_365_a(var1 - 1, var2) && !this.func_363_b(var1 - 1, var2).field_681_n && this.func_365_a(var1 - 1, var2 + 1) && this.func_365_a(var1, var2 + 1) && this.func_365_a(var1 - 1, var2)) {
                this.func_4055_a(this, var1 - 1, var2);
            }

            if (this.func_365_a(var1, var2 - 1) && !this.func_363_b(var1, var2 - 1).field_681_n && this.func_365_a(var1 + 1, var2 - 1) && this.func_365_a(var1, var2 - 1) && this.func_365_a(var1 + 1, var2)) {
                this.func_4055_a(this, var1, var2 - 1);
            }

            if (this.func_365_a(var1 - 1, var2 - 1) && !this.func_363_b(var1 - 1, var2 - 1).field_681_n && this.func_365_a(var1 - 1, var2 - 1) && this.func_365_a(var1, var2 - 1) && this.func_365_a(var1 - 1, var2)) {
                this.func_4055_a(this, var1 - 1, var2 - 1);
            }
        }

        return var4;
    }

    public Chunk func_363_b(int var1, int var2) {
        Chunk var3 = (Chunk)this.field_728_e.get(ChunkCoordIntPair.func_22006_a(var1, var2));
        if (var3 == null) {
            return !this.field_726_g.field_9209_x && !this.field_28068_a ? this.field_724_b : this.func_376_d(var1, var2);
        } else {
            return var3;
        }
    }

    private Chunk func_4063_e(int var1, int var2) {
        if (this.field_729_d == null) {
            return null;
        } else {
            try {
                Chunk var3 = this.field_729_d.func_659_a(this.field_726_g, var1, var2);
                if (var3 != null) {
                    var3.field_676_s = this.field_726_g.func_22080_k();
                }

                return var3;
            } catch (Exception var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    private void func_375_a(Chunk var1) {
        if (this.field_729_d != null) {
            try {
                this.field_729_d.func_4104_b(this.field_726_g, var1);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    private void func_373_b(Chunk var1) {
        if (this.field_729_d != null) {
            try {
                var1.field_676_s = this.field_726_g.func_22080_k();
                this.field_729_d.func_662_a(this.field_726_g, var1);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }

    public void func_4055_a(IChunkProvider var1, int var2, int var3) {
        Chunk var4 = this.func_363_b(var2, var3);
        if (!var4.field_681_n) {
            var4.field_681_n = true;
            if (this.field_730_c != null) {
                this.field_730_c.func_4055_a(var1, var2, var3);
                var4.func_336_e();
            }
        }

    }

    public boolean func_360_a(boolean var1, IProgressUpdate var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < this.field_727_f.size(); ++var4) {
            Chunk var5 = (Chunk)this.field_727_f.get(var4);
            if (var1 && !var5.field_679_p) {
                this.func_375_a(var5);
            }

            if (var5.func_347_a(var1)) {
                this.func_373_b(var5);
                var5.field_680_o = false;
                ++var3;
                if (var3 == 24 && !var1) {
                    return false;
                }
            }
        }

        if (var1) {
            if (this.field_729_d == null) {
                return true;
            }

            this.field_729_d.func_660_b();
        }

        return true;
    }

    public boolean func_361_a() {
        if (!this.field_726_g.field_816_A) {
            for(int var1 = 0; var1 < 100; ++var1) {
                if (!this.field_725_a.isEmpty()) {
                    Integer var2 = (Integer)this.field_725_a.iterator().next();
                    Chunk var3 = (Chunk)this.field_728_e.get(var2);
                    var3.func_331_d();
                    this.func_373_b(var3);
                    this.func_375_a(var3);
                    this.field_725_a.remove(var2);
                    this.field_728_e.remove(var2);
                    this.field_727_f.remove(var3);
                }
            }

            if (this.field_729_d != null) {
                this.field_729_d.func_661_a();
            }
        }

        return this.field_730_c.func_361_a();
    }

    public boolean func_364_b() {
        return !this.field_726_g.field_816_A;
    }
}
