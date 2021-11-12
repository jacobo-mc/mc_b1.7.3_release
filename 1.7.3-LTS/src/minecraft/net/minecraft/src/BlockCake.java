package net.minecraft.src;

import java.util.Random;

public class BlockCake extends Block {
    protected BlockCake(int var1, int var2) {
        super(var1, var2, Material.cakeMaterial);
        this.setTickOnLoad(true);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        this.setBlockBounds(var7, 0.0F, var6, 1.0F - var6, var8, 1.0F - var6);
    }

    public void setBlockBoundsForItemRender() {
        float var1 = 0.0625F;
        float var2 = 0.5F;
        this.setBlockBounds(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        return AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var6), (double)((float)(var2 + 1) - var6), (double)((float)var3 + var8 - var6), (double)((float)(var4 + 1) - var6));
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        float var6 = 0.0625F;
        float var7 = (float)(1 + var5 * 2) / 16.0F;
        float var8 = 0.5F;
        return AxisAlignedBB.getBoundingBoxFromPool((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var6), (double)((float)(var2 + 1) - var6), (double)((float)var3 + var8), (double)((float)(var4 + 1) - var6));
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var1 == 1) {
            return this.blockIndexInTexture;
        } else if (var1 == 0) {
            return this.blockIndexInTexture + 3;
        } else {
            return var2 > 0 && var1 == 4 ? this.blockIndexInTexture + 2 : this.blockIndexInTexture + 1;
        }
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture;
        } else {
            return var1 == 0 ? this.blockIndexInTexture + 3 : this.blockIndexInTexture + 1;
        }
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.eatCakeSlice(var1, var2, var3, var4, var5);
        return true;
    }

    public void onBlockClicked(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.eatCakeSlice(var1, var2, var3, var4, var5);
    }

    private void eatCakeSlice(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var5.health < 20) {
            var5.heal(3);
            int var6 = var1.getBlockMetadata(var2, var3, var4) + 1;
            if (var6 >= 6) {
                var1.setBlockWithNotify(var2, var3, var4, 0);
            } else {
                var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
                var1.markBlockAsNeedsUpdate(var2, var3, var4);
            }
        }

    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return !super.canPlaceBlockAt(var1, var2, var3, var4) ? false : this.canBlockStay(var1, var2, var3, var4);
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (!this.canBlockStay(var1, var2, var3, var4)) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }

    }

    public boolean canBlockStay(World var1, int var2, int var3, int var4) {
        return var1.getBlockMaterial(var2, var3 - 1, var4).isSolid();
    }

    public int quantityDropped(Random var1) {
        return 0;
    }

    public int idDropped(int var1, Random var2) {
        return 0;
    }
}
