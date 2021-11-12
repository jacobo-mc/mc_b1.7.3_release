package net.minecraft.src;

public class EntityWaterMob extends EntityCreature {
    public EntityWaterMob(World var1) {
        super(var1);
    }

    public boolean func_21067_c_() {
        return true;
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    public boolean func_433_a() {
        return this.field_615_ag.func_604_a(this.field_601_au);
    }

    public int func_421_b() {
        return 120;
    }
}
