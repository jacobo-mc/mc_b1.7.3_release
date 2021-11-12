package net.minecraft.src;

public class ColorizerFoliage {
    private static int[] field_6529_a = new int[65536];

    public static void func_28152_a(int[] var0) {
        field_6529_a = var0;
    }

    public static int func_4146_a(double var0, double var2) {
        var2 *= var0;
        int var4 = (int)((1.0D - var0) * 255.0D);
        int var5 = (int)((1.0D - var2) * 255.0D);
        return field_6529_a[var5 << 8 | var4];
    }

    public static int func_21175_a() {
        return 6396257;
    }

    public static int func_21174_b() {
        return 8431445;
    }

    public static int func_31073_c() {
        return 4764952;
    }
}
