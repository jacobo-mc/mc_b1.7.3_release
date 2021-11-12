package net.minecraft.src;

import java.util.Random;

public class BlockPortal extends BlockBreakable {
    public BlockPortal(int var1, int var2) {
        super(var1, var2, Material.portal, false);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return null;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        float var5;
        float var6;
        if (var1.getBlockId(var2 - 1, var3, var4) != this.blockID && var1.getBlockId(var2 + 1, var3, var4) != this.blockID) {
            var5 = 0.125F;
            var6 = 0.5F;
            this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        } else {
            var5 = 0.5F;
            var6 = 0.125F;
            this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        }

    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isACube() {
        return false;
    }

    public boolean tryToCreatePortal(World var1, int var2, int var3, int var4) {
        byte var5 = 0;
        byte var6 = 0;
        if (var1.getBlockId(var2 - 1, var3, var4) == Block.obsidian.blockID || var1.getBlockId(var2 + 1, var3, var4) == Block.obsidian.blockID) {
            var5 = 1;
        }

        if (var1.getBlockId(var2, var3, var4 - 1) == Block.obsidian.blockID || var1.getBlockId(var2, var3, var4 + 1) == Block.obsidian.blockID) {
            var6 = 1;
        }

        if (var5 == var6) {
            return false;
        } else {
            if (var1.getBlockId(var2 - var5, var3, var4 - var6) == 0) {
                var2 -= var5;
                var4 -= var6;
            }

            int var7;
            int var8;
            for(var7 = -1; var7 <= 2; ++var7) {
                for(var8 = -1; var8 <= 3; ++var8) {
                    boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
                    if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                        int var10 = var1.getBlockId(var2 + var5 * var7, var3 + var8, var4 + var6 * var7);
                        if (var9) {
                            if (var10 != Block.obsidian.blockID) {
                                return false;
                            }
                        } else if (var10 != 0 && var10 != Block.fire.blockID) {
                            return false;
                        }
                    }
                }
            }

            var1.editingBlocks = true;

            for(var7 = 0; var7 < 2; ++var7) {
                for(var8 = 0; var8 < 3; ++var8) {
                    var1.setBlockWithNotify(var2 + var5 * var7, var3 + var8, var4 + var6 * var7, Block.portal.blockID);
                }
            }

            var1.editingBlocks = false;
            return true;
        }
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        byte var6 = 0;
        byte var7 = 1;
        if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID || var1.getBlockId(var2 + 1, var3, var4) == this.blockID) {
            var6 = 1;
            var7 = 0;
        }

        int var8;
        for(var8 = var3; var1.getBlockId(var2, var8 - 1, var4) == this.blockID; --var8) {
        }

        if (var1.getBlockId(var2, var8 - 1, var4) != Block.obsidian.blockID) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
        } else {
            int var9;
            for(var9 = 1; var9 < 4 && var1.getBlockId(var2, var8 + var9, var4) == this.blockID; ++var9) {
            }

            if (var9 == 3 && var1.getBlockId(var2, var8 + var9, var4) == Block.obsidian.blockID) {
                boolean var10 = var1.getBlockId(var2 - 1, var3, var4) == this.blockID || var1.getBlockId(var2 + 1, var3, var4) == this.blockID;
                boolean var11 = var1.getBlockId(var2, var3, var4 - 1) == this.blockID || var1.getBlockId(var2, var3, var4 + 1) == this.blockID;
                if (var10 && var11) {
                    var1.setBlockWithNotify(var2, var3, var4, 0);
                } else if ((var1.getBlockId(var2 + var6, var3, var4 + var7) != Block.obsidian.blockID || var1.getBlockId(var2 - var6, var3, var4 - var7) != this.blockID) && (var1.getBlockId(var2 - var6, var3, var4 - var7) != Block.obsidian.blockID || var1.getBlockId(var2 + var6, var3, var4 + var7) != this.blockID)) {
                    var1.setBlockWithNotify(var2, var3, var4, 0);
                }
            } else {
                var1.setBlockWithNotify(var2, var3, var4, 0);
            }
        }
    }

    public int quantityDropped(Random var1) {
        return 0;
    }

    public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
        if (var5.ridingEntity == null && var5.riddenByEntity == null) {
            var5.setInPortal();
        }

    }
}
