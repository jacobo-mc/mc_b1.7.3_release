package net.minecraft.src;

public class BlockLever extends Block {
    protected BlockLever(int var1, int var2) {
        super(var1, var2, Material.circuits);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean isACube() {
        return false;
    }

    public boolean canPlaceBlockOnSide(World var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1 && var1.isBlockNormalCube(var2, var3 - 1, var4)) {
            return true;
        } else if (var5 == 2 && var1.isBlockNormalCube(var2, var3, var4 + 1)) {
            return true;
        } else if (var5 == 3 && var1.isBlockNormalCube(var2, var3, var4 - 1)) {
            return true;
        } else if (var5 == 4 && var1.isBlockNormalCube(var2 + 1, var3, var4)) {
            return true;
        } else {
            return var5 == 5 && var1.isBlockNormalCube(var2 - 1, var3, var4);
        }
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
            return var1.isBlockNormalCube(var2, var3 - 1, var4);
        }
    }

    public void onBlockPlaced(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        int var7 = var6 & 8;
        var6 &= 7;
        var6 = -1;
        if (var5 == 1 && var1.isBlockNormalCube(var2, var3 - 1, var4)) {
            var6 = 5 + var1.rand.nextInt(2);
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

        if (var6 == -1) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        } else {
            var1.setBlockMetadataWithNotify(var2, var3, var4, var6 + var7);
        }
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (this.checkIfAttachedToBlock(var1, var2, var3, var4)) {
            int var6 = var1.getBlockMetadata(var2, var3, var4) & 7;
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

            if (!var1.isBlockNormalCube(var2, var3 - 1, var4) && var6 == 5) {
                var7 = true;
            }

            if (!var1.isBlockNormalCube(var2, var3 - 1, var4) && var6 == 6) {
                var7 = true;
            }

            if (var7) {
                this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
                var1.setBlockWithNotify(var2, var3, var4, 0);
            }
        }

    }

    private boolean checkIfAttachedToBlock(World var1, int var2, int var3, int var4) {
        if (!this.canPlaceBlockAt(var1, var2, var3, var4)) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4) & 7;
        float var6 = 0.1875F;
        if (var5 == 1) {
            this.setBlockBounds(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
        } else if (var5 == 2) {
            this.setBlockBounds(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
        } else if (var5 == 3) {
            this.setBlockBounds(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
        } else if (var5 == 4) {
            this.setBlockBounds(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
        } else {
            var6 = 0.25F;
            this.setBlockBounds(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
        }

    }

    public void onBlockClicked(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.blockActivated(var1, var2, var3, var4, var5);
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.singleplayerWorld) {
            return true;
        } else {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            int var7 = var6 & 7;
            int var8 = 8 - (var6 & 8);
            var1.setBlockMetadataWithNotify(var2, var3, var4, var7 + var8);
            var1.markBlocksDirty(var2, var3, var4, var2, var3, var4);
            var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.click", 0.3F, var8 > 0 ? 0.6F : 0.5F);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4, this.blockID);
            if (var7 == 1) {
                var1.notifyBlocksOfNeighborChange(var2 - 1, var3, var4, this.blockID);
            } else if (var7 == 2) {
                var1.notifyBlocksOfNeighborChange(var2 + 1, var3, var4, this.blockID);
            } else if (var7 == 3) {
                var1.notifyBlocksOfNeighborChange(var2, var3, var4 - 1, this.blockID);
            } else if (var7 == 4) {
                var1.notifyBlocksOfNeighborChange(var2, var3, var4 + 1, this.blockID);
            } else {
                var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
            }

            return true;
        }
    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        if ((var5 & 8) > 0) {
            var1.notifyBlocksOfNeighborChange(var2, var3, var4, this.blockID);
            int var6 = var5 & 7;
            if (var6 == 1) {
                var1.notifyBlocksOfNeighborChange(var2 - 1, var3, var4, this.blockID);
            } else if (var6 == 2) {
                var1.notifyBlocksOfNeighborChange(var2 + 1, var3, var4, this.blockID);
            } else if (var6 == 3) {
                var1.notifyBlocksOfNeighborChange(var2, var3, var4 - 1, this.blockID);
            } else if (var6 == 4) {
                var1.notifyBlocksOfNeighborChange(var2, var3, var4 + 1, this.blockID);
            } else {
                var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
            }
        }

        super.onBlockRemoval(var1, var2, var3, var4);
    }

    public boolean isPoweringTo(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return (var1.getBlockMetadata(var2, var3, var4) & 8) > 0;
    }

    public boolean isIndirectlyPoweringTo(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        if ((var6 & 8) == 0) {
            return false;
        } else {
            int var7 = var6 & 7;
            if (var7 == 6 && var5 == 1) {
                return true;
            } else if (var7 == 5 && var5 == 1) {
                return true;
            } else if (var7 == 4 && var5 == 2) {
                return true;
            } else if (var7 == 3 && var5 == 3) {
                return true;
            } else if (var7 == 2 && var5 == 4) {
                return true;
            } else {
                return var7 == 1 && var5 == 5;
            }
        }
    }

    public boolean canProvidePower() {
        return true;
    }
}
