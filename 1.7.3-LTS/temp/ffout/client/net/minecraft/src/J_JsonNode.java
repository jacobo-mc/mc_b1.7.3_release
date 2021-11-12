package net.minecraft.src;

import java.util.List;
import java.util.Map;

public abstract class J_JsonNode {
    J_JsonNode() {
    }

    public abstract EnumJsonNodeType func_27218_a();

    public abstract String func_27216_b();

    public abstract Map func_27214_c();

    public abstract List func_27215_d();

    public final String func_27213_a(Object... var1) {
        return (String)this.func_27219_a(J_JsonNodeSelectors.func_27349_a(var1), this, var1);
    }

    public final List func_27217_b(Object... var1) {
        return (List)this.func_27219_a(J_JsonNodeSelectors.func_27346_b(var1), this, var1);
    }

    private Object func_27219_a(J_JsonNodeSelector var1, J_JsonNode var2, Object[] var3) {
        try {
            return var1.func_27357_b(var2);
        } catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var5) {
            throw J_JsonNodeDoesNotMatchPathElementsException.func_27319_a(var5, var3, J_JsonNodeFactories.func_27315_a(var2));
        }
    }
}
