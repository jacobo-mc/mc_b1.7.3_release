package net.minecraft.src;

import java.util.Random;

public class WorldGenFire extends WorldGenerator {
    public boolean func_516_a(World var1, Random var2, int var3, int var4, int var5) {
        for(int var6 = 0; var6 < 64; ++var6) {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
            if (var1.func_20084_d(var7, var8, var9) && var1.func_600_a(var7, var8 - 1, var9) == Block.field_4053_bc.field_376_bc) {
                var1.func_690_d(var7, var8, var9, Block.field_402_as.field_376_bc);
            }
        }

        return true;
    }
}
