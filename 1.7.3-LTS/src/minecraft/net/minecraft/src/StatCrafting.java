package net.minecraft.src;

public class StatCrafting extends StatBase {
    private final int field_25073_a;

    public StatCrafting(int var1, String var2, int var3) {
        super(var1, var2);
        this.field_25073_a = var3;
    }

    public int getItemID() {
        return this.field_25073_a;
    }
}
