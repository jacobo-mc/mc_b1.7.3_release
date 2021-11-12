package net.minecraft.src;

import java.util.Random;

public class BlockSapling extends BlockFlower {
    protected BlockSapling(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.4F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_1026_y) {
            super.func_208_a(var1, var2, var3, var4, var5);
            if (var1.func_618_j(var2, var3 + 1, var4) >= 9 && var5.nextInt(30) == 0) {
                int var6 = var1.func_602_e(var2, var3, var4);
                if ((var6 & 8) == 0) {
                    var1.func_691_b(var2, var3, var4, var6 | 8);
                } else {
                    this.func_21028_c(var1, var2, var3, var4, var5);
                }
            }

        }
    }

    public int func_232_a(int var1, int var2) {
        var2 &= 3;
        if (var2 == 1) {
            return 63;
        } else {
            return var2 == 2 ? 79 : super.func_232_a(var1, var2);
        }
    }

    public void func_21028_c(World var1, int var2, int var3, int var4, Random var5) {
        int var6 = var1.func_602_e(var2, var3, var4) & 3;
        var1.func_634_a(var2, var3, var4, 0);
        Object var7 = null;
        if (var6 == 1) {
            var7 = new WorldGenTaiga2();
        } else if (var6 == 2) {
            var7 = new WorldGenForest();
        } else {
            var7 = new WorldGenTrees();
            if (var5.nextInt(10) == 0) {
                var7 = new WorldGenBigTree();
            }
        }

        if (!((WorldGenerator)var7).func_516_a(var1, var5, var2, var3, var4)) {
            var1.func_643_a(var2, var3, var4, this.field_376_bc, var6);
        }

    }

    protected int func_21025_b(int var1) {
        return var1 & 3;
    }
}
