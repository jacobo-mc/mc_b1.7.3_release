package net.minecraft.src;

public abstract class EntityAnimal extends EntityCreature implements IAnimals {
    public EntityAnimal(World var1) {
        super(var1);
    }

    protected float func_159_a(int var1, int var2, int var3) {
        return this.field_9093_l.func_444_a(var1, var2 - 1, var3) == Block.field_534_v.field_573_bc ? 10.0F : this.field_9093_l.func_455_j(var1, var2, var3) - 0.5F;
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    public boolean func_155_a() {
        int var1 = MathHelper.func_584_b(this.field_322_l);
        int var2 = MathHelper.func_584_b(this.field_312_v.field_963_b);
        int var3 = MathHelper.func_584_b(this.field_320_n);
        return this.field_9093_l.func_444_a(var1, var2 - 1, var3) == Block.field_534_v.field_573_bc && this.field_9093_l.func_28098_j(var1, var2, var3) > 8 && super.func_155_a();
    }

    public int func_146_b() {
        return 120;
    }
}
