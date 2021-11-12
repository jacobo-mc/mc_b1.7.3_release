package net.minecraft.src;

final class J_JsonEscapedString {
    private final String escapedString;

    J_JsonEscapedString(String var1) {
        this.escapedString = var1.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public String toString() {
        return this.escapedString;
    }
}
