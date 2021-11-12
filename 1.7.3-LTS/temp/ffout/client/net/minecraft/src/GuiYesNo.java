package net.minecraft.src;

public class GuiYesNo extends GuiScreen {
    private GuiScreen field_961_a;
    private String field_964_h;
    private String field_963_i;
    private String field_22106_k;
    private String field_22105_l;
    private int field_962_j;

    public GuiYesNo(GuiScreen var1, String var2, String var3, String var4, String var5, int var6) {
        this.field_961_a = var1;
        this.field_964_h = var2;
        this.field_963_i = var3;
        this.field_22106_k = var4;
        this.field_22105_l = var5;
        this.field_962_j = var6;
    }

    public void func_6448_a() {
        this.field_949_e.add(new GuiSmallButton(0, this.field_951_c / 2 - 155 + 0, this.field_950_d / 6 + 96, this.field_22106_k));
        this.field_949_e.add(new GuiSmallButton(1, this.field_951_c / 2 - 155 + 160, this.field_950_d / 6 + 96, this.field_22105_l));
    }

    protected void func_572_a(GuiButton var1) {
        this.field_961_a.func_568_a(var1.field_938_f == 0, this.field_962_j);
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        this.func_548_a(this.field_6451_g, this.field_964_h, this.field_951_c / 2, 70, 16777215);
        this.func_548_a(this.field_6451_g, this.field_963_i, this.field_951_c / 2, 90, 16777215);
        super.func_571_a(var1, var2, var3);
    }
}
