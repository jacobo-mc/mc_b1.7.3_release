package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class GuiConnecting extends GuiScreen {
    private NetClientHandler field_952_a;
    private boolean field_953_h = false;

    public GuiConnecting(Minecraft var1, String var2, int var3) {
        System.out.println("Connecting to " + var2 + ", " + var3);
        var1.func_6261_a((World)null);
        (new ThreadConnectToServer(this, var1, var2, var3)).start();
    }

    public void func_570_g() {
        if (this.field_952_a != null) {
            this.field_952_a.func_848_a();
        }

    }

    protected void func_580_a(char var1, int var2) {
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_938_f == 0) {
            this.field_953_h = true;
            if (this.field_952_a != null) {
                this.field_952_a.func_849_b();
            }

            this.field_945_b.func_6272_a(new GuiMainMenu());
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_578_i();
        StringTranslate var4 = StringTranslate.func_20162_a();
        if (this.field_952_a == null) {
            this.func_548_a(this.field_6451_g, var4.func_20163_a("connect.connecting"), this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
            this.func_548_a(this.field_6451_g, "", this.field_951_c / 2, this.field_950_d / 2 - 10, 16777215);
        } else {
            this.func_548_a(this.field_6451_g, var4.func_20163_a("connect.authorizing"), this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
            this.func_548_a(this.field_6451_g, this.field_952_a.field_1209_a, this.field_951_c / 2, this.field_950_d / 2 - 10, 16777215);
        }

        super.func_571_a(var1, var2, var3);
    }

    // $FF: synthetic method
    static NetClientHandler func_582_a(GuiConnecting var0, NetClientHandler var1) {
        return var0.field_952_a = var1;
    }

    // $FF: synthetic method
    static boolean func_581_a(GuiConnecting var0) {
        return var0.field_953_h;
    }

    // $FF: synthetic method
    static NetClientHandler func_583_b(GuiConnecting var0) {
        return var0.field_952_a;
    }
}
