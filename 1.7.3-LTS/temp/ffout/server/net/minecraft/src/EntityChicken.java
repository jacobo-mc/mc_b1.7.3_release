package net.minecraft.src;

public class EntityChicken extends EntityAnimal {
    public boolean field_392_a = false;
    public float field_391_b = 0.0F;
    public float field_395_ad = 0.0F;
    public float field_394_ae;
    public float field_393_af;
    public float field_390_ai = 1.0F;
    public int field_396_aj;

    public EntityChicken(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/chicken.png";
        this.func_113_a(0.3F, 0.4F);
        this.field_9109_aQ = 4;
        this.field_396_aj = this.field_9064_W.nextInt(6000) + 6000;
    }

    public void func_153_y() {
        super.func_153_y();
        this.field_393_af = this.field_391_b;
        this.field_394_ae = this.field_395_ad;
        this.field_395_ad = (float)((double)this.field_395_ad + (double)(this.field_9086_A ? -1 : 4) * 0.3D);
        if (this.field_395_ad < 0.0F) {
            this.field_395_ad = 0.0F;
        }

        if (this.field_395_ad > 1.0F) {
            this.field_395_ad = 1.0F;
        }

        if (!this.field_9086_A && this.field_390_ai < 1.0F) {
            this.field_390_ai = 1.0F;
        }

        this.field_390_ai = (float)((double)this.field_390_ai * 0.9D);
        if (!this.field_9086_A && this.field_318_p < 0.0D) {
            this.field_318_p *= 0.6D;
        }

        this.field_391_b += this.field_390_ai * 2.0F;
        if (!this.field_9093_l.field_792_x && --this.field_396_aj <= 0) {
            this.field_9093_l.func_506_a(this, "mob.chickenplop", 1.0F, (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
            this.func_128_a(Item.field_239_aN.field_234_aS, 1);
            this.field_396_aj = this.field_9064_W.nextInt(6000) + 6000;
        }

    }

    protected void func_114_a(float var1) {
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    protected String func_6097_d() {
        return "mob.chicken";
    }

    protected String func_6100_e() {
        return "mob.chickenhurt";
    }

    protected String func_6098_f() {
        return "mob.chickenhurt";
    }

    protected int func_149_g() {
        return Item.field_194_J.field_234_aS;
    }
}
