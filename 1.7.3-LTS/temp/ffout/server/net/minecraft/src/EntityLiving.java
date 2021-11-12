package net.minecraft.src;

import java.util.List;

public abstract class EntityLiving extends Entity {
    public int field_9099_av = 20;
    public float field_9098_aw;
    public float field_9096_ay;
    public float field_9095_az = 0.0F;
    public float field_9125_aA = 0.0F;
    protected float field_9124_aB;
    protected float field_9123_aC;
    protected float field_9122_aD;
    protected float field_9121_aE;
    protected boolean field_9120_aF = true;
    protected String field_9119_aG = "/mob/char.png";
    protected boolean field_9118_aH = true;
    protected float field_9117_aI = 0.0F;
    protected String field_9116_aJ = null;
    protected float field_9115_aK = 1.0F;
    protected int field_9114_aL = 0;
    protected float field_9113_aM = 0.0F;
    public boolean field_9112_aN = false;
    public float field_9111_aO;
    public float field_9110_aP;
    public int field_9109_aQ = 10;
    public int field_9108_aR;
    private int field_4099_a;
    public int field_9107_aS;
    public int field_9106_aT;
    public float field_9105_aU = 0.0F;
    public int field_9104_aV = 0;
    public int field_9103_aW = 0;
    public float field_9102_aX;
    public float field_9101_aY;
    protected boolean field_9100_aZ = false;
    public int field_9144_ba = -1;
    public float field_9143_bb = (float)(Math.random() * 0.8999999761581421D + 0.10000000149011612D);
    public float field_9142_bc;
    public float field_9141_bd;
    public float field_386_ba;
    protected int field_9140_bf;
    protected double field_9139_bg;
    protected double field_9138_bh;
    protected double field_9137_bi;
    protected double field_9136_bj;
    protected double field_9135_bk;
    float field_9134_bl = 0.0F;
    protected int field_9133_bm = 0;
    protected int field_9132_bn = 0;
    protected float field_9131_bo;
    protected float field_9130_bp;
    protected float field_9129_bq;
    protected boolean field_9128_br = false;
    protected float field_9127_bs = 0.0F;
    protected float field_9126_bt = 0.7F;
    private Entity field_4098_b;
    protected int field_4104_c = 0;

    public EntityLiving(World var1) {
        super(var1);
        this.field_329_e = true;
        this.field_9096_ay = (float)(Math.random() + 1.0D) * 0.01F;
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.field_9098_aw = (float)Math.random() * 12398.0F;
        this.field_316_r = (float)(Math.random() * 3.1415927410125732D * 2.0D);
        this.field_9067_S = 0.5F;
    }

    protected void func_21044_a() {
    }

    public boolean func_145_g(Entity var1) {
        return this.field_9093_l.func_486_a(Vec3D.func_768_b(this.field_322_l, this.field_321_m + (double)this.func_104_p(), this.field_320_n), Vec3D.func_768_b(var1.field_322_l, var1.field_321_m + (double)var1.func_104_p(), var1.field_320_n)) == null;
    }

    public boolean func_129_c_() {
        return !this.field_304_B;
    }

    public boolean func_124_r() {
        return !this.field_304_B;
    }

    public float func_104_p() {
        return this.field_298_E * 0.85F;
    }

    public int func_146_b() {
        return 80;
    }

    public void func_22056_G() {
        String var1 = this.func_6097_d();
        if (var1 != null) {
            this.field_9093_l.func_506_a(this, var1, this.func_6102_h(), (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
        }

    }

    public void func_84_k() {
        this.field_9111_aO = this.field_9110_aP;
        super.func_84_k();
        if (this.field_9064_W.nextInt(1000) < this.field_4099_a++) {
            this.field_4099_a = -this.func_146_b();
            this.func_22056_G();
        }

        if (this.func_120_t() && this.func_91_u()) {
            this.func_121_a((Entity)null, 1);
        }

        if (this.field_9079_ae || this.field_9093_l.field_792_x) {
            this.field_9061_Z = 0;
        }

        int var1;
        if (this.func_120_t() && this.func_110_a(Material.field_521_f) && !this.func_21046_d_()) {
            --this.field_9081_ad;
            if (this.field_9081_ad == -20) {
                this.field_9081_ad = 0;

                for(var1 = 0; var1 < 8; ++var1) {
                    float var2 = this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat();
                    float var3 = this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat();
                    float var4 = this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat();
                    this.field_9093_l.func_514_a("bubble", this.field_322_l + (double)var2, this.field_321_m + (double)var3, this.field_320_n + (double)var4, this.field_319_o, this.field_318_p, this.field_317_q);
                }

                this.func_121_a((Entity)null, 2);
            }

            this.field_9061_Z = 0;
        } else {
            this.field_9081_ad = this.field_9087_aa;
        }

        this.field_9102_aX = this.field_9101_aY;
        if (this.field_9103_aW > 0) {
            --this.field_9103_aW;
        }

        if (this.field_9107_aS > 0) {
            --this.field_9107_aS;
        }

        if (this.field_9083_ac > 0) {
            --this.field_9083_ac;
        }

        if (this.field_9109_aQ <= 0) {
            ++this.field_9104_aV;
            if (this.field_9104_aV > 20) {
                this.func_6101_K();
                this.func_118_j();

                for(var1 = 0; var1 < 20; ++var1) {
                    double var8 = this.field_9064_W.nextGaussian() * 0.02D;
                    double var9 = this.field_9064_W.nextGaussian() * 0.02D;
                    double var6 = this.field_9064_W.nextGaussian() * 0.02D;
                    this.field_9093_l.func_514_a("explode", this.field_322_l + (double)(this.field_9064_W.nextFloat() * this.field_300_D * 2.0F) - (double)this.field_300_D, this.field_321_m + (double)(this.field_9064_W.nextFloat() * this.field_298_E), this.field_320_n + (double)(this.field_9064_W.nextFloat() * this.field_300_D * 2.0F) - (double)this.field_300_D, var8, var9, var6);
                }
            }
        }

        this.field_9121_aE = this.field_9122_aD;
        this.field_9125_aA = this.field_9095_az;
        this.field_9089_x = this.field_316_r;
        this.field_9088_y = this.field_315_s;
    }

    public void func_156_D() {
        for(int var1 = 0; var1 < 20; ++var1) {
            double var2 = this.field_9064_W.nextGaussian() * 0.02D;
            double var4 = this.field_9064_W.nextGaussian() * 0.02D;
            double var6 = this.field_9064_W.nextGaussian() * 0.02D;
            double var8 = 10.0D;
            this.field_9093_l.func_514_a("explode", this.field_322_l + (double)(this.field_9064_W.nextFloat() * this.field_300_D * 2.0F) - (double)this.field_300_D - var2 * var8, this.field_321_m + (double)(this.field_9064_W.nextFloat() * this.field_298_E) - var4 * var8, this.field_320_n + (double)(this.field_9064_W.nextFloat() * this.field_300_D * 2.0F) - (double)this.field_300_D - var6 * var8, var2, var4, var6);
        }

    }

    public void func_115_v() {
        super.func_115_v();
        this.field_9124_aB = this.field_9123_aC;
        this.field_9123_aC = 0.0F;
    }

    public void func_106_b_() {
        super.func_106_b_();
        this.func_153_y();
        double var1 = this.field_322_l - this.field_9092_m;
        double var3 = this.field_320_n - this.field_9090_o;
        float var5 = MathHelper.func_583_a(var1 * var1 + var3 * var3);
        float var6 = this.field_9095_az;
        float var7 = 0.0F;
        this.field_9124_aB = this.field_9123_aC;
        float var8 = 0.0F;
        if (var5 > 0.05F) {
            var8 = 1.0F;
            var7 = var5 * 3.0F;
            var6 = (float)Math.atan2(var3, var1) * 180.0F / 3.1415927F - 90.0F;
        }

        if (this.field_9110_aP > 0.0F) {
            var6 = this.field_316_r;
        }

        if (!this.field_9086_A) {
            var8 = 0.0F;
        }

        this.field_9123_aC += (var8 - this.field_9123_aC) * 0.3F;

        float var9;
        for(var9 = var6 - this.field_9095_az; var9 < -180.0F; var9 += 360.0F) {
        }

        while(var9 >= 180.0F) {
            var9 -= 360.0F;
        }

        this.field_9095_az += var9 * 0.3F;

        float var10;
        for(var10 = this.field_316_r - this.field_9095_az; var10 < -180.0F; var10 += 360.0F) {
        }

        while(var10 >= 180.0F) {
            var10 -= 360.0F;
        }

        boolean var11 = var10 < -90.0F || var10 >= 90.0F;
        if (var10 < -75.0F) {
            var10 = -75.0F;
        }

        if (var10 >= 75.0F) {
            var10 = 75.0F;
        }

        this.field_9095_az = this.field_316_r - var10;
        if (var10 * var10 > 2500.0F) {
            this.field_9095_az += var10 * 0.2F;
        }

        if (var11) {
            var7 *= -1.0F;
        }

        while(this.field_316_r - this.field_9089_x < -180.0F) {
            this.field_9089_x -= 360.0F;
        }

        while(this.field_316_r - this.field_9089_x >= 180.0F) {
            this.field_9089_x += 360.0F;
        }

        while(this.field_9095_az - this.field_9125_aA < -180.0F) {
            this.field_9125_aA -= 360.0F;
        }

        while(this.field_9095_az - this.field_9125_aA >= 180.0F) {
            this.field_9125_aA += 360.0F;
        }

        while(this.field_315_s - this.field_9088_y < -180.0F) {
            this.field_9088_y -= 360.0F;
        }

        while(this.field_315_s - this.field_9088_y >= 180.0F) {
            this.field_9088_y += 360.0F;
        }

        this.field_9122_aD += var7;
    }

    protected void func_113_a(float var1, float var2) {
        super.func_113_a(var1, var2);
    }

    public void func_137_a(int var1) {
        if (this.field_9109_aQ > 0) {
            this.field_9109_aQ += var1;
            if (this.field_9109_aQ > 20) {
                this.field_9109_aQ = 20;
            }

            this.field_9083_ac = this.field_9099_av / 2;
        }
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (this.field_9093_l.field_792_x) {
            return false;
        } else {
            this.field_9132_bn = 0;
            if (this.field_9109_aQ <= 0) {
                return false;
            } else {
                this.field_9141_bd = 1.5F;
                boolean var3 = true;
                if ((float)this.field_9083_ac > (float)this.field_9099_av / 2.0F) {
                    if (var2 <= this.field_9133_bm) {
                        return false;
                    }

                    this.func_6099_c(var2 - this.field_9133_bm);
                    this.field_9133_bm = var2;
                    var3 = false;
                } else {
                    this.field_9133_bm = var2;
                    this.field_9108_aR = this.field_9109_aQ;
                    this.field_9083_ac = this.field_9099_av;
                    this.func_6099_c(var2);
                    this.field_9107_aS = this.field_9106_aT = 10;
                }

                this.field_9105_aU = 0.0F;
                if (var3) {
                    this.field_9093_l.func_9206_a(this, (byte)2);
                    this.func_9060_u();
                    if (var1 != null) {
                        double var4 = var1.field_322_l - this.field_322_l;

                        double var6;
                        for(var6 = var1.field_320_n - this.field_320_n; var4 * var4 + var6 * var6 < 1.0E-4D; var6 = (Math.random() - Math.random()) * 0.01D) {
                            var4 = (Math.random() - Math.random()) * 0.01D;
                        }

                        this.field_9105_aU = (float)(Math.atan2(var6, var4) * 180.0D / 3.1415927410125732D) - this.field_316_r;
                        this.func_143_a(var1, var2, var4, var6);
                    } else {
                        this.field_9105_aU = (float)((int)(Math.random() * 2.0D) * 180);
                    }
                }

                if (this.field_9109_aQ <= 0) {
                    if (var3) {
                        this.field_9093_l.func_506_a(this, this.func_6098_f(), this.func_6102_h(), (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
                    }

                    this.func_142_f(var1);
                } else if (var3) {
                    this.field_9093_l.func_506_a(this, this.func_6100_e(), this.func_6102_h(), (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
                }

                return true;
            }
        }
    }

    protected void func_6099_c(int var1) {
        this.field_9109_aQ -= var1;
    }

    protected float func_6102_h() {
        return 1.0F;
    }

    protected String func_6097_d() {
        return null;
    }

    protected String func_6100_e() {
        return "random.hurt";
    }

    protected String func_6098_f() {
        return "random.hurt";
    }

    public void func_143_a(Entity var1, int var2, double var3, double var5) {
        float var7 = MathHelper.func_583_a(var3 * var3 + var5 * var5);
        float var8 = 0.4F;
        this.field_319_o /= 2.0D;
        this.field_318_p /= 2.0D;
        this.field_317_q /= 2.0D;
        this.field_319_o -= var3 / (double)var7 * (double)var8;
        this.field_318_p += 0.4000000059604645D;
        this.field_317_q -= var5 / (double)var7 * (double)var8;
        if (this.field_318_p > 0.4000000059604645D) {
            this.field_318_p = 0.4000000059604645D;
        }

    }

    public void func_142_f(Entity var1) {
        if (this.field_9114_aL >= 0 && var1 != null) {
            var1.func_96_b(this, this.field_9114_aL);
        }

        if (var1 != null) {
            var1.func_27010_a(this);
        }

        this.field_9100_aZ = true;
        if (!this.field_9093_l.field_792_x) {
            this.func_21047_g_();
        }

        this.field_9093_l.func_9206_a(this, (byte)3);
    }

    protected void func_21047_g_() {
        int var1 = this.func_149_g();
        if (var1 > 0) {
            int var2 = this.field_9064_W.nextInt(3);

            for(int var3 = 0; var3 < var2; ++var3) {
                this.func_128_a(var1, 1);
            }
        }

    }

    protected int func_149_g() {
        return 0;
    }

    protected void func_114_a(float var1) {
        super.func_114_a(var1);
        int var2 = (int)Math.ceil((double)(var1 - 3.0F));
        if (var2 > 0) {
            this.func_121_a((Entity)null, var2);
            int var3 = this.field_9093_l.func_444_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m - 0.20000000298023224D - (double)this.field_9076_H), MathHelper.func_584_b(this.field_320_n));
            if (var3 > 0) {
                StepSound var4 = Block.field_542_n[var3].field_555_bl;
                this.field_9093_l.func_506_a(this, var4.func_737_c(), var4.func_738_a() * 0.5F, var4.func_739_b() * 0.75F);
            }
        }

    }

    public void func_148_c(float var1, float var2) {
        double var3;
        if (this.func_27011_Z()) {
            var3 = this.field_321_m;
            this.func_90_a(var1, var2, 0.02F);
            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            this.field_319_o *= 0.800000011920929D;
            this.field_318_p *= 0.800000011920929D;
            this.field_317_q *= 0.800000011920929D;
            this.field_318_p -= 0.02D;
            if (this.field_9084_B && this.func_133_b(this.field_319_o, this.field_318_p + 0.6000000238418579D - this.field_321_m + var3, this.field_317_q)) {
                this.field_318_p = 0.30000001192092896D;
            }
        } else if (this.func_112_q()) {
            var3 = this.field_321_m;
            this.func_90_a(var1, var2, 0.02F);
            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            this.field_319_o *= 0.5D;
            this.field_318_p *= 0.5D;
            this.field_317_q *= 0.5D;
            this.field_318_p -= 0.02D;
            if (this.field_9084_B && this.func_133_b(this.field_319_o, this.field_318_p + 0.6000000238418579D - this.field_321_m + var3, this.field_317_q)) {
                this.field_318_p = 0.30000001192092896D;
            }
        } else {
            float var8 = 0.91F;
            if (this.field_9086_A) {
                var8 = 0.54600006F;
                int var4 = this.field_9093_l.func_444_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_312_v.field_963_b) - 1, MathHelper.func_584_b(this.field_320_n));
                if (var4 > 0) {
                    var8 = Block.field_542_n[var4].field_552_bo * 0.91F;
                }
            }

            float var9 = 0.16277136F / (var8 * var8 * var8);
            this.func_90_a(var1, var2, this.field_9086_A ? 0.1F * var9 : 0.02F);
            var8 = 0.91F;
            if (this.field_9086_A) {
                var8 = 0.54600006F;
                int var5 = this.field_9093_l.func_444_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_312_v.field_963_b) - 1, MathHelper.func_584_b(this.field_320_n));
                if (var5 > 0) {
                    var8 = Block.field_542_n[var5].field_552_bo * 0.91F;
                }
            }

            if (this.func_144_E()) {
                float var10 = 0.15F;
                if (this.field_319_o < (double)(-var10)) {
                    this.field_319_o = (double)(-var10);
                }

                if (this.field_319_o > (double)var10) {
                    this.field_319_o = (double)var10;
                }

                if (this.field_317_q < (double)(-var10)) {
                    this.field_317_q = (double)(-var10);
                }

                if (this.field_317_q > (double)var10) {
                    this.field_317_q = (double)var10;
                }

                this.field_9072_N = 0.0F;
                if (this.field_318_p < -0.15D) {
                    this.field_318_p = -0.15D;
                }

                if (this.func_9059_p() && this.field_318_p < 0.0D) {
                    this.field_318_p = 0.0D;
                }
            }

            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            if (this.field_9084_B && this.func_144_E()) {
                this.field_318_p = 0.2D;
            }

            this.field_318_p -= 0.08D;
            this.field_318_p *= 0.9800000190734863D;
            this.field_319_o *= (double)var8;
            this.field_317_q *= (double)var8;
        }

        this.field_9142_bc = this.field_9141_bd;
        var3 = this.field_322_l - this.field_9092_m;
        double var11 = this.field_320_n - this.field_9090_o;
        float var7 = MathHelper.func_583_a(var3 * var3 + var11 * var11) * 4.0F;
        if (var7 > 1.0F) {
            var7 = 1.0F;
        }

        this.field_9141_bd += (var7 - this.field_9141_bd) * 0.4F;
        this.field_386_ba += this.field_9141_bd;
    }

    public boolean func_144_E() {
        int var1 = MathHelper.func_584_b(this.field_322_l);
        int var2 = MathHelper.func_584_b(this.field_312_v.field_963_b);
        int var3 = MathHelper.func_584_b(this.field_320_n);
        return this.field_9093_l.func_444_a(var1, var2, var3) == Block.field_638_aG.field_573_bc;
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_394_a("Health", (short)this.field_9109_aQ);
        var1.func_394_a("HurtTime", (short)this.field_9107_aS);
        var1.func_394_a("DeathTime", (short)this.field_9104_aV);
        var1.func_394_a("AttackTime", (short)this.field_9103_aW);
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_9109_aQ = var1.func_406_c("Health");
        if (!var1.func_410_a("Health")) {
            this.field_9109_aQ = 10;
        }

        this.field_9107_aS = var1.func_406_c("HurtTime");
        this.field_9104_aV = var1.func_406_c("DeathTime");
        this.field_9103_aW = var1.func_406_c("AttackTime");
    }

    public boolean func_120_t() {
        return !this.field_304_B && this.field_9109_aQ > 0;
    }

    public boolean func_21046_d_() {
        return false;
    }

    public void func_153_y() {
        if (this.field_9140_bf > 0) {
            double var1 = this.field_322_l + (this.field_9139_bg - this.field_322_l) / (double)this.field_9140_bf;
            double var3 = this.field_321_m + (this.field_9138_bh - this.field_321_m) / (double)this.field_9140_bf;
            double var5 = this.field_320_n + (this.field_9137_bi - this.field_320_n) / (double)this.field_9140_bf;

            double var7;
            for(var7 = this.field_9136_bj - (double)this.field_316_r; var7 < -180.0D; var7 += 360.0D) {
            }

            while(var7 >= 180.0D) {
                var7 -= 360.0D;
            }

            this.field_316_r = (float)((double)this.field_316_r + var7 / (double)this.field_9140_bf);
            this.field_315_s = (float)((double)this.field_315_s + (this.field_9135_bk - (double)this.field_315_s) / (double)this.field_9140_bf);
            --this.field_9140_bf;
            this.func_86_a(var1, var3, var5);
            this.func_6096_b(this.field_316_r, this.field_315_s);
            List var9 = this.field_9093_l.func_481_a(this, this.field_312_v.func_694_e(0.03125D, 0.0D, 0.03125D));
            if (var9.size() > 0) {
                double var10 = 0.0D;

                for(int var12 = 0; var12 < var9.size(); ++var12) {
                    AxisAlignedBB var13 = (AxisAlignedBB)var9.get(var12);
                    if (var13.field_968_e > var10) {
                        var10 = var13.field_968_e;
                    }
                }

                var3 += var10 - this.field_312_v.field_963_b;
                this.func_86_a(var1, var3, var5);
            }
        }

        if (this.func_22058_w()) {
            this.field_9128_br = false;
            this.field_9131_bo = 0.0F;
            this.field_9130_bp = 0.0F;
            this.field_9129_bq = 0.0F;
        } else if (!this.field_9112_aN) {
            this.func_152_d_();
        }

        boolean var14 = this.func_27011_Z();
        boolean var2 = this.func_112_q();
        if (this.field_9128_br) {
            if (var14) {
                this.field_318_p += 0.03999999910593033D;
            } else if (var2) {
                this.field_318_p += 0.03999999910593033D;
            } else if (this.field_9086_A) {
                this.func_154_F();
            }
        }

        this.field_9131_bo *= 0.98F;
        this.field_9130_bp *= 0.98F;
        this.field_9129_bq *= 0.9F;
        this.func_148_c(this.field_9131_bo, this.field_9130_bp);
        List var15 = this.field_9093_l.func_450_b(this, this.field_312_v.func_708_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if (var15 != null && var15.size() > 0) {
            for(int var4 = 0; var4 < var15.size(); ++var4) {
                Entity var16 = (Entity)var15.get(var4);
                if (var16.func_124_r()) {
                    var16.func_92_c(this);
                }
            }
        }

    }

    protected boolean func_22058_w() {
        return this.field_9109_aQ <= 0;
    }

    protected void func_154_F() {
        this.field_318_p = 0.41999998688697815D;
    }

    protected boolean func_25020_s() {
        return true;
    }

    protected void func_27013_Q() {
        EntityPlayer var1 = this.field_9093_l.func_472_a(this, -1.0D);
        if (this.func_25020_s() && var1 != null) {
            double var2 = var1.field_322_l - this.field_322_l;
            double var4 = var1.field_321_m - this.field_321_m;
            double var6 = var1.field_320_n - this.field_320_n;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            if (var8 > 16384.0D) {
                this.func_118_j();
            }

            if (this.field_9132_bn > 600 && this.field_9064_W.nextInt(800) == 0) {
                if (var8 < 1024.0D) {
                    this.field_9132_bn = 0;
                } else {
                    this.func_118_j();
                }
            }
        }

    }

    protected void func_152_d_() {
        ++this.field_9132_bn;
        EntityPlayer var1 = this.field_9093_l.func_472_a(this, -1.0D);
        this.func_27013_Q();
        this.field_9131_bo = 0.0F;
        this.field_9130_bp = 0.0F;
        float var2 = 8.0F;
        if (this.field_9064_W.nextFloat() < 0.02F) {
            var1 = this.field_9093_l.func_472_a(this, (double)var2);
            if (var1 != null) {
                this.field_4098_b = var1;
                this.field_4104_c = 10 + this.field_9064_W.nextInt(20);
            } else {
                this.field_9129_bq = (this.field_9064_W.nextFloat() - 0.5F) * 20.0F;
            }
        }

        if (this.field_4098_b != null) {
            this.func_147_b(this.field_4098_b, 10.0F, (float)this.func_25018_n_());
            if (this.field_4104_c-- <= 0 || this.field_4098_b.field_304_B || this.field_4098_b.func_102_b(this) > (double)(var2 * var2)) {
                this.field_4098_b = null;
            }
        } else {
            if (this.field_9064_W.nextFloat() < 0.05F) {
                this.field_9129_bq = (this.field_9064_W.nextFloat() - 0.5F) * 20.0F;
            }

            this.field_316_r += this.field_9129_bq;
            this.field_315_s = this.field_9127_bs;
        }

        boolean var3 = this.func_27011_Z();
        boolean var4 = this.func_112_q();
        if (var3 || var4) {
            this.field_9128_br = this.field_9064_W.nextFloat() < 0.8F;
        }

    }

    protected int func_25018_n_() {
        return 40;
    }

    public void func_147_b(Entity var1, float var2, float var3) {
        double var4 = var1.field_322_l - this.field_322_l;
        double var8 = var1.field_320_n - this.field_320_n;
        double var6;
        if (var1 instanceof EntityLiving) {
            EntityLiving var10 = (EntityLiving)var1;
            var6 = this.field_321_m + (double)this.func_104_p() - (var10.field_321_m + (double)var10.func_104_p());
        } else {
            var6 = (var1.field_312_v.field_963_b + var1.field_312_v.field_968_e) / 2.0D - (this.field_321_m + (double)this.func_104_p());
        }

        double var14 = (double)MathHelper.func_583_a(var4 * var4 + var8 * var8);
        float var12 = (float)(Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
        float var13 = (float)(-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
        this.field_315_s = -this.func_140_b(this.field_315_s, var13, var3);
        this.field_316_r = this.func_140_b(this.field_316_r, var12, var2);
    }

    public boolean func_25021_O() {
        return this.field_4098_b != null;
    }

    public Entity func_25019_P() {
        return this.field_4098_b;
    }

    private float func_140_b(float var1, float var2, float var3) {
        float var4;
        for(var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
        }

        while(var4 >= 180.0F) {
            var4 -= 360.0F;
        }

        if (var4 > var3) {
            var4 = var3;
        }

        if (var4 < -var3) {
            var4 = -var3;
        }

        return var1 + var4;
    }

    public void func_6101_K() {
    }

    public boolean func_155_a() {
        return this.field_9093_l.func_522_a(this.field_312_v) && this.field_9093_l.func_481_a(this, this.field_312_v).size() == 0 && !this.field_9093_l.func_469_b(this.field_312_v);
    }

    protected void func_4043_o() {
        this.func_121_a((Entity)null, 4);
    }

    public Vec3D func_4039_B() {
        return this.func_141_d(1.0F);
    }

    public Vec3D func_141_d(float var1) {
        float var2;
        float var3;
        float var4;
        float var5;
        if (var1 == 1.0F) {
            var2 = MathHelper.func_582_b(-this.field_316_r * 0.017453292F - 3.1415927F);
            var3 = MathHelper.func_585_a(-this.field_316_r * 0.017453292F - 3.1415927F);
            var4 = -MathHelper.func_582_b(-this.field_315_s * 0.017453292F);
            var5 = MathHelper.func_585_a(-this.field_315_s * 0.017453292F);
            return Vec3D.func_768_b((double)(var3 * var4), (double)var5, (double)(var2 * var4));
        } else {
            var2 = this.field_9088_y + (this.field_315_s - this.field_9088_y) * var1;
            var3 = this.field_9089_x + (this.field_316_r - this.field_9089_x) * var1;
            var4 = MathHelper.func_582_b(-var3 * 0.017453292F - 3.1415927F);
            var5 = MathHelper.func_585_a(-var3 * 0.017453292F - 3.1415927F);
            float var6 = -MathHelper.func_582_b(-var2 * 0.017453292F);
            float var7 = MathHelper.func_585_a(-var2 * 0.017453292F);
            return Vec3D.func_768_b((double)(var5 * var6), (double)var7, (double)(var4 * var6));
        }
    }

    public int func_4045_i() {
        return 4;
    }

    public boolean func_22057_E() {
        return false;
    }
}
