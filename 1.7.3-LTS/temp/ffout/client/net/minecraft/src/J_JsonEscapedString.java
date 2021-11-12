package net.minecraft.src;

final class J_JsonEscapedString {
    private final String field_27031_a;

    J_JsonEscapedString(String var1) {
        this.field_27031_a = var1.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public String toString() {
        return this.field_27031_a;
    }
}
