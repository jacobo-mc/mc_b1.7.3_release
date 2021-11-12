package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderEntity extends Render {
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        renderOffsetAABB(var1.boundingBox, var2 - var1.lastTickPosX, var4 - var1.lastTickPosY, var6 - var1.lastTickPosZ);
        GL11.glPopMatrix();
    }
}
