package net.minecraft.src;

import java.util.Random;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiAchievements extends GuiScreen {
    private static final int field_27126_s;
    private static final int field_27125_t;
    private static final int field_27124_u;
    private static final int field_27123_v;
    protected int field_27121_a = 256;
    protected int field_27119_i = 202;
    protected int field_27118_j = 0;
    protected int field_27117_l = 0;
    protected double field_27116_m;
    protected double field_27115_n;
    protected double field_27114_o;
    protected double field_27113_p;
    protected double field_27112_q;
    protected double field_27111_r;
    private int field_27122_w = 0;
    private StatFileWriter field_27120_x;

    public GuiAchievements(StatFileWriter var1) {
        this.field_27120_x = var1;
        short var2 = 141;
        short var3 = 141;
        this.field_27116_m = this.field_27114_o = this.field_27112_q = (double)(AchievementList.field_25195_b.field_25075_a * 24 - var2 / 2 - 12);
        this.field_27115_n = this.field_27113_p = this.field_27111_r = (double)(AchievementList.field_25195_b.field_25074_b * 24 - var3 / 2);
    }

    public void func_6448_a() {
        this.field_949_e.clear();
        this.field_949_e.add(new GuiSmallButton(1, this.field_951_c / 2 + 24, this.field_950_d / 2 + 74, 80, 20, StatCollector.func_25200_a("gui.done")));
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 1) {
            this.field_945_b.func_6272_a((GuiScreen)null);
            this.field_945_b.func_6259_e();
        }

        super.func_572_a(var1);
    }

    protected void func_580_a(char var1, int var2) {
        if (var2 == this.field_945_b.field_6304_y.field_1570_o.field_1370_b) {
            this.field_945_b.func_6272_a((GuiScreen)null);
            this.field_945_b.func_6259_e();
        } else {
            super.func_580_a(var1, var2);
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        if (Mouse.isButtonDown(0)) {
            int var4 = (this.field_951_c - this.field_27121_a) / 2;
            int var5 = (this.field_950_d - this.field_27119_i) / 2;
            int var6 = var4 + 8;
            int var7 = var5 + 17;
            if ((this.field_27122_w == 0 || this.field_27122_w == 1) && var1 >= var6 && var1 < var6 + 224 && var2 >= var7 && var2 < var7 + 155) {
                if (this.field_27122_w == 0) {
                    this.field_27122_w = 1;
                } else {
                    this.field_27114_o -= (double)(var1 - this.field_27118_j);
                    this.field_27113_p -= (double)(var2 - this.field_27117_l);
                    this.field_27112_q = this.field_27116_m = this.field_27114_o;
                    this.field_27111_r = this.field_27115_n = this.field_27113_p;
                }

                this.field_27118_j = var1;
                this.field_27117_l = var2;
            }

            if (this.field_27112_q < (double)field_27126_s) {
                this.field_27112_q = (double)field_27126_s;
            }

            if (this.field_27111_r < (double)field_27125_t) {
                this.field_27111_r = (double)field_27125_t;
            }

            if (this.field_27112_q >= (double)field_27124_u) {
                this.field_27112_q = (double)(field_27124_u - 1);
            }

            if (this.field_27111_r >= (double)field_27123_v) {
                this.field_27111_r = (double)(field_27123_v - 1);
            }
        } else {
            this.field_27122_w = 0;
        }

        this.func_578_i();
        this.func_27109_b(var1, var2, var3);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        this.func_27110_k();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    public void func_570_g() {
        this.field_27116_m = this.field_27114_o;
        this.field_27115_n = this.field_27113_p;
        double var1 = this.field_27112_q - this.field_27114_o;
        double var3 = this.field_27111_r - this.field_27113_p;
        if (var1 * var1 + var3 * var3 < 4.0D) {
            this.field_27114_o += var1;
            this.field_27113_p += var3;
        } else {
            this.field_27114_o += var1 * 0.85D;
            this.field_27113_p += var3 * 0.85D;
        }

    }

    protected void func_27110_k() {
        int var1 = (this.field_951_c - this.field_27121_a) / 2;
        int var2 = (this.field_950_d - this.field_27119_i) / 2;
        this.field_6451_g.func_873_b("Achievements", var1 + 15, var2 + 5, 4210752);
    }

    protected void func_27109_b(int var1, int var2, float var3) {
        int var4 = MathHelper.func_1108_b(this.field_27116_m + (this.field_27114_o - this.field_27116_m) * (double)var3);
        int var5 = MathHelper.func_1108_b(this.field_27115_n + (this.field_27113_p - this.field_27115_n) * (double)var3);
        if (var4 < field_27126_s) {
            var4 = field_27126_s;
        }

        if (var5 < field_27125_t) {
            var5 = field_27125_t;
        }

        if (var4 >= field_27124_u) {
            var4 = field_27124_u - 1;
        }

        if (var5 >= field_27123_v) {
            var5 = field_27123_v - 1;
        }

        int var6 = this.field_945_b.field_6315_n.func_1070_a("/terrain.png");
        int var7 = this.field_945_b.field_6315_n.func_1070_a("/achievement/bg.png");
        int var8 = (this.field_951_c - this.field_27121_a) / 2;
        int var9 = (this.field_950_d - this.field_27119_i) / 2;
        int var10 = var8 + 16;
        int var11 = var9 + 17;
        this.field_923_k = 0.0F;
        GL11.glDepthFunc(518);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        GL11.glEnable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        this.field_945_b.field_6315_n.func_1076_b(var6);
        int var12 = var4 + 288 >> 4;
        int var13 = var5 + 288 >> 4;
        int var14 = (var4 + 288) % 16;
        int var15 = (var5 + 288) % 16;
        Random var21 = new Random();

        for(int var22 = 0; var22 * 16 - var15 < 155; ++var22) {
            float var23 = 0.6F - (float)(var13 + var22) / 25.0F * 0.3F;
            GL11.glColor4f(var23, var23, var23, 1.0F);

            for(int var24 = 0; var24 * 16 - var14 < 224; ++var24) {
                var21.setSeed((long)(1234 + var12 + var24));
                var21.nextInt();
                int var25 = var21.nextInt(1 + var13 + var22) + (var13 + var22) / 2;
                int var26 = Block.field_393_F.field_378_bb;
                if (var25 <= 37 && var13 + var22 != 35) {
                    if (var25 == 22) {
                        if (var21.nextInt(2) == 0) {
                            var26 = Block.field_391_ax.field_378_bb;
                        } else {
                            var26 = Block.field_433_aO.field_378_bb;
                        }
                    } else if (var25 == 10) {
                        var26 = Block.field_388_I.field_378_bb;
                    } else if (var25 == 8) {
                        var26 = Block.field_386_J.field_378_bb;
                    } else if (var25 > 4) {
                        var26 = Block.field_338_u.field_378_bb;
                    } else if (var25 > 0) {
                        var26 = Block.field_336_w.field_378_bb;
                    }
                } else {
                    var26 = Block.field_403_A.field_378_bb;
                }

                this.func_550_b(var10 + var24 * 16 - var14, var11 + var22 * 16 - var15, var26 % 16 << 4, var26 >> 4 << 4, 16, 16);
            }
        }

        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553);

        int var16;
        int var17;
        int var33;
        int var38;
        for(var12 = 0; var12 < AchievementList.field_27388_e.size(); ++var12) {
            Achievement var28 = (Achievement)AchievementList.field_27388_e.get(var12);
            if (var28.field_25076_c != null) {
                var14 = var28.field_25075_a * 24 - var4 + 11 + var10;
                var15 = var28.field_25074_b * 24 - var5 + 11 + var11;
                var16 = var28.field_25076_c.field_25075_a * 24 - var4 + 11 + var10;
                var17 = var28.field_25076_c.field_25074_b * 24 - var5 + 11 + var11;
                boolean var18 = false;
                boolean var19 = this.field_27120_x.func_27183_a(var28);
                boolean var20 = this.field_27120_x.func_27181_b(var28);
                var38 = Math.sin((double)(System.currentTimeMillis() % 600L) / 600.0D * 3.141592653589793D * 2.0D) > 0.6D ? 255 : 130;
                if (var19) {
                    var33 = -9408400;
                } else if (var20) {
                    var33 = '\uff00' + (var38 << 24);
                } else {
                    var33 = -16777216;
                }

                this.func_27100_a(var14, var16, var15, var33);
                this.func_27099_b(var16, var15, var17, var33);
            }
        }

        Achievement var27 = null;
        RenderItem var29 = new RenderItem();
        GL11.glPushMatrix();
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glPopMatrix();
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);

        int var34;
        for(var14 = 0; var14 < AchievementList.field_27388_e.size(); ++var14) {
            Achievement var30 = (Achievement)AchievementList.field_27388_e.get(var14);
            var16 = var30.field_25075_a * 24 - var4;
            var17 = var30.field_25074_b * 24 - var5;
            if (var16 >= -24 && var17 >= -24 && var16 <= 224 && var17 <= 155) {
                float var35;
                if (this.field_27120_x.func_27183_a(var30)) {
                    var35 = 1.0F;
                    GL11.glColor4f(var35, var35, var35, 1.0F);
                } else if (this.field_27120_x.func_27181_b(var30)) {
                    var35 = Math.sin((double)(System.currentTimeMillis() % 600L) / 600.0D * 3.141592653589793D * 2.0D) < 0.6D ? 0.6F : 0.8F;
                    GL11.glColor4f(var35, var35, var35, 1.0F);
                } else {
                    var35 = 0.3F;
                    GL11.glColor4f(var35, var35, var35, 1.0F);
                }

                this.field_945_b.field_6315_n.func_1076_b(var7);
                var33 = var10 + var16;
                var34 = var11 + var17;
                if (var30.func_27093_f()) {
                    this.func_550_b(var33 - 2, var34 - 2, 26, 202, 26, 26);
                } else {
                    this.func_550_b(var33 - 2, var34 - 2, 0, 202, 26, 26);
                }

                if (!this.field_27120_x.func_27181_b(var30)) {
                    float var36 = 0.1F;
                    GL11.glColor4f(var36, var36, var36, 1.0F);
                    var29.field_27004_a = false;
                }

                GL11.glEnable(2896);
                GL11.glEnable(2884);
                var29.func_161_a(this.field_945_b.field_6314_o, this.field_945_b.field_6315_n, var30.field_27097_d, var33 + 3, var34 + 3);
                GL11.glDisable(2896);
                if (!this.field_27120_x.func_27181_b(var30)) {
                    var29.field_27004_a = true;
                }

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                if (var1 >= var10 && var2 >= var11 && var1 < var10 + 224 && var2 < var11 + 155 && var1 >= var33 && var1 <= var33 + 22 && var2 >= var34 && var2 <= var34 + 22) {
                    var27 = var30;
                }
            }
        }

        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_945_b.field_6315_n.func_1076_b(var7);
        this.func_550_b(var8, var9, 0, 0, this.field_27121_a, this.field_27119_i);
        GL11.glPopMatrix();
        this.field_923_k = 0.0F;
        GL11.glDepthFunc(515);
        GL11.glDisable(2929);
        GL11.glEnable(3553);
        super.func_571_a(var1, var2, var3);
        if (var27 != null) {
            String var31 = var27.field_25070_e;
            String var32 = var27.func_27090_e();
            var17 = var1 + 12;
            var33 = var2 - 4;
            if (this.field_27120_x.func_27181_b(var27)) {
                var34 = Math.max(this.field_6451_g.func_871_a(var31), 120);
                int var37 = this.field_6451_g.func_27277_a(var32, var34);
                if (this.field_27120_x.func_27183_a(var27)) {
                    var37 += 12;
                }

                this.func_549_a(var17 - 3, var33 - 3, var17 + var34 + 3, var33 + var37 + 3 + 12, -1073741824, -1073741824);
                this.field_6451_g.func_27278_a(var32, var17, var33 + 12, var34, -6250336);
                if (this.field_27120_x.func_27183_a(var27)) {
                    this.field_6451_g.func_874_a(StatCollector.func_25200_a("achievement.taken"), var17, var33 + var37 + 4, -7302913);
                }
            } else {
                var34 = Math.max(this.field_6451_g.func_871_a(var31), 120);
                String var39 = StatCollector.func_25199_a("achievement.requires", var27.field_25076_c.field_25070_e);
                var38 = this.field_6451_g.func_27277_a(var39, var34);
                this.func_549_a(var17 - 3, var33 - 3, var17 + var34 + 3, var33 + var38 + 12 + 3, -1073741824, -1073741824);
                this.field_6451_g.func_27278_a(var39, var17, var33 + 12, var34, -9416624);
            }

            this.field_6451_g.func_874_a(var31, var17, var33, this.field_27120_x.func_27181_b(var27) ? (var27.func_27093_f() ? -128 : -1) : (var27.func_27093_f() ? -8355776 : -8355712));
        }

        GL11.glEnable(2929);
        GL11.glEnable(2896);
        RenderHelper.func_1159_a();
    }

    public boolean func_6450_b() {
        return true;
    }

    static {
        field_27126_s = AchievementList.field_27392_a * 24 - 112;
        field_27125_t = AchievementList.field_27391_b * 24 - 112;
        field_27124_u = AchievementList.field_27390_c * 24 - 77;
        field_27123_v = AchievementList.field_27389_d * 24 - 77;
    }
}
