package net.minecraft.src;

import java.util.Random;

public class WorldGenFlowers extends WorldGenerator {
    private int plantBlockId;

    public WorldGenFlowers(int var1) {
        this.plantBlockId = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
        for(int var6 = 0; var6 < 64; ++var6) {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
            if (var1.isAirBlock(var7, var8, var9) && ((BlockFlower)Block.blocksList[this.plantBlockId]).canBlockStay(var1, var7, var8, var9)) {
                var1.setBlock(var7, var8, var9, this.plantBlockId);
            }
        }

        return true;
    }
}
