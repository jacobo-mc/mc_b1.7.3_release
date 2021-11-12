package net.minecraft.src;

public class GuiConflictWarning extends GuiScreen {
    private int field_965_a = 0;

    public void func_570_g() {
        ++this.field_965_a;
    }

    public void func_6448_a() {
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, "Back to title screen"));
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 0) {
                this.field_945_b.func_6272_a(new GuiMainMenu());
            }

        }
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        this.func_548_a(this.field_6451_g, "Level save conflict", this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
        this.func_547_b(this.field_6451_g, "Minecraft detected a conflict in the level save data.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 0, 10526880);
        this.func_547_b(this.field_6451_g, "This could be caused by two copies of the game", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 18, 10526880);
        this.func_547_b(this.field_6451_g, "accessing the same level.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 27, 10526880);
        this.func_547_b(this.field_6451_g, "To prevent level corruption, the current game has quit.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 45, 10526880);
        super.func_571_a(var1, var2, var3);
    }
}
