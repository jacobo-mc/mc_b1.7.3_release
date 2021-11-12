package net.minecraft.src;

public class SlotFurnace extends Slot {
    private EntityPlayer thePlayer;

    public SlotFurnace(EntityPlayer var1, IInventory var2, int var3, int var4, int var5) {
        super(var2, var3, var4, var5);
        this.thePlayer = var1;
    }

    public boolean isItemValid(ItemStack var1) {
        return false;
    }

    public void onPickupFromSlot(ItemStack var1) {
        var1.onCrafting(this.thePlayer.worldObj, this.thePlayer);
        if (var1.itemID == Item.ingotIron.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.acquireIron, 1);
        }

        if (var1.itemID == Item.fishCooked.shiftedIndex) {
            this.thePlayer.addStat(AchievementList.cookFish, 1);
        }

        super.onPickupFromSlot(var1);
    }
}
