package net.minecraft.src;

final class J_ChainedFunctor implements J_Functor {
    private final J_JsonNodeSelector field_27062_a;
    private final J_JsonNodeSelector field_27061_b;

    J_ChainedFunctor(J_JsonNodeSelector var1, J_JsonNodeSelector var2) {
        this.field_27062_a = var1;
        this.field_27061_b = var2;
    }

    public boolean func_27058_a(Object var1) {
        return this.field_27062_a.func_27356_a(var1) && this.field_27061_b.func_27356_a(this.field_27062_a.func_27357_b(var1));
    }

    public Object func_27059_b(Object var1) {
        Object var2;
        try {
            var2 = this.field_27062_a.func_27357_b(var1);
        } catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var6) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27321_b(var6, this.field_27062_a);
        }

        try {
            Object var3 = this.field_27061_b.func_27357_b(var2);
            return var3;
        } catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var5) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27323_a(var5, this.field_27062_a);
        }
    }

    public String func_27060_a() {
        return this.field_27061_b.func_27358_a();
    }

    public String toString() {
        return this.field_27062_a.toString() + ", with " + this.field_27061_b.toString();
    }
}
