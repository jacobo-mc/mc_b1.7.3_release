package net.minecraft.src;

public final class J_InvalidSyntaxException extends Exception {
    private final int column;
    private final int row;

    J_InvalidSyntaxException(String var1, J_ThingWithPosition var2) {
        super("At line " + var2.getRow() + ", column " + var2.getColumn() + ":  " + var1);
        this.column = var2.getColumn();
        this.row = var2.getRow();
    }

    J_InvalidSyntaxException(String var1, Throwable var2, J_ThingWithPosition var3) {
        super("At line " + var3.getRow() + ", column " + var3.getColumn() + ":  " + var1, var2);
        this.column = var3.getColumn();
        this.row = var3.getRow();
    }
}
