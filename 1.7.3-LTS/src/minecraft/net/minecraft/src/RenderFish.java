package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderFish extends Render {
    public void func_4011_a(EntityFish var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        byte var10 = 1;
        byte var11 = 2;
        this.loadTexture("/particles.png");
        Tessellator var12 = Tessellator.instance;
        float var13 = (float)(var10 * 8 + 0) / 128.0F;
        float var14 = (float)(var10 * 8 + 8) / 128.0F;
        float var15 = (float)(var11 * 8 + 0) / 128.0F;
        float var16 = (float)(var11 * 8 + 8) / 128.0F;
        float var17 = 1.0F;
        float var18 = 0.5F;
        float var19 = 0.5F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        var12.startDrawingQuads();
        var12.setNormal(0.0F, 1.0F, 0.0F);
        var12.addVertexWithUV((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
        var12.addVertexWithUV((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
        var12.addVertexWithUV((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
        var12.addVertexWithUV((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
        var12.draw();
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glPopMatrix();
        if (var1.angler != null) {
            float var20 = (var1.angler.prevRotationYaw + (var1.angler.rotationYaw - var1.angler.prevRotationYaw) * var9) * 3.1415927F / 180.0F;
            double var21 = (double)MathHelper.sin(var20);
            double var23 = (double)MathHelper.cos(var20);
            float var25 = var1.angler.getSwingProgress(var9);
            float var26 = MathHelper.sin(MathHelper.sqrt_float(var25) * 3.1415927F);
            Vec3D var27 = Vec3D.createVector(-0.5D, 0.03D, 0.8D);
            var27.rotateAroundX(-(var1.angler.prevRotationPitch + (var1.angler.rotationPitch - var1.angler.prevRotationPitch) * var9) * 3.1415927F / 180.0F);
            var27.rotateAroundY(-(var1.angler.prevRotationYaw + (var1.angler.rotationYaw - var1.angler.prevRotationYaw) * var9) * 3.1415927F / 180.0F);
            var27.rotateAroundY(var26 * 0.5F);
            var27.rotateAroundX(-var26 * 0.7F);
            double var28 = var1.angler.prevPosX + (var1.angler.posX - var1.angler.prevPosX) * (double)var9 + var27.xCoord;
            double var30 = var1.angler.prevPosY + (var1.angler.posY - var1.angler.prevPosY) * (double)var9 + var27.yCoord;
            double var32 = var1.angler.prevPosZ + (var1.angler.posZ - var1.angler.prevPosZ) * (double)var9 + var27.zCoord;
            if (this.renderManager.options.thirdPersonView) {
                var20 = (var1.angler.prevRenderYawOffset + (var1.angler.renderYawOffset - var1.angler.prevRenderYawOffset) * var9) * 3.1415927F / 180.0F;
                var21 = (double)MathHelper.sin(var20);
                var23 = (double)MathHelper.cos(var20);
                var28 = var1.angler.prevPosX + (var1.angler.posX - var1.angler.prevPosX) * (double)var9 - var23 * 0.35D - var21 * 0.85D;
                var30 = var1.angler.prevPosY + (var1.angler.posY - var1.angler.prevPosY) * (double)var9 - 0.45D;
                var32 = var1.angler.prevPosZ + (var1.angler.posZ - var1.angler.prevPosZ) * (double)var9 - var21 * 0.35D + var23 * 0.85D;
            }

            double var34 = var1.prevPosX + (var1.posX - var1.prevPosX) * (double)var9;
            double var36 = var1.prevPosY + (var1.posY - var1.prevPosY) * (double)var9 + 0.25D;
            double var38 = var1.prevPosZ + (var1.posZ - var1.prevPosZ) * (double)var9;
            double var40 = (double)((float)(var28 - var34));
            double var42 = (double)((float)(var30 - var36));
            double var44 = (double)((float)(var32 - var38));
            GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            var12.startDrawing(3);
            var12.setColorOpaque_I(0);
            byte var46 = 16;

            for(int var47 = 0; var47 <= var46; ++var47) {
                float var48 = (float)var47 / (float)var46;
                var12.addVertex(var2 + var40 * (double)var48, var4 + var42 * (double)(var48 * var48 + var48) * 0.5D + 0.25D, var6 + var44 * (double)var48);
            }

            var12.draw();
            GL11.glEnable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        }

    }

    // $FF: synthetic method
    // $FF: bridge method
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_4011_a((EntityFish)var1, var2, var4, var6, var8, var9);
    }
}
