package net.minecraft.src;

import java.util.Random;

public class BlockGrass extends Block {
    protected BlockGrass(int var1) {
        super(var1, Material.grassMaterial);
        this.blockIndexInTexture = 3;
        this.setTickOnLoad(true);
    }

    public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1) {
            return 0;
        } else if (var5 == 0) {
            return 2;
        } else {
            Material var6 = var1.getBlockMaterial(var2, var3 + 1, var4);
            return var6 != Material.snow && var6 != Material.builtSnow ? 3 : 68;
        }
    }

    public int colorMultiplier(IBlockAccess var1, int var2, int var3, int var4) {
        var1.getWorldChunkManager().getBiomeGenBaseAt(var2, var4, 1, 1);
        double var5 = var1.getWorldChunkManager().temperature[0];
        double var7 = var1.getWorldChunkManager().humidity[0];
        return ColorizerGrass.getGrassColor(var5, var7);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.multiplayerWorld) {
            if (var1.getBlockLightValue(var2, var3 + 1, var4) < 4 && Block.lightOpacity[var1.getBlockId(var2, var3 + 1, var4)] > 2) {
                if (var5.nextInt(4) != 0) {
                    return;
                }

                var1.setBlockWithNotify(var2, var3, var4, Block.dirt.blockID);
            } else if (var1.getBlockLightValue(var2, var3 + 1, var4) >= 9) {
                int var6 = var2 + var5.nextInt(3) - 1;
                int var7 = var3 + var5.nextInt(5) - 3;
                int var8 = var4 + var5.nextInt(3) - 1;
                int var9 = var1.getBlockId(var6, var7 + 1, var8);
                if (var1.getBlockId(var6, var7, var8) == Block.dirt.blockID && var1.getBlockLightValue(var6, var7 + 1, var8) >= 4 && Block.lightOpacity[var9] <= 2) {
                    var1.setBlockWithNotify(var6, var7, var8, Block.grass.blockID);
                }
            }

        }
    }

    public int idDropped(int var1, Random var2) {
        return Block.dirt.idDropped(0, var2);
    }
}
