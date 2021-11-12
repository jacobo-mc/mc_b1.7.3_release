package net.minecraft.src;

import java.util.List;

public abstract class EntityLiving extends Entity {
    public int field_9366_o = 20;
    public float field_9365_p;
    public float field_9363_r;
    public float field_735_n = 0.0F;
    public float field_734_o = 0.0F;
    protected float field_9362_u;
    protected float field_9361_v;
    protected float field_9360_w;
    protected float field_9359_x;
    protected boolean field_9358_y = true;
    protected String field_9357_z = "/mob/char.png";
    protected boolean field_9355_A = true;
    protected float field_9353_B = 0.0F;
    protected String field_9351_C = null;
    protected float field_9349_D = 1.0F;
    protected int field_9347_E = 0;
    protected float field_9345_F = 0.0F;
    public boolean field_9343_G = false;
    public float field_9341_H;
    public float field_9339_I;
    public int field_9337_J = 10;
    public int field_9335_K;
    private int field_4121_a;
    public int field_715_G;
    public int field_9332_M;
    public float field_9331_N = 0.0F;
    public int field_712_J = 0;
    public int field_9330_P = 0;
    public float field_9329_Q;
    public float field_9328_R;
    protected boolean field_9327_S = false;
    public int field_9326_T = -1;
    public float field_9325_U = (float)(Math.random() * 0.8999999761581421D + 0.10000000149011612D);
    public float field_705_Q;
    public float field_704_R;
    public float field_703_S;
    protected int field_9324_Y;
    protected double field_9323_Z;
    protected double field_9356_aa;
    protected double field_9354_ab;
    protected double field_9352_ac;
    protected double field_9350_ad;
    float field_9348_ae = 0.0F;
    protected int field_9346_af = 0;
    protected int field_9344_ag = 0;
    protected float field_9342_ah;
    protected float field_9340_ai;
    protected float field_9338_aj;
    protected boolean field_9336_ak = false;
    protected float field_9334_al = 0.0F;
    protected float field_9333_am = 0.7F;
    private Entity field_4120_b;
    protected int field_4127_c = 0;

    public EntityLiving(World var1) {
        super(var1);
        this.field_618_ad = true;
        this.field_9363_r = (float)(Math.random() + 1.0D) * 0.01F;
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
        this.field_9365_p = (float)Math.random() * 12398.0F;
        this.field_605_aq = (float)(Math.random() * 3.1415927410125732D * 2.0D);
        this.field_9286_aZ = 0.5F;
    }

    protected void func_21057_b() {
    }

    public boolean func_420_c(Entity var1) {
        return this.field_615_ag.func_645_a(Vec3D.func_1248_b(this.field_611_ak, this.field_610_al + (double)this.func_373_s(), this.field_609_am), Vec3D.func_1248_b(var1.field_611_ak, var1.field_610_al + (double)var1.func_373_s(), var1.field_609_am)) == null;
    }

    public String func_6376_z() {
        return this.field_9357_z;
    }

    public boolean func_401_c_() {
        return !this.field_646_aA;
    }

    public boolean func_385_d_() {
        return !this.field_646_aA;
    }

    public float func_373_s() {
        return this.field_643_aD * 0.85F;
    }

    public int func_421_b() {
        return 80;
    }

    public void func_22050_O() {
        String var1 = this.func_6389_d();
        if (var1 != null) {
            this.field_615_ag.func_623_a(this, var1, this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
        }

    }

    public void func_391_y() {
        this.field_9341_H = this.field_9339_I;
        super.func_391_y();
        if (this.field_9312_bd.nextInt(1000) < this.field_4121_a++) {
            this.field_4121_a = -this.func_421_b();
            this.func_22050_O();
        }

        if (this.func_354_B() && this.func_345_I()) {
            this.func_396_a((Entity)null, 1);
        }

        if (this.field_9304_bm || this.field_615_ag.field_1026_y) {
            this.field_9309_bg = 0;
        }

        int var1;
        if (this.func_354_B() && this.func_393_a(Material.field_1332_f) && !this.func_21067_c_()) {
            --this.field_9305_bk;
            if (this.field_9305_bk == -20) {
                this.field_9305_bk = 0;

                for(var1 = 0; var1 < 8; ++var1) {
                    float var2 = this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat();
                    float var3 = this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat();
                    float var4 = this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat();
                    this.field_615_ag.func_694_a("bubble", this.field_611_ak + (double)var2, this.field_610_al + (double)var3, this.field_609_am + (double)var4, this.field_608_an, this.field_607_ao, this.field_606_ap);
                }

                this.func_396_a((Entity)null, 2);
            }

            this.field_9309_bg = 0;
        } else {
            this.field_9305_bk = this.field_9308_bh;
        }

        this.field_9329_Q = this.field_9328_R;
        if (this.field_9330_P > 0) {
            --this.field_9330_P;
        }

        if (this.field_715_G > 0) {
            --this.field_715_G;
        }

        if (this.field_9306_bj > 0) {
            --this.field_9306_bj;
        }

        if (this.field_9337_J <= 0) {
            ++this.field_712_J;
            if (this.field_712_J > 20) {
                this.func_6392_F();
                this.func_395_F();

                for(var1 = 0; var1 < 20; ++var1) {
                    double var8 = this.field_9312_bd.nextGaussian() * 0.02D;
                    double var9 = this.field_9312_bd.nextGaussian() * 0.02D;
                    double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
                    this.field_615_ag.func_694_a("explode", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var8, var9, var6);
                }
            }
        }

        this.field_9359_x = this.field_9360_w;
        this.field_734_o = this.field_735_n;
        this.field_603_as = this.field_605_aq;
        this.field_602_at = this.field_604_ar;
    }

    public void func_415_z() {
        for(int var1 = 0; var1 < 20; ++var1) {
            double var2 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var8 = 10.0D;
            this.field_615_ag.func_694_a("explode", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC - var2 * var8, this.field_610_al + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD) - var4 * var8, this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC - var6 * var8, var2, var4, var6);
        }

    }

    public void func_350_p() {
        super.func_350_p();
        this.field_9362_u = this.field_9361_v;
        this.field_9361_v = 0.0F;
    }

    public void func_378_a(double var1, double var3, double var5, float var7, float var8, int var9) {
        this.field_9292_aO = 0.0F;
        this.field_9323_Z = var1;
        this.field_9356_aa = var3;
        this.field_9354_ab = var5;
        this.field_9352_ac = (double)var7;
        this.field_9350_ad = (double)var8;
        this.field_9324_Y = var9;
    }

    public void func_370_e_() {
        super.func_370_e_();
        this.func_425_j();
        double var1 = this.field_611_ak - this.field_9285_at;
        double var3 = this.field_609_am - this.field_9283_av;
        float var5 = MathHelper.func_1109_a(var1 * var1 + var3 * var3);
        float var6 = this.field_735_n;
        float var7 = 0.0F;
        this.field_9362_u = this.field_9361_v;
        float var8 = 0.0F;
        if (var5 > 0.05F) {
            var8 = 1.0F;
            var7 = var5 * 3.0F;
            var6 = (float)Math.atan2(var3, var1) * 180.0F / 3.1415927F - 90.0F;
        }

        if (this.field_9339_I > 0.0F) {
            var6 = this.field_605_aq;
        }

        if (!this.field_9298_aH) {
            var8 = 0.0F;
        }

        this.field_9361_v += (var8 - this.field_9361_v) * 0.3F;

        float var9;
        for(var9 = var6 - this.field_735_n; var9 < -180.0F; var9 += 360.0F) {
        }

        while(var9 >= 180.0F) {
            var9 -= 360.0F;
        }

        this.field_735_n += var9 * 0.3F;

        float var10;
        for(var10 = this.field_605_aq - this.field_735_n; var10 < -180.0F; var10 += 360.0F) {
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

        this.field_735_n = this.field_605_aq - var10;
        if (var10 * var10 > 2500.0F) {
            this.field_735_n += var10 * 0.2F;
        }

        if (var11) {
            var7 *= -1.0F;
        }

        while(this.field_605_aq - this.field_603_as < -180.0F) {
            this.field_603_as -= 360.0F;
        }

        while(this.field_605_aq - this.field_603_as >= 180.0F) {
            this.field_603_as += 360.0F;
        }

        while(this.field_735_n - this.field_734_o < -180.0F) {
            this.field_734_o -= 360.0F;
        }

        while(this.field_735_n - this.field_734_o >= 180.0F) {
            this.field_734_o += 360.0F;
        }

        while(this.field_604_ar - this.field_602_at < -180.0F) {
            this.field_602_at -= 360.0F;
        }

        while(this.field_604_ar - this.field_602_at >= 180.0F) {
            this.field_602_at += 360.0F;
        }

        this.field_9360_w += var7;
    }

    protected void func_371_a(float var1, float var2) {
        super.func_371_a(var1, var2);
    }

    public void func_432_b(int var1) {
        if (this.field_9337_J > 0) {
            this.field_9337_J += var1;
            if (this.field_9337_J > 20) {
                this.field_9337_J = 20;
            }

            this.field_9306_bj = this.field_9366_o / 2;
        }
    }

    public boolean func_396_a(Entity var1, int var2) {
        if (this.field_615_ag.field_1026_y) {
            return false;
        } else {
            this.field_9344_ag = 0;
            if (this.field_9337_J <= 0) {
                return false;
            } else {
                this.field_704_R = 1.5F;
                boolean var3 = true;
                if ((float)this.field_9306_bj > (float)this.field_9366_o / 2.0F) {
                    if (var2 <= this.field_9346_af) {
                        return false;
                    }

                    this.func_4044_a(var2 - this.field_9346_af);
                    this.field_9346_af = var2;
                    var3 = false;
                } else {
                    this.field_9346_af = var2;
                    this.field_9335_K = this.field_9337_J;
                    this.field_9306_bj = this.field_9366_o;
                    this.func_4044_a(var2);
                    this.field_715_G = this.field_9332_M = 10;
                }

                this.field_9331_N = 0.0F;
                if (var3) {
                    this.field_615_ag.func_9425_a(this, (byte)2);
                    this.func_9281_M();
                    if (var1 != null) {
                        double var4 = var1.field_611_ak - this.field_611_ak;

                        double var6;
                        for(var6 = var1.field_609_am - this.field_609_am; var4 * var4 + var6 * var6 < 1.0E-4D; var6 = (Math.random() - Math.random()) * 0.01D) {
                            var4 = (Math.random() - Math.random()) * 0.01D;
                        }

                        this.field_9331_N = (float)(Math.atan2(var6, var4) * 180.0D / 3.1415927410125732D) - this.field_605_aq;
                        this.func_434_a(var1, var2, var4, var6);
                    } else {
                        this.field_9331_N = (float)((int)(Math.random() * 2.0D) * 180);
                    }
                }

                if (this.field_9337_J <= 0) {
                    if (var3) {
                        this.field_615_ag.func_623_a(this, this.func_6390_f(), this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
                    }

                    this.func_419_b(var1);
                } else if (var3) {
                    this.field_615_ag.func_623_a(this, this.func_6394_f_(), this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
                }

                return true;
            }
        }
    }

    public void func_9280_g() {
        this.field_715_G = this.field_9332_M = 10;
        this.field_9331_N = 0.0F;
    }

    protected void func_4044_a(int var1) {
        this.field_9337_J -= var1;
    }

    protected float func_6393_h() {
        return 1.0F;
    }

    protected String func_6389_d() {
        return null;
    }

    protected String func_6394_f_() {
        return "random.hurt";
    }

    protected String func_6390_f() {
        return "random.hurt";
    }

    public void func_434_a(Entity var1, int var2, double var3, double var5) {
        float var7 = MathHelper.func_1109_a(var3 * var3 + var5 * var5);
        float var8 = 0.4F;
        this.field_608_an /= 2.0D;
        this.field_607_ao /= 2.0D;
        this.field_606_ap /= 2.0D;
        this.field_608_an -= var3 / (double)var7 * (double)var8;
        this.field_607_ao += 0.4000000059604645D;
        this.field_606_ap -= var5 / (double)var7 * (double)var8;
        if (this.field_607_ao > 0.4000000059604645D) {
            this.field_607_ao = 0.4000000059604645D;
        }

    }

    public void func_419_b(Entity var1) {
        if (this.field_9347_E >= 0 && var1 != null) {
            var1.func_364_b(this, this.field_9347_E);
        }

        if (var1 != null) {
            var1.func_27015_a(this);
        }

        this.field_9327_S = true;
        if (!this.field_615_ag.field_1026_y) {
            this.func_21066_o();
        }

        this.field_615_ag.func_9425_a(this, (byte)3);
    }

    protected void func_21066_o() {
        int var1 = this.func_422_g();
        if (var1 > 0) {
            int var2 = this.field_9312_bd.nextInt(3);

            for(int var3 = 0; var3 < var2; ++var3) {
                this.func_367_b(var1, 1);
            }
        }

    }

    protected int func_422_g() {
        return 0;
    }

    protected void func_400_c(float var1) {
        super.func_400_c(var1);
        int var2 = (int)Math.ceil((double)(var1 - 3.0F));
        if (var2 > 0) {
            this.func_396_a((Entity)null, var2);
            int var3 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al - 0.20000000298023224D - (double)this.field_9292_aO), MathHelper.func_1108_b(this.field_609_am));
            if (var3 > 0) {
                StepSound var4 = Block.field_345_n[var3].field_358_bl;
                this.field_615_ag.func_623_a(this, var4.func_1145_d(), var4.func_1147_b() * 0.5F, var4.func_1144_c() * 0.75F);
            }
        }

    }

    public void func_435_b(float var1, float var2) {
        double var3;
        if (this.func_27013_ag()) {
            var3 = this.field_610_al;
            this.func_351_a(var1, var2, 0.02F);
            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            this.field_608_an *= 0.800000011920929D;
            this.field_607_ao *= 0.800000011920929D;
            this.field_606_ap *= 0.800000011920929D;
            this.field_607_ao -= 0.02D;
            if (this.field_9297_aI && this.func_403_b(this.field_608_an, this.field_607_ao + 0.6000000238418579D - this.field_610_al + var3, this.field_606_ap)) {
                this.field_607_ao = 0.30000001192092896D;
            }
        } else if (this.func_359_G()) {
            var3 = this.field_610_al;
            this.func_351_a(var1, var2, 0.02F);
            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            this.field_608_an *= 0.5D;
            this.field_607_ao *= 0.5D;
            this.field_606_ap *= 0.5D;
            this.field_607_ao -= 0.02D;
            if (this.field_9297_aI && this.func_403_b(this.field_608_an, this.field_607_ao + 0.6000000238418579D - this.field_610_al + var3, this.field_606_ap)) {
                this.field_607_ao = 0.30000001192092896D;
            }
        } else {
            float var8 = 0.91F;
            if (this.field_9298_aH) {
                var8 = 0.54600006F;
                int var4 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
                if (var4 > 0) {
                    var8 = Block.field_345_n[var4].field_355_bo * 0.91F;
                }
            }

            float var9 = 0.16277136F / (var8 * var8 * var8);
            this.func_351_a(var1, var2, this.field_9298_aH ? 0.1F * var9 : 0.02F);
            var8 = 0.91F;
            if (this.field_9298_aH) {
                var8 = 0.54600006F;
                int var5 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
                if (var5 > 0) {
                    var8 = Block.field_345_n[var5].field_355_bo * 0.91F;
                }
            }

            if (this.func_429_A()) {
                float var10 = 0.15F;
                if (this.field_608_an < (double)(-var10)) {
                    this.field_608_an = (double)(-var10);
                }

                if (this.field_608_an > (double)var10) {
                    this.field_608_an = (double)var10;
                }

                if (this.field_606_ap < (double)(-var10)) {
                    this.field_606_ap = (double)(-var10);
                }

                if (this.field_606_ap > (double)var10) {
                    this.field_606_ap = (double)var10;
                }

                this.field_9288_aU = 0.0F;
                if (this.field_607_ao < -0.15D) {
                    this.field_607_ao = -0.15D;
                }

                if (this.func_381_o() && this.field_607_ao < 0.0D) {
                    this.field_607_ao = 0.0D;
                }
            }

            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            if (this.field_9297_aI && this.func_429_A()) {
                this.field_607_ao = 0.2D;
            }

            this.field_607_ao -= 0.08D;
            this.field_607_ao *= 0.9800000190734863D;
            this.field_608_an *= (double)var8;
            this.field_606_ap *= (double)var8;
        }

        this.field_705_Q = this.field_704_R;
        var3 = this.field_611_ak - this.field_9285_at;
        double var11 = this.field_609_am - this.field_9283_av;
        float var7 = MathHelper.func_1109_a(var3 * var3 + var11 * var11) * 4.0F;
        if (var7 > 1.0F) {
            var7 = 1.0F;
        }

        this.field_704_R += (var7 - this.field_704_R) * 0.4F;
        this.field_703_S += this.field_704_R;
    }

    public boolean func_429_A() {
        int var1 = MathHelper.func_1108_b(this.field_611_ak);
        int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
        int var3 = MathHelper.func_1108_b(this.field_609_am);
        return this.field_615_ag.func_600_a(var1, var2, var3) == Block.field_441_aG.field_376_bc;
    }

    public void func_352_a(NBTTagCompound var1) {
        var1.func_749_a("Health", (short)this.field_9337_J);
        var1.func_749_a("HurtTime", (short)this.field_715_G);
        var1.func_749_a("DeathTime", (short)this.field_712_J);
        var1.func_749_a("AttackTime", (short)this.field_9330_P);
    }

    public void func_357_b(NBTTagCompound var1) {
        this.field_9337_J = var1.func_745_d("Health");
        if (!var1.func_751_b("Health")) {
            this.field_9337_J = 10;
        }

        this.field_715_G = var1.func_745_d("HurtTime");
        this.field_712_J = var1.func_745_d("DeathTime");
        this.field_9330_P = var1.func_745_d("AttackTime");
    }

    public boolean func_354_B() {
        return !this.field_646_aA && this.field_9337_J > 0;
    }

    public boolean func_21067_c_() {
        return false;
    }

    public void func_425_j() {
        if (this.field_9324_Y > 0) {
            double var1 = this.field_611_ak + (this.field_9323_Z - this.field_611_ak) / (double)this.field_9324_Y;
            double var3 = this.field_610_al + (this.field_9356_aa - this.field_610_al) / (double)this.field_9324_Y;
            double var5 = this.field_609_am + (this.field_9354_ab - this.field_609_am) / (double)this.field_9324_Y;

            double var7;
            for(var7 = this.field_9352_ac - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
            }

            while(var7 >= 180.0D) {
                var7 -= 360.0D;
            }

            this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_9324_Y);
            this.field_604_ar = (float)((double)this.field_604_ar + (this.field_9350_ad - (double)this.field_604_ar) / (double)this.field_9324_Y);
            --this.field_9324_Y;
            this.func_347_a(var1, var3, var5);
            this.func_376_c(this.field_605_aq, this.field_604_ar);
            List var9 = this.field_615_ag.func_697_a(this, this.field_601_au.func_28195_e(0.03125D, 0.0D, 0.03125D));
            if (var9.size() > 0) {
                double var10 = 0.0D;

                for(int var12 = 0; var12 < var9.size(); ++var12) {
                    AxisAlignedBB var13 = (AxisAlignedBB)var9.get(var12);
                    if (var13.field_1702_e > var10) {
                        var10 = var13.field_1702_e;
                    }
                }

                var3 += var10 - this.field_601_au.field_1697_b;
                this.func_347_a(var1, var3, var5);
            }
        }

        if (this.func_22049_v()) {
            this.field_9336_ak = false;
            this.field_9342_ah = 0.0F;
            this.field_9340_ai = 0.0F;
            this.field_9338_aj = 0.0F;
        } else if (!this.field_9343_G) {
            this.func_418_b_();
        }

        boolean var14 = this.func_27013_ag();
        boolean var2 = this.func_359_G();
        if (this.field_9336_ak) {
            if (var14) {
                this.field_607_ao += 0.03999999910593033D;
            } else if (var2) {
                this.field_607_ao += 0.03999999910593033D;
            } else if (this.field_9298_aH) {
                this.func_424_C();
            }
        }

        this.field_9342_ah *= 0.98F;
        this.field_9340_ai *= 0.98F;
        this.field_9338_aj *= 0.9F;
        this.func_435_b(this.field_9342_ah, this.field_9340_ai);
        List var15 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if (var15 != null && var15.size() > 0) {
            for(int var4 = 0; var4 < var15.size(); ++var4) {
                Entity var16 = (Entity)var15.get(var4);
                if (var16.func_385_d_()) {
                    var16.func_380_f(this);
                }
            }
        }

    }

    protected boolean func_22049_v() {
        return this.field_9337_J <= 0;
    }

    protected void func_424_C() {
        this.field_607_ao = 0.41999998688697815D;
    }

    protected boolean func_25023_u() {
        return true;
    }

    protected void func_27021_X() {
        EntityPlayer var1 = this.field_615_ag.func_609_a(this, -1.0D);
        if (this.func_25023_u() && var1 != null) {
            double var2 = var1.field_611_ak - this.field_611_ak;
            double var4 = var1.field_610_al - this.field_610_al;
            double var6 = var1.field_609_am - this.field_609_am;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            if (var8 > 16384.0D) {
                this.func_395_F();
            }

            if (this.field_9344_ag > 600 && this.field_9312_bd.nextInt(800) == 0) {
                if (var8 < 1024.0D) {
                    this.field_9344_ag = 0;
                } else {
                    this.func_395_F();
                }
            }
        }

    }

    protected void func_418_b_() {
        ++this.field_9344_ag;
        EntityPlayer var1 = this.field_615_ag.func_609_a(this, -1.0D);
        this.func_27021_X();
        this.field_9342_ah = 0.0F;
        this.field_9340_ai = 0.0F;
        float var2 = 8.0F;
        if (this.field_9312_bd.nextFloat() < 0.02F) {
            var1 = this.field_615_ag.func_609_a(this, (double)var2);
            if (var1 != null) {
                this.field_4120_b = var1;
                this.field_4127_c = 10 + this.field_9312_bd.nextInt(20);
            } else {
                this.field_9338_aj = (this.field_9312_bd.nextFloat() - 0.5F) * 20.0F;
            }
        }

        if (this.field_4120_b != null) {
            this.func_426_b(this.field_4120_b, 10.0F, (float)this.func_25026_x());
            if (this.field_4127_c-- <= 0 || this.field_4120_b.field_646_aA || this.field_4120_b.func_387_e(this) > (double)(var2 * var2)) {
                this.field_4120_b = null;
            }
        } else {
            if (this.field_9312_bd.nextFloat() < 0.05F) {
                this.field_9338_aj = (this.field_9312_bd.nextFloat() - 0.5F) * 20.0F;
            }

            this.field_605_aq += this.field_9338_aj;
            this.field_604_ar = this.field_9334_al;
        }

        boolean var3 = this.func_27013_ag();
        boolean var4 = this.func_359_G();
        if (var3 || var4) {
            this.field_9336_ak = this.field_9312_bd.nextFloat() < 0.8F;
        }

    }

    protected int func_25026_x() {
        return 40;
    }

    public void func_426_b(Entity var1, float var2, float var3) {
        double var4 = var1.field_611_ak - this.field_611_ak;
        double var8 = var1.field_609_am - this.field_609_am;
        double var6;
        if (var1 instanceof EntityLiving) {
            EntityLiving var10 = (EntityLiving)var1;
            var6 = this.field_610_al + (double)this.func_373_s() - (var10.field_610_al + (double)var10.func_373_s());
        } else {
            var6 = (var1.field_601_au.field_1697_b + var1.field_601_au.field_1702_e) / 2.0D - (this.field_610_al + (double)this.func_373_s());
        }

        double var14 = (double)MathHelper.func_1109_a(var4 * var4 + var8 * var8);
        float var12 = (float)(Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
        float var13 = (float)(-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
        this.field_604_ar = -this.func_417_b(this.field_604_ar, var13, var3);
        this.field_605_aq = this.func_417_b(this.field_605_aq, var12, var2);
    }

    public boolean func_25025_V() {
        return this.field_4120_b != null;
    }

    public Entity func_25024_W() {
        return this.field_4120_b;
    }

    private float func_417_b(float var1, float var2, float var3) {
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

    public void func_6392_F() {
    }

    public boolean func_433_a() {
        return this.field_615_ag.func_604_a(this.field_601_au) && this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au);
    }

    protected void func_4034_G() {
        this.func_396_a((Entity)null, 4);
    }

    public float func_431_d(float var1) {
        float var2 = this.field_9339_I - this.field_9341_H;
        if (var2 < 0.0F) {
            ++var2;
        }

        return this.field_9341_H + var2 * var1;
    }

    public Vec3D func_427_e(float var1) {
        if (var1 == 1.0F) {
            return Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
        } else {
            double var2 = this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)var1;
            double var4 = this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)var1;
            double var6 = this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)var1;
            return Vec3D.func_1248_b(var2, var4, var6);
        }
    }

    public Vec3D func_4037_H() {
        return this.func_430_f(1.0F);
    }

    public Vec3D func_430_f(float var1) {
        float var2;
        float var3;
        float var4;
        float var5;
        if (var1 == 1.0F) {
            var2 = MathHelper.func_1114_b(-this.field_605_aq * 0.017453292F - 3.1415927F);
            var3 = MathHelper.func_1106_a(-this.field_605_aq * 0.017453292F - 3.1415927F);
            var4 = -MathHelper.func_1114_b(-this.field_604_ar * 0.017453292F);
            var5 = MathHelper.func_1106_a(-this.field_604_ar * 0.017453292F);
            return Vec3D.func_1248_b((double)(var3 * var4), (double)var5, (double)(var2 * var4));
        } else {
            var2 = this.field_602_at + (this.field_604_ar - this.field_602_at) * var1;
            var3 = this.field_603_as + (this.field_605_aq - this.field_603_as) * var1;
            var4 = MathHelper.func_1114_b(-var3 * 0.017453292F - 3.1415927F);
            var5 = MathHelper.func_1106_a(-var3 * 0.017453292F - 3.1415927F);
            float var6 = -MathHelper.func_1114_b(-var2 * 0.017453292F);
            float var7 = MathHelper.func_1106_a(-var2 * 0.017453292F);
            return Vec3D.func_1248_b((double)(var5 * var6), (double)var7, (double)(var4 * var6));
        }
    }

    public MovingObjectPosition func_416_a(double var1, float var3) {
        Vec3D var4 = this.func_427_e(var3);
        Vec3D var5 = this.func_430_f(var3);
        Vec3D var6 = var4.func_1257_c(var5.field_1776_a * var1, var5.field_1775_b * var1, var5.field_1779_c * var1);
        return this.field_615_ag.func_645_a(var4, var6);
    }

    public int func_6391_i() {
        return 4;
    }

    public ItemStack func_4045_l() {
        return null;
    }

    public void func_9282_a(byte var1) {
        if (var1 == 2) {
            this.field_704_R = 1.5F;
            this.field_9306_bj = this.field_9366_o;
            this.field_715_G = this.field_9332_M = 10;
            this.field_9331_N = 0.0F;
            this.field_615_ag.func_623_a(this, this.func_6394_f_(), this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
            this.func_396_a((Entity)null, 0);
        } else if (var1 == 3) {
            this.field_615_ag.func_623_a(this, this.func_6390_f(), this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
            this.field_9337_J = 0;
            this.func_419_b((Entity)null);
        } else {
            super.func_9282_a(var1);
        }

    }

    public boolean func_22051_K() {
        return false;
    }

    public int func_28021_c(ItemStack var1) {
        return var1.func_1088_b();
    }
}
