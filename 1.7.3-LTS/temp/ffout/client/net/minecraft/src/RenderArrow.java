package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderArrow extends Render {
    public void func_154_a(EntityArrow var1, double var2, double var4, double var6, float var8, float var9) {
        if (var1.field_603_as != 0.0F || var1.field_602_at != 0.0F) {
            this.func_151_a("/item/arrows.png");
            GL11.glPushMatrix();
            GL11.glTranslatef((float)var2, (float)var4, (float)var6);
            GL11.glRotatef(var1.field_603_as + (var1.field_605_aq - var1.field_603_as) * var9 - 90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var1.field_602_at + (var1.field_604_ar - var1.field_602_at) * var9, 0.0F, 0.0F, 1.0F);
            Tessellator var10 = Tessellator.field_1512_a;
            byte var11 = 0;
            float var12 = 0.0F;
            float var13 = 0.5F;
            float var14 = (float)(0 + var11 * 10) / 32.0F;
            float var15 = (float)(5 + var11 * 10) / 32.0F;
            float var16 = 0.0F;
            float var17 = 0.15625F;
            float var18 = (float)(5 + var11 * 10) / 32.0F;
            float var19 = (float)(10 + var11 * 10) / 32.0F;
            float var20 = 0.05625F;
            GL11.glEnable(32826);
            float var21 = (float)var1.field_688_a - var9;
            if (var21 > 0.0F) {
                float var22 = -MathHelper.func_1106_a(var21 * 3.0F) * var21;
                GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
            }

            GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(var20, var20, var20);
            GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
            GL11.glNormal3f(var20, 0.0F, 0.0F);
            var10.func_977_b();
            var10.func_983_a(-7.0D, -2.0D, -2.0D, (double)var16, (double)var18);
            var10.func_983_a(-7.0D, -2.0D, 2.0D, (double)var17, (double)var18);
            var10.func_983_a(-7.0D, 2.0D, 2.0D, (double)var17, (double)var19);
            var10.func_983_a(-7.0D, 2.0D, -2.0D, (double)var16, (double)var19);
            var10.func_982_a();
            GL11.glNormal3f(-var20, 0.0F, 0.0F);
            var10.func_977_b();
            var10.func_983_a(-7.0D, 2.0D, -2.0D, (double)var16, (double)var18);
            var10.func_983_a(-7.0D, 2.0D, 2.0D, (double)var17, (double)var18);
            var10.func_983_a(-7.0D, -2.0D, 2.0D, (double)var17, (double)var19);
            var10.func_983_a(-7.0D, -2.0D, -2.0D, (double)var16, (double)var19);
            var10.func_982_a();

            for(int var23 = 0; var23 < 4; ++var23) {
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glNormal3f(0.0F, 0.0F, var20);
                var10.func_977_b();
                var10.func_983_a(-8.0D, -2.0D, 0.0D, (double)var12, (double)var14);
                var10.func_983_a(8.0D, -2.0D, 0.0D, (double)var13, (double)var14);
                var10.func_983_a(8.0D, 2.0D, 0.0D, (double)var13, (double)var15);
                var10.func_983_a(-8.0D, 2.0D, 0.0D, (double)var12, (double)var15);
                var10.func_982_a();
            }

            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_154_a((EntityArrow)var1, var2, var4, var6, var8, var9);
    }
}
