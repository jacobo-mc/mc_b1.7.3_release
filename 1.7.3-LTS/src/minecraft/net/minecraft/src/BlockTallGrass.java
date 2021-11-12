package net.minecraft.src;

import java.util.Random;

public class BlockTallGrass extends BlockFlower {
    protected BlockTallGrass(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var2 == 1) {
            return this.blockIndexInTexture;
        } else if (var2 == 2) {
            return this.blockIndexInTexture + 16 + 1;
        } else {
            return var2 == 0 ? this.blockIndexInTexture + 16 : this.blockIndexInTexture;
        }
    }

    public int colorMultiplier(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        if (var5 == 0) {
            return 16777215;
        } else {
            long var6 = (long)(var2 * 3129871 + var4 * 6129781 + var3);
            var6 = var6 * var6 * 42317861L + var6 * 11L;
            var2 = (int)((long)var2 + (var6 >> 14 & 31L));
            var3 = (int)((long)var3 + (var6 >> 19 & 31L));
            var4 = (int)((long)var4 + (var6 >> 24 & 31L));
            var1.getWorldChunkManager().getBiomeGenBaseAt(var2, var4, 1, 1);
            double var8 = var1.getWorldChunkManager().temperature[0];
            double var10 = var1.getWorldChunkManager().humidity[0];
            return ColorizerGrass.getGrassColor(var8, var10);
        }
    }

    public int idDropped(int var1, Random var2) {
        return var2.nextInt(8) == 0 ? Item.seeds.shiftedIndex : -1;
    }
}
