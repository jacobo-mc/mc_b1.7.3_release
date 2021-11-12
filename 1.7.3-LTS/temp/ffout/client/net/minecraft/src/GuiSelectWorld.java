package net.minecraft.src;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

public class GuiSelectWorld extends GuiScreen {
    private final DateFormat field_22102_i = new SimpleDateFormat();
    protected GuiScreen field_958_a;
    protected String field_960_h = "Select world";
    private boolean field_959_i = false;
    private int field_22101_l;
    private List field_22100_m;
    private GuiWorldSlot field_22099_n;
    private String field_22098_o;
    private String field_22097_p;
    private boolean field_22096_q;
    private GuiButton field_22095_r;
    private GuiButton field_22104_s;
    private GuiButton field_22103_t;

    public GuiSelectWorld(GuiScreen var1) {
        this.field_958_a = var1;
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_960_h = var1.func_20163_a("selectWorld.title");
        this.field_22098_o = var1.func_20163_a("selectWorld.world");
        this.field_22097_p = var1.func_20163_a("selectWorld.conversion");
        this.func_22084_k();
        this.field_22099_n = new GuiWorldSlot(this);
        this.field_22099_n.func_22240_a(this.field_949_e, 4, 5);
        this.func_585_j();
    }

    private void func_22084_k() {
        ISaveFormat var1 = this.field_945_b.func_22004_c();
        this.field_22100_m = var1.func_22176_b();
        Collections.sort(this.field_22100_m);
        this.field_22101_l = -1;
    }

    protected String func_22091_c(int var1) {
        return ((SaveFormatComparator)this.field_22100_m.get(var1)).func_22164_a();
    }

    protected String func_22094_d(int var1) {
        String var2 = ((SaveFormatComparator)this.field_22100_m.get(var1)).func_22162_b();
        if (var2 == null || MathHelper.func_22282_a(var2)) {
            StringTranslate var3 = StringTranslate.func_20162_a();
            var2 = var3.func_20163_a("selectWorld.world") + " " + (var1 + 1);
        }

        return var2;
    }

    public void func_585_j() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_949_e.add(this.field_22104_s = new GuiButton(1, this.field_951_c / 2 - 154, this.field_950_d - 52, 150, 20, var1.func_20163_a("selectWorld.select")));
        this.field_949_e.add(this.field_22095_r = new GuiButton(6, this.field_951_c / 2 - 154, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectWorld.rename")));
        this.field_949_e.add(this.field_22103_t = new GuiButton(2, this.field_951_c / 2 - 74, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectWorld.delete")));
        this.field_949_e.add(new GuiButton(3, this.field_951_c / 2 + 4, this.field_950_d - 52, 150, 20, var1.func_20163_a("selectWorld.create")));
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 + 4, this.field_950_d - 28, 150, 20, var1.func_20163_a("gui.cancel")));
        this.field_22104_s.field_937_g = false;
        this.field_22095_r.field_937_g = false;
        this.field_22103_t.field_937_g = false;
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 2) {
                String var2 = this.func_22094_d(this.field_22101_l);
                if (var2 != null) {
                    this.field_22096_q = true;
                    StringTranslate var3 = StringTranslate.func_20162_a();
                    String var4 = var3.func_20163_a("selectWorld.deleteQuestion");
                    String var5 = "'" + var2 + "' " + var3.func_20163_a("selectWorld.deleteWarning");
                    String var6 = var3.func_20163_a("selectWorld.deleteButton");
                    String var7 = var3.func_20163_a("gui.cancel");
                    GuiYesNo var8 = new GuiYesNo(this, var4, var5, var6, var7, this.field_22101_l);
                    this.field_945_b.func_6272_a(var8);
                }
            } else if (var1.field_938_f == 1) {
                this.func_584_c(this.field_22101_l);
            } else if (var1.field_938_f == 3) {
                this.field_945_b.func_6272_a(new GuiCreateWorld(this));
            } else if (var1.field_938_f == 6) {
                this.field_945_b.func_6272_a(new GuiRenameWorld(this, this.func_22091_c(this.field_22101_l)));
            } else if (var1.field_938_f == 0) {
                this.field_945_b.func_6272_a(this.field_958_a);
            } else {
                this.field_22099_n.func_22241_a(var1);
            }

        }
    }

    public void func_584_c(int var1) {
        this.field_945_b.func_6272_a((GuiScreen)null);
        if (!this.field_959_i) {
            this.field_959_i = true;
            this.field_945_b.field_6327_b = new PlayerControllerSP(this.field_945_b);
            String var2 = this.func_22091_c(var1);
            if (var2 == null) {
                var2 = "World" + var1;
            }

            this.field_945_b.func_6247_b(var2, this.func_22094_d(var1), 0L);
            this.field_945_b.func_6272_a((GuiScreen)null);
        }
    }

    public void func_568_a(boolean var1, int var2) {
        if (this.field_22096_q) {
            this.field_22096_q = false;
            if (var1) {
                ISaveFormat var3 = this.field_945_b.func_22004_c();
                var3.func_22177_c();
                var3.func_22172_c(this.func_22091_c(var2));
                this.func_22084_k();
            }

            this.field_945_b.func_6272_a(this);
        }

    }

    public void func_571_a(int var1, int var2, float var3) {
        this.field_22099_n.func_22243_a(var1, var2, var3);
        this.func_548_a(this.field_6451_g, this.field_960_h, this.field_951_c / 2, 20, 16777215);
        super.func_571_a(var1, var2, var3);
    }

    // $FF: synthetic method
    static List func_22090_a(GuiSelectWorld var0) {
        return var0.field_22100_m;
    }

    // $FF: synthetic method
    static int func_22089_a(GuiSelectWorld var0, int var1) {
        return var0.field_22101_l = var1;
    }

    // $FF: synthetic method
    static int func_22086_b(GuiSelectWorld var0) {
        return var0.field_22101_l;
    }

    // $FF: synthetic method
    static GuiButton func_22083_c(GuiSelectWorld var0) {
        return var0.field_22104_s;
    }

    // $FF: synthetic method
    static GuiButton func_22085_d(GuiSelectWorld var0) {
        return var0.field_22095_r;
    }

    // $FF: synthetic method
    static GuiButton func_22092_e(GuiSelectWorld var0) {
        return var0.field_22103_t;
    }

    // $FF: synthetic method
    static String func_22087_f(GuiSelectWorld var0) {
        return var0.field_22098_o;
    }

    // $FF: synthetic method
    static DateFormat func_22093_g(GuiSelectWorld var0) {
        return var0.field_22102_i;
    }

    // $FF: synthetic method
    static String func_22088_h(GuiSelectWorld var0) {
        return var0.field_22097_p;
    }
}
