package net.minecraft.src;

public class GuiControls extends GuiScreen {
    private GuiScreen field_957_h;
    protected String field_954_a = "Controls";
    private GameSettings field_956_i;
    private int field_955_j = -1;

    public GuiControls(GuiScreen var1, GameSettings var2) {
        this.field_957_h = var1;
        this.field_956_i = var2;
    }

    private int func_20080_j() {
        return this.field_951_c / 2 - 155;
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        int var2 = this.func_20080_j();

        for(int var3 = 0; var3 < this.field_956_i.field_1564_t.length; ++var3) {
            this.field_949_e.add(new GuiSmallButton(var3, var2 + var3 % 2 * 160, this.field_950_d / 6 + 24 * (var3 >> 1), 70, 20, this.field_956_i.func_1047_d(var3)));
        }

        this.field_949_e.add(new GuiButton(200, this.field_951_c / 2 - 100, this.field_950_d / 6 + 168, var1.func_20163_a("gui.done")));
        this.field_954_a = var1.func_20163_a("controls.title");
    }

    protected void func_572_a(GuiButton var1) {
        for(int var2 = 0; var2 < this.field_956_i.field_1564_t.length; ++var2) {
            ((GuiButton)this.field_949_e.get(var2)).field_939_e = this.field_956_i.func_1047_d(var2);
        }

        if (var1.field_938_f == 200) {
            this.field_945_b.func_6272_a(this.field_957_h);
        } else {
            this.field_955_j = var1.field_938_f;
            var1.field_939_e = "> " + this.field_956_i.func_1047_d(var1.field_938_f) + " <";
        }

    }

    protected void func_580_a(char var1, int var2) {
        if (this.field_955_j >= 0) {
            this.field_956_i.func_1042_a(this.field_955_j, var2);
            ((GuiButton)this.field_949_e.get(this.field_955_j)).field_939_e = this.field_956_i.func_1047_d(this.field_955_j);
            this.field_955_j = -1;
        } else {
            super.func_580_a(var1, var2);
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        this.func_548_a(this.field_6451_g, this.field_954_a, this.field_951_c / 2, 20, 16777215);
        int var4 = this.func_20080_j();

        for(int var5 = 0; var5 < this.field_956_i.field_1564_t.length; ++var5) {
            this.func_547_b(this.field_6451_g, this.field_956_i.func_20102_a(var5), var4 + var5 % 2 * 160 + 70 + 6, this.field_950_d / 6 + 24 * (var5 >> 1) + 7, -1);
        }

        super.func_571_a(var1, var2, var3);
    }
}
