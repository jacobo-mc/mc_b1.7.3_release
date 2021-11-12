package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class EntityWolf extends EntityAnimal {
    private boolean field_25049_a = false;
    private float field_25048_b;
    private float field_25054_c;
    private boolean field_25053_f;
    private boolean field_25052_g;
    private float field_25051_h;
    private float field_25050_i;

    public EntityWolf(World var1) {
        super(var1);
        this.field_9357_z = "/mob/wolf.png";
        this.func_371_a(0.8F, 0.8F);
        this.field_9333_am = 1.1F;
        this.field_9337_J = 8;
    }

    protected void func_21057_b() {
        super.func_21057_b();
        this.field_21064_bx.func_21124_a(16, (byte)0);
        this.field_21064_bx.func_21124_a(17, "");
        this.field_21064_bx.func_21124_a(18, new Integer(this.field_9337_J));
    }

    protected boolean func_25021_m() {
        return false;
    }

    public String func_6376_z() {
        if (this.func_25047_D()) {
            return "/mob/wolf_tame.png";
        } else {
            return this.func_25040_C() ? "/mob/wolf_angry.png" : super.func_6376_z();
        }
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_748_a("Angry", this.func_25040_C());
        var1.func_748_a("Sitting", this.func_25034_B());
        if (this.func_25045_A() == null) {
            var1.func_754_a("Owner", "");
        } else {
            var1.func_754_a("Owner", this.func_25045_A());
        }

    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.func_25041_c(var1.func_760_m("Angry"));
        this.func_25046_b(var1.func_760_m("Sitting"));
        String var2 = var1.func_755_i("Owner");
        if (var2.length() > 0) {
            this.func_25036_a(var2);
            this.func_25038_d(true);
        }

    }

    protected boolean func_25023_u() {
        return !this.func_25047_D();
    }

    protected String func_6389_d() {
        if (this.func_25040_C()) {
            return "mob.wolf.growl";
        } else if (this.field_9312_bd.nextInt(3) == 0) {
            return this.func_25047_D() && this.field_21064_bx.func_25115_b(18) < 10 ? "mob.wolf.whine" : "mob.wolf.panting";
        } else {
            return "mob.wolf.bark";
        }
    }

    protected String func_6394_f_() {
        return "mob.wolf.hurt";
    }

    protected String func_6390_f() {
        return "mob.wolf.death";
    }

    protected float func_6393_h() {
        return 0.4F;
    }

    protected int func_422_g() {
        return -1;
    }

    protected void func_418_b_() {
        super.func_418_b_();
        if (!this.field_750_g && !this.func_25031_E() && this.func_25047_D() && this.field_616_af == null) {
            EntityPlayer var3 = this.field_615_ag.func_25099_a(this.func_25045_A());
            if (var3 != null) {
                float var2 = var3.func_379_d(this);
                if (var2 > 5.0F) {
                    this.func_25044_b(var3, var2);
                }
            } else if (!this.func_27013_ag()) {
                this.func_25046_b(true);
            }
        } else if (this.field_751_f == null && !this.func_25031_E() && !this.func_25047_D() && this.field_615_ag.field_1037_n.nextInt(100) == 0) {
            List var1 = this.field_615_ag.func_657_a(EntitySheep.class, AxisAlignedBB.func_1161_b(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_611_ak + 1.0D, this.field_610_al + 1.0D, this.field_609_am + 1.0D).func_1177_b(16.0D, 4.0D, 16.0D));
            if (!var1.isEmpty()) {
                this.func_25032_c((Entity)var1.get(this.field_615_ag.field_1037_n.nextInt(var1.size())));
            }
        }

        if (this.func_27013_ag()) {
            this.func_25046_b(false);
        }

        if (!this.field_615_ag.field_1026_y) {
            this.field_21064_bx.func_21129_b(18, this.field_9337_J);
        }

    }

    public void func_425_j() {
        super.func_425_j();
        this.field_25049_a = false;
        if (this.func_25025_V() && !this.func_25031_E() && !this.func_25040_C()) {
            Entity var1 = this.func_25024_W();
            if (var1 instanceof EntityPlayer) {
                EntityPlayer var2 = (EntityPlayer)var1;
                ItemStack var3 = var2.field_778_b.func_494_a();
                if (var3 != null) {
                    if (!this.func_25047_D() && var3.field_1617_c == Item.field_21020_aV.field_291_aS) {
                        this.field_25049_a = true;
                    } else if (this.func_25047_D() && Item.field_233_c[var3.field_1617_c] instanceof ItemFood) {
                        this.field_25049_a = ((ItemFood)Item.field_233_c[var3.field_1617_c]).func_25012_m();
                    }
                }
            }
        }

        if (!this.field_9343_G && this.field_25053_f && !this.field_25052_g && !this.func_25031_E() && this.field_9298_aH) {
            this.field_25052_g = true;
            this.field_25051_h = 0.0F;
            this.field_25050_i = 0.0F;
            this.field_615_ag.func_9425_a(this, (byte)8);
        }

    }

    public void func_370_e_() {
        super.func_370_e_();
        this.field_25054_c = this.field_25048_b;
        if (this.field_25049_a) {
            this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
        } else {
            this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
        }

        if (this.field_25049_a) {
            this.field_4127_c = 10;
        }

        if (this.func_27012_af()) {
            this.field_25053_f = true;
            this.field_25052_g = false;
            this.field_25051_h = 0.0F;
            this.field_25050_i = 0.0F;
        } else if ((this.field_25053_f || this.field_25052_g) && this.field_25052_g) {
            if (this.field_25051_h == 0.0F) {
                this.field_615_ag.func_623_a(this, "mob.wolf.shake", this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
            }

            this.field_25050_i = this.field_25051_h;
            this.field_25051_h += 0.05F;
            if (this.field_25050_i >= 2.0F) {
                this.field_25053_f = false;
                this.field_25052_g = false;
                this.field_25050_i = 0.0F;
                this.field_25051_h = 0.0F;
            }

            if (this.field_25051_h > 0.4F) {
                float var1 = (float)this.field_601_au.field_1697_b;
                int var2 = (int)(MathHelper.func_1106_a((this.field_25051_h - 0.4F) * 3.1415927F) * 7.0F);

                for(int var3 = 0; var3 < var2; ++var3) {
                    float var4 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC * 0.5F;
                    float var5 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC * 0.5F;
                    this.field_615_ag.func_694_a("splash", this.field_611_ak + (double)var4, (double)(var1 + 0.8F), this.field_609_am + (double)var5, this.field_608_an, this.field_607_ao, this.field_606_ap);
                }
            }
        }

    }

    public boolean func_25039_v() {
        return this.field_25053_f;
    }

    public float func_25043_b_(float var1) {
        return 0.75F + (this.field_25050_i + (this.field_25051_h - this.field_25050_i) * var1) / 2.0F * 0.25F;
    }

    public float func_25042_a(float var1, float var2) {
        float var3 = (this.field_25050_i + (this.field_25051_h - this.field_25050_i) * var1 + var2) / 1.8F;
        if (var3 < 0.0F) {
            var3 = 0.0F;
        } else if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        return MathHelper.func_1106_a(var3 * 3.1415927F) * MathHelper.func_1106_a(var3 * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
    }

    public float func_25033_c(float var1) {
        return (this.field_25054_c + (this.field_25048_b - this.field_25054_c) * var1) * 0.15F * 3.1415927F;
    }

    public float func_373_s() {
        return this.field_643_aD * 0.8F;
    }

    protected int func_25026_x() {
        return this.func_25034_B() ? 20 : super.func_25026_x();
    }

    private void func_25044_b(Entity var1, float var2) {
        PathEntity var3 = this.field_615_ag.func_702_a(this, var1, 16.0F);
        if (var3 == null && var2 > 12.0F) {
            int var4 = MathHelper.func_1108_b(var1.field_611_ak) - 2;
            int var5 = MathHelper.func_1108_b(var1.field_609_am) - 2;
            int var6 = MathHelper.func_1108_b(var1.field_601_au.field_1697_b);

            for(int var7 = 0; var7 <= 4; ++var7) {
                for(int var8 = 0; var8 <= 4; ++var8) {
                    if ((var7 < 1 || var8 < 1 || var7 > 3 || var8 > 3) && this.field_615_ag.func_28100_h(var4 + var7, var6 - 1, var5 + var8) && !this.field_615_ag.func_28100_h(var4 + var7, var6, var5 + var8) && !this.field_615_ag.func_28100_h(var4 + var7, var6 + 1, var5 + var8)) {
                        this.func_365_c((double)((float)(var4 + var7) + 0.5F), (double)var6, (double)((float)(var5 + var8) + 0.5F), this.field_605_aq, this.field_604_ar);
                        return;
                    }
                }
            }
        } else {
            this.func_25029_a(var3);
        }

    }

    protected boolean func_25028_d_() {
        return this.func_25034_B() || this.field_25052_g;
    }

    public boolean func_396_a(Entity var1, int var2) {
        this.func_25046_b(false);
        if (var1 != null && !(var1 instanceof EntityPlayer) && !(var1 instanceof EntityArrow)) {
            var2 = (var2 + 1) / 2;
        }

        if (!super.func_396_a((Entity)var1, var2)) {
            return false;
        } else {
            if (!this.func_25047_D() && !this.func_25040_C()) {
                if (var1 instanceof EntityPlayer) {
                    this.func_25041_c(true);
                    this.field_751_f = (Entity)var1;
                }

                if (var1 instanceof EntityArrow && ((EntityArrow)var1).field_682_g != null) {
                    var1 = ((EntityArrow)var1).field_682_g;
                }

                if (var1 instanceof EntityLiving) {
                    List var3 = this.field_615_ag.func_657_a(EntityWolf.class, AxisAlignedBB.func_1161_b(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_611_ak + 1.0D, this.field_610_al + 1.0D, this.field_609_am + 1.0D).func_1177_b(16.0D, 4.0D, 16.0D));
                    Iterator var4 = var3.iterator();

                    while(var4.hasNext()) {
                        Entity var5 = (Entity)var4.next();
                        EntityWolf var6 = (EntityWolf)var5;
                        if (!var6.func_25047_D() && var6.field_751_f == null) {
                            var6.field_751_f = (Entity)var1;
                            if (var1 instanceof EntityPlayer) {
                                var6.func_25041_c(true);
                            }
                        }
                    }
                }
            } else if (var1 != this && var1 != null) {
                if (this.func_25047_D() && var1 instanceof EntityPlayer && ((EntityPlayer)var1).field_771_i.equalsIgnoreCase(this.func_25045_A())) {
                    return true;
                }

                this.field_751_f = (Entity)var1;
            }

            return true;
        }
    }

    protected Entity func_438_i() {
        return this.func_25040_C() ? this.field_615_ag.func_609_a(this, 16.0D) : null;
    }

    protected void func_437_a(Entity var1, float var2) {
        if (var2 > 2.0F && var2 < 6.0F && this.field_9312_bd.nextInt(10) == 0) {
            if (this.field_9298_aH) {
                double var8 = var1.field_611_ak - this.field_611_ak;
                double var5 = var1.field_609_am - this.field_609_am;
                float var7 = MathHelper.func_1109_a(var8 * var8 + var5 * var5);
                this.field_608_an = var8 / (double)var7 * 0.5D * 0.800000011920929D + this.field_608_an * 0.20000000298023224D;
                this.field_606_ap = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.field_606_ap * 0.20000000298023224D;
                this.field_607_ao = 0.4000000059604645D;
            }
        } else if ((double)var2 < 1.5D && var1.field_601_au.field_1702_e > this.field_601_au.field_1697_b && var1.field_601_au.field_1697_b < this.field_601_au.field_1702_e) {
            this.field_9330_P = 20;
            byte var3 = 2;
            if (this.func_25047_D()) {
                var3 = 4;
            }

            var1.func_396_a(this, var3);
        }

    }

    public boolean func_353_a(EntityPlayer var1) {
        ItemStack var2 = var1.field_778_b.func_494_a();
        if (!this.func_25047_D()) {
            if (var2 != null && var2.field_1617_c == Item.field_21020_aV.field_291_aS && !this.func_25040_C()) {
                --var2.field_1615_a;
                if (var2.field_1615_a <= 0) {
                    var1.field_778_b.func_472_a(var1.field_778_b.field_847_d, (ItemStack)null);
                }

                if (!this.field_615_ag.field_1026_y) {
                    if (this.field_9312_bd.nextInt(3) == 0) {
                        this.func_25038_d(true);
                        this.func_25029_a((PathEntity)null);
                        this.func_25046_b(true);
                        this.field_9337_J = 20;
                        this.func_25036_a(var1.field_771_i);
                        this.func_25035_a(true);
                        this.field_615_ag.func_9425_a(this, (byte)7);
                    } else {
                        this.func_25035_a(false);
                        this.field_615_ag.func_9425_a(this, (byte)6);
                    }
                }

                return true;
            }
        } else {
            if (var2 != null && Item.field_233_c[var2.field_1617_c] instanceof ItemFood) {
                ItemFood var3 = (ItemFood)Item.field_233_c[var2.field_1617_c];
                if (var3.func_25012_m() && this.field_21064_bx.func_25115_b(18) < 20) {
                    --var2.field_1615_a;
                    if (var2.field_1615_a <= 0) {
                        var1.field_778_b.func_472_a(var1.field_778_b.field_847_d, (ItemStack)null);
                    }

                    this.func_432_b(((ItemFood)Item.field_272_ao).func_25011_l());
                    return true;
                }
            }

            if (var1.field_771_i.equalsIgnoreCase(this.func_25045_A())) {
                if (!this.field_615_ag.field_1026_y) {
                    this.func_25046_b(!this.func_25034_B());
                    this.field_9336_ak = false;
                    this.func_25029_a((PathEntity)null);
                }

                return true;
            }
        }

        return false;
    }

    void func_25035_a(boolean var1) {
        String var2 = "heart";
        if (!var1) {
            var2 = "smoke";
        }

        for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var8 = this.field_9312_bd.nextGaussian() * 0.02D;
            this.field_615_ag.func_694_a(var2, this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + 0.5D + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var4, var6, var8);
        }

    }

    public void func_9282_a(byte var1) {
        if (var1 == 7) {
            this.func_25035_a(true);
        } else if (var1 == 6) {
            this.func_25035_a(false);
        } else if (var1 == 8) {
            this.field_25052_g = true;
            this.field_25051_h = 0.0F;
            this.field_25050_i = 0.0F;
        } else {
            super.func_9282_a(var1);
        }

    }

    public float func_25037_z() {
        if (this.func_25040_C()) {
            return 1.5393804F;
        } else {
            return this.func_25047_D() ? (0.55F - (float)(20 - this.field_21064_bx.func_25115_b(18)) * 0.02F) * 3.1415927F : 0.62831855F;
        }
    }

    public int func_6391_i() {
        return 8;
    }

    public String func_25045_A() {
        return this.field_21064_bx.func_25116_c(17);
    }

    public void func_25036_a(String var1) {
        this.field_21064_bx.func_21129_b(17, var1);
    }

    public boolean func_25034_B() {
        return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
    }

    public void func_25046_b(boolean var1) {
        byte var2 = this.field_21064_bx.func_21130_a(16);
        if (var1) {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 | 1));
        } else {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 & -2));
        }

    }

    public boolean func_25040_C() {
        return (this.field_21064_bx.func_21130_a(16) & 2) != 0;
    }

    public void func_25041_c(boolean var1) {
        byte var2 = this.field_21064_bx.func_21130_a(16);
        if (var1) {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 | 2));
        } else {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 & -3));
        }

    }

    public boolean func_25047_D() {
        return (this.field_21064_bx.func_21130_a(16) & 4) != 0;
    }

    public void func_25038_d(boolean var1) {
        byte var2 = this.field_21064_bx.func_21130_a(16);
        if (var1) {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 | 4));
        } else {
            this.field_21064_bx.func_21129_b(16, (byte)(var2 & -5));
        }

    }
}
