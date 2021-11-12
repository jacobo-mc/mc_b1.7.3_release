package net.minecraft.src;

import java.util.Random;

public class BlockStep extends Block {
    public static final String[] field_22037_a = new String[]{"stone", "sand", "wood", "cobble"};
    private boolean blockType;

    public BlockStep(int var1, boolean var2) {
        super(var1, 6, Material.rock);
        this.blockType = var2;
        if (!var2) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        this.setLightOpacity(255);
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var2 == 0) {
            return var1 <= 1 ? 6 : 5;
        } else if (var2 == 1) {
            if (var1 == 0) {
                return 208;
            } else {
                return var1 == 1 ? 176 : 192;
            }
        } else if (var2 == 2) {
            return 4;
        } else {
            return var2 == 3 ? 16 : 6;
        }
    }

    public int getBlockTextureFromSide(int var1) {
        return this.getBlockTextureFromSideAndMetadata(var1, 0);
    }

    public boolean isOpaqueCube() {
        return this.blockType;
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        if (this != Block.stairSingle) {
            super.onBlockAdded(var1, var2, var3, var4);
        }

        int var5 = var1.getBlockId(var2, var3 - 1, var4);
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        int var7 = var1.getBlockMetadata(var2, var3 - 1, var4);
        if (var6 == var7) {
            if (var5 == stairSingle.blockID) {
                var1.setBlockWithNotify(var2, var3, var4, 0);
                var1.setBlockAndMetadataWithNotify(var2, var3 - 1, var4, Block.stairDouble.blockID, var6);
            }

        }
    }

    public int idDropped(int var1, Random var2) {
        return Block.stairSingle.blockID;
    }

    public int quantityDropped(Random var1) {
        return this.blockType ? 2 : 1;
    }

    protected int damageDropped(int var1) {
        return var1;
    }

    public boolean renderAsNormalBlock() {
        return this.blockType;
    }

    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (this != Block.stairSingle) {
            super.shouldSideBeRendered(var1, var2, var3, var4, var5);
        }

        if (var5 == 1) {
            return true;
        } else if (!super.shouldSideBeRendered(var1, var2, var3, var4, var5)) {
            return false;
        } else if (var5 == 0) {
            return true;
        } else {
            return var1.getBlockId(var2, var3, var4) != this.blockID;
        }
    }
}
