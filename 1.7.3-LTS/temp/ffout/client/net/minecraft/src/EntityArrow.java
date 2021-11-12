package net.minecraft.src;

import java.util.List;

public class EntityArrow extends Entity {
    private int field_9319_c = -1;
    private int field_9318_d = -1;
    private int field_9317_e = -1;
    private int field_9316_f = 0;
    private int field_28019_h = 0;
    private boolean field_9315_g = false;
    public boolean field_28020_a = false;
    public int field_688_a = 0;
    public EntityLiving field_682_g;
    private int field_681_h;
    private int field_680_i = 0;

    public EntityArrow(World var1) {
        super(var1);
        this.func_371_a(0.5F, 0.5F);
    }

    public EntityArrow(World var1, double var2, double var4, double var6) {
        super(var1);
        this.func_371_a(0.5F, 0.5F);
        this.func_347_a(var2, var4, var6);
        this.field_9292_aO = 0.0F;
    }

    public EntityArrow(World var1, EntityLiving var2) {
        super(var1);
        this.field_682_g = var2;
        this.field_28020_a = var2 instanceof EntityPlayer;
        this.func_371_a(0.5F, 0.5F);
        this.func_365_c(var2.field_611_ak, var2.field_610_al + (double)var2.func_373_s(), var2.field_609_am, var2.field_605_aq, var2.field_604_ar);
        this.field_611_ak -= (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
        this.field_610_al -= 0.10000000149011612D;
        this.field_609_am -= (double)(MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
        this.field_9292_aO = 0.0F;
        this.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F));
        this.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F));
        this.field_607_ao = (double)(-MathHelper.func_1106_a(this.field_604_ar / 180.0F * 3.1415927F));
        this.func_408_a(this.field_608_an, this.field_607_ao, this.field_606_ap, 1.5F, 1.0F);
    }

    protected void func_21057_b() {
    }

    public void func_408_a(double var1, double var3, double var5, float var7, float var8) {
        float var9 = MathHelper.func_1109_a(var1 * var1 + var3 * var3 + var5 * var5);
        var1 /= (double)var9;
        var3 /= (double)var9;
        var5 /= (double)var9;
        var1 += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)var8;
        var3 += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)var8;
        var5 += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)var8;
        var1 *= (double)var7;
        var3 *= (double)var7;
        var5 *= (double)var7;
        this.field_608_an = var1;
        this.field_607_ao = var3;
        this.field_606_ap = var5;
        float var10 = MathHelper.func_1109_a(var1 * var1 + var5 * var5);
        this.field_603_as = this.field_605_aq = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
        this.field_602_at = this.field_604_ar = (float)(Math.atan2(var3, (double)var10) * 180.0D / 3.1415927410125732D);
        this.field_681_h = 0;
    }

    public void func_6375_a(double var1, double var3, double var5) {
        this.field_608_an = var1;
        this.field_607_ao = var3;
        this.field_606_ap = var5;
        if (this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
            float var7 = MathHelper.func_1109_a(var1 * var1 + var5 * var5);
            this.field_603_as = this.field_605_aq = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
            this.field_602_at = this.field_604_ar = (float)(Math.atan2(var3, (double)var7) * 180.0D / 3.1415927410125732D);
            this.field_602_at = this.field_604_ar;
            this.field_603_as = this.field_605_aq;
            this.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar);
            this.field_681_h = 0;
        }

    }

    public void func_370_e_() {
        super.func_370_e_();
        if (this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
            float var1 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
            this.field_603_as = this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);
            this.field_602_at = this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var1) * 180.0D / 3.1415927410125732D);
        }

        int var15 = this.field_615_ag.func_600_a(this.field_9319_c, this.field_9318_d, this.field_9317_e);
        if (var15 > 0) {
            Block.field_345_n[var15].func_238_a(this.field_615_ag, this.field_9319_c, this.field_9318_d, this.field_9317_e);
            AxisAlignedBB var2 = Block.field_345_n[var15].func_221_d(this.field_615_ag, this.field_9319_c, this.field_9318_d, this.field_9317_e);
            if (var2 != null && var2.func_4150_a(Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am))) {
                this.field_9315_g = true;
            }
        }

        if (this.field_688_a > 0) {
            --this.field_688_a;
        }

        if (this.field_9315_g) {
            var15 = this.field_615_ag.func_600_a(this.field_9319_c, this.field_9318_d, this.field_9317_e);
            int var18 = this.field_615_ag.func_602_e(this.field_9319_c, this.field_9318_d, this.field_9317_e);
            if (var15 == this.field_9316_f && var18 == this.field_28019_h) {
                ++this.field_681_h;
                if (this.field_681_h == 1200) {
                    this.func_395_F();
                }

            } else {
                this.field_9315_g = false;
                this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
                this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
                this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
                this.field_681_h = 0;
                this.field_680_i = 0;
            }
        } else {
            ++this.field_680_i;
            Vec3D var16 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
            Vec3D var17 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
            MovingObjectPosition var3 = this.field_615_ag.func_28105_a(var16, var17, false, true);
            var16 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
            var17 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
            if (var3 != null) {
                var17 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
            }

            Entity var4 = null;
            List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
            double var6 = 0.0D;

            float var10;
            for(int var8 = 0; var8 < var5.size(); ++var8) {
                Entity var9 = (Entity)var5.get(var8);
                if (var9.func_401_c_() && (var9 != this.field_682_g || this.field_680_i >= 5)) {
                    var10 = 0.3F;
                    AxisAlignedBB var11 = var9.field_601_au.func_1177_b((double)var10, (double)var10, (double)var10);
                    MovingObjectPosition var12 = var11.func_1169_a(var16, var17);
                    if (var12 != null) {
                        double var13 = var16.func_1251_c(var12.field_1169_f);
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
                if (var3.field_1168_g != null) {
                    if (var3.field_1168_g.func_396_a(this.field_682_g, 4)) {
                        this.field_615_ag.func_623_a(this, "random.drr", 1.0F, 1.2F / (this.field_9312_bd.nextFloat() * 0.2F + 0.9F));
                        this.func_395_F();
                    } else {
                        this.field_608_an *= -0.10000000149011612D;
                        this.field_607_ao *= -0.10000000149011612D;
                        this.field_606_ap *= -0.10000000149011612D;
                        this.field_605_aq += 180.0F;
                        this.field_603_as += 180.0F;
                        this.field_680_i = 0;
                    }
                } else {
                    this.field_9319_c = var3.field_1166_b;
                    this.field_9318_d = var3.field_1172_c;
                    this.field_9317_e = var3.field_1171_d;
                    this.field_9316_f = this.field_615_ag.func_600_a(this.field_9319_c, this.field_9318_d, this.field_9317_e);
                    this.field_28019_h = this.field_615_ag.func_602_e(this.field_9319_c, this.field_9318_d, this.field_9317_e);
                    this.field_608_an = (double)((float)(var3.field_1169_f.field_1776_a - this.field_611_ak));
                    this.field_607_ao = (double)((float)(var3.field_1169_f.field_1775_b - this.field_610_al));
                    this.field_606_ap = (double)((float)(var3.field_1169_f.field_1779_c - this.field_609_am));
                    var19 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_607_ao * this.field_607_ao + this.field_606_ap * this.field_606_ap);
                    this.field_611_ak -= this.field_608_an / (double)var19 * 0.05000000074505806D;
                    this.field_610_al -= this.field_607_ao / (double)var19 * 0.05000000074505806D;
                    this.field_609_am -= this.field_606_ap / (double)var19 * 0.05000000074505806D;
                    this.field_615_ag.func_623_a(this, "random.drr", 1.0F, 1.2F / (this.field_9312_bd.nextFloat() * 0.2F + 0.9F));
                    this.field_9315_g = true;
                    this.field_688_a = 7;
                }
            }

            this.field_611_ak += this.field_608_an;
            this.field_610_al += this.field_607_ao;
            this.field_609_am += this.field_606_ap;
            var19 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
            this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

            for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var19) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
            }

            while(this.field_604_ar - this.field_602_at >= 180.0F) {
                this.field_602_at += 360.0F;
            }

            while(this.field_605_aq - this.field_603_as < -180.0F) {
                this.field_603_as -= 360.0F;
            }

            while(this.field_605_aq - this.field_603_as >= 180.0F) {
                this.field_603_as += 360.0F;
            }

            this.field_604_ar = this.field_602_at + (this.field_604_ar - this.field_602_at) * 0.2F;
            this.field_605_aq = this.field_603_as + (this.field_605_aq - this.field_603_as) * 0.2F;
            float var20 = 0.99F;
            var10 = 0.03F;
            if (this.func_27013_ag()) {
                for(int var21 = 0; var21 < 4; ++var21) {
                    float var22 = 0.25F;
                    this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var22, this.field_610_al - this.field_607_ao * (double)var22, this.field_609_am - this.field_606_ap * (double)var22, this.field_608_an, this.field_607_ao, this.field_606_ap);
                }

                var20 = 0.8F;
            }

            this.field_608_an *= (double)var20;
            this.field_607_ao *= (double)var20;
            this.field_606_ap *= (double)var20;
            this.field_607_ao -= (double)var10;
            this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
        }
    }

    public void func_352_a(NBTTagCompound var1) {
        var1.func_749_a("xTile", (short)this.field_9319_c);
        var1.func_749_a("yTile", (short)this.field_9318_d);
        var1.func_749_a("zTile", (short)this.field_9317_e);
        var1.func_761_a("inTile", (byte)this.field_9316_f);
        var1.func_761_a("inData", (byte)this.field_28019_h);
        var1.func_761_a("shake", (byte)this.field_688_a);
        var1.func_761_a("inGround", (byte)(this.field_9315_g ? 1 : 0));
        var1.func_748_a("player", this.field_28020_a);
    }

    public void func_357_b(NBTTagCompound var1) {
        this.field_9319_c = var1.func_745_d("xTile");
        this.field_9318_d = var1.func_745_d("yTile");
        this.field_9317_e = var1.func_745_d("zTile");
        this.field_9316_f = var1.func_746_c("inTile") & 255;
        this.field_28019_h = var1.func_746_c("inData") & 255;
        this.field_688_a = var1.func_746_c("shake") & 255;
        this.field_9315_g = var1.func_746_c("inGround") == 1;
        this.field_28020_a = var1.func_760_m("player");
    }

    public void func_6378_b(EntityPlayer var1) {
        if (!this.field_615_ag.field_1026_y) {
            if (this.field_9315_g && this.field_28020_a && this.field_688_a <= 0 && var1.field_778_b.func_504_a(new ItemStack(Item.field_226_j, 1))) {
                this.field_615_ag.func_623_a(this, "random.pop", 0.2F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                var1.func_443_a_(this, 1);
                this.func_395_F();
            }

        }
    }

    public float func_392_h_() {
        return 0.0F;
    }
}
