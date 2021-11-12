package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderMinecart extends Render {
    protected ModelBase field_20925_a;

    public RenderMinecart() {
        this.field_9246_c = 0.5F;
        this.field_20925_a = new ModelMinecart();
    }

    public void func_152_a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        double var10 = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * (double)var9;
        double var12 = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * (double)var9;
        double var14 = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * (double)var9;
        double var16 = 0.30000001192092896D;
        Vec3D var18 = var1.func_514_g(var10, var12, var14);
        float var19 = var1.field_602_at + (var1.field_604_ar - var1.field_602_at) * var9;
        if (var18 != null) {
            Vec3D var20 = var1.func_515_a(var10, var12, var14, var16);
            Vec3D var21 = var1.func_515_a(var10, var12, var14, -var16);
            if (var20 == null) {
                var20 = var18;
            }

            if (var21 == null) {
                var21 = var18;
            }

            var2 += var18.field_1776_a - var10;
            var4 += (var20.field_1775_b + var21.field_1775_b) / 2.0D - var12;
            var6 += var18.field_1779_c - var14;
            Vec3D var22 = var21.func_1257_c(-var20.field_1776_a, -var20.field_1775_b, -var20.field_1779_c);
            if (var22.func_1253_c() != 0.0D) {
                var22 = var22.func_1252_b();
                var8 = (float)(Math.atan2(var22.field_1779_c, var22.field_1776_a) * 180.0D / 3.141592653589793D);
                var19 = (float)(Math.atan(var22.field_1775_b) * 73.0D);
            }
        }

        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glRotatef(180.0F - var8, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-var19, 0.0F, 0.0F, 1.0F);
        float var23 = (float)var1.field_20911_b - var9;
        float var24 = (float)var1.field_20910_a - var9;
        if (var24 < 0.0F) {
            var24 = 0.0F;
        }

        if (var23 > 0.0F) {
            GL11.glRotatef(MathHelper.func_1106_a(var23) * var23 * var24 / 10.0F * (float)var1.field_20912_c, 1.0F, 0.0F, 0.0F);
        }

        if (var1.field_20913_d != 0) {
            this.func_151_a("/terrain.png");
            float var25 = 0.75F;
            GL11.glScalef(var25, var25, var25);
            GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            if (var1.field_20913_d == 1) {
                (new RenderBlocks()).func_1227_a(Block.field_396_av, 0, var1.func_382_a(var9));
            } else if (var1.field_20913_d == 2) {
                (new RenderBlocks()).func_1227_a(Block.field_445_aC, 0, var1.func_382_a(var9));
            }

            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
            GL11.glScalef(1.0F / var25, 1.0F / var25, 1.0F / var25);
        }

        this.func_151_a("/item/cart.png");
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.field_20925_a.func_864_b(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_152_a((EntityMinecart)var1, var2, var4, var6, var8, var9);
    }
}
