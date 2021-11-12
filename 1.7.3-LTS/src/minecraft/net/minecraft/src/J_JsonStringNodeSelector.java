package net.minecraft.src;

final class J_JsonStringNodeSelector extends J_LeafFunctor {
    public boolean func_27072_a(J_JsonNode var1) {
        return EnumJsonNodeType.STRING == var1.getType();
    }

    public String shortForm() {
        return "A short form string";
    }

    public String func_27073_b(J_JsonNode var1) {
        return var1.getText();
    }

    public String toString() {
        return "a value that is a string";
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object typeSafeApplyTo(Object var1) {
        return this.func_27073_b((J_JsonNode)var1);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public boolean matchsNode(Object var1) {
        return this.func_27072_a((J_JsonNode)var1);
    }
}
