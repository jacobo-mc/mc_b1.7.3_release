package net.minecraft.src;

class J_ArrayNodeContainer implements J_NodeContainer {
    // $FF: synthetic field
    final J_JsonArrayNodeBuilder nodeBuilder;
    // $FF: synthetic field
    final J_JsonListenerToJdomAdapter listenerToJdomAdapter;

    J_ArrayNodeContainer(J_JsonListenerToJdomAdapter var1, J_JsonArrayNodeBuilder var2) {
        this.listenerToJdomAdapter = var1;
        this.nodeBuilder = var2;
    }

    public void addNode(J_JsonNodeBuilder var1) {
        this.nodeBuilder.addField(var1);
    }

    public void addField(J_JsonFieldBuilder var1) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to an array.");
    }
}
