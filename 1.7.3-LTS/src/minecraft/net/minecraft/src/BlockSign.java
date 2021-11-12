package net.minecraft.src;

import java.util.Random;

public class BlockSign extends BlockContainer {
    private Class signEntityClass;
    private boolean isFreestanding;

    protected BlockSign(int var1, Class var2, boolean var3) {
        super(var1, Material.wood);
        this.isFreestanding = var3;
        this.blockIndexInTexture = 4;
        this.signEntityClass = var2;
        float var4 = 0.25F;
        float var5 = 1.0F;
        this.setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var5, 0.5F + var4);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return null;
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        this.setBlockBoundsBasedOnState(var1, var2, var3, var4);
        return super.getSelectedBoundingBoxFromPool(var1, var2, var3, var4);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        if (!this.isFreestanding) {
            int var5 = var1.getBlockMetadata(var2, var3, var4);
            float var6 = 0.28125F;
            float var7 = 0.78125F;
            float var8 = 0.0F;
            float var9 = 1.0F;
            float var10 = 0.125F;
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            if (var5 == 2) {
                this.setBlockBounds(var8, var6, 1.0F - var10, var9, var7, 1.0F);
            }

            if (var5 == 3) {
                this.setBlockBounds(var8, var6, 0.0F, var9, var7, var10);
            }

            if (var5 == 4) {
                this.setBlockBounds(1.0F - var10, var6, var8, 1.0F, var7, var9);
            }

            if (var5 == 5) {
                this.setBlockBounds(0.0F, var6, var8, var10, var7, var9);
            }

        }
    }

    public int getRenderType() {
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    protected TileEntity getBlockEntity() {
        try {
            return (TileEntity)this.signEntityClass.newInstance();
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public int idDropped(int var1, Random var2) {
        return Item.sign.shiftedIndex;
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        boolean var6 = false;
        if (this.isFreestanding) {
            if (!var1.getBlockMaterial(var2, var3 - 1, var4).isSolid()) {
                var6 = true;
            }
        } else {
            int var7 = var1.getBlockMetadata(var2, var3, var4);
            var6 = true;
            if (var7 == 2 && var1.getBlockMaterial(var2, var3, var4 + 1).isSolid()) {
                var6 = false;
            }

            if (var7 == 3 && var1.getBlockMaterial(var2, var3, var4 - 1).isSolid()) {
                var6 = false;
            }

            if (var7 == 4 && var1.getBlockMaterial(var2 + 1, var3, var4).isSolid()) {
                var6 = false;
            }

            if (var7 == 5 && var1.getBlockMaterial(var2 - 1, var3, var4).isSolid()) {
                var6 = false;
            }
        }

        if (var6) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }

        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
    }
}
