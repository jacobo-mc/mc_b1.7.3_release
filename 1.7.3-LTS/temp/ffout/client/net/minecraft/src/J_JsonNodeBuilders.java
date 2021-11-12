package net.minecraft.src;

public final class J_JsonNodeBuilders {
    private J_JsonNodeBuilders() {
    }

    public static J_JsonNodeBuilder func_27248_a() {
        return new J_JsonNullNodeBuilder();
    }

    public static J_JsonNodeBuilder func_27251_b() {
        return new J_JsonTrueNodeBuilder();
    }

    public static J_JsonNodeBuilder func_27252_c() {
        return new J_JsonFalseNodeBuilder();
    }

    public static J_JsonNodeBuilder func_27250_a(String var0) {
        return new J_JsonNumberNodeBuilder(var0);
    }

    public static J_JsonStringNodeBuilder func_27254_b(String var0) {
        return new J_JsonStringNodeBuilder(var0);
    }

    public static J_JsonObjectNodeBuilder func_27253_d() {
        return new J_JsonObjectNodeBuilder();
    }

    public static J_JsonArrayNodeBuilder func_27249_e() {
        return new J_JsonArrayNodeBuilder();
    }
}
