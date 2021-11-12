package net.minecraft.src;

import java.util.List;

public class EntityArrow extends Entity {
    private int field_9183_c = -1;
    private int field_9182_d = -1;
    private int field_9180_e = -1;
    private int field_9179_f = 0;
    private int field_28011_h = 0;
    private boolean field_9181_aj = false;
    public boolean field_28012_a = false;
    public int field_9184_a = 0;
    public EntityLiving field_439_ah;
    private int field_438_ai;
    private int field_437_aj = 0;

    public EntityArrow(World var1) {
        super(var1);
        this.func_113_a(0.5F, 0.5F);
    }

    public EntityArrow(World var1, double var2, double var4, double var6) {
        super(var1);
        this.func_113_a(0.5F, 0.5F);
        this.func_86_a(var2, var4, var6);
        this.field_9076_H = 0.0F;
    }

    public EntityArrow(World var1, EntityLiving var2) {
        super(var1);
        this.field_439_ah = var2;
        this.field_28012_a = var2 instanceof EntityPlayer;
        this.func_113_a(0.5F, 0.5F);
        this.func_107_c(var2.field_322_l, var2.field_321_m + (double)var2.func_104_p(), var2.field_320_n, var2.field_316_r, var2.field_315_s);
        this.field_322_l -= (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * 0.16F);
        this.field_321_m -= 0.10000000149011612D;
        this.field_320_n -= (double)(MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * 0.16F);
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        this.field_9076_H = 0.0F;
        this.field_319_o = (double)(-MathHelper.func_585_a(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F));
        this.field_317_q = (double)(MathHelper.func_582_b(this.field_316_r / 180.0F * 3.1415927F) * MathHelper.func_582_b(this.field_315_s / 180.0F * 3.1415927F));
        this.field_318_p = (double)(-MathHelper.func_585_a(this.field_315_s / 180.0F * 3.1415927F));
        this.func_177_a(this.field_319_o, this.field_318_p, this.field_317_q, 1.5F, 1.0F);
    }

    protected void func_21044_a() {
    }

    public void func_177_a(double var1, double var3, double var5, float var7, float var8) {
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
        this.field_438_ai = 0;
    }

    public void func_106_b_() {
        super.func_106_b_();
        if (this.field_9088_y == 0.0F && this.field_9089_x == 0.0F) {
            float var1 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
            this.field_9089_x = this.field_316_r = (float)(Math.atan2(this.field_319_o, this.field_317_q) * 180.0D / 3.1415927410125732D);
            this.field_9088_y = this.field_315_s = (float)(Math.atan2(this.field_318_p, (double)var1) * 180.0D / 3.1415927410125732D);
        }

        int var15 = this.field_9093_l.func_444_a(this.field_9183_c, this.field_9182_d, this.field_9180_e);
        if (var15 > 0) {
            Block.field_542_n[var15].func_233_a(this.field_9093_l, this.field_9183_c, this.field_9182_d, this.field_9180_e);
            AxisAlignedBB var2 = Block.field_542_n[var15].func_248_d(this.field_9093_l, this.field_9183_c, this.field_9182_d, this.field_9180_e);
            if (var2 != null && var2.func_28183_a(Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n))) {
                this.field_9181_aj = true;
            }
        }

        if (this.field_9184_a > 0) {
            --this.field_9184_a;
        }

        if (this.field_9181_aj) {
            var15 = this.field_9093_l.func_444_a(this.field_9183_c, this.field_9182_d, this.field_9180_e);
            int var18 = this.field_9093_l.func_446_b(this.field_9183_c, this.field_9182_d, this.field_9180_e);
            if (var15 == this.field_9179_f && var18 == this.field_28011_h) {
                ++this.field_438_ai;
                if (this.field_438_ai == 1200) {
                    this.func_118_j();
                }

            } else {
                this.field_9181_aj = false;
                this.field_319_o *= (double)(this.field_9064_W.nextFloat() * 0.2F);
                this.field_318_p *= (double)(this.field_9064_W.nextFloat() * 0.2F);
                this.field_317_q *= (double)(this.field_9064_W.nextFloat() * 0.2F);
                this.field_438_ai = 0;
                this.field_437_aj = 0;
            }
        } else {
            ++this.field_437_aj;
            Vec3D var16 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
            Vec3D var17 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
            MovingObjectPosition var3 = this.field_9093_l.func_28099_a(var16, var17, false, true);
            var16 = Vec3D.func_768_b(this.field_322_l, this.field_321_m, this.field_320_n);
            var17 = Vec3D.func_768_b(this.field_322_l + this.field_319_o, this.field_321_m + this.field_318_p, this.field_320_n + this.field_317_q);
            if (var3 != null) {
                var17 = Vec3D.func_768_b(var3.field_929_f.field_1055_a, var3.field_929_f.field_1054_b, var3.field_929_f.field_1058_c);
            }

            Entity var4 = null;
            List var5 = this.field_9093_l.func_450_b(this, this.field_312_v.func_700_a(this.field_319_o, this.field_318_p, this.field_317_q).func_708_b(1.0D, 1.0D, 1.0D));
            double var6 = 0.0D;

            float var10;
            for(int var8 = 0; var8 < var5.size(); ++var8) {
                Entity var9 = (Entity)var5.get(var8);
                if (var9.func_129_c_() && (var9 != this.field_439_ah || this.field_437_aj >= 5)) {
                    var10 = 0.3F;
                    AxisAlignedBB var11 = var9.field_312_v.func_708_b((double)var10, (double)var10, (double)var10);
                    MovingObjectPosition var12 = var11.func_706_a(var16, var17);
                    if (var12 != null) {
                        double var13 = var16.func_767_a(var12.field_929_f);
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

            float var19;
            if (var3 != null) {
                if (var3.field_928_g != null) {
                    if (var3.field_928_g.func_121_a(this.field_439_ah, 4)) {
                        this.field_9093_l.func_506_a(this, "random.drr", 1.0F, 1.2F / (this.field_9064_W.nextFloat() * 0.2F + 0.9F));
                        this.func_118_j();
                    } else {
                        this.field_319_o *= -0.10000000149011612D;
                        this.field_318_p *= -0.10000000149011612D;
                        this.field_317_q *= -0.10000000149011612D;
                        this.field_316_r += 180.0F;
                        this.field_9089_x += 180.0F;
                        this.field_437_aj = 0;
                    }
                } else {
                    this.field_9183_c = var3.field_926_b;
                    this.field_9182_d = var3.field_932_c;
                    this.field_9180_e = var3.field_931_d;
                    this.field_9179_f = this.field_9093_l.func_444_a(this.field_9183_c, this.field_9182_d, this.field_9180_e);
                    this.field_28011_h = this.field_9093_l.func_446_b(this.field_9183_c, this.field_9182_d, this.field_9180_e);
                    this.field_319_o = (double)((float)(var3.field_929_f.field_1055_a - this.field_322_l));
                    this.field_318_p = (double)((float)(var3.field_929_f.field_1054_b - this.field_321_m));
                    this.field_317_q = (double)((float)(var3.field_929_f.field_1058_c - this.field_320_n));
                    var19 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_318_p * this.field_318_p + this.field_317_q * this.field_317_q);
                    this.field_322_l -= this.field_319_o / (double)var19 * 0.05000000074505806D;
                    this.field_321_m -= this.field_318_p / (double)var19 * 0.05000000074505806D;
                    this.field_320_n -= this.field_317_q / (double)var19 * 0.05000000074505806D;
                    this.field_9093_l.func_506_a(this, "random.drr", 1.0F, 1.2F / (this.field_9064_W.nextFloat() * 0.2F + 0.9F));
                    this.field_9181_aj = true;
                    this.field_9184_a = 7;
                }
            }

            this.field_322_l += this.field_319_o;
            this.field_321_m += this.field_318_p;
            this.field_320_n += this.field_317_q;
            var19 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
            this.field_316_r = (float)(Math.atan2(this.field_319_o, this.field_317_q) * 180.0D / 3.1415927410125732D);

            for(this.field_315_s = (float)(Math.atan2(this.field_318_p, (double)var19) * 180.0D / 3.1415927410125732D); this.field_315_s - this.field_9088_y < -180.0F; this.field_9088_y -= 360.0F) {
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
            float var20 = 0.99F;
            var10 = 0.03F;
            if (this.func_27011_Z()) {
                for(int var21 = 0; var21 < 4; ++var21) {
                    float var22 = 0.25F;
                    this.field_9093_l.func_514_a("bubble", this.field_322_l - this.field_319_o * (double)var22, this.field_321_m - this.field_318_p * (double)var22, this.field_320_n - this.field_317_q * (double)var22, this.field_319_o, this.field_318_p, this.field_317_q);
                }

                var20 = 0.8F;
            }

            this.field_319_o *= (double)var20;
            this.field_318_p *= (double)var20;
            this.field_317_q *= (double)var20;
            this.field_318_p -= (double)var10;
            this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
        }
    }

    public void func_97_a(NBTTagCompound var1) {
        var1.func_394_a("xTile", (short)this.field_9183_c);
        var1.func_394_a("yTile", (short)this.field_9182_d);
        var1.func_394_a("zTile", (short)this.field_9180_e);
        var1.func_409_a("inTile", (byte)this.field_9179_f);
        var1.func_409_a("inData", (byte)this.field_28011_h);
        var1.func_409_a("shake", (byte)this.field_9184_a);
        var1.func_409_a("inGround", (byte)(this.field_9181_aj ? 1 : 0));
        var1.func_393_a("player", this.field_28012_a);
    }

    public void func_99_b(NBTTagCompound var1) {
        this.field_9183_c = var1.func_406_c("xTile");
        this.field_9182_d = var1.func_406_c("yTile");
        this.field_9180_e = var1.func_406_c("zTile");
        this.field_9179_f = var1.func_408_b("inTile") & 255;
        this.field_28011_h = var1.func_408_b("inData") & 255;
        this.field_9184_a = var1.func_408_b("shake") & 255;
        this.field_9181_aj = var1.func_408_b("inGround") == 1;
        this.field_28012_a = var1.func_402_l("player");
    }

    public void func_6093_b(EntityPlayer var1) {
        if (!this.field_9093_l.field_792_x) {
            if (this.field_9181_aj && this.field_28012_a && this.field_9184_a <= 0 && var1.field_416_aj.func_201_a(new ItemStack(Item.field_4148_j, 1))) {
                this.field_9093_l.func_506_a(this, "random.pop", 0.2F, ((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                var1.func_163_c(this, 1);
                this.func_118_j();
            }

        }
    }
}
