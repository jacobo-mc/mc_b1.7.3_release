package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSheep extends RenderLiving {
    public RenderSheep(ModelBase var1, ModelBase var2, float var3) {
        super(var1, var3);
        this.func_4013_a(var2);
    }

    protected boolean func_176_a(EntitySheep var1, int var2, float var3) {
        if (var2 == 0 && !var1.func_21072_p()) {
            this.func_151_a("/mob/sheep_fur.png");
            float var4 = var1.func_382_a(var3);
            int var5 = var1.func_21074_p_();
            GL11.glColor3f(var4 * EntitySheep.field_21075_a[var5][0], var4 * EntitySheep.field_21075_a[var5][1], var4 * EntitySheep.field_21075_a[var5][2]);
            return true;
        } else {
            return false;
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean func_166_a(EntityLiving var1, int var2, float var3) {
        return this.func_176_a((EntitySheep)var1, var2, var3);
    }
}
