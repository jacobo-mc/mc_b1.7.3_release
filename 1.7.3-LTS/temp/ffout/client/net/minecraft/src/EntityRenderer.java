package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public class EntityRenderer {
    public static boolean field_28135_a = false;
    public static int field_28134_b;
    private Minecraft field_1388_h;
    private float field_1387_i = 0.0F;
    public ItemRenderer field_1395_a;
    private int field_1386_j;
    private Entity field_1385_k = null;
    private MouseFilter field_22235_l = new MouseFilter();
    private MouseFilter field_22234_m = new MouseFilter();
    private MouseFilter field_22233_n = new MouseFilter();
    private MouseFilter field_22232_o = new MouseFilter();
    private MouseFilter field_22231_p = new MouseFilter();
    private MouseFilter field_22229_q = new MouseFilter();
    private float field_22228_r = 4.0F;
    private float field_22227_s = 4.0F;
    private float field_22226_t = 0.0F;
    private float field_22225_u = 0.0F;
    private float field_22224_v = 0.0F;
    private float field_22223_w = 0.0F;
    private float field_22222_x = 0.0F;
    private float field_22221_y = 0.0F;
    private float field_22220_z = 0.0F;
    private float field_22230_A = 0.0F;
    private boolean field_27288_B = false;
    private double field_21155_l = 1.0D;
    private double field_21154_m = 0.0D;
    private double field_21153_n = 0.0D;
    private long field_1384_l = System.currentTimeMillis();
    private long field_28133_I = 0L;
    private Random field_1383_m = new Random();
    private int field_27287_H = 0;
    volatile int field_1394_b = 0;
    volatile int field_1393_c = 0;
    FloatBuffer field_1392_d = GLAllocation.func_1123_d(16);
    float field_4270_e;
    float field_4269_f;
    float field_4268_g;
    private float field_1382_n;
    private float field_1381_o;

    public EntityRenderer(Minecraft var1) {
        this.field_1388_h = var1;
        this.field_1395_a = new ItemRenderer(var1);
    }

    public void func_911_a() {
        this.field_1382_n = this.field_1381_o;
        this.field_22227_s = this.field_22228_r;
        this.field_22225_u = this.field_22226_t;
        this.field_22223_w = this.field_22224_v;
        this.field_22221_y = this.field_22222_x;
        this.field_22230_A = this.field_22220_z;
        if (this.field_1388_h.field_22009_h == null) {
            this.field_1388_h.field_22009_h = this.field_1388_h.field_6322_g;
        }

        float var1 = this.field_1388_h.field_6324_e.func_598_c(MathHelper.func_1108_b(this.field_1388_h.field_22009_h.field_611_ak), MathHelper.func_1108_b(this.field_1388_h.field_22009_h.field_610_al), MathHelper.func_1108_b(this.field_1388_h.field_22009_h.field_609_am));
        float var2 = (float)(3 - this.field_1388_h.field_6304_y.field_1580_e) / 3.0F;
        float var3 = var1 * (1.0F - var2) + var2;
        this.field_1381_o += (var3 - this.field_1381_o) * 0.1F;
        ++this.field_1386_j;
        this.field_1395_a.func_895_a();
        this.func_916_c();
    }

    public void func_910_a(float var1) {
        if (this.field_1388_h.field_22009_h != null) {
            if (this.field_1388_h.field_6324_e != null) {
                double var2 = (double)this.field_1388_h.field_6327_b.func_727_b();
                this.field_1388_h.field_6305_x = this.field_1388_h.field_22009_h.func_416_a(var2, var1);
                double var4 = var2;
                Vec3D var6 = this.field_1388_h.field_22009_h.func_427_e(var1);
                if (this.field_1388_h.field_6305_x != null) {
                    var4 = this.field_1388_h.field_6305_x.field_1169_f.func_1251_c(var6);
                }

                if (this.field_1388_h.field_6327_b instanceof PlayerControllerTest) {
                    var2 = 32.0D;
                    var4 = 32.0D;
                } else {
                    if (var4 > 3.0D) {
                        var4 = 3.0D;
                    }

                    var2 = var4;
                }

                Vec3D var7 = this.field_1388_h.field_22009_h.func_430_f(var1);
                Vec3D var8 = var6.func_1257_c(var7.field_1776_a * var2, var7.field_1775_b * var2, var7.field_1779_c * var2);
                this.field_1385_k = null;
                float var9 = 1.0F;
                List var10 = this.field_1388_h.field_6324_e.func_659_b(this.field_1388_h.field_22009_h, this.field_1388_h.field_22009_h.field_601_au.func_1170_a(var7.field_1776_a * var2, var7.field_1775_b * var2, var7.field_1779_c * var2).func_1177_b((double)var9, (double)var9, (double)var9));
                double var11 = 0.0D;

                for(int var13 = 0; var13 < var10.size(); ++var13) {
                    Entity var14 = (Entity)var10.get(var13);
                    if (var14.func_401_c_()) {
                        float var15 = var14.func_4035_j_();
                        AxisAlignedBB var16 = var14.field_601_au.func_1177_b((double)var15, (double)var15, (double)var15);
                        MovingObjectPosition var17 = var16.func_1169_a(var6, var8);
                        if (var16.func_4150_a(var6)) {
                            if (0.0D < var11 || var11 == 0.0D) {
                                this.field_1385_k = var14;
                                var11 = 0.0D;
                            }
                        } else if (var17 != null) {
                            double var18 = var6.func_1251_c(var17.field_1169_f);
                            if (var18 < var11 || var11 == 0.0D) {
                                this.field_1385_k = var14;
                                var11 = var18;
                            }
                        }
                    }
                }

                if (this.field_1385_k != null && !(this.field_1388_h.field_6327_b instanceof PlayerControllerTest)) {
                    this.field_1388_h.field_6305_x = new MovingObjectPosition(this.field_1385_k);
                }

            }
        }
    }

    private float func_914_d(float var1) {
        EntityLiving var2 = this.field_1388_h.field_22009_h;
        float var3 = 70.0F;
        if (var2.func_393_a(Material.field_1332_f)) {
            var3 = 60.0F;
        }

        if (var2.field_9337_J <= 0) {
            float var4 = (float)var2.field_712_J + var1;
            var3 /= (1.0F - 500.0F / (var4 + 500.0F)) * 2.0F + 1.0F;
        }

        return var3 + this.field_22221_y + (this.field_22222_x - this.field_22221_y) * var1;
    }

    private void func_920_e(float var1) {
        EntityLiving var2 = this.field_1388_h.field_22009_h;
        float var3 = (float)var2.field_715_G - var1;
        float var4;
        if (var2.field_9337_J <= 0) {
            var4 = (float)var2.field_712_J + var1;
            GL11.glRotatef(40.0F - 8000.0F / (var4 + 200.0F), 0.0F, 0.0F, 1.0F);
        }

        if (var3 >= 0.0F) {
            var3 /= (float)var2.field_9332_M;
            var3 = MathHelper.func_1106_a(var3 * var3 * var3 * var3 * 3.1415927F);
            var4 = var2.field_9331_N;
            GL11.glRotatef(-var4, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-var3 * 14.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(var4, 0.0F, 1.0F, 0.0F);
        }
    }

    private void func_917_f(float var1) {
        if (this.field_1388_h.field_22009_h instanceof EntityPlayer) {
            EntityPlayer var2 = (EntityPlayer)this.field_1388_h.field_22009_h;
            float var3 = var2.field_9290_aS - var2.field_9291_aR;
            float var4 = -(var2.field_9290_aS + var3 * var1);
            float var5 = var2.field_775_e + (var2.field_774_f - var2.field_775_e) * var1;
            float var6 = var2.field_9329_Q + (var2.field_9328_R - var2.field_9329_Q) * var1;
            GL11.glTranslatef(MathHelper.func_1106_a(var4 * 3.1415927F) * var5 * 0.5F, -Math.abs(MathHelper.func_1114_b(var4 * 3.1415927F) * var5), 0.0F);
            GL11.glRotatef(MathHelper.func_1106_a(var4 * 3.1415927F) * var5 * 3.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(Math.abs(MathHelper.func_1114_b(var4 * 3.1415927F - 0.2F) * var5) * 5.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var6, 1.0F, 0.0F, 0.0F);
        }
    }

    private void func_4138_g(float var1) {
        EntityLiving var2 = this.field_1388_h.field_22009_h;
        float var3 = var2.field_9292_aO - 1.62F;
        double var4 = var2.field_9285_at + (var2.field_611_ak - var2.field_9285_at) * (double)var1;
        double var6 = var2.field_9284_au + (var2.field_610_al - var2.field_9284_au) * (double)var1 - (double)var3;
        double var8 = var2.field_9283_av + (var2.field_609_am - var2.field_9283_av) * (double)var1;
        GL11.glRotatef(this.field_22230_A + (this.field_22220_z - this.field_22230_A) * var1, 0.0F, 0.0F, 1.0F);
        if (var2.func_22051_K()) {
            var3 = (float)((double)var3 + 1.0D);
            GL11.glTranslatef(0.0F, 0.3F, 0.0F);
            if (!this.field_1388_h.field_6304_y.field_22273_E) {
                int var10 = this.field_1388_h.field_6324_e.func_600_a(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_610_al), MathHelper.func_1108_b(var2.field_609_am));
                if (var10 == Block.field_9262_S.field_376_bc) {
                    int var11 = this.field_1388_h.field_6324_e.func_602_e(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_610_al), MathHelper.func_1108_b(var2.field_609_am));
                    int var12 = var11 & 3;
                    GL11.glRotatef((float)(var12 * 90), 0.0F, 1.0F, 0.0F);
                }

                GL11.glRotatef(var2.field_603_as + (var2.field_605_aq - var2.field_603_as) * var1 + 180.0F, 0.0F, -1.0F, 0.0F);
                GL11.glRotatef(var2.field_602_at + (var2.field_604_ar - var2.field_602_at) * var1, -1.0F, 0.0F, 0.0F);
            }
        } else if (this.field_1388_h.field_6304_y.field_1560_x) {
            double var27 = (double)(this.field_22227_s + (this.field_22228_r - this.field_22227_s) * var1);
            float var13;
            float var28;
            if (this.field_1388_h.field_6304_y.field_22273_E) {
                var28 = this.field_22225_u + (this.field_22226_t - this.field_22225_u) * var1;
                var13 = this.field_22223_w + (this.field_22224_v - this.field_22223_w) * var1;
                GL11.glTranslatef(0.0F, 0.0F, (float)(-var27));
                GL11.glRotatef(var13, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(var28, 0.0F, 1.0F, 0.0F);
            } else {
                var28 = var2.field_605_aq;
                var13 = var2.field_604_ar;
                double var14 = (double)(-MathHelper.func_1106_a(var28 / 180.0F * 3.1415927F) * MathHelper.func_1114_b(var13 / 180.0F * 3.1415927F)) * var27;
                double var16 = (double)(MathHelper.func_1114_b(var28 / 180.0F * 3.1415927F) * MathHelper.func_1114_b(var13 / 180.0F * 3.1415927F)) * var27;
                double var18 = (double)(-MathHelper.func_1106_a(var13 / 180.0F * 3.1415927F)) * var27;

                for(int var20 = 0; var20 < 8; ++var20) {
                    float var21 = (float)((var20 & 1) * 2 - 1);
                    float var22 = (float)((var20 >> 1 & 1) * 2 - 1);
                    float var23 = (float)((var20 >> 2 & 1) * 2 - 1);
                    var21 *= 0.1F;
                    var22 *= 0.1F;
                    var23 *= 0.1F;
                    MovingObjectPosition var24 = this.field_1388_h.field_6324_e.func_645_a(Vec3D.func_1248_b(var4 + (double)var21, var6 + (double)var22, var8 + (double)var23), Vec3D.func_1248_b(var4 - var14 + (double)var21 + (double)var23, var6 - var18 + (double)var22, var8 - var16 + (double)var23));
                    if (var24 != null) {
                        double var25 = var24.field_1169_f.func_1251_c(Vec3D.func_1248_b(var4, var6, var8));
                        if (var25 < var27) {
                            var27 = var25;
                        }
                    }
                }

                GL11.glRotatef(var2.field_604_ar - var13, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(var2.field_605_aq - var28, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.0F, 0.0F, (float)(-var27));
                GL11.glRotatef(var28 - var2.field_605_aq, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(var13 - var2.field_604_ar, 1.0F, 0.0F, 0.0F);
            }
        } else {
            GL11.glTranslatef(0.0F, 0.0F, -0.1F);
        }

        if (!this.field_1388_h.field_6304_y.field_22273_E) {
            GL11.glRotatef(var2.field_602_at + (var2.field_604_ar - var2.field_602_at) * var1, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var2.field_603_as + (var2.field_605_aq - var2.field_603_as) * var1 + 180.0F, 0.0F, 1.0F, 0.0F);
        }

        GL11.glTranslatef(0.0F, var3, 0.0F);
        var4 = var2.field_9285_at + (var2.field_611_ak - var2.field_9285_at) * (double)var1;
        var6 = var2.field_9284_au + (var2.field_610_al - var2.field_9284_au) * (double)var1 - (double)var3;
        var8 = var2.field_9283_av + (var2.field_609_am - var2.field_9283_av) * (double)var1;
        this.field_27288_B = this.field_1388_h.field_6323_f.func_27307_a(var4, var6, var8, var1);
    }

    private void func_4139_a(float var1, int var2) {
        this.field_1387_i = (float)(256 >> this.field_1388_h.field_6304_y.field_1580_e);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float var3 = 0.07F;
        if (this.field_1388_h.field_6304_y.field_1578_g) {
            GL11.glTranslatef((float)(-(var2 * 2 - 1)) * var3, 0.0F, 0.0F);
        }

        if (this.field_21155_l != 1.0D) {
            GL11.glTranslatef((float)this.field_21154_m, (float)(-this.field_21153_n), 0.0F);
            GL11.glScaled(this.field_21155_l, this.field_21155_l, 1.0D);
            GLU.gluPerspective(this.func_914_d(var1), (float)this.field_1388_h.field_6326_c / (float)this.field_1388_h.field_6325_d, 0.05F, this.field_1387_i * 2.0F);
        } else {
            GLU.gluPerspective(this.func_914_d(var1), (float)this.field_1388_h.field_6326_c / (float)this.field_1388_h.field_6325_d, 0.05F, this.field_1387_i * 2.0F);
        }

        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if (this.field_1388_h.field_6304_y.field_1578_g) {
            GL11.glTranslatef((float)(var2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
        }

        this.func_920_e(var1);
        if (this.field_1388_h.field_6304_y.field_1579_f) {
            this.func_917_f(var1);
        }

        float var4 = this.field_1388_h.field_6322_g.field_28025_B + (this.field_1388_h.field_6322_g.field_28026_A - this.field_1388_h.field_6322_g.field_28025_B) * var1;
        if (var4 > 0.0F) {
            float var5 = 5.0F / (var4 * var4 + 5.0F) - var4 * 0.04F;
            var5 *= var5;
            GL11.glRotatef(((float)this.field_1386_j + var1) * 20.0F, 0.0F, 1.0F, 1.0F);
            GL11.glScalef(1.0F / var5, 1.0F, 1.0F);
            GL11.glRotatef(-((float)this.field_1386_j + var1) * 20.0F, 0.0F, 1.0F, 1.0F);
        }

        this.func_4138_g(var1);
    }

    private void func_4135_b(float var1, int var2) {
        GL11.glLoadIdentity();
        if (this.field_1388_h.field_6304_y.field_1578_g) {
            GL11.glTranslatef((float)(var2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
        }

        GL11.glPushMatrix();
        this.func_920_e(var1);
        if (this.field_1388_h.field_6304_y.field_1579_f) {
            this.func_917_f(var1);
        }

        if (!this.field_1388_h.field_6304_y.field_1560_x && !this.field_1388_h.field_22009_h.func_22051_K() && !this.field_1388_h.field_6304_y.field_22277_y) {
            this.field_1395_a.func_4133_a(var1);
        }

        GL11.glPopMatrix();
        if (!this.field_1388_h.field_6304_y.field_1560_x && !this.field_1388_h.field_22009_h.func_22051_K()) {
            this.field_1395_a.func_893_b(var1);
            this.func_920_e(var1);
        }

        if (this.field_1388_h.field_6304_y.field_1579_f) {
            this.func_917_f(var1);
        }

    }

    public void func_4136_b(float var1) {
        if (!Display.isActive()) {
            if (System.currentTimeMillis() - this.field_1384_l > 500L) {
                this.field_1388_h.func_6252_g();
            }
        } else {
            this.field_1384_l = System.currentTimeMillis();
        }

        if (this.field_1388_h.field_6289_L) {
            this.field_1388_h.field_6299_B.func_772_c();
            float var2 = this.field_1388_h.field_6304_y.field_1582_c * 0.6F + 0.2F;
            float var3 = var2 * var2 * var2 * 8.0F;
            float var4 = (float)this.field_1388_h.field_6299_B.field_1114_a * var3;
            float var5 = (float)this.field_1388_h.field_6299_B.field_1113_b * var3;
            byte var6 = 1;
            if (this.field_1388_h.field_6304_y.field_1581_d) {
                var6 = -1;
            }

            if (this.field_1388_h.field_6304_y.field_22274_D) {
                var4 = this.field_22235_l.func_22386_a(var4, 0.05F * var3);
                var5 = this.field_22234_m.func_22386_a(var5, 0.05F * var3);
            }

            this.field_1388_h.field_6322_g.func_346_d(var4, var5 * (float)var6);
        }

        if (!this.field_1388_h.field_6307_v) {
            field_28135_a = this.field_1388_h.field_6304_y.field_1578_g;
            ScaledResolution var13 = new ScaledResolution(this.field_1388_h.field_6304_y, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
            int var14 = var13.func_903_a();
            int var15 = var13.func_902_b();
            int var16 = Mouse.getX() * var14 / this.field_1388_h.field_6326_c;
            int var17 = var15 - Mouse.getY() * var15 / this.field_1388_h.field_6325_d - 1;
            short var7 = 200;
            if (this.field_1388_h.field_6304_y.field_1577_h == 1) {
                var7 = 120;
            }

            if (this.field_1388_h.field_6304_y.field_1577_h == 2) {
                var7 = 40;
            }

            long var8;
            if (this.field_1388_h.field_6324_e != null) {
                if (this.field_1388_h.field_6304_y.field_1577_h == 0) {
                    this.func_4134_c(var1, 0L);
                } else {
                    this.func_4134_c(var1, this.field_28133_I + (long)(1000000000 / var7));
                }

                if (this.field_1388_h.field_6304_y.field_1577_h == 2) {
                    var8 = (this.field_28133_I + (long)(1000000000 / var7) - System.nanoTime()) / 1000000L;
                    if (var8 > 0L && var8 < 500L) {
                        try {
                            Thread.sleep(var8);
                        } catch (InterruptedException var12) {
                            var12.printStackTrace();
                        }
                    }
                }

                this.field_28133_I = System.nanoTime();
                if (!this.field_1388_h.field_6304_y.field_22277_y || this.field_1388_h.field_6313_p != null) {
                    this.field_1388_h.field_6308_u.func_4066_a(var1, this.field_1388_h.field_6313_p != null, var16, var17);
                }
            } else {
                GL11.glViewport(0, 0, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
                GL11.glMatrixMode(5889);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glLoadIdentity();
                this.func_905_b();
                if (this.field_1388_h.field_6304_y.field_1577_h == 2) {
                    var8 = (this.field_28133_I + (long)(1000000000 / var7) - System.nanoTime()) / 1000000L;
                    if (var8 < 0L) {
                        var8 += 10L;
                    }

                    if (var8 > 0L && var8 < 500L) {
                        try {
                            Thread.sleep(var8);
                        } catch (InterruptedException var11) {
                            var11.printStackTrace();
                        }
                    }
                }

                this.field_28133_I = System.nanoTime();
            }

            if (this.field_1388_h.field_6313_p != null) {
                GL11.glClear(256);
                this.field_1388_h.field_6313_p.func_571_a(var16, var17, var1);
                if (this.field_1388_h.field_6313_p != null && this.field_1388_h.field_6313_p.field_25091_h != null) {
                    this.field_1388_h.field_6313_p.field_25091_h.func_25087_a(var1);
                }
            }

        }
    }

    public void func_4134_c(float var1, long var2) {
        GL11.glEnable(2884);
        GL11.glEnable(2929);
        if (this.field_1388_h.field_22009_h == null) {
            this.field_1388_h.field_22009_h = this.field_1388_h.field_6322_g;
        }

        this.func_910_a(var1);
        EntityLiving var4 = this.field_1388_h.field_22009_h;
        RenderGlobal var5 = this.field_1388_h.field_6323_f;
        EffectRenderer var6 = this.field_1388_h.field_6321_h;
        double var7 = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)var1;
        double var9 = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)var1;
        double var11 = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)var1;
        IChunkProvider var13 = this.field_1388_h.field_6324_e.func_21118_q();
        int var16;
        if (var13 instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate var14 = (ChunkProviderLoadOrGenerate)var13;
            int var15 = MathHelper.func_1110_d((float)((int)var7)) >> 4;
            var16 = MathHelper.func_1110_d((float)((int)var11)) >> 4;
            var14.func_21110_c(var15, var16);
        }

        for(int var18 = 0; var18 < 2; ++var18) {
            if (this.field_1388_h.field_6304_y.field_1578_g) {
                field_28134_b = var18;
                if (field_28134_b == 0) {
                    GL11.glColorMask(false, true, true, false);
                } else {
                    GL11.glColorMask(true, false, false, false);
                }
            }

            GL11.glViewport(0, 0, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
            this.func_4137_h(var1);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            this.func_4139_a(var1, var18);
            ClippingHelperImpl.func_1155_a();
            if (this.field_1388_h.field_6304_y.field_1580_e < 2) {
                this.func_4140_a(-1, var1);
                var5.func_4142_a(var1);
            }

            GL11.glEnable(2912);
            this.func_4140_a(1, var1);
            if (this.field_1388_h.field_6304_y.field_22278_j) {
                GL11.glShadeModel(7425);
            }

            Frustrum var19 = new Frustrum();
            var19.func_343_a(var7, var9, var11);
            this.field_1388_h.field_6323_f.func_960_a(var19, var1);
            if (var18 == 0) {
                while(!this.field_1388_h.field_6323_f.func_948_a(var4, false) && var2 != 0L) {
                    long var20 = var2 - System.nanoTime();
                    if (var20 < 0L || var20 > 1000000000L) {
                        break;
                    }
                }
            }

            this.func_4140_a(0, var1);
            GL11.glEnable(2912);
            GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/terrain.png"));
            RenderHelper.func_1159_a();
            var5.func_943_a(var4, 0, (double)var1);
            GL11.glShadeModel(7424);
            RenderHelper.func_1158_b();
            var5.func_951_a(var4.func_427_e(var1), var19, var1);
            var6.func_1187_b(var4, var1);
            RenderHelper.func_1159_a();
            this.func_4140_a(0, var1);
            var6.func_1189_a(var4, var1);
            EntityPlayer var21;
            if (this.field_1388_h.field_6305_x != null && var4.func_393_a(Material.field_1332_f) && var4 instanceof EntityPlayer) {
                var21 = (EntityPlayer)var4;
                GL11.glDisable(3008);
                var5.func_959_a(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), var1);
                var5.func_955_b(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), var1);
                GL11.glEnable(3008);
            }

            GL11.glBlendFunc(770, 771);
            this.func_4140_a(0, var1);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/terrain.png"));
            if (this.field_1388_h.field_6304_y.field_1576_i) {
                if (this.field_1388_h.field_6304_y.field_22278_j) {
                    GL11.glShadeModel(7425);
                }

                GL11.glColorMask(false, false, false, false);
                var16 = var5.func_943_a(var4, 1, (double)var1);
                if (this.field_1388_h.field_6304_y.field_1578_g) {
                    if (field_28134_b == 0) {
                        GL11.glColorMask(false, true, true, true);
                    } else {
                        GL11.glColorMask(true, false, false, true);
                    }
                } else {
                    GL11.glColorMask(true, true, true, true);
                }

                if (var16 > 0) {
                    var5.func_944_a(1, (double)var1);
                }

                GL11.glShadeModel(7424);
            } else {
                var5.func_943_a(var4, 1, (double)var1);
            }

            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            if (this.field_21155_l == 1.0D && var4 instanceof EntityPlayer && this.field_1388_h.field_6305_x != null && !var4.func_393_a(Material.field_1332_f)) {
                var21 = (EntityPlayer)var4;
                GL11.glDisable(3008);
                var5.func_959_a(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), var1);
                var5.func_955_b(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), var1);
                GL11.glEnable(3008);
            }

            this.func_27286_d(var1);
            GL11.glDisable(2912);
            if (this.field_1385_k != null) {
            }

            this.func_4140_a(0, var1);
            GL11.glEnable(2912);
            var5.func_4141_b(var1);
            GL11.glDisable(2912);
            this.func_4140_a(1, var1);
            if (this.field_21155_l == 1.0D) {
                GL11.glClear(256);
                this.func_4135_b(var1, var18);
            }

            if (!this.field_1388_h.field_6304_y.field_1578_g) {
                return;
            }
        }

        GL11.glColorMask(true, true, true, false);
    }

    private void func_916_c() {
        float var1 = this.field_1388_h.field_6324_e.func_27162_g(1.0F);
        if (!this.field_1388_h.field_6304_y.field_1576_i) {
            var1 /= 2.0F;
        }

        if (var1 != 0.0F) {
            this.field_1383_m.setSeed((long)this.field_1386_j * 312987231L);
            EntityLiving var2 = this.field_1388_h.field_22009_h;
            World var3 = this.field_1388_h.field_6324_e;
            int var4 = MathHelper.func_1108_b(var2.field_611_ak);
            int var5 = MathHelper.func_1108_b(var2.field_610_al);
            int var6 = MathHelper.func_1108_b(var2.field_609_am);
            byte var7 = 10;
            double var8 = 0.0D;
            double var10 = 0.0D;
            double var12 = 0.0D;
            int var14 = 0;

            for(int var15 = 0; var15 < (int)(100.0F * var1 * var1); ++var15) {
                int var16 = var4 + this.field_1383_m.nextInt(var7) - this.field_1383_m.nextInt(var7);
                int var17 = var6 + this.field_1383_m.nextInt(var7) - this.field_1383_m.nextInt(var7);
                int var18 = var3.func_4083_e(var16, var17);
                int var19 = var3.func_600_a(var16, var18 - 1, var17);
                if (var18 <= var5 + var7 && var18 >= var5 - var7 && var3.func_4075_a().func_4073_a(var16, var17).func_27077_d()) {
                    float var20 = this.field_1383_m.nextFloat();
                    float var21 = this.field_1383_m.nextFloat();
                    if (var19 > 0) {
                        if (Block.field_345_n[var19].field_356_bn == Material.field_1331_g) {
                            this.field_1388_h.field_6321_h.func_1192_a(new EntitySmokeFX(var3, (double)((float)var16 + var20), (double)((float)var18 + 0.1F) - Block.field_345_n[var19].field_368_bg, (double)((float)var17 + var21), 0.0D, 0.0D, 0.0D));
                        } else {
                            ++var14;
                            if (this.field_1383_m.nextInt(var14) == 0) {
                                var8 = (double)((float)var16 + var20);
                                var10 = (double)((float)var18 + 0.1F) - Block.field_345_n[var19].field_368_bg;
                                var12 = (double)((float)var17 + var21);
                            }

                            this.field_1388_h.field_6321_h.func_1192_a(new EntityRainFX(var3, (double)((float)var16 + var20), (double)((float)var18 + 0.1F) - Block.field_345_n[var19].field_368_bg, (double)((float)var17 + var21)));
                        }
                    }
                }
            }

            if (var14 > 0 && this.field_1383_m.nextInt(3) < this.field_27287_H++) {
                this.field_27287_H = 0;
                if (var10 > var2.field_610_al + 1.0D && var3.func_4083_e(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_609_am)) > MathHelper.func_1108_b(var2.field_610_al)) {
                    this.field_1388_h.field_6324_e.func_684_a(var8, var10, var12, "ambient.weather.rain", 0.1F, 0.5F);
                } else {
                    this.field_1388_h.field_6324_e.func_684_a(var8, var10, var12, "ambient.weather.rain", 0.2F, 1.0F);
                }
            }

        }
    }

    protected void func_27286_d(float var1) {
        float var2 = this.field_1388_h.field_6324_e.func_27162_g(var1);
        if (var2 > 0.0F) {
            EntityLiving var3 = this.field_1388_h.field_22009_h;
            World var4 = this.field_1388_h.field_6324_e;
            int var5 = MathHelper.func_1108_b(var3.field_611_ak);
            int var6 = MathHelper.func_1108_b(var3.field_610_al);
            int var7 = MathHelper.func_1108_b(var3.field_609_am);
            Tessellator var8 = Tessellator.field_1512_a;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.01F);
            GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/environment/snow.png"));
            double var9 = var3.field_638_aI + (var3.field_611_ak - var3.field_638_aI) * (double)var1;
            double var11 = var3.field_637_aJ + (var3.field_610_al - var3.field_637_aJ) * (double)var1;
            double var13 = var3.field_636_aK + (var3.field_609_am - var3.field_636_aK) * (double)var1;
            int var15 = MathHelper.func_1108_b(var11);
            byte var16 = 5;
            if (this.field_1388_h.field_6304_y.field_1576_i) {
                var16 = 10;
            }

            BiomeGenBase[] var17 = var4.func_4075_a().func_4069_a(var5 - var16, var7 - var16, var16 * 2 + 1, var16 * 2 + 1);
            int var18 = 0;

            int var19;
            int var20;
            BiomeGenBase var21;
            int var22;
            int var23;
            int var24;
            float var26;
            for(var19 = var5 - var16; var19 <= var5 + var16; ++var19) {
                for(var20 = var7 - var16; var20 <= var7 + var16; ++var20) {
                    var21 = var17[var18++];
                    if (var21.func_27078_c()) {
                        var22 = var4.func_4083_e(var19, var20);
                        if (var22 < 0) {
                            var22 = 0;
                        }

                        var23 = var22;
                        if (var22 < var15) {
                            var23 = var15;
                        }

                        var24 = var6 - var16;
                        int var25 = var6 + var16;
                        if (var24 < var22) {
                            var24 = var22;
                        }

                        if (var25 < var22) {
                            var25 = var22;
                        }

                        var26 = 1.0F;
                        if (var24 != var25) {
                            this.field_1383_m.setSeed((long)(var19 * var19 * 3121 + var19 * 45238971 + var20 * var20 * 418711 + var20 * 13761));
                            float var27 = (float)this.field_1386_j + var1;
                            float var28 = ((float)(this.field_1386_j & 511) + var1) / 512.0F;
                            float var29 = this.field_1383_m.nextFloat() + var27 * 0.01F * (float)this.field_1383_m.nextGaussian();
                            float var30 = this.field_1383_m.nextFloat() + var27 * (float)this.field_1383_m.nextGaussian() * 0.001F;
                            double var31 = (double)((float)var19 + 0.5F) - var3.field_611_ak;
                            double var33 = (double)((float)var20 + 0.5F) - var3.field_609_am;
                            float var35 = MathHelper.func_1109_a(var31 * var31 + var33 * var33) / (float)var16;
                            var8.func_977_b();
                            float var36 = var4.func_598_c(var19, var23, var20);
                            GL11.glColor4f(var36, var36, var36, ((1.0F - var35 * var35) * 0.3F + 0.5F) * var2);
                            var8.func_984_b(-var9 * 1.0D, -var11 * 1.0D, -var13 * 1.0D);
                            var8.func_983_a((double)(var19 + 0), (double)var24, (double)var20 + 0.5D, (double)(0.0F * var26 + var29), (double)((float)var24 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)(var19 + 1), (double)var24, (double)var20 + 0.5D, (double)(1.0F * var26 + var29), (double)((float)var24 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)(var19 + 1), (double)var25, (double)var20 + 0.5D, (double)(1.0F * var26 + var29), (double)((float)var25 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)(var19 + 0), (double)var25, (double)var20 + 0.5D, (double)(0.0F * var26 + var29), (double)((float)var25 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)var19 + 0.5D, (double)var24, (double)(var20 + 0), (double)(0.0F * var26 + var29), (double)((float)var24 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)var19 + 0.5D, (double)var24, (double)(var20 + 1), (double)(1.0F * var26 + var29), (double)((float)var24 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)var19 + 0.5D, (double)var25, (double)(var20 + 1), (double)(1.0F * var26 + var29), (double)((float)var25 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_983_a((double)var19 + 0.5D, (double)var25, (double)(var20 + 0), (double)(0.0F * var26 + var29), (double)((float)var25 * var26 / 4.0F + var28 * var26 + var30));
                            var8.func_984_b(0.0D, 0.0D, 0.0D);
                            var8.func_982_a();
                        }
                    }
                }
            }

            GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/environment/rain.png"));
            if (this.field_1388_h.field_6304_y.field_1576_i) {
                var16 = 10;
            }

            var18 = 0;

            for(var19 = var5 - var16; var19 <= var5 + var16; ++var19) {
                for(var20 = var7 - var16; var20 <= var7 + var16; ++var20) {
                    var21 = var17[var18++];
                    if (var21.func_27077_d()) {
                        var22 = var4.func_4083_e(var19, var20);
                        var23 = var6 - var16;
                        var24 = var6 + var16;
                        if (var23 < var22) {
                            var23 = var22;
                        }

                        if (var24 < var22) {
                            var24 = var22;
                        }

                        float var37 = 1.0F;
                        if (var23 != var24) {
                            this.field_1383_m.setSeed((long)(var19 * var19 * 3121 + var19 * 45238971 + var20 * var20 * 418711 + var20 * 13761));
                            var26 = ((float)(this.field_1386_j + var19 * var19 * 3121 + var19 * 45238971 + var20 * var20 * 418711 + var20 * 13761 & 31) + var1) / 32.0F * (3.0F + this.field_1383_m.nextFloat());
                            double var38 = (double)((float)var19 + 0.5F) - var3.field_611_ak;
                            double var39 = (double)((float)var20 + 0.5F) - var3.field_609_am;
                            float var40 = MathHelper.func_1109_a(var38 * var38 + var39 * var39) / (float)var16;
                            var8.func_977_b();
                            float var32 = var4.func_598_c(var19, 128, var20) * 0.85F + 0.15F;
                            GL11.glColor4f(var32, var32, var32, ((1.0F - var40 * var40) * 0.5F + 0.5F) * var2);
                            var8.func_984_b(-var9 * 1.0D, -var11 * 1.0D, -var13 * 1.0D);
                            var8.func_983_a((double)(var19 + 0), (double)var23, (double)var20 + 0.5D, (double)(0.0F * var37), (double)((float)var23 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)(var19 + 1), (double)var23, (double)var20 + 0.5D, (double)(1.0F * var37), (double)((float)var23 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)(var19 + 1), (double)var24, (double)var20 + 0.5D, (double)(1.0F * var37), (double)((float)var24 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)(var19 + 0), (double)var24, (double)var20 + 0.5D, (double)(0.0F * var37), (double)((float)var24 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)var19 + 0.5D, (double)var23, (double)(var20 + 0), (double)(0.0F * var37), (double)((float)var23 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)var19 + 0.5D, (double)var23, (double)(var20 + 1), (double)(1.0F * var37), (double)((float)var23 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)var19 + 0.5D, (double)var24, (double)(var20 + 1), (double)(1.0F * var37), (double)((float)var24 * var37 / 4.0F + var26 * var37));
                            var8.func_983_a((double)var19 + 0.5D, (double)var24, (double)(var20 + 0), (double)(0.0F * var37), (double)((float)var24 * var37 / 4.0F + var26 * var37));
                            var8.func_984_b(0.0D, 0.0D, 0.0D);
                            var8.func_982_a();
                        }
                    }
                }
            }

            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1F);
        }
    }

    public void func_905_b() {
        ScaledResolution var1 = new ScaledResolution(this.field_1388_h.field_6304_y, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, var1.field_25121_a, var1.field_25120_b, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
    }

    private void func_4137_h(float var1) {
        World var2 = this.field_1388_h.field_6324_e;
        EntityLiving var3 = this.field_1388_h.field_22009_h;
        float var4 = 1.0F / (float)(4 - this.field_1388_h.field_6304_y.field_1580_e);
        var4 = 1.0F - (float)Math.pow((double)var4, 0.25D);
        Vec3D var5 = var2.func_4079_a(this.field_1388_h.field_22009_h, var1);
        float var6 = (float)var5.field_1776_a;
        float var7 = (float)var5.field_1775_b;
        float var8 = (float)var5.field_1779_c;
        Vec3D var9 = var2.func_4082_d(var1);
        this.field_4270_e = (float)var9.field_1776_a;
        this.field_4269_f = (float)var9.field_1775_b;
        this.field_4268_g = (float)var9.field_1779_c;
        this.field_4270_e += (var6 - this.field_4270_e) * var4;
        this.field_4269_f += (var7 - this.field_4269_f) * var4;
        this.field_4268_g += (var8 - this.field_4268_g) * var4;
        float var10 = var2.func_27162_g(var1);
        float var11;
        float var12;
        if (var10 > 0.0F) {
            var11 = 1.0F - var10 * 0.5F;
            var12 = 1.0F - var10 * 0.4F;
            this.field_4270_e *= var11;
            this.field_4269_f *= var11;
            this.field_4268_g *= var12;
        }

        var11 = var2.func_27166_f(var1);
        if (var11 > 0.0F) {
            var12 = 1.0F - var11 * 0.5F;
            this.field_4270_e *= var12;
            this.field_4269_f *= var12;
            this.field_4268_g *= var12;
        }

        if (this.field_27288_B) {
            Vec3D var16 = var2.func_628_d(var1);
            this.field_4270_e = (float)var16.field_1776_a;
            this.field_4269_f = (float)var16.field_1775_b;
            this.field_4268_g = (float)var16.field_1779_c;
        } else if (var3.func_393_a(Material.field_1332_f)) {
            this.field_4270_e = 0.02F;
            this.field_4269_f = 0.02F;
            this.field_4268_g = 0.2F;
        } else if (var3.func_393_a(Material.field_1331_g)) {
            this.field_4270_e = 0.6F;
            this.field_4269_f = 0.1F;
            this.field_4268_g = 0.0F;
        }

        var12 = this.field_1382_n + (this.field_1381_o - this.field_1382_n) * var1;
        this.field_4270_e *= var12;
        this.field_4269_f *= var12;
        this.field_4268_g *= var12;
        if (this.field_1388_h.field_6304_y.field_1578_g) {
            float var13 = (this.field_4270_e * 30.0F + this.field_4269_f * 59.0F + this.field_4268_g * 11.0F) / 100.0F;
            float var14 = (this.field_4270_e * 30.0F + this.field_4269_f * 70.0F) / 100.0F;
            float var15 = (this.field_4270_e * 30.0F + this.field_4268_g * 70.0F) / 100.0F;
            this.field_4270_e = var13;
            this.field_4269_f = var14;
            this.field_4268_g = var15;
        }

        GL11.glClearColor(this.field_4270_e, this.field_4269_f, this.field_4268_g, 0.0F);
    }

    private void func_4140_a(int var1, float var2) {
        EntityLiving var3 = this.field_1388_h.field_22009_h;
        GL11.glFog(2918, this.func_908_a(this.field_4270_e, this.field_4269_f, this.field_4268_g, 1.0F));
        GL11.glNormal3f(0.0F, -1.0F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float var4;
        float var5;
        float var6;
        float var7;
        float var8;
        float var9;
        if (this.field_27288_B) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1F);
            var4 = 1.0F;
            var5 = 1.0F;
            var6 = 1.0F;
            if (this.field_1388_h.field_6304_y.field_1578_g) {
                var7 = (var4 * 30.0F + var5 * 59.0F + var6 * 11.0F) / 100.0F;
                var8 = (var4 * 30.0F + var5 * 70.0F) / 100.0F;
                var9 = (var4 * 30.0F + var6 * 70.0F) / 100.0F;
            }
        } else if (var3.func_393_a(Material.field_1332_f)) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1F);
            var4 = 0.4F;
            var5 = 0.4F;
            var6 = 0.9F;
            if (this.field_1388_h.field_6304_y.field_1578_g) {
                var7 = (var4 * 30.0F + var5 * 59.0F + var6 * 11.0F) / 100.0F;
                var8 = (var4 * 30.0F + var5 * 70.0F) / 100.0F;
                var9 = (var4 * 30.0F + var6 * 70.0F) / 100.0F;
            }
        } else if (var3.func_393_a(Material.field_1331_g)) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0F);
            var4 = 0.4F;
            var5 = 0.3F;
            var6 = 0.3F;
            if (this.field_1388_h.field_6304_y.field_1578_g) {
                var7 = (var4 * 30.0F + var5 * 59.0F + var6 * 11.0F) / 100.0F;
                var8 = (var4 * 30.0F + var5 * 70.0F) / 100.0F;
                var9 = (var4 * 30.0F + var6 * 70.0F) / 100.0F;
            }
        } else {
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, this.field_1387_i * 0.25F);
            GL11.glFogf(2916, this.field_1387_i);
            if (var1 < 0) {
                GL11.glFogf(2915, 0.0F);
                GL11.glFogf(2916, this.field_1387_i * 0.8F);
            }

            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GL11.glFogi(34138, 34139);
            }

            if (this.field_1388_h.field_6324_e.field_4209_q.field_4220_c) {
                GL11.glFogf(2915, 0.0F);
            }
        }

        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
    }

    private FloatBuffer func_908_a(float var1, float var2, float var3, float var4) {
        this.field_1392_d.clear();
        this.field_1392_d.put(var1).put(var2).put(var3).put(var4);
        this.field_1392_d.flip();
        return this.field_1392_d;
    }
}
