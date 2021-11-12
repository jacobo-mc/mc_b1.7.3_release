package net.minecraft.src;

class SlotArmor extends Slot {
    // $FF: synthetic field
    final int armorType;
    // $FF: synthetic field
    final ContainerPlayer inventory;

    SlotArmor(ContainerPlayer var1, IInventory var2, int var3, int var4, int var5, int var6) {
        super(var2, var3, var4, var5);
        this.inventory = var1;
        this.armorType = var6;
    }

    public int getSlotStackLimit() {
        return 1;
    }

    public boolean isItemValid(ItemStack var1) {
        if (var1.getItem() instanceof ItemArmor) {
            return ((ItemArmor)var1.getItem()).armorType == this.armorType;
        } else if (var1.getItem().shiftedIndex == Block.pumpkin.blockID) {
            return this.armorType == 0;
        } else {
            return false;
        }
    }
}
