package net.minecraft.src;

import java.util.Random;

public class WorldGenDeadBush extends WorldGenerator {
    private int field_28058_a;

    public WorldGenDeadBush(int var1) {
        this.field_28058_a = var1;
    }

    public boolean func_516_a(World var1, Random var2, int var3, int var4, int var5) {
        int var11;
        for(boolean var6 = false; ((var11 = var1.func_600_a(var3, var4, var5)) == 0 || var11 == Block.field_384_L.field_376_bc) && var4 > 0; --var4) {
        }

        for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);
            if (var1.func_20084_d(var8, var9, var10) && ((BlockFlower)Block.field_345_n[this.field_28058_a]).func_223_g(var1, var8, var9, var10)) {
                var1.func_634_a(var8, var9, var10, this.field_28058_a);
            }
        }

        return true;
    }
}
