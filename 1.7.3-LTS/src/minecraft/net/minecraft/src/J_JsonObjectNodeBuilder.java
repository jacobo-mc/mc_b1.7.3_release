package net.minecraft.src;

import java.util.LinkedList;
import java.util.List;

public final class J_JsonObjectNodeBuilder implements J_JsonNodeBuilder {
    private final List fieldBuilders = new LinkedList();

    J_JsonObjectNodeBuilder() {
    }

    public J_JsonObjectNodeBuilder withFieldBuilder(J_JsonFieldBuilder var1) {
        this.fieldBuilders.add(var1);
        return this;
    }

    public J_JsonRootNode func_27235_a() {
        return J_JsonNodeFactories.aJsonObject(new J_JsonObjectNodeList(this));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public J_JsonNode buildNode() {
        return this.func_27235_a();
    }

    // $FF: synthetic method
    static List func_27236_a(J_JsonObjectNodeBuilder var0) {
        return var0.fieldBuilders;
    }
}
