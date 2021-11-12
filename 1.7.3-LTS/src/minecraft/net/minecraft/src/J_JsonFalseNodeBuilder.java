package net.minecraft.src;

final class J_JsonFalseNodeBuilder implements J_JsonNodeBuilder {
    public J_JsonNode buildNode() {
        return J_JsonNodeFactories.aJsonFalse();
    }
}
