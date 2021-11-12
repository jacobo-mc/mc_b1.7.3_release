package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class RenderItem extends Render {
    private RenderBlocks field_201_d = new RenderBlocks();
    private Random field_200_e = new Random();
    public boolean field_27004_a = true;

    public RenderItem() {
        this.field_9246_c = 0.15F;
        this.field_194_c = 0.75F;
    }

    public void func_165_a(EntityItem var1, double var2, double var4, double var6, float var8, float var9) {
        this.field_200_e.setSeed(187L);
        ItemStack var10 = var1.field_801_a;
        GL11.glPushMatrix();
        float var11 = MathHelper.func_1106_a(((float)var1.field_800_b + var9) / 10.0F + var1.field_804_d) * 0.1F + 0.1F;
        float var12 = (((float)var1.field_800_b + var9) / 20.0F + var1.field_804_d) * 57.295776F;
        byte var13 = 1;
        if (var1.field_801_a.field_1615_a > 1) {
            var13 = 2;
        }

        if (var1.field_801_a.field_1615_a > 5) {
            var13 = 3;
        }

        if (var1.field_801_a.field_1615_a > 20) {
            var13 = 4;
        }

        GL11.glTranslatef((float)var2, (float)var4 + var11, (float)var6);
        GL11.glEnable(32826);
        float var16;
        float var17;
        float var18;
        if (var10.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var10.field_1617_c].func_210_f())) {
            GL11.glRotatef(var12, 0.0F, 1.0F, 0.0F);
            this.func_151_a("/terrain.png");
            float var28 = 0.25F;
            if (!Block.field_345_n[var10.field_1617_c].func_242_c() && var10.field_1617_c != Block.field_410_al.field_376_bc && Block.field_345_n[var10.field_1617_c].func_210_f() != 16) {
                var28 = 0.5F;
            }

            GL11.glScalef(var28, var28, var28);

            for(int var29 = 0; var29 < var13; ++var29) {
                GL11.glPushMatrix();
                if (var29 > 0) {
                    var16 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F / var28;
                    var17 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F / var28;
                    var18 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F / var28;
                    GL11.glTranslatef(var16, var17, var18);
                }

                this.field_201_d.func_1227_a(Block.field_345_n[var10.field_1617_c], var10.func_21181_i(), var1.func_382_a(var9));
                GL11.glPopMatrix();
            }
        } else {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            int var14 = var10.func_1088_b();
            if (var10.field_1617_c < 256) {
                this.func_151_a("/terrain.png");
            } else {
                this.func_151_a("/gui/items.png");
            }

            Tessellator var15 = Tessellator.field_1512_a;
            var16 = (float)(var14 % 16 * 16 + 0) / 256.0F;
            var17 = (float)(var14 % 16 * 16 + 16) / 256.0F;
            var18 = (float)(var14 / 16 * 16 + 0) / 256.0F;
            float var19 = (float)(var14 / 16 * 16 + 16) / 256.0F;
            float var20 = 1.0F;
            float var21 = 0.5F;
            float var22 = 0.25F;
            int var23;
            float var24;
            float var25;
            float var26;
            if (this.field_27004_a) {
                var23 = Item.field_233_c[var10.field_1617_c].func_27010_f(var10.func_21181_i());
                var24 = (float)(var23 >> 16 & 255) / 255.0F;
                var25 = (float)(var23 >> 8 & 255) / 255.0F;
                var26 = (float)(var23 & 255) / 255.0F;
                float var27 = var1.func_382_a(var9);
                GL11.glColor4f(var24 * var27, var25 * var27, var26 * var27, 1.0F);
            }

            for(var23 = 0; var23 < var13; ++var23) {
                GL11.glPushMatrix();
                if (var23 > 0) {
                    var24 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    var25 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    var26 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(var24, var25, var26);
                }

                GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
                var15.func_977_b();
                var15.func_980_b(0.0F, 1.0F, 0.0F);
                var15.func_983_a((double)(0.0F - var21), (double)(0.0F - var22), 0.0D, (double)var16, (double)var19);
                var15.func_983_a((double)(var20 - var21), (double)(0.0F - var22), 0.0D, (double)var17, (double)var19);
                var15.func_983_a((double)(var20 - var21), (double)(1.0F - var22), 0.0D, (double)var17, (double)var18);
                var15.func_983_a((double)(0.0F - var21), (double)(1.0F - var22), 0.0D, (double)var16, (double)var18);
                var15.func_982_a();
                GL11.glPopMatrix();
            }
        }

        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_27003_a(FontRenderer var1, RenderEngine var2, int var3, int var4, int var5, int var6, int var7) {
        float var11;
        if (var3 < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var3].func_210_f())) {
            var2.func_1076_b(var2.func_1070_a("/terrain.png"));
            Block var14 = Block.field_345_n[var3];
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(var6 - 2), (float)(var7 + 3), -3.0F);
            GL11.glScalef(10.0F, 10.0F, 10.0F);
            GL11.glTranslatef(1.0F, 0.5F, 1.0F);
            GL11.glScalef(1.0F, 1.0F, -1.0F);
            GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            int var15 = Item.field_233_c[var3].func_27010_f(var4);
            var11 = (float)(var15 >> 16 & 255) / 255.0F;
            float var12 = (float)(var15 >> 8 & 255) / 255.0F;
            float var13 = (float)(var15 & 255) / 255.0F;
            if (this.field_27004_a) {
                GL11.glColor4f(var11, var12, var13, 1.0F);
            }

            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            this.field_201_d.field_31088_b = this.field_27004_a;
            this.field_201_d.func_1227_a(var14, var4, 1.0F);
            this.field_201_d.field_31088_b = true;
            GL11.glPopMatrix();
        } else if (var5 >= 0) {
            GL11.glDisable(2896);
            if (var3 < 256) {
                var2.func_1076_b(var2.func_1070_a("/terrain.png"));
            } else {
                var2.func_1076_b(var2.func_1070_a("/gui/items.png"));
            }

            int var8 = Item.field_233_c[var3].func_27010_f(var4);
            float var9 = (float)(var8 >> 16 & 255) / 255.0F;
            float var10 = (float)(var8 >> 8 & 255) / 255.0F;
            var11 = (float)(var8 & 255) / 255.0F;
            if (this.field_27004_a) {
                GL11.glColor4f(var9, var10, var11, 1.0F);
            }

            this.func_163_a(var6, var7, var5 % 16 * 16, var5 / 16 * 16, 16, 16);
            GL11.glEnable(2896);
        }

        GL11.glEnable(2884);
    }

    public void func_161_a(FontRenderer var1, RenderEngine var2, ItemStack var3, int var4, int var5) {
        if (var3 != null) {
            this.func_27003_a(var1, var2, var3.field_1617_c, var3.func_21181_i(), var3.func_1088_b(), var4, var5);
        }
    }

    public void func_164_b(FontRenderer var1, RenderEngine var2, ItemStack var3, int var4, int var5) {
        if (var3 != null) {
            if (var3.field_1615_a > 1) {
                String var6 = "" + var3.field_1615_a;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                var1.func_874_a(var6, var4 + 19 - 2 - var1.func_871_a(var6), var5 + 6 + 3, 16777215);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }

            if (var3.func_21185_g()) {
                int var11 = (int)Math.round(13.0D - (double)var3.func_21179_h() * 13.0D / (double)var3.func_1094_d());
                int var7 = (int)Math.round(255.0D - (double)var3.func_21179_h() * 255.0D / (double)var3.func_1094_d());
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                GL11.glDisable(3553);
                Tessellator var8 = Tessellator.field_1512_a;
                int var9 = 255 - var7 << 16 | var7 << 8;
                int var10 = (255 - var7) / 4 << 16 | 16128;
                this.func_162_a(var8, var4 + 2, var5 + 13, 13, 2, 0);
                this.func_162_a(var8, var4 + 2, var5 + 13, 12, 1, var10);
                this.func_162_a(var8, var4 + 2, var5 + 13, var11, 1, var9);
                GL11.glEnable(3553);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

        }
    }

    private void func_162_a(Tessellator var1, int var2, int var3, int var4, int var5, int var6) {
        var1.func_977_b();
        var1.func_990_b(var6);
        var1.func_991_a((double)(var2 + 0), (double)(var3 + 0), 0.0D);
        var1.func_991_a((double)(var2 + 0), (double)(var3 + var5), 0.0D);
        var1.func_991_a((double)(var2 + var4), (double)(var3 + var5), 0.0D);
        var1.func_991_a((double)(var2 + var4), (double)(var3 + 0), 0.0D);
        var1.func_982_a();
    }

    public void func_163_a(int var1, int var2, int var3, int var4, int var5, int var6) {
        float var7 = 0.0F;
        float var8 = 0.00390625F;
        float var9 = 0.00390625F;
        Tessellator var10 = Tessellator.field_1512_a;
        var10.func_977_b();
        var10.func_983_a((double)(var1 + 0), (double)(var2 + var6), (double)var7, (double)((float)(var3 + 0) * var8), (double)((float)(var4 + var6) * var9));
        var10.func_983_a((double)(var1 + var5), (double)(var2 + var6), (double)var7, (double)((float)(var3 + var5) * var8), (double)((float)(var4 + var6) * var9));
        var10.func_983_a((double)(var1 + var5), (double)(var2 + 0), (double)var7, (double)((float)(var3 + var5) * var8), (double)((float)(var4 + 0) * var9));
        var10.func_983_a((double)(var1 + 0), (double)(var2 + 0), (double)var7, (double)((float)(var3 + 0) * var8), (double)((float)(var4 + 0) * var9));
        var10.func_982_a();
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        this.func_165_a((EntityItem)var1, var2, var4, var6, var8, var9);
    }
}
