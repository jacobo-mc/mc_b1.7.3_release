package net.minecraft.src;

import java.util.List;

public class EntitySnowball extends Entity {
    private int field_456_b = -1;
    private int field_461_ad = -1;
    private int field_460_ae = -1;
    private int field_459_af = 0;
    private boolean field_457_ag = false;
    public int field_458_a = 0;
    private EntityLiving field_455_ah;
    private int field_454_ai;
    private int field_453_aj = 0;

    public EntitySnowball(World var1) {
        super(var1);
        this.func_113_a(0.25F, 0.25F);
    }

    protected void func_21044_a() {
    }

    public EntitySnowball(World var1, EntityLiving var2) {
        super(var1);
        this.field_455_ah = var2;
        this.func_113_a(0.25F, 0.25F);
        this.func_107_c(var2.field_322_l, var2.field_321_m + (double)var2.func_104_p(), var2.field_320_n, var2.field_316_r, var2.field_315_s);
        this.field_322_l -= (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * 0.16F);
        this.field_321_m -= 0.10000000149011612D;
        this.field_320_n -= (double)(MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * 0.16F);
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.field_9076_H = 0.0F;
        float var3 = 0.4F;
        this.field_319_o = (double)(-MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F) * var3);
        this.field_317_q = (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F) * var3);
        this.field_318_p = (double)(-MathHelper.func_585_a(this.field_315_s / 180.0F * 3.1415927F) * var3);
        this.func_6141_a(this.field_319_o, this.field_318_p, this.field_317_q, 1.5F, 1.0F);
    }

    public EntitySnowball(World var1, double var2, double var4, double var6) {
        super(var1);
        this.field_454_ai = 0;
        this.func_113_a(0.25F, 0.25F);
        this.func_86_a(var2, var4, var6);
        this.field_9076_H = 0.0F;
    }

    public void func_6141_a(double var1, double var3, double var5, float var7, float var8) {
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
        this.field_454_ai = 0;
    }

    public void func_106_b_() {
        this.field_9071_O = this.field_322_l;
        this.field_9070_P = this.field_321_m;
        this.field_9069_Q = this.field_320_n;
        super.func_106_b_();
        if (this.field_458_a > 0) {
            --this.field_458_a;
        }

        if (this.field_457_ag) {
            int var1 = this.field_9093_l.func_444_a(this.field_456_b, this.field_461_ad, this.field_460_ae);
            if (var1 == this.field_459_af) {
                ++this.field_454_ai;
                if (this.field_454_ai == 1200) {
                    this.func_118_j();
                }

                return;
            }

            this.field_457_ag = false;
            this.field_319_o *= (double)(this.field_9064_W.nextFloat() * 0.2F);
            this.field_318_p *= (double)(this.field_9064_W.nextFloat() * 0.2F);
            this.field_317_q *= (double)(this.field_9064_W.nextFloat() * 0.2F);
            this.field_454_ai = 0;
            this.field_453_aj = 0;
        } else {
            ++this.field_453_aj;
        }

        Vec3D var15 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
        Vec3D var2 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
        MovingObjectPosition var3 = this.field_9093_l.func_486_a(var15, var2);
        var15 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
        var2 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
        if (var3 != null) {
            var2 = Vec3D.func_768_b(var3.field_929_f.field_1055_a, var3.field_929_f.field_1054_b, var3.field_929_f.field_1058_c);
        }

        if (!this.field_9093_l.field_792_x) {
            Entity var4 = null;
            List var5 = this.field_9093_l.func_450_b(this, this.field_312_v.func_700_a(this.field_319_o, this.field_318_p, this.field_317_q).func_708_b(1.0D, 1.0D, 1.0D));
            double var6 = 0.0D;

            for(int var8 = 0; var8 < var5.size(); ++var8) {
                Entity var9 = (Entity)var5.get(var8);
                if (var9.func_129_c_() && (var9 != this.field_455_ah || this.field_453_aj >= 5)) {
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
        }

        if (var3 != null) {
            if (var3.field_928_g != null && var3.field_928_g.func_121_a(this.field_455_ah, 0)) {
            }

            for(int var16 = 0; var16 < 8; ++var16) {
                this.field_9093_l.func_514_a("snowballpoof", this.field_322_l, this.field_321_m, this.field_320_n, 0.0D, 0.0D, 0.0D);
            }

            this.func_118_j();
        }

        this.field_322_l += this.field_319_o;
        this.field_321_m += this.field_318_p;
        this.field_320_n += this.field_317_q;
        float var17 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
        this.field_316_r = (float)(Math.atan2(this.field_319_o, this.field_317_q) * 180.0D / 3.1415927410125732D);

        for(this.field_315_s = (float)(Math.atan2(this.field_318_p, (double)var17) * 180.0D / 3.1415927410125732D); this.field_315_s - this.field_9088_y < -180.0F; this.field_9088_y -= 360.0F) {
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
        float var18 = 0.99F;
        float var19 = 0.03F;
        if (this.func_27011_Z()) {
            for(int var7 = 0; var7 < 4; ++var7) {
                float var20 = 0.25F;
                this.field_9093_l.func_514_a("bubble", this.field_322_l - this.field_319_o * (double)var20, this.field_321_m - this.field_318_p * (double)var20, this.field_320_n - this.field_317_q * (double)var20, this.field_319_o, this.field_318_p, this.field_317_q);
            }

            var18 = 0.8F;
        }

        this.field_319_o *= (double)var18;
        this.field_318_p *= (double)var18;
        this.field_317_q *= (double)var18;
        this.field_318_p -= (double)var19;
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_394_a("xTile", (short)this.field_456_b);
        var1.func_394_a("yTile", (short)this.field_461_ad);
        var1.func_394_a("zTile", (short)this.field_460_ae);
        var1.func_409_a("inTile", (byte)this.field_459_af);
        var1.func_409_a("shake", (byte)this.field_458_a);
        var1.func_409_a("inGround", (byte)(this.field_457_ag ? 1 : 0));
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_456_b = var1.func_406_c("xTile");
        this.field_461_ad = var1.func_406_c("yTile");
        this.field_460_ae = var1.func_406_c("zTile");
        this.field_459_af = var1.func_408_b("inTile") & 255;
        this.field_458_a = var1.func_408_b("shake") & 255;
        this.field_457_ag = var1.func_408_b("inGround") == 1;
    }

    public void func_6093_b(EntityPlayer var1) {
        if (this.field_457_ag && this.field_455_ah == var1 && this.field_458_a <= 0 && var1.field_416_aj.func_201_a(new ItemStack(Item.field_4148_j, 1))) {
            this.field_9093_l.func_506_a(this, "random.pop", 0.2F, ((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var1.func_163_c(this, 1);
            this.func_118_j();
        }

    }
}
