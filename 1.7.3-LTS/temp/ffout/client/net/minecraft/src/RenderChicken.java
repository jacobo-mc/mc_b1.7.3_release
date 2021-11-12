package net.minecraft.src;

public class RenderChicken extends RenderLiving {
    public RenderChicken(ModelBase var1, float var2) {
        super(var1, var2);
    }

    public void func_181_a(EntityChicken var1, double var2, double var4, double var6, float var8, float var9) {
        super.func_171_a(var1, var2, var4, var6, var8, var9);
    }

    protected float func_182_a(EntityChicken var1, float var2) {
        float var3 = var1.field_756_e + (var1.field_752_b - var1.field_756_e) * var2;
        float var4 = var1.field_757_d + (var1.field_758_c - var1.field_757_d) * var2;
        return (MathHelper.func_1106_a(var3) + 1.0F) * var4;
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected float func_170_d(EntityLiving var1, float var2) {
        return this.func_182_a((EntityChicken)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_171_a(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_181_a((EntityChicken)var1, var2, var4, var6, var8, var9);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_181_a((EntityChicken)var1, var2, var4, var6, var8, var9);
    }
}
