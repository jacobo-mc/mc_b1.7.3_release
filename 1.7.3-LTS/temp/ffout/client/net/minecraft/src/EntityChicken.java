package net.minecraft.src;

public class EntityChicken extends EntityAnimal {
    public boolean field_753_a = false;
    public float field_752_b = 0.0F;
    public float field_758_c = 0.0F;
    public float field_757_d;
    public float field_756_e;
    public float field_755_h = 1.0F;
    public int field_754_i;

    public EntityChicken(World var1) {
        super(var1);
        this.field_9357_z = "/mob/chicken.png";
        this.func_371_a(0.3F, 0.4F);
        this.field_9337_J = 4;
        this.field_754_i = this.field_9312_bd.nextInt(6000) + 6000;
    }

    public void func_425_j() {
        super.func_425_j();
        this.field_756_e = this.field_752_b;
        this.field_757_d = this.field_758_c;
        this.field_758_c = (float)((double)this.field_758_c + (double)(this.field_9298_aH ? -1 : 4) * 0.3D);
        if (this.field_758_c < 0.0F) {
            this.field_758_c = 0.0F;
        }

        if (this.field_758_c > 1.0F) {
            this.field_758_c = 1.0F;
        }

        if (!this.field_9298_aH && this.field_755_h < 1.0F) {
            this.field_755_h = 1.0F;
        }

        this.field_755_h = (float)((double)this.field_755_h * 0.9D);
        if (!this.field_9298_aH && this.field_607_ao < 0.0D) {
            this.field_607_ao *= 0.6D;
        }

        this.field_752_b += this.field_755_h * 2.0F;
        if (!this.field_615_ag.field_1026_y && --this.field_754_i <= 0) {
            this.field_615_ag.func_623_a(this, "mob.chickenplop", 1.0F, (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
            this.func_367_b(Item.field_296_aN.field_291_aS, 1);
            this.field_754_i = this.field_9312_bd.nextInt(6000) + 6000;
        }

    }

    protected void func_400_c(float var1) {
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    protected String func_6389_d() {
        return "mob.chicken";
    }

    protected String func_6394_f_() {
        return "mob.chickenhurt";
    }

    protected String func_6390_f() {
        return "mob.chickenhurt";
    }

    protected int func_422_g() {
        return Item.field_251_J.field_291_aS;
    }
}
