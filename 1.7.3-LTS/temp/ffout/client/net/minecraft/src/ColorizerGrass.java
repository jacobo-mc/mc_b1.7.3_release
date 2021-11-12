package net.minecraft.src;

public class ColorizerGrass {
    private static int[] field_6540_a = new int[65536];

    public static void func_28181_a(int[] var0) {
        field_6540_a = var0;
    }

    public static int func_4147_a(double var0, double var2) {
        var2 *= var0;
        int var4 = (int)((1.0D - var0) * 255.0D);
        int var5 = (int)((1.0D - var2) * 255.0D);
        return field_6540_a[var5 << 8 | var4];
    }
}
