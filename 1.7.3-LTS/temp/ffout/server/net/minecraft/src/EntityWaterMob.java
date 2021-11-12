package net.minecraft.src;

public class EntityWaterMob extends EntityCreature implements IAnimals {
    public EntityWaterMob(World var1) {
        super(var1);
    }

    public boolean func_21046_d_() {
        return true;
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    public boolean func_155_a() {
        return this.field_9093_l.func_522_a(this.field_312_v);
    }

    public int func_146_b() {
        return 120;
    }
}
