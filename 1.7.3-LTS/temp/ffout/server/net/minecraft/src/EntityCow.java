package net.minecraft.src;

public class EntityCow extends EntityAnimal {
    public EntityCow(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/cow.png";
        this.func_113_a(0.9F, 1.3F);
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    protected String func_6097_d() {
        return "mob.cow";
    }

    protected String func_6100_e() {
        return "mob.cowhurt";
    }

    protected String func_6098_f() {
        return "mob.cowhurt";
    }

    protected float func_6102_h() {
        return 0.4F;
    }

    protected int func_149_g() {
        return Item.field_249_aD.field_234_aS;
    }

    public boolean func_6092_a(EntityPlayer var1) {
        ItemStack var2 = var1.field_416_aj.func_213_b();
        if (var2 != null && var2.field_855_c == Item.field_205_au.field_234_aS) {
            var1.field_416_aj.func_206_a(var1.field_416_aj.field_499_d, new ItemStack(Item.field_4204_aE));
            return true;
        } else {
            return false;
        }
    }
}
