package net.minecraft.src;

public class ItemReed extends Item {
    private int spawnID;

    public ItemReed(int var1, Block var2) {
        super(var1);
        this.spawnID = var2.blockID;
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.getBlockId(var4, var5, var6) == Block.snow.blockID) {
            var7 = 0;
        } else {
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
        }

        if (var1.stackSize == 0) {
            return false;
        } else {
            if (var3.canBlockBePlacedAt(this.spawnID, var4, var5, var6, false, var7)) {
                Block var8 = Block.blocksList[this.spawnID];
                if (var3.setBlockWithNotify(var4, var5, var6, this.spawnID)) {
                    Block.blocksList[this.spawnID].onBlockPlaced(var3, var4, var5, var6, var7);
                    Block.blocksList[this.spawnID].onBlockPlacedBy(var3, var4, var5, var6, var2);
                    var3.playSoundEffect((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var8.stepSound.stepSoundDir2(), (var8.stepSound.getVolume() + 1.0F) / 2.0F, var8.stepSound.getPitch() * 0.8F);
                    --var1.stackSize;
                }
            }

            return true;
        }
    }
}
