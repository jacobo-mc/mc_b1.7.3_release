package net.minecraft.src;

import java.util.Random;

public class BlockRail extends Block {
    private final boolean isPowered;

    public static final boolean isRailBlockAt(World var0, int var1, int var2, int var3) {
        int var4 = var0.getBlockId(var1, var2, var3);
        return var4 == Block.rail.blockID || var4 == Block.railPowered.blockID || var4 == Block.railDetector.blockID;
    }

    public static final boolean isRailBlock(int var0) {
        return var0 == Block.rail.blockID || var0 == Block.railPowered.blockID || var0 == Block.railDetector.blockID;
    }

    protected BlockRail(int var1, int var2, boolean var3) {
        super(var1, var2, Material.circuits);
        this.isPowered = var3;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean getIsPowered() {
        return this.isPowered;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public MovingObjectPosition collisionRayTrace(World var1, int var2, int var3, int var4, Vec3D var5, Vec3D var6) {
        this.setBlockBoundsBasedOnState(var1, var2, var3, var4);
        return super.collisionRayTrace(var1, var2, var3, var4, var5, var6);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        if (var5 >= 2 && var5 <= 5) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        } else {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }

    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (this.isPowered) {
            if (this.blockID == Block.railPowered.blockID && (var2 & 8) == 0) {
                return this.blockIndexInTexture - 16;
            }
        } else if (var2 >= 6) {
            return this.blockIndexInTexture - 16;
        }

        return this.blockIndexInTexture;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 9;
    }

    public int quantityDropped(Random var1) {
        return 1;
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return var1.isBlockNormalCube(var2, var3 - 1, var4);
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        if (!var1.multiplayerWorld) {
            this.refreshTrackShape(var1, var2, var3, var4, true);
        }

    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.multiplayerWorld) {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            int var7 = var6;
            if (this.isPowered) {
                var7 = var6 & 7;
            }

            boolean var8 = false;
            if (!var1.isBlockNormalCube(var2, var3 - 1, var4)) {
                var8 = true;
            }

            if (var7 == 2 && !var1.isBlockNormalCube(var2 + 1, var3, var4)) {
                var8 = true;
            }

            if (var7 == 3 && !var1.isBlockNormalCube(var2 - 1, var3, var4)) {
                var8 = true;
            }

            if (var7 == 4 && !var1.isBlockNormalCube(var2, var3, var4 - 1)) {
                var8 = true;
            }

            if (var7 == 5 && !var1.isBlockNormalCube(var2, var3, var4 + 1)) {
                var8 = true;
            }

            if (var8) {
                this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
                var1.setBlockWithNotify(var2, var3, var4, 0);
            } else if (this.blockID == Block.railPowered.blockID) {
                boolean var9 = var1.isBlockIndirectlyGettingPowered(var2, var3, var4) || var1.isBlockIndirectlyGettingPowered(var2, var3 + 1, var4);
                var9 = var9 || this.isNeighborRailPowered(var1, var2, var3, var4, var6, true, 0) || this.isNeighborRailPowered(var1, var2, var3, var4, var6, false, 0);
                boolean var10 = false;
                if (var9 && (var6 & 8) == 0) {
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var7 | 8);
                    var10 = true;
                } else if (!var9 && (var6 & 8) != 0) {
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var7);
                    var10 = true;
                }

                if (var10) {
                    var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
                    if (var7 == 2 || var7 == 3 || var7 == 4 || var7 == 5) {
                        var1.notifyBlocksOfNeighborChange(var2, var3 + 1, var4, this.blockID);
                    }
                }
            } else if (var5 > 0 && Block.blocksList[var5].canProvidePower() && !this.isPowered && RailLogic.getNAdjacentTracks(new RailLogic(this, var1, var2, var3, var4)) == 3) {
                this.refreshTrackShape(var1, var2, var3, var4, false);
            }

        }
    }

    private void refreshTrackShape(World var1, int var2, int var3, int var4, boolean var5) {
        if (!var1.multiplayerWorld) {
            (new RailLogic(this, var1, var2, var3, var4)).refreshTrackShape(var1.isBlockIndirectlyGettingPowered(var2, var3, var4), var5);
        }
    }

    private boolean isNeighborRailPowered(World var1, int var2, int var3, int var4, int var5, boolean var6, int var7) {
        if (var7 >= 8) {
            return false;
        } else {
            int var8 = var5 & 7;
            boolean var9 = true;
            switch(var8) {
            case 0:
                if (var6) {
                    ++var4;
                } else {
                    --var4;
                }
                break;
            case 1:
                if (var6) {
                    --var2;
                } else {
                    ++var2;
                }
                break;
            case 2:
                if (var6) {
                    --var2;
                } else {
                    ++var2;
                    ++var3;
                    var9 = false;
                }

                var8 = 1;
                break;
            case 3:
                if (var6) {
                    --var2;
                    ++var3;
                    var9 = false;
                } else {
                    ++var2;
                }

                var8 = 1;
                break;
            case 4:
                if (var6) {
                    ++var4;
                } else {
                    --var4;
                    ++var3;
                    var9 = false;
                }

                var8 = 0;
                break;
            case 5:
                if (var6) {
                    ++var4;
                    ++var3;
                    var9 = false;
                } else {
                    --var4;
                }

                var8 = 0;
            }

            if (this.isRailPassingPower(var1, var2, var3, var4, var6, var7, var8)) {
                return true;
            } else {
                return var9 && this.isRailPassingPower(var1, var2, var3 - 1, var4, var6, var7, var8);
            }
        }
    }

    private boolean isRailPassingPower(World var1, int var2, int var3, int var4, boolean var5, int var6, int var7) {
        int var8 = var1.getBlockId(var2, var3, var4);
        if (var8 == Block.railPowered.blockID) {
            int var9 = var1.getBlockMetadata(var2, var3, var4);
            int var10 = var9 & 7;
            if (var7 == 1 && (var10 == 0 || var10 == 4 || var10 == 5)) {
                return false;
            }

            if (var7 == 0 && (var10 == 1 || var10 == 2 || var10 == 3)) {
                return false;
            }

            if ((var9 & 8) != 0) {
                if (!var1.isBlockIndirectlyGettingPowered(var2, var3, var4) && !var1.isBlockIndirectlyGettingPowered(var2, var3 + 1, var4)) {
                    return this.isNeighborRailPowered(var1, var2, var3, var4, var9, var5, var6 + 1);
                }

                return true;
            }
        }

        return false;
    }

    public int getMobilityFlag() {
        return 0;
    }

    // $FF: synthetic method
    static boolean isPoweredBlockRail(BlockRail var0) {
        return var0.isPowered;
    }
}
