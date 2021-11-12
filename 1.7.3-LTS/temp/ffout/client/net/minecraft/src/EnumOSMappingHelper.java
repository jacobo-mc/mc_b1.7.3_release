package net.minecraft.src;

// $FF: synthetic class
public class EnumOSMappingHelper {
    // $FF: synthetic field
    public static final int[] field_1585_a = new int[EnumOS2.values().length];

    static {
        try {
            field_1585_a[EnumOS2.linux.ordinal()] = 1;
        } catch (NoSuchFieldError var4) {
        }

        try {
            field_1585_a[EnumOS2.solaris.ordinal()] = 2;
        } catch (NoSuchFieldError var3) {
        }

        try {
            field_1585_a[EnumOS2.windows.ordinal()] = 3;
        } catch (NoSuchFieldError var2) {
        }

        try {
            field_1585_a[EnumOS2.macos.ordinal()] = 4;
        } catch (NoSuchFieldError var1) {
        }

    }
}
