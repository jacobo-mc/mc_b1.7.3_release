package net.minecraft.src;

import java.util.Random;

public abstract class BlockFluid extends Block {
    protected BlockFluid(int var1, Material var2) {
        super(var1, (var2 == Material.field_1331_g ? 14 : 12) * 16 + 13, var2);
        float var3 = 0.0F;
        float var4 = 0.0F;
        this.func_213_a(0.0F + var4, 0.0F + var3, 0.0F + var4, 1.0F + var4, 1.0F + var3, 1.0F + var4);
        this.func_253_b(true);
    }

    public int func_207_d(IBlockAccess var1, int var2, int var3, int var4) {
        return 16777215;
    }

    public static float func_288_b(int var0) {
        if (var0 >= 8) {
            var0 = 0;
        }

        float var1 = (float)(var0 + 1) / 9.0F;
        return var1;
    }

    public int func_218_a(int var1) {
        return var1 != 0 && var1 != 1 ? this.field_378_bb + 1 : this.field_378_bb;
    }

    protected int func_290_h(World var1, int var2, int var3, int var4) {
        return var1.func_599_f(var2, var3, var4) != this.field_356_bn ? -1 : var1.func_602_e(var2, var3, var4);
    }

    protected int func_289_b(IBlockAccess var1, int var2, int var3, int var4) {
        if (var1.func_599_f(var2, var3, var4) != this.field_356_bn) {
            return -1;
        } else {
            int var5 = var1.func_602_e(var2, var3, var4);
            if (var5 >= 8) {
                var5 = 0;
            }

            return var5;
        }
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_224_a(int var1, boolean var2) {
        return var2 && var1 == 0;
    }

    public boolean func_28029_d(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        Material var6 = var1.func_599_f(var2, var3, var4);
        if (var6 == this.field_356_bn) {
            return false;
        } else if (var6 == Material.field_1320_r) {
            return false;
        } else {
            return var5 == 1 ? true : super.func_28029_d(var1, var2, var3, var4, var5);
        }
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        Material var6 = var1.func_599_f(var2, var3, var4);
        if (var6 == this.field_356_bn) {
            return false;
        } else if (var6 == Material.field_1320_r) {
            return false;
        } else {
            return var5 == 1 ? true : super.func_260_c(var1, var2, var3, var4, var5);
        }
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public int func_210_f() {
        return 4;
    }

    public int func_240_a(int var1, Random var2) {
        return 0;
    }

    public int func_229_a(Random var1) {
        return 0;
    }

    private Vec3D func_291_e(IBlockAccess var1, int var2, int var3, int var4) {
        Vec3D var5 = Vec3D.func_1248_b(0.0D, 0.0D, 0.0D);
        int var6 = this.func_289_b(var1, var2, var3, var4);

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

            int var11 = this.func_289_b(var1, var8, var3, var10);
            int var12;
            if (var11 < 0) {
                if (!var1.func_599_f(var8, var3, var10).func_880_c()) {
                    var11 = this.func_289_b(var1, var8, var3 - 1, var10);
                    if (var11 >= 0) {
                        var12 = var11 - (var6 - 8);
                        var5 = var5.func_1257_c((double)((var8 - var2) * var12), (double)((var3 - var3) * var12), (double)((var10 - var4) * var12));
                    }
                }
            } else if (var11 >= 0) {
                var12 = var11 - var6;
                var5 = var5.func_1257_c((double)((var8 - var2) * var12), (double)((var3 - var3) * var12), (double)((var10 - var4) * var12));
            }
        }

        if (var1.func_602_e(var2, var3, var4) >= 8) {
            boolean var13 = false;
            if (var13 || this.func_28029_d(var1, var2, var3, var4 - 1, 2)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2, var3, var4 + 1, 3)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2 - 1, var3, var4, 4)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2 + 1, var3, var4, 5)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2, var3 + 1, var4 - 1, 2)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2, var3 + 1, var4 + 1, 3)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2 - 1, var3 + 1, var4, 4)) {
                var13 = true;
            }

            if (var13 || this.func_28029_d(var1, var2 + 1, var3 + 1, var4, 5)) {
                var13 = true;
            }

            if (var13) {
                var5 = var5.func_1252_b().func_1257_c(0.0D, -6.0D, 0.0D);
            }
        }

        var5 = var5.func_1252_b();
        return var5;
    }

    public void func_257_a(World var1, int var2, int var3, int var4, Entity var5, Vec3D var6) {
        Vec3D var7 = this.func_291_e(var1, var2, var3, var4);
        var6.field_1776_a += var7.field_1776_a;
        var6.field_1775_b += var7.field_1775_b;
        var6.field_1779_c += var7.field_1779_c;
    }

    public int func_4025_d() {
        if (this.field_356_bn == Material.field_1332_f) {
            return 5;
        } else {
            return this.field_356_bn == Material.field_1331_g ? 30 : 0;
        }
    }

    public float func_241_c(IBlockAccess var1, int var2, int var3, int var4) {
        float var5 = var1.func_598_c(var2, var3, var4);
        float var6 = var1.func_598_c(var2, var3 + 1, var4);
        return var5 > var6 ? var5 : var6;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        super.func_208_a(var1, var2, var3, var4, var5);
    }

    public int func_234_g() {
        return this.field_356_bn == Material.field_1332_f ? 1 : 0;
    }

    public void func_247_b(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_356_bn == Material.field_1332_f && var5.nextInt(64) == 0) {
            int var6 = var1.func_602_e(var2, var3, var4);
            if (var6 > 0 && var6 < 8) {
                var1.func_684_a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "liquid.water", var5.nextFloat() * 0.25F + 0.75F, var5.nextFloat() * 1.0F + 0.5F);
            }
        }

        if (this.field_356_bn == Material.field_1331_g && var1.func_599_f(var2, var3 + 1, var4) == Material.field_1337_a && !var1.func_601_g(var2, var3 + 1, var4) && var5.nextInt(100) == 0) {
            double var12 = (double)((float)var2 + var5.nextFloat());
            double var8 = (double)var3 + this.field_362_bj;
            double var10 = (double)((float)var4 + var5.nextFloat());
            var1.func_694_a("lava", var12, var8, var10, 0.0D, 0.0D, 0.0D);
        }

    }

    public static double func_293_a(IBlockAccess var0, int var1, int var2, int var3, Material var4) {
        Vec3D var5 = null;
        if (var4 == Material.field_1332_f) {
            var5 = ((BlockFluid)Block.field_401_B).func_291_e(var0, var1, var2, var3);
        }

        if (var4 == Material.field_1331_g) {
            var5 = ((BlockFluid)Block.field_397_D).func_291_e(var0, var1, var2, var3);
        }

        return var5.field_1776_a == 0.0D && var5.field_1779_c == 0.0D ? -1000.0D : Math.atan2(var5.field_1779_c, var5.field_1776_a) - 1.5707963267948966D;
    }

    public void func_235_e(World var1, int var2, int var3, int var4) {
        this.func_287_j(var1, var2, var3, var4);
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        this.func_287_j(var1, var2, var3, var4);
    }

    private void func_287_j(World var1, int var2, int var3, int var4) {
        if (var1.func_600_a(var2, var3, var4) == this.field_376_bc) {
            if (this.field_356_bn == Material.field_1331_g) {
                boolean var5 = false;
                if (var5 || var1.func_599_f(var2, var3, var4 - 1) == Material.field_1332_f) {
                    var5 = true;
                }

                if (var5 || var1.func_599_f(var2, var3, var4 + 1) == Material.field_1332_f) {
                    var5 = true;
                }

                if (var5 || var1.func_599_f(var2 - 1, var3, var4) == Material.field_1332_f) {
                    var5 = true;
                }

                if (var5 || var1.func_599_f(var2 + 1, var3, var4) == Material.field_1332_f) {
                    var5 = true;
                }

                if (var5 || var1.func_599_f(var2, var3 + 1, var4) == Material.field_1332_f) {
                    var5 = true;
                }

                if (var5) {
                    int var6 = var1.func_602_e(var2, var3, var4);
                    if (var6 == 0) {
                        var1.func_690_d(var2, var3, var4, Block.field_405_aq.field_376_bc);
                    } else if (var6 <= 4) {
                        var1.func_690_d(var2, var3, var4, Block.field_335_x.field_376_bc);
                    }

                    this.func_292_i(var1, var2, var3, var4);
                }
            }

        }
    }

    protected void func_292_i(World var1, int var2, int var3, int var4) {
        var1.func_684_a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.field_1037_n.nextFloat() - var1.field_1037_n.nextFloat()) * 0.8F);

        for(int var5 = 0; var5 < 8; ++var5) {
            var1.func_694_a("largesmoke", (double)var2 + Math.random(), (double)var3 + 1.2D, (double)var4 + Math.random(), 0.0D, 0.0D, 0.0D);
        }

    }
}
