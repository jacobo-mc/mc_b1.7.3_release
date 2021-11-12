package net.minecraft.src;

public class ItemMinecart extends Item {
    public int minecartType;

    public ItemMinecart(int var1, int var2) {
        super(var1);
        this.maxStackSize = 1;
        this.minecartType = var2;
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        int var8 = var3.getBlockId(var4, var5, var6);
        if (BlockRail.isRailBlock(var8)) {
            if (!var3.multiplayerWorld) {
                var3.entityJoinedWorld(new EntityMinecart(var3, (double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), this.minecartType));
            }

            --var1.stackSize;
            return true;
        } else {
            return false;
        }
    }
}
