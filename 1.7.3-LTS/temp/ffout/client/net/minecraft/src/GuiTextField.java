package net.minecraft.src;

public class GuiTextField extends Gui {
    private final FontRenderer field_22080_c;
    private final int field_22079_d;
    private final int field_22078_e;
    private final int field_22077_f;
    private final int field_22076_g;
    private String field_22075_h;
    private int field_22074_i;
    private int field_22073_k;
    public boolean field_22082_a = false;
    public boolean field_22081_b = true;
    private GuiScreen field_27107_l;

    public GuiTextField(GuiScreen var1, FontRenderer var2, int var3, int var4, int var5, int var6, String var7) {
        this.field_27107_l = var1;
        this.field_22080_c = var2;
        this.field_22079_d = var3;
        this.field_22078_e = var4;
        this.field_22077_f = var5;
        this.field_22076_g = var6;
        this.func_22068_a(var7);
    }

    public void func_22068_a(String var1) {
        this.field_22075_h = var1;
    }

    public String func_22071_a() {
        return this.field_22075_h;
    }

    public void func_22070_b() {
        ++this.field_22073_k;
    }

    public void func_22072_a(char var1, int var2) {
        if (this.field_22081_b && this.field_22082_a) {
            if (var1 == '\t') {
                this.field_27107_l.func_27108_j();
            }

            if (var1 == 22) {
                String var3 = GuiScreen.func_574_c();
                if (var3 == null) {
                    var3 = "";
                }

                int var4 = 32 - this.field_22075_h.length();
                if (var4 > var3.length()) {
                    var4 = var3.length();
                }

                if (var4 > 0) {
                    this.field_22075_h = this.field_22075_h + var3.substring(0, var4);
                }
            }

            if (var2 == 14 && this.field_22075_h.length() > 0) {
                this.field_22075_h = this.field_22075_h.substring(0, this.field_22075_h.length() - 1);
            }

            if (ChatAllowedCharacters.field_20157_a.indexOf(var1) >= 0 && (this.field_22075_h.length() < this.field_22074_i || this.field_22074_i == 0)) {
                this.field_22075_h = this.field_22075_h + var1;
            }

        }
    }

    public void func_22069_a(int var1, int var2, int var3) {
        boolean var4 = this.field_22081_b && var1 >= this.field_22079_d && var1 < this.field_22079_d + this.field_22077_f && var2 >= this.field_22078_e && var2 < this.field_22078_e + this.field_22076_g;
        this.func_27106_a(var4);
    }

    public void func_27106_a(boolean var1) {
        if (var1 && !this.field_22082_a) {
            this.field_22073_k = 0;
        }

        this.field_22082_a = var1;
    }

    public void func_22067_c() {
        this.func_551_a(this.field_22079_d - 1, this.field_22078_e - 1, this.field_22079_d + this.field_22077_f + 1, this.field_22078_e + this.field_22076_g + 1, -6250336);
        this.func_551_a(this.field_22079_d, this.field_22078_e, this.field_22079_d + this.field_22077_f, this.field_22078_e + this.field_22076_g, -16777216);
        if (this.field_22081_b) {
            boolean var1 = this.field_22082_a && this.field_22073_k / 6 % 2 == 0;
            this.func_547_b(this.field_22080_c, this.field_22075_h + (var1 ? "_" : ""), this.field_22079_d + 4, this.field_22078_e + (this.field_22076_g - 8) / 2, 14737632);
        } else {
            this.func_547_b(this.field_22080_c, this.field_22075_h, this.field_22079_d + 4, this.field_22078_e + (this.field_22076_g - 8) / 2, 7368816);
        }

    }

    public void func_22066_a(int var1) {
        this.field_22074_i = var1;
    }
}
