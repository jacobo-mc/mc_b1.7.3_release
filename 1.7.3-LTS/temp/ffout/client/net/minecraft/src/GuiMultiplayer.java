package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiMultiplayer extends GuiScreen {
    private GuiScreen field_968_a;
    private GuiTextField field_22111_h;

    public GuiMultiplayer(GuiScreen var1) {
        this.field_968_a = var1;
    }

    public void func_570_g() {
        this.field_22111_h.func_22070_b();
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        Keyboard.enableRepeatEvents(true);
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + 12, var1.func_20163_a("multiplayer.connect")));
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
        String var2 = this.field_945_b.field_6304_y.field_12259_z.replaceAll("_", ":");
        ((GuiButton)this.field_949_e.get(0)).field_937_g = var2.length() > 0;
        this.field_22111_h = new GuiTextField(this, this.field_6451_g, this.field_951_c / 2 - 100, this.field_950_d / 4 - 10 + 50 + 18, 200, 20, var2);
        this.field_22111_h.field_22082_a = true;
        this.field_22111_h.func_22066_a(128);
    }

    public void func_6449_h() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 1) {
                this.field_945_b.func_6272_a(this.field_968_a);
            } else if (var1.field_938_f == 0) {
                String var2 = this.field_22111_h.func_22071_a().trim();
                this.field_945_b.field_6304_y.field_12259_z = var2.replaceAll(":", "_");
                this.field_945_b.field_6304_y.func_1041_b();
                String[] var3 = var2.split(":");
                if (var2.startsWith("[")) {
                    int var4 = var2.indexOf("]");
                    if (var4 > 0) {
                        String var5 = var2.substring(1, var4);
                        String var6 = var2.substring(var4 + 1).trim();
                        if (var6.startsWith(":") && var6.length() > 0) {
                            var6 = var6.substring(1);
                            var3 = new String[]{var5, var6};
                        } else {
                            var3 = new String[]{var5};
                        }
                    }
                }

                if (var3.length > 2) {
                    var3 = new String[]{var2};
                }

                this.field_945_b.func_6272_a(new GuiConnecting(this.field_945_b, var3[0], var3.length > 1 ? this.func_4067_a(var3[1], 25565) : 25565));
            }

        }
    }

    private int func_4067_a(String var1, int var2) {
        try {
            return Integer.parseInt(var1.trim());
        } catch (Exception var4) {
            return var2;
        }
    }

    protected void func_580_a(char var1, int var2) {
        this.field_22111_h.func_22072_a(var1, var2);
        if (var1 == '\r') {
            this.func_572_a((GuiButton)this.field_949_e.get(0));
        }

        ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_22111_h.func_22071_a().length() > 0;
    }

    protected void func_565_a(int var1, int var2, int var3) {
        super.func_565_a(var1, var2, var3);
        this.field_22111_h.func_22069_a(var1, var2, var3);
    }

    public void func_571_a(int var1, int var2, float var3) {
        StringTranslate var4 = StringTranslate.func_20162_a();
        this.func_578_i();
        this.func_548_a(this.field_6451_g, var4.func_20163_a("multiplayer.title"), this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("multiplayer.info1"), this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 0, 10526880);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("multiplayer.info2"), this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 9, 10526880);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("multiplayer.ipinfo"), this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 36, 10526880);
        this.field_22111_h.func_22067_c();
        super.func_571_a(var1, var2, var3);
    }
}
