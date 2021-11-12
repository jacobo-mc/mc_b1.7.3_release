package net.minecraft.src;

import java.util.Random;

public class BlockTorch extends Block {
    protected BlockTorch(int var1, int var2) {
        super(var1, var2, Material.circuits);
        this.setTickOnLoad(true);
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
        return 2;
    }

    private boolean canPlaceTorchOn(World var1, int var2, int var3, int var4) {
        return var1.isBlockNormalCube(var2, var3, var4) || var1.getBlockId(var2, var3, var4) == Block.fence.blockID;
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        if (var1.isBlockNormalCube(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.isBlockNormalCube(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.isBlockNormalCube(var2, var3, var4 - 1)) {
            return true;
        } else if (var1.isBlockNormalCube(var2, var3, var4 + 1)) {
            return true;
        } else {
            return this.canPlaceTorchOn(var1, var2, var3 - 1, var4);
        }
    }

    public void onBlockPlaced(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        if (var5 == 1 && this.canPlaceTorchOn(var1, var2, var3 - 1, var4)) {
            var6 = 5;
        }

        if (var5 == 2 && var1.isBlockNormalCube(var2, var3, var4 + 1)) {
            var6 = 4;
        }

        if (var5 == 3 && var1.isBlockNormalCube(var2, var3, var4 - 1)) {
            var6 = 3;
        }

        if (var5 == 4 && var1.isBlockNormalCube(var2 + 1, var3, var4)) {
            var6 = 2;
        }

        if (var5 == 5 && var1.isBlockNormalCube(var2 - 1, var3, var4)) {
            var6 = 1;
        }

        var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        super.updateTick(var1, var2, var3, var4, var5);
        if (var1.getBlockMetadata(var2, var3, var4) == 0) {
            this.onBlockAdded(var1, var2, var3, var4);
        }

    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        if (var1.isBlockNormalCube(var2 - 1, var3, var4)) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 1);
        } else if (var1.isBlockNormalCube(var2 + 1, var3, var4)) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 2);
        } else if (var1.isBlockNormalCube(var2, var3, var4 - 1)) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 3);
        } else if (var1.isBlockNormalCube(var2, var3, var4 + 1)) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 4);
        } else if (this.canPlaceTorchOn(var1, var2, var3 - 1, var4)) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 5);
        }

        this.dropTorchIfCantStay(var1, var2, var3, var4);
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (this.dropTorchIfCantStay(var1, var2, var3, var4)) {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            boolean var7 = false;
            if (!var1.isBlockNormalCube(var2 - 1, var3, var4) && var6 == 1) {
                var7 = true;
            }

            if (!var1.isBlockNormalCube(var2 + 1, var3, var4) && var6 == 2) {
                var7 = true;
            }

            if (!var1.isBlockNormalCube(var2, var3, var4 - 1) && var6 == 3) {
                var7 = true;
            }

            if (!var1.isBlockNormalCube(var2, var3, var4 + 1) && var6 == 4) {
                var7 = true;
            }

            if (!this.canPlaceTorchOn(var1, var2, var3 - 1, var4) && var6 == 5) {
                var7 = true;
            }

            if (var7) {
                this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
                var1.setBlockWithNotify(var2, var3, var4, 0);
            }
        }

    }

    private boolean dropTorchIfCantStay(World var1, int var2, int var3, int var4) {
        if (!this.canPlaceBlockAt(var1, var2, var3, var4)) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public MovingObjectPosition collisionRayTrace(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        int var7 = var1.getBlockMetadata(var2, var3, var4) & 7;
        float var8 = 0.15F;
        if (var7 == 1) {
            this.setBlockBounds(0.0F, 0.2F, 0.5F - var8, var8 * 2.0F, 0.8F, 0.5F + var8);
        } else if (var7 == 2) {
            this.setBlockBounds(1.0F - var8 * 2.0F, 0.2F, 0.5F - var8, 1.0F, 0.8F, 0.5F + var8);
        } else if (var7 == 3) {
            this.setBlockBounds(0.5F - var8, 0.2F, 0.0F, 0.5F + var8, 0.8F, var8 * 2.0F);
        } else if (var7 == 4) {
            this.setBlockBounds(0.5F - var8, 0.2F, 1.0F - var8 * 2.0F, 0.5F + var8, 0.8F, 1.0F);
        } else {
            var8 = 0.1F;
            this.setBlockBounds(0.5F - var8, 0.0F, 0.5F - var8, 0.5F + var8, 0.6F, 0.5F + var8);
        }

        return super.collisionRayTrace(var1, var2, var3, var4, var5, var6);
    }

    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        double var7 = (double)((float)var2 + 0.5F);
        double var9 = (double)((float)var3 + 0.7F);
        double var11 = (double)((float)var4 + 0.5F);
        double var13 = 0.2199999988079071D;
        double var15 = 0.27000001072883606D;
        if (var6 == 1) {
            var1.spawnParticle("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            var1.spawnParticle("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 2) {
            var1.spawnParticle("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
            var1.spawnParticle("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 3) {
            var1.spawnParticle("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
            var1.spawnParticle("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
        } else if (var6 == 4) {
            var1.spawnParticle("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
            var1.spawnParticle("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
        } else {
            var1.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
            var1.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
        }

    }
}
