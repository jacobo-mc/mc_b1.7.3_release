package net.minecraft.src;

import java.util.List;

public class InventoryBasic implements IInventory {
    private String inventoryTitle;
    private int slotsCount;
    private ItemStack[] inventoryContents;
    private List changeListeners;

    public InventoryBasic(String var1, int var2) {
        this.inventoryTitle = var1;
        this.slotsCount = var2;
        this.inventoryContents = new ItemStack[var2];
    }

    public ItemStack getStackInSlot(int var1) {
        return this.inventoryContents[var1];
    }

    public ItemStack decrStackSize(int var1, int var2) {
        if (this.inventoryContents[var1] != null) {
            ItemStack var3;
            if (this.inventoryContents[var1].stackSize <= var2) {
                var3 = this.inventoryContents[var1];
                this.inventoryContents[var1] = null;
                this.onInventoryChanged();
                return var3;
            } else {
                var3 = this.inventoryContents[var1].splitStack(var2);
                if (this.inventoryContents[var1].stackSize == 0) {
                    this.inventoryContents[var1] = null;
                }

                this.onInventoryChanged();
                return var3;
            }
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.inventoryContents[var1] = var2;
        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    public int getSizeInventory() {
        return this.slotsCount;
    }

    public String getInvName() {
        return this.inventoryTitle;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void onInventoryChanged() {
        if (this.changeListeners != null) {
            for(int var1 = 0; var1 < this.changeListeners.size(); ++var1) {
                ((IInvBasic)this.changeListeners.get(var1)).onInventoryChanged(this);
            }
        }

    }

    public boolean canInteractWith(EntityPlayer var1) {
        return true;
    }
}
