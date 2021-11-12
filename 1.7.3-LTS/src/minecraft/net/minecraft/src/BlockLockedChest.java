package net.minecraft.src;

import java.util.Random;

public class BlockLockedChest extends Block {
    protected BlockLockedChest(int var1) {
        super(var1, Material.wood);
        this.blockIndexInTexture = 26;
    }

    public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1) {
            return this.blockIndexInTexture - 1;
        } else if (var5 == 0) {
            return this.blockIndexInTexture - 1;
        } else {
            int var6 = var1.getBlockId(var2, var3, var4 - 1);
            int var7 = var1.getBlockId(var2, var3, var4 + 1);
            int var8 = var1.getBlockId(var2 - 1, var3, var4);
            int var9 = var1.getBlockId(var2 + 1, var3, var4);
            byte var10 = 3;
            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var7]) {
                var10 = 3;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var6]) {
                var10 = 2;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var9]) {
                var10 = 5;
            }

            if (Block.opaqueCubeLookup[var9] && !Block.opaqueCubeLookup[var8]) {
                var10 = 4;
            }

            return var5 == var10 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture;
        }
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture - 1;
        } else if (var1 == 0) {
            return this.blockIndexInTexture - 1;
        } else {
            return var1 == 3 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture;
        }
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        var1.setBlockWithNotify(var2, var3, var4, 0);
    }
}
