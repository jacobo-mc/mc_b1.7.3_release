package net.minecraft.src;

public class ItemRedstone extends Item {
    public ItemRedstone(int var1) {
        super(var1);
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.getBlockId(var4, var5, var6) != Block.snow.blockID) {
            if (var7 == 0) {
                --var5;
            }

            if (var7 == 1) {
                ++var5;
            }

            if (var7 == 2) {
                --var6;
            }

            if (var7 == 3) {
                ++var6;
            }

            if (var7 == 4) {
                --var4;
            }

            if (var7 == 5) {
                ++var4;
            }

            if (!var3.isAirBlock(var4, var5, var6)) {
                return false;
            }
        }

        if (Block.redstoneWire.canPlaceBlockAt(var3, var4, var5, var6)) {
            --var1.stackSize;
            var3.setBlockWithNotify(var4, var5, var6, Block.redstoneWire.blockID);
        }

        return true;
    }
}
