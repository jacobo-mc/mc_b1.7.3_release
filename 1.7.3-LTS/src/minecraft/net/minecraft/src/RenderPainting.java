package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class RenderPainting extends Render {
    private Random rand = new Random();

    public void func_158_a(EntityPainting var1, double var2, double var4, double var6, float var8, float var9) {
        this.rand.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glRotatef(var8, 0.0F, 1.0F, 0.0F);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        this.loadTexture("/art/kz.png");
        EnumArt var10 = var1.art;
        float var11 = 0.0625F;
        GL11.glScalef(var11, var11, var11);
        this.func_159_a(var1, var10.sizeX, var10.sizeY, var10.offsetX, var10.offsetY);
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
    }

    private void func_159_a(EntityPainting var1, int var2, int var3, int var4, int var5) {
        float var6 = (float)(-var2) / 2.0F;
        float var7 = (float)(-var3) / 2.0F;
        float var8 = -0.5F;
        float var9 = 0.5F;

        for(int var10 = 0; var10 < var2 / 16; ++var10) {
            for(int var11 = 0; var11 < var3 / 16; ++var11) {
                float var12 = var6 + (float)((var10 + 1) * 16);
                float var13 = var6 + (float)(var10 * 16);
                float var14 = var7 + (float)((var11 + 1) * 16);
                float var15 = var7 + (float)(var11 * 16);
                this.func_160_a(var1, (var12 + var13) / 2.0F, (var14 + var15) / 2.0F);
                float var16 = (float)(var4 + var2 - var10 * 16) / 256.0F;
                float var17 = (float)(var4 + var2 - (var10 + 1) * 16) / 256.0F;
                float var18 = (float)(var5 + var3 - var11 * 16) / 256.0F;
                float var19 = (float)(var5 + var3 - (var11 + 1) * 16) / 256.0F;
                float var20 = 0.75F;
                float var21 = 0.8125F;
                float var22 = 0.0F;
                float var23 = 0.0625F;
                float var24 = 0.75F;
                float var25 = 0.8125F;
                float var26 = 0.001953125F;
                float var27 = 0.001953125F;
                float var28 = 0.7519531F;
                float var29 = 0.7519531F;
                float var30 = 0.0F;
                float var31 = 0.0625F;
                Tessellator var32 = Tessellator.instance;
                var32.startDrawingQuads();
                var32.setNormal(0.0F, 0.0F, -1.0F);
                var32.addVertexWithUV((double)var12, (double)var15, (double)var8, (double)var17, (double)var18);
                var32.addVertexWithUV((double)var13, (double)var15, (double)var8, (double)var16, (double)var18);
                var32.addVertexWithUV((double)var13, (double)var14, (double)var8, (double)var16, (double)var19);
                var32.addVertexWithUV((double)var12, (double)var14, (double)var8, (double)var17, (double)var19);
                var32.setNormal(0.0F, 0.0F, 1.0F);
                var32.addVertexWithUV((double)var12, (double)var14, (double)var9, (double)var20, (double)var22);
                var32.addVertexWithUV((double)var13, (double)var14, (double)var9, (double)var21, (double)var22);
                var32.addVertexWithUV((double)var13, (double)var15, (double)var9, (double)var21, (double)var23);
                var32.addVertexWithUV((double)var12, (double)var15, (double)var9, (double)var20, (double)var23);
                var32.setNormal(0.0F, -1.0F, 0.0F);
                var32.addVertexWithUV((double)var12, (double)var14, (double)var8, (double)var24, (double)var26);
                var32.addVertexWithUV((double)var13, (double)var14, (double)var8, (double)var25, (double)var26);
                var32.addVertexWithUV((double)var13, (double)var14, (double)var9, (double)var25, (double)var27);
                var32.addVertexWithUV((double)var12, (double)var14, (double)var9, (double)var24, (double)var27);
                var32.setNormal(0.0F, 1.0F, 0.0F);
                var32.addVertexWithUV((double)var12, (double)var15, (double)var9, (double)var24, (double)var26);
                var32.addVertexWithUV((double)var13, (double)var15, (double)var9, (double)var25, (double)var26);
                var32.addVertexWithUV((double)var13, (double)var15, (double)var8, (double)var25, (double)var27);
                var32.addVertexWithUV((double)var12, (double)var15, (double)var8, (double)var24, (double)var27);
                var32.setNormal(-1.0F, 0.0F, 0.0F);
                var32.addVertexWithUV((double)var12, (double)var14, (double)var9, (double)var29, (double)var30);
                var32.addVertexWithUV((double)var12, (double)var15, (double)var9, (double)var29, (double)var31);
                var32.addVertexWithUV((double)var12, (double)var15, (double)var8, (double)var28, (double)var31);
                var32.addVertexWithUV((double)var12, (double)var14, (double)var8, (double)var28, (double)var30);
                var32.setNormal(1.0F, 0.0F, 0.0F);
                var32.addVertexWithUV((double)var13, (double)var14, (double)var8, (double)var29, (double)var30);
                var32.addVertexWithUV((double)var13, (double)var15, (double)var8, (double)var29, (double)var31);
                var32.addVertexWithUV((double)var13, (double)var15, (double)var9, (double)var28, (double)var31);
                var32.addVertexWithUV((double)var13, (double)var14, (double)var9, (double)var28, (double)var30);
                var32.draw();
            }
        }

    }

    private void func_160_a(EntityPainting var1, float var2, float var3) {
        int var4 = MathHelper.floor_double(var1.posX);
        int var5 = MathHelper.floor_double(var1.posY + (double)(var3 / 16.0F));
        int var6 = MathHelper.floor_double(var1.posZ);
        if (var1.direction == 0) {
            var4 = MathHelper.floor_double(var1.posX + (double)(var2 / 16.0F));
        }

        if (var1.direction == 1) {
            var6 = MathHelper.floor_double(var1.posZ - (double)(var2 / 16.0F));
        }

        if (var1.direction == 2) {
            var4 = MathHelper.floor_double(var1.posX - (double)(var2 / 16.0F));
        }

        if (var1.direction == 3) {
            var6 = MathHelper.floor_double(var1.posZ + (double)(var2 / 16.0F));
        }

        float var7 = this.renderManager.worldObj.getLightBrightness(var4, var5, var6);
        GL11.glColor3f(var7, var7, var7);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_158_a((EntityPainting)var1, var2, var4, var6, var8, var9);
    }
}
