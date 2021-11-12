package net.minecraft.src;

import java.util.Random;

public class BlockFire extends Block {
    private int[] chanceToEncourageFire = new int[256];
    private int[] abilityToCatchFire = new int[256];

    protected BlockFire(int var1, int var2) {
        super(var1, var2, Material.fire);
        this.setTickOnLoad(true);
    }

    public void setFireBurnRates() {
        this.setBurnRate(Block.planks.blockID, 5, 20);
        this.setBurnRate(Block.fence.blockID, 5, 20);
        this.setBurnRate(Block.stairCompactPlanks.blockID, 5, 20);
        this.setBurnRate(Block.wood.blockID, 5, 5);
        this.setBurnRate(Block.leaves.blockID, 30, 60);
        this.setBurnRate(Block.bookShelf.blockID, 30, 20);
        this.setBurnRate(Block.tnt.blockID, 15, 100);
        this.setBurnRate(Block.tallGrass.blockID, 60, 100);
        this.setBurnRate(Block.cloth.blockID, 30, 60);
    }

    private void setBurnRate(int var1, int var2, int var3) {
        this.chanceToEncourageFire[var1] = var2;
        this.abilityToCatchFire[var1] = var3;
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

    public int quantityDropped(Random var1) {
        return 0;
    }

    public int tickRate() {
        return 40;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        boolean var6 = var1.getBlockId(var2, var3 - 1, var4) == Block.bloodStone.blockID;
        if (!this.canPlaceBlockAt(var1, var2, var3, var4)) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }

        if (!var6 && var1.func_27068_v() && (var1.canLightningStrikeAt(var2, var3, var4) || var1.canLightningStrikeAt(var2 - 1, var3, var4) || var1.canLightningStrikeAt(var2 + 1, var3, var4) || var1.canLightningStrikeAt(var2, var3, var4 - 1) || var1.canLightningStrikeAt(var2, var3, var4 + 1))) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
        } else {
            int var7 = var1.getBlockMetadata(var2, var3, var4);
            if (var7 < 15) {
                var1.setBlockMetadata(var2, var3, var4, var7 + var5.nextInt(3) / 2);
            }

            var1.scheduleUpdateTick(var2, var3, var4, this.blockID, this.tickRate());
            if (!var6 && !this.func_268_g(var1, var2, var3, var4)) {
                if (!var1.isBlockNormalCube(var2, var3 - 1, var4) || var7 > 3) {
                    var1.setBlockWithNotify(var2, var3, var4, 0);
                }

            } else if (!var6 && !this.canBlockCatchFire(var1, var2, var3 - 1, var4) && var7 == 15 && var5.nextInt(4) == 0) {
                var1.setBlockWithNotify(var2, var3, var4, 0);
            } else {
                this.tryToCatchBlockOnFire(var1, var2 + 1, var3, var4, 300, var5, var7);
                this.tryToCatchBlockOnFire(var1, var2 - 1, var3, var4, 300, var5, var7);
                this.tryToCatchBlockOnFire(var1, var2, var3 - 1, var4, 250, var5, var7);
                this.tryToCatchBlockOnFire(var1, var2, var3 + 1, var4, 250, var5, var7);
                this.tryToCatchBlockOnFire(var1, var2, var3, var4 - 1, 300, var5, var7);
                this.tryToCatchBlockOnFire(var1, var2, var3, var4 + 1, 300, var5, var7);

                for(int var8 = var2 - 1; var8 <= var2 + 1; ++var8) {
                    for(int var9 = var4 - 1; var9 <= var4 + 1; ++var9) {
                        for(int var10 = var3 - 1; var10 <= var3 + 4; ++var10) {
                            if (var8 != var2 || var10 != var3 || var9 != var4) {
                                int var11 = 100;
                                if (var10 > var3 + 1) {
                                    var11 += (var10 - (var3 + 1)) * 100;
                                }

                                int var12 = this.getChanceOfNeighborsEncouragingFire(var1, var8, var10, var9);
                                if (var12 > 0) {
                                    int var13 = (var12 + 40) / (var7 + 30);
                                    if (var13 > 0 && var5.nextInt(var11) <= var13 && (!var1.func_27068_v() || !var1.canLightningStrikeAt(var8, var10, var9)) && !var1.canLightningStrikeAt(var8 - 1, var10, var4) && !var1.canLightningStrikeAt(var8 + 1, var10, var9) && !var1.canLightningStrikeAt(var8, var10, var9 - 1) && !var1.canLightningStrikeAt(var8, var10, var9 + 1)) {
                                        int var14 = var7 + var5.nextInt(5) / 4;
                                        if (var14 > 15) {
                                            var14 = 15;
                                        }

                                        var1.setBlockAndMetadataWithNotify(var8, var10, var9, this.blockID, var14);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private void tryToCatchBlockOnFire(World var1, int var2, int var3, int var4, int var5, Random var6, int var7) {
        int var8 = this.abilityToCatchFire[var1.getBlockId(var2, var3, var4)];
        if (var6.nextInt(var5) < var8) {
            boolean var9 = var1.getBlockId(var2, var3, var4) == Block.tnt.blockID;
            if (var6.nextInt(var7 + 10) < 5 && !var1.canLightningStrikeAt(var2, var3, var4)) {
                int var10 = var7 + var6.nextInt(5) / 4;
                if (var10 > 15) {
                    var10 = 15;
                }

                var1.setBlockAndMetadataWithNotify(var2, var3, var4, this.blockID, var10);
            } else {
                var1.setBlockWithNotify(var2, var3, var4, 0);
            }

            if (var9) {
                Block.tnt.onBlockDestroyedByPlayer(var1, var2, var3, var4, 1);
            }
        }

    }

    private boolean func_268_g(World var1, int var2, int var3, int var4) {
        if (this.canBlockCatchFire(var1, var2 + 1, var3, var4)) {
            return true;
        } else if (this.canBlockCatchFire(var1, var2 - 1, var3, var4)) {
            return true;
        } else if (this.canBlockCatchFire(var1, var2, var3 - 1, var4)) {
            return true;
        } else if (this.canBlockCatchFire(var1, var2, var3 + 1, var4)) {
            return true;
        } else if (this.canBlockCatchFire(var1, var2, var3, var4 - 1)) {
            return true;
        } else {
            return this.canBlockCatchFire(var1, var2, var3, var4 + 1);
        }
    }

    private int getChanceOfNeighborsEncouragingFire(World var1, int var2, int var3, int var4) {
        byte var5 = 0;
        if (!var1.isAirBlock(var2, var3, var4)) {
            return 0;
        } else {
            int var6 = this.getChanceToEncourageFire(var1, var2 + 1, var3, var4, var5);
            var6 = this.getChanceToEncourageFire(var1, var2 - 1, var3, var4, var6);
            var6 = this.getChanceToEncourageFire(var1, var2, var3 - 1, var4, var6);
            var6 = this.getChanceToEncourageFire(var1, var2, var3 + 1, var4, var6);
            var6 = this.getChanceToEncourageFire(var1, var2, var3, var4 - 1, var6);
            var6 = this.getChanceToEncourageFire(var1, var2, var3, var4 + 1, var6);
            return var6;
        }
    }

    public boolean isCollidable() {
        return false;
    }

    public boolean canBlockCatchFire(IBlockAccess var1, int var2, int var3, int var4) {
        return this.chanceToEncourageFire[var1.getBlockId(var2, var3, var4)] > 0;
    }

    public int getChanceToEncourageFire(World var1, int var2, int var3, int var4, int var5) {
        int var6 = this.chanceToEncourageFire[var1.getBlockId(var2, var3, var4)];
        return var6 > var5 ? var6 : var5;
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return var1.isBlockNormalCube(var2, var3 - 1, var4) || this.func_268_g(var1, var2, var3, var4);
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        if (!var1.isBlockNormalCube(var2, var3 - 1, var4) && !this.func_268_g(var1, var2, var3, var4)) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {
        if (var1.getBlockId(var2, var3 - 1, var4) != Block.obsidian.blockID || !Block.portal.tryToCreatePortal(var1, var2, var3, var4)) {
            if (!var1.isBlockNormalCube(var2, var3 - 1, var4) && !this.func_268_g(var1, var2, var3, var4)) {
                var1.setBlockWithNotify(var2, var3, var4, 0);
            } else {
                var1.scheduleUpdateTick(var2, var3, var4, this.blockID, this.tickRate());
            }
        }
    }
}
