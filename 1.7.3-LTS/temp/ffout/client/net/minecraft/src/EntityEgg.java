package net.minecraft.src;

import java.util.List;

public class EntityEgg extends Entity {
    private int field_20056_b = -1;
    private int field_20055_c = -1;
    private int field_20054_d = -1;
    private int field_20053_e = 0;
    private boolean field_20052_f = false;
    public int field_20057_a = 0;
    private EntityLiving field_20051_g;
    private int field_20050_h;
    private int field_20049_i = 0;

    public EntityEgg(World var1) {
        super(var1);
        this.func_371_a(0.25F, 0.25F);
    }

    protected void func_21057_b() {
    }

    public boolean func_384_a(double var1) {
        double var3 = this.field_601_au.func_1164_b() * 4.0D;
        var3 *= 64.0D;
        return var1 < var3 * var3;
    }

    public EntityEgg(World var1, EntityLiving var2) {
        super(var1);
        this.field_20051_g = var2;
        this.func_371_a(0.25F, 0.25F);
        this.func_365_c(var2.field_611_ak, var2.field_610_al + (double)var2.func_373_s(), var2.field_609_am, var2.field_605_aq, var2.field_604_ar);
        this.field_611_ak -= (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
        this.field_610_al -= 0.10000000149011612D;
        this.field_609_am -= (double)(MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
        this.field_9292_aO = 0.0F;
        float var3 = 0.4F;
        this.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var3);
        this.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var3);
        this.field_607_ao = (double)(-MathHelper.func_1106_a(this.field_604_ar / 180.0F * 3.1415927F) * var3);
        this.func_20048_a(this.field_608_an, this.field_607_ao, this.field_606_ap, 1.5F, 1.0F);
    }

    public EntityEgg(World var1, double var2, double var4, double var6) {
        super(var1);
        this.field_20050_h = 0;
        this.func_371_a(0.25F, 0.25F);
        this.func_347_a(var2, var4, var6);
        this.field_9292_aO = 0.0F;
    }

    public void func_20048_a(double var1, double var3, double var5, float var7, float var8) {
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
        this.field_20050_h = 0;
    }

    public void func_6375_a(double var1, double var3, double var5) {
        this.field_608_an = var1;
        this.field_607_ao = var3;
        this.field_606_ap = var5;
        if (this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
            float var7 = MathHelper.func_1109_a(var1 * var1 + var5 * var5);
            this.field_603_as = this.field_605_aq = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
            this.field_602_at = this.field_604_ar = (float)(Math.atan2(var3, (double)var7) * 180.0D / 3.1415927410125732D);
        }

    }

    public void func_370_e_() {
        this.field_638_aI = this.field_611_ak;
        this.field_637_aJ = this.field_610_al;
        this.field_636_aK = this.field_609_am;
        super.func_370_e_();
        if (this.field_20057_a > 0) {
            --this.field_20057_a;
        }

        if (this.field_20052_f) {
            int var1 = this.field_615_ag.func_600_a(this.field_20056_b, this.field_20055_c, this.field_20054_d);
            if (var1 == this.field_20053_e) {
                ++this.field_20050_h;
                if (this.field_20050_h == 1200) {
                    this.func_395_F();
                }

                return;
            }

            this.field_20052_f = false;
            this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_20050_h = 0;
            this.field_20049_i = 0;
        } else {
            ++this.field_20049_i;
        }

        Vec3D var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
        Vec3D var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
        MovingObjectPosition var3 = this.field_615_ag.func_645_a(var15, var2);
        var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
        var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
        if (var3 != null) {
            var2 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
        }

        if (!this.field_615_ag.field_1026_y) {
            Entity var4 = null;
            List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
            double var6 = 0.0D;

            for(int var8 = 0; var8 < var5.size(); ++var8) {
                Entity var9 = (Entity)var5.get(var8);
                if (var9.func_401_c_() && (var9 != this.field_20051_g || this.field_20049_i >= 5)) {
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
        }

        if (var3 != null) {
            if (var3.field_1168_g != null && var3.field_1168_g.func_396_a(this.field_20051_g, 0)) {
            }

            if (!this.field_615_ag.field_1026_y && this.field_9312_bd.nextInt(8) == 0) {
                byte var16 = 1;
                if (this.field_9312_bd.nextInt(32) == 0) {
                    var16 = 4;
                }

                for(int var17 = 0; var17 < var16; ++var17) {
                    EntityChicken var21 = new EntityChicken(this.field_615_ag);
                    var21.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, 0.0F);
                    this.field_615_ag.func_674_a(var21);
                }
            }

            for(int var18 = 0; var18 < 8; ++var18) {
                this.field_615_ag.func_694_a("snowballpoof", this.field_611_ak, this.field_610_al, this.field_609_am, 0.0D, 0.0D, 0.0D);
            }

            this.func_395_F();
        }

        this.field_611_ak += this.field_608_an;
        this.field_610_al += this.field_607_ao;
        this.field_609_am += this.field_606_ap;
        float var20 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
        this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

        for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var20) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
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
        float var19 = 0.99F;
        float var22 = 0.03F;
        if (this.func_27013_ag()) {
            for(int var7 = 0; var7 < 4; ++var7) {
                float var23 = 0.25F;
                this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var23, this.field_610_al - this.field_607_ao * (double)var23, this.field_609_am - this.field_606_ap * (double)var23, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }

            var19 = 0.8F;
        }

        this.field_608_an *= (double)var19;
        this.field_607_ao *= (double)var19;
        this.field_606_ap *= (double)var19;
        this.field_607_ao -= (double)var22;
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
    }

    public void func_352_a(NBTTagCompound var1) {
        var1.func_749_a("xTile", (short)this.field_20056_b);
        var1.func_749_a("yTile", (short)this.field_20055_c);
        var1.func_749_a("zTile", (short)this.field_20054_d);
        var1.func_761_a("inTile", (byte)this.field_20053_e);
        var1.func_761_a("shake", (byte)this.field_20057_a);
        var1.func_761_a("inGround", (byte)(this.field_20052_f ? 1 : 0));
    }

    public void func_357_b(NBTTagCompound var1) {
        this.field_20056_b = var1.func_745_d("xTile");
        this.field_20055_c = var1.func_745_d("yTile");
        this.field_20054_d = var1.func_745_d("zTile");
        this.field_20053_e = var1.func_746_c("inTile") & 255;
        this.field_20057_a = var1.func_746_c("shake") & 255;
        this.field_20052_f = var1.func_746_c("inGround") == 1;
    }

    public void func_6378_b(EntityPlayer var1) {
        if (this.field_20052_f && this.field_20051_g == var1 && this.field_20057_a <= 0 && var1.field_778_b.func_504_a(new ItemStack(Item.field_226_j, 1))) {
            this.field_615_ag.func_623_a(this, "random.pop", 0.2F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var1.func_443_a_(this, 1);
            this.func_395_F();
        }

    }

    public float func_392_h_() {
        return 0.0F;
    }
}
