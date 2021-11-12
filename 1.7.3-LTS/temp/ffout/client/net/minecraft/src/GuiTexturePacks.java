package net.minecraft.src;

import java.io.File;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

public class GuiTexturePacks extends GuiScreen {
    protected GuiScreen field_6461_a;
    private int field_6454_o = -1;
    private String field_6453_p = "";
    private GuiTexturePackSlot field_22128_k;

    public GuiTexturePacks(GuiScreen var1) {
        this.field_6461_a = var1;
    }

    public void func_6448_a() {
        StringTranslate var1 = StringTranslate.func_20162_a();
        this.field_949_e.add(new GuiSmallButton(5, this.field_951_c / 2 - 154, this.field_950_d - 48, var1.func_20163_a("texturePack.openFolder")));
        this.field_949_e.add(new GuiSmallButton(6, this.field_951_c / 2 + 4, this.field_950_d - 48, var1.func_20163_a("gui.done")));
        this.field_945_b.field_6298_C.func_6532_a();
        this.field_6453_p = (new File(Minecraft.func_6240_b(), "texturepacks")).getAbsolutePath();
        this.field_22128_k = new GuiTexturePackSlot(this);
        this.field_22128_k.func_22240_a(this.field_949_e, 7, 8);
    }

    protected void func_572_a(GuiButton var1) {
        if (var1.field_937_g) {
            if (var1.field_938_f == 5) {
                Sys.openURL("file://" + this.field_6453_p);
            } else if (var1.field_938_f == 6) {
                this.field_945_b.field_6315_n.func_1065_b();
                this.field_945_b.func_6272_a(this.field_6461_a);
            } else {
                this.field_22128_k.func_22241_a(var1);
            }

        }
    }

    protected void func_565_a(int var1, int var2, int var3) {
        super.func_565_a(var1, var2, var3);
    }

    protected void func_573_b(int var1, int var2, int var3) {
        super.func_573_b(var1, var2, var3);
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.field_22128_k.func_22243_a(var1, var2, var3);
        if (this.field_6454_o <= 0) {
            this.field_945_b.field_6298_C.func_6532_a();
            this.field_6454_o += 20;
        }

        StringTranslate var4 = StringTranslate.func_20162_a();
        this.func_548_a(this.field_6451_g, var4.func_20163_a("texturePack.title"), this.field_951_c / 2, 16, 16777215);
        this.func_548_a(this.field_6451_g, var4.func_20163_a("texturePack.folderInfo"), this.field_951_c / 2 - 77, this.field_950_d - 26, 8421504);
        super.func_571_a(var1, var2, var3);
    }

    public void func_570_g() {
        super.func_570_g();
        --this.field_6454_o;
    }

    // $FF: synthetic method
    static Minecraft func_22124_a(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22126_b(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22119_c(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22122_d(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22117_e(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22118_f(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22116_g(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22121_h(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static Minecraft func_22123_i(GuiTexturePacks var0) {
        return var0.field_945_b;
    }

    // $FF: synthetic method
    static FontRenderer func_22127_j(GuiTexturePacks var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_22120_k(GuiTexturePacks var0) {
        return var0.field_6451_g;
    }

    // $FF: synthetic method
    static FontRenderer func_22125_l(GuiTexturePacks var0) {
        return var0.field_6451_g;
    }
}
