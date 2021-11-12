package net.minecraft.src;

public class EntityGhast extends EntityFlying implements IMob {
    public int field_20901_a = 0;
    public double field_20900_b;
    public double field_20902_c;
    public double field_4126_d;
    private Entity field_4123_g = null;
    private int field_4122_h = 0;
    public int field_4125_e = 0;
    public int field_4124_f = 0;

    public EntityGhast(World var1) {
        super(var1);
        this.field_9357_z = "/mob/ghast.png";
        this.func_371_a(4.0F, 4.0F);
        this.field_9304_bm = true;
    }

    protected void func_21057_b() {
        super.func_21057_b();
        this.field_21064_bx.func_21124_a(16, (byte)0);
    }

    public void func_370_e_() {
        super.func_370_e_();
        byte var1 = this.field_21064_bx.func_21130_a(16);
        this.field_9357_z = var1 == 1 ? "/mob/ghast_fire.png" : "/mob/ghast.png";
    }

    protected void func_418_b_() {
        if (!this.field_615_ag.field_1026_y && this.field_615_ag.field_1039_l == 0) {
            this.func_395_F();
        }

        this.func_27021_X();
        this.field_4125_e = this.field_4124_f;
        double var1 = this.field_20900_b - this.field_611_ak;
        double var3 = this.field_20902_c - this.field_610_al;
        double var5 = this.field_4126_d - this.field_609_am;
        double var7 = (double)MathHelper.func_1109_a(var1 * var1 + var3 * var3 + var5 * var5);
        if (var7 < 1.0D || var7 > 60.0D) {
            this.field_20900_b = this.field_611_ak + (double)((this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.field_20902_c = this.field_610_al + (double)((this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.field_4126_d = this.field_609_am + (double)((this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.field_20901_a-- <= 0) {
            this.field_20901_a += this.field_9312_bd.nextInt(5) + 2;
            if (this.func_27023_a(this.field_20900_b, this.field_20902_c, this.field_4126_d, var7)) {
                this.field_608_an += var1 / var7 * 0.1D;
                this.field_607_ao += var3 / var7 * 0.1D;
                this.field_606_ap += var5 / var7 * 0.1D;
            } else {
                this.field_20900_b = this.field_611_ak;
                this.field_20902_c = this.field_610_al;
                this.field_4126_d = this.field_609_am;
            }
        }

        if (this.field_4123_g != null && this.field_4123_g.field_646_aA) {
            this.field_4123_g = null;
        }

        if (this.field_4123_g == null || this.field_4122_h-- <= 0) {
            this.field_4123_g = this.field_615_ag.func_609_a(this, 100.0D);
            if (this.field_4123_g != null) {
                this.field_4122_h = 20;
            }
        }

        double var9 = 64.0D;
        if (this.field_4123_g != null && this.field_4123_g.func_387_e(this) < var9 * var9) {
            double var11 = this.field_4123_g.field_611_ak - this.field_611_ak;
            double var13 = this.field_4123_g.field_601_au.field_1697_b + (double)(this.field_4123_g.field_643_aD / 2.0F) - (this.field_610_al + (double)(this.field_643_aD / 2.0F));
            double var15 = this.field_4123_g.field_609_am - this.field_609_am;
            this.field_735_n = this.field_605_aq = -((float)Math.atan2(var11, var15)) * 180.0F / 3.1415927F;
            if (this.func_420_c(this.field_4123_g)) {
                if (this.field_4124_f == 10) {
                    this.field_615_ag.func_623_a(this, "mob.ghast.charge", this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
                }

                ++this.field_4124_f;
                if (this.field_4124_f == 20) {
                    this.field_615_ag.func_623_a(this, "mob.ghast.fireball", this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
                    EntityFireball var17 = new EntityFireball(this.field_615_ag, this, var11, var13, var15);
                    double var18 = 4.0D;
                    Vec3D var20 = this.func_430_f(1.0F);
                    var17.field_611_ak = this.field_611_ak + var20.field_1776_a * var18;
                    var17.field_610_al = this.field_610_al + (double)(this.field_643_aD / 2.0F) + 0.5D;
                    var17.field_609_am = this.field_609_am + var20.field_1779_c * var18;
                    this.field_615_ag.func_674_a(var17);
                    this.field_4124_f = -40;
                }
            } else if (this.field_4124_f > 0) {
                --this.field_4124_f;
            }
        } else {
            this.field_735_n = this.field_605_aq = -((float)Math.atan2(this.field_608_an, this.field_606_ap)) * 180.0F / 3.1415927F;
            if (this.field_4124_f > 0) {
                --this.field_4124_f;
            }
        }

        if (!this.field_615_ag.field_1026_y) {
            byte var21 = this.field_21064_bx.func_21130_a(16);
            byte var12 = (byte)(this.field_4124_f > 10 ? 1 : 0);
            if (var21 != var12) {
                this.field_21064_bx.func_21129_b(16, var12);
            }
        }

    }

    private boolean func_27023_a(double var1, double var3, double var5, double var7) {
        double var9 = (this.field_20900_b - this.field_611_ak) / var7;
        double var11 = (this.field_20902_c - this.field_610_al) / var7;
        double var13 = (this.field_4126_d - this.field_609_am) / var7;
        AxisAlignedBB var15 = this.field_601_au.func_1160_c();

        for(int var16 = 1; (double)var16 < var7; ++var16) {
            var15.func_1174_d(var9, var11, var13);
            if (this.field_615_ag.func_697_a(this, var15).size() > 0) {
                return false;
            }
        }

        return true;
    }

    protected String func_6389_d() {
        return "mob.ghast.moan";
    }

    protected String func_6394_f_() {
        return "mob.ghast.scream";
    }

    protected String func_6390_f() {
        return "mob.ghast.death";
    }

    protected int func_422_g() {
        return Item.field_250_K.field_291_aS;
    }

    protected float func_6393_h() {
        return 10.0F;
    }

    public boolean func_433_a() {
        return this.field_9312_bd.nextInt(20) == 0 && super.func_433_a() && this.field_615_ag.field_1039_l > 0;
    }

    public int func_6391_i() {
        return 1;
    }
}
