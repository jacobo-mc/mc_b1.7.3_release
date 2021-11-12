package net.minecraft.src;

import java.util.List;

final class J_JsonElementNodeSelector extends J_LeafFunctor {
    // $FF: synthetic field
    final int field_27069_a;

    J_JsonElementNodeSelector(int var1) {
        this.field_27069_a = var1;
    }

    public boolean func_27067_a(List var1) {
        return var1.size() > this.field_27069_a;
    }

    public String func_27060_a() {
        return Integer.toString(this.field_27069_a);
    }

    public J_JsonNode func_27068_b(List var1) {
        return (J_JsonNode)var1.get(this.field_27069_a);
    }

    public String toString() {
        return "an element at index [" + this.field_27069_a + "]";
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object func_27063_c(Object var1) {
        return this.func_27068_b((List)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean func_27058_a(Object var1) {
        return this.func_27067_a((List)var1);
    }
}
