package net.minecraft.src;

import java.util.Random;

public class WorldGenTaiga2 extends WorldGenerator {
    public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
        int var6 = var2.nextInt(4) + 6;
        int var7 = 1 + var2.nextInt(2);
        int var8 = var6 - var7;
        int var9 = 2 + var2.nextInt(2);
        boolean var10 = true;
        if (var4 >= 1 && var4 + var6 + 1 <= 128) {
            int var11;
            int var13;
            int var15;
            int var21;
            for(var11 = var4; var11 <= var4 + 1 + var6 && var10; ++var11) {
                boolean var12 = true;
                if (var11 - var4 < var7) {
                    var21 = 0;
                } else {
                    var21 = var9;
                }

                for(var13 = var3 - var21; var13 <= var3 + var21 && var10; ++var13) {
                    for(int var14 = var5 - var21; var14 <= var5 + var21 && var10; ++var14) {
                        if (var11 >= 0 && var11 < 128) {
                            var15 = var1.getBlockId(var13, var11, var14);
                            if (var15 != 0 && var15 != Block.leaves.blockID) {
                                var10 = false;
                            }
                        } else {
                            var10 = false;
                        }
                    }
                }
            }

            if (!var10) {
                return false;
            } else {
                var11 = var1.getBlockId(var3, var4 - 1, var5);
                if ((var11 == Block.grass.blockID || var11 == Block.dirt.blockID) && var4 < 128 - var6 - 1) {
                    var1.setBlock(var3, var4 - 1, var5, Block.dirt.blockID);
                    var21 = var2.nextInt(2);
                    var13 = 1;
                    byte var22 = 0;

                    int var16;
                    int var17;
                    for(var15 = 0; var15 <= var8; ++var15) {
                        var16 = var4 + var6 - var15;

                        for(var17 = var3 - var21; var17 <= var3 + var21; ++var17) {
                            int var18 = var17 - var3;

                            for(int var19 = var5 - var21; var19 <= var5 + var21; ++var19) {
                                int var20 = var19 - var5;
                                if ((Math.abs(var18) != var21 || Math.abs(var20) != var21 || var21 <= 0) && !Block.opaqueCubeLookup[var1.getBlockId(var17, var16, var19)]) {
                                    var1.setBlockAndMetadata(var17, var16, var19, Block.leaves.blockID, 1);
                                }
                            }
                        }

                        if (var21 >= var13) {
                            var21 = var22;
                            var22 = 1;
                            ++var13;
                            if (var13 > var9) {
                                var13 = var9;
                            }
                        } else {
                            ++var21;
                        }
                    }

                    var15 = var2.nextInt(3);

                    for(var16 = 0; var16 < var6 - var15; ++var16) {
                        var17 = var1.getBlockId(var3, var4 + var16, var5);
                        if (var17 == 0 || var17 == Block.leaves.blockID) {
                            var1.setBlockAndMetadata(var3, var4 + var16, var5, Block.wood.blockID, 1);
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
