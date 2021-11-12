package net.minecraft.src;

// $FF: synthetic class
class EnumJsonNodeTypeMappingHelper {
    // $FF: synthetic field
    static final int[] enumJsonNodeTypeMappingArray = new int[EnumJsonNodeType.values().length];

    static {
        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError var7) {
        }

        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError var6) {
        }

        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError var5) {
        }

        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.NUMBER.ordinal()] = 4;
        } catch (NoSuchFieldError var4) {
        }

        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.FALSE.ordinal()] = 5;
        } catch (NoSuchFieldError var3) {
        }

        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.TRUE.ordinal()] = 6;
        } catch (NoSuchFieldError var2) {
        }

        try {
            enumJsonNodeTypeMappingArray[EnumJsonNodeType.NULL.ordinal()] = 7;
        } catch (NoSuchFieldError var1) {
        }

    }
}
