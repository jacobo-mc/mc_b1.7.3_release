package net.minecraft.src;

import java.util.List;

public class EntityMinecart extends Entity implements IInventory {
    private ItemStack[] field_470_ai;
    public int field_9168_a;
    public int field_9167_b;
    public int field_477_ad;
    private boolean field_469_aj;
    public int field_476_ae;
    public int field_9165_e;
    public double field_9164_f;
    public double field_9166_aj;
    private static final int[][][] field_468_ak = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
    private int field_9163_an;
    private double field_9162_ao;
    private double field_9161_ap;
    private double field_9160_aq;
    private double field_9159_ar;
    private double field_9158_as;

    public EntityMinecart(World var1) {
        super(var1);
        this.field_470_ai = new ItemStack[36];
        this.field_9168_a = 0;
        this.field_9167_b = 0;
        this.field_477_ad = 1;
        this.field_469_aj = false;
        this.field_329_e = true;
        this.func_113_a(0.98F, 0.7F);
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
        return null;
    }

    public boolean func_124_r() {
        return true;
    }

    public EntityMinecart(World var1, double var2, double var4, double var6, int var8) {
        this(var1);
        this.func_86_a(var2, var4 + (double)this.field_9076_H, var6);
        this.field_319_o = 0.0D;
        this.field_318_p = 0.0D;
        this.field_317_q = 0.0D;
        this.field_9092_m = var2;
        this.field_9091_n = var4;
        this.field_9090_o = var6;
        this.field_476_ae = var8;
    }

    public double func_130_h() {
        return (double)this.field_298_E * 0.0D - 0.30000001192092896D;
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (!this.field_9093_l.field_792_x && !this.field_304_B) {
            this.field_477_ad = -this.field_477_ad;
            this.field_9167_b = 10;
            this.func_9060_u();
            this.field_9168_a += var2 * 10;
            if (this.field_9168_a > 40) {
                if (this.field_328_f != null) {
                    this.field_328_f.func_6094_e(this);
                }

                this.func_118_j();
                this.func_123_a(Item.field_199_ax.field_234_aS, 1, 0.0F);
                if (this.field_476_ae == 1) {
                    EntityMinecart var3 = this;

                    for(int var4 = 0; var4 < var3.func_83_a(); ++var4) {
                        ItemStack var5 = var3.func_82_a(var4);
                        if (var5 != null) {
                            float var6 = this.field_9064_W.nextFloat() * 0.8F + 0.1F;
                            float var7 = this.field_9064_W.nextFloat() * 0.8F + 0.1F;
                            float var8 = this.field_9064_W.nextFloat() * 0.8F + 0.1F;

                            while(var5.field_853_a > 0) {
                                int var9 = this.field_9064_W.nextInt(21) + 10;
                                if (var9 > var5.field_853_a) {
                                    var9 = var5.field_853_a;
                                }

                                var5.field_853_a -= var9;
                                EntityItem var10 = new EntityItem(this.field_9093_l, this.field_322_l + (double)var6, this.field_321_m + (double)var7, this.field_320_n + (double)var8, new ItemStack(var5.field_855_c, var9, var5.func_21125_h()));
                                float var11 = 0.05F;
                                var10.field_319_o = (double)((float)this.field_9064_W.nextGaussian() * var11);
                                var10.field_318_p = (double)((float)this.field_9064_W.nextGaussian() * var11 + 0.2F);
                                var10.field_317_q = (double)((float)this.field_9064_W.nextGaussian() * var11);
                                this.field_9093_l.func_526_a(var10);
                            }
                        }
                    }

                    this.func_123_a(Block.field_593_av.field_573_bc, 1, 0.0F);
                } else if (this.field_476_ae == 2) {
                    this.func_123_a(Block.field_642_aC.field_573_bc, 1, 0.0F);
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public boolean func_129_c_() {
        return !this.field_304_B;
    }

    public void func_118_j() {
        for(int var1 = 0; var1 < this.func_83_a(); ++var1) {
            ItemStack var2 = this.func_82_a(var1);
            if (var2 != null) {
                float var3 = this.field_9064_W.nextFloat() * 0.8F + 0.1F;
                float var4 = this.field_9064_W.nextFloat() * 0.8F + 0.1F;
                float var5 = this.field_9064_W.nextFloat() * 0.8F + 0.1F;

                while(var2.field_853_a > 0) {
                    int var6 = this.field_9064_W.nextInt(21) + 10;
                    if (var6 > var2.field_853_a) {
                        var6 = var2.field_853_a;
                    }

                    var2.field_853_a -= var6;
                    EntityItem var7 = new EntityItem(this.field_9093_l, this.field_322_l + (double)var3, this.field_321_m + (double)var4, this.field_320_n + (double)var5, new ItemStack(var2.field_855_c, var6, var2.func_21125_h()));
                    float var8 = 0.05F;
                    var7.field_319_o = (double)((float)this.field_9064_W.nextGaussian() * var8);
                    var7.field_318_p = (double)((float)this.field_9064_W.nextGaussian() * var8 + 0.2F);
                    var7.field_317_q = (double)((float)this.field_9064_W.nextGaussian() * var8);
                    this.field_9093_l.func_526_a(var7);
                }
            }
        }

        super.func_118_j();
    }

    public void func_106_b_() {
        if (this.field_9167_b > 0) {
            --this.field_9167_b;
        }

        if (this.field_9168_a > 0) {
            --this.field_9168_a;
        }

        double var7;
        if (this.field_9093_l.field_792_x && this.field_9163_an > 0) {
            if (this.field_9163_an > 0) {
                double var46 = this.field_322_l + (this.field_9162_ao - this.field_322_l) / (double)this.field_9163_an;
                double var47 = this.field_321_m + (this.field_9161_ap - this.field_321_m) / (double)this.field_9163_an;
                double var5 = this.field_320_n + (this.field_9160_aq - this.field_320_n) / (double)this.field_9163_an;

                for(var7 = this.field_9159_ar - (double)this.field_316_r; var7 < -180.0D; var7 += 360.0D) {
                }

                while(var7 >= 180.0D) {
                    var7 -= 360.0D;
                }

                this.field_316_r = (float)((double)this.field_316_r + var7 / (double)this.field_9163_an);
                this.field_315_s = (float)((double)this.field_315_s + (this.field_9158_as - (double)this.field_315_s) / (double)this.field_9163_an);
                --this.field_9163_an;
                this.func_86_a(var46, var47, var5);
                this.func_6096_b(this.field_316_r, this.field_315_s);
            } else {
                this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
                this.func_6096_b(this.field_316_r, this.field_315_s);
            }

        } else {
            this.field_9092_m = this.field_322_l;
            this.field_9091_n = this.field_321_m;
            this.field_9090_o = this.field_320_n;
            this.field_318_p -= 0.03999999910593033D;
            int var1 = MathHelper.func_584_b(this.field_322_l);
            int var2 = MathHelper.func_584_b(this.field_321_m);
            int var3 = MathHelper.func_584_b(this.field_320_n);
            if (BlockRail.func_27029_g(this.field_9093_l, var1, var2 - 1, var3)) {
                --var2;
            }

            double var4 = 0.4D;
            boolean var6 = false;
            var7 = 0.0078125D;
            int var9 = this.field_9093_l.func_444_a(var1, var2, var3);
            if (BlockRail.func_27030_c(var9)) {
                Vec3D var10 = this.func_182_g(this.field_322_l, this.field_321_m, this.field_320_n);
                int var11 = this.field_9093_l.func_446_b(var1, var2, var3);
                this.field_321_m = (double)var2;
                boolean var12 = false;
                boolean var13 = false;
                if (var9 == Block.field_9036_T.field_573_bc) {
                    var12 = (var11 & 8) != 0;
                    var13 = !var12;
                }

                if (((BlockRail)Block.field_542_n[var9]).func_27028_d()) {
                    var11 &= 7;
                }

                if (var11 >= 2 && var11 <= 5) {
                    this.field_321_m = (double)(var2 + 1);
                }

                if (var11 == 2) {
                    this.field_319_o -= var7;
                }

                if (var11 == 3) {
                    this.field_319_o += var7;
                }

                if (var11 == 4) {
                    this.field_317_q += var7;
                }

                if (var11 == 5) {
                    this.field_317_q -= var7;
                }

                int[][] var14 = field_468_ak[var11];
                double var15 = (double)(var14[1][0] - var14[0][0]);
                double var17 = (double)(var14[1][2] - var14[0][2]);
                double var19 = Math.sqrt(var15 * var15 + var17 * var17);
                double var21 = this.field_319_o * var15 + this.field_317_q * var17;
                if (var21 < 0.0D) {
                    var15 = -var15;
                    var17 = -var17;
                }

                double var23 = Math.sqrt(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
                this.field_319_o = var23 * var15 / var19;
                this.field_317_q = var23 * var17 / var19;
                double var25;
                if (var13) {
                    var25 = Math.sqrt(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
                    if (var25 < 0.03D) {
                        this.field_319_o *= 0.0D;
                        this.field_318_p *= 0.0D;
                        this.field_317_q *= 0.0D;
                    } else {
                        this.field_319_o *= 0.5D;
                        this.field_318_p *= 0.0D;
                        this.field_317_q *= 0.5D;
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
                    this.field_322_l = (double)var1 + 0.5D;
                    var25 = this.field_320_n - (double)var3;
                } else if (var17 == 0.0D) {
                    this.field_320_n = (double)var3 + 0.5D;
                    var25 = this.field_322_l - (double)var1;
                } else {
                    var35 = this.field_322_l - var27;
                    var37 = this.field_320_n - var29;
                    var39 = (var35 * var15 + var37 * var17) * 2.0D;
                    var25 = var39;
                }

                this.field_322_l = var27 + var15 * var25;
                this.field_320_n = var29 + var17 * var25;
                this.func_86_a(this.field_322_l, this.field_321_m + (double)this.field_9076_H, this.field_320_n);
                var35 = this.field_319_o;
                var37 = this.field_317_q;
                if (this.field_328_f != null) {
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

                this.func_88_c(var35, 0.0D, var37);
                if (var14[0][1] != 0 && MathHelper.func_584_b(this.field_322_l) - var1 == var14[0][0] && MathHelper.func_584_b(this.field_320_n) - var3 == var14[0][2]) {
                    this.func_86_a(this.field_322_l, this.field_321_m + (double)var14[0][1], this.field_320_n);
                } else if (var14[1][1] != 0 && MathHelper.func_584_b(this.field_322_l) - var1 == var14[1][0] && MathHelper.func_584_b(this.field_320_n) - var3 == var14[1][2]) {
                    this.func_86_a(this.field_322_l, this.field_321_m + (double)var14[1][1], this.field_320_n);
                }

                if (this.field_328_f != null) {
                    this.field_319_o *= 0.996999979019165D;
                    this.field_318_p *= 0.0D;
                    this.field_317_q *= 0.996999979019165D;
                } else {
                    if (this.field_476_ae == 2) {
                        var39 = (double)MathHelper.func_583_a(this.field_9164_f * this.field_9164_f + this.field_9166_aj * this.field_9166_aj);
                        if (var39 > 0.01D) {
                            var6 = true;
                            this.field_9164_f /= var39;
                            this.field_9166_aj /= var39;
                            double var41 = 0.04D;
                            this.field_319_o *= 0.800000011920929D;
                            this.field_318_p *= 0.0D;
                            this.field_317_q *= 0.800000011920929D;
                            this.field_319_o += this.field_9164_f * var41;
                            this.field_317_q += this.field_9166_aj * var41;
                        } else {
                            this.field_319_o *= 0.8999999761581421D;
                            this.field_318_p *= 0.0D;
                            this.field_317_q *= 0.8999999761581421D;
                        }
                    }

                    this.field_319_o *= 0.9599999785423279D;
                    this.field_318_p *= 0.0D;
                    this.field_317_q *= 0.9599999785423279D;
                }

                Vec3D var52 = this.func_182_g(this.field_322_l, this.field_321_m, this.field_320_n);
                if (var52 != null && var10 != null) {
                    double var40 = (var10.field_1054_b - var52.field_1054_b) * 0.05D;
                    var23 = Math.sqrt(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
                    if (var23 > 0.0D) {
                        this.field_319_o = this.field_319_o / var23 * (var23 + var40);
                        this.field_317_q = this.field_317_q / var23 * (var23 + var40);
                    }

                    this.func_86_a(this.field_322_l, var52.field_1054_b, this.field_320_n);
                }

                int var53 = MathHelper.func_584_b(this.field_322_l);
                int var54 = MathHelper.func_584_b(this.field_320_n);
                if (var53 != var1 || var54 != var3) {
                    var23 = Math.sqrt(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
                    this.field_319_o = var23 * (double)(var53 - var1);
                    this.field_317_q = var23 * (double)(var54 - var3);
                }

                double var42;
                if (this.field_476_ae == 2) {
                    var42 = (double)MathHelper.func_583_a(this.field_9164_f * this.field_9164_f + this.field_9166_aj * this.field_9166_aj);
                    if (var42 > 0.01D && this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q > 0.001D) {
                        this.field_9164_f /= var42;
                        this.field_9166_aj /= var42;
                        if (this.field_9164_f * this.field_319_o + this.field_9166_aj * this.field_317_q < 0.0D) {
                            this.field_9164_f = 0.0D;
                            this.field_9166_aj = 0.0D;
                        } else {
                            this.field_9164_f = this.field_319_o;
                            this.field_9166_aj = this.field_317_q;
                        }
                    }
                }

                if (var12) {
                    var42 = Math.sqrt(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
                    if (var42 > 0.01D) {
                        double var44 = 0.06D;
                        this.field_319_o += this.field_319_o / var42 * var44;
                        this.field_317_q += this.field_317_q / var42 * var44;
                    } else if (var11 == 1) {
                        if (this.field_9093_l.func_445_d(var1 - 1, var2, var3)) {
                            this.field_319_o = 0.02D;
                        } else if (this.field_9093_l.func_445_d(var1 + 1, var2, var3)) {
                            this.field_319_o = -0.02D;
                        }
                    } else if (var11 == 0) {
                        if (this.field_9093_l.func_445_d(var1, var2, var3 - 1)) {
                            this.field_317_q = 0.02D;
                        } else if (this.field_9093_l.func_445_d(var1, var2, var3 + 1)) {
                            this.field_317_q = -0.02D;
                        }
                    }
                }
            } else {
                if (this.field_319_o < -var4) {
                    this.field_319_o = -var4;
                }

                if (this.field_319_o > var4) {
                    this.field_319_o = var4;
                }

                if (this.field_317_q < -var4) {
                    this.field_317_q = -var4;
                }

                if (this.field_317_q > var4) {
                    this.field_317_q = var4;
                }

                if (this.field_9086_A) {
                    this.field_319_o *= 0.5D;
                    this.field_318_p *= 0.5D;
                    this.field_317_q *= 0.5D;
                }

                this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
                if (!this.field_9086_A) {
                    this.field_319_o *= 0.949999988079071D;
                    this.field_318_p *= 0.949999988079071D;
                    this.field_317_q *= 0.949999988079071D;
                }
            }

            this.field_315_s = 0.0F;
            double var48 = this.field_9092_m - this.field_322_l;
            double var49 = this.field_9090_o - this.field_320_n;
            if (var48 * var48 + var49 * var49 > 0.001D) {
                this.field_316_r = (float)(Math.atan2(var49, var48) * 180.0D / 3.141592653589793D);
                if (this.field_469_aj) {
                    this.field_316_r += 180.0F;
                }
            }

            double var50;
            for(var50 = (double)(this.field_316_r - this.field_9089_x); var50 >= 180.0D; var50 -= 360.0D) {
            }

            while(var50 < -180.0D) {
                var50 += 360.0D;
            }

            if (var50 < -170.0D || var50 >= 170.0D) {
                this.field_316_r += 180.0F;
                this.field_469_aj = !this.field_469_aj;
            }

            this.func_6096_b(this.field_316_r, this.field_315_s);
            List var16 = this.field_9093_l.func_450_b(this, this.field_312_v.func_708_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            if (var16 != null && var16.size() > 0) {
                for(int var51 = 0; var51 < var16.size(); ++var51) {
                    Entity var18 = (Entity)var16.get(var51);
                    if (var18 != this.field_328_f && var18.func_124_r() && var18 instanceof EntityMinecart) {
                        var18.func_92_c(this);
                    }
                }
            }

            if (this.field_328_f != null && this.field_328_f.field_304_B) {
                this.field_328_f = null;
            }

            if (var6 && this.field_9064_W.nextInt(4) == 0) {
                --this.field_9165_e;
                if (this.field_9165_e < 0) {
                    this.field_9164_f = this.field_9166_aj = 0.0D;
                }

                this.field_9093_l.func_514_a("largesmoke", this.field_322_l, this.field_321_m + 0.8D, this.field_320_n, 0.0D, 0.0D, 0.0D);
            }

        }
    }

    public Vec3D func_182_g(double var1, double var3, double var5) {
        int var7 = MathHelper.func_584_b(var1);
        int var8 = MathHelper.func_584_b(var3);
        int var9 = MathHelper.func_584_b(var5);
        if (BlockRail.func_27029_g(this.field_9093_l, var7, var8 - 1, var9)) {
            --var8;
        }

        int var10 = this.field_9093_l.func_444_a(var7, var8, var9);
        if (BlockRail.func_27030_c(var10)) {
            int var11 = this.field_9093_l.func_446_b(var7, var8, var9);
            var3 = (double)var8;
            if (((BlockRail)Block.field_542_n[var10]).func_27028_d()) {
                var11 &= 7;
            }

            if (var11 >= 2 && var11 <= 5) {
                var3 = (double)(var8 + 1);
            }

            int[][] var12 = field_468_ak[var11];
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

            return Vec3D.func_768_b(var1, var3, var5);
        } else {
            return null;
        }
    }

    protected void func_97_a(NBTTagCompound var1) {
        var1.func_405_a("Type", this.field_476_ae);
        if (this.field_476_ae == 2) {
            var1.func_411_a("PushX", this.field_9164_f);
            var1.func_411_a("PushZ", this.field_9166_aj);
            var1.func_394_a("Fuel", (short)this.field_9165_e);
        } else if (this.field_476_ae == 1) {
            NBTTagList var2 = new NBTTagList();

            for(int var3 = 0; var3 < this.field_470_ai.length; ++var3) {
                if (this.field_470_ai[var3] != null) {
                    NBTTagCompound var4 = new NBTTagCompound();
                    var4.func_409_a("Slot", (byte)var3);
                    this.field_470_ai[var3].func_570_a(var4);
                    var2.func_386_a(var4);
                }
            }

            var1.func_399_a("Items", var2);
        }

    }

    protected void func_99_b(NBTTagCompound var1) {
        this.field_476_ae = var1.func_395_d("Type");
        if (this.field_476_ae == 2) {
            this.field_9164_f = var1.func_398_g("PushX");
            this.field_9166_aj = var1.func_398_g("PushZ");
            this.field_9165_e = var1.func_406_c("Fuel");
        } else if (this.field_476_ae == 1) {
            NBTTagList var2 = var1.func_407_k("Items");
            this.field_470_ai = new ItemStack[this.func_83_a()];

            for(int var3 = 0; var3 < var2.func_387_b(); ++var3) {
                NBTTagCompound var4 = (NBTTagCompound)var2.func_388_a(var3);
                int var5 = var4.func_408_b("Slot") & 255;
                if (var5 >= 0 && var5 < this.field_470_ai.length) {
                    this.field_470_ai[var5] = new ItemStack(var4);
                }
            }
        }

    }

    public void func_92_c(Entity var1) {
        if (!this.field_9093_l.field_792_x) {
            if (var1 != this.field_328_f) {
                if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.field_476_ae == 0 && this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q > 0.01D && this.field_328_f == null && var1.field_327_g == null) {
                    var1.func_6094_e(this);
                }

                double var2 = var1.field_322_l - this.field_322_l;
                double var4 = var1.field_320_n - this.field_320_n;
                double var6 = var2 * var2 + var4 * var4;
                if (var6 >= 9.999999747378752E-5D) {
                    var6 = (double)MathHelper.func_583_a(var6);
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
                    var2 *= (double)(1.0F - this.field_286_P);
                    var4 *= (double)(1.0F - this.field_286_P);
                    var2 *= 0.5D;
                    var4 *= 0.5D;
                    if (var1 instanceof EntityMinecart) {
                        double var10 = var1.field_322_l - this.field_322_l;
                        double var12 = var1.field_320_n - this.field_320_n;
                        double var14 = var10 * var1.field_317_q + var12 * var1.field_9092_m;
                        var14 *= var14;
                        if (var14 > 5.0D) {
                            return;
                        }

                        double var16 = var1.field_319_o + this.field_319_o;
                        double var18 = var1.field_317_q + this.field_317_q;
                        if (((EntityMinecart)var1).field_476_ae == 2 && this.field_476_ae != 2) {
                            this.field_319_o *= 0.20000000298023224D;
                            this.field_317_q *= 0.20000000298023224D;
                            this.func_87_f(var1.field_319_o - var2, 0.0D, var1.field_317_q - var4);
                            var1.field_319_o *= 0.699999988079071D;
                            var1.field_317_q *= 0.699999988079071D;
                        } else if (((EntityMinecart)var1).field_476_ae != 2 && this.field_476_ae == 2) {
                            var1.field_319_o *= 0.20000000298023224D;
                            var1.field_317_q *= 0.20000000298023224D;
                            var1.func_87_f(this.field_319_o + var2, 0.0D, this.field_317_q + var4);
                            this.field_319_o *= 0.699999988079071D;
                            this.field_317_q *= 0.699999988079071D;
                        } else {
                            var16 /= 2.0D;
                            var18 /= 2.0D;
                            this.field_319_o *= 0.20000000298023224D;
                            this.field_317_q *= 0.20000000298023224D;
                            this.func_87_f(var16 - var2, 0.0D, var18 - var4);
                            var1.field_319_o *= 0.20000000298023224D;
                            var1.field_317_q *= 0.20000000298023224D;
                            var1.func_87_f(var16 + var2, 0.0D, var18 + var4);
                        }
                    } else {
                        this.func_87_f(-var2, 0.0D, -var4);
                        var1.func_87_f(var2 / 4.0D, 0.0D, var4 / 4.0D);
                    }
                }

            }
        }
    }

    public int func_83_a() {
        return 27;
    }

    public ItemStack func_82_a(int var1) {
        return this.field_470_ai[var1];
    }

    public ItemStack func_20069_a(int var1, int var2) {
        if (this.field_470_ai[var1] != null) {
            ItemStack var3;
            if (this.field_470_ai[var1].field_853_a <= var2) {
                var3 = this.field_470_ai[var1];
                this.field_470_ai[var1] = null;
                return var3;
            } else {
                var3 = this.field_470_ai[var1].func_20118_a(var2);
                if (this.field_470_ai[var1].field_853_a == 0) {
                    this.field_470_ai[var1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    public void func_206_a(int var1, ItemStack var2) {
        this.field_470_ai[var1] = var2;
        if (var2 != null && var2.field_853_a > this.func_202_d()) {
            var2.field_853_a = this.func_202_d();
        }

    }

    public String func_20068_b() {
        return "Minecart";
    }

    public int func_202_d() {
        return 64;
    }

    public void func_183_c() {
    }

    public boolean func_6092_a(EntityPlayer var1) {
        if (this.field_476_ae == 0) {
            if (this.field_328_f != null && this.field_328_f instanceof EntityPlayer && this.field_328_f != var1) {
                return true;
            }

            if (!this.field_9093_l.field_792_x) {
                var1.func_6094_e(this);
            }
        } else if (this.field_476_ae == 1) {
            if (!this.field_9093_l.field_792_x) {
                var1.func_166_a(this);
            }
        } else if (this.field_476_ae == 2) {
            ItemStack var2 = var1.field_416_aj.func_213_b();
            if (var2 != null && var2.field_855_c == Item.field_168_k.field_234_aS) {
                if (--var2.field_853_a == 0) {
                    var1.field_416_aj.func_206_a(var1.field_416_aj.field_499_d, (ItemStack)null);
                }

                this.field_9165_e += 1200;
            }

            this.field_9164_f = this.field_322_l - var1.field_322_l;
            this.field_9166_aj = this.field_320_n - var1.field_320_n;
        }

        return true;
    }

    public boolean func_20067_a_(EntityPlayer var1) {
        if (this.field_304_B) {
            return false;
        } else {
            return var1.func_102_b(this) <= 64.0D;
        }
    }
}
