package net.minecraft.src;

import java.util.Random;

public class BlockGrass extends Block {
    protected BlockGrass(int var1) {
        super(var1, Material.field_28132_b);
        this.field_575_bb = 3;
        this.func_231_a(true);
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (!var1.field_792_x) {
            if (var1.func_495_h(var2, var3 + 1, var4) < 4 && Block.field_538_r[var1.func_444_a(var2, var3 + 1, var4)] > 2) {
                if (var5.nextInt(4) != 0) {
                    return;
                }

                var1.func_508_d(var2, var3, var4, Block.field_533_w.field_573_bc);
            } else if (var1.func_495_h(var2, var3 + 1, var4) >= 9) {
                int var6 = var2 + var5.nextInt(3) - 1;
                int var7 = var3 + var5.nextInt(5) - 3;
                int var8 = var4 + var5.nextInt(3) - 1;
                int var9 = var1.func_444_a(var6, var7 + 1, var8);
                if (var1.func_444_a(var6, var7, var8) == Block.field_533_w.field_573_bc && var1.func_495_h(var6, var7 + 1, var8) >= 4 && Block.field_538_r[var9] <= 2) {
                    var1.func_508_d(var6, var7, var8, Block.field_534_v.field_573_bc);
                }
            }

        }
    }

    public int func_252_a(int var1, Random var2) {
        return Block.field_533_w.func_252_a(0, var2);
    }
}
