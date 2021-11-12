package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public abstract class Render {
    protected RenderManager field_191_a;
    private ModelBase field_195_d = new ModelBiped();
    private RenderBlocks field_203_d = new RenderBlocks();
    protected float field_9246_c = 0.0F;
    protected float field_194_c = 1.0F;

    public abstract void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9);

    protected void func_151_a(String var1) {
        RenderEngine var2 = this.field_191_a.field_1229_e;
        var2.func_1076_b(var2.func_1070_a(var1));
    }

    protected boolean func_140_a(String var1, String var2) {
        RenderEngine var3 = this.field_191_a.field_1229_e;
        int var4 = var3.func_1071_a(var1, var2);
        if (var4 >= 0) {
            var3.func_1076_b(var4);
            return true;
        } else {
            return false;
        }
    }

    private void func_148_a(Entity var1, double var2, double var4, double var6, float var8) {
        GL11.glDisable(2896);
        int var9 = Block.field_402_as.field_378_bb;
        int var10 = (var9 & 15) << 4;
        int var11 = var9 & 240;
        float var12 = (float)var10 / 256.0F;
        float var13 = ((float)var10 + 15.99F) / 256.0F;
        float var14 = (float)var11 / 256.0F;
        float var15 = ((float)var11 + 15.99F) / 256.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        float var16 = var1.field_644_aC * 1.4F;
        GL11.glScalef(var16, var16, var16);
        this.func_151_a("/terrain.png");
        Tessellator var17 = Tessellator.field_1512_a;
        float var18 = 0.5F;
        float var19 = 0.0F;
        float var20 = var1.field_643_aD / var16;
        float var21 = (float)(var1.field_610_al - var1.field_601_au.field_1697_b);
        GL11.glRotatef(-this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.0F, -0.3F + (float)((int)var20) * 0.02F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float var22 = 0.0F;
        int var23 = 0;
        var17.func_977_b();

        while(var20 > 0.0F) {
            if (var23 % 2 == 0) {
                var12 = (float)var10 / 256.0F;
                var13 = ((float)var10 + 15.99F) / 256.0F;
                var14 = (float)var11 / 256.0F;
                var15 = ((float)var11 + 15.99F) / 256.0F;
            } else {
                var12 = (float)var10 / 256.0F;
                var13 = ((float)var10 + 15.99F) / 256.0F;
                var14 = (float)(var11 + 16) / 256.0F;
                var15 = ((float)(var11 + 16) + 15.99F) / 256.0F;
            }

            if (var23 / 2 % 2 == 0) {
                float var24 = var13;
                var13 = var12;
                var12 = var24;
            }

            var17.func_983_a((double)(var18 - var19), (double)(0.0F - var21), (double)var22, (double)var13, (double)var15);
            var17.func_983_a((double)(-var18 - var19), (double)(0.0F - var21), (double)var22, (double)var12, (double)var15);
            var17.func_983_a((double)(-var18 - var19), (double)(1.4F - var21), (double)var22, (double)var12, (double)var14);
            var17.func_983_a((double)(var18 - var19), (double)(1.4F - var21), (double)var22, (double)var13, (double)var14);
            var20 -= 0.45F;
            var21 -= 0.45F;
            var18 *= 0.9F;
            var22 += 0.03F;
            ++var23;
        }

        var17.func_982_a();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void func_144_c(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderEngine var10 = this.field_191_a.field_1229_e;
        var10.func_1076_b(var10.func_1070_a("%clamp%/misc/shadow.png"));
        World var11 = this.func_149_b();
        GL11.glDepthMask(false);
        float var12 = this.field_9246_c;
        double var13 = var1.field_638_aI + (var1.field_611_ak - var1.field_638_aI) * (double)var9;
        double var15 = var1.field_637_aJ + (var1.field_610_al - var1.field_637_aJ) * (double)var9 + (double)var1.func_392_h_();
        double var17 = var1.field_636_aK + (var1.field_609_am - var1.field_636_aK) * (double)var9;
        int var19 = MathHelper.func_1108_b(var13 - (double)var12);
        int var20 = MathHelper.func_1108_b(var13 + (double)var12);
        int var21 = MathHelper.func_1108_b(var15 - (double)var12);
        int var22 = MathHelper.func_1108_b(var15);
        int var23 = MathHelper.func_1108_b(var17 - (double)var12);
        int var24 = MathHelper.func_1108_b(var17 + (double)var12);
        double var25 = var2 - var13;
        double var27 = var4 - var15;
        double var29 = var6 - var17;
        Tessellator var31 = Tessellator.field_1512_a;
        var31.func_977_b();

        for(int var32 = var19; var32 <= var20; ++var32) {
            for(int var33 = var21; var33 <= var22; ++var33) {
                for(int var34 = var23; var34 <= var24; ++var34) {
                    int var35 = var11.func_600_a(var32, var33 - 1, var34);
                    if (var35 > 0 && var11.func_618_j(var32, var33, var34) > 3) {
                        this.func_145_a(Block.field_345_n[var35], var2, var4 + (double)var1.func_392_h_(), var6, var32, var33, var34, var8, var12, var25, var27 + (double)var1.func_392_h_(), var29);
                    }
                }
            }
        }

        var31.func_982_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    private World func_149_b() {
        return this.field_191_a.field_1227_g;
    }

    private void func_145_a(Block var1, double var2, double var4, double var6, int var8, int var9, int var10, float var11, float var12, double var13, double var15, double var17) {
        Tessellator var19 = Tessellator.field_1512_a;
        if (var1.func_242_c()) {
            double var20 = ((double)var11 - (var4 - ((double)var9 + var15)) / 2.0D) * 0.5D * (double)this.func_149_b().func_598_c(var8, var9, var10);
            if (var20 >= 0.0D) {
                if (var20 > 1.0D) {
                    var20 = 1.0D;
                }

                var19.func_986_a(1.0F, 1.0F, 1.0F, (float)var20);
                double var22 = (double)var8 + var1.field_370_bf + var13;
                double var24 = (double)var8 + var1.field_364_bi + var13;
                double var26 = (double)var9 + var1.field_368_bg + var15 + 0.015625D;
                double var28 = (double)var10 + var1.field_366_bh + var17;
                double var30 = (double)var10 + var1.field_360_bk + var17;
                float var32 = (float)((var2 - var22) / 2.0D / (double)var12 + 0.5D);
                float var33 = (float)((var2 - var24) / 2.0D / (double)var12 + 0.5D);
                float var34 = (float)((var6 - var28) / 2.0D / (double)var12 + 0.5D);
                float var35 = (float)((var6 - var30) / 2.0D / (double)var12 + 0.5D);
                var19.func_983_a(var22, var26, var28, (double)var32, (double)var34);
                var19.func_983_a(var22, var26, var30, (double)var32, (double)var35);
                var19.func_983_a(var24, var26, var30, (double)var33, (double)var35);
                var19.func_983_a(var24, var26, var28, (double)var33, (double)var34);
            }
        }
    }

    public static void func_146_a(AxisAlignedBB var0, double var1, double var3, double var5) {
        GL11.glDisable(3553);
        Tessellator var7 = Tessellator.field_1512_a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        var7.func_977_b();
        var7.func_984_b(var1, var3, var5);
        var7.func_980_b(0.0F, 0.0F, -1.0F);
        var7.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1704_c);
        var7.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1704_c);
        var7.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1704_c);
        var7.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1704_c);
        var7.func_980_b(0.0F, 0.0F, 1.0F);
        var7.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1701_f);
        var7.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1701_f);
        var7.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1701_f);
        var7.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1701_f);
        var7.func_980_b(0.0F, -1.0F, 0.0F);
        var7.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1704_c);
        var7.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1704_c);
        var7.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1701_f);
        var7.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1701_f);
        var7.func_980_b(0.0F, 1.0F, 0.0F);
        var7.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1701_f);
        var7.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1701_f);
        var7.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1704_c);
        var7.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1704_c);
        var7.func_980_b(-1.0F, 0.0F, 0.0F);
        var7.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1701_f);
        var7.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1701_f);
        var7.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1704_c);
        var7.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1704_c);
        var7.func_980_b(1.0F, 0.0F, 0.0F);
        var7.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1704_c);
        var7.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1704_c);
        var7.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1701_f);
        var7.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1701_f);
        var7.func_984_b(0.0D, 0.0D, 0.0D);
        var7.func_982_a();
        GL11.glEnable(3553);
    }

    public static void func_142_a(AxisAlignedBB var0) {
        Tessellator var1 = Tessellator.field_1512_a;
        var1.func_977_b();
        var1.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1704_c);
        var1.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1704_c);
        var1.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1701_f);
        var1.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1701_f);
        var1.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1701_f);
        var1.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1701_f);
        var1.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1701_f);
        var1.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1701_f);
        var1.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1701_f);
        var1.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1701_f);
        var1.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1704_c);
        var1.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1704_c);
        var1.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1701_f);
        var1.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1701_f);
        var1.func_991_a(var0.field_1698_a, var0.field_1702_e, var0.field_1704_c);
        var1.func_991_a(var0.field_1698_a, var0.field_1697_b, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1704_c);
        var1.func_991_a(var0.field_1703_d, var0.field_1702_e, var0.field_1701_f);
        var1.func_991_a(var0.field_1703_d, var0.field_1697_b, var0.field_1701_f);
        var1.func_982_a();
    }

    public void func_4009_a(RenderManager var1) {
        this.field_191_a = var1;
    }

    public void func_141_b(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        if (this.field_191_a.field_1223_k.field_1576_i && this.field_9246_c > 0.0F) {
            double var10 = this.field_191_a.func_851_a(var1.field_611_ak, var1.field_610_al, var1.field_609_am);
            float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.field_194_c);
            if (var12 > 0.0F) {
                this.func_144_c(var1, var2, var4, var6, var12, var9);
            }
        }

        if (var1.func_21062_U()) {
            this.func_148_a(var1, var2, var4, var6, var9);
        }

    }

    public FontRenderer func_6329_a() {
        return this.field_191_a.func_6500_a();
    }
}
