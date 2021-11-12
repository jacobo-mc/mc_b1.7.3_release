package net.minecraft.src;

import java.util.Random;

public class WorldGenDungeons extends WorldGenerator {
    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        byte var6 = 3;
        int var7 = var2.nextInt(2) + 2;
        int var8 = var2.nextInt(2) + 2;
        int var9 = 0;

        int var10;
        int var11;
        int var12;
        for(var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10) {
            for(var11 = var4 - 1; var11 <= var4 + var6 + 1; ++var11) {
                for(var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12) {
                    Material var13 = var1.func_443_c(var10, var11, var12);
                    if (var11 == var4 - 1 && !var13.func_216_a()) {
                        return false;
                    }

                    if (var11 == var4 + var6 + 1 && !var13.func_216_a()) {
                        return false;
                    }

                    if ((var10 == var3 - var7 - 1 || var10 == var3 + var7 + 1 || var12 == var5 - var8 - 1 || var12 == var5 + var8 + 1) && var11 == var4 && var1.func_20111_e(var10, var11, var12) && var1.func_20111_e(var10, var11 + 1, var12)) {
                        ++var9;
                    }
                }
            }
        }

        if (var9 >= 1 && var9 <= 5) {
            for(var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10) {
                for(var11 = var4 + var6; var11 >= var4 - 1; --var11) {
                    for(var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12) {
                        if (var10 != var3 - var7 - 1 && var11 != var4 - 1 && var12 != var5 - var8 - 1 && var10 != var3 + var7 + 1 && var11 != var4 + var6 + 1 && var12 != var5 + var8 + 1) {
                            var1.func_508_d(var10, var11, var12, 0);
                        } else if (var11 >= 0 && !var1.func_443_c(var10, var11 - 1, var12).func_216_a()) {
                            var1.func_508_d(var10, var11, var12, 0);
                        } else if (var1.func_443_c(var10, var11, var12).func_216_a()) {
                            if (var11 == var4 - 1 && var2.nextInt(4) != 0) {
                                var1.func_508_d(var10, var11, var12, Block.field_603_ap.field_573_bc);
                            } else {
                                var1.func_508_d(var10, var11, var12, Block.field_532_x.field_573_bc);
                            }
                        }
                    }
                }
            }

            label110:
            for(var10 = 0; var10 < 2; ++var10) {
                for(var11 = 0; var11 < 3; ++var11) {
                    var12 = var3 + var2.nextInt(var7 * 2 + 1) - var7;
                    int var14 = var5 + var2.nextInt(var8 * 2 + 1) - var8;
                    if (var1.func_20111_e(var12, var4, var14)) {
                        int var15 = 0;
                        if (var1.func_443_c(var12 - 1, var4, var14).func_216_a()) {
                            ++var15;
                        }

                        if (var1.func_443_c(var12 + 1, var4, var14).func_216_a()) {
                            ++var15;
                        }

                        if (var1.func_443_c(var12, var4, var14 - 1).func_216_a()) {
                            ++var15;
                        }

                        if (var1.func_443_c(var12, var4, var14 + 1).func_216_a()) {
                            ++var15;
                        }

                        if (var15 == 1) {
                            var1.func_508_d(var12, var4, var14, Block.field_593_av.field_573_bc);
                            TileEntityChest var16 = (TileEntityChest)var1.func_451_k(var12, var4, var14);
                            int var17 = 0;

                            while(true) {
                                if (var17 >= 8) {
                                    continue label110;
                                }

                                ItemStack var18 = this.func_434_a(var2);
                                if (var18 != null) {
                                    var16.func_206_a(var2.nextInt(var16.func_83_a()), var18);
                                }

                                ++var17;
                            }
                        }
                    }
                }
            }

            var1.func_508_d(var3, var4, var5, Block.field_597_at.field_573_bc);
            TileEntityMobSpawner var19 = (TileEntityMobSpawner)var1.func_451_k(var3, var4, var5);
            var19.func_21078_a(this.func_433_b(var2));
            return true;
        } else {
            return false;
        }
    }

    private ItemStack func_434_a(Random var1) {
        int var2 = var1.nextInt(11);
        if (var2 == 0) {
            return new ItemStack(Item.field_197_ay);
        } else if (var2 == 1) {
            return new ItemStack(Item.field_166_m, var1.nextInt(4) + 1);
        } else if (var2 == 2) {
            return new ItemStack(Item.field_185_S);
        } else if (var2 == 3) {
            return new ItemStack(Item.field_186_R, var1.nextInt(4) + 1);
        } else if (var2 == 4) {
            return new ItemStack(Item.field_193_K, var1.nextInt(4) + 1);
        } else if (var2 == 5) {
            return new ItemStack(Item.field_196_I, var1.nextInt(4) + 1);
        } else if (var2 == 6) {
            return new ItemStack(Item.field_205_au);
        } else if (var2 == 7 && var1.nextInt(100) == 0) {
            return new ItemStack(Item.field_212_ar);
        } else if (var2 == 8 && var1.nextInt(2) == 0) {
            return new ItemStack(Item.field_252_aA, var1.nextInt(4) + 1);
        } else if (var2 == 9 && var1.nextInt(10) == 0) {
            return new ItemStack(Item.field_176_c[Item.field_236_aQ.field_234_aS + var1.nextInt(2)]);
        } else {
            return var2 == 10 ? new ItemStack(Item.field_21097_aU, 1, 3) : null;
        }
    }

    private String func_433_b(Random var1) {
        int var2 = var1.nextInt(4);
        if (var2 == 0) {
            return "Skeleton";
        } else if (var2 == 1) {
            return "Zombie";
        } else if (var2 == 2) {
            return "Zombie";
        } else {
            return var2 == 3 ? "Spider" : "";
        }
    }
}
