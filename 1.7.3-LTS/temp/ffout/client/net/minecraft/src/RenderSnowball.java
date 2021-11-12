package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSnowball extends Render {
    private int field_20003_a;

    public RenderSnowball(int var1) {
        this.field_20003_a = var1;
    }

    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.func_151_a("/gui/items.png");
        Tessellator var10 = Tessellator.field_1512_a;
        float var11 = (float)(this.field_20003_a % 16 * 16 + 0) / 256.0F;
        float var12 = (float)(this.field_20003_a % 16 * 16 + 16) / 256.0F;
        float var13 = (float)(this.field_20003_a / 16 * 16 + 0) / 256.0F;
        float var14 = (float)(this.field_20003_a / 16 * 16 + 16) / 256.0F;
        float var15 = 1.0F;
        float var16 = 0.5F;
        float var17 = 0.25F;
        GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        var10.func_977_b();
        var10.func_980_b(0.0F, 1.0F, 0.0F);
        var10.func_983_a((double)(0.0F - var16), (double)(0.0F - var17), 0.0D, (double)var11, (double)var14);
        var10.func_983_a((double)(var15 - var16), (double)(0.0F - var17), 0.0D, (double)var12, (double)var14);
        var10.func_983_a((double)(var15 - var16), (double)(1.0F - var17), 0.0D, (double)var12, (double)var13);
        var10.func_983_a((double)(0.0F - var16), (double)(1.0F - var17), 0.0D, (double)var11, (double)var13);
        var10.func_982_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
}
