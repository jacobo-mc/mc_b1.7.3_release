package net.minecraft.src;

public class BiomeGenHell extends BiomeGenBase {
    public BiomeGenHell() {
        this.field_25058_r.clear();
        this.field_25057_s.clear();
        this.field_25056_t.clear();
        this.field_25058_r.add(new SpawnListEntry(EntityGhast.class, 10));
        this.field_25058_r.add(new SpawnListEntry(EntityPigZombie.class, 10));
    }
}
