package net.minecraft.src;

import java.util.Random;

public class BlockLeaves extends BlockLeavesBase {
    private int field_663_c;
    int[] field_20041_b;

    protected BlockLeaves(int var1, int var2) {
        super(var1, var2, Material.field_4218_h, false);
        this.field_663_c = var2;
        this.func_231_a(true);
    }

    public void func_242_b(World var1, int var2, int var3, int var4) {
        byte var5 = 1;
        int var6 = var5 + 1;
        if (var1.func_466_a(var2 - var6, var3 - var6, var4 - var6, var2 + var6, var3 + var6, var4 + var6)) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
                for(int var8 = -var5; var8 <= var5; ++var8) {
                    for(int var9 = -var5; var9 <= var5; ++var9) {
                        int var10 = var1.func_444_a(var2 + var7, var3 + var8, var4 + var9);
                        if (var10 == Block.field_581_L.field_573_bc) {
                            int var11 = var1.func_446_b(var2 + var7, var3 + var8, var4 + var9);
                            var1.func_463_c(var2 + var7, var3 + var8, var4 + var9, var11 | 8);
                        }
                    }
                }
            }
        }

    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_792_x) {
            int var6 = var1.func_446_b(var2, var3, var4);
            if ((var6 & 8) != 0) {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;
                if (this.field_20041_b == null) {
                    this.field_20041_b = new int[var9 * var9 * var9];
                }

                int var12;
                if (var1.func_466_a(var2 - var8, var3 - var8, var4 - var8, var2 + var8, var3 + var8, var4 + var8)) {
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
                                            if (this.field_20041_b[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
                                                if (this.field_20041_b[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_20041_b[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20041_b[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                                    this.field_20041_b[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20041_b[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
                                                    this.field_20041_b[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20041_b[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
                                                    this.field_20041_b[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                                }

                                                if (this.field_20041_b[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
                                                    this.field_20041_b[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                                }

                                                if (this.field_20041_b[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
                                                    this.field_20041_b[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
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
                                var15 = var1.func_444_a(var2 + var12, var3 + var13, var4 + var14);
                                if (var15 == Block.field_582_K.field_573_bc) {
                                    this.field_20041_b[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                } else if (var15 == Block.field_581_L.field_573_bc) {
                                    this.field_20041_b[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                } else {
                                    this.field_20041_b[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }

                        ++var12;
                    }
                }

                var12 = this.field_20041_b[var11 * var10 + var11 * var9 + var11];
                if (var12 >= 0) {
                    var1.func_463_c(var2, var3, var4, var6 & -9);
                } else {
                    this.func_6091_h(var1, var2, var3, var4);
                }
            }

        }
    }

    private void func_6091_h(World var1, int var2, int var3, int var4) {
        this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
        var1.func_508_d(var2, var3, var4, 0);
    }

    public int func_244_a(Random var1) {
        return var1.nextInt(20) == 0 ? 1 : 0;
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_6047_y.field_573_bc;
    }

    public void func_12007_g(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        if (!var1.field_792_x && var2.func_172_B() != null && var2.func_172_B().field_855_c == Item.field_31022_bc.field_234_aS) {
            var2.func_25046_a(StatList.field_25094_y[this.field_573_bc], 1);
            this.func_31024_a(var1, var3, var4, var5, new ItemStack(Block.field_581_L.field_573_bc, 1, var6 & 3));
        } else {
            super.func_12007_g(var1, var2, var3, var4, var5, var6);
        }

    }

    protected int func_21025_b(int var1) {
        return var1 & 3;
    }

    public boolean func_240_b() {
        return !this.field_6088_a;
    }

    public int func_22009_a(int var1, int var2) {
        return (var2 & 3) == 1 ? this.field_575_bb + 80 : this.field_575_bb;
    }

    public void func_249_b(World var1, int var2, int var3, int var4, Entity var5) {
        super.func_249_b(var1, var2, var3, var4, var5);
    }
}
