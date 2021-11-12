package net.minecraft.src;

class J_ObjectNodeContainer implements J_NodeContainer {
    // $FF: synthetic field
    final J_JsonObjectNodeBuilder nodeBuilder;
    // $FF: synthetic field
    final J_JsonListenerToJdomAdapter listenerToJdomAdapter;

    J_ObjectNodeContainer(J_JsonListenerToJdomAdapter var1, J_JsonObjectNodeBuilder var2) {
        this.listenerToJdomAdapter = var1;
        this.nodeBuilder = var2;
    }

    public void addNode(J_JsonNodeBuilder var1) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
    }

    public void addField(J_JsonFieldBuilder var1) {
        this.nodeBuilder.withFieldBuilder(var1);
    }
}
