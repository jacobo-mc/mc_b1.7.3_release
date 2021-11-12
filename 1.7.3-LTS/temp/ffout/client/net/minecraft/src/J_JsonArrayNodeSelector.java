package net.minecraft.src;

import java.util.List;

final class J_JsonArrayNodeSelector extends J_LeafFunctor {
    public boolean func_27074_a(J_JsonNode var1) {
        return EnumJsonNodeType.ARRAY == var1.func_27218_a();
    }

    public String func_27060_a() {
        return "A short form array";
    }

    public List func_27075_b(J_JsonNode var1) {
        return var1.func_27215_d();
    }

    public String toString() {
        return "an array";
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object func_27063_c(Object var1) {
        return this.func_27075_b((J_JsonNode)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean func_27058_a(Object var1) {
        return this.func_27074_a((J_JsonNode)var1);
    }
}
