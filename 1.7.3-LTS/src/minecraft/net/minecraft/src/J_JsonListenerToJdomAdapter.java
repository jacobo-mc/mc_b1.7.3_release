package net.minecraft.src;

import java.util.Stack;

final class J_JsonListenerToJdomAdapter implements J_JsonListener {
    private final Stack stack = new Stack();
    private J_JsonNodeBuilder root;

    J_JsonRootNode getDocument() {
        return (J_JsonRootNode)this.root.buildNode();
    }

    public void startDocument() {
    }

    public void endDocument() {
    }

    public void startArray() {
        J_JsonArrayNodeBuilder var1 = J_JsonNodeBuilders.func_27249_e();
        this.addRootNode(var1);
        this.stack.push(new J_ArrayNodeContainer(this, var1));
    }

    public void endArray() {
        this.stack.pop();
    }

    public void startObject() {
        J_JsonObjectNodeBuilder var1 = J_JsonNodeBuilders.func_27253_d();
        this.addRootNode(var1);
        this.stack.push(new J_ObjectNodeContainer(this, var1));
    }

    public void endObject() {
        this.stack.pop();
    }

    public void startField(String var1) {
        J_JsonFieldBuilder var2 = J_JsonFieldBuilder.aJsonFieldBuilder().withKey(J_JsonNodeBuilders.func_27254_b(var1));
        ((J_NodeContainer)this.stack.peek()).addField(var2);
        this.stack.push(new J_FieldNodeContainer(this, var2));
    }

    public void endField() {
        this.stack.pop();
    }

    public void numberValue(String var1) {
        this.addValue(J_JsonNodeBuilders.func_27250_a(var1));
    }

    public void trueValue() {
        this.addValue(J_JsonNodeBuilders.func_27251_b());
    }

    public void stringValue(String var1) {
        this.addValue(J_JsonNodeBuilders.func_27254_b(var1));
    }

    public void falseValue() {
        this.addValue(J_JsonNodeBuilders.func_27252_c());
    }

    public void nullValue() {
        this.addValue(J_JsonNodeBuilders.func_27248_a());
    }

    private void addRootNode(J_JsonNodeBuilder var1) {
        if (this.root == null) {
            this.root = var1;
        } else {
            this.addValue(var1);
        }

    }

    private void addValue(J_JsonNodeBuilder var1) {
        ((J_NodeContainer)this.stack.peek()).addNode(var1);
    }
}
