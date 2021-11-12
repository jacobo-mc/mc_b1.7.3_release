package net.minecraft.src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class J_JsonArrayNodeBuilder implements J_JsonNodeBuilder {
    private final List elementBuilders = new LinkedList();

    J_JsonArrayNodeBuilder() {
    }

    public J_JsonArrayNodeBuilder addField(J_JsonNodeBuilder var1) {
        this.elementBuilders.add(var1);
        return this;
    }

    public J_JsonRootNode build() {
        LinkedList var1 = new LinkedList();
        Iterator var2 = this.elementBuilders.iterator();

        while(var2.hasNext()) {
            J_JsonNodeBuilder var3 = (J_JsonNodeBuilder)var2.next();
            var1.add(var3.buildNode());
        }

        return J_JsonNodeFactories.aJsonArray(var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public J_JsonNode buildNode() {
        return this.build();
    }
}
