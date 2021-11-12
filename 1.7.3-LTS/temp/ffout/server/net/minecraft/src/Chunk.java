package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Chunk {
    public static boolean field_694_a;
    public byte[] field_693_b;
    public boolean field_692_c;
    public World field_691_d;
    public NibbleArray field_690_e;
    public NibbleArray field_689_f;
    public NibbleArray field_688_g;
    public byte[] field_687_h;
    public int field_686_i;
    public final int field_685_j;
    public final int field_684_k;
    public Map field_683_l;
    public List[] field_682_m;
    public boolean field_681_n;
    public boolean field_680_o;
    public boolean field_679_p;
    public boolean field_677_r;
    public long field_676_s;

    public Chunk(World var1, int var2, int var3) {
        this.field_683_l = new HashMap();
        this.field_682_m = new List[8];
        this.field_681_n = false;
        this.field_680_o = false;
        this.field_677_r = false;
        this.field_676_s = 0L;
        this.field_691_d = var1;
        this.field_685_j = var2;
        this.field_684_k = var3;
        this.field_687_h = new byte[256];

        for(int var4 = 0; var4 < this.field_682_m.length; ++var4) {
            this.field_682_m[var4] = new ArrayList();
        }

    }

    public Chunk(World var1, byte[] var2, int var3, int var4) {
        this(var1, var3, var4);
        this.field_693_b = var2;
        this.field_690_e = new NibbleArray(var2.length);
        this.field_689_f = new NibbleArray(var2.length);
        this.field_688_g = new NibbleArray(var2.length);
    }

    public boolean func_351_a(int var1, int var2) {
        return var1 == this.field_685_j && var2 == this.field_684_k;
    }

    public int func_337_b(int var1, int var2) {
        return this.field_687_h[var2 << 4 | var1] & 255;
    }

    public void func_348_a() {
    }

    public void func_353_b() {
        int var1 = 127;

        int var2;
        int var3;
        for(var2 = 0; var2 < 16; ++var2) {
            for(var3 = 0; var3 < 16; ++var3) {
                int var4 = 127;

                int var5;
                for(var5 = var2 << 11 | var3 << 7; var4 > 0 && Block.field_538_r[this.field_693_b[var5 + var4 - 1] & 255] == 0; --var4) {
                }

                this.field_687_h[var3 << 4 | var2] = (byte)var4;
                if (var4 < var1) {
                    var1 = var4;
                }

                if (!this.field_691_d.field_4272_q.field_4306_c) {
                    int var6 = 15;
                    int var7 = 127;

                    do {
                        var6 -= Block.field_538_r[this.field_693_b[var5 + var7] & 255];
                        if (var6 > 0) {
                            this.field_689_f.func_561_a(var2, var7, var3, var6);
                        }

                        --var7;
                    } while(var7 > 0 && var6 > 0);
                }
            }
        }

        this.field_686_i = var1;

        for(var2 = 0; var2 < 16; ++var2) {
            for(var3 = 0; var3 < 16; ++var3) {
                this.func_333_c(var2, var3);
            }
        }

        this.field_680_o = true;
    }

    public void func_4053_c() {
    }

    private void func_333_c(int var1, int var2) {
        int var3 = this.func_337_b(var1, var2);
        int var4 = this.field_685_j * 16 + var1;
        int var5 = this.field_684_k * 16 + var2;
        this.func_355_f(var4 - 1, var5, var3);
        this.func_355_f(var4 + 1, var5, var3);
        this.func_355_f(var4, var5 - 1, var3);
        this.func_355_f(var4, var5 + 1, var3);
    }

    private void func_355_f(int var1, int var2, int var3) {
        int var4 = this.field_691_d.func_488_c(var1, var2);
        if (var4 > var3) {
            this.field_691_d.func_483_a(EnumSkyBlock.Sky, var1, var3, var2, var1, var4, var2);
            this.field_680_o = true;
        } else if (var4 < var3) {
            this.field_691_d.func_483_a(EnumSkyBlock.Sky, var1, var4, var2, var1, var3, var2);
            this.field_680_o = true;
        }

    }

    private void func_339_g(int var1, int var2, int var3) {
        int var4 = this.field_687_h[var3 << 4 | var1] & 255;
        int var5 = var4;
        if (var2 > var4) {
            var5 = var2;
        }

        for(int var6 = var1 << 11 | var3 << 7; var5 > 0 && Block.field_538_r[this.field_693_b[var6 + var5 - 1] & 255] == 0; --var5) {
        }

        if (var5 != var4) {
            this.field_691_d.func_498_f(var1, var3, var5, var4);
            this.field_687_h[var3 << 4 | var1] = (byte)var5;
            int var7;
            int var8;
            int var9;
            if (var5 < this.field_686_i) {
                this.field_686_i = var5;
            } else {
                var7 = 127;

                for(var8 = 0; var8 < 16; ++var8) {
                    for(var9 = 0; var9 < 16; ++var9) {
                        if ((this.field_687_h[var9 << 4 | var8] & 255) < var7) {
                            var7 = this.field_687_h[var9 << 4 | var8] & 255;
                        }
                    }
                }

                this.field_686_i = var7;
            }

            var7 = this.field_685_j * 16 + var1;
            var8 = this.field_684_k * 16 + var3;
            if (var5 < var4) {
                for(var9 = var5; var9 < var4; ++var9) {
                    this.field_689_f.func_561_a(var1, var9, var3, 15);
                }
            } else {
                this.field_691_d.func_483_a(EnumSkyBlock.Sky, var7, var4, var8, var7, var5, var8);

                for(var9 = var4; var9 < var5; ++var9) {
                    this.field_689_f.func_561_a(var1, var9, var3, 0);
                }
            }

            var9 = 15;

            int var10;
            for(var10 = var5; var5 > 0 && var9 > 0; this.field_689_f.func_561_a(var1, var5, var3, var9)) {
                --var5;
                int var11 = Block.field_538_r[this.func_344_a(var1, var5, var3)];
                if (var11 == 0) {
                    var11 = 1;
                }

                var9 -= var11;
                if (var9 < 0) {
                    var9 = 0;
                }
            }

            while(var5 > 0 && Block.field_538_r[this.func_344_a(var1, var5 - 1, var3)] == 0) {
                --var5;
            }

            if (var5 != var10) {
                this.field_691_d.func_483_a(EnumSkyBlock.Sky, var7 - 1, var5, var8 - 1, var7 + 1, var10, var8 + 1);
            }

            this.field_680_o = true;
        }
    }

    public int func_344_a(int var1, int var2, int var3) {
        return this.field_693_b[var1 << 11 | var3 << 7 | var2] & 255;
    }

    public boolean func_346_a(int var1, int var2, int var3, int var4, int var5) {
        byte var6 = (byte)var4;
        int var7 = this.field_687_h[var3 << 4 | var1] & 255;
        int var8 = this.field_693_b[var1 << 11 | var3 << 7 | var2] & 255;
        if (var8 == var4 && this.field_690_e.func_562_a(var1, var2, var3) == var5) {
            return false;
        } else {
            int var9 = this.field_685_j * 16 + var1;
            int var10 = this.field_684_k * 16 + var3;
            this.field_693_b[var1 << 11 | var3 << 7 | var2] = (byte)(var6 & 255);
            if (var8 != 0 && !this.field_691_d.field_792_x) {
                Block.field_542_n[var8].func_242_b(this.field_691_d, var9, var2, var10);
            }

            this.field_690_e.func_561_a(var1, var2, var3, var5);
            if (!this.field_691_d.field_4272_q.field_4306_c) {
                if (Block.field_538_r[var6 & 255] != 0) {
                    if (var2 >= var7) {
                        this.func_339_g(var1, var2 + 1, var3);
                    }
                } else if (var2 == var7 - 1) {
                    this.func_339_g(var1, var2, var3);
                }

                this.field_691_d.func_483_a(EnumSkyBlock.Sky, var9, var2, var10, var9, var2, var10);
            }

            this.field_691_d.func_483_a(EnumSkyBlock.Block, var9, var2, var10, var9, var2, var10);
            this.func_333_c(var1, var3);
            this.field_690_e.func_561_a(var1, var2, var3, var5);
            if (var4 != 0) {
                Block.field_542_n[var4].func_250_e(this.field_691_d, var9, var2, var10);
            }

            this.field_680_o = true;
            return true;
        }
    }

    public boolean func_357_a(int var1, int var2, int var3, int var4) {
        byte var5 = (byte)var4;
        int var6 = this.field_687_h[var3 << 4 | var1] & 255;
        int var7 = this.field_693_b[var1 << 11 | var3 << 7 | var2] & 255;
        if (var7 == var4) {
            return false;
        } else {
            int var8 = this.field_685_j * 16 + var1;
            int var9 = this.field_684_k * 16 + var3;
            this.field_693_b[var1 << 11 | var3 << 7 | var2] = (byte)(var5 & 255);
            if (var7 != 0) {
                Block.field_542_n[var7].func_242_b(this.field_691_d, var8, var2, var9);
            }

            this.field_690_e.func_561_a(var1, var2, var3, 0);
            if (Block.field_538_r[var5 & 255] != 0) {
                if (var2 >= var6) {
                    this.func_339_g(var1, var2 + 1, var3);
                }
            } else if (var2 == var6 - 1) {
                this.func_339_g(var1, var2, var3);
            }

            this.field_691_d.func_483_a(EnumSkyBlock.Sky, var8, var2, var9, var8, var2, var9);
            this.field_691_d.func_483_a(EnumSkyBlock.Block, var8, var2, var9, var8, var2, var9);
            this.func_333_c(var1, var3);
            if (var4 != 0 && !this.field_691_d.field_792_x) {
                Block.field_542_n[var4].func_250_e(this.field_691_d, var8, var2, var9);
            }

            this.field_680_o = true;
            return true;
        }
    }

    public int func_356_b(int var1, int var2, int var3) {
        return this.field_690_e.func_562_a(var1, var2, var3);
    }

    public void func_345_b(int var1, int var2, int var3, int var4) {
        this.field_680_o = true;
        this.field_690_e.func_561_a(var1, var2, var3, var4);
    }

    public int func_341_a(EnumSkyBlock var1, int var2, int var3, int var4) {
        if (var1 == EnumSkyBlock.Sky) {
            return this.field_689_f.func_562_a(var2, var3, var4);
        } else {
            return var1 == EnumSkyBlock.Block ? this.field_688_g.func_562_a(var2, var3, var4) : 0;
        }
    }

    public void func_330_a(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
        this.field_680_o = true;
        if (var1 == EnumSkyBlock.Sky) {
            this.field_689_f.func_561_a(var2, var3, var4, var5);
        } else {
            if (var1 != EnumSkyBlock.Block) {
                return;
            }

            this.field_688_g.func_561_a(var2, var3, var4, var5);
        }

    }

    public int func_354_c(int var1, int var2, int var3, int var4) {
        int var5 = this.field_689_f.func_562_a(var1, var2, var3);
        if (var5 > 0) {
            field_694_a = true;
        }

        var5 -= var4;
        int var6 = this.field_688_g.func_562_a(var1, var2, var3);
        if (var6 > var5) {
            var5 = var6;
        }

        return var5;
    }

    public void func_335_a(Entity var1) {
        this.field_677_r = true;
        int var2 = MathHelper.func_584_b(var1.field_322_l / 16.0D);
        int var3 = MathHelper.func_584_b(var1.field_320_n / 16.0D);
        if (var2 != this.field_685_j || var3 != this.field_684_k) {
            System.out.println("Wrong location! " + var1);
            Thread.dumpStack();
        }

        int var4 = MathHelper.func_584_b(var1.field_321_m / 16.0D);
        if (var4 < 0) {
            var4 = 0;
        }

        if (var4 >= this.field_682_m.length) {
            var4 = this.field_682_m.length - 1;
        }

        var1.field_276_Z = true;
        var1.field_307_aa = this.field_685_j;
        var1.field_305_ab = var4;
        var1.field_303_ac = this.field_684_k;
        this.field_682_m[var4].add(var1);
    }

    public void func_350_b(Entity var1) {
        this.func_332_a(var1, var1.field_305_ab);
    }

    public void func_332_a(Entity var1, int var2) {
        if (var2 < 0) {
            var2 = 0;
        }

        if (var2 >= this.field_682_m.length) {
            var2 = this.field_682_m.length - 1;
        }

        this.field_682_m[var2].remove(var1);
    }

    public boolean func_343_c(int var1, int var2, int var3) {
        return var2 >= (this.field_687_h[var3 << 4 | var1] & 255);
    }

    public TileEntity func_338_d(int var1, int var2, int var3) {
        ChunkPosition var4 = new ChunkPosition(var1, var2, var3);
        TileEntity var5 = (TileEntity)this.field_683_l.get(var4);
        if (var5 == null) {
            int var6 = this.func_344_a(var1, var2, var3);
            if (!Block.field_539_q[var6]) {
                return null;
            }

            BlockContainer var7 = (BlockContainer)Block.field_542_n[var6];
            var7.func_250_e(this.field_691_d, this.field_685_j * 16 + var1, var2, this.field_684_k * 16 + var3);
            var5 = (TileEntity)this.field_683_l.get(var4);
        }

        if (var5 != null && var5.func_31004_g()) {
            this.field_683_l.remove(var4);
            return null;
        } else {
            return var5;
        }
    }

    public void func_349_a(TileEntity var1) {
        int var2 = var1.field_478_b - this.field_685_j * 16;
        int var3 = var1.field_483_c;
        int var4 = var1.field_482_d - this.field_684_k * 16;
        this.func_352_a(var2, var3, var4, var1);
        if (this.field_692_c) {
            this.field_691_d.field_814_b.add(var1);
        }

    }

    public void func_352_a(int var1, int var2, int var3, TileEntity var4) {
        ChunkPosition var5 = new ChunkPosition(var1, var2, var3);
        var4.field_479_a = this.field_691_d;
        var4.field_478_b = this.field_685_j * 16 + var1;
        var4.field_483_c = var2;
        var4.field_482_d = this.field_684_k * 16 + var3;
        if (this.func_344_a(var1, var2, var3) != 0 && Block.field_542_n[this.func_344_a(var1, var2, var3)] instanceof BlockContainer) {
            var4.func_31002_j();
            this.field_683_l.put(var5, var4);
        } else {
            System.out.println("Attempted to place a tile entity where there was no entity tile!");
        }
    }

    public void func_359_e(int var1, int var2, int var3) {
        ChunkPosition var4 = new ChunkPosition(var1, var2, var3);
        if (this.field_692_c) {
            TileEntity var5 = (TileEntity)this.field_683_l.remove(var4);
            if (var5 != null) {
                var5.func_31003_h();
            }
        }

    }

    public void func_358_c() {
        this.field_692_c = true;
        this.field_691_d.func_31047_a(this.field_683_l.values());

        for(int var1 = 0; var1 < this.field_682_m.length; ++var1) {
            this.field_691_d.func_464_a(this.field_682_m[var1]);
        }

    }

    public void func_331_d() {
        this.field_692_c = false;
        Iterator var1 = this.field_683_l.values().iterator();

        while(var1.hasNext()) {
            TileEntity var2 = (TileEntity)var1.next();
            var2.func_31003_h();
        }

        for(int var3 = 0; var3 < this.field_682_m.length; ++var3) {
            this.field_691_d.func_461_b(this.field_682_m[var3]);
        }

    }

    public void func_336_e() {
        this.field_680_o = true;
    }

    public void func_329_a(Entity var1, AxisAlignedBB var2, List var3) {
        int var4 = MathHelper.func_584_b((var2.field_963_b - 2.0D) / 16.0D);
        int var5 = MathHelper.func_584_b((var2.field_968_e + 2.0D) / 16.0D);
        if (var4 < 0) {
            var4 = 0;
        }

        if (var5 >= this.field_682_m.length) {
            var5 = this.field_682_m.length - 1;
        }

        for(int var6 = var4; var6 <= var5; ++var6) {
            List var7 = this.field_682_m[var6];

            for(int var8 = 0; var8 < var7.size(); ++var8) {
                Entity var9 = (Entity)var7.get(var8);
                if (var9 != var1 && var9.field_312_v.func_704_a(var2)) {
                    var3.add(var9);
                }
            }
        }

    }

    public void func_342_a(Class var1, AxisAlignedBB var2, List var3) {
        int var4 = MathHelper.func_584_b((var2.field_963_b - 2.0D) / 16.0D);
        int var5 = MathHelper.func_584_b((var2.field_968_e + 2.0D) / 16.0D);
        if (var4 < 0) {
            var4 = 0;
        }

        if (var5 >= this.field_682_m.length) {
            var5 = this.field_682_m.length - 1;
        }

        for(int var6 = var4; var6 <= var5; ++var6) {
            List var7 = this.field_682_m[var6];

            for(int var8 = 0; var8 < var7.size(); ++var8) {
                Entity var9 = (Entity)var7.get(var8);
                if (var1.isAssignableFrom(var9.getClass()) && var9.field_312_v.func_704_a(var2)) {
                    var3.add(var9);
                }
            }
        }

    }

    public boolean func_347_a(boolean var1) {
        if (this.field_679_p) {
            return false;
        } else {
            if (var1) {
                if (this.field_677_r && this.field_691_d.func_22080_k() != this.field_676_s) {
                    return true;
                }
            } else if (this.field_677_r && this.field_691_d.func_22080_k() >= this.field_676_s + 600L) {
                return true;
            }

            return this.field_680_o;
        }
    }

    public int func_340_a(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var5 - var2;
        int var10 = var6 - var3;
        int var11 = var7 - var4;
        if (var9 * var10 * var11 == this.field_693_b.length) {
            System.arraycopy(this.field_693_b, 0, var1, var8, this.field_693_b.length);
            var8 += this.field_693_b.length;
            System.arraycopy(this.field_690_e.field_844_a, 0, var1, var8, this.field_690_e.field_844_a.length);
            var8 += this.field_690_e.field_844_a.length;
            System.arraycopy(this.field_688_g.field_844_a, 0, var1, var8, this.field_688_g.field_844_a.length);
            var8 += this.field_688_g.field_844_a.length;
            System.arraycopy(this.field_689_f.field_844_a, 0, var1, var8, this.field_689_f.field_844_a.length);
            var8 += this.field_689_f.field_844_a.length;
            return var8;
        } else {
            int var12;
            int var13;
            int var14;
            int var15;
            for(var12 = var2; var12 < var5; ++var12) {
                for(var13 = var4; var13 < var7; ++var13) {
                    var14 = var12 << 11 | var13 << 7 | var3;
                    var15 = var6 - var3;
                    System.arraycopy(this.field_693_b, var14, var1, var8, var15);
                    var8 += var15;
                }
            }

            for(var12 = var2; var12 < var5; ++var12) {
                for(var13 = var4; var13 < var7; ++var13) {
                    var14 = (var12 << 11 | var13 << 7 | var3) >> 1;
                    var15 = (var6 - var3) / 2;
                    System.arraycopy(this.field_690_e.field_844_a, var14, var1, var8, var15);
                    var8 += var15;
                }
            }

            for(var12 = var2; var12 < var5; ++var12) {
                for(var13 = var4; var13 < var7; ++var13) {
                    var14 = (var12 << 11 | var13 << 7 | var3) >> 1;
                    var15 = (var6 - var3) / 2;
                    System.arraycopy(this.field_688_g.field_844_a, var14, var1, var8, var15);
                    var8 += var15;
                }
            }

            for(var12 = var2; var12 < var5; ++var12) {
                for(var13 = var4; var13 < var7; ++var13) {
                    var14 = (var12 << 11 | var13 << 7 | var3) >> 1;
                    var15 = (var6 - var3) / 2;
                    System.arraycopy(this.field_689_f.field_844_a, var14, var1, var8, var15);
                    var8 += var15;
                }
            }

            return var8;
        }
    }

    public Random func_334_a(long var1) {
        return new Random(this.field_691_d.func_22079_j() + (long)(this.field_685_j * this.field_685_j * 4987142) + (long)(this.field_685_j * 5947611) + (long)(this.field_684_k * this.field_684_k) * 4392871L + (long)(this.field_684_k * 389711) ^ var1);
    }

    public boolean func_21101_g() {
        return false;
    }

    public void func_25083_h() {
        ChunkBlockMap.func_26001_a(this.field_693_b);
    }
}
