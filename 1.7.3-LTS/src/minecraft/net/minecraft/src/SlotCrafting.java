package net.minecraft.src;

public class SlotCrafting extends Slot {
    private final IInventory craftMatrix;
    private EntityPlayer thePlayer;

    public SlotCrafting(EntityPlayer var1, IInventory var2, IInventory var3, int var4, int var5, int var6) {
        super(var3, var4, var5, var6);
        this.thePlayer = var1;
        this.craftMatrix = var2;
    }

    public boolean isItemValid(ItemStack var1) {
        return false;
    }

    public void onPickupFromSlot(ItemStack var1) {
        var1.onCrafting(this.thePlayer.worldObj, this.thePlayer);
        if (var1.itemID == Block.workbench.blockID) {
            this.thePlayer.addStat(AchievementList.buildWorkBench, 1);
        } else if (var1.itemID == Item.pickaxeWood.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.buildPickaxe, 1);
        } else if (var1.itemID == Block.stoneOvenIdle.blockID) {
            this.thePlayer.addStat(AchievementList.buildFurnace, 1);
        } else if (var1.itemID == Item.hoeWood.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.buildHoe, 1);
        } else if (var1.itemID == Item.bread.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.makeBread, 1);
        } else if (var1.itemID == Item.cake.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.bakeCake, 1);
        } else if (var1.itemID == Item.pickaxeStone.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.buildBetterPickaxe, 1);
        } else if (var1.itemID == Item.swordWood.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.buildSword, 1);
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
