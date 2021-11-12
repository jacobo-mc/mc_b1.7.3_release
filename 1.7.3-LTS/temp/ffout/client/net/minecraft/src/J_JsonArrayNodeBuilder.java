package net.minecraft.src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class J_JsonArrayNodeBuilder implements J_JsonNodeBuilder {
    private final List field_27242_a = new LinkedList();

    J_JsonArrayNodeBuilder() {
    }

    public J_JsonArrayNodeBuilder func_27240_a(J_JsonNodeBuilder var1) {
        this.field_27242_a.add(var1);
        return this;
    }

    public J_JsonRootNode func_27241_a() {
        LinkedList var1 = new LinkedList();
        Iterator var2 = this.field_27242_a.iterator();

        while(var2.hasNext()) {
            J_JsonNodeBuilder var3 = (J_JsonNodeBuilder)var2.next();
            var1.add(var3.func_27234_b());
        }

        return J_JsonNodeFactories.func_27309_a(var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public J_JsonNode func_27234_b() {
        return this.func_27241_a();
    }
}
