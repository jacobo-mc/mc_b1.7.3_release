package net.minecraft.src;

public enum EnumToolMaterial {
    WOOD(0, 59, 2.0F, 0),
    STONE(1, 131, 4.0F, 1),
    IRON(2, 250, 6.0F, 2),
    EMERALD(3, 1561, 8.0F, 3),
    GOLD(0, 32, 12.0F, 0);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;

    private EnumToolMaterial(int var3, int var4, float var5, int var6) {
        this.harvestLevel = var3;
        this.maxUses = var4;
        this.efficiencyOnProperMaterial = var5;
        this.damageVsEntity = var6;
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiencyOnProperMaterial() {
        return this.efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity() {
        return this.damageVsEntity;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }
}
