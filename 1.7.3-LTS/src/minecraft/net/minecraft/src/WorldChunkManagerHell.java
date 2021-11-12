package net.minecraft.src;

import java.util.Arrays;

public class WorldChunkManagerHell extends WorldChunkManager {
    private BiomeGenBase field_4201_e;
    private double field_4200_f;
    private double field_4199_g;

    public WorldChunkManagerHell(BiomeGenBase var1, double var2, double var4) {
        this.field_4201_e = var1;
        this.field_4200_f = var2;
        this.field_4199_g = var4;
    }

    public BiomeGenBase getBiomeGenAtChunkCoord(ChunkCoordIntPair var1) {
        return this.field_4201_e;
    }

    public BiomeGenBase getBiomeGenAt(int var1, int var2) {
        return this.field_4201_e;
    }

    public double getTemperature(int var1, int var2) {
        return this.field_4200_f;
    }

    public BiomeGenBase[] getBiomeGenBaseAt(int var1, int var2, int var3, int var4) {
        this.biomeGenBase = this.loadBlockGeneratorData(this.biomeGenBase, var1, var2, var3, var4);
        return this.biomeGenBase;
    }

    public double[] getTemperatures(double[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new double[var4 * var5];
        }

        Arrays.fill(var1, 0, var4 * var5, this.field_4200_f);
        return var1;
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new BiomeGenBase[var4 * var5];
        }

        if (this.temperature == null || this.temperature.length < var4 * var5) {
            this.temperature = new double[var4 * var5];
            this.humidity = new double[var4 * var5];
        }

        Arrays.fill(var1, 0, var4 * var5, this.field_4201_e);
        Arrays.fill(this.humidity, 0, var4 * var5, this.field_4199_g);
        Arrays.fill(this.temperature, 0, var4 * var5, this.field_4200_f);
        return var1;
    }
}
