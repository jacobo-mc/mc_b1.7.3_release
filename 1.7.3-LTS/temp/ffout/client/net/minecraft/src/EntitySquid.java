package net.minecraft.src;

public class EntitySquid extends EntityWaterMob {
    public float field_21089_a = 0.0F;
    public float field_21088_b = 0.0F;
    public float field_21087_c = 0.0F;
    public float field_21086_f = 0.0F;
    public float field_21085_g = 0.0F;
    public float field_21084_h = 0.0F;
    public float field_21083_i = 0.0F;
    public float field_21082_j = 0.0F;
    private float field_21081_k = 0.0F;
    private float field_21080_l = 0.0F;
    private float field_21079_m = 0.0F;
    private float field_21078_n = 0.0F;
    private float field_21077_o = 0.0F;
    private float field_21076_p = 0.0F;

    public EntitySquid(World var1) {
        super(var1);
        this.field_9357_z = "/mob/squid.png";
        this.func_371_a(0.95F, 0.95F);
        this.field_21080_l = 1.0F / (this.field_9312_bd.nextFloat() + 1.0F) * 0.2F;
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    protected String func_6389_d() {
        return null;
    }

    protected String func_6394_f_() {
        return null;
    }

    protected String func_6390_f() {
        return null;
    }

    protected float func_6393_h() {
        return 0.4F;
    }

    protected int func_422_g() {
        return 0;
    }

    protected void func_21066_o() {
        int var1 = this.field_9312_bd.nextInt(3) + 1;

        for(int var2 = 0; var2 < var1; ++var2) {
            this.func_21058_a(new ItemStack(Item.field_21021_aU, 1, 0), 0.0F);
        }

    }

    public boolean func_353_a(EntityPlayer var1) {
        return false;
    }

    public boolean func_27013_ag() {
        return this.field_615_ag.func_682_a(this.field_601_au.func_1177_b(0.0D, -0.6000000238418579D, 0.0D), Material.field_1332_f, this);
    }

    public void func_425_j() {
        super.func_425_j();
        this.field_21088_b = this.field_21089_a;
        this.field_21086_f = this.field_21087_c;
        this.field_21084_h = this.field_21085_g;
        this.field_21082_j = this.field_21083_i;
        this.field_21085_g += this.field_21080_l;
        if (this.field_21085_g > 6.2831855F) {
            this.field_21085_g -= 6.2831855F;
            if (this.field_9312_bd.nextInt(10) == 0) {
                this.field_21080_l = 1.0F / (this.field_9312_bd.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.func_27013_ag()) {
            float var1;
            if (this.field_21085_g < 3.1415927F) {
                var1 = this.field_21085_g / 3.1415927F;
                this.field_21083_i = MathHelper.func_1106_a(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
                if ((double)var1 > 0.75D) {
                    this.field_21081_k = 1.0F;
                    this.field_21079_m = 1.0F;
                } else {
                    this.field_21079_m *= 0.8F;
                }
            } else {
                this.field_21083_i = 0.0F;
                this.field_21081_k *= 0.9F;
                this.field_21079_m *= 0.99F;
            }

            if (!this.field_9343_G) {
                this.field_608_an = (double)(this.field_21078_n * this.field_21081_k);
                this.field_607_ao = (double)(this.field_21077_o * this.field_21081_k);
                this.field_606_ap = (double)(this.field_21076_p * this.field_21081_k);
            }

            var1 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
            this.field_735_n += (-((float)Math.atan2(this.field_608_an, this.field_606_ap)) * 180.0F / 3.1415927F - this.field_735_n) * 0.1F;
            this.field_605_aq = this.field_735_n;
            this.field_21087_c += 3.1415927F * this.field_21079_m * 1.5F;
            this.field_21089_a += (-((float)Math.atan2((double)var1, this.field_607_ao)) * 180.0F / 3.1415927F - this.field_21089_a) * 0.1F;
        } else {
            this.field_21083_i = MathHelper.func_1112_e(MathHelper.func_1106_a(this.field_21085_g)) * 3.1415927F * 0.25F;
            if (!this.field_9343_G) {
                this.field_608_an = 0.0D;
                this.field_607_ao -= 0.08D;
                this.field_607_ao *= 0.9800000190734863D;
                this.field_606_ap = 0.0D;
            }

            this.field_21089_a = (float)((double)this.field_21089_a + (double)(-90.0F - this.field_21089_a) * 0.02D);
        }

    }

    public void func_435_b(float var1, float var2) {
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
    }

    protected void func_418_b_() {
        if (this.field_9312_bd.nextInt(50) == 0 || !this.field_9307_bi || this.field_21078_n == 0.0F && this.field_21077_o == 0.0F && this.field_21076_p == 0.0F) {
            float var1 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
            this.field_21078_n = MathHelper.func_1114_b(var1) * 0.2F;
            this.field_21077_o = -0.1F + this.field_9312_bd.nextFloat() * 0.2F;
            this.field_21076_p = MathHelper.func_1106_a(var1) * 0.2F;
        }

        this.func_27021_X();
    }
}
