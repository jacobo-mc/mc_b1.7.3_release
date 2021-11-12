package net.minecraft.src;

public class ColorizerWater {
    private static int[] waterBuffer = new int[65536];

    public static void setWaterBiomeColorizer(int[] var0) {
        waterBuffer = var0;
    }
}
