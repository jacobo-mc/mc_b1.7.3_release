package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockPressurePlate extends Block {
    private EnumMobType triggerMobType;

    protected BlockPressurePlate(int var1, int var2, EnumMobType var3, Material var4) {
        super(var1, var2, var4);
        this.triggerMobType = var3;
        this.setTickOnLoad(true);
        float var5 = 0.0625F;
        this.setBlockBounds(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
    }

    public int tickRate() {
        return 20;
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

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return var1.isBlockNormalCube(var2, var3 - 1, var4);
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        boolean var6 = false;
        if (!var1.isBlockNormalCube(var2, var3 - 1, var4)) {
            var6 = true;
        }

        if (var6) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }

    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.multiplayerWorld) {
            if (var1.getBlockMetadata(var2, var3, var4) != 0) {
                this.setStateIfMobInteractsWithPlate(var1, var2, var3, var4);
            }
        }
    }

    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
        if (!var1.multiplayerWorld) {
            if (var1.getBlockMetadata(var2, var3, var4) != 1) {
                this.setStateIfMobInteractsWithPlate(var1, var2, var3, var4);
            }
        }
    }

    private void setStateIfMobInteractsWithPlate(World var1, int var2, int var3, int var4) {
        boolean var5 = var1.getBlockMetadata(var2, var3, var4) == 1;
        boolean var6 = false;
        float var7 = 0.125F;
        List var8 = null;
        if (this.triggerMobType == EnumMobType.everything) {
            var8 = var1.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (this.triggerMobType == EnumMobType.mobs) {
            var8 = var1.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (this.triggerMobType == EnumMobType.players) {
            var8 = var1.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
        }

        if (var8.size() > 0) {
            var6 = true;
        }

        if (var6 && !var5) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 1);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
            var1.markBlocksDirty(var2, var3, var4, var2, var3, var4);
            var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.6F);
        }

        if (!var6 && var5) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 0);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
            var1.markBlocksDirty(var2, var3, var4, var2, var3, var4);
            var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.5F);
        }

        if (var6) {
            var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate());
        }

    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        if (var5 > 0) {
            var1.notifyBlocksOfNeighborChange(var2, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
        }

        super.onBlockRemoval(var1, var2, var3, var4);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        boolean var5 = var1.getBlockMetadata(var2, var3, var4) == 1;
        float var6 = 0.0625F;
        if (var5) {
            this.setBlockBounds(var6, 0.0F, var6, 1.0F - var6, 0.03125F, 1.0F - var6);
        } else {
            this.setBlockBounds(var6, 0.0F, var6, 1.0F - var6, 0.0625F, 1.0F - var6);
        }

    }

    public boolean isPoweringTo(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var1.getBlockMetadata(var2, var3, var4) > 0;
    }

    public boolean isIndirectlyPoweringTo(World var1, int var2, int var3, int var4, int var5) {
        if (var1.getBlockMetadata(var2, var3, var4) == 0) {
            return false;
        } else {
            return var5 == 1;
        }
    }

    public boolean canProvidePower() {
        return true;
    }

    public void setBlockBoundsForItemRender() {
        float var1 = 0.5F;
        float var2 = 0.125F;
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
    }

    public int getMobilityFlag() {
        return 1;
    }
}
