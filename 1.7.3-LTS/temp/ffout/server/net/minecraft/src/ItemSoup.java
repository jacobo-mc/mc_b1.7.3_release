package net.minecraft.src;

public class ItemSoup extends ItemFood {
    public ItemSoup(int var1, int var2) {
        super(var1, var2, false);
    }

    public ItemStack func_6152_a(ItemStack var1, World var2, EntityPlayer var3) {
        super.func_6152_a(var1, var2, var3);
        return new ItemStack(Item.field_4173_C);
    }
}
