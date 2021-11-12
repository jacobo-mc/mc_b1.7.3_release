package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiChat extends GuiScreen {
    protected String field_985_a = "";
    private int field_986_h = 0;
    private static final String field_20082_i;

    public void func_6448_a() {
        Keyboard.enableRepeatEvents(true);
    }

    public void func_6449_h() {
        Keyboard.enableRepeatEvents(false);
    }

    public void func_570_g() {
        ++this.field_986_h;
    }

    protected void func_580_a(char var1, int var2) {
        if (var2 == 1) {
            this.field_945_b.func_6272_a((GuiScreen)null);
        } else if (var2 == 28) {
            String var3 = this.field_985_a.trim();
            if (var3.length() > 0) {
                String var4 = this.field_985_a.trim();
                if (!this.field_945_b.func_22003_b(var4)) {
                    this.field_945_b.field_6322_g.func_461_a(var4);
                }
            }

            this.field_945_b.func_6272_a((GuiScreen)null);
        } else {
            if (var2 == 14 && this.field_985_a.length() > 0) {
                this.field_985_a = this.field_985_a.substring(0, this.field_985_a.length() - 1);
            }

            if (field_20082_i.indexOf(var1) >= 0 && this.field_985_a.length() < 100) {
                this.field_985_a = this.field_985_a + var1;
            }

        }
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_551_a(2, this.field_950_d - 14, this.field_951_c - 2, this.field_950_d - 2, Integer.MIN_VALUE);
        this.func_547_b(this.field_6451_g, "> " + this.field_985_a + (this.field_986_h / 6 % 2 == 0 ? "_" : ""), 4, this.field_950_d - 12, 14737632);
        super.func_571_a(var1, var2, var3);
    }

    protected void func_565_a(int var1, int var2, int var3) {
        if (var3 == 0) {
            if (this.field_945_b.field_6308_u.field_933_a != null) {
                if (this.field_985_a.length() > 0 && !this.field_985_a.endsWith(" ")) {
                    this.field_985_a = this.field_985_a + " ";
                }

                this.field_985_a = this.field_985_a + this.field_945_b.field_6308_u.field_933_a;
                byte var4 = 100;
                if (this.field_985_a.length() > var4) {
                    this.field_985_a = this.field_985_a.substring(0, var4);
                }
            } else {
                super.func_565_a(var1, var2, var3);
            }
        }

    }

    static {
        field_20082_i = ChatAllowedCharacters.field_20157_a;
    }
}
