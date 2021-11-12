package net.minecraft.src;

import java.util.Random;

public class ChunkProviderSky implements IChunkProvider {
    private Random field_28085_j;
    private NoiseGeneratorOctaves field_28084_k;
    private NoiseGeneratorOctaves field_28083_l;
    private NoiseGeneratorOctaves field_28082_m;
    private NoiseGeneratorOctaves field_28081_n;
    private NoiseGeneratorOctaves field_28080_o;
    public NoiseGeneratorOctaves field_28094_a;
    public NoiseGeneratorOctaves field_28093_b;
    public NoiseGeneratorOctaves field_28092_c;
    private World field_28079_p;
    private double[] field_28078_q;
    private double[] field_28077_r = new double[256];
    private double[] field_28076_s = new double[256];
    private double[] field_28075_t = new double[256];
    private MapGenBase field_28074_u = new MapGenCaves();
    private BiomeGenBase[] field_28073_v;
    double[] field_28091_d;
    double[] field_28090_e;
    double[] field_28089_f;
    double[] field_28088_g;
    double[] field_28087_h;
    int[][] field_28086_i = new int[32][32];
    private double[] field_28072_w;

    public ChunkProviderSky(World var1, long var2) {
        this.field_28079_p = var1;
        this.field_28085_j = new Random(var2);
        this.field_28084_k = new NoiseGeneratorOctaves(this.field_28085_j, 16);
        this.field_28083_l = new NoiseGeneratorOctaves(this.field_28085_j, 16);
        this.field_28082_m = new NoiseGeneratorOctaves(this.field_28085_j, 8);
        this.field_28081_n = new NoiseGeneratorOctaves(this.field_28085_j, 4);
        this.field_28080_o = new NoiseGeneratorOctaves(this.field_28085_j, 4);
        this.field_28094_a = new NoiseGeneratorOctaves(this.field_28085_j, 10);
        this.field_28093_b = new NoiseGeneratorOctaves(this.field_28085_j, 16);
        this.field_28092_c = new NoiseGeneratorOctaves(this.field_28085_j, 8);
    }

    public void func_28070_a(int var1, int var2, byte[] var3, BiomeGenBase[] var4, double[] var5) {
        byte var6 = 2;
        int var7 = var6 + 1;
        byte var8 = 33;
        int var9 = var6 + 1;
        this.field_28078_q = this.generateTerrain(this.field_28078_q, var1 * var6, 0, var2 * var6, var7, var8, var9);

        for(int var10 = 0; var10 < var6; ++var10) {
            for(int var11 = 0; var11 < var6; ++var11) {
                for(int var12 = 0; var12 < 32; ++var12) {
                    double var13 = 0.25D;
                    double var15 = this.field_28078_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var17 = this.field_28078_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var19 = this.field_28078_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var21 = this.field_28078_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var23 = (this.field_28078_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
                    double var25 = (this.field_28078_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
                    double var27 = (this.field_28078_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
                    double var29 = (this.field_28078_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

                    for(int var31 = 0; var31 < 4; ++var31) {
                        double var32 = 0.125D;
                        double var34 = var15;
                        double var36 = var17;
                        double var38 = (var19 - var15) * var32;
                        double var40 = (var21 - var17) * var32;

                        for(int var42 = 0; var42 < 8; ++var42) {
                            int var43 = var42 + var10 * 8 << 11 | 0 + var11 * 8 << 7 | var12 * 4 + var31;
                            short var44 = 128;
                            double var45 = 0.125D;
                            double var47 = var34;
                            double var49 = (var36 - var34) * var45;

                            for(int var51 = 0; var51 < 8; ++var51) {
                                int var52 = 0;
                                if (var47 > 0.0D) {
                                    var52 = Block.stone.blockID;
                                }

                                var3[var43] = (byte)var52;
                                var43 += var44;
                                var47 += var49;
                            }

                            var34 += var38;
                            var36 += var40;
                        }

                        var15 += var23;
                        var17 += var25;
                        var19 += var27;
                        var21 += var29;
                    }
                }
            }
        }

    }

    public void func_28069_a(int var1, int var2, byte[] var3, BiomeGenBase[] var4) {
        double var5 = 0.03125D;
        this.field_28077_r = this.field_28081_n.generateNoiseOctaves(this.field_28077_r, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var5, var5, 1.0D);
        this.field_28076_s = this.field_28081_n.generateNoiseOctaves(this.field_28076_s, (double)(var1 * 16), 109.0134D, (double)(var2 * 16), 16, 1, 16, var5, 1.0D, var5);
        this.field_28075_t = this.field_28080_o.generateNoiseOctaves(this.field_28075_t, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

        for(int var7 = 0; var7 < 16; ++var7) {
            for(int var8 = 0; var8 < 16; ++var8) {
                BiomeGenBase var9 = var4[var7 + var8 * 16];
                int var10 = (int)(this.field_28075_t[var7 + var8 * 16] / 3.0D + 3.0D + this.field_28085_j.nextDouble() * 0.25D);
                int var11 = -1;
                byte var12 = var9.topBlock;
                byte var13 = var9.fillerBlock;

                for(int var14 = 127; var14 >= 0; --var14) {
                    int var15 = (var8 * 16 + var7) * 128 + var14;
                    byte var16 = var3[var15];
                    if (var16 == 0) {
                        var11 = -1;
                    } else if (var16 == Block.stone.blockID) {
                        if (var11 == -1) {
                            if (var10 <= 0) {
                                var12 = 0;
                                var13 = (byte)Block.stone.blockID;
                            }

                            var11 = var10;
                            if (var14 >= 0) {
                                var3[var15] = var12;
                            } else {
                                var3[var15] = var13;
                            }
                        } else if (var11 > 0) {
                            --var11;
                            var3[var15] = var13;
                            if (var11 == 0 && var13 == Block.sand.blockID) {
                                var11 = this.field_28085_j.nextInt(4);
                                var13 = (byte)Block.sandStone.blockID;
                            }
                        }
                    }
                }
            }
        }

    }

    public Chunk loadChunk(int var1, int var2) {
        return this.provideChunk(var1, var2);
    }

    public Chunk provideChunk(int var1, int var2) {
        this.field_28085_j.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte['\u8000'];
        Chunk var4 = new Chunk(this.field_28079_p, var3, var1, var2);
        this.field_28073_v = this.field_28079_p.getWorldChunkManager().loadBlockGeneratorData(this.field_28073_v, var1 * 16, var2 * 16, 16, 16);
        double[] var5 = this.field_28079_p.getWorldChunkManager().temperature;
        this.func_28070_a(var1, var2, var3, this.field_28073_v, var5);
        this.func_28069_a(var1, var2, var3, this.field_28073_v);
        this.field_28074_u.func_667_a(this, this.field_28079_p, var1, var2, var3);
        var4.func_353_b();
        return var4;
    }

    private double[] generateTerrain(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (var1 == null) {
            var1 = new double[var5 * var6 * var7];
        }

        double var8 = 684.412D;
        double var10 = 684.412D;
        double[] var12 = this.field_28079_p.getWorldChunkManager().temperature;
        double[] var13 = this.field_28079_p.getWorldChunkManager().humidity;
        this.field_28088_g = this.field_28094_a.func_4103_a(this.field_28088_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.field_28087_h = this.field_28093_b.func_4103_a(this.field_28087_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        var8 *= 2.0D;
        this.field_28091_d = this.field_28082_m.generateNoiseOctaves(this.field_28091_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
        this.field_28090_e = this.field_28084_k.generateNoiseOctaves(this.field_28090_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        this.field_28089_f = this.field_28083_l.generateNoiseOctaves(this.field_28089_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
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
                double var27 = (this.field_28088_g[var15] + 256.0D) / 512.0D;
                var27 *= var25;
                if (var27 > 1.0D) {
                    var27 = 1.0D;
                }

                double var29 = this.field_28087_h[var15] / 8000.0D;
                if (var29 < 0.0D) {
                    var29 = -var29 * 0.3D;
                }

                var29 = var29 * 3.0D - 2.0D;
                if (var29 > 1.0D) {
                    var29 = 1.0D;
                }

                var29 /= 8.0D;
                var29 = 0.0D;
                if (var27 < 0.0D) {
                    var27 = 0.0D;
                }

                var27 += 0.5D;
                var29 = var29 * (double)var6 / 16.0D;
                ++var15;
                double var31 = (double)var6 / 2.0D;

                for(int var33 = 0; var33 < var6; ++var33) {
                    double var34 = 0.0D;
                    double var36 = ((double)var33 - var31) * 8.0D / var27;
                    if (var36 < 0.0D) {
                        var36 *= -1.0D;
                    }

                    double var38 = this.field_28090_e[var14] / 512.0D;
                    double var40 = this.field_28089_f[var14] / 512.0D;
                    double var42 = (this.field_28091_d[var14] / 10.0D + 1.0D) / 2.0D;
                    if (var42 < 0.0D) {
                        var34 = var38;
                    } else if (var42 > 1.0D) {
                        var34 = var40;
                    } else {
                        var34 = var38 + (var40 - var38) * var42;
                    }

                    var34 -= 8.0D;
                    byte var44 = 32;
                    double var45;
                    if (var33 > var6 - var44) {
                        var45 = (double)((float)(var33 - (var6 - var44)) / ((float)var44 - 1.0F));
                        var34 = var34 * (1.0D - var45) + -30.0D * var45;
                    }

                    var44 = 8;
                    if (var33 < var44) {
                        var45 = (double)((float)(var44 - var33) / ((float)var44 - 1.0F));
                        var34 = var34 * (1.0D - var45) + -30.0D * var45;
                    }

                    var1[var14] = var34;
                    ++var14;
                }
            }
        }

        return var1;
    }

    public boolean chunkExists(int var1, int var2) {
        return true;
    }

    public void populate(IChunkProvider var1, int var2, int var3) {
        BlockSand.fallInstantly = true;
        int var4 = var2 * 16;
        int var5 = var3 * 16;
        BiomeGenBase var6 = this.field_28079_p.getWorldChunkManager().getBiomeGenAt(var4 + 16, var5 + 16);
        this.field_28085_j.setSeed(this.field_28079_p.getRandomSeed());
        long var7 = this.field_28085_j.nextLong() / 2L * 2L + 1L;
        long var9 = this.field_28085_j.nextLong() / 2L * 2L + 1L;
        this.field_28085_j.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.field_28079_p.getRandomSeed());
        double var11 = 0.25D;
        int var13;
        int var14;
        int var15;
        if (this.field_28085_j.nextInt(4) == 0) {
            var13 = var4 + this.field_28085_j.nextInt(16) + 8;
            var14 = this.field_28085_j.nextInt(128);
            var15 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenLakes(Block.waterStill.blockID)).generate(this.field_28079_p, this.field_28085_j, var13, var14, var15);
        }

        if (this.field_28085_j.nextInt(8) == 0) {
            var13 = var4 + this.field_28085_j.nextInt(16) + 8;
            var14 = this.field_28085_j.nextInt(this.field_28085_j.nextInt(120) + 8);
            var15 = var5 + this.field_28085_j.nextInt(16) + 8;
            if (var14 < 64 || this.field_28085_j.nextInt(10) == 0) {
                (new WorldGenLakes(Block.lavaStill.blockID)).generate(this.field_28079_p, this.field_28085_j, var13, var14, var15);
            }
        }

        int var16;
        for(var13 = 0; var13 < 8; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16) + 8;
            var15 = this.field_28085_j.nextInt(128);
            var16 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenDungeons()).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 10; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(128);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenClay(32)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(128);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.dirt.blockID, 32)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 10; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(128);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.gravel.blockID, 32)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(128);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.oreCoal.blockID, 16)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(64);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.oreIron.blockID, 8)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 2; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(32);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.oreGold.blockID, 8)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 8; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(16);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.oreRedstone.blockID, 7)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 1; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(16);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.oreDiamond.blockID, 7)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        for(var13 = 0; var13 < 1; ++var13) {
            var14 = var4 + this.field_28085_j.nextInt(16);
            var15 = this.field_28085_j.nextInt(16) + this.field_28085_j.nextInt(16);
            var16 = var5 + this.field_28085_j.nextInt(16);
            (new WorldGenMinable(Block.oreLapis.blockID, 6)).generate(this.field_28079_p, this.field_28085_j, var14, var15, var16);
        }

        var11 = 0.5D;
        var13 = (int)((this.field_28092_c.func_647_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.field_28085_j.nextDouble() * 4.0D + 4.0D) / 3.0D);
        var14 = 0;
        if (this.field_28085_j.nextInt(10) == 0) {
            ++var14;
        }

        if (var6 == BiomeGenBase.forest) {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.rainforest) {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.seasonalForest) {
            var14 += var13 + 2;
        }

        if (var6 == BiomeGenBase.taiga) {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.desert) {
            var14 -= 20;
        }

        if (var6 == BiomeGenBase.tundra) {
            var14 -= 20;
        }

        if (var6 == BiomeGenBase.plains) {
            var14 -= 20;
        }

        int var17;
        for(var15 = 0; var15 < var14; ++var15) {
            var16 = var4 + this.field_28085_j.nextInt(16) + 8;
            var17 = var5 + this.field_28085_j.nextInt(16) + 8;
            WorldGenerator var18 = var6.getRandomWorldGenForTrees(this.field_28085_j);
            var18.func_420_a(1.0D, 1.0D, 1.0D);
            var18.generate(this.field_28079_p, this.field_28085_j, var16, this.field_28079_p.getHeightValue(var16, var17), var17);
        }

        int var23;
        for(var15 = 0; var15 < 2; ++var15) {
            var16 = var4 + this.field_28085_j.nextInt(16) + 8;
            var17 = this.field_28085_j.nextInt(128);
            var23 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.plantYellow.blockID)).generate(this.field_28079_p, this.field_28085_j, var16, var17, var23);
        }

        if (this.field_28085_j.nextInt(2) == 0) {
            var15 = var4 + this.field_28085_j.nextInt(16) + 8;
            var16 = this.field_28085_j.nextInt(128);
            var17 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.plantRed.blockID)).generate(this.field_28079_p, this.field_28085_j, var15, var16, var17);
        }

        if (this.field_28085_j.nextInt(4) == 0) {
            var15 = var4 + this.field_28085_j.nextInt(16) + 8;
            var16 = this.field_28085_j.nextInt(128);
            var17 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.field_28079_p, this.field_28085_j, var15, var16, var17);
        }

        if (this.field_28085_j.nextInt(8) == 0) {
            var15 = var4 + this.field_28085_j.nextInt(16) + 8;
            var16 = this.field_28085_j.nextInt(128);
            var17 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.field_28079_p, this.field_28085_j, var15, var16, var17);
        }

        for(var15 = 0; var15 < 10; ++var15) {
            var16 = var4 + this.field_28085_j.nextInt(16) + 8;
            var17 = this.field_28085_j.nextInt(128);
            var23 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenReed()).generate(this.field_28079_p, this.field_28085_j, var16, var17, var23);
        }

        if (this.field_28085_j.nextInt(32) == 0) {
            var15 = var4 + this.field_28085_j.nextInt(16) + 8;
            var16 = this.field_28085_j.nextInt(128);
            var17 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(this.field_28079_p, this.field_28085_j, var15, var16, var17);
        }

        var15 = 0;
        if (var6 == BiomeGenBase.desert) {
            var15 += 10;
        }

        int var19;
        for(var16 = 0; var16 < var15; ++var16) {
            var17 = var4 + this.field_28085_j.nextInt(16) + 8;
            var23 = this.field_28085_j.nextInt(128);
            var19 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenCactus()).generate(this.field_28079_p, this.field_28085_j, var17, var23, var19);
        }

        for(var16 = 0; var16 < 50; ++var16) {
            var17 = var4 + this.field_28085_j.nextInt(16) + 8;
            var23 = this.field_28085_j.nextInt(this.field_28085_j.nextInt(120) + 8);
            var19 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.field_28079_p, this.field_28085_j, var17, var23, var19);
        }

        for(var16 = 0; var16 < 20; ++var16) {
            var17 = var4 + this.field_28085_j.nextInt(16) + 8;
            var23 = this.field_28085_j.nextInt(this.field_28085_j.nextInt(this.field_28085_j.nextInt(112) + 8) + 8);
            var19 = var5 + this.field_28085_j.nextInt(16) + 8;
            (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.field_28079_p, this.field_28085_j, var17, var23, var19);
        }

        this.field_28072_w = this.field_28079_p.getWorldChunkManager().getTemperatures(this.field_28072_w, var4 + 8, var5 + 8, 16, 16);

        for(var16 = var4 + 8; var16 < var4 + 8 + 16; ++var16) {
            for(var17 = var5 + 8; var17 < var5 + 8 + 16; ++var17) {
                var23 = var16 - (var4 + 8);
                var19 = var17 - (var5 + 8);
                int var20 = this.field_28079_p.getTopSolidOrLiquidBlock(var16, var17);
                double var21 = this.field_28072_w[var23 * 16 + var19] - (double)(var20 - 64) / 64.0D * 0.3D;
                if (var21 < 0.5D && var20 > 0 && var20 < 128 && this.field_28079_p.isAirBlock(var16, var20, var17) && this.field_28079_p.getBlockMaterial(var16, var20 - 1, var17).getIsSolid() && this.field_28079_p.getBlockMaterial(var16, var20 - 1, var17) != Material.ice) {
                    this.field_28079_p.setBlockWithNotify(var16, var20, var17, Block.snow.blockID);
                }
            }
        }

        BlockSand.fallInstantly = false;
    }

    public boolean saveChunks(boolean var1, IProgressUpdate var2) {
        return true;
    }

    public boolean func_361_a() {
        return false;
    }

    public boolean func_364_b() {
        return true;
    }
}
