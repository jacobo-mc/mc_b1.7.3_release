package net.minecraft.src;

import java.util.Map;

final class J_JsonObjectNodeSelector extends J_LeafFunctor {
    public boolean func_27070_a(J_JsonNode var1) {
        return EnumJsonNodeType.OBJECT == var1.getType();
    }

    public String shortForm() {
        return "A short form object";
    }

    public Map func_27071_b(J_JsonNode var1) {
        return var1.getFields();
    }

    public String toString() {
        return "an object";
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object typeSafeApplyTo(Object var1) {
        return this.func_27071_b((J_JsonNode)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean matchsNode(Object var1) {
        return this.func_27070_a((J_JsonNode)var1);
    }
}
