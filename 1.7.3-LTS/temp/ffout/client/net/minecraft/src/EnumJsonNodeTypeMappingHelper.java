package net.minecraft.src;

// $FF: synthetic class
class EnumJsonNodeTypeMappingHelper {
    // $FF: synthetic field
    static final int[] field_27341_a = new int[EnumJsonNodeType.values().length];

    static {
        try {
            field_27341_a[EnumJsonNodeType.ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError var7) {
        }

        try {
            field_27341_a[EnumJsonNodeType.OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError var6) {
        }

        try {
            field_27341_a[EnumJsonNodeType.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError var5) {
        }

        try {
            field_27341_a[EnumJsonNodeType.NUMBER.ordinal()] = 4;
        } catch (NoSuchFieldError var4) {
        }

        try {
            field_27341_a[EnumJsonNodeType.FALSE.ordinal()] = 5;
        } catch (NoSuchFieldError var3) {
        }

        try {
            field_27341_a[EnumJsonNodeType.TRUE.ordinal()] = 6;
        } catch (NoSuchFieldError var2) {
        }

        try {
            field_27341_a[EnumJsonNodeType.NULL.ordinal()] = 7;
        } catch (NoSuchFieldError var1) {
        }

    }
}
