package net.minecraft.src;

import java.util.List;

public class EntityMinecart extends Entity implements IInventory {
    private ItemStack[] field_857_h;
    public int field_20910_a;
    public int field_20911_b;
    public int field_20912_c;
    private boolean field_856_i;
    public int field_20913_d;
    public int field_9418_e;
    public double field_9417_f;
    public double field_9416_g;
    private static final int[][][] field_855_j = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
    private int field_9415_k;
    private double field_9414_l;
    private double field_9413_m;
    private double field_9412_n;
    private double field_9411_o;
    private double field_9410_p;
    private double field_9409_q;
    private double field_9408_r;
    private double field_9407_s;

    public EntityMinecart(World var1) {
        super(var1);
        this.field_857_h = new ItemStack[36];
        this.field_20910_a = 0;
        this.field_20911_b = 0;
        this.field_20912_c = 1;
        this.field_856_i = false;
        this.field_618_ad = true;
        this.func_371_a(0.98F, 0.7F);
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
        return null;
    }

    public boolean func_385_d_() {
        return true;
    }

    public EntityMinecart(World var1, double var2, double var4, double var6, int var8) {
        this(var1);
        this.func_347_a(var2, var4 + (double)this.field_9292_aO, var6);
        this.field_608_an = 0.0D;
        this.field_607_ao = 0.0D;
        this.field_606_ap = 0.0D;
        this.field_9285_at = var2;
        this.field_9284_au = var4;
        this.field_9283_av = var6;
        this.field_20913_d = var8;
    }

    public double func_402_h() {
        return (double)this.field_643_aD * 0.0D - 0.30000001192092896D;
    }

    public boolean func_396_a(Entity var1, int var2) {
        if (!this.field_615_ag.field_1026_y && !this.field_646_aA) {
            this.field_20912_c = -this.field_20912_c;
            this.field_20911_b = 10;
            this.func_9281_M();
            this.field_20910_a += var2 * 10;
            if (this.field_20910_a > 40) {
                if (this.field_617_ae != null) {
                    this.field_617_ae.func_6377_h(this);
                }

                this.func_395_F();
                this.func_394_a(Item.field_256_ax.field_291_aS, 1, 0.0F);
                if (this.field_20913_d == 1) {
                    EntityMinecart var3 = this;

                    for(int var4 = 0; var4 < var3.func_469_c(); ++var4) {
                        ItemStack var5 = var3.func_468_c(var4);
                        if (var5 != null) {
                            float var6 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
                            float var7 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
                            float var8 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;

                            while(var5.field_1615_a > 0) {
                                int var9 = this.field_9312_bd.nextInt(21) + 10;
                                if (var9 > var5.field_1615_a) {
                                    var9 = var5.field_1615_a;
                                }

                                var5.field_1615_a -= var9;
                                EntityItem var10 = new EntityItem(this.field_615_ag, this.field_611_ak + (double)var6, this.field_610_al + (double)var7, this.field_609_am + (double)var8, new ItemStack(var5.field_1617_c, var9, var5.func_21181_i()));
                                float var11 = 0.05F;
                                var10.field_608_an = (double)((float)this.field_9312_bd.nextGaussian() * var11);
                                var10.field_607_ao = (double)((float)this.field_9312_bd.nextGaussian() * var11 + 0.2F);
                                var10.field_606_ap = (double)((float)this.field_9312_bd.nextGaussian() * var11);
                                this.field_615_ag.func_674_a(var10);
                            }
                        }
                    }

                    this.func_394_a(Block.field_396_av.field_376_bc, 1, 0.0F);
                } else if (this.field_20913_d == 2) {
                    this.func_394_a(Block.field_445_aC.field_376_bc, 1, 0.0F);
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public void func_9280_g() {
        System.out.println("Animating hurt");
        this.field_20912_c = -this.field_20912_c;
        this.field_20911_b = 10;
        this.field_20910_a += this.field_20910_a * 10;
    }

    public boolean func_401_c_() {
        return !this.field_646_aA;
    }

    public void func_395_F() {
        for(int var1 = 0; var1 < this.func_469_c(); ++var1) {
            ItemStack var2 = this.func_468_c(var1);
            if (var2 != null) {
                float var3 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
                float var4 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
                float var5 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;

                while(var2.field_1615_a > 0) {
                    int var6 = this.field_9312_bd.nextInt(21) + 10;
                    if (var6 > var2.field_1615_a) {
                        var6 = var2.field_1615_a;
                    }

                    var2.field_1615_a -= var6;
                    EntityItem var7 = new EntityItem(this.field_615_ag, this.field_611_ak + (double)var3, this.field_610_al + (double)var4, this.field_609_am + (double)var5, new ItemStack(var2.field_1617_c, var6, var2.func_21181_i()));
                    float var8 = 0.05F;
                    var7.field_608_an = (double)((float)this.field_9312_bd.nextGaussian() * var8);
                    var7.field_607_ao = (double)((float)this.field_9312_bd.nextGaussian() * var8 + 0.2F);
                    var7.field_606_ap = (double)((float)this.field_9312_bd.nextGaussian() * var8);
                    this.field_615_ag.func_674_a(var7);
                }
            }
        }

        super.func_395_F();
    }

    public void func_370_e_() {
        if (this.field_20911_b > 0) {
            --this.field_20911_b;
        }

        if (this.field_20910_a > 0) {
            --this.field_20910_a;
        }

        double var7;
        if (this.field_615_ag.field_1026_y && this.field_9415_k > 0) {
            if (this.field_9415_k > 0) {
                double var46 = this.field_611_ak + (this.field_9414_l - this.field_611_ak) / (double)this.field_9415_k;
                double var47 = this.field_610_al + (this.field_9413_m - this.field_610_al) / (double)this.field_9415_k;
                double var5 = this.field_609_am + (this.field_9412_n - this.field_609_am) / (double)this.field_9415_k;

                for(var7 = this.field_9411_o - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
                }

                while(var7 >= 180.0D) {
                    var7 -= 360.0D;
                }

                this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_9415_k);
                this.field_604_ar = (float)((double)this.field_604_ar + (this.field_9410_p - (double)this.field_604_ar) / (double)this.field_9415_k);
                --this.field_9415_k;
                this.func_347_a(var46, var47, var5);
                this.func_376_c(this.field_605_aq, this.field_604_ar);
            } else {
                this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
                this.func_376_c(this.field_605_aq, this.field_604_ar);
            }

        } else {
            this.field_9285_at = this.field_611_ak;
            this.field_9284_au = this.field_610_al;
            this.field_9283_av = this.field_609_am;
            this.field_607_ao -= 0.03999999910593033D;
            int var1 = MathHelper.func_1108_b(this.field_611_ak);
            int var2 = MathHelper.func_1108_b(this.field_610_al);
            int var3 = MathHelper.func_1108_b(this.field_609_am);
            if (BlockRail.func_27040_h(this.field_615_ag, var1, var2 - 1, var3)) {
                --var2;
            }

            double var4 = 0.4D;
            boolean var6 = false;
            var7 = 0.0078125D;
            int var9 = this.field_615_ag.func_600_a(var1, var2, var3);
            if (BlockRail.func_27041_c(var9)) {
                Vec3D var10 = this.func_514_g(this.field_611_ak, this.field_610_al, this.field_609_am);
                int var11 = this.field_615_ag.func_602_e(var1, var2, var3);
                this.field_610_al = (double)var2;
                boolean var12 = false;
                boolean var13 = false;
                if (var9 == Block.field_9261_T.field_376_bc) {
                    var12 = (var11 & 8) != 0;
                    var13 = !var12;
                }

                if (((BlockRail)Block.field_345_n[var9]).func_27042_h()) {
                    var11 &= 7;
                }

                if (var11 >= 2 && var11 <= 5) {
                    this.field_610_al = (double)(var2 + 1);
                }

                if (var11 == 2) {
                    this.field_608_an -= var7;
                }

                if (var11 == 3) {
                    this.field_608_an += var7;
                }

                if (var11 == 4) {
                    this.field_606_ap += var7;
                }

                if (var11 == 5) {
                    this.field_606_ap -= var7;
                }

                int[][] var14 = field_855_j[var11];
                double var15 = (double)(var14[1][0] - var14[0][0]);
                double var17 = (double)(var14[1][2] - var14[0][2]);
                double var19 = Math.sqrt(var15 * var15 + var17 * var17);
                double var21 = this.field_608_an * var15 + this.field_606_ap * var17;
                if (var21 < 0.0D) {
                    var15 = -var15;
                    var17 = -var17;
                }

                double var23 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
                this.field_608_an = var23 * var15 / var19;
                this.field_606_ap = var23 * var17 / var19;
                double var25;
                if (var13) {
                    var25 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
                    if (var25 < 0.03D) {
                        this.field_608_an *= 0.0D;
                        this.field_607_ao *= 0.0D;
                        this.field_606_ap *= 0.0D;
                    } else {
                        this.field_608_an *= 0.5D;
                        this.field_607_ao *= 0.0D;
                        this.field_606_ap *= 0.5D;
                    }
                }

                var25 = 0.0D;
                double var27 = (double)var1 + 0.5D + (double)var14[0][0] * 0.5D;
                double var29 = (double)var3 + 0.5D + (double)var14[0][2] * 0.5D;
                double var31 = (double)var1 + 0.5D + (double)var14[1][0] * 0.5D;
                double var33 = (double)var3 + 0.5D + (double)var14[1][2] * 0.5D;
                var15 = var31 - var27;
                var17 = var33 - var29;
                double var35;
                double var37;
                double var39;
                if (var15 == 0.0D) {
                    this.field_611_ak = (double)var1 + 0.5D;
                    var25 = this.field_609_am - (double)var3;
                } else if (var17 == 0.0D) {
                    this.field_609_am = (double)var3 + 0.5D;
                    var25 = this.field_611_ak - (double)var1;
                } else {
                    var35 = this.field_611_ak - var27;
                    var37 = this.field_609_am - var29;
                    var39 = (var35 * var15 + var37 * var17) * 2.0D;
                    var25 = var39;
                }

                this.field_611_ak = var27 + var15 * var25;
                this.field_609_am = var29 + var17 * var25;
                this.func_347_a(this.field_611_ak, this.field_610_al + (double)this.field_9292_aO, this.field_609_am);
                var35 = this.field_608_an;
                var37 = this.field_606_ap;
                if (this.field_617_ae != null) {
                    var35 *= 0.75D;
                    var37 *= 0.75D;
                }

                if (var35 < -var4) {
                    var35 = -var4;
                }

                if (var35 > var4) {
                    var35 = var4;
                }

                if (var37 < -var4) {
                    var37 = -var4;
                }

                if (var37 > var4) {
                    var37 = var4;
                }

                this.func_349_c(var35, 0.0D, var37);
                if (var14[0][1] != 0 && MathHelper.func_1108_b(this.field_611_ak) - var1 == var14[0][0] && MathHelper.func_1108_b(this.field_609_am) - var3 == var14[0][2]) {
                    this.func_347_a(this.field_611_ak, this.field_610_al + (double)var14[0][1], this.field_609_am);
                } else if (var14[1][1] != 0 && MathHelper.func_1108_b(this.field_611_ak) - var1 == var14[1][0] && MathHelper.func_1108_b(this.field_609_am) - var3 == var14[1][2]) {
                    this.func_347_a(this.field_611_ak, this.field_610_al + (double)var14[1][1], this.field_609_am);
                }

                if (this.field_617_ae != null) {
                    this.field_608_an *= 0.996999979019165D;
                    this.field_607_ao *= 0.0D;
                    this.field_606_ap *= 0.996999979019165D;
                } else {
                    if (this.field_20913_d == 2) {
                        var39 = (double)MathHelper.func_1109_a(this.field_9417_f * this.field_9417_f + this.field_9416_g * this.field_9416_g);
                        if (var39 > 0.01D) {
                            var6 = true;
                            this.field_9417_f /= var39;
                            this.field_9416_g /= var39;
                            double var41 = 0.04D;
                            this.field_608_an *= 0.800000011920929D;
                            this.field_607_ao *= 0.0D;
                            this.field_606_ap *= 0.800000011920929D;
                            this.field_608_an += this.field_9417_f * var41;
                            this.field_606_ap += this.field_9416_g * var41;
                        } else {
                            this.field_608_an *= 0.8999999761581421D;
                            this.field_607_ao *= 0.0D;
                            this.field_606_ap *= 0.8999999761581421D;
                        }
                    }

                    this.field_608_an *= 0.9599999785423279D;
                    this.field_607_ao *= 0.0D;
                    this.field_606_ap *= 0.9599999785423279D;
                }

                Vec3D var52 = this.func_514_g(this.field_611_ak, this.field_610_al, this.field_609_am);
                if (var52 != null && var10 != null) {
                    double var40 = (var10.field_1775_b - var52.field_1775_b) * 0.05D;
                    var23 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
                    if (var23 > 0.0D) {
                        this.field_608_an = this.field_608_an / var23 * (var23 + var40);
                        this.field_606_ap = this.field_606_ap / var23 * (var23 + var40);
                    }

                    this.func_347_a(this.field_611_ak, var52.field_1775_b, this.field_609_am);
                }

                int var53 = MathHelper.func_1108_b(this.field_611_ak);
                int var54 = MathHelper.func_1108_b(this.field_609_am);
                if (var53 != var1 || var54 != var3) {
                    var23 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
                    this.field_608_an = var23 * (double)(var53 - var1);
                    this.field_606_ap = var23 * (double)(var54 - var3);
                }

                double var42;
                if (this.field_20913_d == 2) {
                    var42 = (double)MathHelper.func_1109_a(this.field_9417_f * this.field_9417_f + this.field_9416_g * this.field_9416_g);
                    if (var42 > 0.01D && this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap > 0.001D) {
                        this.field_9417_f /= var42;
                        this.field_9416_g /= var42;
                        if (this.field_9417_f * this.field_608_an + this.field_9416_g * this.field_606_ap < 0.0D) {
                            this.field_9417_f = 0.0D;
                            this.field_9416_g = 0.0D;
                        } else {
                            this.field_9417_f = this.field_608_an;
                            this.field_9416_g = this.field_606_ap;
                        }
                    }
                }

                if (var12) {
                    var42 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
                    if (var42 > 0.01D) {
                        double var44 = 0.06D;
                        this.field_608_an += this.field_608_an / var42 * var44;
                        this.field_606_ap += this.field_606_ap / var42 * var44;
                    } else if (var11 == 1) {
                        if (this.field_615_ag.func_28100_h(var1 - 1, var2, var3)) {
                            this.field_608_an = 0.02D;
                        } else if (this.field_615_ag.func_28100_h(var1 + 1, var2, var3)) {
                            this.field_608_an = -0.02D;
                        }
                    } else if (var11 == 0) {
                        if (this.field_615_ag.func_28100_h(var1, var2, var3 - 1)) {
                            this.field_606_ap = 0.02D;
                        } else if (this.field_615_ag.func_28100_h(var1, var2, var3 + 1)) {
                            this.field_606_ap = -0.02D;
                        }
                    }
                }
            } else {
                if (this.field_608_an < -var4) {
                    this.field_608_an = -var4;
                }

                if (this.field_608_an > var4) {
                    this.field_608_an = var4;
                }

                if (this.field_606_ap < -var4) {
                    this.field_606_ap = -var4;
                }

                if (this.field_606_ap > var4) {
                    this.field_606_ap = var4;
                }

                if (this.field_9298_aH) {
                    this.field_608_an *= 0.5D;
                    this.field_607_ao *= 0.5D;
                    this.field_606_ap *= 0.5D;
                }

                this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
                if (!this.field_9298_aH) {
                    this.field_608_an *= 0.949999988079071D;
                    this.field_607_ao *= 0.949999988079071D;
                    this.field_606_ap *= 0.949999988079071D;
                }
            }

            this.field_604_ar = 0.0F;
            double var48 = this.field_9285_at - this.field_611_ak;
            double var49 = this.field_9283_av - this.field_609_am;
            if (var48 * var48 + var49 * var49 > 0.001D) {
                this.field_605_aq = (float)(Math.atan2(var49, var48) * 180.0D / 3.141592653589793D);
                if (this.field_856_i) {
                    this.field_605_aq += 180.0F;
                }
            }

            double var50;
            for(var50 = (double)(this.field_605_aq - this.field_603_as); var50 >= 180.0D; var50 -= 360.0D) {
            }

            while(var50 < -180.0D) {
                var50 += 360.0D;
            }

            if (var50 < -170.0D || var50 >= 170.0D) {
                this.field_605_aq += 180.0F;
                this.field_856_i = !this.field_856_i;
            }

            this.func_376_c(this.field_605_aq, this.field_604_ar);
            List var16 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            if (var16 != null && var16.size() > 0) {
                for(int var51 = 0; var51 < var16.size(); ++var51) {
                    Entity var18 = (Entity)var16.get(var51);
                    if (var18 != this.field_617_ae && var18.func_385_d_() && var18 instanceof EntityMinecart) {
                        var18.func_380_f(this);
                    }
                }
            }

            if (this.field_617_ae != null && this.field_617_ae.field_646_aA) {
                this.field_617_ae = null;
            }

            if (var6 && this.field_9312_bd.nextInt(4) == 0) {
                --this.field_9418_e;
                if (this.field_9418_e < 0) {
                    this.field_9417_f = this.field_9416_g = 0.0D;
                }

                this.field_615_ag.func_694_a("largesmoke", this.field_611_ak, this.field_610_al + 0.8D, this.field_609_am, 0.0D, 0.0D, 0.0D);
            }

        }
    }

    public Vec3D func_515_a(double var1, double var3, double var5, double var7) {
        int var9 = MathHelper.func_1108_b(var1);
        int var10 = MathHelper.func_1108_b(var3);
        int var11 = MathHelper.func_1108_b(var5);
        if (BlockRail.func_27040_h(this.field_615_ag, var9, var10 - 1, var11)) {
            --var10;
        }

        int var12 = this.field_615_ag.func_600_a(var9, var10, var11);
        if (!BlockRail.func_27041_c(var12)) {
            return null;
        } else {
            int var13 = this.field_615_ag.func_602_e(var9, var10, var11);
            if (((BlockRail)Block.field_345_n[var12]).func_27042_h()) {
                var13 &= 7;
            }

            var3 = (double)var10;
            if (var13 >= 2 && var13 <= 5) {
                var3 = (double)(var10 + 1);
            }

            int[][] var14 = field_855_j[var13];
            double var15 = (double)(var14[1][0] - var14[0][0]);
            double var17 = (double)(var14[1][2] - var14[0][2]);
            double var19 = Math.sqrt(var15 * var15 + var17 * var17);
            var15 /= var19;
            var17 /= var19;
            var1 += var15 * var7;
            var5 += var17 * var7;
            if (var14[0][1] != 0 && MathHelper.func_1108_b(var1) - var9 == var14[0][0] && MathHelper.func_1108_b(var5) - var11 == var14[0][2]) {
                var3 += (double)var14[0][1];
            } else if (var14[1][1] != 0 && MathHelper.func_1108_b(var1) - var9 == var14[1][0] && MathHelper.func_1108_b(var5) - var11 == var14[1][2]) {
                var3 += (double)var14[1][1];
            }

            return this.func_514_g(var1, var3, var5);
        }
    }

    public Vec3D func_514_g(double var1, double var3, double var5) {
        int var7 = MathHelper.func_1108_b(var1);
        int var8 = MathHelper.func_1108_b(var3);
        int var9 = MathHelper.func_1108_b(var5);
        if (BlockRail.func_27040_h(this.field_615_ag, var7, var8 - 1, var9)) {
            --var8;
        }

        int var10 = this.field_615_ag.func_600_a(var7, var8, var9);
        if (BlockRail.func_27041_c(var10)) {
            int var11 = this.field_615_ag.func_602_e(var7, var8, var9);
            var3 = (double)var8;
            if (((BlockRail)Block.field_345_n[var10]).func_27042_h()) {
                var11 &= 7;
            }

            if (var11 >= 2 && var11 <= 5) {
                var3 = (double)(var8 + 1);
            }

            int[][] var12 = field_855_j[var11];
            double var13 = 0.0D;
            double var15 = (double)var7 + 0.5D + (double)var12[0][0] * 0.5D;
            double var17 = (double)var8 + 0.5D + (double)var12[0][1] * 0.5D;
            double var19 = (double)var9 + 0.5D + (double)var12[0][2] * 0.5D;
            double var21 = (double)var7 + 0.5D + (double)var12[1][0] * 0.5D;
            double var23 = (double)var8 + 0.5D + (double)var12[1][1] * 0.5D;
            double var25 = (double)var9 + 0.5D + (double)var12[1][2] * 0.5D;
            double var27 = var21 - var15;
            double var29 = (var23 - var17) * 2.0D;
            double var31 = var25 - var19;
            if (var27 == 0.0D) {
                var1 = (double)var7 + 0.5D;
                var13 = var5 - (double)var9;
            } else if (var31 == 0.0D) {
                var5 = (double)var9 + 0.5D;
                var13 = var1 - (double)var7;
            } else {
                double var33 = var1 - var15;
                double var35 = var5 - var19;
                double var37 = (var33 * var27 + var35 * var31) * 2.0D;
                var13 = var37;
            }

            var1 = var15 + var27 * var13;
            var3 = var17 + var29 * var13;
            var5 = var19 + var31 * var13;
            if (var29 < 0.0D) {
                ++var3;
            }

            if (var29 > 0.0D) {
                var3 += 0.5D;
            }

            return Vec3D.func_1248_b(var1, var3, var5);
        } else {
            return null;
        }
    }

    protected void func_352_a(NBTTagCompound var1) {
        var1.func_758_a("Type", this.field_20913_d);
        if (this.field_20913_d == 2) {
            var1.func_765_a("PushX", this.field_9417_f);
            var1.func_765_a("PushZ", this.field_9416_g);
            var1.func_749_a("Fuel", (short)this.field_9418_e);
        } else if (this.field_20913_d == 1) {
            NBTTagList var2 = new NBTTagList();

            for(int var3 = 0; var3 < this.field_857_h.length; ++var3) {
                if (this.field_857_h[var3] != null) {
                    NBTTagCompound var4 = new NBTTagCompound();
                    var4.func_761_a("Slot", (byte)var3);
                    this.field_857_h[var3].func_1086_a(var4);
                    var2.func_742_a(var4);
                }
            }

            var1.func_762_a("Items", var2);
        }

    }

    protected void func_357_b(NBTTagCompound var1) {
        this.field_20913_d = var1.func_756_e("Type");
        if (this.field_20913_d == 2) {
            this.field_9417_f = var1.func_757_h("PushX");
            this.field_9416_g = var1.func_757_h("PushZ");
            this.field_9418_e = var1.func_745_d("Fuel");
        } else if (this.field_20913_d == 1) {
            NBTTagList var2 = var1.func_753_l("Items");
            this.field_857_h = new ItemStack[this.func_469_c()];

            for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
                NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
                int var5 = var4.func_746_c("Slot") & 255;
                if (var5 >= 0 && var5 < this.field_857_h.length) {
                    this.field_857_h[var5] = new ItemStack(var4);
                }
            }
        }

    }

    public float func_392_h_() {
        return 0.0F;
    }

    public void func_380_f(Entity var1) {
        if (!this.field_615_ag.field_1026_y) {
            if (var1 != this.field_617_ae) {
                if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.field_20913_d == 0 && this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap > 0.01D && this.field_617_ae == null && var1.field_616_af == null) {
                    var1.func_6377_h(this);
                }

                double var2 = var1.field_611_ak - this.field_611_ak;
                double var4 = var1.field_609_am - this.field_609_am;
                double var6 = var2 * var2 + var4 * var4;
                if (var6 >= 9.999999747378752E-5D) {
                    var6 = (double)MathHelper.func_1109_a(var6);
                    var2 /= var6;
                    var4 /= var6;
                    double var8 = 1.0D / var6;
                    if (var8 > 1.0D) {
                        var8 = 1.0D;
                    }

                    var2 *= var8;
                    var4 *= var8;
                    var2 *= 0.10000000149011612D;
                    var4 *= 0.10000000149011612D;
                    var2 *= (double)(1.0F - this.field_632_aO);
                    var4 *= (double)(1.0F - this.field_632_aO);
                    var2 *= 0.5D;
                    var4 *= 0.5D;
                    if (var1 instanceof EntityMinecart) {
                        double var10 = var1.field_611_ak - this.field_611_ak;
                        double var12 = var1.field_609_am - this.field_609_am;
                        double var14 = var10 * var1.field_606_ap + var12 * var1.field_9285_at;
                        var14 *= var14;
                        if (var14 > 5.0D) {
                            return;
                        }

                        double var16 = var1.field_608_an + this.field_608_an;
                        double var18 = var1.field_606_ap + this.field_606_ap;
                        if (((EntityMinecart)var1).field_20913_d == 2 && this.field_20913_d != 2) {
                            this.field_608_an *= 0.20000000298023224D;
                            this.field_606_ap *= 0.20000000298023224D;
                            this.func_348_f(var1.field_608_an - var2, 0.0D, var1.field_606_ap - var4);
                            var1.field_608_an *= 0.699999988079071D;
                            var1.field_606_ap *= 0.699999988079071D;
                        } else if (((EntityMinecart)var1).field_20913_d != 2 && this.field_20913_d == 2) {
                            var1.field_608_an *= 0.20000000298023224D;
                            var1.field_606_ap *= 0.20000000298023224D;
                            var1.func_348_f(this.field_608_an + var2, 0.0D, this.field_606_ap + var4);
                            this.field_608_an *= 0.699999988079071D;
                            this.field_606_ap *= 0.699999988079071D;
                        } else {
                            var16 /= 2.0D;
                            var18 /= 2.0D;
                            this.field_608_an *= 0.20000000298023224D;
                            this.field_606_ap *= 0.20000000298023224D;
                            this.func_348_f(var16 - var2, 0.0D, var18 - var4);
                            var1.field_608_an *= 0.20000000298023224D;
                            var1.field_606_ap *= 0.20000000298023224D;
                            var1.func_348_f(var16 + var2, 0.0D, var18 + var4);
                        }
                    } else {
                        this.func_348_f(-var2, 0.0D, -var4);
                        var1.func_348_f(var2 / 4.0D, 0.0D, var4 / 4.0D);
                    }
                }

            }
        }
    }

    public int func_469_c() {
        return 27;
    }

    public ItemStack func_468_c(int var1) {
        return this.field_857_h[var1];
    }

    public ItemStack func_473_a(int var1, int var2) {
        if (this.field_857_h[var1] != null) {
            ItemStack var3;
            if (this.field_857_h[var1].field_1615_a <= var2) {
                var3 = this.field_857_h[var1];
                this.field_857_h[var1] = null;
                return var3;
            } else {
                var3 = this.field_857_h[var1].func_1085_a(var2);
                if (this.field_857_h[var1].field_1615_a == 0) {
                    this.field_857_h[var1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_472_a(int var1, ItemStack var2) {
        this.field_857_h[var1] = var2;
        if (var2 != null && var2.field_1615_a > this.func_470_e()) {
            var2.field_1615_a = this.func_470_e();
        }

    }

    public String func_471_d() {
        return "Minecart";
    }

    public int func_470_e() {
        return 64;
    }

    public void func_474_j_() {
    }

    public boolean func_353_a(EntityPlayer var1) {
        if (this.field_20913_d == 0) {
            if (this.field_617_ae != null && this.field_617_ae instanceof EntityPlayer && this.field_617_ae != var1) {
                return true;
            }

            if (!this.field_615_ag.field_1026_y) {
                var1.func_6377_h(this);
            }
        } else if (this.field_20913_d == 1) {
            if (!this.field_615_ag.field_1026_y) {
                var1.func_452_a(this);
            }
        } else if (this.field_20913_d == 2) {
            ItemStack var2 = var1.field_778_b.func_494_a();
            if (var2 != null && var2.field_1617_c == Item.field_225_k.field_291_aS) {
                if (--var2.field_1615_a == 0) {
                    var1.field_778_b.func_472_a(var1.field_778_b.field_847_d, (ItemStack)null);
                }

                this.field_9418_e += 1200;
            }

            this.field_9417_f = this.field_611_ak - var1.field_611_ak;
            this.field_9416_g = this.field_609_am - var1.field_609_am;
        }

        return true;
    }

    public void func_378_a(double var1, double var3, double var5, float var7, float var8, int var9) {
        this.field_9414_l = var1;
        this.field_9413_m = var3;
        this.field_9412_n = var5;
        this.field_9411_o = (double)var7;
        this.field_9410_p = (double)var8;
        this.field_9415_k = var9 + 2;
        this.field_608_an = this.field_9409_q;
        this.field_607_ao = this.field_9408_r;
        this.field_606_ap = this.field_9407_s;
    }

    public void func_6375_a(double var1, double var3, double var5) {
        this.field_9409_q = this.field_608_an = var1;
        this.field_9408_r = this.field_607_ao = var3;
        this.field_9407_s = this.field_606_ap = var5;
    }

    public boolean func_20070_a_(EntityPlayer var1) {
        if (this.field_646_aA) {
            return false;
        } else {
            return var1.func_387_e(this) <= 64.0D;
        }
    }
}
