package net.minecraft.src;

public class RenderCow extends RenderLiving {
    public RenderCow(ModelBase var1, float var2) {
        super(var1, var2);
    }

    public void func_177_a(EntityCow var1, double var2, double var4, double var6, float var8, float var9) {
        super.func_171_a(var1, var2, var4, var6, var8, var9);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_171_a(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_177_a((EntityCow)var1, var2, var4, var6, var8, var9);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_177_a((EntityCow)var1, var2, var4, var6, var8, var9);
    }
}
