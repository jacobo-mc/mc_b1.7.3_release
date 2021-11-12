package net.minecraft.src;

public class WorldProviderSky extends WorldProvider {
    public void func_4090_a() {
        this.field_4301_b = new WorldChunkManagerHell(BiomeGenBase.field_28054_m, 0.5D, 0.0D);
        this.field_6165_g = 1;
    }

    public IChunkProvider func_4087_c() {
        return new ChunkProviderSky(this.field_4302_a, this.field_4302_a.func_22079_j());
    }

    public float func_4089_a(long var1, float var3) {
        return 0.0F;
    }

    public boolean func_4092_a(int var1, int var2) {
        int var3 = this.field_4302_a.func_528_f(var1, var2);
        return var3 == 0 ? false : Block.field_542_n[var3].field_553_bn.func_218_c();
    }
}
