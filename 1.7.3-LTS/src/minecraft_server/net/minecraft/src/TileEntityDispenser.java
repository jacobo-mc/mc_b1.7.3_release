package net.minecraft.src;

import java.util.Random;

public class TileEntityDispenser extends TileEntity implements IInventory {
    private ItemStack[] dispenserContents = new ItemStack[9];
    private Random dispenserRandom = new Random();

    public int getSizeInventory() {
        return 9;
    }

    public ItemStack getStackInSlot(int var1) {
        return this.dispenserContents[var1];
    }

    public ItemStack decrStackSize(int var1, int var2) {
        if (this.dispenserContents[var1] != null) {
            ItemStack var3;
            if (this.dispenserContents[var1].stackSize <= var2) {
                var3 = this.dispenserContents[var1];
                this.dispenserContents[var1] = null;
                this.onInventoryChanged();
                return var3;
            } else {
                var3 = this.dispenserContents[var1].splitStack(var2);
                if (this.dispenserContents[var1].stackSize == 0) {
                    this.dispenserContents[var1] = null;
                }

                this.onInventoryChanged();
                return var3;
            }
        } else {
            return null;
        }
    }

    public ItemStack getRandomStackFromInventory() {
        int var1 = -1;
        int var2 = 1;

        for(int var3 = 0; var3 < this.dispenserContents.length; ++var3) {
            if (this.dispenserContents[var3] != null && this.dispenserRandom.nextInt(var2++) == 0) {
                var1 = var3;
            }
        }

        if (var1 >= 0) {
            return this.decrStackSize(var1, 1);
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.dispenserContents[var1] = var2;
        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    public String getInvName() {
        return "Trap";
    }

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items");
        this.dispenserContents = new ItemStack[this.getSizeInventory()];

        for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            int var5 = var4.getByte("Slot") & 255;
            if (var5 >= 0 && var5 < this.dispenserContents.length) {
                this.dispenserContents[var5] = new ItemStack(var4);
            }
        }

    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        NBTTagList var2 = new NBTTagList();

        for(int var3 = 0; var3 < this.dispenserContents.length; ++var3) {
            if (this.dispenserContents[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.dispenserContents[var3].writeToNBT(var4);
                var2.setTag(var4);
            }
        }

        var1.setTag("Items", var2);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean canInteractWith(EntityPlayer var1) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        } else {
            return var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
        }
    }
}
