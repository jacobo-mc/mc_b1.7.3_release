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

    public int idDropped(int var1, Random var2) {
        return var2.nextInt(8) == 0 ? Item.seeds.shiftedIndex : -1;
    }
}
