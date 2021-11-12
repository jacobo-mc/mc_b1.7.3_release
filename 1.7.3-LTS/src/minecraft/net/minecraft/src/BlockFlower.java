package net.minecraft.src;

import java.util.Random;

public class BlockFlower extends Block {
    protected BlockFlower(int var1, int var2) {
        super(var1, Material.plants);
        this.blockIndexInTexture = var2;
        this.setTickOnLoad(true);
        float var3 = 0.2F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return super.canPlaceBlockAt(var1, var2, var3, var4) && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1) {
        return var1 == Block.grass.blockID || var1 == Block.dirt.blockID || var1 == Block.tilledField.blockID;
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
        this.checkFlowerChange(var1, var2, var3, var4);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        this.checkFlowerChange(var1, var2, var3, var4);
    }

    protected final void checkFlowerChange(World var1, int var2, int var3, int var4) {
        if (!this.canBlockStay(var1, var2, var3, var4)) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }

    }

    public boolean canBlockStay(World var1, int var2, int var3, int var4) {
        return (var1.getFullBlockLightValue(var2, var3, var4) >= 8 || var1.canBlockSeeTheSky(var2, var3, var4)) && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }
}
