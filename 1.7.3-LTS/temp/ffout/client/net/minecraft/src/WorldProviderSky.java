package net.minecraft.src;

public class WorldProviderSky extends WorldProvider {
    public void func_4098_a() {
        this.field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_28057_m, 0.5D, 0.0D);
        this.field_4218_e = 1;
    }

    public IChunkProvider func_4094_c() {
        return new ChunkProviderSky(this.field_4216_a, this.field_4216_a.func_22138_q());
    }

    public float func_4100_a(long var1, float var3) {
        return 0.0F;
    }

    public float[] func_4097_b(float var1, float var2) {
        return null;
    }

    public Vec3D func_4096_a(float var1, float var2) {
        int var3 = 8421536;
        float var4 = MathHelper.func_1114_b(var1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
        if (var4 < 0.0F) {
            var4 = 0.0F;
        }

        if (var4 > 1.0F) {
            var4 = 1.0F;
        }

        float var5 = (float)(var3 >> 16 & 255) / 255.0F;
        float var6 = (float)(var3 >> 8 & 255) / 255.0F;
        float var7 = (float)(var3 & 255) / 255.0F;
        var5 *= var4 * 0.94F + 0.06F;
        var6 *= var4 * 0.94F + 0.06F;
        var7 *= var4 * 0.91F + 0.09F;
        return Vec3D.func_1248_b((double)var5, (double)var6, (double)var7);
    }

    public boolean func_28112_c() {
        return false;
    }

    public float func_28111_d() {
        return 8.0F;
    }

    public boolean func_4102_a(int var1, int var2) {
        int var3 = this.field_4216_a.func_614_g(var1, var2);
        return var3 == 0 ? false : Block.field_345_n[var3].field_356_bn.func_880_c();
    }
}
