package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiGameOver extends GuiScreen {
    public void func_6448_a() {
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 72, "Respawn"));
        this.field_949_e.add(new GuiButton(2, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96, "Title menu"));
        if (this.field_945_b.field_6320_i == null) {
            ((GuiButton)this.field_949_e.get(1)).field_937_g = false;
        }

    }

    protected void func_580_a(char var1, int var2) {
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 0) {
        }

        if (var1.field_938_f == 1) {
            this.field_945_b.field_6322_g.func_9367_r();
            this.field_945_b.func_6272_a((GuiScreen)null);
        }

        if (var1.field_938_f == 2) {
            this.field_945_b.func_6261_a((World)null);
            this.field_945_b.func_6272_a(new GuiMainMenu());
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_549_a(0, 0, this.field_951_c, this.field_950_d, 1615855616, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        this.func_548_a(this.field_6451_g, "Game over!", this.field_951_c / 2 / 2, 30, 16777215);
        GL11.glPopMatrix();
        this.func_548_a(this.field_6451_g, "Score: &e" + this.field_945_b.field_6322_g.func_6417_t(), this.field_951_c / 2, 100, 16777215);
        super.func_571_a(var1, var2, var3);
    }

    public boolean func_6450_b() {
        return false;
    }
}
