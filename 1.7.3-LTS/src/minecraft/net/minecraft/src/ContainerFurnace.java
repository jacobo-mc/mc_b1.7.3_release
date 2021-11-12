package net.minecraft.src;

public class ContainerFurnace extends Container {
    private TileEntityFurnace furnace;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    public ContainerFurnace(InventoryPlayer var1, TileEntityFurnace var2) {
        this.furnace = var2;
        this.addSlot(new Slot(var2, 0, 56, 17));
        this.addSlot(new Slot(var2, 1, 56, 53));
        this.addSlot(new SlotFurnace(var1.player, var2, 2, 116, 35));

        int var3;
        for(var3 = 0; var3 < 3; ++var3) {
            for(int var4 = 0; var4 < 9; ++var4) {
                this.addSlot(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for(var3 = 0; var3 < 9; ++var3) {
            this.addSlot(new Slot(var1, var3, 8 + var3 * 18, 142));
        }

    }

    public void updateCraftingResults() {
        super.updateCraftingResults();

        for(int var1 = 0; var1 < this.crafters.size(); ++var1) {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);
            if (this.cookTime != this.furnace.furnaceCookTime) {
                var2.updateCraftingInventoryInfo(this, 0, this.furnace.furnaceCookTime);
            }

            if (this.burnTime != this.furnace.furnaceBurnTime) {
                var2.updateCraftingInventoryInfo(this, 1, this.furnace.furnaceBurnTime);
            }

            if (this.itemBurnTime != this.furnace.currentItemBurnTime) {
                var2.updateCraftingInventoryInfo(this, 2, this.furnace.currentItemBurnTime);
            }
        }

        this.cookTime = this.furnace.furnaceCookTime;
        this.burnTime = this.furnace.furnaceBurnTime;
        this.itemBurnTime = this.furnace.currentItemBurnTime;
    }

    public void updateProgressBar(int var1, int var2) {
        if (var1 == 0) {
            this.furnace.furnaceCookTime = var2;
        }

        if (var1 == 1) {
            this.furnace.furnaceBurnTime = var2;
        }

        if (var1 == 2) {
            this.furnace.currentItemBurnTime = var2;
        }

    }

    public boolean isUsableByPlayer(EntityPlayer var1) {
        return this.furnace.canInteractWith(var1);
    }

    public ItemStack getStackInSlot(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.slots.get(var1);
        if (var3 != null && var3.getHasStack()) {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();
            if (var1 == 2) {
                this.mergeItemStack(var4, 3, 39, true);
            } else if (var1 >= 3 && var1 < 30) {
                this.mergeItemStack(var4, 30, 39, false);
            } else if (var1 >= 30 && var1 < 39) {
                this.mergeItemStack(var4, 3, 30, false);
            } else {
                this.mergeItemStack(var4, 3, 39, false);
            }

            if (var4.stackSize == 0) {
                var3.putStack((ItemStack)null);
            } else {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize) {
                return null;
            }

            var3.onPickupFromSlot(var4);
        }

        return var2;
    }
}
