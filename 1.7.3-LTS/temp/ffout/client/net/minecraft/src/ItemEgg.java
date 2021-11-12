package net.minecraft.src;

public class ItemEgg extends Item {
    public ItemEgg(int var1) {
        super(var1);
        this.field_290_aT = 16;
    }

    public ItemStack func_193_a(ItemStack var1, World var2, EntityPlayer var3) {
        --var1.field_1615_a;
        var2.func_623_a(var3, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
        if (!var2.field_1026_y) {
            var2.func_674_a(new EntityEgg(var2, var3));
        }

        return var1;
    }
}
