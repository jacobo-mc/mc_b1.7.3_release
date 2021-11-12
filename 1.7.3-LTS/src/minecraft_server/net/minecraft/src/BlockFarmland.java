package net.minecraft.src;

import java.util.Random;

public class BlockFarmland extends Block {
    protected BlockFarmland(int var1) {
        super(var1, Material.ground);
        this.blockIndexInTexture = 87;
        this.setTickOnLoad(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return AxisAlignedBB.getBoundingBoxFromPool((double)(var2 + 0), (double)(var3 + 0), (double)(var4 + 0), (double)(var2 + 1), (double)(var3 + 1), (double)(var4 + 1));
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isACube() {
        return false;
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var1 == 1 && var2 > 0) {
            return this.blockIndexInTexture - 1;
        } else {
            return var1 == 1 ? this.blockIndexInTexture : 2;
        }
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(5) == 0) {
            if (!this.isWaterNearby(var1, var2, var3, var4) && !var1.canLightningStrikeAt(var2, var3 + 1, var4)) {
                int var6 = var1.getBlockMetadata(var2, var3, var4);
                if (var6 > 0) {
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var6 - 1);
                } else if (!this.isCropsNearby(var1, var2, var3, var4)) {
                    var1.setBlockWithNotify(var2, var3, var4, Block.dirt.blockID);
                }
            } else {
                var1.setBlockMetadataWithNotify(var2, var3, var4, 7);
            }
        }

    }

    public void onEntityWalking(World var1, int var2, int var3, int var4, Entity var5) {
        if (var1.rand.nextInt(4) == 0) {
            var1.setBlockWithNotify(var2, var3, var4, Block.dirt.blockID);
        }

    }

    private boolean isCropsNearby(World var1, int var2, int var3, int var4) {
        byte var5 = 0;

        for(int var6 = var2 - var5; var6 <= var2 + var5; ++var6) {
            for(int var7 = var4 - var5; var7 <= var4 + var5; ++var7) {
                if (var1.getBlockId(var6, var3 + 1, var7) == Block.crops.blockID) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isWaterNearby(World var1, int var2, int var3, int var4) {
        for(int var5 = var2 - 4; var5 <= var2 + 4; ++var5) {
            for(int var6 = var3; var6 <= var3 + 1; ++var6) {
                for(int var7 = var4 - 4; var7 <= var4 + 4; ++var7) {
                    if (var1.getBlockMaterial(var5, var6, var7) == Material.water) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
        Material var6 = var1.getBlockMaterial(var2, var3 + 1, var4);
        if (var6.isSolid()) {
            var1.setBlockWithNotify(var2, var3, var4, Block.dirt.blockID);
        }

    }

    public int idDropped(int var1, Random var2) {
        return Block.dirt.idDropped(0, var2);
    }
}
