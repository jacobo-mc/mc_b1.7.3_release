package net.minecraft.src;

public enum EnumCreatureType {
    monster(IMob.class, 70, Material.field_1337_a, false),
    creature(EntityAnimal.class, 15, Material.field_1337_a, true),
    waterCreature(EntityWaterMob.class, 5, Material.field_1332_f, true);

    private final Class field_4278_c;
    private final int field_4277_d;
    private final Material field_21173_f;
    private final boolean field_21172_g;

    private EnumCreatureType(Class var3, int var4, Material var5, boolean var6) {
        this.field_4278_c = var3;
        this.field_4277_d = var4;
        this.field_21173_f = var5;
        this.field_21172_g = var6;
    }

    public Class func_21170_a() {
        return this.field_4278_c;
    }

    public int func_21169_b() {
        return this.field_4277_d;
    }

    public Material func_21171_c() {
        return this.field_21173_f;
    }

    public boolean func_21168_d() {
        return this.field_21172_g;
    }
}
