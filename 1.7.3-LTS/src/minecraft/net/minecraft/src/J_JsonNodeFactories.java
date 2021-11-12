package net.minecraft.src;

import java.util.Arrays;
import java.util.Map;

public final class J_JsonNodeFactories {
    private J_JsonNodeFactories() {
    }

    public static J_JsonNode aJsonNull() {
        return J_JsonConstants.NULL;
    }

    public static J_JsonNode aJsonTrue() {
        return J_JsonConstants.TRUE;
    }

    public static J_JsonNode aJsonFalse() {
        return J_JsonConstants.FALSE;
    }

    public static J_JsonStringNode aJsonString(String var0) {
        return new J_JsonStringNode(var0);
    }

    public static J_JsonNode aJsonNumber(String var0) {
        return new J_JsonNumberNode(var0);
    }

    public static J_JsonRootNode aJsonArray(Iterable var0) {
        return new J_JsonArray(var0);
    }

    public static J_JsonRootNode aJsonArray(J_JsonNode... var0) {
        return aJsonArray(Arrays.asList(var0));
    }

    public static J_JsonRootNode aJsonObject(Map var0) {
        return new J_JsonObject(var0);
    }
}
