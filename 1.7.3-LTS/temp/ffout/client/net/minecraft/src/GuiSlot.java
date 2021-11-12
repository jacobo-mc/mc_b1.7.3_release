package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public abstract class GuiSlot {
    private final Minecraft field_22264_a;
    private final int field_22263_b;
    private final int field_22262_c;
    protected final int field_22261_d;
    protected final int field_22260_e;
    private final int field_22259_f;
    private final int field_22258_g;
    protected final int field_22257_h;
    private int field_22256_i;
    private int field_22255_j;
    private float field_22254_k = -2.0F;
    private float field_22253_l;
    private float field_22252_m;
    private int field_22251_n = -1;
    private long field_22250_o = 0L;
    private boolean field_25123_p = true;
    private boolean field_27262_q;
    private int field_27261_r;

    public GuiSlot(Minecraft var1, int var2, int var3, int var4, int var5, int var6) {
        this.field_22264_a = var1;
        this.field_22263_b = var2;
        this.field_22262_c = var3;
        this.field_22261_d = var4;
        this.field_22260_e = var5;
        this.field_22257_h = var6;
        this.field_22258_g = 0;
        this.field_22259_f = var2;
    }

    public void func_27258_a(boolean var1) {
        this.field_25123_p = var1;
    }

    protected void func_27259_a(boolean var1, int var2) {
        this.field_27262_q = var1;
        this.field_27261_r = var2;
        if (!var1) {
            this.field_27261_r = 0;
        }

    }

    protected abstract int func_22249_a();

    protected abstract void func_22247_a(int var1, boolean var2);

    protected abstract boolean func_22246_a(int var1);

    protected int func_22245_b() {
        return this.func_22249_a() * this.field_22257_h + this.field_27261_r;
    }

    protected abstract void func_22248_c();

    protected abstract void func_22242_a(int var1, int var2, int var3, int var4, Tessellator var5);

    protected void func_27260_a(int var1, int var2, Tessellator var3) {
    }

    protected void func_27255_a(int var1, int var2) {
    }

    protected void func_27257_b(int var1, int var2) {
    }

    public int func_27256_c(int var1, int var2) {
        int var3 = this.field_22263_b / 2 - 110;
        int var4 = this.field_22263_b / 2 + 110;
        int var5 = var2 - this.field_22261_d - this.field_27261_r + (int)this.field_22252_m - 4;
        int var6 = var5 / this.field_22257_h;
        return var1 >= var3 && var1 <= var4 && var6 >= 0 && var5 >= 0 && var6 < this.func_22249_a() ? var6 : -1;
    }

    public void func_22240_a(List var1, int var2, int var3) {
        this.field_22256_i = var2;
        this.field_22255_j = var3;
    }

    private void func_22244_d() {
        int var1 = this.func_22245_b() - (this.field_22260_e - this.field_22261_d - 4);
        if (var1 < 0) {
            var1 /= 2;
        }

        if (this.field_22252_m < 0.0F) {
            this.field_22252_m = 0.0F;
        }

        if (this.field_22252_m > (float)var1) {
            this.field_22252_m = (float)var1;
        }

    }

    public void func_22241_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == this.field_22256_i) {
                this.field_22252_m -= (float)(this.field_22257_h * 2 / 3);
                this.field_22254_k = -2.0F;
                this.func_22244_d();
            } else if (var1.field_938_f == this.field_22255_j) {
                this.field_22252_m += (float)(this.field_22257_h * 2 / 3);
                this.field_22254_k = -2.0F;
                this.func_22244_d();
            }

        }
    }

    public void func_22243_a(int var1, int var2, float var3) {
        this.func_22248_c();
        int var4 = this.func_22249_a();
        int var5 = this.field_22263_b / 2 + 124;
        int var6 = var5 + 6;
        int var9;
        int var10;
        int var11;
        int var13;
        int var19;
        if (Mouse.isButtonDown(0)) {
            if (this.field_22254_k == -1.0F) {
                boolean var7 = true;
                if (var2 >= this.field_22261_d && var2 <= this.field_22260_e) {
                    int var8 = this.field_22263_b / 2 - 110;
                    var9 = this.field_22263_b / 2 + 110;
                    var10 = var2 - this.field_22261_d - this.field_27261_r + (int)this.field_22252_m - 4;
                    var11 = var10 / this.field_22257_h;
                    if (var1 >= var8 && var1 <= var9 && var11 >= 0 && var10 >= 0 && var11 < var4) {
                        boolean var12 = var11 == this.field_22251_n && System.currentTimeMillis() - this.field_22250_o < 250L;
                        this.func_22247_a(var11, var12);
                        this.field_22251_n = var11;
                        this.field_22250_o = System.currentTimeMillis();
                    } else if (var1 >= var8 && var1 <= var9 && var10 < 0) {
                        this.func_27255_a(var1 - var8, var2 - this.field_22261_d + (int)this.field_22252_m - 4);
                        var7 = false;
                    }

                    if (var1 >= var5 && var1 <= var6) {
                        this.field_22253_l = -1.0F;
                        var19 = this.func_22245_b() - (this.field_22260_e - this.field_22261_d - 4);
                        if (var19 < 1) {
                            var19 = 1;
                        }

                        var13 = (int)((float)((this.field_22260_e - this.field_22261_d) * (this.field_22260_e - this.field_22261_d)) / (float)this.func_22245_b());
                        if (var13 < 32) {
                            var13 = 32;
                        }

                        if (var13 > this.field_22260_e - this.field_22261_d - 8) {
                            var13 = this.field_22260_e - this.field_22261_d - 8;
                        }

                        this.field_22253_l /= (float)(this.field_22260_e - this.field_22261_d - var13) / (float)var19;
                    } else {
                        this.field_22253_l = 1.0F;
                    }

                    if (var7) {
                        this.field_22254_k = (float)var2;
                    } else {
                        this.field_22254_k = -2.0F;
                    }
                } else {
                    this.field_22254_k = -2.0F;
                }
            } else if (this.field_22254_k >= 0.0F) {
                this.field_22252_m -= ((float)var2 - this.field_22254_k) * this.field_22253_l;
                this.field_22254_k = (float)var2;
            }
        } else {
            this.field_22254_k = -1.0F;
        }

        this.func_22244_d();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator var16 = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, this.field_22264_a.field_6315_n.func_1070_a("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float var17 = 32.0F;
        var16.func_977_b();
        var16.func_990_b(2105376);
        var16.func_983_a((double)this.field_22258_g, (double)this.field_22260_e, 0.0D, (double)((float)this.field_22258_g / var17), (double)((float)(this.field_22260_e + (int)this.field_22252_m) / var17));
        var16.func_983_a((double)this.field_22259_f, (double)this.field_22260_e, 0.0D, (double)((float)this.field_22259_f / var17), (double)((float)(this.field_22260_e + (int)this.field_22252_m) / var17));
        var16.func_983_a((double)this.field_22259_f, (double)this.field_22261_d, 0.0D, (double)((float)this.field_22259_f / var17), (double)((float)(this.field_22261_d + (int)this.field_22252_m) / var17));
        var16.func_983_a((double)this.field_22258_g, (double)this.field_22261_d, 0.0D, (double)((float)this.field_22258_g / var17), (double)((float)(this.field_22261_d + (int)this.field_22252_m) / var17));
        var16.func_982_a();
        var9 = this.field_22263_b / 2 - 92 - 16;
        var10 = this.field_22261_d + 4 - (int)this.field_22252_m;
        if (this.field_27262_q) {
            this.func_27260_a(var9, var10, var16);
        }

        int var14;
        for(var11 = 0; var11 < var4; ++var11) {
            var19 = var10 + var11 * this.field_22257_h + this.field_27261_r;
            var13 = this.field_22257_h - 4;
            if (var19 <= this.field_22260_e && var19 + var13 >= this.field_22261_d) {
                if (this.field_25123_p && this.func_22246_a(var11)) {
                    var14 = this.field_22263_b / 2 - 110;
                    int var15 = this.field_22263_b / 2 + 110;
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glDisable(3553);
                    var16.func_977_b();
                    var16.func_990_b(8421504);
                    var16.func_983_a((double)var14, (double)(var19 + var13 + 2), 0.0D, 0.0D, 1.0D);
                    var16.func_983_a((double)var15, (double)(var19 + var13 + 2), 0.0D, 1.0D, 1.0D);
                    var16.func_983_a((double)var15, (double)(var19 - 2), 0.0D, 1.0D, 0.0D);
                    var16.func_983_a((double)var14, (double)(var19 - 2), 0.0D, 0.0D, 0.0D);
                    var16.func_990_b(0);
                    var16.func_983_a((double)(var14 + 1), (double)(var19 + var13 + 1), 0.0D, 0.0D, 1.0D);
                    var16.func_983_a((double)(var15 - 1), (double)(var19 + var13 + 1), 0.0D, 1.0D, 1.0D);
                    var16.func_983_a((double)(var15 - 1), (double)(var19 - 1), 0.0D, 1.0D, 0.0D);
                    var16.func_983_a((double)(var14 + 1), (double)(var19 - 1), 0.0D, 0.0D, 0.0D);
                    var16.func_982_a();
                    GL11.glEnable(3553);
                }

                this.func_22242_a(var11, var9, var19, var13, var16);
            }
        }

        GL11.glDisable(2929);
        byte var18 = 4;
        this.func_22239_a(0, this.field_22261_d, 255, 255);
        this.func_22239_a(this.field_22260_e, this.field_22262_c, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        var16.func_977_b();
        var16.func_6513_a(0, 0);
        var16.func_983_a((double)this.field_22258_g, (double)(this.field_22261_d + var18), 0.0D, 0.0D, 1.0D);
        var16.func_983_a((double)this.field_22259_f, (double)(this.field_22261_d + var18), 0.0D, 1.0D, 1.0D);
        var16.func_6513_a(0, 255);
        var16.func_983_a((double)this.field_22259_f, (double)this.field_22261_d, 0.0D, 1.0D, 0.0D);
        var16.func_983_a((double)this.field_22258_g, (double)this.field_22261_d, 0.0D, 0.0D, 0.0D);
        var16.func_982_a();
        var16.func_977_b();
        var16.func_6513_a(0, 255);
        var16.func_983_a((double)this.field_22258_g, (double)this.field_22260_e, 0.0D, 0.0D, 1.0D);
        var16.func_983_a((double)this.field_22259_f, (double)this.field_22260_e, 0.0D, 1.0D, 1.0D);
        var16.func_6513_a(0, 0);
        var16.func_983_a((double)this.field_22259_f, (double)(this.field_22260_e - var18), 0.0D, 1.0D, 0.0D);
        var16.func_983_a((double)this.field_22258_g, (double)(this.field_22260_e - var18), 0.0D, 0.0D, 0.0D);
        var16.func_982_a();
        var19 = this.func_22245_b() - (this.field_22260_e - this.field_22261_d - 4);
        if (var19 > 0) {
            var13 = (this.field_22260_e - this.field_22261_d) * (this.field_22260_e - this.field_22261_d) / this.func_22245_b();
            if (var13 < 32) {
                var13 = 32;
            }

            if (var13 > this.field_22260_e - this.field_22261_d - 8) {
                var13 = this.field_22260_e - this.field_22261_d - 8;
            }

            var14 = (int)this.field_22252_m * (this.field_22260_e - this.field_22261_d - var13) / var19 + this.field_22261_d;
            if (var14 < this.field_22261_d) {
                var14 = this.field_22261_d;
            }

            var16.func_977_b();
            var16.func_6513_a(0, 255);
            var16.func_983_a((double)var5, (double)this.field_22260_e, 0.0D, 0.0D, 1.0D);
            var16.func_983_a((double)var6, (double)this.field_22260_e, 0.0D, 1.0D, 1.0D);
            var16.func_983_a((double)var6, (double)this.field_22261_d, 0.0D, 1.0D, 0.0D);
            var16.func_983_a((double)var5, (double)this.field_22261_d, 0.0D, 0.0D, 0.0D);
            var16.func_982_a();
            var16.func_977_b();
            var16.func_6513_a(8421504, 255);
            var16.func_983_a((double)var5, (double)(var14 + var13), 0.0D, 0.0D, 1.0D);
            var16.func_983_a((double)var6, (double)(var14 + var13), 0.0D, 1.0D, 1.0D);
            var16.func_983_a((double)var6, (double)var14, 0.0D, 1.0D, 0.0D);
            var16.func_983_a((double)var5, (double)var14, 0.0D, 0.0D, 0.0D);
            var16.func_982_a();
            var16.func_977_b();
            var16.func_6513_a(12632256, 255);
            var16.func_983_a((double)var5, (double)(var14 + var13 - 1), 0.0D, 0.0D, 1.0D);
            var16.func_983_a((double)(var6 - 1), (double)(var14 + var13 - 1), 0.0D, 1.0D, 1.0D);
            var16.func_983_a((double)(var6 - 1), (double)var14, 0.0D, 1.0D, 0.0D);
            var16.func_983_a((double)var5, (double)var14, 0.0D, 0.0D, 0.0D);
            var16.func_982_a();
        }

        this.func_27257_b(var1, var2);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    private void func_22239_a(int var1, int var2, int var3, int var4) {
        Tessellator var5 = Tessellator.field_1512_a;
        GL11.glBindTexture(3553, this.field_22264_a.field_6315_n.func_1070_a("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float var6 = 32.0F;
        var5.func_977_b();
        var5.func_6513_a(4210752, var4);
        var5.func_983_a(0.0D, (double)var2, 0.0D, 0.0D, (double)((float)var2 / var6));
        var5.func_983_a((double)this.field_22263_b, (double)var2, 0.0D, (double)((float)this.field_22263_b / var6), (double)((float)var2 / var6));
        var5.func_6513_a(4210752, var3);
        var5.func_983_a((double)this.field_22263_b, (double)var1, 0.0D, (double)((float)this.field_22263_b / var6), (double)((float)var1 / var6));
        var5.func_983_a(0.0D, (double)var1, 0.0D, 0.0D, (double)((float)var1 / var6));
        var5.func_982_a();
    }
}
