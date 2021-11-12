package net.minecraft.src;

public abstract class WorldProvider {
    public World field_4302_a;
    public WorldChunkManager field_4301_b;
    public boolean field_6167_c = false;
    public boolean field_6166_d = false;
    public boolean field_4306_c = false;
    public float[] field_4305_d = new float[16];
    public int field_6165_g = 0;
    private float[] field_6164_h = new float[4];

    public final void func_4093_a(World var1) {
        this.field_4302_a = var1;
        this.func_4090_a();
        this.func_4088_b();
    }

    protected void func_4088_b() {
        float var1 = 0.05F;

        for(int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.field_4305_d[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }

    }

    protected void func_4090_a() {
        this.field_4301_b = new WorldChunkManager(this.field_4302_a);
    }

    public IChunkProvider func_4087_c() {
        return new ChunkProviderGenerate(this.field_4302_a, this.field_4302_a.func_22079_j());
    }

    public boolean func_4092_a(int var1, int var2) {
        int var3 = this.field_4302_a.func_528_f(var1, var2);
        return var3 == Block.field_590_F.field_573_bc;
    }

    public float func_4089_a(long var1, float var3) {
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

    public boolean func_28108_d() {
        return true;
    }

    public static WorldProvider func_4091_a(int var0) {
        if (var0 == -1) {
            return new WorldProviderHell();
        } else if (var0 == 0) {
            return new WorldProviderSurface();
        } else {
            return var0 == 1 ? new WorldProviderSky() : null;
        }
    }
}
