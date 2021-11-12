package net.minecraft.src;

import java.util.List;

public class EntityFireball extends Entity {
    private int field_9195_e = -1;
    private int field_9193_f = -1;
    private int field_9197_aj = -1;
    private int field_9194_ak = 0;
    private boolean field_9192_al = false;
    public int field_9200_a = 0;
    public EntityLiving field_9191_am;
    private int field_9190_an;
    private int field_9189_ao = 0;
    public double field_9199_b;
    public double field_9198_c;
    public double field_9196_d;

    public EntityFireball(World var1) {
        super(var1);
        this.func_113_a(1.0F, 1.0F);
    }

    protected void func_21044_a() {
    }

    public EntityFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
        super(var1);
        this.field_9191_am = var2;
        this.func_113_a(1.0F, 1.0F);
        this.func_107_c(var2.field_322_l, var2.field_321_m, var2.field_320_n, var2.field_316_r, var2.field_315_s);
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.field_9076_H = 0.0F;
        this.field_319_o = this.field_318_p = this.field_317_q = 0.0D;
        var3 += this.field_9064_W.nextGaussian() * 0.4D;
        var5 += this.field_9064_W.nextGaussian() * 0.4D;
        var7 += this.field_9064_W.nextGaussian() * 0.4D;
        double var9 = (double)MathHelper.func_583_a(var3 * var3 + var5 * var5 + var7 * var7);
        this.field_9199_b = var3 / var9 * 0.1D;
        this.field_9198_c = var5 / var9 * 0.1D;
        this.field_9196_d = var7 / var9 * 0.1D;
    }

    public void func_106_b_() {
        super.func_106_b_();
        this.field_9061_Z = 10;
        if (this.field_9200_a > 0) {
            --this.field_9200_a;
        }

        if (this.field_9192_al) {
            int var1 = this.field_9093_l.func_444_a(this.field_9195_e, this.field_9193_f, this.field_9197_aj);
            if (var1 == this.field_9194_ak) {
                ++this.field_9190_an;
                if (this.field_9190_an == 1200) {
                    this.func_118_j();
                }

                return;
            }

            this.field_9192_al = false;
            this.field_319_o *= (double)(this.field_9064_W.nextFloat() * 0.2F);
            this.field_318_p *= (double)(this.field_9064_W.nextFloat() * 0.2F);
            this.field_317_q *= (double)(this.field_9064_W.nextFloat() * 0.2F);
            this.field_9190_an = 0;
            this.field_9189_ao = 0;
        } else {
            ++this.field_9189_ao;
        }

        Vec3D var15 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
        Vec3D var2 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
        MovingObjectPosition var3 = this.field_9093_l.func_486_a(var15, var2);
        var15 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
        var2 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
        if (var3 != null) {
            var2 = Vec3D.func_768_b(var3.field_929_f.field_1055_a, var3.field_929_f.field_1054_b, var3.field_929_f.field_1058_c);
        }

        Entity var4 = null;
        List var5 = this.field_9093_l.func_450_b(this, this.field_312_v.func_700_a(this.field_319_o, this.field_318_p, this.field_317_q).func_708_b(1.0D, 1.0D, 1.0D));
        double var6 = 0.0D;

        for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if (var9.func_129_c_() && (var9 != this.field_9191_am || this.field_9189_ao >= 25)) {
                float var10 = 0.3F;
                AxisAlignedBB var11 = var9.field_312_v.func_708_b((double)var10, (double)var10, (double)var10);
                MovingObjectPosition var12 = var11.func_706_a(var15, var2);
                if (var12 != null) {
                    double var13 = var15.func_767_a(var12.field_929_f);
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
            if (!this.field_9093_l.field_792_x) {
                if (var3.field_928_g != null && var3.field_928_g.func_121_a(this.field_9191_am, 0)) {
                }

                this.field_9093_l.func_12015_a((Entity)null, this.field_322_l, this.field_321_m, this.field_320_n, 1.0F, true);
            }

            this.func_118_j();
        }

        this.field_322_l += this.field_319_o;
        this.field_321_m += this.field_318_p;
        this.field_320_n += this.field_317_q;
        float var16 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
        this.field_316_r = (float)(Math.atan2(this.field_319_o, this.field_317_q) * 180.0D / 3.1415927410125732D);

        for(this.field_315_s = (float)(Math.atan2(this.field_318_p, (double)var16) * 180.0D / 3.1415927410125732D); this.field_315_s - this.field_9088_y < -180.0F; this.field_9088_y -= 360.0F) {
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
        float var17 = 0.95F;
        if (this.func_27011_Z()) {
            for(int var18 = 0; var18 < 4; ++var18) {
                float var19 = 0.25F;
                this.field_9093_l.func_514_a("bubble", this.field_322_l - this.field_319_o * (double)var19, this.field_321_m - this.field_318_p * (double)var19, this.field_320_n - this.field_317_q * (double)var19, this.field_319_o, this.field_318_p, this.field_317_q);
            }

            var17 = 0.8F;
        }

        this.field_319_o += this.field_9199_b;
        this.field_318_p += this.field_9198_c;
        this.field_317_q += this.field_9196_d;
        this.field_319_o *= (double)var17;
        this.field_318_p *= (double)var17;
        this.field_317_q *= (double)var17;
        this.field_9093_l.func_514_a("smoke", this.field_322_l, this.field_321_m + 0.5D, this.field_320_n, 0.0D, 0.0D, 0.0D);
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_394_a("xTile", (short)this.field_9195_e);
        var1.func_394_a("yTile", (short)this.field_9193_f);
        var1.func_394_a("zTile", (short)this.field_9197_aj);
        var1.func_409_a("inTile", (byte)this.field_9194_ak);
        var1.func_409_a("shake", (byte)this.field_9200_a);
        var1.func_409_a("inGround", (byte)(this.field_9192_al ? 1 : 0));
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_9195_e = var1.func_406_c("xTile");
        this.field_9193_f = var1.func_406_c("yTile");
        this.field_9197_aj = var1.func_406_c("zTile");
        this.field_9194_ak = var1.func_408_b("inTile") & 255;
        this.field_9200_a = var1.func_408_b("shake") & 255;
        this.field_9192_al = var1.func_408_b("inGround") == 1;
    }

    public boolean func_129_c_() {
        return true;
    }

    public boolean func_121_a(Entity var1, int var2) {
        this.func_9060_u();
        if (var1 != null) {
            Vec3D var3 = var1.func_4039_B();
            if (var3 != null) {
                this.field_319_o = var3.field_1055_a;
                this.field_318_p = var3.field_1054_b;
                this.field_317_q = var3.field_1058_c;
                this.field_9199_b = this.field_319_o * 0.1D;
                this.field_9198_c = this.field_318_p * 0.1D;
                this.field_9196_d = this.field_317_q * 0.1D;
            }

            return true;
        } else {
            return false;
        }
    }
}
