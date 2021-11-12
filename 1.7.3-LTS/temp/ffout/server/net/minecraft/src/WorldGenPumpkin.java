package net.minecraft.src;

import java.util.Random;

public class WorldGenPumpkin extends WorldGenerator {
    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        for(int var6 = 0; var6 < 64; ++var6) {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
            if (var1.func_20111_e(var7, var8, var9) && var1.func_444_a(var7, var8 - 1, var9) == Block.field_534_v.field_573_bc && Block.field_4052_bb.func_259_a(var1, var7, var8, var9)) {
                var1.func_470_a(var7, var8, var9, Block.field_4052_bb.field_573_bc, var2.nextInt(4));
            }
        }

        return true;
    }
}
