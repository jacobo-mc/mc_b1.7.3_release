package net.minecraft.src;

import java.util.Random;

public class BiomeGenForest extends BiomeGenBase {
    public BiomeGenForest() {
        this.field_25057_s.add(new SpawnListEntry(EntityWolf.class, 2));
    }

    public WorldGenerator func_21114_a(Random var1) {
        if (var1.nextInt(5) == 0) {
            return new WorldGenForest();
        } else {
            return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
        }
    }
}
