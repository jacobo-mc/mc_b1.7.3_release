package net.minecraft.src;

import java.util.List;
import org.lwjgl.opengl.GL11;

class GuiTexturePackSlot extends GuiSlot {
    // $FF: synthetic field
    final GuiTexturePacks field_22265_a;

    public GuiTexturePackSlot(GuiTexturePacks var1) {
        super(GuiTexturePacks.func_22124_a(var1), var1.field_951_c, var1.field_950_d, 32, var1.field_950_d - 55 + 4, 36);
        this.field_22265_a = var1;
    }

    protected int func_22249_a() {
        List var1 = GuiTexturePacks.func_22126_b(this.field_22265_a).field_6298_C.func_6530_b();
        return var1.size();
    }

    protected void func_22247_a(int var1, boolean var2) {
        List var3 = GuiTexturePacks.func_22119_c(this.field_22265_a).field_6298_C.func_6530_b();
        GuiTexturePacks.func_22122_d(this.field_22265_a).field_6298_C.func_6531_a((TexturePackBase)var3.get(var1));
        GuiTexturePacks.func_22117_e(this.field_22265_a).field_6315_n.func_1065_b();
    }

    protected boolean func_22246_a(int var1) {
        List var2 = GuiTexturePacks.func_22118_f(this.field_22265_a).field_6298_C.func_6530_b();
        return GuiTexturePacks.func_22116_g(this.field_22265_a).field_6298_C.field_6534_a == var2.get(var1);
    }

    protected int func_22245_b() {
        return this.func_22249_a() * 36;
    }

    protected void func_22248_c() {
        this.field_22265_a.func_578_i();
    }

    protected void func_22242_a(int var1, int var2, int var3, int var4, Tessellator var5) {
        TexturePackBase var6 = (TexturePackBase)GuiTexturePacks.func_22121_h(this.field_22265_a).field_6298_C.func_6530_b().get(var1);
        var6.func_6483_c(GuiTexturePacks.func_22123_i(this.field_22265_a));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        var5.func_977_b();
        var5.func_990_b(16777215);
        var5.func_983_a((double)var2, (double)(var3 + var4), 0.0D, 0.0D, 1.0D);
        var5.func_983_a((double)(var2 + 32), (double)(var3 + var4), 0.0D, 1.0D, 1.0D);
        var5.func_983_a((double)(var2 + 32), (double)var3, 0.0D, 1.0D, 0.0D);
        var5.func_983_a((double)var2, (double)var3, 0.0D, 0.0D, 0.0D);
        var5.func_982_a();
        this.field_22265_a.func_547_b(GuiTexturePacks.func_22127_j(this.field_22265_a), var6.field_6487_a, var2 + 32 + 2, var3 + 1, 16777215);
        this.field_22265_a.func_547_b(GuiTexturePacks.func_22120_k(this.field_22265_a), var6.field_6486_b, var2 + 32 + 2, var3 + 12, 8421504);
        this.field_22265_a.func_547_b(GuiTexturePacks.func_22125_l(this.field_22265_a), var6.field_6489_c, var2 + 32 + 2, var3 + 12 + 10, 8421504);
    }
}
