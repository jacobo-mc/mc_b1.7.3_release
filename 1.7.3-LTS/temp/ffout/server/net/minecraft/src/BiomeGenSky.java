package net.minecraft.src;

public class BiomeGenSky extends BiomeGenBase {
    public BiomeGenSky() {
        this.field_25058_r.clear();
        this.field_25057_s.clear();
        this.field_25056_t.clear();
        this.field_25057_s.add(new SpawnListEntry(EntityChicken.class, 10));
    }
}
