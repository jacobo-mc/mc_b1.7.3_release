package net.minecraft.src;

import java.util.List;

public class EntityFish extends Entity {
    private int field_20906_d = -1;
    private int field_20905_e = -1;
    private int field_4126_f = -1;
    private int field_4132_ai = 0;
    private boolean field_4129_aj = false;
    public int field_4134_a = 0;
    public EntityPlayer field_20909_b;
    private int field_6150_ak;
    private int field_4125_al = 0;
    private int field_4124_am = 0;
    public Entity field_20907_c = null;
    private int field_6149_an;
    private double field_6148_ao;
    private double field_6147_ap;
    private double field_6146_aq;
    private double field_6145_ar;
    private double field_6144_as;

    public EntityFish(World var1) {
        super(var1);
        this.func_113_a(0.25F, 0.25F);
        this.field_28008_bI = true;
    }

    public EntityFish(World var1, EntityPlayer var2) {
        super(var1);
        this.field_28008_bI = true;
        this.field_20909_b = var2;
        this.field_20909_b.field_6124_at = this;
        this.func_113_a(0.25F, 0.25F);
        this.func_107_c(var2.field_322_l, var2.field_321_m + 1.62D - (double)var2.field_9076_H, var2.field_320_n, var2.field_316_r, var2.field_315_s);
        this.field_322_l -= (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * 0.16F);
        this.field_321_m -= 0.10000000149011612D;
        this.field_320_n -= (double)(MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * 0.16F);
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.field_9076_H = 0.0F;
        float var3 = 0.4F;
        this.field_319_o = (double)(-MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F) * var3);
        this.field_317_q = (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F) * var3);
        this.field_318_p = (double)(-MathHelper.func_585_a(this.field_315_s / 180.0F * 3.1415927F) * var3);
        this.func_6142_a(this.field_319_o, this.field_318_p, this.field_317_q, 1.5F, 1.0F);
    }

    protected void func_21044_a() {
    }

    public void func_6142_a(double var1, double var3, double var5, float var7, float var8) {
        float var9 = MathHelper.func_583_a(var1 * var1 + var3 * var3 + var5 * var5);
        var1 /= (double)var9;
        var3 /= (double)var9;
        var5 /= (double)var9;
        var1 += this.field_9064_W.nextGaussian() * 0.007499999832361937D * (double)var8;
        var3 += this.field_9064_W.nextGaussian() * 0.007499999832361937D * (double)var8;
        var5 += this.field_9064_W.nextGaussian() * 0.007499999832361937D * (double)var8;
        var1 *= (double)var7;
        var3 *= (double)var7;
        var5 *= (double)var7;
        this.field_319_o = var1;
        this.field_318_p = var3;
        this.field_317_q = var5;
        float var10 = MathHelper.func_583_a(var1 * var1 + var5 * var5);
        this.field_9089_x = this.field_316_r = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
        this.field_9088_y = this.field_315_s = (float)(Math.atan2(var3, (double)var10) * 180.0D / 3.1415927410125732D);
        this.field_6150_ak = 0;
    }

    public void func_106_b_() {
        super.func_106_b_();
        if (this.field_6149_an > 0) {
            double var21 = this.field_322_l + (this.field_6148_ao - this.field_322_l) / (double)this.field_6149_an;
            double var22 = this.field_321_m + (this.field_6147_ap - this.field_321_m) / (double)this.field_6149_an;
            double var23 = this.field_320_n + (this.field_6146_aq - this.field_320_n) / (double)this.field_6149_an;

            double var7;
            for(var7 = this.field_6145_ar - (double)this.field_316_r; var7 < -180.0D; var7 += 360.0D) {
            }

            while(var7 >= 180.0D) {
                var7 -= 360.0D;
            }

            this.field_316_r = (float)((double)this.field_316_r + var7 / (double)this.field_6149_an);
            this.field_315_s = (float)((double)this.field_315_s + (this.field_6144_as - (double)this.field_315_s) / (double)this.field_6149_an);
            --this.field_6149_an;
            this.func_86_a(var21, var22, var23);
            this.func_6096_b(this.field_316_r, this.field_315_s);
        } else {
            if (!this.field_9093_l.field_792_x) {
                ItemStack var1 = this.field_20909_b.func_172_B();
                if (this.field_20909_b.field_304_B || !this.field_20909_b.func_120_t() || var1 == null || var1.func_569_a() != Item.field_4196_aP || this.func_102_b(this.field_20909_b) > 1024.0D) {
                    this.func_118_j();
                    this.field_20909_b.field_6124_at = null;
                    return;
                }

                if (this.field_20907_c != null) {
                    if (!this.field_20907_c.field_304_B) {
                        this.field_322_l = this.field_20907_c.field_322_l;
                        this.field_321_m = this.field_20907_c.field_312_v.field_963_b + (double)this.field_20907_c.field_298_E * 0.8D;
                        this.field_320_n = this.field_20907_c.field_320_n;
                        return;
                    }

                    this.field_20907_c = null;
                }
            }

            if (this.field_4134_a > 0) {
                --this.field_4134_a;
            }

            if (this.field_4129_aj) {
                int var19 = this.field_9093_l.func_444_a(this.field_20906_d, this.field_20905_e, this.field_4126_f);
                if (var19 == this.field_4132_ai) {
                    ++this.field_6150_ak;
                    if (this.field_6150_ak == 1200) {
                        this.func_118_j();
                    }

                    return;
                }

                this.field_4129_aj = false;
                this.field_319_o *= (double)(this.field_9064_W.nextFloat() * 0.2F);
                this.field_318_p *= (double)(this.field_9064_W.nextFloat() * 0.2F);
                this.field_317_q *= (double)(this.field_9064_W.nextFloat() * 0.2F);
                this.field_6150_ak = 0;
                this.field_4125_al = 0;
            } else {
                ++this.field_4125_al;
            }

            Vec3D var20 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
            Vec3D var2 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
            MovingObjectPosition var3 = this.field_9093_l.func_486_a(var20, var2);
            var20 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
            var2 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
            if (var3 != null) {
                var2 = Vec3D.func_768_b(var3.field_929_f.field_1055_a, var3.field_929_f.field_1054_b, var3.field_929_f.field_1058_c);
            }

            Entity var4 = null;
            List var5 = this.field_9093_l.func_450_b(this, this.field_312_v.func_700_a(this.field_319_o, this.field_318_p, this.field_317_q).func_708_b(1.0D, 1.0D, 1.0D));
            double var6 = 0.0D;

            double var13;
            for(int var8 = 0; var8 < var5.size(); ++var8) {
                Entity var9 = (Entity)var5.get(var8);
                if (var9.func_129_c_() && (var9 != this.field_20909_b || this.field_4125_al >= 5)) {
                    float var10 = 0.3F;
                    AxisAlignedBB var11 = var9.field_312_v.func_708_b((double)var10, (double)var10, (double)var10);
                    MovingObjectPosition var12 = var11.func_706_a(var20, var2);
                    if (var12 != null) {
                        var13 = var20.func_767_a(var12.field_929_f);
                        if (var13 < var6 || var6 == 0.0D) {
                            var4 = var9;
                            var6 = var13;
                        }
                    }
                }
            }

            if (var4 != null) {
                var3 = new MovingObjectPosition(var4);
            }

            if (var3 != null) {
                if (var3.field_928_g != null) {
                    if (var3.field_928_g.func_121_a(this.field_20909_b, 0)) {
                        this.field_20907_c = var3.field_928_g;
                    }
                } else {
                    this.field_4129_aj = true;
                }
            }

            if (!this.field_4129_aj) {
                this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
                float var24 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
                this.field_316_r = (float)(Math.atan2(this.field_319_o, this.field_317_q) * 180.0D / 3.1415927410125732D);

                for(this.field_315_s = (float)(Math.atan2(this.field_318_p, (double)var24) * 180.0D / 3.1415927410125732D); this.field_315_s - this.field_9088_y < -180.0F; this.field_9088_y -= 360.0F) {
                }

                while(this.field_315_s - this.field_9088_y >= 180.0F) {
                    this.field_9088_y += 360.0F;
                }

                while(this.field_316_r - this.field_9089_x < -180.0F) {
                    this.field_9089_x -= 360.0F;
                }

                while(this.field_316_r - this.field_9089_x >= 180.0F) {
                    this.field_9089_x += 360.0F;
                }

                this.field_315_s = this.field_9088_y + (this.field_315_s - this.field_9088_y) * 0.2F;
                this.field_316_r = this.field_9089_x + (this.field_316_r - this.field_9089_x) * 0.2F;
                float var25 = 0.92F;
                if (this.field_9086_A || this.field_9084_B) {
                    var25 = 0.5F;
                }

                byte var26 = 5;
                double var27 = 0.0D;

                for(int var28 = 0; var28 < var26; ++var28) {
                    double var14 = this.field_312_v.field_963_b + (this.field_312_v.field_968_e - this.field_312_v.field_963_b) * (double)(var28 + 0) / (double)var26 - 0.125D + 0.125D;
                    double var16 = this.field_312_v.field_963_b + (this.field_312_v.field_968_e - this.field_312_v.field_963_b) * (double)(var28 + 1) / (double)var26 - 0.125D + 0.125D;
                    AxisAlignedBB var18 = AxisAlignedBB.func_693_b(this.field_312_v.field_964_a, var14, this.field_312_v.field_970_c, this.field_312_v.field_969_d, var16, this.field_312_v.field_967_f);
                    if (this.field_9093_l.func_524_b(var18, Material.field_521_f)) {
                        var27 += 1.0D / (double)var26;
                    }
                }

                if (var27 > 0.0D) {
                    if (this.field_4124_am > 0) {
                        --this.field_4124_am;
                    } else {
                        short var29 = 500;
                        if (this.field_9093_l.func_27072_q(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m) + 1, MathHelper.func_584_b(this.field_320_n))) {
                            var29 = 300;
                        }

                        if (this.field_9064_W.nextInt(var29) == 0) {
                            this.field_4124_am = this.field_9064_W.nextInt(30) + 10;
                            this.field_318_p -= 0.20000000298023224D;
                            this.field_9093_l.func_506_a(this, "random.splash", 0.25F, 1.0F + (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.4F);
                            float var30 = (float)MathHelper.func_584_b(this.field_312_v.field_963_b);

                            int var15;
                            float var17;
                            float var31;
                            for(var15 = 0; (float)var15 < 1.0F + this.field_300_D * 20.0F; ++var15) {
                                var31 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                                var17 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                                this.field_9093_l.func_514_a("bubble", this.field_322_l + (double)var31, (double)(var30 + 1.0F), this.field_320_n + (double)var17, this.field_319_o, this.field_318_p - (double)(this.field_9064_W.nextFloat() * 0.2F), this.field_317_q);
                            }

                            for(var15 = 0; (float)var15 < 1.0F + this.field_300_D * 20.0F; ++var15) {
                                var31 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                                var17 = (this.field_9064_W.nextFloat() * 2.0F - 1.0F) * this.field_300_D;
                                this.field_9093_l.func_514_a("splash", this.field_322_l + (double)var31, (double)(var30 + 1.0F), this.field_320_n + (double)var17, this.field_319_o, this.field_318_p, this.field_317_q);
                            }
                        }
                    }
                }

                if (this.field_4124_am > 0) {
                    this.field_318_p -= (double)(this.field_9064_W.nextFloat() * this.field_9064_W.nextFloat() * this.field_9064_W.nextFloat()) * 0.2D;
                }

                var13 = var27 * 2.0D - 1.0D;
                this.field_318_p += 0.03999999910593033D * var13;
                if (var27 > 0.0D) {
                    var25 = (float)((double)var25 * 0.9D);
                    this.field_318_p *= 0.8D;
                }

                this.field_319_o *= (double)var25;
                this.field_318_p *= (double)var25;
                this.field_317_q *= (double)var25;
                this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
            }
        }
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_394_a("xTile", (short)this.field_20906_d);
        var1.func_394_a("yTile", (short)this.field_20905_e);
        var1.func_394_a("zTile", (short)this.field_4126_f);
        var1.func_409_a("inTile", (byte)this.field_4132_ai);
        var1.func_409_a("shake", (byte)this.field_4134_a);
        var1.func_409_a("inGround", (byte)(this.field_4129_aj ? 1 : 0));
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_20906_d = var1.func_406_c("xTile");
        this.field_20905_e = var1.func_406_c("yTile");
        this.field_4126_f = var1.func_406_c("zTile");
        this.field_4132_ai = var1.func_408_b("inTile") & 255;
        this.field_4134_a = var1.func_408_b("shake") & 255;
        this.field_4129_aj = var1.func_408_b("inGround") == 1;
    }

    public int func_6143_c() {
        byte var1 = 0;
        if (this.field_20907_c != null) {
            double var2 = this.field_20909_b.field_322_l - this.field_322_l;
            double var4 = this.field_20909_b.field_321_m - this.field_321_m;
            double var6 = this.field_20909_b.field_320_n - this.field_320_n;
            double var8 = (double)MathHelper.func_583_a(var2 * var2 + var4 * var4 + var6 * var6);
            double var10 = 0.1D;
            Entity var10000 = this.field_20907_c;
            var10000.field_319_o += var2 * var10;
            var10000 = this.field_20907_c;
            var10000.field_318_p += var4 * var10 + (double)MathHelper.func_583_a(var8) * 0.08D;
            var10000 = this.field_20907_c;
            var10000.field_317_q += var6 * var10;
            var1 = 3;
        } else if (this.field_4124_am > 0) {
            EntityItem var13 = new EntityItem(this.field_9093_l, this.field_322_l, this.field_321_m, this.field_320_n, new ItemStack(Item.field_4193_aS));
            double var3 = this.field_20909_b.field_322_l - this.field_322_l;
            double var5 = this.field_20909_b.field_321_m - this.field_321_m;
            double var7 = this.field_20909_b.field_320_n - this.field_320_n;
            double var9 = (double)MathHelper.func_583_a(var3 * var3 + var5 * var5 + var7 * var7);
            double var11 = 0.1D;
            var13.field_319_o = var3 * var11;
            var13.field_318_p = var5 * var11 + (double)MathHelper.func_583_a(var9) * 0.08D;
            var13.field_317_q = var7 * var11;
            this.field_9093_l.func_526_a(var13);
            this.field_20909_b.func_25046_a(StatList.field_25095_x, 1);
            var1 = 1;
        }

        if (this.field_4129_aj) {
            var1 = 2;
        }

        this.func_118_j();
        this.field_20909_b.field_6124_at = null;
        return var1;
    }
}
