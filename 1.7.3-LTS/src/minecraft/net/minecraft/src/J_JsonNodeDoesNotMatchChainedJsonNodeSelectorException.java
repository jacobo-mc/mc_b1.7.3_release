package net.minecraft.src;

import java.util.LinkedList;
import java.util.List;

public final class J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException extends J_JsonNodeDoesNotMatchJsonNodeSelectorException {
    final J_Functor failedNode;
    final List failPath;

    static J_JsonNodeDoesNotMatchJsonNodeSelectorException func_27322_a(J_Functor var0) {
        return new J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(var0, new LinkedList());
    }

    static J_JsonNodeDoesNotMatchJsonNodeSelectorException func_27323_a(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var0, J_JsonNodeSelector var1) {
        LinkedList var2 = new LinkedList(var0.failPath);
        var2.add(var1);
        return new J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(var0.failedNode, var2);
    }

    static J_JsonNodeDoesNotMatchJsonNodeSelectorException func_27321_b(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var0, J_JsonNodeSelector var1) {
        LinkedList var2 = new LinkedList();
        var2.add(var1);
        return new J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(var0.failedNode, var2);
    }

    private J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(J_Functor var1, List var2) {
        super("Failed to match any JSON node at [" + getShortFormFailPath(var2) + "]");
        this.failedNode = var1;
        this.failPath = var2;
    }

    static String getShortFormFailPath(List var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = var0.size() - 1; var2 >= 0; --var2) {
            var1.append(((J_JsonNodeSelector)var0.get(var2)).shortForm());
            if (var2 != 0) {
                var1.append(".");
            }
        }

        return var1.toString();
    }

    public String toString() {
        return "JsonNodeDoesNotMatchJsonNodeSelectorException{failedNode=" + this.failedNode + ", failPath=" + this.failPath + '}';
    }
}
