package net.minecraft.src;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class J_JsonNumberNode extends J_JsonNode {
    private static final Pattern field_27226_a = Pattern.compile("(-?)(0|([1-9]([0-9]*)))(\\.[0-9]+)?((e|E)(\\+|-)?[0-9]+)?");
    private final String field_27225_b;

    J_JsonNumberNode(String var1) {
        if (var1 == null) {
            throw new NullPointerException("Attempt to construct a JsonNumber with a null value.");
        } else if (!field_27226_a.matcher(var1).matches()) {
            throw new IllegalArgumentException("Attempt to construct a JsonNumber with a String [" + var1 + "] that does not match the JSON number specification.");
        } else {
            this.field_27225_b = var1;
        }
    }

    public EnumJsonNodeType func_27218_a() {
        return EnumJsonNodeType.NUMBER;
    }

    public String func_27216_b() {
        return this.field_27225_b;
    }

    public Map func_27214_c() {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public List func_27215_d() {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && this.getClass() == var1.getClass()) {
            J_JsonNumberNode var2 = (J_JsonNumberNode)var1;
            return this.field_27225_b.equals(var2.field_27225_b);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.field_27225_b.hashCode();
    }

    public String toString() {
        return "JsonNumberNode value:[" + this.field_27225_b + "]";
    }
}
