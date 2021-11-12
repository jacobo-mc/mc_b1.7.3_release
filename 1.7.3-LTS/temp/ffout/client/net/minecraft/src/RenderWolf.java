package net.minecraft.src;

public class RenderWolf extends RenderLiving {
    public RenderWolf(ModelBase var1, float var2) {
        super(var1, var2);
    }

    public void func_25005_a(EntityWolf var1, double var2, double var4, double var6, float var8, float var9) {
        super.func_171_a(var1, var2, var4, var6, var8, var9);
    }

    protected float func_25004_a(EntityWolf var1, float var2) {
        return var1.func_25037_z();
    }

    protected void func_25006_b(EntityWolf var1, float var2) {
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_6330_a(EntityLiving var1, float var2) {
        this.func_25006_b((EntityWolf)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected float func_170_d(EntityLiving var1, float var2) {
        return this.func_25004_a((EntityWolf)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_171_a(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_25005_a((EntityWolf)var1, var2, var4, var6, var8, var9);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_25005_a((EntityWolf)var1, var2, var4, var6, var8, var9);
    }
}
