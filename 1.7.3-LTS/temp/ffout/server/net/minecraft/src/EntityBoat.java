package net.minecraft.src;

import java.util.List;

public class EntityBoat extends Entity {
    public int field_9178_a;
    public int field_9177_b;
    public int field_436_ad;
    private int field_9176_d;
    private double field_9174_e;
    private double field_9172_f;
    private double field_9175_aj;
    private double field_9173_ak;
    private double field_9171_al;

    public EntityBoat(World var1) {
        super(var1);
        this.field_9178_a = 0;
        this.field_9177_b = 0;
        this.field_436_ad = 1;
        this.field_329_e = true;
        this.func_113_a(1.5F, 0.6F);
        this.field_9076_H = this.field_298_E / 2.0F;
    }

    protected boolean func_25017_l() {
        return false;
    }

    protected void func_21044_a() {
    }

    public AxisAlignedBB func_89_d(Entity var1) {
        return var1.field_312_v;
    }

    public AxisAlignedBB func_93_n() {
        return this.field_312_v;
    }

    public boolean func_124_r() {
        return true;
    }

    public EntityBoat(World var1, double var2, double var4, double var6) {
        this(var1);
        this.func_86_a(var2, var4 + (double)this.field_9076_H, var6);
        this.field_319_o = 0.0D;
        this.field_318_p = 0.0D;
        this.field_317_q = 0.0D;
        this.field_9092_m = var2;
        this.field_9091_n = var4;
        this.field_9090_o = var6;
    }

    public double func_130_h() {
        return (double)this.field_298_E * 0.0D - 0.30000001192092896D;
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (!this.field_9093_l.field_792_x && !this.field_304_B) {
            this.field_436_ad = -this.field_436_ad;
            this.field_9177_b = 10;
            this.field_9178_a += var2 * 10;
            this.func_9060_u();
            if (this.field_9178_a > 40) {
                if (this.field_328_f != null) {
                    this.field_328_f.func_6094_e(this);
                }

                int var3;
                for(var3 = 0; var3 < 3; ++var3) {
                    this.func_123_a(Block.field_531_y.field_573_bc, 1, 0.0F);
                }

                for(var3 = 0; var3 < 2; ++var3) {
                    this.func_123_a(Item.field_209_B.field_234_aS, 1, 0.0F);
                }

                this.func_118_j();
            }

            return true;
        } else {
            return true;
        }
    }

    public boolean func_129_c_() {
        return !this.field_304_B;
    }

    public void func_106_b_() {
        super.func_106_b_();
        if (this.field_9177_b > 0) {
            --this.field_9177_b;
        }

        if (this.field_9178_a > 0) {
            --this.field_9178_a;
        }

        this.field_9092_m = this.field_322_l;
        this.field_9091_n = this.field_321_m;
        this.field_9090_o = this.field_320_n;
        byte var1 = 5;
        double var2 = 0.0D;

        for(int var4 = 0; var4 < var1; ++var4) {
            double var5 = this.field_312_v.field_963_b + (this.field_312_v.field_968_e - this.field_312_v.field_963_b) * (double)(var4 + 0) / (double)var1 - 0.125D;
            double var7 = this.field_312_v.field_963_b + (this.field_312_v.field_968_e - this.field_312_v.field_963_b) * (double)(var4 + 1) / (double)var1 - 0.125D;
            AxisAlignedBB var9 = AxisAlignedBB.func_693_b(this.field_312_v.field_964_a, var5, this.field_312_v.field_970_c, this.field_312_v.field_969_d, var7, this.field_312_v.field_967_f);
            if (this.field_9093_l.func_524_b(var9, Material.field_521_f)) {
                var2 += 1.0D / (double)var1;
            }
        }

        double var6;
        double var8;
        double var10;
        double var21;
        if (this.field_9093_l.field_792_x) {
            if (this.field_9176_d > 0) {
                var21 = this.field_322_l + (this.field_9174_e - this.field_322_l) / (double)this.field_9176_d;
                var6 = this.field_321_m + (this.field_9172_f - this.field_321_m) / (double)this.field_9176_d;
                var8 = this.field_320_n + (this.field_9175_aj - this.field_320_n) / (double)this.field_9176_d;

                for(var10 = this.field_9173_ak - (double)this.field_316_r; var10 < -180.0D; var10 += 360.0D) {
                }

                while(var10 >= 180.0D) {
                    var10 -= 360.0D;
                }

                this.field_316_r = (float)((double)this.field_316_r + var10 / (double)this.field_9176_d);
                this.field_315_s = (float)((double)this.field_315_s + (this.field_9171_al - (double)this.field_315_s) / (double)this.field_9176_d);
                --this.field_9176_d;
                this.func_86_a(var21, var6, var8);
                this.func_6096_b(this.field_316_r, this.field_315_s);
            } else {
                var21 = this.field_322_l + this.field_319_o;
                var6 = this.field_321_m + this.field_318_p;
                var8 = this.field_320_n + this.field_317_q;
                this.func_86_a(var21, var6, var8);
                if (this.field_9086_A) {
                    this.field_319_o *= 0.5D;
                    this.field_318_p *= 0.5D;
                    this.field_317_q *= 0.5D;
                }

                this.field_319_o *= 0.9900000095367432D;
                this.field_318_p *= 0.949999988079071D;
                this.field_317_q *= 0.9900000095367432D;
            }

        } else {
            if (var2 < 1.0D) {
                var21 = var2 * 2.0D - 1.0D;
                this.field_318_p += 0.03999999910593033D * var21;
            } else {
                if (this.field_318_p < 0.0D) {
                    this.field_318_p /= 2.0D;
                }

                this.field_318_p += 0.007000000216066837D;
            }

            if (this.field_328_f != null) {
                this.field_319_o += this.field_328_f.field_319_o * 0.2D;
                this.field_317_q += this.field_328_f.field_317_q * 0.2D;
            }

            var21 = 0.4D;
            if (this.field_319_o < -var21) {
                this.field_319_o = -var21;
            }

            if (this.field_319_o > var21) {
                this.field_319_o = var21;
            }

            if (this.field_317_q < -var21) {
                this.field_317_q = -var21;
            }

            if (this.field_317_q > var21) {
                this.field_317_q = var21;
            }

            if (this.field_9086_A) {
                this.field_319_o *= 0.5D;
                this.field_318_p *= 0.5D;
                this.field_317_q *= 0.5D;
            }

            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            var6 = Math.sqrt(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
            if (var6 > 0.15D) {
                var8 = Math.cos((double)this.field_316_r * 3.141592653589793D / 180.0D);
                var10 = Math.sin((double)this.field_316_r * 3.141592653589793D / 180.0D);

                for(int var12 = 0; (double)var12 < 1.0D + var6 * 60.0D; ++var12) {
                    double var13 = (double)(this.field_9064_W.nextFloat() * 2.0F - 1.0F);
                    double var15 = (double)(this.field_9064_W.nextInt(2) * 2 - 1) * 0.7D;
                    double var17;
                    double var19;
                    if (this.field_9064_W.nextBoolean()) {
                        var17 = this.field_322_l - var8 * var13 * 0.8D + var10 * var15;
                        var19 = this.field_320_n - var10 * var13 * 0.8D - var8 * var15;
                        this.field_9093_l.func_514_a("splash", var17, this.field_321_m - 0.125D, var19, this.field_319_o, this.field_318_p, this.field_317_q);
                    } else {
                        var17 = this.field_322_l + var8 + var10 * var13 * 0.7D;
                        var19 = this.field_320_n + var10 - var8 * var13 * 0.7D;
                        this.field_9093_l.func_514_a("splash", var17, this.field_321_m - 0.125D, var19, this.field_319_o, this.field_318_p, this.field_317_q);
                    }
                }
            }

            if (this.field_9084_B && var6 > 0.15D) {
                if (!this.field_9093_l.field_792_x) {
                    this.func_118_j();

                    int var22;
                    for(var22 = 0; var22 < 3; ++var22) {
                        this.func_123_a(Block.field_531_y.field_573_bc, 1, 0.0F);
                    }

                    for(var22 = 0; var22 < 2; ++var22) {
                        this.func_123_a(Item.field_209_B.field_234_aS, 1, 0.0F);
                    }
                }
            } else {
                this.field_319_o *= 0.9900000095367432D;
                this.field_318_p *= 0.949999988079071D;
                this.field_317_q *= 0.9900000095367432D;
            }

            this.field_315_s = 0.0F;
            var8 = (double)this.field_316_r;
            var10 = this.field_9092_m - this.field_322_l;
            double var23 = this.field_9090_o - this.field_320_n;
            if (var10 * var10 + var23 * var23 > 0.001D) {
                var8 = (double)((float)(Math.atan2(var23, var10) * 180.0D / 3.141592653589793D));
            }

            double var14;
            for(var14 = var8 - (double)this.field_316_r; var14 >= 180.0D; var14 -= 360.0D) {
            }

            while(var14 < -180.0D) {
                var14 += 360.0D;
            }

            if (var14 > 20.0D) {
                var14 = 20.0D;
            }

            if (var14 < -20.0D) {
                var14 = -20.0D;
            }

            this.field_316_r = (float)((double)this.field_316_r + var14);
            this.func_6096_b(this.field_316_r, this.field_315_s);
            List var16 = this.field_9093_l.func_450_b(this, this.field_312_v.func_708_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            int var24;
            if (var16 != null && var16.size() > 0) {
                for(var24 = 0; var24 < var16.size(); ++var24) {
                    Entity var18 = (Entity)var16.get(var24);
                    if (var18 != this.field_328_f && var18.func_124_r() && var18 instanceof EntityBoat) {
                        var18.func_92_c(this);
                    }
                }
            }

            for(var24 = 0; var24 < 4; ++var24) {
                int var25 = MathHelper.func_584_b(this.field_322_l + ((double)(var24 % 2) - 0.5D) * 0.8D);
                int var26 = MathHelper.func_584_b(this.field_321_m);
                int var20 = MathHelper.func_584_b(this.field_320_n + ((double)(var24 / 2) - 0.5D) * 0.8D);
                if (this.field_9093_l.func_444_a(var25, var26, var20) == Block.field_625_aT.field_573_bc) {
                    this.field_9093_l.func_508_d(var25, var26, var20, 0);
                }
            }

            if (this.field_328_f != null && this.field_328_f.field_304_B) {
                this.field_328_f = null;
            }

        }
    }

    public void func_127_w() {
        if (this.field_328_f != null) {
            double var1 = Math.cos((double)this.field_316_r * 3.141592653589793D / 180.0D) * 0.4D;
            double var3 = Math.sin((double)this.field_316_r * 3.141592653589793D / 180.0D) * 0.4D;
            this.field_328_f.func_86_a(this.field_322_l + var1, this.field_321_m + this.func_130_h() + this.field_328_f.func_117_x(), this.field_320_n + var3);
        }
    }

    protected void func_97_a(NBTTagCompound var1) {
    }

    protected void func_99_b(NBTTagCompound var1) {
    }

    public boolean func_6092_a(EntityPlayer var1) {
        if (this.field_328_f != null && this.field_328_f instanceof EntityPlayer && this.field_328_f != var1) {
            return true;
        } else {
            if (!this.field_9093_l.field_792_x) {
                var1.func_6094_e(this);
            }

            return true;
        }
    }
}
