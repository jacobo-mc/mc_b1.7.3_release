package net.minecraft.src;

import java.util.Random;

public class WorldGenDeadBush extends WorldGenerator {
    private int field_28055_a;

    public WorldGenDeadBush(int var1) {
        this.field_28055_a = var1;
    }

    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        int var11;
        for(boolean var6 = false; ((var11 = var1.func_444_a(var3, var4, var5)) == 0 || var11 == Block.field_581_L.field_573_bc) && var4 > 0; --var4) {
        }

        for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);
            if (var1.func_20111_e(var8, var9, var10) && ((BlockFlower)Block.field_542_n[this.field_28055_a]).func_220_f(var1, var8, var9, var10)) {
                var1.func_462_a(var8, var9, var10, this.field_28055_a);
            }
        }

        return true;
    }
}
