package net.minecraft.src;

public class ItemFood extends Item {
    private int healAmount;
    private boolean isWolfsFavoriteMeat;

    public ItemFood(int var1, int var2, boolean var3) {
        super(var1);
        this.healAmount = var2;
        this.isWolfsFavoriteMeat = var3;
        this.maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        --var1.stackSize;
        var3.heal(this.healAmount);
        return var1;
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    public boolean getIsWolfsFavoriteMeat() {
        return this.isWolfsFavoriteMeat;
    }
}
