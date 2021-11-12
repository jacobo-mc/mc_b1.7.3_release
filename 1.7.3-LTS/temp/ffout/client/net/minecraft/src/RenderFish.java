package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderFish extends Render {
    public void func_4011_a(EntityFish var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        byte var10 = 1;
        byte var11 = 2;
        this.func_151_a("/particles.png");
        Tessellator var12 = Tessellator.field_1512_a;
        float var13 = (float)(var10 * 8 + 0) / 128.0F;
        float var14 = (float)(var10 * 8 + 8) / 128.0F;
        float var15 = (float)(var11 * 8 + 0) / 128.0F;
        float var16 = (float)(var11 * 8 + 8) / 128.0F;
        float var17 = 1.0F;
        float var18 = 0.5F;
        float var19 = 0.5F;
        GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
        var12.func_977_b();
        var12.func_980_b(0.0F, 1.0F, 0.0F);
        var12.func_983_a((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
        var12.func_983_a((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
        var12.func_983_a((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
        var12.func_983_a((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
        var12.func_982_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        if (var1.field_4097_b != null) {
            float var20 = (var1.field_4097_b.field_603_as + (var1.field_4097_b.field_605_aq - var1.field_4097_b.field_603_as) * var9) * 3.1415927F / 180.0F;
            double var21 = (double)MathHelper.func_1106_a(var20);
            double var23 = (double)MathHelper.func_1114_b(var20);
            float var25 = var1.field_4097_b.func_431_d(var9);
            float var26 = MathHelper.func_1106_a(MathHelper.func_1113_c(var25) * 3.1415927F);
            Vec3D var27 = Vec3D.func_1248_b(-0.5D, 0.03D, 0.8D);
            var27.func_1258_a(-(var1.field_4097_b.field_602_at + (var1.field_4097_b.field_604_ar - var1.field_4097_b.field_602_at) * var9) * 3.1415927F / 180.0F);
            var27.func_1249_b(-(var1.field_4097_b.field_603_as + (var1.field_4097_b.field_605_aq - var1.field_4097_b.field_603_as) * var9) * 3.1415927F / 180.0F);
            var27.func_1249_b(var26 * 0.5F);
            var27.func_1258_a(-var26 * 0.7F);
            double var28 = var1.field_4097_b.field_9285_at + (var1.field_4097_b.field_611_ak - var1.field_4097_b.field_9285_at) * (double)var9 + var27.field_1776_a;
            double var30 = var1.field_4097_b.field_9284_au + (var1.field_4097_b.field_610_al - var1.field_4097_b.field_9284_au) * (double)var9 + var27.field_1775_b;
            double var32 = var1.field_4097_b.field_9283_av + (var1.field_4097_b.field_609_am - var1.field_4097_b.field_9283_av) * (double)var9 + var27.field_1779_c;
            if (this.field_191_a.field_1223_k.field_1560_x) {
                var20 = (var1.field_4097_b.field_734_o + (var1.field_4097_b.field_735_n - var1.field_4097_b.field_734_o) * var9) * 3.1415927F / 180.0F;
                var21 = (double)MathHelper.func_1106_a(var20);
                var23 = (double)MathHelper.func_1114_b(var20);
                var28 = var1.field_4097_b.field_9285_at + (var1.field_4097_b.field_611_ak - var1.field_4097_b.field_9285_at) * (double)var9 - var23 * 0.35D - var21 * 0.85D;
                var30 = var1.field_4097_b.field_9284_au + (var1.field_4097_b.field_610_al - var1.field_4097_b.field_9284_au) * (double)var9 - 0.45D;
                var32 = var1.field_4097_b.field_9283_av + (var1.field_4097_b.field_609_am - var1.field_4097_b.field_9283_av) * (double)var9 - var21 * 0.35D + var23 * 0.85D;
            }

            double var34 = var1.field_9285_at + (var1.field_611_ak - var1.field_9285_at) * (double)var9;
            double var36 = var1.field_9284_au + (var1.field_610_al - var1.field_9284_au) * (double)var9 + 0.25D;
            double var38 = var1.field_9283_av + (var1.field_609_am - var1.field_9283_av) * (double)var9;
            double var40 = (double)((float)(var28 - var34));
            double var42 = (double)((float)(var30 - var36));
            double var44 = (double)((float)(var32 - var38));
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            var12.func_992_a(3);
            var12.func_990_b(0);
            byte var46 = 16;

            for(int var47 = 0; var47 <= var46; ++var47) {
                float var48 = (float)var47 / (float)var46;
                var12.func_991_a(var2 + var40 * (double)var48, var4 + var42 * (double)(var48 * var48 + var48) * 0.5D + 0.25D, var6 + var44 * (double)var48);
            }

            var12.func_982_a();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }

    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_4011_a((EntityFish)var1, var2, var4, var6, var8, var9);
    }
}
