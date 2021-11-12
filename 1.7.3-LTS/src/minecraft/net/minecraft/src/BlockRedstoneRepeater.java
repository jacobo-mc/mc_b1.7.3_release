package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneRepeater extends Block {
    public static final double[] repeaterTorchOffset = new double[]{-0.0625D, 0.0625D, 0.1875D, 0.3125D};
    private static final int[] field_22023_b = new int[]{1, 2, 3, 4};
    private final boolean isRepeaterPowered;

    protected BlockRedstoneRepeater(int var1, boolean var2) {
        super(var1, 6, Material.circuits);
        this.isRepeaterPowered = var2;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return !var1.isBlockNormalCube(var2, var3 - 1, var4) ? false : super.canPlaceBlockAt(var1, var2, var3, var4);
    }

    public boolean canBlockStay(World var1, int var2, int var3, int var4) {
        return !var1.isBlockNormalCube(var2, var3 - 1, var4) ? false : super.canBlockStay(var1, var2, var3, var4);
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        boolean var7 = this.ignoreTick(var1, var2, var3, var4, var6);
        if (this.isRepeaterPowered && !var7) {
            var1.setBlockAndMetadataWithNotify(var2, var3, var4, Block.redstoneRepeaterIdle.blockID, var6);
        } else if (!this.isRepeaterPowered) {
            var1.setBlockAndMetadataWithNotify(var2, var3, var4, Block.redstoneRepeaterActive.blockID, var6);
            if (!var7) {
                int var8 = (var6 & 12) >> 2;
                var1.scheduleBlockUpdate(var2, var3, var4, Block.redstoneRepeaterActive.blockID, field_22023_b[var8] * 2);
            }
        }

    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var1 == 0) {
            return this.isRepeaterPowered ? 99 : 115;
        } else if (var1 == 1) {
            return this.isRepeaterPowered ? 147 : 131;
        } else {
            return 5;
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return var5 != 0 && var5 != 1;
    }

    public int getRenderType() {
        return 15;
    }

    public int getBlockTextureFromSide(int var1) {
        return this.getBlockTextureFromSideAndMetadata(var1, 0);
    }

    public boolean isIndirectlyPoweringTo(World var1, int var2, int var3, int var4, int var5) {
        return this.isPoweringTo(var1, var2, var3, var4, var5);
    }

    public boolean isPoweringTo(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.isRepeaterPowered) {
            return false;
        } else {
            int var6 = var1.getBlockMetadata(var2, var3, var4) & 3;
            if (var6 == 0 && var5 == 3) {
                return true;
            } else if (var6 == 1 && var5 == 4) {
                return true;
            } else if (var6 == 2 && var5 == 2) {
                return true;
            } else {
                return var6 == 3 && var5 == 5;
            }
        }
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (!this.canBlockStay(var1, var2, var3, var4)) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        } else {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            boolean var7 = this.ignoreTick(var1, var2, var3, var4, var6);
            int var8 = (var6 & 12) >> 2;
            if (this.isRepeaterPowered && !var7) {
                var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, field_22023_b[var8] * 2);
            } else if (!this.isRepeaterPowered && var7) {
                var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, field_22023_b[var8] * 2);
            }

        }
    }

    private boolean ignoreTick(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var5 & 3;
        switch(var6) {
        case 0:
            return var1.isBlockIndirectlyProvidingPowerTo(var2, var3, var4 + 1, 3) || var1.getBlockId(var2, var3, var4 + 1) == Block.redstoneWire.blockID && var1.getBlockMetadata(var2, var3, var4 + 1) > 0;
        case 1:
            return var1.isBlockIndirectlyProvidingPowerTo(var2 - 1, var3, var4, 4) || var1.getBlockId(var2 - 1, var3, var4) == Block.redstoneWire.blockID && var1.getBlockMetadata(var2 - 1, var3, var4) > 0;
        case 2:
            return var1.isBlockIndirectlyProvidingPowerTo(var2, var3, var4 - 1, 2) || var1.getBlockId(var2, var3, var4 - 1) == Block.redstoneWire.blockID && var1.getBlockMetadata(var2, var3, var4 - 1) > 0;
        case 3:
            return var1.isBlockIndirectlyProvidingPowerTo(var2 + 1, var3, var4, 5) || var1.getBlockId(var2 + 1, var3, var4) == Block.redstoneWire.blockID && var1.getBlockMetadata(var2 + 1, var3, var4) > 0;
        default:
            return false;
        }
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        int var7 = (var6 & 12) >> 2;
        var7 = var7 + 1 << 2 & 12;
        var1.setBlockMetadataWithNotify(var2, var3, var4, var7 | var6 & 3);
        return true;
    }

    public boolean canProvidePower() {
        return false;
    }

    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5) {
        int var6 = ((MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
        boolean var7 = this.ignoreTick(var1, var2, var3, var4, var6);
        if (var7) {
            var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, 1);
        }

    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        var1.notifyBlocksOfNeighborChange(var2 + 1, var3, var4, this.blockID);
        var1.notifyBlocksOfNeighborChange(var2 - 1, var3, var4, this.blockID);
        var1.notifyBlocksOfNeighborChange(var2, var3, var4 + 1, this.blockID);
        var1.notifyBlocksOfNeighborChange(var2, var3, var4 - 1, this.blockID);
        var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
        var1.notifyBlocksOfNeighborChange(var2, var3 + 1, var4, this.blockID);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int idDropped(int var1, Random var2) {
        return Item.redstoneRepeater.shiftedIndex;
    }

    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {
        if (this.isRepeaterPowered) {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            double var7 = (double)((float)var2 + 0.5F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var9 = (double)((float)var3 + 0.4F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var11 = (double)((float)var4 + 0.5F) + (double)(var5.nextFloat() - 0.5F) * 0.2D;
            double var13 = 0.0D;
            double var15 = 0.0D;
            if (var5.nextInt(2) == 0) {
                switch(var6 & 3) {
                case 0:
                    var15 = -0.3125D;
                    break;
                case 1:
                    var13 = 0.3125D;
                    break;
                case 2:
                    var15 = 0.3125D;
                    break;
                case 3:
                    var13 = -0.3125D;
                }
            } else {
                int var17 = (var6 & 12) >> 2;
                switch(var6 & 3) {
                case 0:
                    var15 = repeaterTorchOffset[var17];
                    break;
                case 1:
                    var13 = -repeaterTorchOffset[var17];
                    break;
                case 2:
                    var15 = -repeaterTorchOffset[var17];
                    break;
                case 3:
                    var13 = repeaterTorchOffset[var17];
                }
            }

            var1.spawnParticle("reddust", var7 + var13, var9, var11 + var15, 0.0D, 0.0D, 0.0D);
        }
    }
}
