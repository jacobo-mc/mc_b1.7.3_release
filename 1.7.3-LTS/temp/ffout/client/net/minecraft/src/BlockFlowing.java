package net.minecraft.src;

import java.util.Random;

public class BlockFlowing extends BlockFluid {
    int field_460_a = 0;
    boolean[] field_459_b = new boolean[4];
    int[] field_461_c = new int[4];

    protected BlockFlowing(int var1, Material var2) {
        super(var1, var2);
    }

    private void func_30003_j(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        var1.func_643_a(var2, var3, var4, this.field_376_bc + 1, var5);
        var1.func_701_b(var2, var3, var4, var2, var3, var4);
        var1.func_665_h(var2, var3, var4);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = this.func_290_h(var1, var2, var3, var4);
        byte var7 = 1;
        if (this.field_356_bn == Material.field_1331_g && !var1.field_4209_q.field_6479_d) {
            var7 = 2;
        }

        boolean var8 = true;
        int var10;
        if (var6 > 0) {
            byte var9 = -100;
            this.field_460_a = 0;
            int var12 = this.func_296_f(var1, var2 - 1, var3, var4, var9);
            var12 = this.func_296_f(var1, var2 + 1, var3, var4, var12);
            var12 = this.func_296_f(var1, var2, var3, var4 - 1, var12);
            var12 = this.func_296_f(var1, var2, var3, var4 + 1, var12);
            var10 = var12 + var7;
            if (var10 >= 8 || var12 < 0) {
                var10 = -1;
            }

            if (this.func_290_h(var1, var2, var3 + 1, var4) >= 0) {
                int var11 = this.func_290_h(var1, var2, var3 + 1, var4);
                if (var11 >= 8) {
                    var10 = var11;
                } else {
                    var10 = var11 + 8;
                }
            }

            if (this.field_460_a >= 2 && this.field_356_bn == Material.field_1332_f) {
                if (var1.func_599_f(var2, var3 - 1, var4).func_878_a()) {
                    var10 = 0;
                } else if (var1.func_599_f(var2, var3 - 1, var4) == this.field_356_bn && var1.func_602_e(var2, var3, var4) == 0) {
                    var10 = 0;
                }
            }

            if (this.field_356_bn == Material.field_1331_g && var6 < 8 && var10 < 8 && var10 > var6 && var5.nextInt(4) != 0) {
                var10 = var6;
                var8 = false;
            }

            if (var10 != var6) {
                var6 = var10;
                if (var10 < 0) {
                    var1.func_690_d(var2, var3, var4, 0);
                } else {
                    var1.func_691_b(var2, var3, var4, var10);
                    var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
                    var1.func_611_g(var2, var3, var4, this.field_376_bc);
                }
            } else if (var8) {
                this.func_30003_j(var1, var2, var3, var4);
            }
        } else {
            this.func_30003_j(var1, var2, var3, var4);
        }

        if (this.func_298_m(var1, var2, var3 - 1, var4)) {
            if (var6 >= 8) {
                var1.func_688_b(var2, var3 - 1, var4, this.field_376_bc, var6);
            } else {
                var1.func_688_b(var2, var3 - 1, var4, this.field_376_bc, var6 + 8);
            }
        } else if (var6 >= 0 && (var6 == 0 || this.func_295_l(var1, var2, var3 - 1, var4))) {
            boolean[] var13 = this.func_297_k(var1, var2, var3, var4);
            var10 = var6 + var7;
            if (var6 >= 8) {
                var10 = 1;
            }

            if (var10 >= 8) {
                return;
            }

            if (var13[0]) {
                this.func_299_g(var1, var2 - 1, var3, var4, var10);
            }

            if (var13[1]) {
                this.func_299_g(var1, var2 + 1, var3, var4, var10);
            }

            if (var13[2]) {
                this.func_299_g(var1, var2, var3, var4 - 1, var10);
            }

            if (var13[3]) {
                this.func_299_g(var1, var2, var3, var4 + 1, var10);
            }
        }

    }

    private void func_299_g(World var1, int var2, int var3, int var4, int var5) {
        if (this.func_298_m(var1, var2, var3, var4)) {
            int var6 = var1.func_600_a(var2, var3, var4);
            if (var6 > 0) {
                if (this.field_356_bn == Material.field_1331_g) {
                    this.func_292_i(var1, var2, var3, var4);
                } else {
                    Block.field_345_n[var6].func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
                }
            }

            var1.func_688_b(var2, var3, var4, this.field_376_bc, var5);
        }

    }

    private int func_300_a(World var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = 1000;

        for(int var8 = 0; var8 < 4; ++var8) {
            if ((var8 != 0 || var6 != 1) && (var8 != 1 || var6 != 0) && (var8 != 2 || var6 != 3) && (var8 != 3 || var6 != 2)) {
                int var9 = var2;
                int var11 = var4;
                if (var8 == 0) {
                    var9 = var2 - 1;
                }

                if (var8 == 1) {
                    ++var9;
                }

                if (var8 == 2) {
                    var11 = var4 - 1;
                }

                if (var8 == 3) {
                    ++var11;
                }

                if (!this.func_295_l(var1, var9, var3, var11) && (var1.func_599_f(var9, var3, var11) != this.field_356_bn || var1.func_602_e(var9, var3, var11) != 0)) {
                    if (!this.func_295_l(var1, var9, var3 - 1, var11)) {
                        return var5;
                    }

                    if (var5 < 4) {
                        int var12 = this.func_300_a(var1, var9, var3, var11, var5 + 1, var8);
                        if (var12 < var7) {
                            var7 = var12;
                        }
                    }
                }
            }
        }

        return var7;
    }

    private boolean[] func_297_k(World var1, int var2, int var3, int var4) {
        int var5;
        int var6;
        for(var5 = 0; var5 < 4; ++var5) {
            this.field_461_c[var5] = 1000;
            var6 = var2;
            int var8 = var4;
            if (var5 == 0) {
                var6 = var2 - 1;
            }

            if (var5 == 1) {
                ++var6;
            }

            if (var5 == 2) {
                var8 = var4 - 1;
            }

            if (var5 == 3) {
                ++var8;
            }

            if (!this.func_295_l(var1, var6, var3, var8) && (var1.func_599_f(var6, var3, var8) != this.field_356_bn || var1.func_602_e(var6, var3, var8) != 0)) {
                if (!this.func_295_l(var1, var6, var3 - 1, var8)) {
                    this.field_461_c[var5] = 0;
                } else {
                    this.field_461_c[var5] = this.func_300_a(var1, var6, var3, var8, 1, var5);
                }
            }
        }

        var5 = this.field_461_c[0];

        for(var6 = 1; var6 < 4; ++var6) {
            if (this.field_461_c[var6] < var5) {
                var5 = this.field_461_c[var6];
            }
        }

        for(var6 = 0; var6 < 4; ++var6) {
            this.field_459_b[var6] = this.field_461_c[var6] == var5;
        }

        return this.field_459_b;
    }

    private boolean func_295_l(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_600_a(var2, var3, var4);
        if (var5 != Block.field_442_aF.field_376_bc && var5 != Block.field_435_aM.field_376_bc && var5 != Block.field_443_aE.field_376_bc && var5 != Block.field_441_aG.field_376_bc && var5 != Block.field_423_aY.field_376_bc) {
            if (var5 == 0) {
                return false;
            } else {
                Material var6 = Block.field_345_n[var5].field_356_bn;
                return var6.func_880_c();
            }
        } else {
            return true;
        }
    }

    protected int func_296_f(World var1, int var2, int var3, int var4, int var5) {
        int var6 = this.func_290_h(var1, var2, var3, var4);
        if (var6 < 0) {
            return var5;
        } else {
            if (var6 == 0) {
                ++this.field_460_a;
            }

            if (var6 >= 8) {
                var6 = 0;
            }

            return var5 >= 0 && var6 >= var5 ? var5 : var6;
        }
    }

    private boolean func_298_m(World var1, int var2, int var3, int var4) {
        Material var5 = var1.func_599_f(var2, var3, var4);
        if (var5 == this.field_356_bn) {
            return false;
        } else if (var5 == Material.field_1331_g) {
            return false;
        } else {
            return !this.func_295_l(var1, var2, var3, var4);
        }
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        super.func_235_e(var1, var2, var3, var4);
        if (var1.func_600_a(var2, var3, var4) == this.field_376_bc) {
            var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
        }

    }
}
