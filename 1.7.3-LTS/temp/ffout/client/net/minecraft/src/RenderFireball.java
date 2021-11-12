package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderFireball extends Render {
    public void func_4012_a(EntityFireball var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glEnable(32826);
        float var10 = 2.0F;
        GL11.glScalef(var10 / 1.0F, var10 / 1.0F, var10 / 1.0F);
        int var11 = Item.field_308_aB.func_27009_a(0);
        this.func_151_a("/gui/items.png");
        Tessellator var12 = Tessellator.field_1512_a;
        float var13 = (float)(var11 % 16 * 16 + 0) / 256.0F;
        float var14 = (float)(var11 % 16 * 16 + 16) / 256.0F;
        float var15 = (float)(var11 / 16 * 16 + 0) / 256.0F;
        float var16 = (float)(var11 / 16 * 16 + 16) / 256.0F;
        float var17 = 1.0F;
        float var18 = 0.5F;
        float var19 = 0.25F;
        GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        var12.func_977_b();
        var12.func_980_b(0.0F, 1.0F, 0.0F);
        var12.func_983_a((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
        var12.func_983_a((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
        var12.func_983_a((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
        var12.func_983_a((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
        var12.func_982_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_4012_a((EntityFireball)var1, var2, var4, var6, var8, var9);
    }
}
