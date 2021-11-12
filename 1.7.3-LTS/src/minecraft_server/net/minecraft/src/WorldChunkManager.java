package net.minecraft.src;

import java.util.Random;

public class WorldChunkManager {
    private NoiseGeneratorOctaves2 field_4255_e;
    private NoiseGeneratorOctaves2 field_4254_f;
    private NoiseGeneratorOctaves2 field_4253_g;
    public double[] temperature;
    public double[] humidity;
    public double[] field_4257_c;
    public BiomeGenBase[] field_4256_d;

    protected WorldChunkManager() {
    }

    public WorldChunkManager(World var1) {
        this.field_4255_e = new NoiseGeneratorOctaves2(new Random(var1.getRandomSeed() * 9871L), 4);
        this.field_4254_f = new NoiseGeneratorOctaves2(new Random(var1.getRandomSeed() * 39811L), 4);
        this.field_4253_g = new NoiseGeneratorOctaves2(new Random(var1.getRandomSeed() * 543321L), 2);
    }

    public BiomeGenBase func_4066_a(ChunkCoordIntPair var1) {
        return this.getBiomeGenAt(var1.chunkXPos << 4, var1.chunkZPos << 4);
    }

    public BiomeGenBase getBiomeGenAt(int var1, int var2) {
        return this.func_4065_a(var1, var2, 1, 1)[0];
    }

    public BiomeGenBase[] func_4065_a(int var1, int var2, int var3, int var4) {
        this.field_4256_d = this.loadBlockGeneratorData(this.field_4256_d, var1, var2, var3, var4);
        return this.field_4256_d;
    }

    public double[] getTemperatures(double[] var1, int var2, int var3, int var4, int var5) {
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

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new BiomeGenBase[var4 * var5];
        }

        this.temperature = this.field_4255_e.func_4101_a(this.temperature, (double)var2, (double)var3, var4, var4, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.humidity = this.field_4254_f.func_4101_a(this.humidity, (double)var2, (double)var3, var4, var4, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
        this.field_4257_c = this.field_4253_g.func_4101_a(this.field_4257_c, (double)var2, (double)var3, var4, var4, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for(int var7 = 0; var7 < var4; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
                double var9 = this.field_4257_c[var6] * 1.1D + 0.5D;
                double var11 = 0.01D;
                double var13 = 1.0D - var11;
                double var15 = (this.temperature[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
                var11 = 0.002D;
                var13 = 1.0D - var11;
                double var17 = (this.humidity[var6] * 0.15D + 0.5D) * var13 + var9 * var11;
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

                this.temperature[var6] = var15;
                this.humidity[var6] = var17;
                var1[var6++] = BiomeGenBase.getBiomeFromLookup(var15, var17);
            }
        }

        return var1;
    }
}
