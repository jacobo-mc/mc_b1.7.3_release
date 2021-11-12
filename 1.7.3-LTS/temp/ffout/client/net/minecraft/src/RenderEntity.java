package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderEntity extends Render {
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        func_146_a(var1.field_601_au, var2 - var1.field_638_aI, var4 - var1.field_637_aJ, var6 - var1.field_636_aK);
        GL11.glPopMatrix();
    }
}
