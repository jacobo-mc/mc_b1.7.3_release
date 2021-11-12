package net.minecraft.src;

public class BiomeGenSky extends BiomeGenBase {
    public BiomeGenSky() {
        this.field_25066_r.clear();
        this.field_25065_s.clear();
        this.field_25064_t.clear();
        this.field_25065_s.add(new SpawnListEntry(EntityChicken.class, 10));
    }

    public int func_4126_a(float var1) {
        return 12632319;
    }
}
