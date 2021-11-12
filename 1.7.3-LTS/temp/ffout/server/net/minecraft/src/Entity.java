package net.minecraft.src;

import java.util.List;
import java.util.Random;

public abstract class Entity {
    private static int field_384_a = 0;
    public int field_331_c;
    public double field_9094_h;
    public boolean field_329_e;
    public Entity field_328_f;
    public Entity field_327_g;
    public World field_9093_l;
    public double field_9092_m;
    public double field_9091_n;
    public double field_9090_o;
    public double field_322_l;
    public double field_321_m;
    public double field_320_n;
    public double field_319_o;
    public double field_318_p;
    public double field_317_q;
    public float field_316_r;
    public float field_315_s;
    public float field_9089_x;
    public float field_9088_y;
    public final AxisAlignedBB field_312_v;
    public boolean field_9086_A;
    public boolean field_9084_B;
    public boolean field_9082_C;
    public boolean field_9080_D;
    public boolean field_9078_E;
    public boolean field_27012_bb;
    public boolean field_9077_F;
    public boolean field_304_B;
    public float field_9076_H;
    public float field_300_D;
    public float field_298_E;
    public float field_9075_K;
    public float field_9074_L;
    protected float field_9072_N;
    private int field_6151_b;
    public double field_9071_O;
    public double field_9070_P;
    public double field_9069_Q;
    public float field_9068_R;
    public float field_9067_S;
    public boolean field_9066_T;
    public float field_286_P;
    protected Random field_9064_W;
    public int field_9063_X;
    public int field_9062_Y;
    public int field_9061_Z;
    protected int field_9087_aa;
    protected boolean field_9085_ab;
    public int field_9083_ac;
    public int field_9081_ad;
    private boolean field_4131_c;
    protected boolean field_9079_ae;
    protected DataWatcher field_21045_af;
    public float field_31001_bF;
    private double field_4130_d;
    private double field_4128_e;
    public boolean field_276_Z;
    public int field_307_aa;
    public int field_305_ab;
    public int field_303_ac;
    public boolean field_28008_bI;

    public Entity(World var1) {
        this.field_331_c = field_384_a++;
        this.field_9094_h = 1.0D;
        this.field_329_e = false;
        this.field_312_v = AxisAlignedBB.func_698_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        this.field_9086_A = false;
        this.field_9080_D = false;
        this.field_9078_E = false;
        this.field_9077_F = true;
        this.field_304_B = false;
        this.field_9076_H = 0.0F;
        this.field_300_D = 0.6F;
        this.field_298_E = 1.8F;
        this.field_9075_K = 0.0F;
        this.field_9074_L = 0.0F;
        this.field_9072_N = 0.0F;
        this.field_6151_b = 1;
        this.field_9068_R = 0.0F;
        this.field_9067_S = 0.0F;
        this.field_9066_T = false;
        this.field_286_P = 0.0F;
        this.field_9064_W = new Random();
        this.field_9063_X = 0;
        this.field_9062_Y = 1;
        this.field_9061_Z = 0;
        this.field_9087_aa = 300;
        this.field_9085_ab = false;
        this.field_9083_ac = 0;
        this.field_9081_ad = 300;
        this.field_4131_c = true;
        this.field_9079_ae = false;
        this.field_21045_af = new DataWatcher();
        this.field_31001_bF = 0.0F;
        this.field_276_Z = false;
        this.field_9093_l = var1;
        this.func_86_a(0.0D, 0.0D, 0.0D);
        this.field_21045_af.func_21153_a(0, (byte)0);
        this.func_21044_a();
    }

    protected abstract void func_21044_a();

    public DataWatcher func_21039_p() {
        return this.field_21045_af;
    }

    public boolean equals(Object var1) {
        if (var1 instanceof Entity) {
            return ((Entity)var1).field_331_c == this.field_331_c;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.field_331_c;
    }

    public void func_118_j() {
        this.field_304_B = true;
    }

    protected void func_113_a(float var1, float var2) {
        this.field_300_D = var1;
        this.field_298_E = var2;
    }

    protected void func_6096_b(float var1, float var2) {
        this.field_316_r = var1 % 360.0F;
        this.field_315_s = var2 % 360.0F;
    }

    public void func_86_a(double var1, double var3, double var5) {
        this.field_322_l = var1;
        this.field_321_m = var3;
        this.field_320_n = var5;
        float var7 = this.field_300_D / 2.0F;
        float var8 = this.field_298_E;
        this.field_312_v.func_695_c(var1 - (double)var7, var3 - (double)this.field_9076_H + (double)this.field_9068_R, var5 - (double)var7, var1 + (double)var7, var3 - (double)this.field_9076_H + (double)this.field_9068_R + (double)var8, var5 + (double)var7);
    }

    public void func_106_b_() {
        this.func_84_k();
    }

    public void func_84_k() {
        if (this.field_327_g != null && this.field_327_g.field_304_B) {
            this.field_327_g = null;
        }

        ++this.field_9063_X;
        this.field_9075_K = this.field_9074_L;
        this.field_9092_m = this.field_322_l;
        this.field_9091_n = this.field_321_m;
        this.field_9090_o = this.field_320_n;
        this.field_9088_y = this.field_315_s;
        this.field_9089_x = this.field_316_r;
        if (this.func_119_o()) {
            if (!this.field_9085_ab && !this.field_4131_c) {
                float var1 = MathHelper.func_583_a(this.field_319_o * this.field_319_o * 0.20000000298023224D + this.field_318_p * this.field_318_p + this.field_317_q * this.field_317_q * 0.20000000298023224D) * 0.2F;
                if (var1 > 1.0F) {
                    var1 = 1.0F;
                }

                this.field_9093_l.func_506_a(this, "random.splash", var1, 1.0F + (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.4F);
                float var2 = (float)MathHelper.func_584_b(this.field_312_v.field_963_b);

                int var3;
                float var4;
                float var5;
                for(var3 = 0; (float)var3 < 1.0F + this.field_300_D * 20.0F; ++var3) {
                    var4 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                    var5 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                    this.field_9093_l.func_514_a("bubble", this.field_322_l + (double)var4, (double)(var2 + 1.0F), this.field_320_n + (double)var5, this.field_319_o, this.field_318_p - (double)(this.field_9064_W.nextFloat() * 0.2F), this.field_317_q);
                }

                for(var3 = 0; (float)var3 < 1.0F + this.field_300_D * 20.0F; ++var3) {
                    var4 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                    var5 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                    this.field_9093_l.func_514_a("splash", this.field_322_l + (double)var4, (double)(var2 + 1.0F), this.field_320_n + (double)var5, this.field_319_o, this.field_318_p, this.field_317_q);
                }
            }

            this.field_9072_N = 0.0F;
            this.field_9085_ab = true;
            this.field_9061_Z = 0;
        } else {
            this.field_9085_ab = false;
        }

        if (this.field_9093_l.field_792_x) {
            this.field_9061_Z = 0;
        } else if (this.field_9061_Z > 0) {
            if (this.field_9079_ae) {
                this.field_9061_Z -= 4;
                if (this.field_9061_Z < 0) {
                    this.field_9061_Z = 0;
                }
            } else {
                if (this.field_9061_Z % 20 == 0) {
                    this.func_121_a((Entity)null, 1);
                }

                --this.field_9061_Z;
            }
        }

        if (this.func_112_q()) {
            this.func_4040_n();
        }

        if (this.field_321_m < -64.0D) {
            this.func_4043_o();
        }

        if (!this.field_9093_l.field_792_x) {
            this.func_21041_a(0, this.field_9061_Z > 0);
            this.func_21041_a(2, this.field_327_g != null);
        }

        this.field_4131_c = false;
    }

    protected void func_4040_n() {
        if (!this.field_9079_ae) {
            this.func_121_a((Entity)null, 4);
            this.field_9061_Z = 600;
        }

    }

    protected void func_4043_o() {
        this.func_118_j();
    }

    public boolean func_133_b(double var1, double var3, double var5) {
        AxisAlignedBB var7 = this.field_312_v.func_696_c(var1, var3, var5);
        List var8 = this.field_9093_l.func_481_a(this, var7);
        if (var8.size() > 0) {
            return false;
        } else {
            return !this.field_9093_l.func_469_b(var7);
        }
    }

    public void func_88_c(double var1, double var3, double var5) {
        if (this.field_9066_T) {
            this.field_312_v.func_702_d(var1, var3, var5);
            this.field_322_l = (this.field_312_v.field_964_a + this.field_312_v.field_969_d) / 2.0D;
            this.field_321_m = this.field_312_v.field_963_b + (double)this.field_9076_H - (double)this.field_9068_R;
            this.field_320_n = (this.field_312_v.field_970_c + this.field_312_v.field_967_f) / 2.0D;
        } else {
            this.field_9068_R *= 0.4F;
            double var7 = this.field_322_l;
            double var9 = this.field_320_n;
            if (this.field_27012_bb) {
                this.field_27012_bb = false;
                var1 *= 0.25D;
                var3 *= 0.05000000074505806D;
                var5 *= 0.25D;
                this.field_319_o = 0.0D;
                this.field_318_p = 0.0D;
                this.field_317_q = 0.0D;
            }

            double var11 = var1;
            double var13 = var3;
            double var15 = var5;
            AxisAlignedBB var17 = this.field_312_v.func_711_b();
            boolean var18 = this.field_9086_A && this.func_9059_p();
            if (var18) {
                double var19;
                for(var19 = 0.05D; var1 != 0.0D && this.field_9093_l.func_481_a(this, this.field_312_v.func_696_c(var1, -1.0D, 0.0D)).size() == 0; var11 = var1) {
                    if (var1 < var19 && var1 >= -var19) {
                        var1 = 0.0D;
                    } else if (var1 > 0.0D) {
                        var1 -= var19;
                    } else {
                        var1 += var19;
                    }
                }

                for(; var5 != 0.0D && this.field_9093_l.func_481_a(this, this.field_312_v.func_696_c(0.0D, -1.0D, var5)).size() == 0; var15 = var5) {
                    if (var5 < var19 && var5 >= -var19) {
                        var5 = 0.0D;
                    } else if (var5 > 0.0D) {
                        var5 -= var19;
                    } else {
                        var5 += var19;
                    }
                }
            }

            List var35 = this.field_9093_l.func_481_a(this, this.field_312_v.func_700_a(var1, var3, var5));

            for(int var20 = 0; var20 < var35.size(); ++var20) {
                var3 = ((AxisAlignedBB)var35.get(var20)).func_701_b(this.field_312_v, var3);
            }

            this.field_312_v.func_702_d(0.0D, var3, 0.0D);
            if (!this.field_9077_F && var13 != var3) {
                var5 = 0.0D;
                var3 = 0.0D;
                var1 = 0.0D;
            }

            boolean var36 = this.field_9086_A || var13 != var3 && var13 < 0.0D;

            int var21;
            for(var21 = 0; var21 < var35.size(); ++var21) {
                var1 = ((AxisAlignedBB)var35.get(var21)).func_710_a(this.field_312_v, var1);
            }

            this.field_312_v.func_702_d(var1, 0.0D, 0.0D);
            if (!this.field_9077_F && var11 != var1) {
                var5 = 0.0D;
                var3 = 0.0D;
                var1 = 0.0D;
            }

            for(var21 = 0; var21 < var35.size(); ++var21) {
                var5 = ((AxisAlignedBB)var35.get(var21)).func_709_c(this.field_312_v, var5);
            }

            this.field_312_v.func_702_d(0.0D, 0.0D, var5);
            if (!this.field_9077_F && var15 != var5) {
                var5 = 0.0D;
                var3 = 0.0D;
                var1 = 0.0D;
            }

            double var23;
            int var28;
            double var37;
            if (this.field_9067_S > 0.0F && var36 && (var18 || this.field_9068_R < 0.05F) && (var11 != var1 || var15 != var5)) {
                var37 = var1;
                var23 = var3;
                double var25 = var5;
                var1 = var11;
                var3 = (double)this.field_9067_S;
                var5 = var15;
                AxisAlignedBB var27 = this.field_312_v.func_711_b();
                this.field_312_v.func_699_b(var17);
                var35 = this.field_9093_l.func_481_a(this, this.field_312_v.func_700_a(var11, var3, var15));

                for(var28 = 0; var28 < var35.size(); ++var28) {
                    var3 = ((AxisAlignedBB)var35.get(var28)).func_701_b(this.field_312_v, var3);
                }

                this.field_312_v.func_702_d(0.0D, var3, 0.0D);
                if (!this.field_9077_F && var13 != var3) {
                    var5 = 0.0D;
                    var3 = 0.0D;
                    var1 = 0.0D;
                }

                for(var28 = 0; var28 < var35.size(); ++var28) {
                    var1 = ((AxisAlignedBB)var35.get(var28)).func_710_a(this.field_312_v, var1);
                }

                this.field_312_v.func_702_d(var1, 0.0D, 0.0D);
                if (!this.field_9077_F && var11 != var1) {
                    var5 = 0.0D;
                    var3 = 0.0D;
                    var1 = 0.0D;
                }

                for(var28 = 0; var28 < var35.size(); ++var28) {
                    var5 = ((AxisAlignedBB)var35.get(var28)).func_709_c(this.field_312_v, var5);
                }

                this.field_312_v.func_702_d(0.0D, 0.0D, var5);
                if (!this.field_9077_F && var15 != var5) {
                    var5 = 0.0D;
                    var3 = 0.0D;
                    var1 = 0.0D;
                }

                if (!this.field_9077_F && var13 != var3) {
                    var5 = 0.0D;
                    var3 = 0.0D;
                    var1 = 0.0D;
                } else {
                    var3 = (double)(-this.field_9067_S);

                    for(var28 = 0; var28 < var35.size(); ++var28) {
                        var3 = ((AxisAlignedBB)var35.get(var28)).func_701_b(this.field_312_v, var3);
                    }

                    this.field_312_v.func_702_d(0.0D, var3, 0.0D);
                }

                if (var37 * var37 + var25 * var25 >= var1 * var1 + var5 * var5) {
                    var1 = var37;
                    var3 = var23;
                    var5 = var25;
                    this.field_312_v.func_699_b(var27);
                } else {
                    double var41 = this.field_312_v.field_963_b - (double)((int)this.field_312_v.field_963_b);
                    if (var41 > 0.0D) {
                        this.field_9068_R = (float)((double)this.field_9068_R + var41 + 0.01D);
                    }
                }
            }

            this.field_322_l = (this.field_312_v.field_964_a + this.field_312_v.field_969_d) / 2.0D;
            this.field_321_m = this.field_312_v.field_963_b + (double)this.field_9076_H - (double)this.field_9068_R;
            this.field_320_n = (this.field_312_v.field_970_c + this.field_312_v.field_967_f) / 2.0D;
            this.field_9084_B = var11 != var1 || var15 != var5;
            this.field_9082_C = var13 != var3;
            this.field_9086_A = var13 != var3 && var13 < 0.0D;
            this.field_9080_D = this.field_9084_B || this.field_9082_C;
            this.func_122_m(var3, this.field_9086_A);
            if (var11 != var1) {
                this.field_319_o = 0.0D;
            }

            if (var13 != var3) {
                this.field_318_p = 0.0D;
            }

            if (var15 != var5) {
                this.field_317_q = 0.0D;
            }

            var37 = this.field_322_l - var7;
            var23 = this.field_320_n - var9;
            int var26;
            int var38;
            int var39;
            if (this.func_25017_l() && !var18 && this.field_327_g == null) {
                this.field_9074_L = (float)((double)this.field_9074_L + (double)MathHelper.func_583_a(var37 * var37 + var23 * var23) * 0.6D);
                var38 = MathHelper.func_584_b(this.field_322_l);
                var26 = MathHelper.func_584_b(this.field_321_m - 0.20000000298023224D - (double)this.field_9076_H);
                var39 = MathHelper.func_584_b(this.field_320_n);
                var28 = this.field_9093_l.func_444_a(var38, var26, var39);
                if (this.field_9093_l.func_444_a(var38, var26 - 1, var39) == Block.field_9050_aZ.field_573_bc) {
                    var28 = this.field_9093_l.func_444_a(var38, var26 - 1, var39);
                }

                if (this.field_9074_L > (float)this.field_6151_b && var28 > 0) {
                    ++this.field_6151_b;
                    StepSound var29 = Block.field_542_n[var28].field_555_bl;
                    if (this.field_9093_l.func_444_a(var38, var26 + 1, var39) == Block.field_625_aT.field_573_bc) {
                        var29 = Block.field_625_aT.field_555_bl;
                        this.field_9093_l.func_506_a(this, var29.func_737_c(), var29.func_738_a() * 0.15F, var29.func_739_b());
                    } else if (!Block.field_542_n[var28].field_553_bn.func_217_d()) {
                        this.field_9093_l.func_506_a(this, var29.func_737_c(), var29.func_738_a() * 0.15F, var29.func_739_b());
                    }

                    Block.field_542_n[var28].func_249_b(this.field_9093_l, var38, var26, var39, this);
                }
            }

            var38 = MathHelper.func_584_b(this.field_312_v.field_964_a + 0.001D);
            var26 = MathHelper.func_584_b(this.field_312_v.field_963_b + 0.001D);
            var39 = MathHelper.func_584_b(this.field_312_v.field_970_c + 0.001D);
            var28 = MathHelper.func_584_b(this.field_312_v.field_969_d - 0.001D);
            int var40 = MathHelper.func_584_b(this.field_312_v.field_968_e - 0.001D);
            int var30 = MathHelper.func_584_b(this.field_312_v.field_967_f - 0.001D);
            if (this.field_9093_l.func_466_a(var38, var26, var39, var28, var40, var30)) {
                for(int var31 = var38; var31 <= var28; ++var31) {
                    for(int var32 = var26; var32 <= var40; ++var32) {
                        for(int var33 = var39; var33 <= var30; ++var33) {
                            int var34 = this.field_9093_l.func_444_a(var31, var32, var33);
                            if (var34 > 0) {
                                Block.field_542_n[var34].func_263_a(this.field_9093_l, var31, var32, var33, this);
                            }
                        }
                    }
                }
            }

            boolean var42 = this.func_27008_Y();
            if (this.field_9093_l.func_523_c(this.field_312_v.func_694_e(0.001D, 0.001D, 0.001D))) {
                this.func_125_b(1);
                if (!var42) {
                    ++this.field_9061_Z;
                    if (this.field_9061_Z == 0) {
                        this.field_9061_Z = 300;
                    }
                }
            } else if (this.field_9061_Z <= 0) {
                this.field_9061_Z = -this.field_9062_Y;
            }

            if (var42 && this.field_9061_Z > 0) {
                this.field_9093_l.func_506_a(this, "random.fizz", 0.7F, 1.6F + (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.4F);
                this.field_9061_Z = -this.field_9062_Y;
            }

        }
    }

    protected boolean func_25017_l() {
        return true;
    }

    protected void func_122_m(double var1, boolean var3) {
        if (var3) {
            if (this.field_9072_N > 0.0F) {
                this.func_114_a(this.field_9072_N);
                this.field_9072_N = 0.0F;
            }
        } else if (var1 < 0.0D) {
            this.field_9072_N = (float)((double)this.field_9072_N - var1);
        }

    }

    public AxisAlignedBB func_93_n() {
        return null;
    }

    protected void func_125_b(int var1) {
        if (!this.field_9079_ae) {
            this.func_121_a((Entity)null, var1);
        }

    }

    protected void func_114_a(float var1) {
        if (this.field_328_f != null) {
            this.field_328_f.func_114_a(var1);
        }

    }

    public boolean func_27008_Y() {
        return this.field_9085_ab || this.field_9093_l.func_27072_q(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n));
    }

    public boolean func_27011_Z() {
        return this.field_9085_ab;
    }

    public boolean func_119_o() {
        return this.field_9093_l.func_490_a(this.field_312_v.func_708_b(0.0D, -0.4000000059604645D, 0.0D).func_694_e(0.001D, 0.001D, 0.001D), Material.field_521_f, this);
    }

    public boolean func_110_a(Material var1) {
        double var2 = this.field_321_m + (double)this.func_104_p();
        int var4 = MathHelper.func_584_b(this.field_322_l);
        int var5 = MathHelper.func_588_d((float)MathHelper.func_584_b(var2));
        int var6 = MathHelper.func_584_b(this.field_320_n);
        int var7 = this.field_9093_l.func_444_a(var4, var5, var6);
        if (var7 != 0 && Block.field_542_n[var7].field_553_bn == var1) {
            float var8 = BlockFluid.func_299_b(this.field_9093_l.func_446_b(var4, var5, var6)) - 0.11111111F;
            float var9 = (float)(var5 + 1) - var8;
            return var2 < (double)var9;
        } else {
            return false;
        }
    }

    public float func_104_p() {
        return 0.0F;
    }

    public boolean func_112_q() {
        return this.field_9093_l.func_500_a(this.field_312_v.func_708_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_520_g);
    }

    public void func_90_a(float var1, float var2, float var3) {
        float var4 = MathHelper.func_586_c(var1 * var1 + var2 * var2);
        if (var4 >= 0.01F) {
            if (var4 < 1.0F) {
                var4 = 1.0F;
            }

            var4 = var3 / var4;
            var1 *= var4;
            var2 *= var4;
            float var5 = MathHelper.func_585_a(this.field_316_r * 3.1415927F / 180.0F);
            float var6 = MathHelper.func_582_b(this.field_316_r * 3.1415927F / 180.0F);
            this.field_319_o += (double)(var1 * var6 - var2 * var5);
            this.field_317_q += (double)(var2 * var6 + var1 * var5);
        }
    }

    public float func_108_b(float var1) {
        int var2 = MathHelper.func_584_b(this.field_322_l);
        double var3 = (this.field_312_v.field_968_e - this.field_312_v.field_963_b) * 0.66D;
        int var5 = MathHelper.func_584_b(this.field_321_m - (double)this.field_9076_H + var3);
        int var6 = MathHelper.func_584_b(this.field_320_n);
        if (this.field_9093_l.func_466_a(MathHelper.func_584_b(this.field_312_v.field_964_a), MathHelper.func_584_b(this.field_312_v.field_963_b), MathHelper.func_584_b(this.field_312_v.field_970_c), MathHelper.func_584_b(this.field_312_v.field_969_d), MathHelper.func_584_b(this.field_312_v.field_968_e), MathHelper.func_584_b(this.field_312_v.field_967_f))) {
            float var7 = this.field_9093_l.func_455_j(var2, var5, var6);
            if (var7 < this.field_31001_bF) {
                var7 = this.field_31001_bF;
            }

            return var7;
        } else {
            return this.field_31001_bF;
        }
    }

    public void func_28007_a(World var1) {
        this.field_9093_l = var1;
    }

    public void func_6095_b(double var1, double var3, double var5, float var7, float var8) {
        this.field_9092_m = this.field_322_l = var1;
        this.field_9091_n = this.field_321_m = var3;
        this.field_9090_o = this.field_320_n = var5;
        this.field_9089_x = this.field_316_r = var7;
        this.field_9088_y = this.field_315_s = var8;
        this.field_9068_R = 0.0F;
        double var9 = (double)(this.field_9089_x - var7);
        if (var9 < -180.0D) {
            this.field_9089_x += 360.0F;
        }

        if (var9 >= 180.0D) {
            this.field_9089_x -= 360.0F;
        }

        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.func_6096_b(var7, var8);
    }

    public void func_107_c(double var1, double var3, double var5, float var7, float var8) {
        this.field_9071_O = this.field_9092_m = this.field_322_l = var1;
        this.field_9070_P = this.field_9091_n = this.field_321_m = var3 + (double)this.field_9076_H;
        this.field_9069_Q = this.field_9090_o = this.field_320_n = var5;
        this.field_316_r = var7;
        this.field_315_s = var8;
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
    }

    public float func_94_a(Entity var1) {
        float var2 = (float)(this.field_322_l - var1.field_322_l);
        float var3 = (float)(this.field_321_m - var1.field_321_m);
        float var4 = (float)(this.field_320_n - var1.field_320_n);
        return MathHelper.func_586_c(var2 * var2 + var3 * var3 + var4 * var4);
    }

    public double func_101_d(double var1, double var3, double var5) {
        double var7 = this.field_322_l - var1;
        double var9 = this.field_321_m - var3;
        double var11 = this.field_320_n - var5;
        return var7 * var7 + var9 * var9 + var11 * var11;
    }

    public double func_103_e(double var1, double var3, double var5) {
        double var7 = this.field_322_l - var1;
        double var9 = this.field_321_m - var3;
        double var11 = this.field_320_n - var5;
        return (double)MathHelper.func_583_a(var7 * var7 + var9 * var9 + var11 * var11);
    }

    public double func_102_b(Entity var1) {
        double var2 = this.field_322_l - var1.field_322_l;
        double var4 = this.field_321_m - var1.field_321_m;
        double var6 = this.field_320_n - var1.field_320_n;
        return var2 * var2 + var4 * var4 + var6 * var6;
    }

    public void func_6093_b(EntityPlayer var1) {
    }

    public void func_92_c(Entity var1) {
        if (var1.field_328_f != this && var1.field_327_g != this) {
            double var2 = var1.field_322_l - this.field_322_l;
            double var4 = var1.field_320_n - this.field_320_n;
            double var6 = MathHelper.func_581_a(var2, var4);
            if (var6 >= 0.009999999776482582D) {
                var6 = (double)MathHelper.func_583_a(var6);
                var2 /= var6;
                var4 /= var6;
                double var8 = 1.0D / var6;
                if (var8 > 1.0D) {
                    var8 = 1.0D;
                }

                var2 *= var8;
                var4 *= var8;
                var2 *= 0.05000000074505806D;
                var4 *= 0.05000000074505806D;
                var2 *= (double)(1.0F - this.field_286_P);
                var4 *= (double)(1.0F - this.field_286_P);
                this.func_87_f(-var2, 0.0D, -var4);
                var1.func_87_f(var2, 0.0D, var4);
            }

        }
    }

    public void func_87_f(double var1, double var3, double var5) {
        this.field_319_o += var1;
        this.field_318_p += var3;
        this.field_317_q += var5;
    }

    protected void func_9060_u() {
        this.field_9078_E = true;
    }

    public boolean func_121_a(Entity var1, int var2) {
        this.func_9060_u();
        return false;
    }

    public boolean func_129_c_() {
        return false;
    }

    public boolean func_124_r() {
        return false;
    }

    public void func_96_b(Entity var1, int var2) {
    }

    public boolean func_95_c(NBTTagCompound var1) {
        String var2 = this.func_109_s();
        if (!this.field_304_B && var2 != null) {
            var1.func_403_a("id", var2);
            this.func_98_d(var1);
            return true;
        } else {
            return false;
        }
    }

    public void func_98_d(NBTTagCompound var1) {
        var1.func_399_a("Pos", this.func_132_a(this.field_322_l, this.field_321_m + (double)this.field_9068_R, this.field_320_n));
        var1.func_399_a("Motion", this.func_132_a(this.field_319_o, this.field_318_p, this.field_317_q));
        var1.func_399_a("Rotation", this.func_85_a(this.field_316_r, this.field_315_s));
        var1.func_390_a("FallDistance", this.field_9072_N);
        var1.func_394_a("Fire", (short)this.field_9061_Z);
        var1.func_394_a("Air", (short)this.field_9081_ad);
        var1.func_393_a("OnGround", this.field_9086_A);
        this.func_97_a(var1);
    }

    public void func_100_e(NBTTagCompound var1) {
        NBTTagList var2 = var1.func_407_k("Pos");
        NBTTagList var3 = var1.func_407_k("Motion");
        NBTTagList var4 = var1.func_407_k("Rotation");
        this.field_319_o = ((NBTTagDouble)var3.func_388_a(0)).field_735_a;
        this.field_318_p = ((NBTTagDouble)var3.func_388_a(1)).field_735_a;
        this.field_317_q = ((NBTTagDouble)var3.func_388_a(2)).field_735_a;
        if (Math.abs(this.field_319_o) > 10.0D) {
            this.field_319_o = 0.0D;
        }

        if (Math.abs(this.field_318_p) > 10.0D) {
            this.field_318_p = 0.0D;
        }

        if (Math.abs(this.field_317_q) > 10.0D) {
            this.field_317_q = 0.0D;
        }

        this.field_9092_m = this.field_9071_O = this.field_322_l = ((NBTTagDouble)var2.func_388_a(0)).field_735_a;
        this.field_9091_n = this.field_9070_P = this.field_321_m = ((NBTTagDouble)var2.func_388_a(1)).field_735_a;
        this.field_9090_o = this.field_9069_Q = this.field_320_n = ((NBTTagDouble)var2.func_388_a(2)).field_735_a;
        this.field_9089_x = this.field_316_r = ((NBTTagFloat)var4.func_388_a(0)).field_739_a;
        this.field_9088_y = this.field_315_s = ((NBTTagFloat)var4.func_388_a(1)).field_739_a;
        this.field_9072_N = var1.func_389_f("FallDistance");
        this.field_9061_Z = var1.func_406_c("Fire");
        this.field_9081_ad = var1.func_406_c("Air");
        this.field_9086_A = var1.func_402_l("OnGround");
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.func_6096_b(this.field_316_r, this.field_315_s);
        this.func_99_b(var1);
    }

    protected final String func_109_s() {
        return EntityList.func_564_b(this);
    }

    protected abstract void func_99_b(NBTTagCompound var1);

    protected abstract void func_97_a(NBTTagCompound var1);

    protected NBTTagList func_132_a(double... var1) {
        NBTTagList var2 = new NBTTagList();
        double[] var3 = var1;
        int var4 = var1.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            double var6 = var3[var5];
            var2.func_386_a(new NBTTagDouble(var6));
        }

        return var2;
    }

    protected NBTTagList func_85_a(float... var1) {
        NBTTagList var2 = new NBTTagList();
        float[] var3 = var1;
        int var4 = var1.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            float var6 = var3[var5];
            var2.func_386_a(new NBTTagFloat(var6));
        }

        return var2;
    }

    public EntityItem func_128_a(int var1, int var2) {
        return this.func_123_a(var1, var2, 0.0F);
    }

    public EntityItem func_123_a(int var1, int var2, float var3) {
        return this.func_21040_a(new ItemStack(var1, var2, 0), var3);
    }

    public EntityItem func_21040_a(ItemStack var1, float var2) {
        EntityItem var3 = new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m + (double)var2, this.field_320_n, var1);
        var3.field_433_ad = 10;
        this.field_9093_l.func_526_a(var3);
        return var3;
    }

    public boolean func_120_t() {
        return !this.field_304_B;
    }

    public boolean func_91_u() {
        for(int var1 = 0; var1 < 8; ++var1) {
            float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.field_300_D * 0.9F;
            float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
            float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.field_300_D * 0.9F;
            int var5 = MathHelper.func_584_b(this.field_322_l + (double)var2);
            int var6 = MathHelper.func_584_b(this.field_321_m + (double)this.func_104_p() + (double)var3);
            int var7 = MathHelper.func_584_b(this.field_320_n + (double)var4);
            if (this.field_9093_l.func_445_d(var5, var6, var7)) {
                return true;
            }
        }

        return false;
    }

    public boolean func_6092_a(EntityPlayer var1) {
        return false;
    }

    public AxisAlignedBB func_89_d(Entity var1) {
        return null;
    }

    public void func_115_v() {
        if (this.field_327_g.field_304_B) {
            this.field_327_g = null;
        } else {
            this.field_319_o = 0.0D;
            this.field_318_p = 0.0D;
            this.field_317_q = 0.0D;
            this.func_106_b_();
            if (this.field_327_g != null) {
                this.field_327_g.func_127_w();
                this.field_4128_e += (double)(this.field_327_g.field_316_r - this.field_327_g.field_9089_x);

                for(this.field_4130_d += (double)(this.field_327_g.field_315_s - this.field_327_g.field_9088_y); this.field_4128_e >= 180.0D; this.field_4128_e -= 360.0D) {
                }

                while(this.field_4128_e < -180.0D) {
                    this.field_4128_e += 360.0D;
                }

                while(this.field_4130_d >= 180.0D) {
                    this.field_4130_d -= 360.0D;
                }

                while(this.field_4130_d < -180.0D) {
                    this.field_4130_d += 360.0D;
                }

                double var1 = this.field_4128_e * 0.5D;
                double var3 = this.field_4130_d * 0.5D;
                float var5 = 10.0F;
                if (var1 > (double)var5) {
                    var1 = (double)var5;
                }

                if (var1 < (double)(-var5)) {
                    var1 = (double)(-var5);
                }

                if (var3 > (double)var5) {
                    var3 = (double)var5;
                }

                if (var3 < (double)(-var5)) {
                    var3 = (double)(-var5);
                }

                this.field_4128_e -= var1;
                this.field_4130_d -= var3;
                this.field_316_r = (float)((double)this.field_316_r + var1);
                this.field_315_s = (float)((double)this.field_315_s + var3);
            }
        }
    }

    public void func_127_w() {
        this.field_328_f.func_86_a(this.field_322_l, this.field_321_m + this.func_130_h() + this.field_328_f.func_117_x(), this.field_320_n);
    }

    public double func_117_x() {
        return (double)this.field_9076_H;
    }

    public double func_130_h() {
        return (double)this.field_298_E * 0.75D;
    }

    public void func_6094_e(Entity var1) {
        this.field_4130_d = 0.0D;
        this.field_4128_e = 0.0D;
        if (var1 == null) {
            if (this.field_327_g != null) {
                this.func_107_c(this.field_327_g.field_322_l, this.field_327_g.field_312_v.field_963_b + (double)this.field_327_g.field_298_E, this.field_327_g.field_320_n, this.field_316_r, this.field_315_s);
                this.field_327_g.field_328_f = null;
            }

            this.field_327_g = null;
        } else if (this.field_327_g == var1) {
            this.field_327_g.field_328_f = null;
            this.field_327_g = null;
            this.func_107_c(var1.field_322_l, var1.field_312_v.field_963_b + (double)var1.field_298_E, var1.field_320_n, this.field_316_r, this.field_315_s);
        } else {
            if (this.field_327_g != null) {
                this.field_327_g.field_328_f = null;
            }

            if (var1.field_328_f != null) {
                var1.field_328_f.field_327_g = null;
            }

            this.field_327_g = var1;
            var1.field_328_f = this;
        }
    }

    public Vec3D func_4039_B() {
        return null;
    }

    public void func_4042_C() {
    }

    public ItemStack[] func_20042_E() {
        return null;
    }

    public boolean func_9059_p() {
        return this.func_21042_c(1);
    }

    public void func_21043_b(boolean var1) {
        this.func_21041_a(1, var1);
    }

    protected boolean func_21042_c(int var1) {
        return (this.field_21045_af.func_21156_a(0) & 1 << var1) != 0;
    }

    protected void func_21041_a(int var1, boolean var2) {
        byte var3 = this.field_21045_af.func_21156_a(0);
        if (var2) {
            this.field_21045_af.func_21155_b(0, (byte)(var3 | 1 << var1));
        } else {
            this.field_21045_af.func_21155_b(0, (byte)(var3 & ~(1 << var1)));
        }

    }

    public void func_27009_a(EntityLightningBolt var1) {
        this.func_125_b(5);
        ++this.field_9061_Z;
        if (this.field_9061_Z == 0) {
            this.field_9061_Z = 300;
        }

    }

    public void func_27010_a(EntityLiving var1) {
    }

    protected boolean func_28005_g(double var1, double var3, double var5) {
        int var7 = MathHelper.func_584_b(var1);
        int var8 = MathHelper.func_584_b(var3);
        int var9 = MathHelper.func_584_b(var5);
        double var10 = var1 - (double)var7;
        double var12 = var3 - (double)var8;
        double var14 = var5 - (double)var9;
        if (this.field_9093_l.func_445_d(var7, var8, var9)) {
            boolean var16 = !this.field_9093_l.func_445_d(var7 - 1, var8, var9);
            boolean var17 = !this.field_9093_l.func_445_d(var7 + 1, var8, var9);
            boolean var18 = !this.field_9093_l.func_445_d(var7, var8 - 1, var9);
            boolean var19 = !this.field_9093_l.func_445_d(var7, var8 + 1, var9);
            boolean var20 = !this.field_9093_l.func_445_d(var7, var8, var9 - 1);
            boolean var21 = !this.field_9093_l.func_445_d(var7, var8, var9 + 1);
            byte var22 = -1;
            double var23 = 9999.0D;
            if (var16 && var10 < var23) {
                var23 = var10;
                var22 = 0;
            }

            if (var17 && 1.0D - var10 < var23) {
                var23 = 1.0D - var10;
                var22 = 1;
            }

            if (var18 && var12 < var23) {
                var23 = var12;
                var22 = 2;
            }

            if (var19 && 1.0D - var12 < var23) {
                var23 = 1.0D - var12;
                var22 = 3;
            }

            if (var20 && var14 < var23) {
                var23 = var14;
                var22 = 4;
            }

            if (var21 && 1.0D - var14 < var23) {
                var23 = 1.0D - var14;
                var22 = 5;
            }

            float var25 = this.field_9064_W.nextFloat() * 0.2F + 0.1F;
            if (var22 == 0) {
                this.field_319_o = (double)(-var25);
            }

            if (var22 == 1) {
                this.field_319_o = (double)var25;
            }

            if (var22 == 2) {
                this.field_318_p = (double)(-var25);
            }

            if (var22 == 3) {
                this.field_318_p = (double)var25;
            }

            if (var22 == 4) {
                this.field_317_q = (double)(-var25);
            }

            if (var22 == 5) {
                this.field_317_q = (double)var25;
            }
        }

        return false;
    }
}
