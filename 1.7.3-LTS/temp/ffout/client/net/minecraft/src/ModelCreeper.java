package net.minecraft.src;

public class ModelCreeper extends ModelBase {
    public ModelRenderer field_1271_a;
    public ModelRenderer field_1270_b;
    public ModelRenderer field_1276_c;
    public ModelRenderer field_1275_d;
    public ModelRenderer field_1274_e;
    public ModelRenderer field_1273_f;
    public ModelRenderer field_1272_g;

    public ModelCreeper() {
        this(0.0F);
    }

    public ModelCreeper(float var1) {
        byte var2 = 4;
        this.field_1271_a = new ModelRenderer(0, 0);
        this.field_1271_a.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
        this.field_1271_a.func_925_a(0.0F, (float)var2, 0.0F);
        this.field_1270_b = new ModelRenderer(32, 0);
        this.field_1270_b.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1 + 0.5F);
        this.field_1270_b.func_925_a(0.0F, (float)var2, 0.0F);
        this.field_1276_c = new ModelRenderer(16, 16);
        this.field_1276_c.func_923_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
        this.field_1276_c.func_925_a(0.0F, (float)var2, 0.0F);
        this.field_1275_d = new ModelRenderer(0, 16);
        this.field_1275_d.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1275_d.func_925_a(-2.0F, (float)(12 + var2), 4.0F);
        this.field_1274_e = new ModelRenderer(0, 16);
        this.field_1274_e.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1274_e.func_925_a(2.0F, (float)(12 + var2), 4.0F);
        this.field_1273_f = new ModelRenderer(0, 16);
        this.field_1273_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1273_f.func_925_a(-2.0F, (float)(12 + var2), -4.0F);
        this.field_1272_g = new ModelRenderer(0, 16);
        this.field_1272_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1272_g.func_925_a(2.0F, (float)(12 + var2), -4.0F);
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_1271_a.func_922_a(var6);
        this.field_1276_c.func_922_a(var6);
        this.field_1275_d.func_922_a(var6);
        this.field_1274_e.func_922_a(var6);
        this.field_1273_f.func_922_a(var6);
        this.field_1272_g.func_922_a(var6);
    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_1271_a.field_1406_e = var4 / 57.295776F;
        this.field_1271_a.field_1407_d = var5 / 57.295776F;
        this.field_1275_d.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 1.4F * var2;
        this.field_1274_e.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.field_1273_f.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.field_1272_g.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 1.4F * var2;
    }
}
