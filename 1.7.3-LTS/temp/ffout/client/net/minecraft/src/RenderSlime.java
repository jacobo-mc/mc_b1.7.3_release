package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSlime extends RenderLiving {
    private ModelBase field_205_f;

    public RenderSlime(ModelBase var1, ModelBase var2, float var3) {
        super(var1, var3);
        this.field_205_f = var2;
    }

    protected boolean func_179_a(EntitySlime var1, int var2, float var3) {
        if (var2 == 0) {
            this.func_4013_a(this.field_205_f);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return true;
        } else {
            if (var2 == 1) {
                GL11.glDisable(3042);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return false;
        }
    }

    protected void func_178_a(EntitySlime var1, float var2) {
        int var3 = var1.func_25027_v();
        float var4 = (var1.field_767_b + (var1.field_768_a - var1.field_767_b) * var2) / ((float)var3 * 0.5F + 1.0F);
        float var5 = 1.0F / (var4 + 1.0F);
        float var6 = (float)var3;
        GL11.glScalef(var5 * var6, 1.0F / var5 * var6, var5 * var6);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_6330_a(EntityLiving var1, float var2) {
        this.func_178_a((EntitySlime)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean func_166_a(EntityLiving var1, int var2, float var3) {
        return this.func_179_a((EntitySlime)var1, var2, var3);
    }
}
