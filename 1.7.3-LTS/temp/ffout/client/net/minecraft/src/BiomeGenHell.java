package net.minecraft.src;

public class BiomeGenHell extends BiomeGenBase {
    public BiomeGenHell() {
        this.field_25066_r.clear();
        this.field_25065_s.clear();
        this.field_25064_t.clear();
        this.field_25066_r.add(new SpawnListEntry(EntityGhast.class, 10));
        this.field_25066_r.add(new SpawnListEntry(EntityPigZombie.class, 10));
    }
}
