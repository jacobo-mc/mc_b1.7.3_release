package net.minecraft.src;

public class EntitySpider extends EntityMob {
    public EntitySpider(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/spider.png";
        this.func_113_a(1.4F, 0.9F);
        this.field_9126_bt = 0.8F;
    }

    public double func_130_h() {
        return (double)this.field_298_E * 0.75D - 0.5D;
    }

    protected boolean func_25017_l() {
        return false;
    }

    protected Entity func_158_i() {
        float var1 = this.func_108_b(1.0F);
        if (var1 < 0.5F) {
            double var2 = 16.0D;
            return this.field_9093_l.func_472_a(this, var2);
        } else {
            return null;
        }
    }

    protected String func_6097_d() {
        return "mob.spider";
    }

    protected String func_6100_e() {
        return "mob.spider";
    }

    protected String func_6098_f() {
        return "mob.spiderdeath";
    }

    protected void func_157_a(Entity var1, float var2) {
        float var3 = this.func_108_b(1.0F);
        if (var3 > 0.5F && this.field_9064_W.nextInt(100) == 0) {
            this.field_389_ag = null;
        } else {
            if (var2 > 2.0F && var2 < 6.0F && this.field_9064_W.nextInt(10) == 0) {
                if (this.field_9086_A) {
                    double var4 = var1.field_322_l - this.field_322_l;
                    double var6 = var1.field_320_n - this.field_320_n;
                    float var8 = MathHelper.func_583_a(var4 * var4 + var6 * var6);
                    this.field_319_o = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.field_319_o * 0.20000000298023224D;
                    this.field_317_q = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.field_317_q * 0.20000000298023224D;
                    this.field_318_p = 0.4000000059604645D;
                }
            } else {
                super.func_157_a(var1, var2);
            }

        }
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    protected int func_149_g() {
        return Item.field_196_I.field_234_aS;
    }

    public boolean func_144_E() {
        return this.field_9084_B;
    }
}
