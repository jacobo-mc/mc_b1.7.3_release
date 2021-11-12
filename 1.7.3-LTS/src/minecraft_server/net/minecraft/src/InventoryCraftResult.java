package net.minecraft.src;

public class InventoryCraftResult implements IInventory {
    private ItemStack[] stackResult = new ItemStack[1];

    public int getSizeInventory() {
        return 1;
    }

    public ItemStack getStackInSlot(int var1) {
        return this.stackResult[var1];
    }

    public String getInvName() {
        return "Result";
    }

    public ItemStack decrStackSize(int var1, int var2) {
        if (this.stackResult[var1] != null) {
            ItemStack var3 = this.stackResult[var1];
            this.stackResult[var1] = null;
            return var3;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.stackResult[var1] = var2;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void onInventoryChanged() {
    }

    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }
}
