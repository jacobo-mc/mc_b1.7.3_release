package net.minecraft.src;

import java.util.Random;

public class WorldChunkManager {
    private NoiseGeneratorOctaves2 field_4255_e;
    private NoiseGeneratorOctaves2 field_4254_f;
    private NoiseGeneratorOctaves2 field_4253_g;
    public double[] field_4259_a;
    public double[] field_4258_b;
    public double[] field_4257_c;
    public BiomeGenBase[] field_4256_d;

    protected WorldChunkManager() {
    }

    public WorldChunkManager(World var1) {
        this.field_4255_e = new NoiseGeneratorOctaves2(new Random(var1.func_22079_j() * 9871L), 4);
        this.field_4254_f = new NoiseGeneratorOctaves2(new Random(var1.func_22079_j() * 39811L), 4);
        this.field_4253_g = new NoiseGeneratorOctaves2(new Random(var1.func_22079_j() * 543321L), 2);
    }

    public BiomeGenBase func_4066_a(ChunkCoordIntPair var1) {
        return this.func_4067_a(var1.field_152_a << 4, var1.field_151_b << 4);
    }

    public BiomeGenBase func_4067_a(int var1, int var2) {
        return this.func_4065_a(var1, var2, 1, 1)[0];
    }

    public BiomeGenBase[] func_4065_a(int var1, int var2, int var3, int var4) {
        this.field_4256_d = this.func_4064_a(this.field_4256_d, var1, var2, var3, var4);
        return this.field_4256_d;
    }

    public double[] func_4068_a(double[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new double[var4 * var5];
        }

        var1 = this.field_4255_e.func_4101_a(var1, (double)var2, (double)var3, var4, var5, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.field_4257_c = this.field_4253_g.func_4101_a(this.field_4257_c, (double)var2, (double)var3, var4, var5, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for(int var7 = 0; var7 < var4; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
                double var9 = this.field_4257_c[var6] * 1.1D + 0.5D;
                double var11 = 0.01D;
                double var13 = 1.0D - var11;
                double var15 = (var1[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
                var15 = 1.0D - (1.0D - var15) * (1.0D - var15);
                if (var15 < 0.0D) {
                    var15 = 0.0D;
                }

                if (var15 > 1.0D) {
                    var15 = 1.0D;
                }

                var1[var6] = var15;
                ++var6;
            }
        }

        return var1;
    }

    public BiomeGenBase[] func_4064_a(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new BiomeGenBase[var4 * var5];
        }

        this.field_4259_a = this.field_4255_e.func_4101_a(this.field_4259_a, (double)var2, (double)var3, var4, var4, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.field_4258_b = this.field_4254_f.func_4101_a(this.field_4258_b, (double)var2, (double)var3, var4, var4, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
        this.field_4257_c = this.field_4253_g.func_4101_a(this.field_4257_c, (double)var2, (double)var3, var4, var4, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for(int var7 = 0; var7 < var4; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
                double var9 = this.field_4257_c[var6] * 1.1D + 0.5D;
                double var11 = 0.01D;
                double var13 = 1.0D - var11;
                double var15 = (this.field_4259_a[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
                var11 = 0.002D;
                var13 = 1.0D - var11;
                double var17 = (this.field_4258_b[var6] * 0.15D + 0.5D) * var13 + var9 * var11;
                var15 = 1.0D - (1.0D - var15) * (1.0D - var15);
                if (var15 < 0.0D) {
                    var15 = 0.0D;
                }

                if (var17 < 0.0D) {
                    var17 = 0.0D;
                }

                if (var15 > 1.0D) {
                    var15 = 1.0D;
                }

                if (var17 > 1.0D) {
                    var17 = 1.0D;
                }

                this.field_4259_a[var6] = var15;
                this.field_4258_b[var6] = var17;
                var1[var6++] = BiomeGenBase.func_4085_a(var15, var17);
            }
        }

        return var1;
    }
}
