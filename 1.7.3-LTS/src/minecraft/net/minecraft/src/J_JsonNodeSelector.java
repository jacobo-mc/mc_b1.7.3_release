package net.minecraft.src;

public final class J_JsonNodeSelector {
    final J_Functor valueGetter;

    J_JsonNodeSelector(J_Functor var1) {
        this.valueGetter = var1;
    }

    public boolean matchs(Object var1) {
        return this.valueGetter.matchsNode(var1);
    }

    public Object getValue(Object var1) {
        return this.valueGetter.applyTo(var1);
    }

    public J_JsonNodeSelector with(J_JsonNodeSelector var1) {
        return new J_JsonNodeSelector(new J_ChainedFunctor(this, var1));
    }

    String shortForm() {
        return this.valueGetter.shortForm();
    }

    public String toString() {
        return this.valueGetter.toString();
    }
}
