package net.minecraft.src;

public class GuiErrorScreen extends GuiScreen {
    private int field_28098_a = 0;

    public void func_570_g() {
        ++this.field_28098_a;
    }

    public void func_6448_a() {
    }

    protected void func_572_a(GuiButton var1) {
    }

    protected void func_580_a(char var1, int var2) {
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        this.func_548_a(this.field_6451_g, "Out of memory!", this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
        this.func_547_b(this.field_6451_g, "Minecraft has run out of memory.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 0, 10526880);
        this.func_547_b(this.field_6451_g, "This could be caused by a bug in the game or by the", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 18, 10526880);
        this.func_547_b(this.field_6451_g, "Java Virtual Machine not being allocated enough", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 27, 10526880);
        this.func_547_b(this.field_6451_g, "memory. If you are playing in a web browser, try", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 36, 10526880);
        this.func_547_b(this.field_6451_g, "downloading the game and playing it offline.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 45, 10526880);
        this.func_547_b(this.field_6451_g, "To prevent level corruption, the current game has quit.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 63, 10526880);
        this.func_547_b(this.field_6451_g, "Please restart the game.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 81, 10526880);
        super.func_571_a(var1, var2, var3);
    }
}
