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

    public BiomeGenBase func_4074_a(ChunkCoordIntPair var1) {
        return this.field_4201_e;
    }

    public BiomeGenBase func_4073_a(int var1, int var2) {
        return this.field_4201_e;
    }

    public double func_4072_b(int var1, int var2) {
        return this.field_4200_f;
    }

    public BiomeGenBase[] func_4069_a(int var1, int var2, int var3, int var4) {
        this.field_4195_d = this.func_4070_a(this.field_4195_d, var1, var2, var3, var4);
        return this.field_4195_d;
    }

    public double[] func_4071_a(double[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new double[var4 * var5];
        }

        Arrays.fill(var1, 0, var4 * var5, this.field_4200_f);
        return var1;
    }

    public BiomeGenBase[] func_4070_a(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
        if (var1 == null || var1.length < var4 * var5) {
            var1 = new BiomeGenBase[var4 * var5];
        }

        if (this.field_4198_a == null || this.field_4198_a.length < var4 * var5) {
            this.field_4198_a = new double[var4 * var5];
            this.field_4197_b = new double[var4 * var5];
        }

        Arrays.fill(var1, 0, var4 * var5, this.field_4201_e);
        Arrays.fill(this.field_4197_b, 0, var4 * var5, this.field_4199_g);
        Arrays.fill(this.field_4198_a, 0, var4 * var5, this.field_4200_f);
        return var1;
    }
}
