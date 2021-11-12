package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderBiped extends RenderLiving {
    protected ModelBiped field_4013_a;

    public RenderBiped(ModelBiped var1, float var2) {
        super(var1, var2);
        this.field_4013_a = var1;
    }

    protected void func_6331_b(EntityLiving var1, float var2) {
        ItemStack var3 = var1.func_4045_l();
        if (var3 != null) {
            GL11.glPushMatrix();
            this.field_4013_a.field_1283_d.func_926_b(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            float var4;
            if (var3.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var3.field_1617_c].func_210_f())) {
                var4 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                var4 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(var4, -var4, var4);
            } else if (Item.field_233_c[var3.field_1617_c].func_4017_a()) {
                var4 = 0.625F;
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(var4, -var4, var4);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            } else {
                var4 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(var4, var4, var4);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.field_191_a.field_4236_f.func_4132_a(var1, var3);
            GL11.glPopMatrix();
        }

    }
}
