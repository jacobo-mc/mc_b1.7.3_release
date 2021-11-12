package net.minecraft.src;

public class EntityGhast extends EntityFlying implements IMob {
    public int field_20903_a = 0;
    public double field_20902_b;
    public double field_20904_c;
    public double field_4102_d;
    private Entity field_4097_ai = null;
    private int field_4103_aj = 0;
    public int field_4101_e = 0;
    public int field_4100_f = 0;

    public EntityGhast(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/ghast.png";
        this.func_113_a(4.0F, 4.0F);
        this.field_9079_ae = true;
    }

    protected void func_21044_a() {
        super.func_21044_a();
        this.field_21045_af.func_21153_a(16, (byte)0);
    }

    public void func_106_b_() {
        super.func_106_b_();
        byte var1 = this.field_21045_af.func_21156_a(16);
        this.field_9119_aG = var1 == 1 ? "/mob/ghast_fire.png" : "/mob/ghast.png";
    }

    protected void func_152_d_() {
        if (!this.field_9093_l.field_792_x && this.field_9093_l.field_804_l == 0) {
            this.func_118_j();
        }

        this.func_27013_Q();
        this.field_4101_e = this.field_4100_f;
        double var1 = this.field_20902_b - this.field_322_l;
        double var3 = this.field_20904_c - this.field_321_m;
        double var5 = this.field_4102_d - this.field_320_n;
        double var7 = (double)MathHelper.func_583_a(var1 * var1 + var3 * var3 + var5 * var5);
        if (var7 < 1.0D || var7 > 60.0D) {
            this.field_20902_b = this.field_322_l + (double)((this.field_9064_W.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.field_20904_c = this.field_321_m + (double)((this.field_9064_W.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.field_4102_d = this.field_320_n + (double)((this.field_9064_W.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.field_20903_a-- <= 0) {
            this.field_20903_a += this.field_9064_W.nextInt(5) + 2;
            if (this.func_4046_a(this.field_20902_b, this.field_20904_c, this.field_4102_d, var7)) {
                this.field_319_o += var1 / var7 * 0.1D;
                this.field_318_p += var3 / var7 * 0.1D;
                this.field_317_q += var5 / var7 * 0.1D;
            } else {
                this.field_20902_b = this.field_322_l;
                this.field_20904_c = this.field_321_m;
                this.field_4102_d = this.field_320_n;
            }
        }

        if (this.field_4097_ai != null && this.field_4097_ai.field_304_B) {
            this.field_4097_ai = null;
        }

        if (this.field_4097_ai == null || this.field_4103_aj-- <= 0) {
            this.field_4097_ai = this.field_9093_l.func_472_a(this, 100.0D);
            if (this.field_4097_ai != null) {
                this.field_4103_aj = 20;
            }
        }

        double var9 = 64.0D;
        if (this.field_4097_ai != null && this.field_4097_ai.func_102_b(this) < var9 * var9) {
            double var11 = this.field_4097_ai.field_322_l - this.field_322_l;
            double var13 = this.field_4097_ai.field_312_v.field_963_b + (double)(this.field_4097_ai.field_298_E / 2.0F) - (this.field_321_m + (double)(this.field_298_E / 2.0F));
            double var15 = this.field_4097_ai.field_320_n - this.field_320_n;
            this.field_9095_az = this.field_316_r = -((float)Math.atan2(var11, var15)) * 180.0F / 3.1415927F;
            if (this.func_145_g(this.field_4097_ai)) {
                if (this.field_4100_f == 10) {
                    this.field_9093_l.func_506_a(this, "mob.ghast.charge", this.func_6102_h(), (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
                }

                ++this.field_4100_f;
                if (this.field_4100_f == 20) {
                    this.field_9093_l.func_506_a(this, "mob.ghast.fireball", this.func_6102_h(), (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
                    EntityFireball var17 = new EntityFireball(this.field_9093_l, this, var11, var13, var15);
                    double var18 = 4.0D;
                    Vec3D var20 = this.func_141_d(1.0F);
                    var17.field_322_l = this.field_322_l + var20.field_1055_a * var18;
                    var17.field_321_m = this.field_321_m + (double)(this.field_298_E / 2.0F) + 0.5D;
                    var17.field_320_n = this.field_320_n + var20.field_1058_c * var18;
                    this.field_9093_l.func_526_a(var17);
                    this.field_4100_f = -40;
                }
            } else if (this.field_4100_f > 0) {
                --this.field_4100_f;
            }
        } else {
            this.field_9095_az = this.field_316_r = -((float)Math.atan2(this.field_319_o, this.field_317_q)) * 180.0F / 3.1415927F;
            if (this.field_4100_f > 0) {
                --this.field_4100_f;
            }
        }

        if (!this.field_9093_l.field_792_x) {
            byte var21 = this.field_21045_af.func_21156_a(16);
            byte var12 = (byte)(this.field_4100_f > 10 ? 1 : 0);
            if (var21 != var12) {
                this.field_21045_af.func_21155_b(16, var12);
            }
        }

    }

    private boolean func_4046_a(double var1, double var3, double var5, double var7) {
        double var9 = (this.field_20902_b - this.field_322_l) / var7;
        double var11 = (this.field_20904_c - this.field_321_m) / var7;
        double var13 = (this.field_4102_d - this.field_320_n) / var7;
        AxisAlignedBB var15 = this.field_312_v.func_711_b();

        for(int var16 = 1; (double)var16 < var7; ++var16) {
            var15.func_702_d(var9, var11, var13);
            if (this.field_9093_l.func_481_a(this, var15).size() > 0) {
                return false;
            }
        }

        return true;
    }

    protected String func_6097_d() {
        return "mob.ghast.moan";
    }

    protected String func_6100_e() {
        return "mob.ghast.scream";
    }

    protected String func_6098_f() {
        return "mob.ghast.death";
    }

    protected int func_149_g() {
        return Item.field_193_K.field_234_aS;
    }

    protected float func_6102_h() {
        return 10.0F;
    }

    public boolean func_155_a() {
        return this.field_9064_W.nextInt(20) == 0 && super.func_155_a() && this.field_9093_l.field_804_l > 0;
    }

    public int func_4045_i() {
        return 1;
    }
}
