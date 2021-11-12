package net.minecraft.src;

public abstract class EntityAnimal extends EntityCreature {
    public EntityAnimal(World var1) {
        super(var1);
    }

    protected float func_439_a(int var1, int var2, int var3) {
        return this.field_615_ag.func_600_a(var1, var2 - 1, var3) == Block.field_337_v.field_376_bc ? 10.0F : this.field_615_ag.func_598_c(var1, var2, var3) - 0.5F;
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    public boolean func_433_a() {
        int var1 = MathHelper.func_1108_b(this.field_611_ak);
        int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
        int var3 = MathHelper.func_1108_b(this.field_609_am);
        return this.field_615_ag.func_600_a(var1, var2 - 1, var3) == Block.field_337_v.field_376_bc && this.field_615_ag.func_28104_m(var1, var2, var3) > 8 && super.func_433_a();
    }

    public int func_421_b() {
        return 120;
    }
}
