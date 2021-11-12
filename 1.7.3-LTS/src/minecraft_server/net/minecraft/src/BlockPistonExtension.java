package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockPistonExtension extends Block {
    private int field_31046_a = -1;

    public BlockPistonExtension(int var1, int var2) {
        super(var1, var2, Material.piston);
        this.setStepSound(soundStoneFootstep);
        this.setHardness(0.5F);
    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
        super.onBlockRemoval(var1, var2, var3, var4);
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        int var6 = PistonBlockTextures.field_31052_a[func_31045_b(var5)];
        var2 += PistonBlockTextures.field_31051_b[var6];
        var3 += PistonBlockTextures.field_31054_c[var6];
        var4 += PistonBlockTextures.field_31053_d[var6];
        int var7 = var1.getBlockId(var2, var3, var4);
        if (var7 == Block.pistonBase.blockID || var7 == Block.pistonStickyBase.blockID) {
            var5 = var1.getBlockMetadata(var2, var3, var4);
            if (BlockPistonBase.isExtended(var5)) {
                Block.blocksList[var7].dropBlockAsItem(var1, var2, var3, var4, var5);
                var1.setBlockWithNotify(var2, var3, var4, 0);
            }
        }

    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        int var3 = func_31045_b(var2);
        if (var1 == var3) {
            if (this.field_31046_a >= 0) {
                return this.field_31046_a;
            } else {
                return (var2 & 8) != 0 ? this.blockIndexInTexture - 1 : this.blockIndexInTexture;
            }
        } else {
            return var1 == PistonBlockTextures.field_31052_a[var3] ? 107 : 108;
        }
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isACube() {
        return false;
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return false;
    }

    public boolean canPlaceBlockOnSide(World var1, int var2, int var3, int var4, int var5) {
        return false;
    }

    public int quantityDropped(Random var1) {
        return 0;
    }

    public void getCollidingBoundingBoxes(World var1, int var2, int var3, int var4, AxisAlignedBB var5, ArrayList var6) {
        int var7 = var1.getBlockMetadata(var2, var3, var4);
        switch(func_31045_b(var7)) {
        case 0:
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            break;
        case 1:
            this.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            break;
        case 2:
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            break;
        case 3:
            this.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            break;
        case 4:
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            break;
        case 5:
            this.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
            this.setBlockBounds(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.getCollidingBoundingBoxes(var1, var2, var3, var4, var5, var6);
        }

        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        switch(func_31045_b(var5)) {
        case 0:
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
        case 1:
            this.setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
        case 2:
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
        case 3:
            this.setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
        case 4:
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
        case 5:
            this.setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        int var6 = func_31045_b(var1.getBlockMetadata(var2, var3, var4));
        int var7 = var1.getBlockId(var2 - PistonBlockTextures.field_31051_b[var6], var3 - PistonBlockTextures.field_31054_c[var6], var4 - PistonBlockTextures.field_31053_d[var6]);
        if (var7 != Block.pistonBase.blockID && var7 != Block.pistonStickyBase.blockID) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
        } else {
            Block.blocksList[var7].onNeighborBlockChange(var1, var2 - PistonBlockTextures.field_31051_b[var6], var3 - PistonBlockTextures.field_31054_c[var6], var4 - PistonBlockTextures.field_31053_d[var6], var5);
        }

    }

    public static int func_31045_b(int var0) {
        return var0 & 7;
    }
}
