package net.minecraft.src;

import java.util.Random;

public class BlockSand extends Block {
    public static boolean field_650_a = false;

    public BlockSand(int var1, int var2) {
        super(var1, var2, Material.field_514_m);
    }

    public void func_250_e(World var1, int var2, int var3, int var4) {
        var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        var1.func_22074_c(var2, var3, var4, this.field_573_bc, this.func_4028_b());
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        this.func_284_h(var1, var2, var3, var4);
    }

    private void func_284_h(World var1, int var2, int var3, int var4) {
        if (func_285_g(var1, var2, var3 - 1, var4) && var3 >= 0) {
            byte var8 = 32;
            if (!field_650_a && var1.func_466_a(var2 - var8, var3 - var8, var4 - var8, var2 + var8, var3 + var8, var4 + var8)) {
                EntityFallingSand var9 = new EntityFallingSand(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), this.field_573_bc);
                var1.func_526_a(var9);
            } else {
                var1.func_508_d(var2, var3, var4, 0);

                while(func_285_g(var1, var2, var3 - 1, var4) && var3 > 0) {
                    --var3;
                }

                if (var3 > 0) {
                    var1.func_508_d(var2, var3, var4, this.field_573_bc);
                }
            }
        }

    }

    public int func_4028_b() {
        return 3;
    }

    public static boolean func_285_g(World var0, int var1, int var2, int var3) {
        int var4 = var0.func_444_a(var1, var2, var3);
        if (var4 == 0) {
            return true;
        } else if (var4 == Block.field_599_as.field_573_bc) {
            return true;
        } else {
            Material var5 = Block.field_542_n[var4].field_553_bn;
            if (var5 == Material.field_521_f) {
                return true;
            } else {
                return var5 == Material.field_520_g;
            }
        }
    }
}
