package net.minecraft.src;

import java.util.Random;

public class WorldGenFlowers extends WorldGenerator {
    private int field_765_a;

    public WorldGenFlowers(int var1) {
        this.field_765_a = var1;
    }

    public boolean func_419_a(World var1, Random var2, int var3, int var4, int var5) {
        for(int var6 = 0; var6 < 64; ++var6) {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
            if (var1.func_20111_e(var7, var8, var9) && ((BlockFlower)Block.field_542_n[this.field_765_a]).func_220_f(var1, var7, var8, var9)) {
                var1.func_462_a(var7, var8, var9, this.field_765_a);
            }
        }

        return true;
    }
}
