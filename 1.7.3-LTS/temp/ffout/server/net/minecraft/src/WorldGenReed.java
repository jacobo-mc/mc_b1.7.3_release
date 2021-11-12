package net.minecraft.src;

import java.util.Random;

public class WorldGenReed extends WorldGenerator {
    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        for(int var6 = 0; var6 < 20; ++var6) {
            int var7 = var3 + var2.nextInt(4) - var2.nextInt(4);
            int var8 = var4;
            int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);
            if (var1.func_20111_e(var7, var4, var9) && (var1.func_443_c(var7 - 1, var4 - 1, var9) == Material.field_521_f || var1.func_443_c(var7 + 1, var4 - 1, var9) == Material.field_521_f || var1.func_443_c(var7, var4 - 1, var9 - 1) == Material.field_521_f || var1.func_443_c(var7, var4 - 1, var9 + 1) == Material.field_521_f)) {
                int var10 = 2 + var2.nextInt(var2.nextInt(3) + 1);

                for(int var11 = 0; var11 < var10; ++var11) {
                    if (Block.field_620_aY.func_220_f(var1, var7, var8 + var11, var9)) {
                        var1.func_462_a(var7, var8 + var11, var9, Block.field_620_aY.field_573_bc);
                    }
                }
            }
        }

        return true;
    }
}
