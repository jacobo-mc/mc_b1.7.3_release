package net.minecraft.src;

import java.util.Random;

public class BlockPistonMoving extends BlockContainer {
    public BlockPistonMoving(int var1) {
        super(var1, Material.piston);
        this.setHardness(-1.0F);
    }

    protected TileEntity getBlockEntity() {
        return null;
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
        TileEntity var5 = var1.getBlockTileEntity(var2, var3, var4);
        if (var5 != null && var5 instanceof TileEntityPiston) {
            ((TileEntityPiston)var5).clearPistonTileEntity();
        } else {
            super.onBlockRemoval(var1, var2, var3, var4);
        }

    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return false;
    }

    public boolean canPlaceBlockOnSide(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isACube() {
        return false;
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (!var1.singleplayerWorld && var1.getBlockTileEntity(var2, var3, var4) == null) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
            return true;
        } else {
            return false;
        }
    }

    public int idDropped(int var1, Random var2) {
        return 0;
    }

    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!var1.singleplayerWorld) {
            TileEntityPiston var7 = this.getTileEntityAtLocation(var1, var2, var3, var4);
            if (var7 != null) {
                Block.blocksList[var7.getStoredBlockID()].dropBlockAsItem(var1, var2, var3, var4, var7.getBlockMetadata());
            }
        }
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.singleplayerWorld && var1.getBlockTileEntity(var2, var3, var4) == null) {
        }

    }

    public static TileEntity getTileEntity(int var0, int var1, int var2, boolean var3, boolean var4) {
        return new TileEntityPiston(var0, var1, var2, var3, var4);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        TileEntityPiston var5 = this.getTileEntityAtLocation(var1, var2, var3, var4);
        if (var5 == null) {
            return null;
        } else {
            float var6 = var5.func_31007_a(0.0F);
            if (var5.func_31010_c()) {
                var6 = 1.0F - var6;
            }

            return this.func_31032_a(var1, var2, var3, var4, var5.getStoredBlockID(), var6, var5.func_31008_d());
        }
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        TileEntityPiston var5 = this.getTileEntityAtLocation(var1, var2, var3, var4);
        if (var5 != null) {
            Block var6 = Block.blocksList[var5.getStoredBlockID()];
            if (var6 == null || var6 == this) {
                return;
            }

            var6.setBlockBoundsBasedOnState(var1, var2, var3, var4);
            float var7 = var5.func_31007_a(0.0F);
            if (var5.func_31010_c()) {
                var7 = 1.0F - var7;
            }

            int var8 = var5.func_31008_d();
            this.minX = var6.minX - (double)((float)PistonBlockTextures.field_31051_b[var8] * var7);
            this.minY = var6.minY - (double)((float)PistonBlockTextures.field_31054_c[var8] * var7);
            this.minZ = var6.minZ - (double)((float)PistonBlockTextures.field_31053_d[var8] * var7);
            this.maxX = var6.maxX - (double)((float)PistonBlockTextures.field_31051_b[var8] * var7);
            this.maxY = var6.maxY - (double)((float)PistonBlockTextures.field_31054_c[var8] * var7);
            this.maxZ = var6.maxZ - (double)((float)PistonBlockTextures.field_31053_d[var8] * var7);
        }

    }

    public AxisAlignedBB func_31032_a(World var1, int var2, int var3, int var4, int var5, float var6, int var7) {
        if (var5 != 0 && var5 != this.blockID) {
            AxisAlignedBB var8 = Block.blocksList[var5].getCollisionBoundingBoxFromPool(var1, var2, var3, var4);
            if (var8 == null) {
                return null;
            } else {
                var8.minX -= (double)((float)PistonBlockTextures.field_31051_b[var7] * var6);
                var8.maxX -= (double)((float)PistonBlockTextures.field_31051_b[var7] * var6);
                var8.minY -= (double)((float)PistonBlockTextures.field_31054_c[var7] * var6);
                var8.maxY -= (double)((float)PistonBlockTextures.field_31054_c[var7] * var6);
                var8.minZ -= (double)((float)PistonBlockTextures.field_31053_d[var7] * var6);
                var8.maxZ -= (double)((float)PistonBlockTextures.field_31053_d[var7] * var6);
                return var8;
            }
        } else {
            return null;
        }
    }

    private TileEntityPiston getTileEntityAtLocation(IBlockAccess var1, int var2, int var3, int var4) {
        TileEntity var5 = var1.getBlockTileEntity(var2, var3, var4);
        return var5 != null && var5 instanceof TileEntityPiston ? (TileEntityPiston)var5 : null;
    }
}
