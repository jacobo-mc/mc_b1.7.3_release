package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ItemRenderer {
    private Minecraft field_1356_a;
    private ItemStack field_9451_b = null;
    private float field_9453_c = 0.0F;
    private float field_9452_d = 0.0F;
    private RenderBlocks field_1357_e = new RenderBlocks();
    private MapItemRenderer field_28131_f;
    private int field_20099_f = -1;

    public ItemRenderer(Minecraft var1) {
        this.field_1356_a = var1;
        this.field_28131_f = new MapItemRenderer(var1.field_6314_o, var1.field_6304_y, var1.field_6315_n);
    }

    public void func_4132_a(EntityLiving var1, ItemStack var2) {
        GL11.glPushMatrix();
        if (var2.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var2.field_1617_c].func_210_f())) {
            GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1070_a("/terrain.png"));
            this.field_1357_e.func_1227_a(Block.field_345_n[var2.field_1617_c], var2.func_21181_i(), var1.func_382_a(1.0F));
        } else {
            if (var2.field_1617_c < 256) {
                GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1070_a("/terrain.png"));
            } else {
                GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1070_a("/gui/items.png"));
            }

            Tessellator var3 = Tessellator.field_1512_a;
            int var4 = var1.func_28021_c(var2);
            float var5 = ((float)(var4 % 16 * 16) + 0.0F) / 256.0F;
            float var6 = ((float)(var4 % 16 * 16) + 15.99F) / 256.0F;
            float var7 = ((float)(var4 / 16 * 16) + 0.0F) / 256.0F;
            float var8 = ((float)(var4 / 16 * 16) + 15.99F) / 256.0F;
            float var9 = 1.0F;
            float var10 = 0.0F;
            float var11 = 0.3F;
            GL11.glEnable(32826);
            GL11.glTranslatef(-var10, -var11, 0.0F);
            float var12 = 1.5F;
            GL11.glScalef(var12, var12, var12);
            GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
            float var13 = 0.0625F;
            var3.func_977_b();
            var3.func_980_b(0.0F, 0.0F, 1.0F);
            var3.func_983_a(0.0D, 0.0D, 0.0D, (double)var6, (double)var8);
            var3.func_983_a((double)var9, 0.0D, 0.0D, (double)var5, (double)var8);
            var3.func_983_a((double)var9, 1.0D, 0.0D, (double)var5, (double)var7);
            var3.func_983_a(0.0D, 1.0D, 0.0D, (double)var6, (double)var7);
            var3.func_982_a();
            var3.func_977_b();
            var3.func_980_b(0.0F, 0.0F, -1.0F);
            var3.func_983_a(0.0D, 1.0D, (double)(0.0F - var13), (double)var6, (double)var7);
            var3.func_983_a((double)var9, 1.0D, (double)(0.0F - var13), (double)var5, (double)var7);
            var3.func_983_a((double)var9, 0.0D, (double)(0.0F - var13), (double)var5, (double)var8);
            var3.func_983_a(0.0D, 0.0D, (double)(0.0F - var13), (double)var6, (double)var8);
            var3.func_982_a();
            var3.func_977_b();
            var3.func_980_b(-1.0F, 0.0F, 0.0F);

            int var14;
            float var15;
            float var16;
            float var17;
            for(var14 = 0; var14 < 16; ++var14) {
                var15 = (float)var14 / 16.0F;
                var16 = var6 + (var5 - var6) * var15 - 0.001953125F;
                var17 = var9 * var15;
                var3.func_983_a((double)var17, 0.0D, (double)(0.0F - var13), (double)var16, (double)var8);
                var3.func_983_a((double)var17, 0.0D, 0.0D, (double)var16, (double)var8);
                var3.func_983_a((double)var17, 1.0D, 0.0D, (double)var16, (double)var7);
                var3.func_983_a((double)var17, 1.0D, (double)(0.0F - var13), (double)var16, (double)var7);
            }

            var3.func_982_a();
            var3.func_977_b();
            var3.func_980_b(1.0F, 0.0F, 0.0F);

            for(var14 = 0; var14 < 16; ++var14) {
                var15 = (float)var14 / 16.0F;
                var16 = var6 + (var5 - var6) * var15 - 0.001953125F;
                var17 = var9 * var15 + 0.0625F;
                var3.func_983_a((double)var17, 1.0D, (double)(0.0F - var13), (double)var16, (double)var7);
                var3.func_983_a((double)var17, 1.0D, 0.0D, (double)var16, (double)var7);
                var3.func_983_a((double)var17, 0.0D, 0.0D, (double)var16, (double)var8);
                var3.func_983_a((double)var17, 0.0D, (double)(0.0F - var13), (double)var16, (double)var8);
            }

            var3.func_982_a();
            var3.func_977_b();
            var3.func_980_b(0.0F, 1.0F, 0.0F);

            for(var14 = 0; var14 < 16; ++var14) {
                var15 = (float)var14 / 16.0F;
                var16 = var8 + (var7 - var8) * var15 - 0.001953125F;
                var17 = var9 * var15 + 0.0625F;
                var3.func_983_a(0.0D, (double)var17, 0.0D, (double)var6, (double)var16);
                var3.func_983_a((double)var9, (double)var17, 0.0D, (double)var5, (double)var16);
                var3.func_983_a((double)var9, (double)var17, (double)(0.0F - var13), (double)var5, (double)var16);
                var3.func_983_a(0.0D, (double)var17, (double)(0.0F - var13), (double)var6, (double)var16);
            }

            var3.func_982_a();
            var3.func_977_b();
            var3.func_980_b(0.0F, -1.0F, 0.0F);

            for(var14 = 0; var14 < 16; ++var14) {
                var15 = (float)var14 / 16.0F;
                var16 = var8 + (var7 - var8) * var15 - 0.001953125F;
                var17 = var9 * var15;
                var3.func_983_a((double)var9, (double)var17, 0.0D, (double)var5, (double)var16);
                var3.func_983_a(0.0D, (double)var17, 0.0D, (double)var6, (double)var16);
                var3.func_983_a(0.0D, (double)var17, (double)(0.0F - var13), (double)var6, (double)var16);
                var3.func_983_a((double)var9, (double)var17, (double)(0.0F - var13), (double)var5, (double)var16);
            }

            var3.func_982_a();
            GL11.glDisable(32826);
        }

        GL11.glPopMatrix();
    }

    public void func_4133_a(float var1) {
        float var2 = this.field_9452_d + (this.field_9453_c - this.field_9452_d) * var1;
        EntityPlayerSP var3 = this.field_1356_a.field_6322_g;
        float var4 = var3.field_602_at + (var3.field_604_ar - var3.field_602_at) * var1;
        GL11.glPushMatrix();
        GL11.glRotatef(var4, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(var3.field_603_as + (var3.field_605_aq - var3.field_603_as) * var1, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glPopMatrix();
        ItemStack var5 = this.field_9451_b;
        float var6 = this.field_1356_a.field_6324_e.func_598_c(MathHelper.func_1108_b(var3.field_611_ak), MathHelper.func_1108_b(var3.field_610_al), MathHelper.func_1108_b(var3.field_609_am));
        float var8;
        float var9;
        float var10;
        if (var5 != null) {
            int var7 = Item.field_233_c[var5.field_1617_c].func_27010_f(var5.func_21181_i());
            var8 = (float)(var7 >> 16 & 255) / 255.0F;
            var9 = (float)(var7 >> 8 & 255) / 255.0F;
            var10 = (float)(var7 & 255) / 255.0F;
            GL11.glColor4f(var6 * var8, var6 * var9, var6 * var10, 1.0F);
        } else {
            GL11.glColor4f(var6, var6, var6, 1.0F);
        }

        float var14;
        if (var5 != null && var5.field_1617_c == Item.field_28010_bb.field_291_aS) {
            GL11.glPushMatrix();
            var14 = 0.8F;
            var8 = var3.func_431_d(var1);
            var9 = MathHelper.func_1106_a(var8 * 3.1415927F);
            var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F);
            GL11.glTranslatef(-var10 * 0.4F, MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F * 2.0F) * 0.2F, -var9 * 0.2F);
            var8 = 1.0F - var4 / 45.0F + 0.1F;
            if (var8 < 0.0F) {
                var8 = 0.0F;
            }

            if (var8 > 1.0F) {
                var8 = 1.0F;
            }

            var8 = -MathHelper.func_1114_b(var8 * 3.1415927F) * 0.5F + 0.5F;
            GL11.glTranslatef(0.0F, 0.0F * var14 - (1.0F - var2) * 1.2F - var8 * 0.5F + 0.04F, -0.9F * var14);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var8 * -85.0F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(32826);
            GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1071_a(this.field_1356_a.field_6322_g.field_20047_bv, this.field_1356_a.field_6322_g.func_6376_z()));

            for(int var17 = 0; var17 < 2; ++var17) {
                int var21 = var17 * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float)var21);
                GL11.glRotatef((float)(-45 * var21), 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef((float)(-65 * var21), 0.0F, 1.0F, 0.0F);
                Render var11 = RenderManager.field_1233_a.func_855_a(this.field_1356_a.field_6322_g);
                RenderPlayer var12 = (RenderPlayer)var11;
                float var13 = 1.0F;
                GL11.glScalef(var13, var13, var13);
                var12.func_185_b();
                GL11.glPopMatrix();
            }

            var9 = var3.func_431_d(var1);
            var10 = MathHelper.func_1106_a(var9 * var9 * 3.1415927F);
            float var18 = MathHelper.func_1106_a(MathHelper.func_1113_c(var9) * 3.1415927F);
            GL11.glRotatef(-var10 * 20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-var18 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-var18 * 80.0F, 1.0F, 0.0F, 0.0F);
            var9 = 0.38F;
            GL11.glScalef(var9, var9, var9);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
            var10 = 0.015625F;
            GL11.glScalef(var10, var10, var10);
            this.field_1356_a.field_6315_n.func_1076_b(this.field_1356_a.field_6315_n.func_1070_a("/misc/mapbg.png"));
            Tessellator var19 = Tessellator.field_1512_a;
            GL11.glNormal3f(0.0F, 0.0F, -1.0F);
            var19.func_977_b();
            byte var20 = 7;
            var19.func_983_a((double)(0 - var20), (double)(128 + var20), 0.0D, 0.0D, 1.0D);
            var19.func_983_a((double)(128 + var20), (double)(128 + var20), 0.0D, 1.0D, 1.0D);
            var19.func_983_a((double)(128 + var20), (double)(0 - var20), 0.0D, 1.0D, 0.0D);
            var19.func_983_a((double)(0 - var20), (double)(0 - var20), 0.0D, 0.0D, 0.0D);
            var19.func_982_a();
            MapData var22 = Item.field_28010_bb.func_28012_a(var5, this.field_1356_a.field_6324_e);
            this.field_28131_f.func_28157_a(this.field_1356_a.field_6322_g, this.field_1356_a.field_6315_n, var22);
            GL11.glPopMatrix();
        } else if (var5 != null) {
            GL11.glPushMatrix();
            var14 = 0.8F;
            var8 = var3.func_431_d(var1);
            var9 = MathHelper.func_1106_a(var8 * 3.1415927F);
            var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F);
            GL11.glTranslatef(-var10 * 0.4F, MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F * 2.0F) * 0.2F, -var9 * 0.2F);
            GL11.glTranslatef(0.7F * var14, -0.65F * var14 - (1.0F - var2) * 0.6F, -0.9F * var14);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826);
            var8 = var3.func_431_d(var1);
            var9 = MathHelper.func_1106_a(var8 * var8 * 3.1415927F);
            var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F);
            GL11.glRotatef(-var9 * 20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-var10 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-var10 * 80.0F, 1.0F, 0.0F, 0.0F);
            var8 = 0.4F;
            GL11.glScalef(var8, var8, var8);
            if (var5.func_1091_a().func_4023_b()) {
                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            this.func_4132_a(var3, var5);
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            var14 = 0.8F;
            var8 = var3.func_431_d(var1);
            var9 = MathHelper.func_1106_a(var8 * 3.1415927F);
            var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F);
            GL11.glTranslatef(-var10 * 0.3F, MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F * 2.0F) * 0.4F, -var9 * 0.4F);
            GL11.glTranslatef(0.8F * var14, -0.75F * var14 - (1.0F - var2) * 0.6F, -0.9F * var14);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826);
            var8 = var3.func_431_d(var1);
            var9 = MathHelper.func_1106_a(var8 * var8 * 3.1415927F);
            var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var8) * 3.1415927F);
            GL11.glRotatef(var10 * 70.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-var9 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1071_a(this.field_1356_a.field_6322_g.field_20047_bv, this.field_1356_a.field_6322_g.func_6376_z()));
            GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
            GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(5.6F, 0.0F, 0.0F);
            Render var15 = RenderManager.field_1233_a.func_855_a(this.field_1356_a.field_6322_g);
            RenderPlayer var16 = (RenderPlayer)var15;
            var10 = 1.0F;
            GL11.glScalef(var10, var10, var10);
            var16.func_185_b();
            GL11.glPopMatrix();
        }

        GL11.glDisable(32826);
        RenderHelper.func_1159_a();
    }

    public void func_893_b(float var1) {
        GL11.glDisable(3008);
        int var2;
        if (this.field_1356_a.field_6322_g.func_21062_U()) {
            var2 = this.field_1356_a.field_6315_n.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, var2);
            this.func_890_d(var1);
        }

        if (this.field_1356_a.field_6322_g.func_345_I()) {
            var2 = MathHelper.func_1108_b(this.field_1356_a.field_6322_g.field_611_ak);
            int var3 = MathHelper.func_1108_b(this.field_1356_a.field_6322_g.field_610_al);
            int var4 = MathHelper.func_1108_b(this.field_1356_a.field_6322_g.field_609_am);
            int var5 = this.field_1356_a.field_6315_n.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, var5);
            int var6 = this.field_1356_a.field_6324_e.func_600_a(var2, var3, var4);
            if (this.field_1356_a.field_6324_e.func_28100_h(var2, var3, var4)) {
                this.func_898_a(var1, Block.field_345_n[var6].func_218_a(2));
            } else {
                for(int var7 = 0; var7 < 8; ++var7) {
                    float var8 = ((float)((var7 >> 0) % 2) - 0.5F) * this.field_1356_a.field_6322_g.field_644_aC * 0.9F;
                    float var9 = ((float)((var7 >> 1) % 2) - 0.5F) * this.field_1356_a.field_6322_g.field_643_aD * 0.2F;
                    float var10 = ((float)((var7 >> 2) % 2) - 0.5F) * this.field_1356_a.field_6322_g.field_644_aC * 0.9F;
                    int var11 = MathHelper.func_1110_d((float)var2 + var8);
                    int var12 = MathHelper.func_1110_d((float)var3 + var9);
                    int var13 = MathHelper.func_1110_d((float)var4 + var10);
                    if (this.field_1356_a.field_6324_e.func_28100_h(var11, var12, var13)) {
                        var6 = this.field_1356_a.field_6324_e.func_600_a(var11, var12, var13);
                    }
                }
            }

            if (Block.field_345_n[var6] != null) {
                this.func_898_a(var1, Block.field_345_n[var6].func_218_a(2));
            }
        }

        if (this.field_1356_a.field_6322_g.func_393_a(Material.field_1332_f)) {
            var2 = this.field_1356_a.field_6315_n.func_1070_a("/misc/water.png");
            GL11.glBindTexture(3553, var2);
            this.func_892_c(var1);
        }

        GL11.glEnable(3008);
    }

    private void func_898_a(float var1, int var2) {
        Tessellator var3 = Tessellator.field_1512_a;
        this.field_1356_a.field_6322_g.func_382_a(var1);
        float var4 = 0.1F;
        GL11.glColor4f(var4, var4, var4, 0.5F);
        GL11.glPushMatrix();
        float var5 = -1.0F;
        float var6 = 1.0F;
        float var7 = -1.0F;
        float var8 = 1.0F;
        float var9 = -0.5F;
        float var10 = 0.0078125F;
        float var11 = (float)(var2 % 16) / 256.0F - var10;
        float var12 = ((float)(var2 % 16) + 15.99F) / 256.0F + var10;
        float var13 = (float)(var2 / 16) / 256.0F - var10;
        float var14 = ((float)(var2 / 16) + 15.99F) / 256.0F + var10;
        var3.func_977_b();
        var3.func_983_a((double)var5, (double)var7, (double)var9, (double)var12, (double)var14);
        var3.func_983_a((double)var6, (double)var7, (double)var9, (double)var11, (double)var14);
        var3.func_983_a((double)var6, (double)var8, (double)var9, (double)var11, (double)var13);
        var3.func_983_a((double)var5, (double)var8, (double)var9, (double)var12, (double)var13);
        var3.func_982_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_892_c(float var1) {
        Tessellator var2 = Tessellator.field_1512_a;
        float var3 = this.field_1356_a.field_6322_g.func_382_a(var1);
        GL11.glColor4f(var3, var3, var3, 0.5F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float var4 = 4.0F;
        float var5 = -1.0F;
        float var6 = 1.0F;
        float var7 = -1.0F;
        float var8 = 1.0F;
        float var9 = -0.5F;
        float var10 = -this.field_1356_a.field_6322_g.field_605_aq / 64.0F;
        float var11 = this.field_1356_a.field_6322_g.field_604_ar / 64.0F;
        var2.func_977_b();
        var2.func_983_a((double)var5, (double)var7, (double)var9, (double)(var4 + var10), (double)(var4 + var11));
        var2.func_983_a((double)var6, (double)var7, (double)var9, (double)(0.0F + var10), (double)(var4 + var11));
        var2.func_983_a((double)var6, (double)var8, (double)var9, (double)(0.0F + var10), (double)(0.0F + var11));
        var2.func_983_a((double)var5, (double)var8, (double)var9, (double)(var4 + var10), (double)(0.0F + var11));
        var2.func_982_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
    }

    private void func_890_d(float var1) {
        Tessellator var2 = Tessellator.field_1512_a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float var3 = 1.0F;

        for(int var4 = 0; var4 < 2; ++var4) {
            GL11.glPushMatrix();
            int var5 = Block.field_402_as.field_378_bb + var4 * 16;
            int var6 = (var5 & 15) << 4;
            int var7 = var5 & 240;
            float var8 = (float)var6 / 256.0F;
            float var9 = ((float)var6 + 15.99F) / 256.0F;
            float var10 = (float)var7 / 256.0F;
            float var11 = ((float)var7 + 15.99F) / 256.0F;
            float var12 = (0.0F - var3) / 2.0F;
            float var13 = var12 + var3;
            float var14 = 0.0F - var3 / 2.0F;
            float var15 = var14 + var3;
            float var16 = -0.5F;
            GL11.glTranslatef((float)(-(var4 * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            GL11.glRotatef((float)(var4 * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
            var2.func_977_b();
            var2.func_983_a((double)var12, (double)var14, (double)var16, (double)var9, (double)var11);
            var2.func_983_a((double)var13, (double)var14, (double)var16, (double)var8, (double)var11);
            var2.func_983_a((double)var13, (double)var15, (double)var16, (double)var8, (double)var10);
            var2.func_983_a((double)var12, (double)var15, (double)var16, (double)var9, (double)var10);
            var2.func_982_a();
            GL11.glPopMatrix();
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
    }

    public void func_895_a() {
        this.field_9452_d = this.field_9453_c;
        EntityPlayerSP var1 = this.field_1356_a.field_6322_g;
        ItemStack var2 = var1.field_778_b.func_494_a();
        boolean var4 = this.field_20099_f == var1.field_778_b.field_847_d && var2 == this.field_9451_b;
        if (this.field_9451_b == null && var2 == null) {
            var4 = true;
        }

        if (var2 != null && this.field_9451_b != null && var2 != this.field_9451_b && var2.field_1617_c == this.field_9451_b.field_1617_c && var2.func_21181_i() == this.field_9451_b.func_21181_i()) {
            this.field_9451_b = var2;
            var4 = true;
        }

        float var5 = 0.4F;
        float var6 = var4 ? 1.0F : 0.0F;
        float var7 = var6 - this.field_9453_c;
        if (var7 < -var5) {
            var7 = -var5;
        }

        if (var7 > var5) {
            var7 = var5;
        }

        this.field_9453_c += var7;
        if (this.field_9453_c < 0.1F) {
            this.field_9451_b = var2;
            this.field_20099_f = var1.field_778_b.field_847_d;
        }

    }

    public void func_9449_b() {
        this.field_9453_c = 0.0F;
    }

    public void func_9450_c() {
        this.field_9453_c = 0.0F;
    }
}
