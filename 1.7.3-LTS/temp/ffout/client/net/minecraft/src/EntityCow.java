package net.minecraft.src;

public class EntityCow extends EntityAnimal {
    public EntityCow(World var1) {
        super(var1);
        this.field_9357_z = "/mob/cow.png";
        this.func_371_a(0.9F, 1.3F);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    protected String func_6389_d() {
        return "mob.cow";
    }

    protected String func_6394_f_() {
        return "mob.cowhurt";
    }

    protected String func_6390_f() {
        return "mob.cowhurt";
    }

    protected float func_6393_h() {
        return 0.4F;
    }

    protected int func_422_g() {
        return Item.field_306_aD.field_291_aS;
    }

    public boolean func_353_a(EntityPlayer var1) {
        ItemStack var2 = var1.field_778_b.func_494_a();
        if (var2 != null && var2.field_1617_c == Item.field_262_au.field_291_aS) {
            var1.field_778_b.func_472_a(var1.field_778_b.field_847_d, new ItemStack(Item.field_305_aE));
            return true;
        } else {
            return false;
        }
    }
}
