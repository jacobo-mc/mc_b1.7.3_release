package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class J_JsonArray extends J_JsonRootNode {
    private final List field_27221_a;

    J_JsonArray(Iterable var1) {
        this.field_27221_a = func_27220_a(var1);
    }

    public EnumJsonNodeType func_27218_a() {
        return EnumJsonNodeType.ARRAY;
    }

    public List func_27215_d() {
        return new ArrayList(this.field_27221_a);
    }

    public String func_27216_b() {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    public Map func_27214_c() {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && this.getClass() == var1.getClass()) {
            J_JsonArray var2 = (J_JsonArray)var1;
            return this.field_27221_a.equals(var2.field_27221_a);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.field_27221_a.hashCode();
    }

    public String toString() {
        return "JsonArray elements:[" + this.field_27221_a + "]";
    }

    private static List func_27220_a(Iterable var0) {
        return new J_JsonNodeList(var0);
    }
}
