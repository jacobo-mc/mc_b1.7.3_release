package net.minecraft.src;

public class ItemFood extends Item {
    private int healAmount;
    private boolean field_25011_bi;

    public ItemFood(int var1, int var2, boolean var3) {
        super(var1);
        this.healAmount = var2;
        this.field_25011_bi = var3;
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

    public boolean func_25010_k() {
        return this.field_25011_bi;
    }
}
