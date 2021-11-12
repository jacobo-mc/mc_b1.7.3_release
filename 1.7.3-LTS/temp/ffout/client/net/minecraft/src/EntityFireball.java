package net.minecraft.src;

import java.util.List;

public class EntityFireball extends Entity {
    private int field_9402_e = -1;
    private int field_9401_f = -1;
    private int field_9400_g = -1;
    private int field_9399_h = 0;
    private boolean field_9398_i = false;
    public int field_9406_a = 0;
    public EntityLiving field_9397_j;
    private int field_9396_k;
    private int field_9395_l = 0;
    public double field_9405_b;
    public double field_9404_c;
    public double field_9403_d;

    public EntityFireball(World var1) {
        super(var1);
        this.func_371_a(1.0F, 1.0F);
    }

    protected void func_21057_b() {
    }

    public boolean func_384_a(double var1) {
        double var3 = this.field_601_au.func_1164_b() * 4.0D;
        var3 *= 64.0D;
        return var1 < var3 * var3;
    }

    public EntityFireball(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1);
        this.func_371_a(1.0F, 1.0F);
        this.func_365_c(var2, var4, var6, this.field_605_aq, this.field_604_ar);
        this.func_347_a(var2, var4, var6);
        double var14 = (double)MathHelper.func_1109_a(var8 * var8 + var10 * var10 + var12 * var12);
        this.field_9405_b = var8 / var14 * 0.1D;
        this.field_9404_c = var10 / var14 * 0.1D;
        this.field_9403_d = var12 / var14 * 0.1D;
    }

    public EntityFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
        super(var1);
        this.field_9397_j = var2;
        this.func_371_a(1.0F, 1.0F);
        this.func_365_c(var2.field_611_ak, var2.field_610_al, var2.field_609_am, var2.field_605_aq, var2.field_604_ar);
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
        this.field_9292_aO = 0.0F;
        this.field_608_an = this.field_607_ao = this.field_606_ap = 0.0D;
        var3 += this.field_9312_bd.nextGaussian() * 0.4D;
        var5 += this.field_9312_bd.nextGaussian() * 0.4D;
        var7 += this.field_9312_bd.nextGaussian() * 0.4D;
        double var9 = (double)MathHelper.func_1109_a(var3 * var3 + var5 * var5 + var7 * var7);
        this.field_9405_b = var3 / var9 * 0.1D;
        this.field_9404_c = var5 / var9 * 0.1D;
        this.field_9403_d = var7 / var9 * 0.1D;
    }

    public void func_370_e_() {
        super.func_370_e_();
        this.field_9309_bg = 10;
        if (this.field_9406_a > 0) {
            --this.field_9406_a;
        }

        if (this.field_9398_i) {
            int var1 = this.field_615_ag.func_600_a(this.field_9402_e, this.field_9401_f, this.field_9400_g);
            if (var1 == this.field_9399_h) {
                ++this.field_9396_k;
                if (this.field_9396_k == 1200) {
                    this.func_395_F();
                }

                return;
            }

            this.field_9398_i = false;
            this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_9396_k = 0;
            this.field_9395_l = 0;
        } else {
            ++this.field_9395_l;
        }

        Vec3D var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
        Vec3D var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
        MovingObjectPosition var3 = this.field_615_ag.func_645_a(var15, var2);
        var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
        var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
        if (var3 != null) {
            var2 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
        }

        Entity var4 = null;
        List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
        double var6 = 0.0D;

        for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if (var9.func_401_c_() && (var9 != this.field_9397_j || this.field_9395_l >= 25)) {
                float var10 = 0.3F;
                AxisAlignedBB var11 = var9.field_601_au.func_1177_b((double)var10, (double)var10, (double)var10);
                MovingObjectPosition var12 = var11.func_1169_a(var15, var2);
                if (var12 != null) {
                    double var13 = var15.func_1251_c(var12.field_1169_f);
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
            if (!this.field_615_ag.field_1026_y) {
                if (var3.field_1168_g != null && var3.field_1168_g.func_396_a(this.field_9397_j, 0)) {
                }

                this.field_615_ag.func_12244_a((Entity)null, this.field_611_ak, this.field_610_al, this.field_609_am, 1.0F, true);
            }

            this.func_395_F();
        }

        this.field_611_ak += this.field_608_an;
        this.field_610_al += this.field_607_ao;
        this.field_609_am += this.field_606_ap;
        float var16 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
        this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

        for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var16) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
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
        float var17 = 0.95F;
        if (this.func_27013_ag()) {
            for(int var18 = 0; var18 < 4; ++var18) {
                float var19 = 0.25F;
                this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var19, this.field_610_al - this.field_607_ao * (double)var19, this.field_609_am - this.field_606_ap * (double)var19, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }

            var17 = 0.8F;
        }

        this.field_608_an += this.field_9405_b;
        this.field_607_ao += this.field_9404_c;
        this.field_606_ap += this.field_9403_d;
        this.field_608_an *= (double)var17;
        this.field_607_ao *= (double)var17;
        this.field_606_ap *= (double)var17;
        this.field_615_ag.func_694_a("smoke", this.field_611_ak, this.field_610_al + 0.5D, this.field_609_am, 0.0D, 0.0D, 0.0D);
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
    }

    public void func_352_a(NBTTagCompound var1) {
        var1.func_749_a("xTile", (short)this.field_9402_e);
        var1.func_749_a("yTile", (short)this.field_9401_f);
        var1.func_749_a("zTile", (short)this.field_9400_g);
        var1.func_761_a("inTile", (byte)this.field_9399_h);
        var1.func_761_a("shake", (byte)this.field_9406_a);
        var1.func_761_a("inGround", (byte)(this.field_9398_i ? 1 : 0));
    }

    public void func_357_b(NBTTagCompound var1) {
        this.field_9402_e = var1.func_745_d("xTile");
        this.field_9401_f = var1.func_745_d("yTile");
        this.field_9400_g = var1.func_745_d("zTile");
        this.field_9399_h = var1.func_746_c("inTile") & 255;
        this.field_9406_a = var1.func_746_c("shake") & 255;
        this.field_9398_i = var1.func_746_c("inGround") == 1;
    }

    public boolean func_401_c_() {
        return true;
    }

    public float func_4035_j_() {
        return 1.0F;
    }

    public boolean func_396_a(Entity var1, int var2) {
        this.func_9281_M();
        if (var1 != null) {
            Vec3D var3 = var1.func_4037_H();
            if (var3 != null) {
                this.field_608_an = var3.field_1776_a;
                this.field_607_ao = var3.field_1775_b;
                this.field_606_ap = var3.field_1779_c;
                this.field_9405_b = this.field_608_an * 0.1D;
                this.field_9404_c = this.field_607_ao * 0.1D;
                this.field_9403_d = this.field_606_ap * 0.1D;
            }

            return true;
        } else {
            return false;
        }
    }

    public float func_392_h_() {
        return 0.0F;
    }
}
