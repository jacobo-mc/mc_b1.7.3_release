package net.minecraft.src;

public class SpawnListEntry {
    public Class entityClass;
    public int spawnRarityRate;

    public SpawnListEntry(Class var1, int var2) {
        this.entityClass = var1;
        this.spawnRarityRate = var2;
    }
}
