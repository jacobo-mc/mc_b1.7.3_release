package net.minecraft.src;

public enum EnumSkyBlock {
    Sky(15),
    Block(0);

    public final int defaultLightValue;

    private EnumSkyBlock(int var3) {
        this.defaultLightValue = var3;
    }
}
