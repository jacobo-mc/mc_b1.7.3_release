package net.minecraft.src;

import java.util.Random;

public class BlockLeaves extends BlockLeavesBase {
    private int field_463_b;
    int[] field_20017_a;

    protected BlockLeaves(int var1, int var2) {
        super(var1, var2, Material.field_4265_h, false);
        this.field_463_b = var2;
        this.func_253_b(true);
    }

    public int func_31030_b(int var1) {
        if ((var1 & 1) == 1) {
            return ColorizerFoliage.func_21175_a();
        } else {
            return (var1 & 2) == 2 ? ColorizerFoliage.func_21174_b() : ColorizerFoliage.func_31073_c();
        }
    }

    public int func_207_d(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        if ((var5 & 1) == 1) {
            return ColorizerFoliage.func_21175_a();
        } else if ((var5 & 2) == 2) {
            return ColorizerFoliage.func_21174_b();
        } else {
            var1.func_4075_a().func_4069_a(var2, var4, 1, 1);
            double var6 = var1.func_4075_a().field_4198_a[0];
            double var8 = var1.func_4075_a().field_4197_b[0];
            return ColorizerFoliage.func_4146_a(var6, var8);
        }
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        byte var5 = 1;
        int var6 = var5 + 1;
        if (var1.func_640_a(var2 - var6, var3 - var6, var4 - var6, var2 + var6, var3 + var6, var4 + var6)) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
                for(int var8 = -var5; var8 <= var5; ++var8) {
                    for(int var9 = -var5; var9 <= var5; ++var9) {
                        int var10 = var1.func_600_a(var2 + var7, var3 + var8, var4 + var9);
                        if (var10 == Block.field_384_L.field_376_bc) {
                            int var11 = var1.func_602_e(var2 + var7, var3 + var8, var4 + var9);
                            var1.func_635_c(var2 + var7, var3 + var8, var4 + var9, var11 | 8);
                        }
                    }
                }
            }
        }

    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_1026_y) {
            int var6 = var1.func_602_e(var2, var3, var4);
            if ((var6 & 8) != 0) {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;
                if (this.field_20017_a == null) {
                    this.field_20017_a = new int[var9 * var9 * var9];
                }

                int var12;
                if (var1.func_640_a(var2 - var8, var3 - var8, var4 - var8, var2 + var8, var3 + var8, var4 + var8)) {
                    var12 = -var7;

                    label111:
                    while(true) {
                        int var13;
                        int var14;
                        int var15;
                        if (var12 > var7) {
                            var12 = 1;

                            while(true) {
                                if (var12 > 4) {
                                    break label111;
                                }

                                for(var13 = -var7; var13 <= var7; ++var13) {
                                    for(var14 = -var7; var14 <= var7; ++var14) {
                                        for(var15 = -var7; var15 <= var7; ++var15) {
                                            if (this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
                                                if (this.field_20017_a[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_20017_a[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20017_a[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_20017_a[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
                                                    this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
                                                    this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
                                                    this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                                }

                                                if (this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
                                                    this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                                }
                                            }
                                        }
                                    }
                                }

                                ++var12;
                            }
                        }

                        for(var13 = -var7; var13 <= var7; ++var13) {
                            for(var14 = -var7; var14 <= var7; ++var14) {
                                var15 = var1.func_600_a(var2 + var12, var3 + var13, var4 + var14);
                                if (var15 == Block.field_385_K.field_376_bc) {
                                    this.field_20017_a[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (var15 == Block.field_384_L.field_376_bc) {
                                    this.field_20017_a[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                } else {
                                    this.field_20017_a[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }

                        ++var12;
                    }
                }

                var12 = this.field_20017_a[var11 * var10 + var11 * var9 + var11];
                if (var12 >= 0) {
                    var1.func_635_c(var2, var3, var4, var6 & -9);
                } else {
                    this.func_6360_i(var1, var2, var3, var4);
                }
            }

        }
    }

    private void func_6360_i(World var1, int var2, int var3, int var4) {
        this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
        var1.func_690_d(var2, var3, var4, 0);
    }

    public int func_229_a(Random var1) {
        return var1.nextInt(20) == 0 ? 1 : 0;
    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_333_z.field_376_bc;
    }

    public void func_220_a_(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        if (!var1.field_1026_y && var2.func_6416_v() != null && var2.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS) {
            var2.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
            this.func_31027_a(var1, var3, var4, var5, new ItemStack(Block.field_384_L.field_376_bc, 1, var6 & 3));
        } else {
            super.func_220_a_(var1, var2, var3, var4, var5, var6);
        }

    }

    protected int func_21025_b(int var1) {
        return var1 & 3;
    }

    public boolean func_217_b() {
        return !this.field_6359_a;
    }

    public int func_232_a(int var1, int var2) {
        return (var2 & 3) == 1 ? this.field_378_bb + 80 : this.field_378_bb;
    }

    public void func_310_a(boolean var1) {
        this.field_6359_a = var1;
        this.field_378_bb = this.field_463_b + (var1 ? 0 : 1);
    }

    public void func_254_a(World var1, int var2, int var3, int var4, Entity var5) {
        super.func_254_a(var1, var2, var3, var4, var5);
    }
}
