package net.minecraft.src;

import java.util.Iterator;
import java.util.Random;

public class BlockBed extends Block {
    public static final int[][] headBlockToFootBlockMap = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public BlockBed(int var1) {
        super(var1, 134, Material.cloth);
        this.setBounds();
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        if (var1.multiplayerWorld) {
            return true;
        } else {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            if (!isBlockFootOfBed(var6)) {
                int var7 = getDirectionFromMetadata(var6);
                var2 += headBlockToFootBlockMap[var7][0];
                var4 += headBlockToFootBlockMap[var7][1];
                if (var1.getBlockId(var2, var3, var4) != this.blockID) {
                    return true;
                }

                var6 = var1.getBlockMetadata(var2, var3, var4);
            }

            if (!var1.worldProvider.canRespawnHere()) {
                double var16 = (double)var2 + 0.5D;
                double var17 = (double)var3 + 0.5D;
                double var11 = (double)var4 + 0.5D;
                var1.setBlockWithNotify(var2, var3, var4, 0);
                int var13 = getDirectionFromMetadata(var6);
                var2 += headBlockToFootBlockMap[var13][0];
                var4 += headBlockToFootBlockMap[var13][1];
                if (var1.getBlockId(var2, var3, var4) == this.blockID) {
                    var1.setBlockWithNotify(var2, var3, var4, 0);
                    var16 = (var16 + (double)var2 + 0.5D) / 2.0D;
                    var17 = (var17 + (double)var3 + 0.5D) / 2.0D;
                    var11 = (var11 + (double)var4 + 0.5D) / 2.0D;
                }

                var1.newExplosion((Entity)null, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), 5.0F, true);
                return true;
            } else {
                if (isBedOccupied(var6)) {
                    EntityPlayer var14 = null;
                    Iterator var8 = var1.playerEntities.iterator();

                    while(var8.hasNext()) {
                        EntityPlayer var9 = (EntityPlayer)var8.next();
                        if (var9.isPlayerSleeping()) {
                            ChunkCoordinates var10 = var9.bedChunkCoordinates;
                            if (var10.x == var2 && var10.y == var3 && var10.z == var4) {
                                var14 = var9;
                            }
                        }
                    }

                    if (var14 != null) {
                        var5.addChatMessage("tile.bed.occupied");
                        return true;
                    }

                    setBedOccupied(var1, var2, var3, var4, false);
                }

                EnumStatus var15 = var5.sleepInBedAt(var2, var3, var4);
                if (var15 == EnumStatus.OK) {
                    setBedOccupied(var1, var2, var3, var4, true);
                    return true;
                } else {
                    if (var15 == EnumStatus.NOT_POSSIBLE_NOW) {
                        var5.addChatMessage("tile.bed.noSleep");
                    }

                    return true;
                }
            }
        }
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var1 == 0) {
            return Block.planks.blockIndexInTexture;
        } else {
            int var3 = getDirectionFromMetadata(var2);
            int var4 = ModelBed.bedDirection[var3][var1];
            if (isBlockFootOfBed(var2)) {
                if (var4 == 2) {
                    return this.blockIndexInTexture + 2 + 16;
                } else {
                    return var4 != 5 && var4 != 4 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture + 1 + 16;
                }
            } else if (var4 == 3) {
                return this.blockIndexInTexture - 1 + 16;
            } else {
                return var4 != 5 && var4 != 4 ? this.blockIndexInTexture : this.blockIndexInTexture + 16;
            }
        }
    }

    public int getRenderType() {
        return 14;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
        this.setBounds();
    }

    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.getBlockMetadata(var2, var3, var4);
        int var7 = getDirectionFromMetadata(var6);
        if (isBlockFootOfBed(var6)) {
            if (var1.getBlockId(var2 - headBlockToFootBlockMap[var7][0], var3, var4 - headBlockToFootBlockMap[var7][1]) != this.blockID) {
                var1.setBlockWithNotify(var2, var3, var4, 0);
            }
        } else if (var1.getBlockId(var2 + headBlockToFootBlockMap[var7][0], var3, var4 + headBlockToFootBlockMap[var7][1]) != this.blockID) {
            var1.setBlockWithNotify(var2, var3, var4, 0);
            if (!var1.multiplayerWorld) {
                this.dropBlockAsItem(var1, var2, var3, var4, var6);
            }
        }

    }

    public int idDropped(int var1, Random var2) {
        return isBlockFootOfBed(var1) ? 0 : Item.bed.shiftedIndex;
    }

    private void setBounds() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }

    public static int getDirectionFromMetadata(int var0) {
        return var0 & 3;
    }

    public static boolean isBlockFootOfBed(int var0) {
        return (var0 & 8) != 0;
    }

    public static boolean isBedOccupied(int var0) {
        return (var0 & 4) != 0;
    }

    public static void setBedOccupied(World var0, int var1, int var2, int var3, boolean var4) {
        int var5 = var0.getBlockMetadata(var1, var2, var3);
        if (var4) {
            var5 |= 4;
        } else {
            var5 &= -5;
        }

        var0.setBlockMetadataWithNotify(var1, var2, var3, var5);
    }

    public static ChunkCoordinates getNearestEmptyChunkCoordinates(World var0, int var1, int var2, int var3, int var4) {
        int var5 = var0.getBlockMetadata(var1, var2, var3);
        int var6 = getDirectionFromMetadata(var5);

        for(int var7 = 0; var7 <= 1; ++var7) {
            int var8 = var1 - headBlockToFootBlockMap[var6][0] * var7 - 1;
            int var9 = var3 - headBlockToFootBlockMap[var6][1] * var7 - 1;
            int var10 = var8 + 2;
            int var11 = var9 + 2;

            for(int var12 = var8; var12 <= var10; ++var12) {
                for(int var13 = var9; var13 <= var11; ++var13) {
                    if (var0.isBlockNormalCube(var12, var2 - 1, var13) && var0.isAirBlock(var12, var2, var13) && var0.isAirBlock(var12, var2 + 1, var13)) {
                        if (var4 <= 0) {
                            return new ChunkCoordinates(var12, var2, var13);
                        }

                        --var4;
                    }
                }
            }
        }

        return null;
    }

    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
        if (!isBlockFootOfBed(var5)) {
            super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
        }

    }

    public int getMobilityFlag() {
        return 1;
    }
}
