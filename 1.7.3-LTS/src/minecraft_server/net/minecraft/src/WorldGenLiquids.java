package net.minecraft.src;

import java.util.Random;

public class WorldGenLiquids extends WorldGenerator {
    private int liquidBlockId;

    public WorldGenLiquids(int var1) {
        this.liquidBlockId = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
        if (var1.getBlockId(var3, var4 + 1, var5) != Block.stone.blockID) {
            return false;
        } else if (var1.getBlockId(var3, var4 - 1, var5) != Block.stone.blockID) {
            return false;
        } else if (var1.getBlockId(var3, var4, var5) != 0 && var1.getBlockId(var3, var4, var5) != Block.stone.blockID) {
            return false;
        } else {
            int var6 = 0;
            if (var1.getBlockId(var3 - 1, var4, var5) == Block.stone.blockID) {
                ++var6;
            }

            if (var1.getBlockId(var3 + 1, var4, var5) == Block.stone.blockID) {
                ++var6;
            }

            if (var1.getBlockId(var3, var4, var5 - 1) == Block.stone.blockID) {
                ++var6;
            }

            if (var1.getBlockId(var3, var4, var5 + 1) == Block.stone.blockID) {
                ++var6;
            }

            int var7 = 0;
            if (var1.isAirBlock(var3 - 1, var4, var5)) {
                ++var7;
            }

            if (var1.isAirBlock(var3 + 1, var4, var5)) {
                ++var7;
            }

            if (var1.isAirBlock(var3, var4, var5 - 1)) {
                ++var7;
            }

            if (var1.isAirBlock(var3, var4, var5 + 1)) {
                ++var7;
            }

            if (var6 == 3 && var7 == 1) {
                var1.setBlockWithNotify(var3, var4, var5, this.liquidBlockId);
                var1.scheduledUpdatesAreImmediate = true;
                Block.blocksList[this.liquidBlockId].updateTick(var1, var3, var4, var5, var2);
                var1.scheduledUpdatesAreImmediate = false;
            }

            return true;
        }
    }
}
