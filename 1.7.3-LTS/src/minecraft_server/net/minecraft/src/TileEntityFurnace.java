package net.minecraft.src;

public class TileEntityFurnace extends TileEntity implements IInventory {
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;

    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int var1) {
        return this.furnaceItemStacks[var1];
    }

    public ItemStack decrStackSize(int var1, int var2) {
        if (this.furnaceItemStacks[var1] != null) {
            ItemStack var3;
            if (this.furnaceItemStacks[var1].stackSize <= var2) {
                var3 = this.furnaceItemStacks[var1];
                this.furnaceItemStacks[var1] = null;
                return var3;
            } else {
                var3 = this.furnaceItemStacks[var1].splitStack(var2);
                if (this.furnaceItemStacks[var1].stackSize == 0) {
                    this.furnaceItemStacks[var1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.furnaceItemStacks[var1] = var2;
        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }

    }

    public String getInvName() {
        return "Furnace";
    }

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[var5] = new ItemStack(var4);
            }
        }

        this.furnaceBurnTime = var1.getShort("BurnTime");
        this.furnaceCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setShort("BurnTime", (short)this.furnaceBurnTime);
        var1.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for(int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3) {
            if (this.furnaceItemStacks[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.furnaceItemStacks[var3].writeToNBT(var4);
                var2.setTag(var4);
            }
        }

        var1.setTag("Items", var2);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity() {
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.singleplayerWorld) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
                if (this.furnaceBurnTime > 0) {
                    var2 = true;
                    if (this.furnaceItemStacks[1] != null) {
                        --this.furnaceItemStacks[1].stackSize;
                        if (this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if (this.furnaceCookTime == 200) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceBurnTime > 0) {
                var2 = true;
                BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2) {
            this.onInventoryChanged();
        }

    }

    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        } else {
            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0].getItem().shiftedIndex);
            if (var1 == null) {
                return false;
            } else if (this.furnaceItemStacks[2] == null) {
                return true;
            } else if (!this.furnaceItemStacks[2].isItemEqual(var1)) {
                return false;
            } else if (this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) {
                return true;
            } else {
                return this.furnaceItemStacks[2].stackSize < var1.getMaxStackSize();
            }
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0].getItem().shiftedIndex);
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = var1.copy();
            } else if (this.furnaceItemStacks[2].itemID == var1.itemID) {
                ++this.furnaceItemStacks[2].stackSize;
            }

            --this.furnaceItemStacks[0].stackSize;
            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }

        }
    }

    private int getItemBurnTime(ItemStack var1) {
        if (var1 == null) {
            return 0;
        } else {
            int var2 = var1.getItem().shiftedIndex;
            if (var2 < 256 && Block.blocksList[var2].blockMaterial == Material.wood) {
                return 300;
            } else if (var2 == Item.stick.shiftedIndex) {
                return 100;
            } else if (var2 == Item.coal.shiftedIndex) {
                return 1600;
            } else if (var2 == Item.bucketLava.shiftedIndex) {
                return 20000;
            } else {
                return var2 == Block.sapling.blockID ? 100 : 0;
            }
        }
    }

    public boolean canInteractWith(EntityPlayer var1) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        } else {
            return var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
        }
    }
}
