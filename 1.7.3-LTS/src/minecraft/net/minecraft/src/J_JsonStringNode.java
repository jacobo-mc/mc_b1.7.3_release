package net.minecraft.src;

import java.util.List;
import java.util.Map;

public final class J_JsonStringNode extends J_JsonNode implements Comparable {
    private final String value;

    J_JsonStringNode(String var1) {
        if (var1 == null) {
            throw new NullPointerException("Attempt to construct a JsonString with a null value.");
        } else {
            this.value = var1;
        }
    }

    public EnumJsonNodeType getType() {
        return EnumJsonNodeType.STRING;
    }

    public String getText() {
        return this.value;
    }

    public Map getFields() {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public List getElements() {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 != null && this.getClass() == var1.getClass()) {
            J_JsonStringNode var2 = (J_JsonStringNode)var1;
            return this.value.equals(var2.value);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "JsonStringNode value:[" + this.value + "]";
    }

    public int func_27223_a(J_JsonStringNode var1) {
        return this.value.compareTo(var1.value);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_27223_a((J_JsonStringNode)var1);
    }
}
