package net.minecraft.src;

import java.util.Random;

public class BlockGrass extends Block {
    protected BlockGrass(int var1) {
        super(var1, Material.field_28130_b);
        this.field_378_bb = 3;
        this.func_253_b(true);
    }

    public int func_211_a(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        if (var5 == 1) {
            return 0;
        } else if (var5 == 0) {
            return 2;
        } else {
            Material var6 = var1.func_599_f(var2, var3 + 1, var4);
            return var6 != Material.field_1319_s && var6 != Material.field_1318_t ? 3 : 68;
        }
    }

    public int func_207_d(IBlockAccess var1, int var2, int var3, int var4) {
        var1.func_4075_a().func_4069_a(var2, var4, 1, 1);
        double var5 = var1.func_4075_a().field_4198_a[0];
        double var7 = var1.func_4075_a().field_4197_b[0];
        return ColorizerGrass.func_4147_a(var5, var7);
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_1026_y) {
            if (var1.func_618_j(var2, var3 + 1, var4) < 4 && Block.field_341_r[var1.func_600_a(var2, var3 + 1, var4)] > 2) {
                if (var5.nextInt(4) != 0) {
                    return;
                }

                var1.func_690_d(var2, var3, var4, Block.field_336_w.field_376_bc);
            } else if (var1.func_618_j(var2, var3 + 1, var4) >= 9) {
                int var6 = var2 + var5.nextInt(3) - 1;
                int var7 = var3 + var5.nextInt(5) - 3;
                int var8 = var4 + var5.nextInt(3) - 1;
                int var9 = var1.func_600_a(var6, var7 + 1, var8);
                if (var1.func_600_a(var6, var7, var8) == Block.field_336_w.field_376_bc && var1.func_618_j(var6, var7 + 1, var8) >= 4 && Block.field_341_r[var9] <= 2) {
                    var1.func_690_d(var6, var7, var8, Block.field_337_v.field_376_bc);
                }
            }

        }
    }

    public int func_240_a(int var1, Random var2) {
        return Block.field_336_w.func_240_a(0, var2);
    }
}
