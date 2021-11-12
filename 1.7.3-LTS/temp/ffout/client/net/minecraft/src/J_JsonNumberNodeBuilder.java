package net.minecraft.src;

final class J_JsonNumberNodeBuilder implements J_JsonNodeBuilder {
    private final J_JsonNode field_27239_a;

    J_JsonNumberNodeBuilder(String var1) {
        this.field_27239_a = J_JsonNodeFactories.func_27311_b(var1);
    }

    public J_JsonNode func_27234_b() {
        return this.field_27239_a;
    }
}
