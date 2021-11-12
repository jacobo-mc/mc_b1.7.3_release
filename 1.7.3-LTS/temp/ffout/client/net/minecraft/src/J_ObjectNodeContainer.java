package net.minecraft.src;

class J_ObjectNodeContainer implements J_NodeContainer {
    // $FF: synthetic field
    final J_JsonObjectNodeBuilder field_27296_a;
    // $FF: synthetic field
    final J_JsonListenerToJdomAdapter field_27295_b;

    J_ObjectNodeContainer(J_JsonListenerToJdomAdapter var1, J_JsonObjectNodeBuilder var2) {
        this.field_27295_b = var1;
        this.field_27296_a = var2;
    }

    public void func_27290_a(J_JsonNodeBuilder var1) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
    }

    public void func_27289_a(J_JsonFieldBuilder var1) {
        this.field_27296_a.func_27237_a(var1);
    }
}
