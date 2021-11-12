package net.minecraft.src;

public class EntityCreature extends EntityLiving {
    private PathEntity field_388_a;
    protected Entity field_389_ag;
    protected boolean field_387_ah = false;

    public EntityCreature(World var1) {
        super(var1);
    }

    protected boolean func_25026_u() {
        return false;
    }

    protected void func_152_d_() {
        this.field_387_ah = this.func_25026_u();
        float var1 = 16.0F;
        if (this.field_389_ag == null) {
            this.field_389_ag = this.func_158_i();
            if (this.field_389_ag != null) {
                this.field_388_a = this.field_9093_l.func_482_a(this, this.field_389_ag, var1);
            }
        } else if (!this.field_389_ag.func_120_t()) {
            this.field_389_ag = null;
        } else {
            float var2 = this.field_389_ag.func_94_a(this);
            if (this.func_145_g(this.field_389_ag)) {
                this.func_157_a(this.field_389_ag, var2);
            } else {
                this.func_28013_b(this.field_389_ag, var2);
            }
        }

        if (this.field_387_ah || this.field_389_ag == null || this.field_388_a != null && this.field_9064_W.nextInt(20) != 0) {
            if (!this.field_387_ah && (this.field_388_a == null && this.field_9064_W.nextInt(80) == 0 || this.field_9064_W.nextInt(80) == 0)) {
                this.func_31021_B();
            }
        } else {
            this.field_388_a = this.field_9093_l.func_482_a(this, this.field_389_ag, var1);
        }

        int var21 = MathHelper.func_584_b(this.field_312_v.field_963_b + 0.5D);
        boolean var3 = this.func_27011_Z();
        boolean var4 = this.func_112_q();
        this.field_315_s = 0.0F;
        if (this.field_388_a != null && this.field_9064_W.nextInt(100) != 0) {
            Vec3D var5 = this.field_388_a.func_727_a(this);
            double var6 = (double)(this.field_300_D * 2.0F);

            while(var5 != null && var5.func_759_d(this.field_322_l, var5.field_1054_b, this.field_320_n) < var6 * var6) {
                this.field_388_a.func_728_a();
                if (this.field_388_a.func_729_b()) {
                    var5 = null;
                    this.field_388_a = null;
                } else {
                    var5 = this.field_388_a.func_727_a(this);
                }
            }

            this.field_9128_br = false;
            if (var5 != null) {
                double var8 = var5.field_1055_a - this.field_322_l;
                double var10 = var5.field_1058_c - this.field_320_n;
                double var12 = var5.field_1054_b - (double)var21;
                float var14 = (float)(Math.atan2(var10, var8) * 180.0D / 3.1415927410125732D) - 90.0F;
                float var15 = var14 - this.field_316_r;

                for(this.field_9130_bp = this.field_9126_bt; var15 < -180.0F; var15 += 360.0F) {
                }

                while(var15 >= 180.0F) {
                    var15 -= 360.0F;
                }

                if (var15 > 30.0F) {
                    var15 = 30.0F;
                }

                if (var15 < -30.0F) {
                    var15 = -30.0F;
                }

                this.field_316_r += var15;
                if (this.field_387_ah && this.field_389_ag != null) {
                    double var16 = this.field_389_ag.field_322_l - this.field_322_l;
                    double var18 = this.field_389_ag.field_320_n - this.field_320_n;
                    float var20 = this.field_316_r;
                    this.field_316_r = (float)(Math.atan2(var18, var16) * 180.0D / 3.1415927410125732D) - 90.0F;
                    var15 = (var20 - this.field_316_r + 90.0F) * 3.1415927F / 180.0F;
                    this.field_9131_bo = -MathHelper.func_585_a(var15) * this.field_9130_bp * 1.0F;
                    this.field_9130_bp = MathHelper.func_582_b(var15) * this.field_9130_bp * 1.0F;
                }

                if (var12 > 0.0D) {
                    this.field_9128_br = true;
                }
            }

            if (this.field_389_ag != null) {
                this.func_147_b(this.field_389_ag, 30.0F, 30.0F);
            }

            if (this.field_9084_B && !this.func_25023_z()) {
                this.field_9128_br = true;
            }

            if (this.field_9064_W.nextFloat() < 0.8F && (var3 || var4)) {
                this.field_9128_br = true;
            }

        } else {
            super.func_152_d_();
            this.field_388_a = null;
        }
    }

    protected void func_31021_B() {
        boolean var1 = false;
        int var2 = -1;
        int var3 = -1;
        int var4 = -1;
        float var5 = -99999.0F;

        for(int var6 = 0; var6 < 10; ++var6) {
            int var7 = MathHelper.func_584_b(this.field_322_l + (double)this.field_9064_W.nextInt(13) - 6.0D);
            int var8 = MathHelper.func_584_b(this.field_321_m + (double)this.field_9064_W.nextInt(7) - 3.0D);
            int var9 = MathHelper.func_584_b(this.field_320_n + (double)this.field_9064_W.nextInt(13) - 6.0D);
            float var10 = this.func_159_a(var7, var8, var9);
            if (var10 > var5) {
                var5 = var10;
                var2 = var7;
                var3 = var8;
                var4 = var9;
                var1 = true;
            }
        }

        if (var1) {
            this.field_388_a = this.field_9093_l.func_501_a(this, var2, var3, var4, 10.0F);
        }

    }

    protected void func_157_a(Entity var1, float var2) {
    }

    protected void func_28013_b(Entity var1, float var2) {
    }

    protected float func_159_a(int var1, int var2, int var3) {
        return 0.0F;
    }

    protected Entity func_158_i() {
        return null;
    }

    public boolean func_155_a() {
        int var1 = MathHelper.func_584_b(this.field_322_l);
        int var2 = MathHelper.func_584_b(this.field_312_v.field_963_b);
        int var3 = MathHelper.func_584_b(this.field_320_n);
        return super.func_155_a() && this.func_159_a(var1, var2, var3) >= 0.0F;
    }

    public boolean func_25023_z() {
        return this.field_388_a != null;
    }

    public void func_25022_a(PathEntity var1) {
        this.field_388_a = var1;
    }

    public Entity func_25024_A() {
        return this.field_389_ag;
    }

    public void func_25025_c(Entity var1) {
        this.field_389_ag = var1;
    }
}
