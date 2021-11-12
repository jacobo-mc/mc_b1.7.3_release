package net.minecraft.src;

class SlotArmor extends Slot {
    // $FF: synthetic field
    final int field_20102_a;
    // $FF: synthetic field
    final ContainerPlayer field_20101_b;

    SlotArmor(ContainerPlayer var1, IInventory var2, int var3, int var4, int var5, int var6) {
        super(var2, var3, var4, var5);
        this.field_20101_b = var1;
        this.field_20102_a = var6;
    }

    public int getSlotStackLimit() {
        return 1;
    }

    public boolean isItemValid(ItemStack var1) {
        if (var1.getItem() instanceof ItemArmor) {
            return ((ItemArmor)var1.getItem()).armorType == this.field_20102_a;
        } else if (var1.getItem().shiftedIndex == Block.pumpkin.blockID) {
            return this.field_20102_a == 0;
        } else {
            return false;
        }
    }
}
