package net.minecraft.src;

public class GuiConnectFailed extends GuiScreen {
    private String field_992_a;
    private String field_993_h;

    public GuiConnectFailed(String var1, String var2, Object... var3) {
        StringTranslate var4 = StringTranslate.func_20162_a();
        this.field_992_a = var4.func_20163_a(var1);
        if (var3 != null) {
            this.field_993_h = var4.func_20160_a(var2, var3);
        } else {
            this.field_993_h = var4.func_20163_a(var2);
        }

    }

    public void func_570_g() {
    }

    protected void func_580_a(char var1, int var2) {
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.toMenu")));
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 0) {
            this.field_945_b.func_6272_a(new GuiMainMenu());
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        this.func_548_a(this.field_6451_g, this.field_992_a, this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
        this.func_548_a(this.field_6451_g, this.field_993_h, this.field_951_c / 2, this.field_950_d / 2 - 10, 16777215);
        super.func_571_a(var1, var2, var3);
    }
}
