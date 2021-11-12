package net.minecraft.src;

public abstract class WorldProvider {
    public World field_4216_a;
    public WorldChunkManager field_4215_b;
    public boolean field_4220_c = false;
    public boolean field_6479_d = false;
    public boolean field_6478_e = false;
    public float[] field_4219_d = new float[16];
    public int field_4218_e = 0;
    private float[] field_4217_f = new float[4];

    public final void func_4095_a(World var1) {
        this.field_4216_a = var1;
        this.func_4098_a();
        this.func_4093_b();
    }

    protected void func_4093_b() {
        float var1 = 0.05F;

        for(int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.field_4219_d[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }

    }

    protected void func_4098_a() {
        this.field_4215_b = new WorldChunkManager(this.field_4216_a);
    }

    public IChunkProvider func_4094_c() {
        return new ChunkProviderGenerate(this.field_4216_a, this.field_4216_a.func_22138_q());
    }

    public boolean func_4102_a(int var1, int var2) {
        int var3 = this.field_4216_a.func_614_g(var1, var2);
        return var3 == Block.field_393_F.field_376_bc;
    }

    public float func_4100_a(long var1, float var3) {
        int var4 = (int)(var1 % 24000L);
        float var5 = ((float)var4 + var3) / 24000.0F - 0.25F;
        if (var5 < 0.0F) {
            ++var5;
        }

        if (var5 > 1.0F) {
            --var5;
        }

        float var6 = var5;
        var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
        var5 = var6 + (var5 - var6) / 3.0F;
        return var5;
    }

    public float[] func_4097_b(float var1, float var2) {
        float var3 = 0.4F;
        float var4 = MathHelper.func_1114_b(var1 * 3.1415927F * 2.0F) - 0.0F;
        float var5 = -0.0F;
        if (var4 >= var5 - var3 && var4 <= var5 + var3) {
            float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
            float var7 = 1.0F - (1.0F - MathHelper.func_1106_a(var6 * 3.1415927F)) * 0.99F;
            var7 *= var7;
            this.field_4217_f[0] = var6 * 0.3F + 0.7F;
            this.field_4217_f[1] = var6 * var6 * 0.7F + 0.2F;
            this.field_4217_f[2] = var6 * var6 * 0.0F + 0.2F;
            this.field_4217_f[3] = var7;
            return this.field_4217_f;
        } else {
            return null;
        }
    }

    public Vec3D func_4096_a(float var1, float var2) {
        float var3 = MathHelper.func_1114_b(var1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
        if (var3 < 0.0F) {
            var3 = 0.0F;
        }

        if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        float var4 = 0.7529412F;
        float var5 = 0.84705883F;
        float var6 = 1.0F;
        var4 *= var3 * 0.94F + 0.06F;
        var5 *= var3 * 0.94F + 0.06F;
        var6 *= var3 * 0.91F + 0.09F;
        return Vec3D.func_1248_b((double)var4, (double)var5, (double)var6);
    }

    public boolean func_6477_d() {
        return true;
    }

    public static WorldProvider func_4101_a(int var0) {
        if (var0 == -1) {
            return new WorldProviderHell();
        } else if (var0 == 0) {
            return new WorldProviderSurface();
        } else {
            return var0 == 1 ? new WorldProviderSky() : null;
        }
    }

    public float func_28111_d() {
        return 108.0F;
    }

    public boolean func_28112_c() {
        return true;
    }
}
