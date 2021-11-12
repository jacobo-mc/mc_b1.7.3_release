package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiIngame extends Gui {
    private static RenderItem field_930_d = new RenderItem();
    private List field_929_e = new ArrayList();
    private Random field_9423_f = new Random();
    private Minecraft field_9422_g;
    public String field_933_a = null;
    private int field_9421_h = 0;
    private String field_9420_i = "";
    private int field_9419_j = 0;
    private boolean field_22065_l = false;
    public float field_6446_b;
    float field_931_c = 1.0F;

    public GuiIngame(Minecraft var1) {
        this.field_9422_g = var1;
    }

    public void func_4066_a(float var1, boolean var2, int var3, int var4) {
        ScaledResolution var5 = new ScaledResolution(this.field_9422_g.field_6304_y, this.field_9422_g.field_6326_c, this.field_9422_g.field_6325_d);
        int var6 = var5.func_903_a();
        int var7 = var5.func_902_b();
        FontRenderer var8 = this.field_9422_g.field_6314_o;
        this.field_9422_g.field_9243_r.func_905_b();
        GL11.glEnable(3042);
        if (Minecraft.func_22001_u()) {
            this.func_4064_a(this.field_9422_g.field_6322_g.func_382_a(var1), var6, var7);
        }

        ItemStack var9 = this.field_9422_g.field_6322_g.field_778_b.func_492_d(3);
        if (!this.field_9422_g.field_6304_y.field_1560_x && var9 != null && var9.field_1617_c == Block.field_4055_bb.field_376_bc) {
            this.func_4063_a(var6, var7);
        }

        float var10 = this.field_9422_g.field_6322_g.field_28025_B + (this.field_9422_g.field_6322_g.field_28026_A - this.field_9422_g.field_6322_g.field_28025_B) * var1;
        if (var10 > 0.0F) {
            this.func_4065_b(var10, var6, var7);
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/gui/gui.png"));
        InventoryPlayer var11 = this.field_9422_g.field_6322_g.field_778_b;
        this.field_923_k = -90.0F;
        this.func_550_b(var6 / 2 - 91, var7 - 22, 0, 0, 182, 22);
        this.func_550_b(var6 / 2 - 91 - 1 + var11.field_847_d * 20, var7 - 22 - 1, 0, 22, 24, 22);
        GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(775, 769);
        this.func_550_b(var6 / 2 - 7, var7 / 2 - 7, 0, 0, 16, 16);
        GL11.glDisable(3042);
        boolean var12 = this.field_9422_g.field_6322_g.field_9306_bj / 3 % 2 == 1;
        if (this.field_9422_g.field_6322_g.field_9306_bj < 10) {
            var12 = false;
        }

        int var13 = this.field_9422_g.field_6322_g.field_9337_J;
        int var14 = this.field_9422_g.field_6322_g.field_9335_K;
        this.field_9423_f.setSeed((long)(this.field_9421_h * 312871));
        int var15;
        int var16;
        int var17;
        if (this.field_9422_g.field_6327_b.func_6469_d()) {
            var15 = this.field_9422_g.field_6322_g.func_6419_n();

            int var18;
            for(var16 = 0; var16 < 10; ++var16) {
                var17 = var7 - 32;
                if (var15 > 0) {
                    var18 = var6 / 2 + 91 - var16 * 8 - 9;
                    if (var16 * 2 + 1 < var15) {
                        this.func_550_b(var18, var17, 34, 9, 9, 9);
                    }

                    if (var16 * 2 + 1 == var15) {
                        this.func_550_b(var18, var17, 25, 9, 9, 9);
                    }

                    if (var16 * 2 + 1 > var15) {
                        this.func_550_b(var18, var17, 16, 9, 9, 9);
                    }
                }

                byte var28 = 0;
                if (var12) {
                    var28 = 1;
                }

                int var19 = var6 / 2 - 91 + var16 * 8;
                if (var13 <= 4) {
                    var17 += this.field_9423_f.nextInt(2);
                }

                this.func_550_b(var19, var17, 16 + var28 * 9, 0, 9, 9);
                if (var12) {
                    if (var16 * 2 + 1 < var14) {
                        this.func_550_b(var19, var17, 70, 0, 9, 9);
                    }

                    if (var16 * 2 + 1 == var14) {
                        this.func_550_b(var19, var17, 79, 0, 9, 9);
                    }
                }

                if (var16 * 2 + 1 < var13) {
                    this.func_550_b(var19, var17, 52, 0, 9, 9);
                }

                if (var16 * 2 + 1 == var13) {
                    this.func_550_b(var19, var17, 61, 0, 9, 9);
                }
            }

            if (this.field_9422_g.field_6322_g.func_393_a(Material.field_1332_f)) {
                var16 = (int)Math.ceil((double)(this.field_9422_g.field_6322_g.field_9305_bk - 2) * 10.0D / 300.0D);
                var17 = (int)Math.ceil((double)this.field_9422_g.field_6322_g.field_9305_bk * 10.0D / 300.0D) - var16;

                for(var18 = 0; var18 < var16 + var17; ++var18) {
                    if (var18 < var16) {
                        this.func_550_b(var6 / 2 - 91 + var18 * 8, var7 - 32 - 9, 16, 18, 9, 9);
                    } else {
                        this.func_550_b(var6 / 2 - 91 + var18 * 8, var7 - 32 - 9, 25, 18, 9, 9);
                    }
                }
            }
        }

        GL11.glDisable(3042);
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glRotatef(120.0F, 1.0F, 0.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glPopMatrix();

        for(var15 = 0; var15 < 9; ++var15) {
            var16 = var6 / 2 - 90 + var15 * 20 + 2;
            var17 = var7 - 16 - 3;
            this.func_554_a(var15, var16, var17, var1);
        }

        RenderHelper.func_1159_a();
        GL11.glDisable(32826);
        if (this.field_9422_g.field_6322_g.func_22060_M() > 0) {
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            var15 = this.field_9422_g.field_6322_g.func_22060_M();
            float var27 = (float)var15 / 100.0F;
            if (var27 > 1.0F) {
                var27 = 1.0F - (float)(var15 - 100) / 10.0F;
            }

            var17 = (int)(220.0F * var27) << 24 | 1052704;
            this.func_551_a(0, 0, var6, var7, var17);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
        }

        String var23;
        if (this.field_9422_g.field_6304_y.field_22276_A) {
            GL11.glPushMatrix();
            if (Minecraft.field_28005_H > 0L) {
                GL11.glTranslatef(0.0F, 32.0F, 0.0F);
            }

            var8.func_874_a("Minecraft Beta 1.7.3 (" + this.field_9422_g.field_6292_I + ")", 2, 2, 16777215);
            var8.func_874_a(this.field_9422_g.func_6241_m(), 2, 12, 16777215);
            var8.func_874_a(this.field_9422_g.func_6262_n(), 2, 22, 16777215);
            var8.func_874_a(this.field_9422_g.func_6245_o(), 2, 32, 16777215);
            var8.func_874_a(this.field_9422_g.func_21002_o(), 2, 42, 16777215);
            long var24 = Runtime.getRuntime().maxMemory();
            long var29 = Runtime.getRuntime().totalMemory();
            long var30 = Runtime.getRuntime().freeMemory();
            long var21 = var29 - var30;
            var23 = "Used memory: " + var21 * 100L / var24 + "% (" + var21 / 1024L / 1024L + "MB) of " + var24 / 1024L / 1024L + "MB";
            this.func_547_b(var8, var23, var6 - var8.func_871_a(var23) - 2, 2, 14737632);
            var23 = "Allocated memory: " + var29 * 100L / var24 + "% (" + var29 / 1024L / 1024L + "MB)";
            this.func_547_b(var8, var23, var6 - var8.func_871_a(var23) - 2, 12, 14737632);
            this.func_547_b(var8, "x: " + this.field_9422_g.field_6322_g.field_611_ak, 2, 64, 14737632);
            this.func_547_b(var8, "y: " + this.field_9422_g.field_6322_g.field_610_al, 2, 72, 14737632);
            this.func_547_b(var8, "z: " + this.field_9422_g.field_6322_g.field_609_am, 2, 80, 14737632);
            this.func_547_b(var8, "f: " + (MathHelper.func_1108_b((double)(this.field_9422_g.field_6322_g.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3), 2, 88, 14737632);
            GL11.glPopMatrix();
        }

        if (this.field_9419_j > 0) {
            float var25 = (float)this.field_9419_j - var1;
            var16 = (int)(var25 * 256.0F / 20.0F);
            if (var16 > 255) {
                var16 = 255;
            }

            if (var16 > 0) {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(var6 / 2), (float)(var7 - 48), 0.0F);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                var17 = 16777215;
                if (this.field_22065_l) {
                    var17 = Color.HSBtoRGB(var25 / 50.0F, 0.7F, 0.6F) & 16777215;
                }

                var8.func_873_b(this.field_9420_i, -var8.func_871_a(this.field_9420_i) / 2, -4, var17 + (var16 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
        }

        byte var26 = 10;
        boolean var31 = false;
        if (this.field_9422_g.field_6313_p instanceof GuiChat) {
            var26 = 20;
            var31 = true;
        }

        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, (float)(var7 - 48), 0.0F);

        for(var17 = 0; var17 < this.field_929_e.size() && var17 < var26; ++var17) {
            if (((ChatLine)this.field_929_e.get(var17)).field_1296_b < 200 || var31) {
                double var32 = (double)((ChatLine)this.field_929_e.get(var17)).field_1296_b / 200.0D;
                var32 = 1.0D - var32;
                var32 *= 10.0D;
                if (var32 < 0.0D) {
                    var32 = 0.0D;
                }

                if (var32 > 1.0D) {
                    var32 = 1.0D;
                }

                var32 *= var32;
                int var20 = (int)(255.0D * var32);
                if (var31) {
                    var20 = 255;
                }

                if (var20 > 0) {
                    byte var33 = 2;
                    int var22 = -var17 * 9;
                    var23 = ((ChatLine)this.field_929_e.get(var17)).field_1297_a;
                    this.func_551_a(var33, var22 - 1, var33 + 320, var22 + 8, var20 / 2 << 24);
                    GL11.glEnable(3042);
                    var8.func_874_a(var23, var33, var22, 16777215 + (var20 << 24));
                }
            }
        }

        GL11.glPopMatrix();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    private void func_4063_a(int var1, int var2) {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3008);
        GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("%blur%/misc/pumpkinblur.png"));
        Tessellator var3 = Tessellator.field_1512_a;
        var3.func_977_b();
        var3.func_983_a(0.0D, (double)var2, -90.0D, 0.0D, 1.0D);
        var3.func_983_a((double)var1, (double)var2, -90.0D, 1.0D, 1.0D);
        var3.func_983_a((double)var1, 0.0D, -90.0D, 1.0D, 0.0D);
        var3.func_983_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        var3.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_4064_a(float var1, int var2, int var3) {
        var1 = 1.0F - var1;
        if (var1 < 0.0F) {
            var1 = 0.0F;
        }

        if (var1 > 1.0F) {
            var1 = 1.0F;
        }

        this.field_931_c = (float)((double)this.field_931_c + (double)(var1 - this.field_931_c) * 0.01D);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(this.field_931_c, this.field_931_c, this.field_931_c, 1.0F);
        GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("%blur%/misc/vignette.png"));
        Tessellator var4 = Tessellator.field_1512_a;
        var4.func_977_b();
        var4.func_983_a(0.0D, (double)var3, -90.0D, 0.0D, 1.0D);
        var4.func_983_a((double)var2, (double)var3, -90.0D, 1.0D, 1.0D);
        var4.func_983_a((double)var2, 0.0D, -90.0D, 1.0D, 0.0D);
        var4.func_983_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        var4.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBlendFunc(770, 771);
    }

    private void func_4065_b(float var1, int var2, int var3) {
        if (var1 < 1.0F) {
            var1 *= var1;
            var1 *= var1;
            var1 = var1 * 0.8F + 0.2F;
        }

        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, var1);
        GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/terrain.png"));
        float var4 = (float)(Block.field_4047_bf.field_378_bb % 16) / 16.0F;
        float var5 = (float)(Block.field_4047_bf.field_378_bb / 16) / 16.0F;
        float var6 = (float)(Block.field_4047_bf.field_378_bb % 16 + 1) / 16.0F;
        float var7 = (float)(Block.field_4047_bf.field_378_bb / 16 + 1) / 16.0F;
        Tessellator var8 = Tessellator.field_1512_a;
        var8.func_977_b();
        var8.func_983_a(0.0D, (double)var3, -90.0D, (double)var4, (double)var7);
        var8.func_983_a((double)var2, (double)var3, -90.0D, (double)var6, (double)var7);
        var8.func_983_a((double)var2, 0.0D, -90.0D, (double)var6, (double)var5);
        var8.func_983_a(0.0D, 0.0D, -90.0D, (double)var4, (double)var5);
        var8.func_982_a();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_554_a(int var1, int var2, int var3, float var4) {
        ItemStack var5 = this.field_9422_g.field_6322_g.field_778_b.field_843_a[var1];
        if (var5 != null) {
            float var6 = (float)var5.field_1614_b - var4;
            if (var6 > 0.0F) {
                GL11.glPushMatrix();
                float var7 = 1.0F + var6 / 5.0F;
                GL11.glTranslatef((float)(var2 + 8), (float)(var3 + 12), 0.0F);
                GL11.glScalef(1.0F / var7, (var7 + 1.0F) / 2.0F, 1.0F);
                GL11.glTranslatef((float)(-(var2 + 8)), (float)(-(var3 + 12)), 0.0F);
            }

            field_930_d.func_161_a(this.field_9422_g.field_6314_o, this.field_9422_g.field_6315_n, var5, var2, var3);
            if (var6 > 0.0F) {
                GL11.glPopMatrix();
            }

            field_930_d.func_164_b(this.field_9422_g.field_6314_o, this.field_9422_g.field_6315_n, var5, var2, var3);
        }
    }

    public void func_555_a() {
        if (this.field_9419_j > 0) {
            --this.field_9419_j;
        }

        ++this.field_9421_h;

        for(int var1 = 0; var1 < this.field_929_e.size(); ++var1) {
            ++((ChatLine)this.field_929_e.get(var1)).field_1296_b;
        }

    }

    public void func_28097_b() {
        this.field_929_e.clear();
    }

    public void func_552_a(String var1) {
        while(this.field_9422_g.field_6314_o.func_871_a(var1) > 320) {
            int var2;
            for(var2 = 1; var2 < var1.length() && this.field_9422_g.field_6314_o.func_871_a(var1.substring(0, var2 + 1)) <= 320; ++var2) {
            }

            this.func_552_a(var1.substring(0, var2));
            var1 = var1.substring(var2);
        }

        this.field_929_e.add(0, new ChatLine(var1));

        while(this.field_929_e.size() > 50) {
            this.field_929_e.remove(this.field_929_e.size() - 1);
        }

    }

    public void func_553_b(String var1) {
        this.field_9420_i = "Now playing: " + var1;
        this.field_9419_j = 60;
        this.field_22065_l = true;
    }

    public void func_22064_c(String var1) {
        StringTranslate var2 = StringTranslate.func_20162_a();
        String var3 = var2.func_20163_a(var1);
        this.func_552_a(var3);
    }
}
