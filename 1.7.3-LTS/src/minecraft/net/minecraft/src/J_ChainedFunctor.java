package net.minecraft.src;

final class J_ChainedFunctor implements J_Functor {
    private final J_JsonNodeSelector parentJsonNodeSelector;
    private final J_JsonNodeSelector childJsonNodeSelector;

    J_ChainedFunctor(J_JsonNodeSelector var1, J_JsonNodeSelector var2) {
        this.parentJsonNodeSelector = var1;
        this.childJsonNodeSelector = var2;
    }

    public boolean matchsNode(Object var1) {
        return this.parentJsonNodeSelector.matchs(var1) && this.childJsonNodeSelector.matchs(this.parentJsonNodeSelector.getValue(var1));
    }

    public Object applyTo(Object var1) {
        Object var2;
        try {
            var2 = this.parentJsonNodeSelector.getValue(var1);
        } catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var6) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27321_b(var6, this.parentJsonNodeSelector);
        }

        try {
            Object var3 = this.childJsonNodeSelector.getValue(var2);
            return var3;
        } catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var5) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27323_a(var5, this.parentJsonNodeSelector);
        }
    }

    public String shortForm() {
        return this.childJsonNodeSelector.shortForm();
    }

    public String toString() {
        return this.parentJsonNodeSelector.toString() + ", with " + this.childJsonNodeSelector.toString();
    }
}
