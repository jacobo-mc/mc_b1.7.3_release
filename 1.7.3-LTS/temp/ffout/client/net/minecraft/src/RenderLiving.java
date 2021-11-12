package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class RenderLiving extends Render {
    protected ModelBase field_20920_e;
    protected ModelBase field_6332_f;

    public RenderLiving(ModelBase var1, float var2) {
        this.field_20920_e = var1;
        this.field_9246_c = var2;
    }

    public void func_4013_a(ModelBase var1) {
        this.field_6332_f = var1;
    }

    public void func_171_a(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        this.field_20920_e.field_1244_k = this.func_167_c(var1, var9);
        if (this.field_6332_f != null) {
            this.field_6332_f.field_1244_k = this.field_20920_e.field_1244_k;
        }

        this.field_20920_e.field_1243_l = var1.func_21063_V();
        if (this.field_6332_f != null) {
            this.field_6332_f.field_1243_l = this.field_20920_e.field_1243_l;
        }

        try {
            float var10 = var1.field_734_o + (var1.field_735_n - var1.field_734_o) * var9;
            float var11 = var1.field_603_as + (var1.field_605_aq - var1.field_603_as) * var9;
            float var12 = var1.field_602_at + (var1.field_604_ar - var1.field_602_at) * var9;
            this.func_22012_b(var1, var2, var4, var6);
            float var13 = this.func_170_d(var1, var9);
            this.func_21004_a(var1, var13, var10, var9);
            float var14 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(-1.0F, -1.0F, 1.0F);
            this.func_6330_a(var1, var9);
            GL11.glTranslatef(0.0F, -24.0F * var14 - 0.0078125F, 0.0F);
            float var15 = var1.field_705_Q + (var1.field_704_R - var1.field_705_Q) * var9;
            float var16 = var1.field_703_S - var1.field_704_R * (1.0F - var9);
            if (var15 > 1.0F) {
                var15 = 1.0F;
            }

            this.func_140_a(var1.field_20047_bv, var1.func_6376_z());
            GL11.glEnable(3008);
            this.field_20920_e.func_25103_a(var1, var16, var15, var9);
            this.field_20920_e.func_864_b(var16, var15, var13, var11 - var10, var12, var14);

            for(int var17 = 0; var17 < 4; ++var17) {
                if (this.func_166_a(var1, var17, var9)) {
                    this.field_6332_f.func_864_b(var16, var15, var13, var11 - var10, var12, var14);
                    GL11.glDisable(3042);
                    GL11.glEnable(3008);
                }
            }

            this.func_6331_b(var1, var9);
            float var25 = var1.func_382_a(var9);
            int var18 = this.func_173_a(var1, var25, var9);
            if ((var18 >> 24 & 255) > 0 || var1.field_715_G > 0 || var1.field_712_J > 0) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if (var1.field_715_G > 0 || var1.field_712_J > 0) {
                    GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
                    this.field_20920_e.func_864_b(var16, var15, var13, var11 - var10, var12, var14);

                    for(int var19 = 0; var19 < 4; ++var19) {
                        if (this.func_27005_b(var1, var19, var9)) {
                            GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
                            this.field_6332_f.func_864_b(var16, var15, var13, var11 - var10, var12, var14);
                        }
                    }
                }

                if ((var18 >> 24 & 255) > 0) {
                    float var26 = (float)(var18 >> 16 & 255) / 255.0F;
                    float var20 = (float)(var18 >> 8 & 255) / 255.0F;
                    float var21 = (float)(var18 & 255) / 255.0F;
                    float var22 = (float)(var18 >> 24 & 255) / 255.0F;
                    GL11.glColor4f(var26, var20, var21, var22);
                    this.field_20920_e.func_864_b(var16, var15, var13, var11 - var10, var12, var14);

                    for(int var23 = 0; var23 < 4; ++var23) {
                        if (this.func_27005_b(var1, var23, var9)) {
                            GL11.glColor4f(var26, var20, var21, var22);
                            this.field_6332_f.func_864_b(var16, var15, var13, var11 - var10, var12, var14);
                        }
                    }
                }

                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }

            GL11.glDisable(32826);
        } catch (Exception var24) {
            var24.printStackTrace();
        }

        GL11.glEnable(2884);
        GL11.glPopMatrix();
        this.func_22014_a(var1, var2, var4, var6);
    }

    protected void func_22012_b(EntityLiving var1, double var2, double var4, double var6) {
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
    }

    protected void func_21004_a(EntityLiving var1, float var2, float var3, float var4) {
        GL11.glRotatef(180.0F - var3, 0.0F, 1.0F, 0.0F);
        if (var1.field_712_J > 0) {
            float var5 = ((float)var1.field_712_J + var4 - 1.0F) / 20.0F * 1.6F;
            var5 = MathHelper.func_1113_c(var5);
            if (var5 > 1.0F) {
                var5 = 1.0F;
            }

            GL11.glRotatef(var5 * this.func_172_a(var1), 0.0F, 0.0F, 1.0F);
        }

    }

    protected float func_167_c(EntityLiving var1, float var2) {
        return var1.func_431_d(var2);
    }

    protected float func_170_d(EntityLiving var1, float var2) {
        return (float)var1.field_9311_be + var2;
    }

    protected void func_6331_b(EntityLiving var1, float var2) {
    }

    protected boolean func_27005_b(EntityLiving var1, int var2, float var3) {
        return this.func_166_a(var1, var2, var3);
    }

    protected boolean func_166_a(EntityLiving var1, int var2, float var3) {
        return false;
    }

    protected float func_172_a(EntityLiving var1) {
        return 90.0F;
    }

    protected int func_173_a(EntityLiving var1, float var2, float var3) {
        return 0;
    }

    protected void func_6330_a(EntityLiving var1, float var2) {
    }

    protected void func_22014_a(EntityLiving var1, double var2, double var4, double var6) {
        if (Minecraft.func_22007_w()) {
            this.func_22013_a(var1, Integer.toString(var1.field_620_ab), var2, var4, var6, 64);
        }

    }

    protected void func_22013_a(EntityLiving var1, String var2, double var3, double var5, double var7, int var9) {
        float var10 = var1.func_379_d(this.field_191_a.field_22188_h);
        if (var10 <= (float)var9) {
            FontRenderer var11 = this.func_6329_a();
            float var12 = 1.6F;
            float var13 = 0.016666668F * var12;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)var3 + 0.0F, (float)var5 + 2.3F, (float)var7);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-var13, -var13, var13);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            Tessellator var14 = Tessellator.field_1512_a;
            byte var15 = 0;
            if (var2.equals("deadmau5")) {
                var15 = -10;
            }

            GL11.glDisable(3553);
            var14.func_977_b();
            int var16 = var11.func_871_a(var2) / 2;
            var14.func_986_a(0.0F, 0.0F, 0.0F, 0.25F);
            var14.func_991_a((double)(-var16 - 1), (double)(-1 + var15), 0.0D);
            var14.func_991_a((double)(-var16 - 1), (double)(8 + var15), 0.0D);
            var14.func_991_a((double)(var16 + 1), (double)(8 + var15), 0.0D);
            var14.func_991_a((double)(var16 + 1), (double)(-1 + var15), 0.0D);
            var14.func_982_a();
            GL11.glEnable(3553);
            var11.func_873_b(var2, -var11.func_871_a(var2) / 2, var15, 553648127);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            var11.func_873_b(var2, -var11.func_871_a(var2) / 2, var15, -1);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
        }
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_171_a((EntityLiving)var1, var2, var4, var6, var8, var9);
    }
}
