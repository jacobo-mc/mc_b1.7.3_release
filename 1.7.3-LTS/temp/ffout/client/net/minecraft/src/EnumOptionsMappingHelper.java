package net.minecraft.src;

// $FF: synthetic class
class EnumOptionsMappingHelper {
    // $FF: synthetic field
    static final int[] field_20155_a = new int[EnumOptions.values().length];

    static {
        try {
            field_20155_a[EnumOptions.INVERT_MOUSE.ordinal()] = 1;
        } catch (NoSuchFieldError var5) {
        }

        try {
            field_20155_a[EnumOptions.VIEW_BOBBING.ordinal()] = 2;
        } catch (NoSuchFieldError var4) {
        }

        try {
            field_20155_a[EnumOptions.ANAGLYPH.ordinal()] = 3;
        } catch (NoSuchFieldError var3) {
        }

        try {
            field_20155_a[EnumOptions.ADVANCED_OPENGL.ordinal()] = 4;
        } catch (NoSuchFieldError var2) {
        }

        try {
            field_20155_a[EnumOptions.AMBIENT_OCCLUSION.ordinal()] = 5;
        } catch (NoSuchFieldError var1) {
        }

    }
}
