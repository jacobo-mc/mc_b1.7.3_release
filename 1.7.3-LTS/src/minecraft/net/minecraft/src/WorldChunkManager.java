package net.minecraft.src;

import java.util.Random;

public class WorldChunkManager {
    private NoiseGeneratorOctaves2 field_4194_e;
    private NoiseGeneratorOctaves2 field_4193_f;
    private NoiseGeneratorOctaves2 field_4192_g;
    public double[] temperature;
    public double[] humidity;
    public double[] field_4196_c;
    public BiomeGenBase[] biomeGenBase;

    protected WorldChunkManager() {
    }

    public WorldChunkManager(World var1) {
        this.field_4194_e = new NoiseGeneratorOctaves2(new Random(var1.getRandomSeed() * 9871L), 4);
        this.field_4193_f = new NoiseGeneratorOctaves2(new Random(var1.getRandomSeed() * 39811L), 4);
        this.field_4192_g = new NoiseGeneratorOctaves2(new Random(var1.getRandomSeed() * 543321L), 2);
    }

    public BiomeGenBase getBiomeGenAtChunkCoord(ChunkCoordIntPair var1) {
        return this.getBiomeGenAt(var1.chunkXPos << 4, var1.chunkZPos << 4);
    }

    public BiomeGenBase getBiomeGenAt(int var1, int var2) {
        return this.getBiomeGenBaseAt(var1, var2, 1, 1)[0];
    }

    public double getTemperature(int var1, int var2) {
        this.temperature = this.field_4194_e.func_4112_a(this.temperature, (double)var1, (double)var2, 1, 1, 0.02500000037252903D, 0.02500000037252903D, 0.5D);
        return this.temperature[0];
    }

    public BiomeGenBase[] getBiomeGenBaseAt(int var1, int var2, int var3, int var4) {
        this.biomeGenBase = this.loadBlockGeneratorData(this.biomeGenBase, var1, var2, var3, var4);
        return this.biomeGenBase;
    }

    public double[] getTemperatures(double[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new double[var4 * var5];
        }

        var1 = this.field_4194_e.func_4112_a(var1, (double)var2, (double)var3, var4, var5, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var2, (double)var3, var4, var5, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for(int var7 = 0; var7 < var4; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
                double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
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

        this.temperature = this.field_4194_e.func_4112_a(this.temperature, (double)var2, (double)var3, var4, var4, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.humidity = this.field_4193_f.func_4112_a(this.humidity, (double)var2, (double)var3, var4, var4, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var2, (double)var3, var4, var4, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for(int var7 = 0; var7 < var4; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
                double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
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
