package net.minecraft.src;

import java.util.Random;

public class BlockMushroom extends BlockFlower {
    protected BlockMushroom(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.2F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
        this.func_231_a(true);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var5.nextInt(100) == 0) {
            int var6 = var2 + var5.nextInt(3) - 1;
            int var7 = var3 + var5.nextInt(2) - var5.nextInt(2);
            int var8 = var4 + var5.nextInt(3) - 1;
            if (var1.func_20111_e(var6, var7, var8) && this.func_220_f(var1, var6, var7, var8)) {
                int var10000 = var2 + (var5.nextInt(3) - 1);
                var10000 = var4 + (var5.nextInt(3) - 1);
                if (var1.func_20111_e(var6, var7, var8) && this.func_220_f(var1, var6, var7, var8)) {
                    var1.func_508_d(var6, var7, var8, this.field_573_bc);
                }
            }
        }

    }

    protected boolean func_277_b(int var1) {
        return Block.field_540_p[var1];
    }

    public boolean func_220_f(World var1, int var2, int var3, int var4) {
        if (var3 >= 0 && var3 < 128) {
            return var1.func_28098_j(var2, var3, var4) < 13 && this.func_277_b(var1.func_444_a(var2, var3 - 1, var4));
        } else {
            return false;
        }
    }
}
