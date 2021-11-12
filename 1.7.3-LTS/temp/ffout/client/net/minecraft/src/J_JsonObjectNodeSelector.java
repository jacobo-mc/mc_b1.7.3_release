package net.minecraft.src;

import java.util.Map;

final class J_JsonObjectNodeSelector extends J_LeafFunctor {
    public boolean func_27070_a(J_JsonNode var1) {
        return EnumJsonNodeType.OBJECT == var1.func_27218_a();
    }

    public String func_27060_a() {
        return "A short form object";
    }

    public Map func_27071_b(J_JsonNode var1) {
        return var1.func_27214_c();
    }

    public String toString() {
        return "an object";
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object func_27063_c(Object var1) {
        return this.func_27071_b((J_JsonNode)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean func_27058_a(Object var1) {
        return this.func_27070_a((J_JsonNode)var1);
    }
}
