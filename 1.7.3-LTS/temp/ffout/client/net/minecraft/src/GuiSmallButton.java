package net.minecraft.src;

public class GuiSmallButton extends GuiButton {
    private final EnumOptions field_20079_i;

    public GuiSmallButton(int var1, int var2, int var3, String var4) {
        this(var1, var2, var3, (EnumOptions)null, var4);
    }

    public GuiSmallButton(int var1, int var2, int var3, int var4, int var5, String var6) {
        super(var1, var2, var3, var4, var5, var6);
        this.field_20079_i = null;
    }

    public GuiSmallButton(int var1, int var2, int var3, EnumOptions var4, String var5) {
        super(var1, var2, var3, 150, 20, var5);
        this.field_20079_i = var4;
    }

    public EnumOptions func_20078_a() {
        return this.field_20079_i;
    }
}
