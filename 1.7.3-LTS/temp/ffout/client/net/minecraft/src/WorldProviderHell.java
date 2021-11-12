package net.minecraft.src;

public class WorldProviderHell extends WorldProvider {
    public void func_4098_a() {
        this.field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_4245_l, 1.0D, 0.0D);
        this.field_4220_c = true;
        this.field_6479_d = true;
        this.field_6478_e = true;
        this.field_4218_e = -1;
    }

    public Vec3D func_4096_a(float var1, float var2) {
        return Vec3D.func_1248_b(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
    }

    protected void func_4093_b() {
        float var1 = 0.1F;

        for(int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.field_4219_d[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }

    }

    public IChunkProvider func_4094_c() {
        return new ChunkProviderHell(this.field_4216_a, this.field_4216_a.func_22138_q());
    }

    public boolean func_4102_a(int var1, int var2) {
        int var3 = this.field_4216_a.func_614_g(var1, var2);
        if (var3 == Block.field_403_A.field_376_bc) {
            return false;
        } else if (var3 == 0) {
            return false;
        } else {
            return Block.field_343_p[var3];
        }
    }

    public float func_4100_a(long var1, float var3) {
        return 0.5F;
    }

    public boolean func_6477_d() {
        return false;
    }
}
