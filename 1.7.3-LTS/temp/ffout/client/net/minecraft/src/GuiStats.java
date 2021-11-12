package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiStats extends GuiScreen {
    private static RenderItem field_27153_j = new RenderItem();
    protected GuiScreen field_27152_a;
    protected String field_27154_i = "Select world";
    private GuiSlotStatsGeneral field_27151_l;
    private GuiSlotStatsItem field_27150_m;
    private GuiSlotStatsBlock field_27157_n;
    private StatFileWriter field_27156_o;
    private GuiSlot field_27155_p = null;

    public GuiStats(GuiScreen var1, StatFileWriter var2) {
        this.field_27152_a = var1;
        this.field_27156_o = var2;
    }

    public void func_6448_a() {
        this.field_27154_i = StatCollector.func_25200_a("gui.stats");
        this.field_27151_l = new GuiSlotStatsGeneral(this);
        this.field_27151_l.func_22240_a(this.field_949_e, 1, 1);
        this.field_27150_m = new GuiSlotStatsItem(this);
        this.field_27150_m.func_22240_a(this.field_949_e, 1, 1);
        this.field_27157_n = new GuiSlotStatsBlock(this);
        this.field_27157_n.func_22240_a(this.field_949_e, 1, 1);
        this.field_27155_p = this.field_27151_l;
        this.func_27130_k();
    }

    public void func_27130_k() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 + 4, this.field_950_d - 28, 150, 20, var1.func_20163_a("gui.done")));
        this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 154, this.field_950_d - 52, 100, 20, var1.func_20163_a("stat.generalButton")));
        GuiButton var2;
        this.field_949_e.add(var2 = new GuiButton(2, this.field_951_c / 2 - 46, this.field_950_d - 52, 100, 20, var1.func_20163_a("stat.blocksButton")));
        GuiButton var3;
        this.field_949_e.add(var3 = new GuiButton(3, this.field_951_c / 2 + 62, this.field_950_d - 52, 100, 20, var1.func_20163_a("stat.itemsButton")));
        if (this.field_27157_n.func_22249_a() == 0) {
            var2.field_937_g = false;
        }

        if (this.field_27150_m.func_22249_a() == 0) {
            var3.field_937_g = false;
        }

    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 0) {
                this.field_945_b.func_6272_a(this.field_27152_a);
            } else if (var1.field_938_f == 1) {
                this.field_27155_p = this.field_27151_l;
            } else if (var1.field_938_f == 3) {
                this.field_27155_p = this.field_27150_m;
            } else if (var1.field_938_f == 2) {
                this.field_27155_p = this.field_27157_n;
            } else {
                this.field_27155_p.func_22241_a(var1);
            }

        }
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.field_27155_p.func_22243_a(var1, var2, var3);
        this.func_548_a(this.field_6451_g, this.field_27154_i, this.field_951_c / 2, 20, 16777215);
        super.func_571_a(var1, var2, var3);
    }

    private void func_27138_c(int var1, int var2, int var3) {
        this.func_27147_a(var1 + 1, var2 + 1);
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        RenderHelper.func_1158_b();
        GL11.glPopMatrix();
        field_27153_j.func_27003_a(this.field_6451_g, this.field_945_b.field_6315_n, var3, 0, Item.field_233_c[var3].func_27009_a(0), var1 + 2, var2 + 2);
        RenderHelper.func_1159_a();
        GL11.glDisable(32826);
    }

    private void func_27147_a(int var1, int var2) {
        this.func_27136_c(var1, var2, 0, 0);
    }

    private void func_27136_c(int var1, int var2, int var3, int var4) {
        int var5 = this.field_945_b.field_6315_n.func_1070_a("/gui/slot.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_945_b.field_6315_n.func_1076_b(var5);
        Tessellator var10 = Tessellator.field_1512_a;
        var10.func_977_b();
        var10.func_983_a((double)(var1 + 0), (double)(var2 + 18), (double)this.field_923_k, (double)((float)(var3 + 0) * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F));
        var10.func_983_a((double)(var1 + 18), (double)(var2 + 18), (double)this.field_923_k, (double)((float)(var3 + 18) * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F));
        var10.func_983_a((double)(var1 + 18), (double)(var2 + 0), (double)this.field_923_k, (double)((float)(var3 + 18) * 0.0078125F), (double)((float)(var4 + 0) * 0.0078125F));
        var10.func_983_a((double)(var1 + 0), (double)(var2 + 0), (double)this.field_923_k, (double)((float)(var3 + 0) * 0.0078125F), (double)((float)(var4 + 0) * 0.0078125F));
        var10.func_982_a();
    }

    // $FF: synthetic method
    static Minecraft func_27141_a(GuiStats var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static FontRenderer func_27145_b(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static StatFileWriter func_27142_c(GuiStats var0) {
        return var0.field_27156_o;
    }

    // $FF: synthetic method
    static FontRenderer func_27140_d(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_27146_e(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static Minecraft func_27143_f(GuiStats var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static void func_27128_a(GuiStats var0, int var1, int var2, int var3, int var4) {
        var0.func_27136_c(var1, var2, var3, var4);
    }

    // $FF: synthetic method
    static Minecraft func_27149_g(GuiStats var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static FontRenderer func_27133_h(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_27137_i(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_27132_j(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_27134_k(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_27139_l(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static void func_27129_a(GuiStats var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        var0.func_549_a(var1, var2, var3, var4, var5, var6);
    }

    // $FF: synthetic method
    static FontRenderer func_27144_m(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_27127_n(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static void func_27135_b(GuiStats var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        var0.func_549_a(var1, var2, var3, var4, var5, var6);
    }

    // $FF: synthetic method
    static FontRenderer func_27131_o(GuiStats var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static void func_27148_a(GuiStats var0, int var1, int var2, int var3) {
        var0.func_27138_c(var1, var2, var3);
    }
}
