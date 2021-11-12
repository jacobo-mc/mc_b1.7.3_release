package net.minecraft.src;

import java.util.List;

public class EntityBoat extends Entity {
    public int field_807_a;
    public int field_806_b;
    public int field_808_c;
    private int field_9394_d;
    private double field_9393_e;
    private double field_9392_f;
    private double field_9391_g;
    private double field_9390_h;
    private double field_9389_i;
    private double field_9388_j;
    private double field_9387_k;
    private double field_9386_l;

    public EntityBoat(World var1) {
        super(var1);
        this.field_807_a = 0;
        this.field_806_b = 0;
        this.field_808_c = 1;
        this.field_618_ad = true;
        this.func_371_a(1.5F, 0.6F);
        this.field_9292_aO = this.field_643_aD / 2.0F;
    }

    protected boolean func_25021_m() {
        return false;
    }

    protected void func_21057_b() {
    }

    public AxisAlignedBB func_383_b_(Entity var1) {
        return var1.field_601_au;
    }

    public AxisAlignedBB func_372_f_() {
        return this.field_601_au;
    }

    public boolean func_385_d_() {
        return true;
    }

    public EntityBoat(World var1, double var2, double var4, double var6) {
        this(var1);
        this.func_347_a(var2, var4 + (double)this.field_9292_aO, var6);
        this.field_608_an = 0.0D;
        this.field_607_ao = 0.0D;
        this.field_606_ap = 0.0D;
        this.field_9285_at = var2;
        this.field_9284_au = var4;
        this.field_9283_av = var6;
    }

    public double func_402_h() {
        return (double)this.field_643_aD * 0.0D - 0.30000001192092896D;
    }

    public boolean func_396_a(Entity var1, int var2) {
        if (!this.field_615_ag.field_1026_y && !this.field_646_aA) {
            this.field_808_c = -this.field_808_c;
            this.field_806_b = 10;
            this.field_807_a += var2 * 10;
            this.func_9281_M();
            if (this.field_807_a > 40) {
                if (this.field_617_ae != null) {
                    this.field_617_ae.func_6377_h(this);
                }

                int var3;
                for(var3 = 0; var3 < 3; ++var3) {
                    this.func_394_a(Block.field_334_y.field_376_bc, 1, 0.0F);
                }

                for(var3 = 0; var3 < 2; ++var3) {
                    this.func_394_a(Item.field_266_B.field_291_aS, 1, 0.0F);
                }

                this.func_395_F();
            }

            return true;
        } else {
            return true;
        }
    }

    public void func_9280_g() {
        this.field_808_c = -this.field_808_c;
        this.field_806_b = 10;
        this.field_807_a += this.field_807_a * 10;
    }

    public boolean func_401_c_() {
        return !this.field_646_aA;
    }

    public void func_378_a(double var1, double var3, double var5, float var7, float var8, int var9) {
        this.field_9393_e = var1;
        this.field_9392_f = var3;
        this.field_9391_g = var5;
        this.field_9390_h = (double)var7;
        this.field_9389_i = (double)var8;
        this.field_9394_d = var9 + 4;
        this.field_608_an = this.field_9388_j;
        this.field_607_ao = this.field_9387_k;
        this.field_606_ap = this.field_9386_l;
    }

    public void func_6375_a(double var1, double var3, double var5) {
        this.field_9388_j = this.field_608_an = var1;
        this.field_9387_k = this.field_607_ao = var3;
        this.field_9386_l = this.field_606_ap = var5;
    }

    public void func_370_e_() {
        super.func_370_e_();
        if (this.field_806_b > 0) {
            --this.field_806_b;
        }

        if (this.field_807_a > 0) {
            --this.field_807_a;
        }

        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        byte var1 = 5;
        double var2 = 0.0D;

        for(int var4 = 0; var4 < var1; ++var4) {
            double var5 = this.field_601_au.field_1697_b + (this.field_601_au.field_1702_e - this.field_601_au.field_1697_b) * (double)(var4 + 0) / (double)var1 - 0.125D;
            double var7 = this.field_601_au.field_1697_b + (this.field_601_au.field_1702_e - this.field_601_au.field_1697_b) * (double)(var4 + 1) / (double)var1 - 0.125D;
            AxisAlignedBB var9 = AxisAlignedBB.func_1161_b(this.field_601_au.field_1698_a, var5, this.field_601_au.field_1704_c, this.field_601_au.field_1703_d, var7, this.field_601_au.field_1701_f);
            if (this.field_615_ag.func_707_b(var9, Material.field_1332_f)) {
                var2 += 1.0D / (double)var1;
            }
        }

        double var6;
        double var8;
        double var10;
        double var21;
        if (this.field_615_ag.field_1026_y) {
            if (this.field_9394_d > 0) {
                var21 = this.field_611_ak + (this.field_9393_e - this.field_611_ak) / (double)this.field_9394_d;
                var6 = this.field_610_al + (this.field_9392_f - this.field_610_al) / (double)this.field_9394_d;
                var8 = this.field_609_am + (this.field_9391_g - this.field_609_am) / (double)this.field_9394_d;

                for(var10 = this.field_9390_h - (double)this.field_605_aq; var10 < -180.0D; var10 += 360.0D) {
                }

                while(var10 >= 180.0D) {
                    var10 -= 360.0D;
                }

                this.field_605_aq = (float)((double)this.field_605_aq + var10 / (double)this.field_9394_d);
                this.field_604_ar = (float)((double)this.field_604_ar + (this.field_9389_i - (double)this.field_604_ar) / (double)this.field_9394_d);
                --this.field_9394_d;
                this.func_347_a(var21, var6, var8);
                this.func_376_c(this.field_605_aq, this.field_604_ar);
            } else {
                var21 = this.field_611_ak + this.field_608_an;
                var6 = this.field_610_al + this.field_607_ao;
                var8 = this.field_609_am + this.field_606_ap;
                this.func_347_a(var21, var6, var8);
                if (this.field_9298_aH) {
                    this.field_608_an *= 0.5D;
                    this.field_607_ao *= 0.5D;
                    this.field_606_ap *= 0.5D;
                }

                this.field_608_an *= 0.9900000095367432D;
                this.field_607_ao *= 0.949999988079071D;
                this.field_606_ap *= 0.9900000095367432D;
            }

        } else {
            if (var2 < 1.0D) {
                var21 = var2 * 2.0D - 1.0D;
                this.field_607_ao += 0.03999999910593033D * var21;
            } else {
                if (this.field_607_ao < 0.0D) {
                    this.field_607_ao /= 2.0D;
                }

                this.field_607_ao += 0.007000000216066837D;
            }

            if (this.field_617_ae != null) {
                this.field_608_an += this.field_617_ae.field_608_an * 0.2D;
                this.field_606_ap += this.field_617_ae.field_606_ap * 0.2D;
            }

            var21 = 0.4D;
            if (this.field_608_an < -var21) {
                this.field_608_an = -var21;
            }

            if (this.field_608_an > var21) {
                this.field_608_an = var21;
            }

            if (this.field_606_ap < -var21) {
                this.field_606_ap = -var21;
            }

            if (this.field_606_ap > var21) {
                this.field_606_ap = var21;
            }

            if (this.field_9298_aH) {
                this.field_608_an *= 0.5D;
                this.field_607_ao *= 0.5D;
                this.field_606_ap *= 0.5D;
            }

            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            var6 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
            if (var6 > 0.15D) {
                var8 = Math.cos((double)this.field_605_aq * 3.141592653589793D / 180.0D);
                var10 = Math.sin((double)this.field_605_aq * 3.141592653589793D / 180.0D);

                for(int var12 = 0; (double)var12 < 1.0D + var6 * 60.0D; ++var12) {
                    double var13 = (double)(this.field_9312_bd.nextFloat() * 2.0F - 1.0F);
                    double var15 = (double)(this.field_9312_bd.nextInt(2) * 2 - 1) * 0.7D;
                    double var17;
                    double var19;
                    if (this.field_9312_bd.nextBoolean()) {
                        var17 = this.field_611_ak - var8 * var13 * 0.8D + var10 * var15;
                        var19 = this.field_609_am - var10 * var13 * 0.8D - var8 * var15;
                        this.field_615_ag.func_694_a("splash", var17, this.field_610_al - 0.125D, var19, this.field_608_an, this.field_607_ao, this.field_606_ap);
                    } else {
                        var17 = this.field_611_ak + var8 + var10 * var13 * 0.7D;
                        var19 = this.field_609_am + var10 - var8 * var13 * 0.7D;
                        this.field_615_ag.func_694_a("splash", var17, this.field_610_al - 0.125D, var19, this.field_608_an, this.field_607_ao, this.field_606_ap);
                    }
                }
            }

            if (this.field_9297_aI && var6 > 0.15D) {
                if (!this.field_615_ag.field_1026_y) {
                    this.func_395_F();

                    int var22;
                    for(var22 = 0; var22 < 3; ++var22) {
                        this.func_394_a(Block.field_334_y.field_376_bc, 1, 0.0F);
                    }

                    for(var22 = 0; var22 < 2; ++var22) {
                        this.func_394_a(Item.field_266_B.field_291_aS, 1, 0.0F);
                    }
                }
            } else {
                this.field_608_an *= 0.9900000095367432D;
                this.field_607_ao *= 0.949999988079071D;
                this.field_606_ap *= 0.9900000095367432D;
            }

            this.field_604_ar = 0.0F;
            var8 = (double)this.field_605_aq;
            var10 = this.field_9285_at - this.field_611_ak;
            double var23 = this.field_9283_av - this.field_609_am;
            if (var10 * var10 + var23 * var23 > 0.001D) {
                var8 = (double)((float)(Math.atan2(var23, var10) * 180.0D / 3.141592653589793D));
            }

            double var14;
            for(var14 = var8 - (double)this.field_605_aq; var14 >= 180.0D; var14 -= 360.0D) {
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

            this.field_605_aq = (float)((double)this.field_605_aq + var14);
            this.func_376_c(this.field_605_aq, this.field_604_ar);
            List var16 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            int var24;
            if (var16 != null && var16.size() > 0) {
                for(var24 = 0; var24 < var16.size(); ++var24) {
                    Entity var18 = (Entity)var16.get(var24);
                    if (var18 != this.field_617_ae && var18.func_385_d_() && var18 instanceof EntityBoat) {
                        var18.func_380_f(this);
                    }
                }
            }

            for(var24 = 0; var24 < 4; ++var24) {
                int var25 = MathHelper.func_1108_b(this.field_611_ak + ((double)(var24 % 2) - 0.5D) * 0.8D);
                int var26 = MathHelper.func_1108_b(this.field_610_al);
                int var20 = MathHelper.func_1108_b(this.field_609_am + ((double)(var24 / 2) - 0.5D) * 0.8D);
                if (this.field_615_ag.func_600_a(var25, var26, var20) == Block.field_428_aT.field_376_bc) {
                    this.field_615_ag.func_690_d(var25, var26, var20, 0);
                }
            }

            if (this.field_617_ae != null && this.field_617_ae.field_646_aA) {
                this.field_617_ae = null;
            }

        }
    }

    public void func_366_i_() {
        if (this.field_617_ae != null) {
            double var1 = Math.cos((double)this.field_605_aq * 3.141592653589793D / 180.0D) * 0.4D;
            double var3 = Math.sin((double)this.field_605_aq * 3.141592653589793D / 180.0D) * 0.4D;
            this.field_617_ae.func_347_a(this.field_611_ak + var1, this.field_610_al + this.func_402_h() + this.field_617_ae.func_388_v(), this.field_609_am + var3);
        }
    }

    protected void func_352_a(NBTTagCompound var1) {
    }

    protected void func_357_b(NBTTagCompound var1) {
    }

    public float func_392_h_() {
        return 0.0F;
    }

    public boolean func_353_a(EntityPlayer var1) {
        if (this.field_617_ae != null && this.field_617_ae instanceof EntityPlayer && this.field_617_ae != var1) {
            return true;
        } else {
            if (!this.field_615_ag.field_1026_y) {
                var1.func_6377_h(this);
            }

            return true;
        }
    }
}
