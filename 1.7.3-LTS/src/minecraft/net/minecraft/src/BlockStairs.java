package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockStairs extends Block {
    private Block modelBlock;

    protected BlockStairs(int var1, Block var2) {
        super(var1, var2.blockIndexInTexture, var2.blockMaterial);
        this.modelBlock = var2;
        this.setHardness(var2.blockHardness);
        this.setResistance(var2.blockResistance / 3.0F);
        this.setStepSound(var2.stepSound);
        this.setLightOpacity(255);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return super.getCollisionBoundingBoxFromPool(var1, var2, var3, var4);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 10;
    }

    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return super.shouldSideBeRendered(var1, var2, var3, var4, var5);
    }

    public void getCollidingBoundingBoxes(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        int var7 = var1.getBlockMetadata(var2, var3, var4);
        if (var7 == 0) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 1) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 2) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
        } else if (var7 == 3) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
        }

        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {
        this.modelBlock.randomDisplayTick(var1, var2, var3, var4, var5);
    }

    public void onBlockClicked(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.modelBlock.onBlockClicked(var1, var2, var3, var4, var5);
    }

    public void onBlockDestroyedByPlayer(World var1, int var2, int var3, int var4, int var5) {
        this.modelBlock.onBlockDestroyedByPlayer(var1, var2, var3, var4, var5);
    }

    public float getBlockBrightness(IBlockAccess var1, int var2, int var3, int var4) {
        return this.modelBlock.getBlockBrightness(var1, var2, var3, var4);
    }

    public float getExplosionResistance(Entity var1) {
        return this.modelBlock.getExplosionResistance(var1);
    }

    public int getRenderBlockPass() {
        return this.modelBlock.getRenderBlockPass();
    }

    public int idDropped(int var1, Random var2) {
        return this.modelBlock.idDropped(var1, var2);
    }

    public int quantityDropped(Random var1) {
        return this.modelBlock.quantityDropped(var1);
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        return this.modelBlock.getBlockTextureFromSideAndMetadata(var1, var2);
    }

    public int getBlockTextureFromSide(int var1) {
        return this.modelBlock.getBlockTextureFromSide(var1);
    }

    public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return this.modelBlock.getBlockTexture(var1, var2, var3, var4, var5);
    }

    public int tickRate() {
        return this.modelBlock.tickRate();
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return this.modelBlock.getSelectedBoundingBoxFromPool(var1, var2, var3, var4);
    }

    public void velocityToAddToEntity(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
        this.modelBlock.velocityToAddToEntity(var1, var2, var3, var4, var5, var6);
    }

    public boolean isCollidable() {
        return this.modelBlock.isCollidable();
    }

    public boolean canCollideCheck(int var1, boolean var2) {
        return this.modelBlock.canCollideCheck(var1, var2);
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return this.modelBlock.canPlaceBlockAt(var1, var2, var3, var4);
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        this.onNeighborBlockChange(var1, var2, var3, var4, 0);
        this.modelBlock.onBlockAdded(var1, var2, var3, var4);
    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
        this.modelBlock.onBlockRemoval(var1, var2, var3, var4);
    }

    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
        this.modelBlock.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
    }

    public void onEntityWalking(World var1, int var2, int var3, int var4, Entity var5) {
        this.modelBlock.onEntityWalking(var1, var2, var3, var4, var5);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        this.modelBlock.updateTick(var1, var2, var3, var4, var5);
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        return this.modelBlock.blockActivated(var1, var2, var3, var4, var5);
    }

    public void onBlockDestroyedByExplosion(World var1, int var2, int var3, int var4) {
        this.modelBlock.onBlockDestroyedByExplosion(var1, var2, var3, var4);
    }

    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 2);
        }

        if (var6 == 1) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 1);
        }

        if (var6 == 2) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 3);
        }

        if (var6 == 3) {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 0);
        }

    }
}
