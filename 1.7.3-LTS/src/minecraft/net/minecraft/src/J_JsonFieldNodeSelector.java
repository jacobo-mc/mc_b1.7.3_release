package net.minecraft.src;

import java.util.Map;

final class J_JsonFieldNodeSelector extends J_LeafFunctor {
    // $FF: synthetic field
    final J_JsonStringNode field_27066_a;

    J_JsonFieldNodeSelector(J_JsonStringNode var1) {
        this.field_27066_a = var1;
    }

    public boolean func_27065_a(Map var1) {
        return var1.containsKey(this.field_27066_a);
    }

    public String shortForm() {
        return "\"" + this.field_27066_a.getText() + "\"";
    }

    public J_JsonNode func_27064_b(Map var1) {
        return (J_JsonNode)var1.get(this.field_27066_a);
    }

    public String toString() {
        return "a field called [\"" + this.field_27066_a.getText() + "\"]";
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object typeSafeApplyTo(Object var1) {
        return this.func_27064_b((Map)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean matchsNode(Object var1) {
        return this.func_27065_a((Map)var1);
    }
}
