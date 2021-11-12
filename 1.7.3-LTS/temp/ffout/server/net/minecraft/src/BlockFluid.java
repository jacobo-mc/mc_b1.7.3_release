package net.minecraft.src;

import java.util.Random;

public abstract class BlockFluid extends Block {
    protected BlockFluid(int var1, Material var2) {
        super(var1, (var2 == Material.field_520_g ? 14 : 12) * 16 + 13, var2);
        float var3 = 0.0F;
        float var4 = 0.0F;
        this.func_229_a(0.0F + var4, 0.0F + var3, 0.0F + var4, 1.0F + var4, 1.0F + var3, 1.0F + var4);
        this.func_231_a(true);
    }

    public static float func_299_b(int var0) {
        if (var0 >= 8) {
            var0 = 0;
        }

        float var1 = (float)(var0 + 1) / 9.0F;
        return var1;
    }

    public int func_241_a(int var1) {
        return var1 != 0 && var1 != 1 ? this.field_575_bb + 1 : this.field_575_bb;
    }

    protected int func_301_g(World var1, int var2, int var3, int var4) {
        return var1.func_443_c(var2, var3, var4) != this.field_553_bn ? -1 : var1.func_446_b(var2, var3, var4);
    }

    protected int func_303_b(IBlockAccess var1, int var2, int var3, int var4) {
        if (var1.func_443_c(var2, var3, var4) != this.field_553_bn) {
            return -1;
        } else {
            int var5 = var1.func_446_b(var2, var3, var4);
            if (var5 >= 8) {
                var5 = 0;
            }

            return var5;
        }
    }

    public boolean func_28025_b() {
        return false;
    }

    public boolean func_240_b() {
        return false;
    }

    public boolean func_243_a(int var1, boolean var2) {
        return var2 && var1 == 0;
    }

    public boolean func_253_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        Material var6 = var1.func_443_c(var2, var3, var4);
        if (var6 == this.field_553_bn) {
            return false;
        } else if (var6 == Material.field_509_r) {
            return false;
        } else {
            return var5 == 1 ? true : super.func_253_a(var1, var2, var3, var4, var5);
        }
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public int func_252_a(int var1, Random var2) {
        return 0;
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    private Vec3D func_298_c(IBlockAccess var1, int var2, int var3, int var4) {
        Vec3D var5 = Vec3D.func_768_b(0.0D, 0.0D, 0.0D);
        int var6 = this.func_303_b(var1, var2, var3, var4);

        for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = var2;
            int var10 = var4;
            if (var7 == 0) {
                var8 = var2 - 1;
            }

            if (var7 == 1) {
                var10 = var4 - 1;
            }

            if (var7 == 2) {
                ++var8;
            }

            if (var7 == 3) {
                ++var10;
            }

            int var11 = this.func_303_b(var1, var8, var3, var10);
            int var12;
            if (var11 < 0) {
                if (!var1.func_443_c(var8, var3, var10).func_218_c()) {
                    var11 = this.func_303_b(var1, var8, var3 - 1, var10);
                    if (var11 >= 0) {
                        var12 = var11 - (var6 - 8);
                        var5 = var5.func_757_c((double)((var8 - var2) * var12), (double)((var3 - var3) * var12), (double)((var10 - var4) * var12));
                    }
                }
            } else if (var11 >= 0) {
                var12 = var11 - var6;
                var5 = var5.func_757_c((double)((var8 - var2) * var12), (double)((var3 - var3) * var12), (double)((var10 - var4) * var12));
            }
        }

        if (var1.func_446_b(var2, var3, var4) >= 8) {
            boolean var13 = false;
            if (var13 || this.func_253_a(var1, var2, var3, var4 - 1, 2)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2, var3, var4 + 1, 3)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2 - 1, var3, var4, 4)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2 + 1, var3, var4, 5)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2, var3 + 1, var4 - 1, 2)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2, var3 + 1, var4 + 1, 3)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2 - 1, var3 + 1, var4, 4)) {
                var13 = true;
            }

            if (var13 || this.func_253_a(var1, var2 + 1, var3 + 1, var4, 5)) {
                var13 = true;
            }

            if (var13) {
                var5 = var5.func_758_b().func_757_c(0.0D, -6.0D, 0.0D);
            }
        }

        var5 = var5.func_758_b();
        return var5;
    }

    public void func_230_a(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
        Vec3D var7 = this.func_298_c(var1, var2, var3, var4);
        var6.field_1055_a += var7.field_1055_a;
        var6.field_1054_b += var7.field_1054_b;
        var6.field_1058_c += var7.field_1058_c;
    }

    public int func_4028_b() {
        if (this.field_553_bn == Material.field_521_f) {
            return 5;
        } else {
            return this.field_553_bn == Material.field_520_g ? 30 : 0;
        }
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        super.func_221_a(var1, var2, var3, var4, var5);
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        this.func_302_i(var1, var2, var3, var4);
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        this.func_302_i(var1, var2, var3, var4);
    }

    private void func_302_i(World var1, int var2, int var3, int var4) {
        if (var1.func_444_a(var2, var3, var4) == this.field_573_bc) {
            if (this.field_553_bn == Material.field_520_g) {
                boolean var5 = false;
                if (var5 || var1.func_443_c(var2, var3, var4 - 1) == Material.field_521_f) {
                    var5 = true;
                }

                if (var5 || var1.func_443_c(var2, var3, var4 + 1) == Material.field_521_f) {
                    var5 = true;
                }

                if (var5 || var1.func_443_c(var2 - 1, var3, var4) == Material.field_521_f) {
                    var5 = true;
                }

                if (var5 || var1.func_443_c(var2 + 1, var3, var4) == Material.field_521_f) {
                    var5 = true;
                }

                if (var5 || var1.func_443_c(var2, var3 + 1, var4) == Material.field_521_f) {
                    var5 = true;
                }

                if (var5) {
                    int var6 = var1.func_446_b(var2, var3, var4);
                    if (var6 == 0) {
                        var1.func_508_d(var2, var3, var4, Block.field_602_aq.field_573_bc);
                    } else if (var6 <= 4) {
                        var1.func_508_d(var2, var3, var4, Block.field_532_x.field_573_bc);
                    }

                    this.func_300_h(var1, var2, var3, var4);
                }
            }

        }
    }

    protected void func_300_h(World var1, int var2, int var3, int var4) {
        var1.func_502_a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.field_803_m.nextFloat() - var1.field_803_m.nextFloat()) * 0.8F);

        for(int var5 = 0; var5 < 8; ++var5) {
            var1.func_514_a("largesmoke", (double)var2 + Math.random(), (double)var3 + 1.2D, (double)var4 + Math.random(), 0.0D, 0.0D, 0.0D);
        }

    }
}
