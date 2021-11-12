package net.minecraft.src;

public class WorldProviderHell extends WorldProvider {
    public void func_4090_a() {
        this.field_4301_b = new WorldChunkManagerHell(BiomeGenBase.field_4289_l, 1.0D, 0.0D);
        this.field_6167_c = true;
        this.field_6166_d = true;
        this.field_4306_c = true;
        this.field_6165_g = -1;
    }

    protected void func_4088_b() {
        float var1 = 0.1F;

        for(int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.field_4305_d[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }

    }

    public IChunkProvider func_4087_c() {
        return new ChunkProviderHell(this.field_4302_a, this.field_4302_a.func_22079_j());
    }

    public boolean func_4092_a(int var1, int var2) {
        int var3 = this.field_4302_a.func_528_f(var1, var2);
        if (var3 == Block.field_4064_A.field_573_bc) {
            return false;
        } else if (var3 == 0) {
            return false;
        } else {
            return Block.field_540_p[var3];
        }
    }

    public float func_4089_a(long var1, float var3) {
        return 0.5F;
    }

    public boolean func_28108_d() {
        return false;
    }
}
