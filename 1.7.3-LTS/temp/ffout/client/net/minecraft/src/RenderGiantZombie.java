package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderGiantZombie extends RenderLiving {
    private float field_204_f;

    public RenderGiantZombie(ModelBase var1, float var2, float var3) {
        super(var1, var2 * var3);
        this.field_204_f = var3;
    }

    protected void func_175_a(EntityGiantZombie var1, float var2) {
        GL11.glScalef(this.field_204_f, this.field_204_f, this.field_204_f);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_6330_a(EntityLiving var1, float var2) {
        this.func_175_a((EntityGiantZombie)var1, var2);
    }
}
