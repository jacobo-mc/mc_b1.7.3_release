package net.minecraft.src;

import java.util.Arrays;

public class WorldChunkManagerHell extends WorldChunkManager {
    private BiomeGenBase field_4262_e;
    private double field_4261_f;
    private double field_4260_g;

    public WorldChunkManagerHell(BiomeGenBase var1, double var2, double var4) {
        this.field_4262_e = var1;
        this.field_4261_f = var2;
        this.field_4260_g = var4;
    }

    public BiomeGenBase func_4066_a(ChunkCoordIntPair var1) {
        return this.field_4262_e;
    }

    public BiomeGenBase getBiomeGenAt(int var1, int var2) {
        return this.field_4262_e;
    }

    public BiomeGenBase[] func_4065_a(int var1, int var2, int var3, int var4) {
        this.field_4256_d = this.loadBlockGeneratorData(this.field_4256_d, var1, var2, var3, var4);
        return this.field_4256_d;
    }

    public double[] getTemperatures(double[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new double[var4 * var5];
        }

        Arrays.fill(var1, 0, var4 * var5, this.field_4261_f);
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

        Arrays.fill(var1, 0, var4 * var5, this.field_4262_e);
        Arrays.fill(this.humidity, 0, var4 * var5, this.field_4260_g);
        Arrays.fill(this.temperature, 0, var4 * var5, this.field_4261_f);
        return var1;
    }
}
