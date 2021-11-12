package net.minecraft.src;

public abstract class TileEntitySpecialRenderer {
    protected TileEntityRenderer field_6509_a;

    public abstract void func_930_a(TileEntity var1, double var2, double var4, double var6, float var8);

    protected void func_6507_a(String var1) {
        RenderEngine var2 = this.field_6509_a.field_1550_e;
        var2.func_1076_b(var2.func_1070_a(var1));
    }

    public void func_928_a(TileEntityRenderer var1) {
        this.field_6509_a = var1;
    }

    public void func_31069_a(World var1) {
    }

    public FontRenderer func_6508_a() {
        return this.field_6509_a.func_6516_a();
    }
}
