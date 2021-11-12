package net.minecraft.src;

public final class J_JsonStringNodeBuilder implements J_JsonNodeBuilder {
    private final String field_27244_a;

    J_JsonStringNodeBuilder(String var1) {
        this.field_27244_a = var1;
    }

    public J_JsonStringNode func_27243_a() {
        return J_JsonNodeFactories.aJsonString(this.field_27244_a);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public J_JsonNode buildNode() {
        return this.func_27243_a();
    }
}
