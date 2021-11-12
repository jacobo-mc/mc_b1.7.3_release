package net.minecraft.src;

import java.util.List;
import java.util.Map;

public abstract class J_JsonNode {
    J_JsonNode() {
    }

    public abstract EnumJsonNodeType getType();

    public abstract String getText();

    public abstract Map getFields();

    public abstract List getElements();

    public final String getStringValue(Object... var1) {
        return (String)this.wrapExceptionsFor(J_JsonNodeSelectors.func_27349_a(var1), this, var1);
    }

    public final List getArrayNode(Object... var1) {
        return (List)this.wrapExceptionsFor(J_JsonNodeSelectors.func_27346_b(var1), this, var1);
    }

    private Object wrapExceptionsFor(J_JsonNodeSelector var1, J_JsonNode var2, Object[] var3) {
        try {
            return var1.getValue(var2);
        } catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var5) {
            throw J_JsonNodeDoesNotMatchPathElementsException.jsonNodeDoesNotMatchPathElementsException(var5, var3, J_JsonNodeFactories.aJsonArray(var2));
        }
    }
}
