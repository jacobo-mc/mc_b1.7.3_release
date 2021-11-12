package net.minecraft.src;

public class BiomeGenHell extends BiomeGenBase {
    public BiomeGenHell() {
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 10));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 10));
    }
}
