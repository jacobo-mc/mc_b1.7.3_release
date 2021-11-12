package net.minecraft.src;

import java.util.Random;

public class BlockStationary extends BlockFluid {
    protected BlockStationary(int var1, Material var2) {
        super(var1, var2);
        this.func_253_b(false);
        if (var2 == Material.field_1331_g) {
            this.func_253_b(true);
        }

    }

    public void func_226_a(World var1, int var2, int var3, int var4, int var5) {
        super.func_226_a(var1, var2, var3, var4, var5);
        if (var1.func_600_a(var2, var3, var4) == this.field_376_bc) {
            this.func_30004_j(var1, var2, var3, var4);
        }

    }

    private void func_30004_j(World var1, int var2, int var3, int var4) {
        int var5 = var1.func_602_e(var2, var3, var4);
        var1.field_1043_h = true;
        var1.func_643_a(var2, var3, var4, this.field_376_bc - 1, var5);
        var1.func_701_b(var2, var3, var4, var2, var3, var4);
        var1.func_22136_c(var2, var3, var4, this.field_376_bc - 1, this.func_4025_d());
        var1.field_1043_h = false;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (this.field_356_bn == Material.field_1331_g) {
            int var6 = var5.nextInt(3);

            for(int var7 = 0; var7 < var6; ++var7) {
                var2 += var5.nextInt(3) - 1;
                ++var3;
                var4 += var5.nextInt(3) - 1;
                int var8 = var1.func_600_a(var2, var3, var4);
                if (var8 == 0) {
                    if (this.func_301_k(var1, var2 - 1, var3, var4) || this.func_301_k(var1, var2 + 1, var3, var4) || this.func_301_k(var1, var2, var3, var4 - 1) || this.func_301_k(var1, var2, var3, var4 + 1) || this.func_301_k(var1, var2, var3 - 1, var4) || this.func_301_k(var1, var2, var3 + 1, var4)) {
                        var1.func_690_d(var2, var3, var4, Block.field_402_as.field_376_bc);
                        return;
                    }
                } else if (Block.field_345_n[var8].field_356_bn.func_880_c()) {
                    return;
                }
            }
        }

    }

    private boolean func_301_k(World var1, int var2, int var3, int var4) {
        return var1.func_599_f(var2, var3, var4).func_876_e();
    }
}
