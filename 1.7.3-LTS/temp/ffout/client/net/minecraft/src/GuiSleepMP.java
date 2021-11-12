package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiSleepMP extends GuiChat {
    public void func_6448_a() {
        Keyboard.enableRepeatEvents(true);
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d - 40, var1.func_20163_a("multiplayer.stopSleeping")));
    }

    public void func_6449_h() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_580_a(char var1, int var2) {
        if (var2 == 1) {
            this.func_22115_j();
        } else if (var2 == 28) {
            String var3 = this.field_985_a.trim();
            if (var3.length() > 0) {
                this.field_945_b.field_6322_g.func_461_a(this.field_985_a.trim());
            }

            this.field_985_a = "";
        } else {
            super.func_580_a(var1, var2);
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        super.func_571_a(var1, var2, var3);
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 1) {
            this.func_22115_j();
        } else {
            super.func_572_a(var1);
        }

    }

    private void func_22115_j() {
        if (this.field_945_b.field_6322_g instanceof EntityClientPlayerMP) {
            NetClientHandler var1 = ((EntityClientPlayerMP)this.field_945_b.field_6322_g).field_797_bg;
            var1.func_847_a(new Packet19EntityAction(this.field_945_b.field_6322_g, 3));
        }

    }
}
