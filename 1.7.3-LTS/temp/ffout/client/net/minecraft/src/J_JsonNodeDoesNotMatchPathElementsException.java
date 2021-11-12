package net.minecraft.src;

public final class J_JsonNodeDoesNotMatchPathElementsException extends J_JsonNodeDoesNotMatchJsonNodeSelectorException {
    private static final J_JsonFormatter field_27320_a = new J_CompactJsonFormatter();

    static J_JsonNodeDoesNotMatchPathElementsException func_27319_a(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var0, Object[] var1, J_JsonRootNode var2) {
        return new J_JsonNodeDoesNotMatchPathElementsException(var0, var1, var2);
    }

    private J_JsonNodeDoesNotMatchPathElementsException(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var1, Object[] var2, J_JsonRootNode var3) {
        super(func_27318_b(var1, var2, var3));
    }

    private static String func_27318_b(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException var0, Object[] var1, J_JsonRootNode var2) {
        return "Failed to find " + var0.field_27326_a.toString() + " at [" + J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27324_a(var0.field_27325_b) + "] while resolving [" + func_27317_a(var1) + "] in " + field_27320_a.func_27327_a(var2) + ".";
    }

    private static String func_27317_a(Object[] var0) {
        StringBuilder var1 = new StringBuilder();
        boolean var2 = true;
        Object[] var3 = var0;
        int var4 = var0.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Object var6 = var3[var5];
            if (!var2) {
                var1.append(".");
            }

            var2 = false;
            if (var6 instanceof String) {
                var1.append("\"").append(var6).append("\"");
            } else {
                var1.append(var6);
            }
        }

        return var1.toString();
    }
}
