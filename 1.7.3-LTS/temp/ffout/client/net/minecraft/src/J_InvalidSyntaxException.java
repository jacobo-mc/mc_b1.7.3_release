package net.minecraft.src;

public final class J_InvalidSyntaxException extends Exception {
    private final int field_27191_a;
    private final int field_27190_b;

    J_InvalidSyntaxException(String var1, J_ThingWithPosition var2) {
        super("At line " + var2.func_27330_b() + ", column " + var2.func_27331_a() + ":  " + var1);
        this.field_27191_a = var2.func_27331_a();
        this.field_27190_b = var2.func_27330_b();
    }

    J_InvalidSyntaxException(String var1, Throwable var2, J_ThingWithPosition var3) {
        super("At line " + var3.func_27330_b() + ", column " + var3.func_27331_a() + ":  " + var1, var2);
        this.field_27191_a = var3.func_27331_a();
        this.field_27190_b = var3.func_27330_b();
    }
}
