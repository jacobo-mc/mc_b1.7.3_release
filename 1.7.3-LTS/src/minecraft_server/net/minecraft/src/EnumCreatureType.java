package net.minecraft.src;

public enum EnumCreatureType {
    monster(IMob.class, 70, Material.air, false),
    creature(EntityAnimal.class, 15, Material.air, true),
    waterCreature(EntityWaterMob.class, 5, Material.water, true);

    private final Class creatureClass;
    private final int maxNumberOfCreature;
    private final Material creatureMaterial;
    private final boolean field_21106_g;

    private EnumCreatureType(Class var3, int var4, Material var5, boolean var6) {
        this.creatureClass = var3;
        this.maxNumberOfCreature = var4;
        this.creatureMaterial = var5;
        this.field_21106_g = var6;
    }

    public Class getCreatureClass() {
        return this.creatureClass;
    }

    public int getMaxNumberOfCreature() {
        return this.maxNumberOfCreature;
    }

    public Material getCreatureMaterial() {
        return this.creatureMaterial;
    }

    public boolean func_21103_d() {
        return this.field_21106_g;
    }
}
