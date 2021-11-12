package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockRedstoneTorch extends BlockTorch {
    private boolean torchActive = false;
    private static List torchUpdates = new ArrayList();

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        return var1 == 1 ? Block.redstoneWire.getBlockTextureFromSideAndMetadata(var1, var2) : super.getBlockTextureFromSideAndMetadata(var1, var2);
    }

    private boolean checkForBurnout(World var1, int var2, int var3, int var4, boolean var5) {
        if (var5) {
            torchUpdates.add(new RedstoneUpdateInfo(var2, var3, var4, var1.getWorldTime()));
        }

        int var6 = 0;

        for(int var7 = 0; var7 < torchUpdates.size(); ++var7) {
            RedstoneUpdateInfo var8 = (RedstoneUpdateInfo)torchUpdates.get(var7);
            if (var8.x == var2 && var8.y == var3 && var8.z == var4) {
                ++var6;
                if (var6 >= 8) {
                    return true;
                }
            }
        }

        return false;
    }

    protected BlockRedstoneTorch(int var1, int var2, boolean var3) {
        super(var1, var2);
        this.torchActive = var3;
        this.setTickOnLoad(true);
    }

    public int tickRate() {
        return 2;
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        if (var1.getBlockMetadata(var2, var3, var4) == 0) {
            super.onBlockAdded(var1, var2, var3, var4);
        }

        if (this.torchActive) {
            var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3 + 1, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2 - 1, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2 + 1, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4 - 1, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4 + 1, this.blockID);
        }

    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
        if (this.torchActive) {
            var1.notifyBlocksOfNeighborChange(var2, var3 - 1, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3 + 1, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2 - 1, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2 + 1, var3, var4, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4 - 1, this.blockID);
            var1.notifyBlocksOfNeighborChange(var2, var3, var4 + 1, this.blockID);
        }

    }

    public boolean isPoweringTo(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (!this.torchActive) {
            return false;
        } else {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            if (var6 == 5 && var5 == 1) {
                return false;
            } else if (var6 == 3 && var5 == 3) {
                return false;
            } else if (var6 == 4 && var5 == 2) {
                return false;
            } else if (var6 == 1 && var5 == 5) {
                return false;
            } else {
                return var6 != 2 || var5 != 4;
            }
        }
    }

    private boolean func_30003_g(World var1, int var2, int var3, int var4) {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        if (var5 == 5 && var1.isBlockIndirectlyProvidingPowerTo(var2, var3 - 1, var4, 0)) {
            return true;
        } else if (var5 == 3 && var1.isBlockIndirectlyProvidingPowerTo(var2, var3, var4 - 1, 2)) {
            return true;
        } else if (var5 == 4 && var1.isBlockIndirectlyProvidingPowerTo(var2, var3, var4 + 1, 3)) {
            return true;
        } else if (var5 == 1 && var1.isBlockIndirectlyProvidingPowerTo(var2 - 1, var3, var4, 4)) {
            return true;
        } else {
            return var5 == 2 && var1.isBlockIndirectlyProvidingPowerTo(var2 + 1, var3, var4, 5);
        }
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        boolean var6 = this.func_30003_g(var1, var2, var3, var4);

        while(torchUpdates.size() > 0 && var1.getWorldTime() - ((RedstoneUpdateInfo)torchUpdates.get(0)).updateTime > 100L) {
            torchUpdates.remove(0);
        }

        if (this.torchActive) {
            if (var6) {
                var1.setBlockAndMetadataWithNotify(var2, var3, var4, Block.torchRedstoneIdle.blockID, var1.getBlockMetadata(var2, var3, var4));
                if (this.checkForBurnout(var1, var2, var3, var4, true)) {
                    var1.playSoundEffect((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.rand.nextFloat() - var1.rand.nextFloat()) * 0.8F);

                    for(int var7 = 0; var7 < 5; ++var7) {
                        double var8 = (double)var2 + var5.nextDouble() * 0.6D + 0.2D;
                        double var10 = (double)var3 + var5.nextDouble() * 0.6D + 0.2D;
                        double var12 = (double)var4 + var5.nextDouble() * 0.6D + 0.2D;
                        var1.spawnParticle("smoke", var8, var10, var12, 0.0D, 0.0D, 0.0D);
                    }
                }
            }
        } else if (!var6 && !this.checkForBurnout(var1, var2, var3, var4, false)) {
            var1.setBlockAndMetadataWithNotify(var2, var3, var4, Block.torchRedstoneActive.blockID, var1.getBlockMetadata(var2, var3, var4));
        }

    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
        var1.scheduleUpdateTick(var2, var3, var4, this.blockID, this.tickRate());
    }

    public boolean isIndirectlyPoweringTo(World var1, int var2, int var3, int var4, int var5) {
        return var5 == 0 ? this.isPoweringTo(var1, var2, var3, var4, var5) : false;
    }

    public int idDropped(int var1, Random var2) {
        return Block.torchRedstoneActive.blockID;
    }

    public boolean canProvidePower() {
        return true;
    }
}
