package net.minecraft.src;

import java.util.Random;

public class BlockButton extends Block {
    protected BlockButton(int var1, int var2) {
        super(var1, var2, Material.field_1324_n);
        this.func_253_b(true);
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public int func_4025_d() {
        return 20;
    }

    public boolean func_217_b() {
        return false;
    }

    public boolean func_242_c() {
        return false;
    }

    public boolean func_28030_e(World var1, int var2, int var3, int var4, int var5) {
        if (var5 == 2 && var1.func_28100_h(var2, var3, var4 + 1)) {
            return true;
        } else if (var5 == 3 && var1.func_28100_h(var2, var3, var4 - 1)) {
            return true;
        } else if (var5 == 4 && var1.func_28100_h(var2 + 1, var3, var4)) {
            return true;
        } else {
            return var5 == 5 && var1.func_28100_h(var2 - 1, var3, var4);
        }
    }

    public boolean func_243_a(World var1, int var2, int var3, int var4) {
        if (var1.func_28100_h(var2 - 1, var3, var4)) {
            return true;
        } else if (var1.func_28100_h(var2 + 1, var3, var4)) {
            return true;
        } else if (var1.func_28100_h(var2, var3, var4 - 1)) {
            return true;
        } else {
            return var1.func_28100_h(var2, var3, var4 + 1);
        }
    }

    public void func_258_d(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        int var7 = var6 & 8;
        var6 &= 7;
        if (var5 == 2 && var1.func_28100_h(var2, var3, var4 + 1)) {
            var6 = 4;
        } else if (var5 == 3 && var1.func_28100_h(var2, var3, var4 - 1)) {
            var6 = 3;
        } else if (var5 == 4 && var1.func_28100_h(var2 + 1, var3, var4)) {
            var6 = 2;
        } else if (var5 == 5 && var1.func_28100_h(var2 - 1, var3, var4)) {
            var6 = 1;
        } else {
            var6 = this.func_22036_h(var1, var2, var3, var4);
        }

        var1.func_691_b(var2, var3, var4, var6 + var7);
    }

    private int func_22036_h(World var1, int var2, int var3, int var4) {
        if (var1.func_28100_h(var2 - 1, var3, var4)) {
            return 1;
        } else if (var1.func_28100_h(var2 + 1, var3, var4)) {
            return 2;
        } else if (var1.func_28100_h(var2, var3, var4 - 1)) {
            return 3;
        } else {
            return var1.func_28100_h(var2, var3, var4 + 1) ? 4 : 1;
        }
    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        if (this.func_305_h(var1, var2, var3, var4)) {
            int var6 = var1.func_602_e(var2, var3, var4) & 7;
            boolean var7 = false;
            if (!var1.func_28100_h(var2 - 1, var3, var4) && var6 == 1) {
                var7 = true;
            }

            if (!var1.func_28100_h(var2 + 1, var3, var4) && var6 == 2) {
                var7 = true;
            }

            if (!var1.func_28100_h(var2, var3, var4 - 1) && var6 == 3) {
                var7 = true;
            }

            if (!var1.func_28100_h(var2, var3, var4 + 1) && var6 == 4) {
                var7 = true;
            }

            if (var7) {
                this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
                var1.func_690_d(var2, var3, var4, 0);
            }
        }

    }

    private boolean func_305_h(World var1, int var2, int var3, int var4) {
        if (!this.func_243_a(var1, var2, var3, var4)) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
            return false;
        } else {
            return true;
        }
    }

    public void func_238_a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        int var6 = var5 & 7;
        boolean var7 = (var5 & 8) > 0;
        float var8 = 0.375F;
        float var9 = 0.625F;
        float var10 = 0.1875F;
        float var11 = 0.125F;
        if (var7) {
            var11 = 0.0625F;
        }

        if (var6 == 1) {
            this.func_213_a(0.0F, var8, 0.5F - var10, var11, var9, 0.5F + var10);
        } else if (var6 == 2) {
            this.func_213_a(1.0F - var11, var8, 0.5F - var10, 1.0F, var9, 0.5F + var10);
        } else if (var6 == 3) {
            this.func_213_a(0.5F - var10, var8, 0.0F, 0.5F + var10, var9, var11);
        } else if (var6 == 4) {
            this.func_213_a(0.5F - var10, var8, 1.0F - var11, 0.5F + var10, var9, 1.0F);
        }

    }

    public void func_233_b(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        this.func_250_a(var1, var2, var3, var4, var5);
    }

    public boolean func_250_a(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        int var7 = var6 & 7;
        int var8 = 8 - (var6 & 8);
        if (var8 == 0) {
            return true;
        } else {
            var1.func_691_b(var2, var3, var4, var7 + var8);
            var1.func_701_b(var2, var3, var4, var2, var3, var4);
            var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.click", 0.3F, 0.6F);
            var1.func_611_g(var2, var3, var4, this.field_376_bc);
            if (var7 == 1) {
                var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
            } else if (var7 == 2) {
                var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
            } else if (var7 == 3) {
                var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
            } else if (var7 == 4) {
                var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
            } else {
                var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            }

            var1.func_22136_c(var2, var3, var4, this.field_376_bc, this.func_4025_d());
            return true;
        }
    }

    public void func_214_b(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        if ((var5 & 8) > 0) {
            var1.func_611_g(var2, var3, var4, this.field_376_bc);
            int var6 = var5 & 7;
            if (var6 == 1) {
                var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
            } else if (var6 == 2) {
                var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
            } else if (var6 == 3) {
                var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
            } else if (var6 == 4) {
                var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
            } else {
                var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
            }
        }

        super.func_214_b(var1, var2, var3, var4);
    }

    public boolean func_231_b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return (var1.func_602_e(var2, var3, var4) & 8) > 0;
    }

    public boolean func_228_c(World var1, int var2, int var3, int var4, int var5) {
        int var6 = var1.func_602_e(var2, var3, var4);
        if ((var6 & 8) == 0) {
            return false;
        } else {
            int var7 = var6 & 7;
            if (var7 == 5 && var5 == 1) {
                return true;
            } else if (var7 == 4 && var5 == 2) {
                return true;
            } else if (var7 == 3 && var5 == 3) {
                return true;
            } else if (var7 == 2 && var5 == 4) {
                return true;
            } else {
                return var7 == 1 && var5 == 5;
            }
        }
    }

    public boolean func_209_d() {
        return true;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_1026_y) {
            int var6 = var1.func_602_e(var2, var3, var4);
            if ((var6 & 8) != 0) {
                var1.func_691_b(var2, var3, var4, var6 & 7);
                var1.func_611_g(var2, var3, var4, this.field_376_bc);
                int var7 = var6 & 7;
                if (var7 == 1) {
                    var1.func_611_g(var2 - 1, var3, var4, this.field_376_bc);
                } else if (var7 == 2) {
                    var1.func_611_g(var2 + 1, var3, var4, this.field_376_bc);
                } else if (var7 == 3) {
                    var1.func_611_g(var2, var3, var4 - 1, this.field_376_bc);
                } else if (var7 == 4) {
                    var1.func_611_g(var2, var3, var4 + 1, this.field_376_bc);
                } else {
                    var1.func_611_g(var2, var3 - 1, var4, this.field_376_bc);
                }

                var1.func_684_a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.click", 0.3F, 0.5F);
                var1.func_701_b(var2, var3, var4, var2, var3, var4);
            }
        }
    }

    public void func_237_e() {
        float var1 = 0.1875F;
        float var2 = 0.125F;
        float var3 = 0.125F;
        this.func_213_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
    }
}
