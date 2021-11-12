package net.minecraft.src;

import java.util.Random;

public class WorldGenTaiga1 extends WorldGenerator {
    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        int var6 = var2.nextInt(5) + 7;
        int var7 = var6 - var2.nextInt(2) - 3;
        int var8 = var6 - var7;
        int var9 = 1 + var2.nextInt(var8 + 1);
        boolean var10 = true;
        if (var4 >= 1 && var4 + var6 + 1 <= 128) {
            int var11;
            int var13;
            int var14;
            int var15;
            int var18;
            for(var11 = var4; var11 <= var4 + 1 + var6 && var10; ++var11) {
                boolean var12 = true;
                if (var11 - var4 < var7) {
                    var18 = 0;
                } else {
                    var18 = var9;
                }

                for(var13 = var3 - var18; var13 <= var3 + var18 && var10; ++var13) {
                    for(var14 = var5 - var18; var14 <= var5 + var18 && var10; ++var14) {
                        if (var11 >= 0 && var11 < 128) {
                            var15 = var1.func_444_a(var13, var11, var14);
                            if (var15 != 0 && var15 != Block.field_581_L.field_573_bc) {
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
                var11 = var1.func_444_a(var3, var4 - 1, var5);
                if ((var11 == Block.field_534_v.field_573_bc || var11 == Block.field_533_w.field_573_bc) && var4 < 128 - var6 - 1) {
                    var1.func_462_a(var3, var4 - 1, var5, Block.field_533_w.field_573_bc);
                    var18 = 0;

                    for(var13 = var4 + var6; var13 >= var4 + var7; --var13) {
                        for(var14 = var3 - var18; var14 <= var3 + var18; ++var14) {
                            var15 = var14 - var3;

                            for(int var16 = var5 - var18; var16 <= var5 + var18; ++var16) {
                                int var17 = var16 - var5;
                                if ((Math.abs(var15) != var18 || Math.abs(var17) != var18 || var18 <= 0) && !Block.field_540_p[var1.func_444_a(var14, var13, var16)]) {
                                    var1.func_470_a(var14, var13, var16, Block.field_581_L.field_573_bc, 1);
                                }
                            }
                        }

                        if (var18 >= 1 && var13 == var4 + var7 + 1) {
                            --var18;
                        } else if (var18 < var9) {
                            ++var18;
                        }
                    }

                    for(var13 = 0; var13 < var6 - 1; ++var13) {
                        var14 = var1.func_444_a(var3, var4 + var13, var5);
                        if (var14 == 0 || var14 == Block.field_581_L.field_573_bc) {
                            var1.func_470_a(var3, var4 + var13, var5, Block.field_582_K.field_573_bc, 1);
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
