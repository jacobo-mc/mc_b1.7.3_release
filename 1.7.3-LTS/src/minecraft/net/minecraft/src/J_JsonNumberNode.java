package net.minecraft.src;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class J_JsonNumberNode extends J_JsonNode {
    private static final Pattern PATTERN = Pattern.compile("(-?)(0|([1-9]([0-9]*)))(\\.[0-9]+)?((e|E)(\\+|-)?[0-9]+)?");
    private final String value;

    J_JsonNumberNode(String var1) {
        if (var1 == null) {
            throw new NullPointerException("Attempt to construct a JsonNumber with a null value.");
        } else if (!PATTERN.matcher(var1).matches()) {
            throw new IllegalArgumentException("Attempt to construct a JsonNumber with a String [" + var1 + "] that does not match the JSON number specification.");
        } else {
            this.value = var1;
        }
    }

    public EnumJsonNodeType getType() {
        return EnumJsonNodeType.NUMBER;
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
            J_JsonNumberNode var2 = (J_JsonNumberNode)var1;
            return this.value.equals(var2.value);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "JsonNumberNode value:[" + this.value + "]";
    }
}
