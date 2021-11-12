package net.minecraft.src;

public enum EnumCreatureType {
    monster(IMob.class, 70, Material.field_526_a, false),
    creature(EntityAnimal.class, 15, Material.field_526_a, true),
    waterCreature(EntityWaterMob.class, 5, Material.field_521_f, true);

    private final Class field_21109_d;
    private final int field_21108_e;
    private final Material field_21107_f;
    private final boolean field_21106_g;

    private EnumCreatureType(Class var3, int var4, Material var5, boolean var6) {
        this.field_21109_d = var3;
        this.field_21108_e = var4;
        this.field_21107_f = var5;
        this.field_21106_g = var6;
    }

    public Class func_21105_a() {
        return this.field_21109_d;
    }

    public int func_21104_b() {
        return this.field_21108_e;
    }

    public Material func_21102_c() {
        return this.field_21107_f;
    }

    public boolean func_21103_d() {
        return this.field_21106_g;
    }
}
