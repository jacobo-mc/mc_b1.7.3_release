package net.minecraft.src;

import java.util.Random;

public class BlockDeadBush extends BlockFlower {
    protected BlockDeadBush(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1) {
        return var1 == Block.sand.blockID;
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        return this.blockIndexInTexture;
    }

    public int idDropped(int var1, Random var2) {
        return -1;
    }
}
