package net.minecraft.src;

public class TexturedQuad {
    public PositionTextureVertex[] field_1195_a;
    public int field_1194_b;
    private boolean field_1196_c;

    public TexturedQuad(PositionTextureVertex[] var1) {
        this.field_1194_b = 0;
        this.field_1196_c = false;
        this.field_1195_a = var1;
        this.field_1194_b = var1.length;
    }

    public TexturedQuad(PositionTextureVertex[] var1, int var2, int var3, int var4, int var5) {
        this(var1);
        float var6 = 0.0015625F;
        float var7 = 0.003125F;
        var1[0] = var1[0].func_1115_a((float)var4 / 64.0F - var6, (float)var3 / 32.0F + var7);
        var1[1] = var1[1].func_1115_a((float)var2 / 64.0F + var6, (float)var3 / 32.0F + var7);
        var1[2] = var1[2].func_1115_a((float)var2 / 64.0F + var6, (float)var5 / 32.0F - var7);
        var1[3] = var1[3].func_1115_a((float)var4 / 64.0F - var6, (float)var5 / 32.0F - var7);
    }

    public void func_809_a() {
        PositionTextureVertex[] var1 = new PositionTextureVertex[this.field_1195_a.length];

        for(int var2 = 0; var2 < this.field_1195_a.length; ++var2) {
            var1[var2] = this.field_1195_a[this.field_1195_a.length - var2 - 1];
        }

        this.field_1195_a = var1;
    }

    public void func_808_a(Tessellator var1, float var2) {
        Vec3D var3 = this.field_1195_a[1].field_1655_a.func_1262_a(this.field_1195_a[0].field_1655_a);
        Vec3D var4 = this.field_1195_a[1].field_1655_a.func_1262_a(this.field_1195_a[2].field_1655_a);
        Vec3D var5 = var4.func_1246_b(var3).func_1252_b();
        var1.func_977_b();
        if (this.field_1196_c) {
            var1.func_980_b(-((float)var5.field_1776_a), -((float)var5.field_1775_b), -((float)var5.field_1779_c));
        } else {
            var1.func_980_b((float)var5.field_1776_a, (float)var5.field_1775_b, (float)var5.field_1779_c);
        }

        for(int var6 = 0; var6 < 4; ++var6) {
            PositionTextureVertex var7 = this.field_1195_a[var6];
            var1.func_983_a((double)((float)var7.field_1655_a.field_1776_a * var2), (double)((float)var7.field_1655_a.field_1775_b * var2), (double)((float)var7.field_1655_a.field_1779_c * var2), (double)var7.field_1654_b, (double)var7.field_1656_c);
        }

        var1.func_982_a();
    }
}
