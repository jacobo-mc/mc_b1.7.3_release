package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class RenderPlayer extends RenderLiving {
    private ModelBiped field_209_f;
    private ModelBiped field_208_g;
    private ModelBiped field_207_h;
    private static final String[] field_206_i = new String[]{"cloth", "chain", "iron", "diamond", "gold"};

    public RenderPlayer() {
        super(new ModelBiped(0.0F), 0.5F);
        this.field_209_f = (ModelBiped)this.field_20920_e;
        this.field_208_g = new ModelBiped(1.0F);
        this.field_207_h = new ModelBiped(0.5F);
    }

    protected boolean func_187_a(EntityPlayer var1, int var2, float var3) {
        ItemStack var4 = var1.field_778_b.func_492_d(3 - var2);
        if (var4 != null) {
            Item var5 = var4.func_1091_a();
            if (var5 instanceof ItemArmor) {
                ItemArmor var6 = (ItemArmor)var5;
                this.func_151_a("/armor/" + field_206_i[var6.field_311_aZ] + "_" + (var2 == 2 ? 2 : 1) + ".png");
                ModelBiped var7 = var2 == 2 ? this.field_207_h : this.field_208_g;
                var7.field_1286_a.field_1403_h = var2 == 0;
                var7.field_1285_b.field_1403_h = var2 == 0;
                var7.field_1284_c.field_1403_h = var2 == 1 || var2 == 2;
                var7.field_1283_d.field_1403_h = var2 == 1;
                var7.field_1282_e.field_1403_h = var2 == 1;
                var7.field_1281_f.field_1403_h = var2 == 2 || var2 == 3;
                var7.field_1280_g.field_1403_h = var2 == 2 || var2 == 3;
                this.func_4013_a(var7);
                return true;
            }
        }

        return false;
    }

    public void func_188_a(EntityPlayer var1, double var2, double var4, double var6, float var8, float var9) {
        ItemStack var10 = var1.field_778_b.func_494_a();
        this.field_208_g.field_1278_i = this.field_207_h.field_1278_i = this.field_209_f.field_1278_i = var10 != null;
        this.field_208_g.field_1277_j = this.field_207_h.field_1277_j = this.field_209_f.field_1277_j = var1.func_381_o();
        double var11 = var4 - (double)var1.field_9292_aO;
        if (var1.func_381_o() && !(var1 instanceof EntityPlayerSP)) {
            var11 -= 0.125D;
        }

        super.func_171_a(var1, var2, var11, var6, var8, var9);
        this.field_208_g.field_1277_j = this.field_207_h.field_1277_j = this.field_209_f.field_1277_j = false;
        this.field_208_g.field_1278_i = this.field_207_h.field_1278_i = this.field_209_f.field_1278_i = false;
    }

    protected void func_22015_a(EntityPlayer var1, double var2, double var4, double var6) {
        if (Minecraft.func_22006_t() && var1 != this.field_191_a.field_22188_h) {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            float var10 = var1.func_379_d(this.field_191_a.field_22188_h);
            float var11 = var1.func_381_o() ? 32.0F : 64.0F;
            if (var10 < var11) {
                String var12 = var1.field_771_i;
                if (!var1.func_381_o()) {
                    if (var1.func_22051_K()) {
                        this.func_22013_a(var1, var12, var2, var4 - 1.5D, var6, 64);
                    } else {
                        this.func_22013_a(var1, var12, var2, var4, var6, 64);
                    }
                } else {
                    FontRenderer var13 = this.func_6329_a();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + 2.3F, (float)var6);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
                    GL11.glScalef(-var9, -var9, var9);
                    GL11.glDisable(2896);
                    GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    Tessellator var14 = Tessellator.field_1512_a;
                    GL11.glDisable(3553);
                    var14.func_977_b();
                    int var15 = var13.func_871_a(var12) / 2;
                    var14.func_986_a(0.0F, 0.0F, 0.0F, 0.25F);
                    var14.func_991_a((double)(-var15 - 1), -1.0D, 0.0D);
                    var14.func_991_a((double)(-var15 - 1), 8.0D, 0.0D);
                    var14.func_991_a((double)(var15 + 1), 8.0D, 0.0D);
                    var14.func_991_a((double)(var15 + 1), -1.0D, 0.0D);
                    var14.func_982_a();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    var13.func_873_b(var12, -var13.func_871_a(var12) / 2, 0, 553648127);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glPopMatrix();
                }
            }
        }

    }

    protected void func_4015_a(EntityPlayer var1, float var2) {
        ItemStack var3 = var1.field_778_b.func_492_d(3);
        if (var3 != null && var3.func_1091_a().field_291_aS < 256) {
            GL11.glPushMatrix();
            this.field_209_f.field_1286_a.func_926_b(0.0625F);
            if (RenderBlocks.func_1219_a(Block.field_345_n[var3.field_1617_c].func_210_f())) {
                float var4 = 0.625F;
                GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(var4, -var4, var4);
            }

            this.field_191_a.field_4236_f.func_4132_a(var1, var3);
            GL11.glPopMatrix();
        }

        float var5;
        if (var1.field_771_i.equals("deadmau5") && this.func_140_a(var1.field_20047_bv, (String)null)) {
            for(int var19 = 0; var19 < 2; ++var19) {
                var5 = var1.field_603_as + (var1.field_605_aq - var1.field_603_as) * var2 - (var1.field_734_o + (var1.field_735_n - var1.field_734_o) * var2);
                float var6 = var1.field_602_at + (var1.field_604_ar - var1.field_602_at) * var2;
                GL11.glPushMatrix();
                GL11.glRotatef(var5, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(var6, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.375F * (float)(var19 * 2 - 1), 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.375F, 0.0F);
                GL11.glRotatef(-var6, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-var5, 0.0F, 1.0F, 0.0F);
                float var7 = 1.3333334F;
                GL11.glScalef(var7, var7, var7);
                this.field_209_f.func_20095_a(0.0625F);
                GL11.glPopMatrix();
            }
        }

        if (this.func_140_a(var1.field_20067_q, (String)null)) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
            double var20 = var1.field_20066_r + (var1.field_20063_u - var1.field_20066_r) * (double)var2 - (var1.field_9285_at + (var1.field_611_ak - var1.field_9285_at) * (double)var2);
            double var22 = var1.field_20065_s + (var1.field_20062_v - var1.field_20065_s) * (double)var2 - (var1.field_9284_au + (var1.field_610_al - var1.field_9284_au) * (double)var2);
            double var8 = var1.field_20064_t + (var1.field_20061_w - var1.field_20064_t) * (double)var2 - (var1.field_9283_av + (var1.field_609_am - var1.field_9283_av) * (double)var2);
            float var10 = var1.field_734_o + (var1.field_735_n - var1.field_734_o) * var2;
            double var11 = (double)MathHelper.func_1106_a(var10 * 3.1415927F / 180.0F);
            double var13 = (double)(-MathHelper.func_1114_b(var10 * 3.1415927F / 180.0F));
            float var15 = (float)var22 * 10.0F;
            if (var15 < -6.0F) {
                var15 = -6.0F;
            }

            if (var15 > 32.0F) {
                var15 = 32.0F;
            }

            float var16 = (float)(var20 * var11 + var8 * var13) * 100.0F;
            float var17 = (float)(var20 * var13 - var8 * var11) * 100.0F;
            if (var16 < 0.0F) {
                var16 = 0.0F;
            }

            float var18 = var1.field_775_e + (var1.field_774_f - var1.field_775_e) * var2;
            var15 += MathHelper.func_1106_a((var1.field_9291_aR + (var1.field_9290_aS - var1.field_9291_aR) * var2) * 6.0F) * 32.0F * var18;
            if (var1.func_381_o()) {
                var15 += 25.0F;
            }

            GL11.glRotatef(6.0F + var16 / 2.0F + var15, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var17 / 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-var17 / 2.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            this.field_209_f.func_20096_b(0.0625F);
            GL11.glPopMatrix();
        }

        ItemStack var21 = var1.field_778_b.func_494_a();
        if (var21 != null) {
            GL11.glPushMatrix();
            this.field_209_f.field_1283_d.func_926_b(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if (var1.field_4128_n != null) {
                var21 = new ItemStack(Item.field_266_B);
            }

            if (var21.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var21.field_1617_c].func_210_f())) {
                var5 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                var5 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(var5, -var5, var5);
            } else if (Item.field_233_c[var21.field_1617_c].func_4017_a()) {
                var5 = 0.625F;
                if (Item.field_233_c[var21.field_1617_c].func_4023_b()) {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(var5, -var5, var5);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            } else {
                var5 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(var5, var5, var5);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.field_191_a.field_4236_f.func_4132_a(var1, var21);
            GL11.glPopMatrix();
        }

    }

    protected void func_186_b(EntityPlayer var1, float var2) {
        float var3 = 0.9375F;
        GL11.glScalef(var3, var3, var3);
    }

    public void func_185_b() {
        this.field_209_f.field_1244_k = 0.0F;
        this.field_209_f.func_863_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        this.field_209_f.field_1283_d.func_922_a(0.0625F);
    }

    protected void func_22016_b(EntityPlayer var1, double var2, double var4, double var6) {
        if (var1.func_354_B() && var1.func_22051_K()) {
            super.func_22012_b(var1, var2 + (double)var1.field_22063_x, var4 + (double)var1.field_22062_y, var6 + (double)var1.field_22061_z);
        } else {
            super.func_22012_b(var1, var2, var4, var6);
        }

    }

    protected void func_22017_a(EntityPlayer var1, float var2, float var3, float var4) {
        if (var1.func_354_B() && var1.func_22051_K()) {
            GL11.glRotatef(var1.func_22059_J(), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(this.func_172_a(var1), 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
        } else {
            super.func_21004_a(var1, var2, var3, var4);
        }

    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_22014_a(EntityLiving var1, double var2, double var4, double var6) {
        this.func_22015_a((EntityPlayer)var1, var2, var4, var6);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_6330_a(EntityLiving var1, float var2) {
        this.func_186_b((EntityPlayer)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected boolean func_166_a(EntityLiving var1, int var2, float var3) {
        return this.func_187_a((EntityPlayer)var1, var2, var3);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_6331_b(EntityLiving var1, float var2) {
        this.func_4015_a((EntityPlayer)var1, var2);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_21004_a(EntityLiving var1, float var2, float var3, float var4) {
        this.func_22017_a((EntityPlayer)var1, var2, var3, var4);
    }

    // $FF: synthetic method
    // $FF: bridge method
    protected void func_22012_b(EntityLiving var1, double var2, double var4, double var6) {
        this.func_22016_b((EntityPlayer)var1, var2, var4, var6);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_171_a(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_188_a((EntityPlayer)var1, var2, var4, var6, var8, var9);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_188_a((EntityPlayer)var1, var2, var4, var6, var8, var9);
    }
}
