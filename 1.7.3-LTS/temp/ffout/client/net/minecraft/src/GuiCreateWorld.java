package net.minecraft.src;

import java.util.Random;
import org.lwjgl.input.Keyboard;

public class GuiCreateWorld extends GuiScreen {
    private GuiScreen field_22131_a;
    private GuiTextField field_22134_h;
    private GuiTextField field_22133_i;
    private String field_22132_k;
    private boolean field_22130_l;

    public GuiCreateWorld(GuiScreen var1) {
        this.field_22131_a = var1;
    }

    public void func_570_g() {
        this.field_22134_h.func_22070_b();
        this.field_22133_i.func_22070_b();
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        Keyboard.enableRepeatEvents(true);
        this.field_949_e.clear();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + 12, var1.func_20163_a("selectWorld.create")));
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
        this.field_22134_h = new GuiTextField(this, this.field_6451_g, this.field_951_c / 2 - 100, 60, 200, 20, var1.func_20163_a("selectWorld.newWorld"));
        this.field_22134_h.field_22082_a = true;
        this.field_22134_h.func_22066_a(32);
        this.field_22133_i = new GuiTextField(this, this.field_6451_g, this.field_951_c / 2 - 100, 116, 200, 20, "");
        this.func_22129_j();
    }

    private void func_22129_j() {
        this.field_22132_k = this.field_22134_h.func_22071_a().trim();
        char[] var1 = ChatAllowedCharacters.field_22286_b;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            char var4 = var1[var3];
            this.field_22132_k = this.field_22132_k.replace(var4, '_');
        }

        if (MathHelper.func_22282_a(this.field_22132_k)) {
            this.field_22132_k = "World";
        }

        this.field_22132_k = func_25097_a(this.field_945_b.func_22004_c(), this.field_22132_k);
    }

    public static String func_25097_a(ISaveFormat var0, String var1) {
        while(var0.func_22173_b(var1) != null) {
            var1 = var1 + "-";
        }

        return var1;
    }

    public void func_6449_h() {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 1) {
                this.field_945_b.func_6272_a(this.field_22131_a);
            } else if (var1.field_938_f == 0) {
                this.field_945_b.func_6272_a((GuiScreen)null);
                if (this.field_22130_l) {
                    return;
                }

                this.field_22130_l = true;
                long var2 = (new Random()).nextLong();
                String var4 = this.field_22133_i.func_22071_a();
                if (!MathHelper.func_22282_a(var4)) {
                    try {
                        long var5 = Long.parseLong(var4);
                        if (var5 != 0L) {
                            var2 = var5;
                        }
                    } catch (NumberFormatException var7) {
                        var2 = (long)var4.hashCode();
                    }
                }

                this.field_945_b.field_6327_b = new PlayerControllerSP(this.field_945_b);
                this.field_945_b.func_6247_b(this.field_22132_k, this.field_22134_h.func_22071_a(), var2);
                this.field_945_b.func_6272_a((GuiScreen)null);
            }

        }
    }

    protected void func_580_a(char var1, int var2) {
        if (this.field_22134_h.field_22082_a) {
            this.field_22134_h.func_22072_a(var1, var2);
        } else {
            this.field_22133_i.func_22072_a(var1, var2);
        }

        if (var1 == '\r') {
            this.func_572_a((GuiButton)this.field_949_e.get(0));
        }

        ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_22134_h.func_22071_a().length() > 0;
        this.func_22129_j();
    }

    protected void func_565_a(int var1, int var2, int var3) {
        super.func_565_a(var1, var2, var3);
        this.field_22134_h.func_22069_a(var1, var2, var3);
        this.field_22133_i.func_22069_a(var1, var2, var3);
    }

    public void func_571_a(int var1, int var2, float var3) {
        StringTranslate var4 = StringTranslate.func_20162_a();
        this.func_578_i();
        this.func_548_a(this.field_6451_g, var4.func_20163_a("selectWorld.create"), this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.enterName"), this.field_951_c / 2 - 100, 47, 10526880);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.resultFolder") + " " + this.field_22132_k, this.field_951_c / 2 - 100, 85, 10526880);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.enterSeed"), this.field_951_c / 2 - 100, 104, 10526880);
        this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.seedInfo"), this.field_951_c / 2 - 100, 140, 10526880);
        this.field_22134_h.func_22067_c();
        this.field_22133_i.func_22067_c();
        super.func_571_a(var1, var2, var3);
    }

    public void func_27108_j() {
        if (this.field_22134_h.field_22082_a) {
            this.field_22134_h.func_27106_a(false);
            this.field_22133_i.func_27106_a(true);
        } else {
            this.field_22134_h.func_27106_a(true);
            this.field_22133_i.func_27106_a(false);
        }

    }
}
