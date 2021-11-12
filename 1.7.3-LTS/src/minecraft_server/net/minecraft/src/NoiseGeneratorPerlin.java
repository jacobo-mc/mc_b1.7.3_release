package net.minecraft.src;

import java.util.Random;

public class NoiseGeneratorPerlin extends NoiseGenerator {
    private int[] permutations;
    public double xCoord;
    public double yCoord;
    public double zCoord;

    public NoiseGeneratorPerlin() {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random var1) {
        this.permutations = new int[512];
        this.xCoord = var1.nextDouble() * 256.0D;
        this.yCoord = var1.nextDouble() * 256.0D;
        this.zCoord = var1.nextDouble() * 256.0D;

        int var2;
        for(var2 = 0; var2 < 256; this.permutations[var2] = var2++) {
        }

        for(var2 = 0; var2 < 256; ++var2) {
            int var3 = var1.nextInt(256 - var2) + var2;
            int var4 = this.permutations[var2];
            this.permutations[var2] = this.permutations[var3];
            this.permutations[var3] = var4;
            this.permutations[var2 + 256] = this.permutations[var2];
        }

    }

    public double generateNoise(double var1, double var3, double var5) {
        double var7 = var1 + this.xCoord;
        double var9 = var3 + this.yCoord;
        double var11 = var5 + this.zCoord;
        int var13 = (int)var7;
        int var14 = (int)var9;
        int var15 = (int)var11;
        if (var7 < (double)var13) {
            --var13;
        }

        if (var9 < (double)var14) {
            --var14;
        }

        if (var11 < (double)var15) {
            --var15;
        }

        int var16 = var13 & 255;
        int var17 = var14 & 255;
        int var18 = var15 & 255;
        var7 -= (double)var13;
        var9 -= (double)var14;
        var11 -= (double)var15;
        double var19 = var7 * var7 * var7 * (var7 * (var7 * 6.0D - 15.0D) + 10.0D);
        double var21 = var9 * var9 * var9 * (var9 * (var9 * 6.0D - 15.0D) + 10.0D);
        double var23 = var11 * var11 * var11 * (var11 * (var11 * 6.0D - 15.0D) + 10.0D);
        int var25 = this.permutations[var16] + var17;
        int var26 = this.permutations[var25] + var18;
        int var27 = this.permutations[var25 + 1] + var18;
        int var28 = this.permutations[var16 + 1] + var17;
        int var29 = this.permutations[var28] + var18;
        int var30 = this.permutations[var28 + 1] + var18;
        return this.lerp(var23, this.lerp(var21, this.lerp(var19, this.grad(this.permutations[var26], var7, var9, var11), this.grad(this.permutations[var29], var7 - 1.0D, var9, var11)), this.lerp(var19, this.grad(this.permutations[var27], var7, var9 - 1.0D, var11), this.grad(this.permutations[var30], var7 - 1.0D, var9 - 1.0D, var11))), this.lerp(var21, this.lerp(var19, this.grad(this.permutations[var26 + 1], var7, var9, var11 - 1.0D), this.grad(this.permutations[var29 + 1], var7 - 1.0D, var9, var11 - 1.0D)), this.lerp(var19, this.grad(this.permutations[var27 + 1], var7, var9 - 1.0D, var11 - 1.0D), this.grad(this.permutations[var30 + 1], var7 - 1.0D, var9 - 1.0D, var11 - 1.0D))));
    }

    public final double lerp(double var1, double var3, double var5) {
        return var3 + var1 * (var5 - var3);
    }

    public final double func_4102_a(int var1, double var2, double var4) {
        int var6 = var1 & 15;
        double var7 = (double)(1 - ((var6 & 8) >> 3)) * var2;
        double var9 = var6 < 4 ? 0.0D : (var6 != 12 && var6 != 14 ? var4 : var2);
        return ((var6 & 1) == 0 ? var7 : -var7) + ((var6 & 2) == 0 ? var9 : -var9);
    }

    public final double grad(int var1, double var2, double var4, double var6) {
        int var8 = var1 & 15;
        double var9 = var8 < 8 ? var2 : var4;
        double var11 = var8 < 4 ? var4 : (var8 != 12 && var8 != 14 ? var6 : var2);
        return ((var8 & 1) == 0 ? var9 : -var9) + ((var8 & 2) == 0 ? var11 : -var11);
    }

    public double func_642_a(double var1, double var3) {
        return this.generateNoise(var1, var3, 0.0D);
    }

    public void func_646_a(double[] var1, double var2, double var4, double var6, int var8, int var9, int var10, double var11, double var13, double var15, double var17) {
        int var10001;
        int var19;
        int var22;
        double var31;
        double var35;
        int var37;
        double var38;
        int var40;
        int var41;
        double var42;
        int var75;
        if (var9 == 1) {
            boolean var64 = false;
            boolean var65 = false;
            boolean var21 = false;
            boolean var68 = false;
            double var70 = 0.0D;
            double var73 = 0.0D;
            var75 = 0;
            double var77 = 1.0D / var17;

            for(int var30 = 0; var30 < var8; ++var30) {
                var31 = (var2 + (double)var30) * var11 + this.xCoord;
                int var78 = (int)var31;
                if (var31 < (double)var78) {
                    --var78;
                }

                int var34 = var78 & 255;
                var31 -= (double)var78;
                var35 = var31 * var31 * var31 * (var31 * (var31 * 6.0D - 15.0D) + 10.0D);

                for(var37 = 0; var37 < var10; ++var37) {
                    var38 = (var6 + (double)var37) * var15 + this.zCoord;
                    var40 = (int)var38;
                    if (var38 < (double)var40) {
                        --var40;
                    }

                    var41 = var40 & 255;
                    var38 -= (double)var40;
                    var42 = var38 * var38 * var38 * (var38 * (var38 * 6.0D - 15.0D) + 10.0D);
                    var19 = this.permutations[var34] + 0;
                    int var66 = this.permutations[var19] + var41;
                    int var67 = this.permutations[var34 + 1] + 0;
                    var22 = this.permutations[var67] + var41;
                    var70 = this.lerp(var35, this.func_4102_a(this.permutations[var66], var31, var38), this.grad(this.permutations[var22], var31 - 1.0D, 0.0D, var38));
                    var73 = this.lerp(var35, this.grad(this.permutations[var66 + 1], var31, 0.0D, var38 - 1.0D), this.grad(this.permutations[var22 + 1], var31 - 1.0D, 0.0D, var38 - 1.0D));
                    double var79 = this.lerp(var42, var70, var73);
                    var10001 = var75++;
                    var1[var10001] += var79 * var77;
                }
            }

        } else {
            var19 = 0;
            double var20 = 1.0D / var17;
            var22 = -1;
            boolean var23 = false;
            boolean var24 = false;
            boolean var25 = false;
            boolean var26 = false;
            boolean var27 = false;
            boolean var28 = false;
            double var29 = 0.0D;
            var31 = 0.0D;
            double var33 = 0.0D;
            var35 = 0.0D;

            for(var37 = 0; var37 < var8; ++var37) {
                var38 = (var2 + (double)var37) * var11 + this.xCoord;
                var40 = (int)var38;
                if (var38 < (double)var40) {
                    --var40;
                }

                var41 = var40 & 255;
                var38 -= (double)var40;
                var42 = var38 * var38 * var38 * (var38 * (var38 * 6.0D - 15.0D) + 10.0D);

                for(int var44 = 0; var44 < var10; ++var44) {
                    double var45 = (var6 + (double)var44) * var15 + this.zCoord;
                    int var47 = (int)var45;
                    if (var45 < (double)var47) {
                        --var47;
                    }

                    int var48 = var47 & 255;
                    var45 -= (double)var47;
                    double var49 = var45 * var45 * var45 * (var45 * (var45 * 6.0D - 15.0D) + 10.0D);

                    for(int var51 = 0; var51 < var9; ++var51) {
                        double var52 = (var4 + (double)var51) * var13 + this.yCoord;
                        int var54 = (int)var52;
                        if (var52 < (double)var54) {
                            --var54;
                        }

                        int var55 = var54 & 255;
                        var52 -= (double)var54;
                        double var56 = var52 * var52 * var52 * (var52 * (var52 * 6.0D - 15.0D) + 10.0D);
                        if (var51 == 0 || var55 != var22) {
                            var22 = var55;
                            int var69 = this.permutations[var41] + var55;
                            int var71 = this.permutations[var69] + var48;
                            int var72 = this.permutations[var69 + 1] + var48;
                            int var74 = this.permutations[var41 + 1] + var55;
                            var75 = this.permutations[var74] + var48;
                            int var76 = this.permutations[var74 + 1] + var48;
                            var29 = this.lerp(var42, this.grad(this.permutations[var71], var38, var52, var45), this.grad(this.permutations[var75], var38 - 1.0D, var52, var45));
                            var31 = this.lerp(var42, this.grad(this.permutations[var72], var38, var52 - 1.0D, var45), this.grad(this.permutations[var76], var38 - 1.0D, var52 - 1.0D, var45));
                            var33 = this.lerp(var42, this.grad(this.permutations[var71 + 1], var38, var52, var45 - 1.0D), this.grad(this.permutations[var75 + 1], var38 - 1.0D, var52, var45 - 1.0D));
                            var35 = this.lerp(var42, this.grad(this.permutations[var72 + 1], var38, var52 - 1.0D, var45 - 1.0D), this.grad(this.permutations[var76 + 1], var38 - 1.0D, var52 - 1.0D, var45 - 1.0D));
                        }

                        double var58 = this.lerp(var56, var29, var31);
                        double var60 = this.lerp(var56, var33, var35);
                        double var62 = this.lerp(var49, var58, var60);
                        var10001 = var19++;
                        var1[var10001] += var62 * var20;
                    }
                }
            }

        }
    }
}
