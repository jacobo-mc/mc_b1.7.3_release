package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiRenameWorld extends GuiScreen {
    private GuiScreen field_22112_a;
    private GuiTextField field_22114_h;
    private final String field_22113_i;

    public GuiRenameWorld(GuiScreen var1, String var2) {
        this.field_22112_a = var1;
        this.field_22113_i = var2;
    }

    public void func_570_g() {
        this.field_22114_h.func_22070_b();
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        Keyboard.enableRepeatEvents(true);
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + 12, var1.func_20163_a("selectWorld.renameButton")));
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
        ISaveFormat var2 = this.field_945_b.func_22004_c();
        WorldInfo var3 = var2.func_22173_b(this.field_22113_i);
        String var4 = var3.func_22302_j();
        this.field_22114_h = new GuiTextField(this, this.field_6451_g, this.field_951_c / 2 - 100, 60, 200, 20, var4);
        this.field_22114_h.field_22082_a = true;
        this.field_22114_h.func_22066_a(32);
    }

    public void func_6449_h() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 1) {
                this.field_945_b.func_6272_a(this.field_22112_a);
            } else if (var1.field_938_f == 0) {
                ISaveFormat var2 = this.field_945_b.func_22004_c();
                var2.func_22170_a(this.field_22113_i, this.field_22114_h.func_22071_a().trim());
                this.field_945_b.func_6272_a(this.field_22112_a);
            }

        }
    }

    protected void func_580_a(char var1, int var2) {
        this.field_22114_h.func_22072_a(var1, var2);
        ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_22114_h.func_22071_a().trim().length() > 0;
        if (var1 == '\r') {
            this.func_572_a((GuiButton)this.field_949_e.get(0));
        }

    }

    protected void func_565_a(int var1, int var2, int var3) {
        super.func_565_a(var1, var2, var3);
        this.field_22114_h.func_22069_a(var1, var2, var3);
    }

    public void func_571_a(int var1, int var2, float var3) {
        StringTranslate var4 = StringTranslate.func_20162_a();
        this.func_578_i();
        this.func_548_a(this.field_6451_g, var4.func_20163_a("selectWorld.renameTitle"), this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.enterName"), this.field_951_c / 2 - 100, 47, 10526880);
        this.field_22114_h.func_22067_c();
        super.func_571_a(var1, var2, var3);
    }
}
