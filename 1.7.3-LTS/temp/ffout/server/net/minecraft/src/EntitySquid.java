package net.minecraft.src;

public class EntitySquid extends EntityWaterMob {
    public float field_21063_a = 0.0F;
    public float field_21062_b = 0.0F;
    public float field_21061_c = 0.0F;
    public float field_21059_f = 0.0F;
    public float field_21060_ak = 0.0F;
    public float field_21058_al = 0.0F;
    public float field_21057_am = 0.0F;
    public float field_21056_an = 0.0F;
    private float field_21055_ao = 0.0F;
    private float field_21054_ap = 0.0F;
    private float field_21053_aq = 0.0F;
    private float field_21052_ar = 0.0F;
    private float field_21051_as = 0.0F;
    private float field_21050_at = 0.0F;

    public EntitySquid(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/squid.png";
        this.func_113_a(0.95F, 0.95F);
        this.field_21054_ap = 1.0F / (this.field_9064_W.nextFloat() + 1.0F) * 0.2F;
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    protected String func_6097_d() {
        return null;
    }

    protected String func_6100_e() {
        return null;
    }

    protected String func_6098_f() {
        return null;
    }

    protected float func_6102_h() {
        return 0.4F;
    }

    protected int func_149_g() {
        return 0;
    }

    protected void func_21047_g_() {
        int var1 = this.field_9064_W.nextInt(3) + 1;

        for(int var2 = 0; var2 < var1; ++var2) {
            this.func_21040_a(new ItemStack(Item.field_21097_aU, 1, 0), 0.0F);
        }

    }

    public boolean func_6092_a(EntityPlayer var1) {
        return false;
    }

    public boolean func_27011_Z() {
        return this.field_9093_l.func_490_a(this.field_312_v.func_708_b(0.0D, -0.6000000238418579D, 0.0D), Material.field_521_f, this);
    }

    public void func_153_y() {
        super.func_153_y();
        this.field_21062_b = this.field_21063_a;
        this.field_21059_f = this.field_21061_c;
        this.field_21058_al = this.field_21060_ak;
        this.field_21056_an = this.field_21057_am;
        this.field_21060_ak += this.field_21054_ap;
        if (this.field_21060_ak > 6.2831855F) {
            this.field_21060_ak -= 6.2831855F;
            if (this.field_9064_W.nextInt(10) == 0) {
                this.field_21054_ap = 1.0F / (this.field_9064_W.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.func_27011_Z()) {
            float var1;
            if (this.field_21060_ak < 3.1415927F) {
                var1 = this.field_21060_ak / 3.1415927F;
                this.field_21057_am = MathHelper.func_585_a(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
                if ((double)var1 > 0.75D) {
                    this.field_21055_ao = 1.0F;
                    this.field_21053_aq = 1.0F;
                } else {
                    this.field_21053_aq *= 0.8F;
                }
            } else {
                this.field_21057_am = 0.0F;
                this.field_21055_ao *= 0.9F;
                this.field_21053_aq *= 0.99F;
            }

            if (!this.field_9112_aN) {
                this.field_319_o = (double)(this.field_21052_ar * this.field_21055_ao);
                this.field_318_p = (double)(this.field_21051_as * this.field_21055_ao);
                this.field_317_q = (double)(this.field_21050_at * this.field_21055_ao);
            }

            var1 = MathHelper.func_583_a(this.field_319_o * this.field_319_o + this.field_317_q * this.field_317_q);
            this.field_9095_az += (-((float)Math.atan2(this.field_319_o, this.field_317_q)) * 180.0F / 3.1415927F - this.field_9095_az) * 0.1F;
            this.field_316_r = this.field_9095_az;
            this.field_21061_c += 3.1415927F * this.field_21053_aq * 1.5F;
            this.field_21063_a += (-((float)Math.atan2((double)var1, this.field_318_p)) * 180.0F / 3.1415927F - this.field_21063_a) * 0.1F;
        } else {
            this.field_21057_am = MathHelper.func_587_e(MathHelper.func_585_a(this.field_21060_ak)) * 3.1415927F * 0.25F;
            if (!this.field_9112_aN) {
                this.field_319_o = 0.0D;
                this.field_318_p -= 0.08D;
                this.field_318_p *= 0.9800000190734863D;
                this.field_317_q = 0.0D;
            }

            this.field_21063_a = (float)((double)this.field_21063_a + (double)(-90.0F - this.field_21063_a) * 0.02D);
        }

    }

    public void func_148_c(float var1, float var2) {
        this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
    }

    protected void func_152_d_() {
        if (this.field_9064_W.nextInt(50) == 0 || !this.field_9085_ab || this.field_21052_ar == 0.0F && this.field_21051_as == 0.0F && this.field_21050_at == 0.0F) {
            float var1 = this.field_9064_W.nextFloat() * 3.1415927F * 2.0F;
            this.field_21052_ar = MathHelper.func_582_b(var1) * 0.2F;
            this.field_21051_as = -0.1F + this.field_9064_W.nextFloat() * 0.2F;
            this.field_21050_at = MathHelper.func_585_a(var1) * 0.2F;
        }

        this.func_27013_Q();
    }
}
