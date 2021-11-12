package net.minecraft.src;

public class SlotCrafting extends Slot {
    private final IInventory craftMatrix;
    private EntityPlayer field_25004_e;

    public SlotCrafting(EntityPlayer var1, IInventory var2, IInventory var3, int var4, int var5, int var6) {
        super(var3, var4, var5, var6);
        this.field_25004_e = var1;
        this.craftMatrix = var2;
    }

    public boolean isItemValid(ItemStack var1) {
        return false;
    }

    public void onPickupFromSlot(ItemStack var1) {
        var1.func_28142_b(this.field_25004_e.worldObj, this.field_25004_e);
        if (var1.itemID == Block.workbench.blockID) {
            this.field_25004_e.addStat(AchievementList.field_25130_d, 1);
        } else if (var1.itemID == Item.pickaxeWood.shiftedIndex) {
            this.field_25004_e.addStat(AchievementList.field_27110_i, 1);
        } else if (var1.itemID == Block.stoneOvenIdle.blockID) {
            this.field_25004_e.addStat(AchievementList.field_27109_j, 1);
        } else if (var1.itemID == Item.hoeWood.shiftedIndex) {
            this.field_25004_e.addStat(AchievementList.field_27107_l, 1);
        } else if (var1.itemID == Item.bread.shiftedIndex) {
            this.field_25004_e.addStat(AchievementList.field_27106_m, 1);
        } else if (var1.itemID == Item.cake.shiftedIndex) {
            this.field_25004_e.addStat(AchievementList.field_27105_n, 1);
        } else if (var1.itemID == Item.pickaxeStone.shiftedIndex) {
            this.field_25004_e.addStat(AchievementList.field_27104_o, 1);
        } else if (var1.itemID == Item.swordWood.shiftedIndex) {
            this.field_25004_e.addStat(AchievementList.field_27101_r, 1);
        }

        for(int var2 = 0; var2 < this.craftMatrix.getSizeInventory(); ++var2) {
            ItemStack var3 = this.craftMatrix.getStackInSlot(var2);
            if (var3 != null) {
                this.craftMatrix.decrStackSize(var2, 1);
                if (var3.getItem().hasContainerItem()) {
                    this.craftMatrix.setInventorySlotContents(var2, new ItemStack(var3.getItem().getContainerItem()));
                }
            }
        }

    }
}
