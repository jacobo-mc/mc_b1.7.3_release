package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderTNTPrimed extends Render {
    private RenderBlocks field_196_d = new RenderBlocks();

    public RenderTNTPrimed() {
        this.field_9246_c = 0.5F;
    }

    public void func_153_a(EntityTNTPrimed var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        float var10;
        if ((float)var1.field_689_a - var9 + 1.0F < 10.0F) {
            var10 = 1.0F - ((float)var1.field_689_a - var9 + 1.0F) / 10.0F;
            if (var10 < 0.0F) {
                var10 = 0.0F;
            }

            if (var10 > 1.0F) {
                var10 = 1.0F;
            }

            var10 *= var10;
            var10 *= var10;
            float var11 = 1.0F + var10 * 0.3F;
            GL11.glScalef(var11, var11, var11);
        }

        var10 = (1.0F - ((float)var1.field_689_a - var9 + 1.0F) / 100.0F) * 0.8F;
        this.func_151_a("/terrain.png");
        this.field_196_d.func_1227_a(Block.field_408_an, 0, var1.func_382_a(var9));
        if (var1.field_689_a / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, var10);
            this.field_196_d.func_1227_a(Block.field_408_an, 0, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }

        GL11.glPopMatrix();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_153_a((EntityTNTPrimed)var1, var2, var4, var6, var8, var9);
    }
}
