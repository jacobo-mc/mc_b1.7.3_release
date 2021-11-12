package net.minecraft.src;

public class EntitySpider extends EntityMob {
    public EntitySpider(World var1) {
        super(var1);
        this.field_9357_z = "/mob/spider.png";
        this.func_371_a(1.4F, 0.9F);
        this.field_9333_am = 0.8F;
    }

    public double func_402_h() {
        return (double)this.field_643_aD * 0.75D - 0.5D;
    }

    protected boolean func_25021_m() {
        return false;
    }

    protected Entity func_438_i() {
        float var1 = this.func_382_a(1.0F);
        if (var1 < 0.5F) {
            double var2 = 16.0D;
            return this.field_615_ag.func_609_a(this, var2);
        } else {
            return null;
        }
    }

    protected String func_6389_d() {
        return "mob.spider";
    }

    protected String func_6394_f_() {
        return "mob.spider";
    }

    protected String func_6390_f() {
        return "mob.spiderdeath";
    }

    protected void func_437_a(Entity var1, float var2) {
        float var3 = this.func_382_a(1.0F);
        if (var3 > 0.5F && this.field_9312_bd.nextInt(100) == 0) {
            this.field_751_f = null;
        } else {
            if (var2 > 2.0F && var2 < 6.0F && this.field_9312_bd.nextInt(10) == 0) {
                if (this.field_9298_aH) {
                    double var4 = var1.field_611_ak - this.field_611_ak;
                    double var6 = var1.field_609_am - this.field_609_am;
                    float var8 = MathHelper.func_1109_a(var4 * var4 + var6 * var6);
                    this.field_608_an = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.field_608_an * 0.20000000298023224D;
                    this.field_606_ap = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.field_606_ap * 0.20000000298023224D;
                    this.field_607_ao = 0.4000000059604645D;
                }
            } else {
                super.func_437_a(var1, var2);
            }

        }
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    protected int func_422_g() {
        return Item.field_253_I.field_291_aS;
    }

    public boolean func_429_A() {
        return this.field_9297_aI;
    }
}
