package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Chunk {
    public static boolean field_1540_a;
    public byte[] field_1539_b;
    public boolean field_1538_c;
    public World field_1537_d;
    public NibbleArray field_1536_e;
    public NibbleArray field_1535_f;
    public NibbleArray field_1534_g;
    public byte[] field_1533_h;
    public int field_1532_i;
    public final int field_1531_j;
    public final int field_1530_k;
    public Map field_1529_l;
    public List[] field_1528_m;
    public boolean field_1527_n;
    public boolean field_1526_o;
    public boolean field_1525_p;
    public boolean field_1523_r;
    public long field_1522_s;

    public Chunk(World var1, int var2, int var3) {
        this.field_1529_l = new HashMap();
        this.field_1528_m = new List[8];
        this.field_1527_n = false;
        this.field_1526_o = false;
        this.field_1523_r = false;
        this.field_1522_s = 0L;
        this.field_1537_d = var1;
        this.field_1531_j = var2;
        this.field_1530_k = var3;
        this.field_1533_h = new byte[256];

        for(int var4 = 0; var4 < this.field_1528_m.length; ++var4) {
            this.field_1528_m[var4] = new ArrayList();
        }

    }

    public Chunk(World var1, byte[] var2, int var3, int var4) {
        this(var1, var3, var4);
        this.field_1539_b = var2;
        this.field_1536_e = new NibbleArray(var2.length);
        this.field_1535_f = new NibbleArray(var2.length);
        this.field_1534_g = new NibbleArray(var2.length);
    }

    public boolean func_1017_a(int var1, int var2) {
        return var1 == this.field_1531_j && var2 == this.field_1530_k;
    }

    public int func_999_b(int var1, int var2) {
        return this.field_1533_h[var2 << 4 | var1] & 255;
    }

    public void func_1014_a() {
    }

    public void func_1018_b() {
        int var1 = 127;

        for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
                int var4 = 127;

                for(int var5 = var2 << 11 | var3 << 7; var4 > 0 && Block.field_341_r[this.field_1539_b[var5 + var4 - 1] & 255] == 0; --var4) {
                }

                this.field_1533_h[var3 << 4 | var2] = (byte)var4;
                if (var4 < var1) {
                    var1 = var4;
                }
            }
        }

        this.field_1532_i = var1;
        this.field_1526_o = true;
    }

    public void func_1024_c() {
        int var1 = 127;

        int var2;
        int var3;
        for(var2 = 0; var2 < 16; ++var2) {
            for(var3 = 0; var3 < 16; ++var3) {
                int var4 = 127;

                int var5;
                for(var5 = var2 << 11 | var3 << 7; var4 > 0 && Block.field_341_r[this.field_1539_b[var5 + var4 - 1] & 255] == 0; --var4) {
                }

                this.field_1533_h[var3 << 4 | var2] = (byte)var4;
                if (var4 < var1) {
                    var1 = var4;
                }

                if (!this.field_1537_d.field_4209_q.field_6478_e) {
                    int var6 = 15;
                    int var7 = 127;

                    do {
                        var6 -= Block.field_341_r[this.field_1539_b[var5 + var7] & 255];
                        if (var6 > 0) {
                            this.field_1535_f.func_770_a(var2, var7, var3, var6);
                        }

                        --var7;
                    } while(var7 > 0 && var6 > 0);
                }
            }
        }

        this.field_1532_i = var1;

        for(var2 = 0; var2 < 16; ++var2) {
            for(var3 = 0; var3 < 16; ++var3) {
                this.func_996_c(var2, var3);
            }
        }

        this.field_1526_o = true;
    }

    public void func_4143_d() {
    }

    private void func_996_c(int var1, int var2) {
        int var3 = this.func_999_b(var1, var2);
        int var4 = this.field_1531_j * 16 + var1;
        int var5 = this.field_1530_k * 16 + var2;
        this.func_1020_f(var4 - 1, var5, var3);
        this.func_1020_f(var4 + 1, var5, var3);
        this.func_1020_f(var4, var5 - 1, var3);
        this.func_1020_f(var4, var5 + 1, var3);
    }

    private void func_1020_f(int var1, int var2, int var3) {
        int var4 = this.field_1537_d.func_666_c(var1, var2);
        if (var4 > var3) {
            this.field_1537_d.func_616_a(EnumSkyBlock.Sky, var1, var3, var2, var1, var4, var2);
            this.field_1526_o = true;
        } else if (var4 < var3) {
            this.field_1537_d.func_616_a(EnumSkyBlock.Sky, var1, var4, var2, var1, var3, var2);
            this.field_1526_o = true;
        }

    }

    private void func_1003_g(int var1, int var2, int var3) {
        int var4 = this.field_1533_h[var3 << 4 | var1] & 255;
        int var5 = var4;
        if (var2 > var4) {
            var5 = var2;
        }

        for(int var6 = var1 << 11 | var3 << 7; var5 > 0 && Block.field_341_r[this.field_1539_b[var6 + var5 - 1] & 255] == 0; --var5) {
        }

        if (var5 != var4) {
            this.field_1537_d.func_680_f(var1, var3, var5, var4);
            this.field_1533_h[var3 << 4 | var1] = (byte)var5;
            int var7;
            int var8;
            int var9;
            if (var5 < this.field_1532_i) {
                this.field_1532_i = var5;
            } else {
                var7 = 127;

                for(var8 = 0; var8 < 16; ++var8) {
                    for(var9 = 0; var9 < 16; ++var9) {
                        if ((this.field_1533_h[var9 << 4 | var8] & 255) < var7) {
                            var7 = this.field_1533_h[var9 << 4 | var8] & 255;
                        }
                    }
                }

                this.field_1532_i = var7;
            }

            var7 = this.field_1531_j * 16 + var1;
            var8 = this.field_1530_k * 16 + var3;
            if (var5 < var4) {
                for(var9 = var5; var9 < var4; ++var9) {
                    this.field_1535_f.func_770_a(var1, var9, var3, 15);
                }
            } else {
                this.field_1537_d.func_616_a(EnumSkyBlock.Sky, var7, var4, var8, var7, var5, var8);

                for(var9 = var4; var9 < var5; ++var9) {
                    this.field_1535_f.func_770_a(var1, var9, var3, 0);
                }
            }

            var9 = 15;

            int var10;
            for(var10 = var5; var5 > 0 && var9 > 0; this.field_1535_f.func_770_a(var1, var5, var3, var9)) {
                --var5;
                int var11 = Block.field_341_r[this.func_1008_a(var1, var5, var3)];
                if (var11 == 0) {
                    var11 = 1;
                }

                var9 -= var11;
                if (var9 < 0) {
                    var9 = 0;
                }
            }

            while(var5 > 0 && Block.field_341_r[this.func_1008_a(var1, var5 - 1, var3)] == 0) {
                --var5;
            }

            if (var5 != var10) {
                this.field_1537_d.func_616_a(EnumSkyBlock.Sky, var7 - 1, var5, var8 - 1, var7 + 1, var10, var8 + 1);
            }

            this.field_1526_o = true;
        }
    }

    public int func_1008_a(int var1, int var2, int var3) {
        return this.field_1539_b[var1 << 11 | var3 << 7 | var2] & 255;
    }

    public boolean func_1010_a(int var1, int var2, int var3, int var4, int var5) {
        byte var6 = (byte)var4;
        int var7 = this.field_1533_h[var3 << 4 | var1] & 255;
        int var8 = this.field_1539_b[var1 << 11 | var3 << 7 | var2] & 255;
        if (var8 == var4 && this.field_1536_e.func_771_a(var1, var2, var3) == var5) {
            return false;
        } else {
            int var9 = this.field_1531_j * 16 + var1;
            int var10 = this.field_1530_k * 16 + var3;
            this.field_1539_b[var1 << 11 | var3 << 7 | var2] = (byte)(var6 & 255);
            if (var8 != 0 && !this.field_1537_d.field_1026_y) {
                Block.field_345_n[var8].func_214_b(this.field_1537_d, var9, var2, var10);
            }

            this.field_1536_e.func_770_a(var1, var2, var3, var5);
            if (!this.field_1537_d.field_4209_q.field_6478_e) {
                if (Block.field_341_r[var6 & 255] != 0) {
                    if (var2 >= var7) {
                        this.func_1003_g(var1, var2 + 1, var3);
                    }
                } else if (var2 == var7 - 1) {
                    this.func_1003_g(var1, var2, var3);
                }

                this.field_1537_d.func_616_a(EnumSkyBlock.Sky, var9, var2, var10, var9, var2, var10);
            }

            this.field_1537_d.func_616_a(EnumSkyBlock.Block, var9, var2, var10, var9, var2, var10);
            this.func_996_c(var1, var3);
            this.field_1536_e.func_770_a(var1, var2, var3, var5);
            if (var4 != 0) {
                Block.field_345_n[var4].func_235_e(this.field_1537_d, var9, var2, var10);
            }

            this.field_1526_o = true;
            return true;
        }
    }

    public boolean func_1022_a(int var1, int var2, int var3, int var4) {
        byte var5 = (byte)var4;
        int var6 = this.field_1533_h[var3 << 4 | var1] & 255;
        int var7 = this.field_1539_b[var1 << 11 | var3 << 7 | var2] & 255;
        if (var7 == var4) {
            return false;
        } else {
            int var8 = this.field_1531_j * 16 + var1;
            int var9 = this.field_1530_k * 16 + var3;
            this.field_1539_b[var1 << 11 | var3 << 7 | var2] = (byte)(var5 & 255);
            if (var7 != 0) {
                Block.field_345_n[var7].func_214_b(this.field_1537_d, var8, var2, var9);
            }

            this.field_1536_e.func_770_a(var1, var2, var3, 0);
            if (Block.field_341_r[var5 & 255] != 0) {
                if (var2 >= var6) {
                    this.func_1003_g(var1, var2 + 1, var3);
                }
            } else if (var2 == var6 - 1) {
                this.func_1003_g(var1, var2, var3);
            }

            this.field_1537_d.func_616_a(EnumSkyBlock.Sky, var8, var2, var9, var8, var2, var9);
            this.field_1537_d.func_616_a(EnumSkyBlock.Block, var8, var2, var9, var8, var2, var9);
            this.func_996_c(var1, var3);
            if (var4 != 0 && !this.field_1537_d.field_1026_y) {
                Block.field_345_n[var4].func_235_e(this.field_1537_d, var8, var2, var9);
            }

            this.field_1526_o = true;
            return true;
        }
    }

    public int func_1021_b(int var1, int var2, int var3) {
        return this.field_1536_e.func_771_a(var1, var2, var3);
    }

    public void func_1009_b(int var1, int var2, int var3, int var4) {
        this.field_1526_o = true;
        this.field_1536_e.func_770_a(var1, var2, var3, var4);
    }

    public int func_1025_a(EnumSkyBlock var1, int var2, int var3, int var4) {
        if (var1 == EnumSkyBlock.Sky) {
            return this.field_1535_f.func_771_a(var2, var3, var4);
        } else {
            return var1 == EnumSkyBlock.Block ? this.field_1534_g.func_771_a(var2, var3, var4) : 0;
        }
    }

    public void func_1011_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        this.field_1526_o = true;
        if (var1 == EnumSkyBlock.Sky) {
            this.field_1535_f.func_770_a(var2, var3, var4, var5);
        } else {
            if (var1 != EnumSkyBlock.Block) {
                return;
            }

            this.field_1534_g.func_770_a(var2, var3, var4, var5);
        }

    }

    public int func_1019_c(int var1, int var2, int var3, int var4) {
        int var5 = this.field_1535_f.func_771_a(var1, var2, var3);
        if (var5 > 0) {
            field_1540_a = true;
        }

        var5 -= var4;
        int var6 = this.field_1534_g.func_771_a(var1, var2, var3);
        if (var6 > var5) {
            var5 = var6;
        }

        return var5;
    }

    public void func_1000_a(Entity var1) {
        this.field_1523_r = true;
        int var2 = MathHelper.func_1108_b(var1.field_611_ak / 16.0D);
        int var3 = MathHelper.func_1108_b(var1.field_609_am / 16.0D);
        if (var2 != this.field_1531_j || var3 != this.field_1530_k) {
            System.out.println("Wrong location! " + var1);
            Thread.dumpStack();
        }

        int var4 = MathHelper.func_1108_b(var1.field_610_al / 16.0D);
        if (var4 < 0) {
            var4 = 0;
        }

        if (var4 >= this.field_1528_m.length) {
            var4 = this.field_1528_m.length - 1;
        }

        var1.field_621_aZ = true;
        var1.field_657_ba = this.field_1531_j;
        var1.field_656_bb = var4;
        var1.field_654_bc = this.field_1530_k;
        this.field_1528_m[var4].add(var1);
    }

    public void func_1015_b(Entity var1) {
        this.func_1016_a(var1, var1.field_656_bb);
    }

    public void func_1016_a(Entity var1, int var2) {
        if (var2 < 0) {
            var2 = 0;
        }

        if (var2 >= this.field_1528_m.length) {
            var2 = this.field_1528_m.length - 1;
        }

        this.field_1528_m[var2].remove(var1);
    }

    public boolean func_1007_c(int var1, int var2, int var3) {
        return var2 >= (this.field_1533_h[var3 << 4 | var1] & 255);
    }

    public TileEntity func_1002_d(int var1, int var2, int var3) {
        ChunkPosition var4 = new ChunkPosition(var1, var2, var3);
        TileEntity var5 = (TileEntity)this.field_1529_l.get(var4);
        if (var5 == null) {
            int var6 = this.func_1008_a(var1, var2, var3);
            if (!Block.field_342_q[var6]) {
                return null;
            }

            BlockContainer var7 = (BlockContainer)Block.field_345_n[var6];
            var7.func_235_e(this.field_1537_d, this.field_1531_j * 16 + var1, var2, this.field_1530_k * 16 + var3);
            var5 = (TileEntity)this.field_1529_l.get(var4);
        }

        if (var5 != null && var5.func_31006_g()) {
            this.field_1529_l.remove(var4);
            return null;
        } else {
            return var5;
        }
    }

    public void func_1001_a(TileEntity var1) {
        int var2 = var1.field_823_f - this.field_1531_j * 16;
        int var3 = var1.field_822_g;
        int var4 = var1.field_821_h - this.field_1530_k * 16;
        this.func_1005_a(var2, var3, var4, var1);
        if (this.field_1538_c) {
            this.field_1537_d.field_1049_b.add(var1);
        }

    }

    public void func_1005_a(int var1, int var2, int var3, TileEntity var4) {
        ChunkPosition var5 = new ChunkPosition(var1, var2, var3);
        var4.field_824_e = this.field_1537_d;
        var4.field_823_f = this.field_1531_j * 16 + var1;
        var4.field_822_g = var2;
        var4.field_821_h = this.field_1530_k * 16 + var3;
        if (this.func_1008_a(var1, var2, var3) != 0 && Block.field_345_n[this.func_1008_a(var1, var2, var3)] instanceof BlockContainer) {
            var4.func_31004_j();
            this.field_1529_l.put(var5, var4);
        } else {
            System.out.println("Attempted to place a tile entity where there was no entity tile!");
        }
    }

    public void func_1023_e(int var1, int var2, int var3) {
        ChunkPosition var4 = new ChunkPosition(var1, var2, var3);
        if (this.field_1538_c) {
            TileEntity var5 = (TileEntity)this.field_1529_l.remove(var4);
            if (var5 != null) {
                var5.func_31005_i();
            }
        }

    }

    public void func_995_d() {
        this.field_1538_c = true;
        this.field_1537_d.func_31054_a(this.field_1529_l.values());

        for(int var1 = 0; var1 < this.field_1528_m.length; ++var1) {
            this.field_1537_d.func_636_a(this.field_1528_m[var1]);
        }

    }

    public void func_998_e() {
        this.field_1538_c = false;
        Iterator var1 = this.field_1529_l.values().iterator();

        while(var1.hasNext()) {
            TileEntity var2 = (TileEntity)var1.next();
            var2.func_31005_i();
        }

        for(int var3 = 0; var3 < this.field_1528_m.length; ++var3) {
            this.field_1537_d.func_632_b(this.field_1528_m[var3]);
        }

    }

    public void func_1006_f() {
        this.field_1526_o = true;
    }

    public void func_994_a(Entity var1, AxisAlignedBB var2, List var3) {
        int var4 = MathHelper.func_1108_b((var2.field_1697_b - 2.0D) / 16.0D);
        int var5 = MathHelper.func_1108_b((var2.field_1702_e + 2.0D) / 16.0D);
        if (var4 < 0) {
            var4 = 0;
        }

        if (var5 >= this.field_1528_m.length) {
            var5 = this.field_1528_m.length - 1;
        }

        for(int var6 = var4; var6 <= var5; ++var6) {
            List var7 = this.field_1528_m[var6];

            for(int var8 = 0; var8 < var7.size(); ++var8) {
                Entity var9 = (Entity)var7.get(var8);
                if (var9 != var1 && var9.field_601_au.func_1178_a(var2)) {
                    var3.add(var9);
                }
            }
        }

    }

    public void func_1013_a(Class var1, AxisAlignedBB var2, List var3) {
        int var4 = MathHelper.func_1108_b((var2.field_1697_b - 2.0D) / 16.0D);
        int var5 = MathHelper.func_1108_b((var2.field_1702_e + 2.0D) / 16.0D);
        if (var4 < 0) {
            var4 = 0;
        }

        if (var5 >= this.field_1528_m.length) {
            var5 = this.field_1528_m.length - 1;
        }

        for(int var6 = var4; var6 <= var5; ++var6) {
            List var7 = this.field_1528_m[var6];

            for(int var8 = 0; var8 < var7.size(); ++var8) {
                Entity var9 = (Entity)var7.get(var8);
                if (var1.isAssignableFrom(var9.getClass()) && var9.field_601_au.func_1178_a(var2)) {
                    var3.add(var9);
                }
            }
        }

    }

    public boolean func_1012_a(boolean var1) {
        if (this.field_1525_p) {
            return false;
        } else {
            if (var1) {
                if (this.field_1523_r && this.field_1537_d.func_22139_r() != this.field_1522_s) {
                    return true;
                }
            } else if (this.field_1523_r && this.field_1537_d.func_22139_r() >= this.field_1522_s + 600L) {
                return true;
            }

            return this.field_1526_o;
        }
    }

    public int func_1004_a(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9;
        int var10;
        int var11;
        int var12;
        for(var9 = var2; var9 < var5; ++var9) {
            for(var10 = var4; var10 < var7; ++var10) {
                var11 = var9 << 11 | var10 << 7 | var3;
                var12 = var6 - var3;
                System.arraycopy(var1, var8, this.field_1539_b, var11, var12);
                var8 += var12;
            }
        }

        this.func_1018_b();

        for(var9 = var2; var9 < var5; ++var9) {
            for(var10 = var4; var10 < var7; ++var10) {
                var11 = (var9 << 11 | var10 << 7 | var3) >> 1;
                var12 = (var6 - var3) / 2;
                System.arraycopy(var1, var8, this.field_1536_e.field_1109_a, var11, var12);
                var8 += var12;
            }
        }

        for(var9 = var2; var9 < var5; ++var9) {
            for(var10 = var4; var10 < var7; ++var10) {
                var11 = (var9 << 11 | var10 << 7 | var3) >> 1;
                var12 = (var6 - var3) / 2;
                System.arraycopy(var1, var8, this.field_1534_g.field_1109_a, var11, var12);
                var8 += var12;
            }
        }

        for(var9 = var2; var9 < var5; ++var9) {
            for(var10 = var4; var10 < var7; ++var10) {
                var11 = (var9 << 11 | var10 << 7 | var3) >> 1;
                var12 = (var6 - var3) / 2;
                System.arraycopy(var1, var8, this.field_1535_f.field_1109_a, var11, var12);
                var8 += var12;
            }
        }

        return var8;
    }

    public Random func_997_a(long var1) {
        return new Random(this.field_1537_d.func_22138_q() + (long)(this.field_1531_j * this.field_1531_j * 4987142) + (long)(this.field_1531_j * 5947611) + (long)(this.field_1530_k * this.field_1530_k) * 4392871L + (long)(this.field_1530_k * 389711) ^ var1);
    }

    public boolean func_21167_h() {
        return false;
    }

    public void func_25124_i() {
        ChunkBlockMap.func_26002_a(this.field_1539_b);
    }
}
