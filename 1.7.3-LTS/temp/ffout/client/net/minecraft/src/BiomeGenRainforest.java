package net.minecraft.src;

import java.util.Random;

public class BiomeGenRainforest extends BiomeGenBase {
    public WorldGenerator func_21107_a(Random var1) {
        return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }
}
