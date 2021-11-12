package net.minecraft.src;

public class ContainerWorkbench extends Container {
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerWorkbench(InventoryPlayer var1, World var2, int var3, int var4, int var5) {
        this.worldObj = var2;
        this.posX = var3;
        this.posY = var4;
        this.posZ = var5;
        this.addSlot(new SlotCrafting(var1.player, this.craftMatrix, this.craftResult, 0, 124, 35));

        int var6;
        int var7;
        for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < 3; ++var7) {
                this.addSlot(new Slot(this.craftMatrix, var7 + var6 * 3, 30 + var7 * 18, 17 + var6 * 18));
            }
        }

        for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < 9; ++var7) {
                this.addSlot(new Slot(var1, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
            }
        }

        for(var6 = 0; var6 < 9; ++var6) {
            this.addSlot(new Slot(var1, var6, 8 + var6 * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    public void onCraftMatrixChanged(IInventory var1) {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix));
    }

    public void onCraftGuiClosed(EntityPlayer var1) {
        super.onCraftGuiClosed(var1);
        if (!this.worldObj.multiplayerWorld) {
            for(int var2 = 0; var2 < 9; ++var2) {
                ItemStack var3 = this.craftMatrix.getStackInSlot(var2);
                if (var3 != null) {
                    var1.dropPlayerItem(var3);
                }
            }

        }
    }

    public boolean isUsableByPlayer(EntityPlayer var1) {
        if (this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != Block.workbench.blockID) {
            return false;
        } else {
            return var1.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
        }
    }

    public ItemStack getStackInSlot(int var1) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.slots.get(var1);
        if (var3 != null && var3.getHasStack()) {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();
            if (var1 == 0) {
                this.mergeItemStack(var4, 10, 46, true);
            } else if (var1 >= 10 && var1 < 37) {
                this.mergeItemStack(var4, 37, 46, false);
            } else if (var1 >= 37 && var1 < 46) {
                this.mergeItemStack(var4, 10, 37, false);
            } else {
                this.mergeItemStack(var4, 10, 46, false);
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
