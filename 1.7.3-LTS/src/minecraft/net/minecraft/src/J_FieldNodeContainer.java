package net.minecraft.src;

class J_FieldNodeContainer implements J_NodeContainer {
    // $FF: synthetic field
    final J_JsonFieldBuilder fieldBuilder;
    // $FF: synthetic field
    final J_JsonListenerToJdomAdapter listenerToJdomAdapter;

    J_FieldNodeContainer(J_JsonListenerToJdomAdapter var1, J_JsonFieldBuilder var2) {
        this.listenerToJdomAdapter = var1;
        this.fieldBuilder = var2;
    }

    public void addNode(J_JsonNodeBuilder var1) {
        this.fieldBuilder.withValue(var1);
    }

    public void addField(J_JsonFieldBuilder var1) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to a field.");
    }
}
