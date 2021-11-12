package net.minecraft.src;

import java.util.Random;

public class BlockMushroom extends BlockFlower {
    protected BlockMushroom(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.2F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
        this.setTickOnLoad(true);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(100) == 0) {
            int var6 = var2 + var5.nextInt(3) - 1;
            int var7 = var3 + var5.nextInt(2) - var5.nextInt(2);
            int var8 = var4 + var5.nextInt(3) - 1;
            if (var1.isAirBlock(var6, var7, var8) && this.canBlockStay(var1, var6, var7, var8)) {
                int var10000 = var2 + (var5.nextInt(3) - 1);
                var10000 = var4 + (var5.nextInt(3) - 1);
                if (var1.isAirBlock(var6, var7, var8) && this.canBlockStay(var1, var6, var7, var8)) {
                    var1.setBlockWithNotify(var6, var7, var8, this.blockID);
                }
            }
        }

    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1) {
        return Block.opaqueCubeLookup[var1];
    }

    public boolean canBlockStay(World var1, int var2, int var3, int var4) {
        if (var3 >= 0 && var3 < 128) {
            return var1.getFullBlockLightValue(var2, var3, var4) < 13 && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
        } else {
            return false;
        }
    }
}
