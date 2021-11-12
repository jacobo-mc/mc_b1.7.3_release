package net.minecraft.src;

import java.util.Random;

public class ChunkProviderGenerate implements IChunkProvider {
    private Random field_913_j;
    private NoiseGeneratorOctaves field_912_k;
    private NoiseGeneratorOctaves field_911_l;
    private NoiseGeneratorOctaves field_910_m;
    private NoiseGeneratorOctaves field_909_n;
    private NoiseGeneratorOctaves field_908_o;
    public NoiseGeneratorOctaves field_922_a;
    public NoiseGeneratorOctaves field_921_b;
    public NoiseGeneratorOctaves field_920_c;
    private World field_907_p;
    private double[] field_4180_q;
    private double[] field_905_r = new double[256];
    private double[] field_904_s = new double[256];
    private double[] field_903_t = new double[256];
    private MapGenBase field_902_u = new MapGenCaves();
    private BiomeGenBase[] field_4179_v;
    double[] field_4185_d;
    double[] field_4184_e;
    double[] field_4183_f;
    double[] field_4182_g;
    double[] field_4181_h;
    int[][] field_914_i = new int[32][32];
    private double[] field_4178_w;

    public ChunkProviderGenerate(World var1, long var2) {
        this.field_907_p = var1;
        this.field_913_j = new Random(var2);
        this.field_912_k = new NoiseGeneratorOctaves(this.field_913_j, 16);
        this.field_911_l = new NoiseGeneratorOctaves(this.field_913_j, 16);
        this.field_910_m = new NoiseGeneratorOctaves(this.field_913_j, 8);
        this.field_909_n = new NoiseGeneratorOctaves(this.field_913_j, 4);
        this.field_908_o = new NoiseGeneratorOctaves(this.field_913_j, 4);
        this.field_922_a = new NoiseGeneratorOctaves(this.field_913_j, 10);
        this.field_921_b = new NoiseGeneratorOctaves(this.field_913_j, 16);
        this.field_920_c = new NoiseGeneratorOctaves(this.field_913_j, 8);
    }

    public void func_4060_a(int var1, int var2, byte[] var3, BiomeGenBase[] var4, double[] var5) {
        byte var6 = 4;
        byte var7 = 64;
        int var8 = var6 + 1;
        byte var9 = 17;
        int var10 = var6 + 1;
        this.field_4180_q = this.func_4061_a(this.field_4180_q, var1 * var6, 0, var2 * var6, var8, var9, var10);

        for(int var11 = 0; var11 < var6; ++var11) {
            for(int var12 = 0; var12 < var6; ++var12) {
                for(int var13 = 0; var13 < 16; ++var13) {
                    double var14 = 0.125D;
                    double var16 = this.field_4180_q[((var11 + 0) * var10 + var12 + 0) * var9 + var13 + 0];
                    double var18 = this.field_4180_q[((var11 + 0) * var10 + var12 + 1) * var9 + var13 + 0];
                    double var20 = this.field_4180_q[((var11 + 1) * var10 + var12 + 0) * var9 + var13 + 0];
                    double var22 = this.field_4180_q[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 0];
                    double var24 = (this.field_4180_q[((var11 + 0) * var10 + var12 + 0) * var9 + var13 + 1] - var16) * var14;
                    double var26 = (this.field_4180_q[((var11 + 0) * var10 + var12 + 1) * var9 + var13 + 1] - var18) * var14;
                    double var28 = (this.field_4180_q[((var11 + 1) * var10 + var12 + 0) * var9 + var13 + 1] - var20) * var14;
                    double var30 = (this.field_4180_q[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 1] - var22) * var14;

                    for(int var32 = 0; var32 < 8; ++var32) {
                        double var33 = 0.25D;
                        double var35 = var16;
                        double var37 = var18;
                        double var39 = (var20 - var16) * var33;
                        double var41 = (var22 - var18) * var33;

                        for(int var43 = 0; var43 < 4; ++var43) {
                            int var44 = var43 + var11 * 4 << 11 | 0 + var12 * 4 << 7 | var13 * 8 + var32;
                            short var45 = 128;
                            double var46 = 0.25D;
                            double var48 = var35;
                            double var50 = (var37 - var35) * var46;

                            for(int var52 = 0; var52 < 4; ++var52) {
                                double var53 = var5[(var11 * 4 + var43) * 16 + var12 * 4 + var52];
                                int var55 = 0;
                                if (var13 * 8 + var32 < var7) {
                                    if (var53 < 0.5D && var13 * 8 + var32 >= var7 - 1) {
                                        var55 = Block.field_4063_aU.field_376_bc;
                                    } else {
                                        var55 = Block.field_399_C.field_376_bc;
                                    }
                                }

                                if (var48 > 0.0D) {
                                    var55 = Block.field_338_u.field_376_bc;
                                }

                                var3[var44] = (byte)var55;
                                var44 += var45;
                                var48 += var50;
                            }

                            var35 += var39;
                            var37 += var41;
                        }

                        var16 += var24;
                        var18 += var26;
                        var20 += var28;
                        var22 += var30;
                    }
                }
            }
        }

    }

    public void func_4062_a(int var1, int var2, byte[] var3, BiomeGenBase[] var4) {
        byte var5 = 64;
        double var6 = 0.03125D;
        this.field_905_r = this.field_909_n.func_807_a(this.field_905_r, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6, var6, 1.0D);
        this.field_904_s = this.field_909_n.func_807_a(this.field_904_s, (double)(var1 * 16), 109.0134D, (double)(var2 * 16), 16, 1, 16, var6, 1.0D, var6);
        this.field_903_t = this.field_908_o.func_807_a(this.field_903_t, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

        for(int var8 = 0; var8 < 16; ++var8) {
            for(int var9 = 0; var9 < 16; ++var9) {
                BiomeGenBase var10 = var4[var8 + var9 * 16];
                boolean var11 = this.field_905_r[var8 + var9 * 16] + this.field_913_j.nextDouble() * 0.2D > 0.0D;
                boolean var12 = this.field_904_s[var8 + var9 * 16] + this.field_913_j.nextDouble() * 0.2D > 3.0D;
                int var13 = (int)(this.field_903_t[var8 + var9 * 16] / 3.0D + 3.0D + this.field_913_j.nextDouble() * 0.25D);
                int var14 = -1;
                byte var15 = var10.field_4242_o;
                byte var16 = var10.field_4241_p;

                for(int var17 = 127; var17 >= 0; --var17) {
                    int var18 = (var9 * 16 + var8) * 128 + var17;
                    if (var17 <= 0 + this.field_913_j.nextInt(5)) {
                        var3[var18] = (byte)Block.field_403_A.field_376_bc;
                    } else {
                        byte var19 = var3[var18];
                        if (var19 == 0) {
                            var14 = -1;
                        } else if (var19 == Block.field_338_u.field_376_bc) {
                            if (var14 == -1) {
                                if (var13 <= 0) {
                                    var15 = 0;
                                    var16 = (byte)Block.field_338_u.field_376_bc;
                                } else if (var17 >= var5 - 4 && var17 <= var5 + 1) {
                                    var15 = var10.field_4242_o;
                                    var16 = var10.field_4241_p;
                                    if (var12) {
                                        var15 = 0;
                                    }

                                    if (var12) {
                                        var16 = (byte)Block.field_392_G.field_376_bc;
                                    }

                                    if (var11) {
                                        var15 = (byte)Block.field_393_F.field_376_bc;
                                    }

                                    if (var11) {
                                        var16 = (byte)Block.field_393_F.field_376_bc;
                                    }
                                }

                                if (var17 < var5 && var15 == 0) {
                                    var15 = (byte)Block.field_399_C.field_376_bc;
                                }

                                var14 = var13;
                                if (var17 >= var5 - 1) {
                                    var3[var18] = var15;
                                } else {
                                    var3[var18] = var16;
                                }
                            } else if (var14 > 0) {
                                --var14;
                                var3[var18] = var16;
                                if (var14 == 0 && var16 == Block.field_393_F.field_376_bc) {
                                    var14 = this.field_913_j.nextInt(4);
                                    var16 = (byte)Block.field_9264_Q.field_376_bc;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public Chunk func_538_d(int var1, int var2) {
        return this.func_533_b(var1, var2);
    }

    public Chunk func_533_b(int var1, int var2) {
        this.field_913_j.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte['\u8000'];
        Chunk var4 = new Chunk(this.field_907_p, var3, var1, var2);
        this.field_4179_v = this.field_907_p.func_4075_a().func_4070_a(this.field_4179_v, var1 * 16, var2 * 16, 16, 16);
        double[] var5 = this.field_907_p.func_4075_a().field_4198_a;
        this.func_4060_a(var1, var2, var3, this.field_4179_v, var5);
        this.func_4062_a(var1, var2, var3, this.field_4179_v);
        this.field_902_u.func_867_a(this, this.field_907_p, var1, var2, var3);
        var4.func_1024_c();
        return var4;
    }

    private double[] func_4061_a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (var1 == null) {
            var1 = new double[var5 * var6 * var7];
        }

        double var8 = 684.412D;
        double var10 = 684.412D;
        double[] var12 = this.field_907_p.func_4075_a().field_4198_a;
        double[] var13 = this.field_907_p.func_4075_a().field_4197_b;
        this.field_4182_g = this.field_922_a.func_4109_a(this.field_4182_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.field_4181_h = this.field_921_b.func_4109_a(this.field_4181_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        this.field_4185_d = this.field_910_m.func_807_a(this.field_4185_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
        this.field_4184_e = this.field_912_k.func_807_a(this.field_4184_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        this.field_4183_f = this.field_911_l.func_807_a(this.field_4183_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        int var14 = 0;
        int var15 = 0;
        int var16 = 16 / var5;

        for(int var17 = 0; var17 < var5; ++var17) {
            int var18 = var17 * var16 + var16 / 2;

            for(int var19 = 0; var19 < var7; ++var19) {
                int var20 = var19 * var16 + var16 / 2;
                double var21 = var12[var18 * 16 + var20];
                double var23 = var13[var18 * 16 + var20] * var21;
                double var25 = 1.0D - var23;
                var25 *= var25;
                var25 *= var25;
                var25 = 1.0D - var25;
                double var27 = (this.field_4182_g[var15] + 256.0D) / 512.0D;
                var27 *= var25;
                if (var27 > 1.0D) {
                    var27 = 1.0D;
                }

                double var29 = this.field_4181_h[var15] / 8000.0D;
                if (var29 < 0.0D) {
                    var29 = -var29 * 0.3D;
                }

                var29 = var29 * 3.0D - 2.0D;
                if (var29 < 0.0D) {
                    var29 /= 2.0D;
                    if (var29 < -1.0D) {
                        var29 = -1.0D;
                    }

                    var29 /= 1.4D;
                    var29 /= 2.0D;
                    var27 = 0.0D;
                } else {
                    if (var29 > 1.0D) {
                        var29 = 1.0D;
                    }

                    var29 /= 8.0D;
                }

                if (var27 < 0.0D) {
                    var27 = 0.0D;
                }

                var27 += 0.5D;
                var29 = var29 * (double)var6 / 16.0D;
                double var31 = (double)var6 / 2.0D + var29 * 4.0D;
                ++var15;

                for(int var33 = 0; var33 < var6; ++var33) {
                    double var34 = 0.0D;
                    double var36 = ((double)var33 - var31) * 12.0D / var27;
                    if (var36 < 0.0D) {
                        var36 *= 4.0D;
                    }

                    double var38 = this.field_4184_e[var14] / 512.0D;
                    double var40 = this.field_4183_f[var14] / 512.0D;
                    double var42 = (this.field_4185_d[var14] / 10.0D + 1.0D) / 2.0D;
                    if (var42 < 0.0D) {
                        var34 = var38;
                    } else if (var42 > 1.0D) {
                        var34 = var40;
                    } else {
                        var34 = var38 + (var40 - var38) * var42;
                    }

                    var34 -= var36;
                    if (var33 > var6 - 4) {
                        double var44 = (double)((float)(var33 - (var6 - 4)) / 3.0F);
                        var34 = var34 * (1.0D - var44) + -10.0D * var44;
                    }

                    var1[var14] = var34;
                    ++var14;
                }
            }
        }

        return var1;
    }

    public boolean func_537_a(int var1, int var2) {
        return true;
    }

    public void func_534_a(IChunkProvider var1, int var2, int var3) {
        BlockSand.field_466_a = true;
        int var4 = var2 * 16;
        int var5 = var3 * 16;
        BiomeGenBase var6 = this.field_907_p.func_4075_a().func_4073_a(var4 + 16, var5 + 16);
        this.field_913_j.setSeed(this.field_907_p.func_22138_q());
        long var7 = this.field_913_j.nextLong() / 2L * 2L + 1L;
        long var9 = this.field_913_j.nextLong() / 2L * 2L + 1L;
        this.field_913_j.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.field_907_p.func_22138_q());
        double var11 = 0.25D;
        int var13;
        int var14;
        int var15;
        if (this.field_913_j.nextInt(4) == 0) {
            var13 = var4 + this.field_913_j.nextInt(16) + 8;
            var14 = this.field_913_j.nextInt(128);
            var15 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenLakes(Block.field_399_C.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var13, var14, var15);
        }

        if (this.field_913_j.nextInt(8) == 0) {
            var13 = var4 + this.field_913_j.nextInt(16) + 8;
            var14 = this.field_913_j.nextInt(this.field_913_j.nextInt(120) + 8);
            var15 = var5 + this.field_913_j.nextInt(16) + 8;
            if (var14 < 64 || this.field_913_j.nextInt(10) == 0) {
                (new WorldGenLakes(Block.field_395_E.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var13, var14, var15);
            }
        }

        int var16;
        for(var13 = 0; var13 < 8; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16) + 8;
            var15 = this.field_913_j.nextInt(128);
            var16 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenDungeons()).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 10; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(128);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenClay(32)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(128);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_336_w.field_376_bc, 32)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 10; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(128);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_392_G.field_376_bc, 32)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(128);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_386_J.field_376_bc, 16)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(64);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_388_I.field_376_bc, 8)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 2; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(32);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_390_H.field_376_bc, 8)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 8; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(16);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_433_aO.field_376_bc, 7)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 1; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(16);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_391_ax.field_376_bc, 7)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 1; ++var13) {
            var14 = var4 + this.field_913_j.nextInt(16);
            var15 = this.field_913_j.nextInt(16) + this.field_913_j.nextInt(16);
            var16 = var5 + this.field_913_j.nextInt(16);
            (new WorldGenMinable(Block.field_9267_N.field_376_bc, 6)).func_516_a(this.field_907_p, this.field_913_j, var14, var15, var16);
        }

        var11 = 0.5D;
        var13 = (int)((this.field_920_c.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.field_913_j.nextDouble() * 4.0D + 4.0D) / 3.0D);
        var14 = 0;
        if (this.field_913_j.nextInt(10) == 0) {
            ++var14;
        }

        if (var6 == BiomeGenBase.field_4253_d) {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.field_4256_a) {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.field_4254_c) {
            var14 += var13 + 2;
        }

        if (var6 == BiomeGenBase.field_4250_g) {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.field_4249_h) {
            var14 -= 20;
        }

        if (var6 == BiomeGenBase.field_4246_k) {
            var14 -= 20;
        }

        if (var6 == BiomeGenBase.field_4248_i) {
            var14 -= 20;
        }

        int var17;
        for(var15 = 0; var15 < var14; ++var15) {
            var16 = var4 + this.field_913_j.nextInt(16) + 8;
            var17 = var5 + this.field_913_j.nextInt(16) + 8;
            WorldGenerator var18 = var6.func_21107_a(this.field_913_j);
            var18.func_517_a(1.0D, 1.0D, 1.0D);
            var18.func_516_a(this.field_907_p, this.field_913_j, var16, this.field_907_p.func_666_c(var16, var17), var17);
        }

        byte var27 = 0;
        if (var6 == BiomeGenBase.field_4253_d) {
            var27 = 2;
        }

        if (var6 == BiomeGenBase.field_4254_c) {
            var27 = 4;
        }

        if (var6 == BiomeGenBase.field_4250_g) {
            var27 = 2;
        }

        if (var6 == BiomeGenBase.field_4248_i) {
            var27 = 3;
        }

        int var19;
        int var25;
        for(var16 = 0; var16 < var27; ++var16) {
            var17 = var4 + this.field_913_j.nextInt(16) + 8;
            var25 = this.field_913_j.nextInt(128);
            var19 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_417_ae.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var17, var25, var19);
        }

        byte var28 = 0;
        if (var6 == BiomeGenBase.field_4253_d) {
            var28 = 2;
        }

        if (var6 == BiomeGenBase.field_4256_a) {
            var28 = 10;
        }

        if (var6 == BiomeGenBase.field_4254_c) {
            var28 = 2;
        }

        if (var6 == BiomeGenBase.field_4250_g) {
            var28 = 1;
        }

        if (var6 == BiomeGenBase.field_4248_i) {
            var28 = 10;
        }

        int var20;
        int var21;
        for(var17 = 0; var17 < var28; ++var17) {
            byte var26 = 1;
            if (var6 == BiomeGenBase.field_4256_a && this.field_913_j.nextInt(3) != 0) {
                var26 = 2;
            }

            var19 = var4 + this.field_913_j.nextInt(16) + 8;
            var20 = this.field_913_j.nextInt(128);
            var21 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenTallGrass(Block.field_9257_X.field_376_bc, var26)).func_516_a(this.field_907_p, this.field_913_j, var19, var20, var21);
        }

        var28 = 0;
        if (var6 == BiomeGenBase.field_4249_h) {
            var28 = 2;
        }

        for(var17 = 0; var17 < var28; ++var17) {
            var25 = var4 + this.field_913_j.nextInt(16) + 8;
            var19 = this.field_913_j.nextInt(128);
            var20 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.field_9256_Y.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var25, var19, var20);
        }

        if (this.field_913_j.nextInt(2) == 0) {
            var17 = var4 + this.field_913_j.nextInt(16) + 8;
            var25 = this.field_913_j.nextInt(128);
            var19 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_416_af.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var17, var25, var19);
        }

        if (this.field_913_j.nextInt(4) == 0) {
            var17 = var4 + this.field_913_j.nextInt(16) + 8;
            var25 = this.field_913_j.nextInt(128);
            var19 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_415_ag.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var17, var25, var19);
        }

        if (this.field_913_j.nextInt(8) == 0) {
            var17 = var4 + this.field_913_j.nextInt(16) + 8;
            var25 = this.field_913_j.nextInt(128);
            var19 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_414_ah.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var17, var25, var19);
        }

        for(var17 = 0; var17 < 10; ++var17) {
            var25 = var4 + this.field_913_j.nextInt(16) + 8;
            var19 = this.field_913_j.nextInt(128);
            var20 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenReed()).func_516_a(this.field_907_p, this.field_913_j, var25, var19, var20);
        }

        if (this.field_913_j.nextInt(32) == 0) {
            var17 = var4 + this.field_913_j.nextInt(16) + 8;
            var25 = this.field_913_j.nextInt(128);
            var19 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenPumpkin()).func_516_a(this.field_907_p, this.field_913_j, var17, var25, var19);
        }

        var17 = 0;
        if (var6 == BiomeGenBase.field_4249_h) {
            var17 += 10;
        }

        for(var25 = 0; var25 < var17; ++var25) {
            var19 = var4 + this.field_913_j.nextInt(16) + 8;
            var20 = this.field_913_j.nextInt(128);
            var21 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenCactus()).func_516_a(this.field_907_p, this.field_913_j, var19, var20, var21);
        }

        for(var25 = 0; var25 < 50; ++var25) {
            var19 = var4 + this.field_913_j.nextInt(16) + 8;
            var20 = this.field_913_j.nextInt(this.field_913_j.nextInt(120) + 8);
            var21 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_401_B.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var19, var20, var21);
        }

        for(var25 = 0; var25 < 20; ++var25) {
            var19 = var4 + this.field_913_j.nextInt(16) + 8;
            var20 = this.field_913_j.nextInt(this.field_913_j.nextInt(this.field_913_j.nextInt(112) + 8) + 8);
            var21 = var5 + this.field_913_j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_397_D.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var19, var20, var21);
        }

        this.field_4178_w = this.field_907_p.func_4075_a().func_4071_a(this.field_4178_w, var4 + 8, var5 + 8, 16, 16);

        for(var25 = var4 + 8; var25 < var4 + 8 + 16; ++var25) {
            for(var19 = var5 + 8; var19 < var5 + 8 + 16; ++var19) {
                var20 = var25 - (var4 + 8);
                var21 = var19 - (var5 + 8);
                int var22 = this.field_907_p.func_4083_e(var25, var19);
                double var23 = this.field_4178_w[var20 * 16 + var21] - (double)(var22 - 64) / 64.0D * 0.3D;
                if (var23 < 0.5D && var22 > 0 && var22 < 128 && this.field_907_p.func_20084_d(var25, var22, var19) && this.field_907_p.func_599_f(var25, var22 - 1, var19).func_880_c() && this.field_907_p.func_599_f(var25, var22 - 1, var19) != Material.field_1320_r) {
                    this.field_907_p.func_690_d(var25, var22, var19, Block.field_428_aT.field_376_bc);
                }
            }
        }

        BlockSand.field_466_a = false;
    }

    public boolean func_535_a(boolean var1, IProgressUpdate var2) {
        return true;
    }

    public boolean func_532_a() {
        return false;
    }

    public boolean func_536_b() {
        return true;
    }

    public String func_21109_c() {
        return "RandomLevelSource";
    }
}
