package net.minecraft.src;

public class Slot {
    private final int slotIndex;
    private final IInventory inventory;
    public int id;
    public int xDisplayPosition;
    public int yDisplayPosition;

    public Slot(IInventory var1, int var2, int var3, int var4) {
        this.inventory = var1;
        this.slotIndex = var2;
        this.xDisplayPosition = var3;
        this.yDisplayPosition = var4;
    }

    public void onPickupFromSlot(ItemStack var1) {
        this.onSlotChanged();
    }

    public boolean isItemValid(ItemStack var1) {
        return true;
    }

    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    public boolean func_27006_b() {
        return this.getStack() != null;
    }

    public void putStack(ItemStack var1) {
        this.inventory.setInventorySlotContents(this.slotIndex, var1);
        this.onSlotChanged();
    }

    public void onSlotChanged() {
        this.inventory.onInventoryChanged();
    }

    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }

    public ItemStack decrStackSize(int var1) {
        return this.inventory.decrStackSize(this.slotIndex, var1);
    }

    public boolean isHere(IInventory var1, int var2) {
        return var1 == this.inventory && var2 == this.slotIndex;
    }
}
