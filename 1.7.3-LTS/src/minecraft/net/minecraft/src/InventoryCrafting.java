package net.minecraft.src;

public class InventoryCrafting implements IInventory {
    private ItemStack[] stackList;
    private int inventoryWidth;
    private Container eventHandler;

    public InventoryCrafting(Container var1, int var2, int var3) {
        int var4 = var2 * var3;
        this.stackList = new ItemStack[var4];
        this.eventHandler = var1;
        this.inventoryWidth = var2;
    }

    public int getSizeInventory() {
        return this.stackList.length;
    }

    public ItemStack getStackInSlot(int var1) {
        return var1 >= this.getSizeInventory() ? null : this.stackList[var1];
    }

    public ItemStack getStackInRowAndColumn(int var1, int var2) {
        if (var1 >= 0 && var1 < this.inventoryWidth) {
            int var3 = var1 + var2 * this.inventoryWidth;
            return this.getStackInSlot(var3);
        } else {
            return null;
        }
    }

    public String getInvName() {
        return "Crafting";
    }

    public ItemStack decrStackSize(int var1, int var2) {
        if (this.stackList[var1] != null) {
            ItemStack var3;
            if (this.stackList[var1].stackSize <= var2) {
                var3 = this.stackList[var1];
                this.stackList[var1] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return var3;
            } else {
                var3 = this.stackList[var1].splitStack(var2);
                if (this.stackList[var1].stackSize == 0) {
                    this.stackList[var1] = null;
                }

                this.eventHandler.onCraftMatrixChanged(this);
                return var3;
            }
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.stackList[var1] = var2;
        this.eventHandler.onCraftMatrixChanged(this);
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
