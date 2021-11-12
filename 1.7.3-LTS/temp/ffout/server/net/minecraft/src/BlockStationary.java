package net.minecraft.src;

import java.util.Random;

public class BlockStationary extends BlockFluid {
    protected BlockStationary(int var1, Material var2) {
        super(var1, var2);
        this.func_231_a(false);
        if (var2 == Material.field_520_g) {
            this.func_231_a(true);
        }

    }

    public void func_234_b(World var1, int var2, int var3, int var4, int var5) {
        super.func_234_b(var1, var2, var3, var4, var5);
        if (var1.func_444_a(var2, var3, var4) == this.field_573_bc) {
            this.func_30005_i(var1, var2, var3, var4);
        }

    }

    private void func_30005_i(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_446_b(var2, var3, var4);
        var1.field_808_h = true;
        var1.func_470_a(var2, var3, var4, this.field_573_bc - 1, var5);
        var1.func_519_b(var2, var3, var4, var2, var3, var4);
        var1.func_22074_c(var2, var3, var4, this.field_573_bc - 1, this.func_4028_b());
        var1.field_808_h = false;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_553_bn == Material.field_520_g) {
            int var6 = var5.nextInt(3);

            for(int var7 = 0; var7 < var6; ++var7) {
                var2 += var5.nextInt(3) - 1;
                ++var3;
                var4 += var5.nextInt(3) - 1;
                int var8 = var1.func_444_a(var2, var3, var4);
                if (var8 == 0) {
                    if (this.func_4033_j(var1, var2 - 1, var3, var4) || this.func_4033_j(var1, var2 + 1, var3, var4) || this.func_4033_j(var1, var2, var3, var4 - 1) || this.func_4033_j(var1, var2, var3, var4 + 1) || this.func_4033_j(var1, var2, var3 - 1, var4) || this.func_4033_j(var1, var2, var3 + 1, var4)) {
                        var1.func_508_d(var2, var3, var4, Block.field_599_as.field_573_bc);
                        return;
                    }
                } else if (Block.field_542_n[var8].field_553_bn.func_218_c()) {
                    return;
                }
            }
        }

    }

    private boolean func_4033_j(World var1, int var2, int var3, int var4) {
        return var1.func_443_c(var2, var3, var4).func_4051_e();
    }
}
