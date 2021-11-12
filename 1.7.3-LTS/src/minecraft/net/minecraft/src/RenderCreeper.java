package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderCreeper extends RenderLiving {
    private ModelBase field_27008_a = new ModelCreeper(2.0F);

    public RenderCreeper() {
        super(new ModelCreeper(), 0.5F);
    }

    protected void updateCreeperScale(EntityCreeper var1, float var2) {
        float var4 = var1.setCreeperFlashTime(var2);
        float var5 = 1.0F + MathHelper.sin(var4 * 100.0F) * var4 * 0.01F;
        if (var4 < 0.0F) {
            var4 = 0.0F;
        }

        if (var4 > 1.0F) {
            var4 = 1.0F;
        }

        var4 *= var4;
        var4 *= var4;
        float var6 = (1.0F + var4 * 0.4F) * var5;
        float var7 = (1.0F + var4 * 0.1F) / var5;
        GL11.glScalef(var6, var7, var6);
    }

    protected int updateCreeperColorMultiplier(EntityCreeper var1, float var2, float var3) {
        float var5 = var1.setCreeperFlashTime(var3);
        if ((int)(var5 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int var6 = (int)(var5 * 0.2F * 255.0F);
            if (var6 < 0) {
                var6 = 0;
            }

            if (var6 > 255) {
                var6 = 255;
            }

            short var7 = 255;
            short var8 = 255;
            short var9 = 255;
            return var6 << 24 | var7 << 16 | var8 << 8 | var9;
        }
    }

    protected boolean func_27006_a(EntityCreeper var1, int var2, float var3) {
        if (var1.getPowered()) {
            if (var2 == 1) {
                float var4 = (float)var1.ticksExisted + var3;
                this.loadTexture("/armor/power.png");
                GL11.glMatrixMode(5890 /*GL_TEXTURE*/);
                GL11.glLoadIdentity();
                float var5 = var4 * 0.01F;
                float var6 = var4 * 0.01F;
                GL11.glTranslatef(var5, var6, 0.0F);
                this.setRenderPassModel(this.field_27008_a);
                GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
                GL11.glEnable(3042 /*GL_BLEND*/);
                float var7 = 0.5F;
                GL11.glColor4f(var7, var7, var7, 1.0F);
                GL11.glDisable(2896 /*GL_LIGHTING*/);
                GL11.glBlendFunc(1, 1);
                return true;
            }

            if (var2 == 2) {
                GL11.glMatrixMode(5890 /*GL_TEXTURE*/);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888 /*GL_MODELVIEW0_ARB*/);
                GL11.glEnable(2896 /*GL_LIGHTING*/);
                GL11.glDisable(3042 /*GL_BLEND*/);
            }
        }

        return false;
    }

    protected boolean func_27007_b(EntityCreeper var1, int var2, float var3) {
        return false;
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void preRenderCallback(EntityLiving var1, float var2) {
        this.updateCreeperScale((EntityCreeper)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected int getColorMultiplier(EntityLiving var1, float var2, float var3) {
        return this.updateCreeperColorMultiplier((EntityCreeper)var1, var2, var3);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean shouldRenderPass(EntityLiving var1, int var2, float var3) {
        return this.func_27006_a((EntityCreeper)var1, var2, var3);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean func_27005_b(EntityLiving var1, int var2, float var3) {
        return this.func_27007_b((EntityCreeper)var1, var2, var3);
    }
}
