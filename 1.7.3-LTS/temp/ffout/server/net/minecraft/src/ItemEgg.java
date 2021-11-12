package net.minecraft.src;

public class ItemEgg extends Item {
    public ItemEgg(int var1) {
        super(var1);
        this.field_233_aT = 16;
    }

    public ItemStack func_6152_a(ItemStack var1, World var2, EntityPlayer var3) {
        --var1.field_853_a;
        var2.func_506_a(var3, "random.bow", 0.5F, 0.4F / (field_4154_b.nextFloat() * 0.4F + 0.8F));
        if (!var2.field_792_x) {
            var2.func_526_a(new EntityEgg(var2, var3));
        }

        return var1;
    }
}
