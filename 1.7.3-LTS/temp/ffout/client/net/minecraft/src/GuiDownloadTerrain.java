package net.minecraft.src;

public class GuiDownloadTerrain extends GuiScreen {
    private NetClientHandler field_983_a;
    private int field_984_h = 0;

    public GuiDownloadTerrain(NetClientHandler var1) {
        this.field_983_a = var1;
    }

    protected void func_580_a(char var1, int var2) {
    }

    public void func_6448_a() {
        this.field_949_e.clear();
    }

    public void func_570_g() {
        ++this.field_984_h;
        if (this.field_984_h % 20 == 0) {
            this.field_983_a.func_847_a(new Packet0KeepAlive());
        }

        if (this.field_983_a != null) {
            this.field_983_a.func_848_a();
        }

    }

    protected void func_572_a(GuiButton var1) {
    }

    public void func_571_a(int var1, int var2, float var3) {
        this.func_579_b(0);
        StringTranslate var4 = StringTranslate.func_20162_a();
        this.func_548_a(this.field_6451_g, var4.func_20163_a("multiplayer.downloadingTerrain"), this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
        super.func_571_a(var1, var2, var3);
    }
}
