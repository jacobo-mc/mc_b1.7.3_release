package net.minecraft.src;

public class ItemDye extends Item {
    public static final String[] dyeColors = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
    public static final int[] field_31023_bk = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

    public ItemDye(int var1) {
        super(var1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var1.getItemDamage() == 15) {
            int var8 = var3.getBlockId(var4, var5, var6);
            if (var8 == Block.sapling.blockID) {
                if (!var3.singleplayerWorld) {
                    ((BlockSapling)Block.sapling).growTree(var3, var4, var5, var6, var3.rand);
                    --var1.stackSize;
                }

                return true;
            }

            if (var8 == Block.crops.blockID) {
                if (!var3.singleplayerWorld) {
                    ((BlockCrops)Block.crops).fertilize(var3, var4, var5, var6);
                    --var1.stackSize;
                }

                return true;
            }

            if (var8 == Block.grass.blockID) {
                if (!var3.singleplayerWorld) {
                    --var1.stackSize;

                    label53:
                    for(int var9 = 0; var9 < 128; ++var9) {
                        int var10 = var4;
                        int var11 = var5 + 1;
                        int var12 = var6;

                        for(int var13 = 0; var13 < var9 / 16; ++var13) {
                            var10 += itemRand.nextInt(3) - 1;
                            var11 += (itemRand.nextInt(3) - 1) * itemRand.nextInt(3) / 2;
                            var12 += itemRand.nextInt(3) - 1;
                            if (var3.getBlockId(var10, var11 - 1, var12) != Block.grass.blockID || var3.isBlockNormalCube(var10, var11, var12)) {
                                continue label53;
                            }
                        }

                        if (var3.getBlockId(var10, var11, var12) == 0) {
                            if (itemRand.nextInt(10) != 0) {
                                var3.setBlockAndMetadataWithNotify(var10, var11, var12, Block.tallGrass.blockID, 1);
                            } else if (itemRand.nextInt(3) != 0) {
                                var3.setBlockWithNotify(var10, var11, var12, Block.plantYellow.blockID);
                            } else {
                                var3.setBlockWithNotify(var10, var11, var12, Block.plantRed.blockID);
                            }
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }

    public void saddleEntity(ItemStack var1, EntityLiving var2) {
        if (var2 instanceof EntitySheep) {
            EntitySheep var3 = (EntitySheep)var2;
            int var4 = BlockCloth.func_21033_c(var1.getItemDamage());
            if (!var3.func_21069_f_() && var3.getFleeceColor() != var4) {
                var3.setFleeceColor(var4);
                --var1.stackSize;
            }
        }

    }
}
