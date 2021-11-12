package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderFallingSand extends Render {
    private RenderBlocks field_197_d = new RenderBlocks();

    public RenderFallingSand() {
        this.field_9246_c = 0.5F;
    }

    public void func_156_a(EntityFallingSand var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        this.func_151_a("/terrain.png");
        Block var10 = Block.field_345_n[var1.field_799_a];
        World var11 = var1.func_465_i();
        GL11.glDisable(2896);
        this.field_197_d.func_1243_a(var10, var11, MathHelper.func_1108_b(var1.field_611_ak), MathHelper.func_1108_b(var1.field_610_al), MathHelper.func_1108_b(var1.field_609_am));
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_156_a((EntityFallingSand)var1, var2, var4, var6, var8, var9);
    }
}
