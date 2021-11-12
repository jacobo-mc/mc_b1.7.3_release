package net.minecraft.src;

public class ModelChicken extends ModelBase {
    public ModelRenderer field_1289_a;
    public ModelRenderer field_1288_b;
    public ModelRenderer field_1295_c;
    public ModelRenderer field_1294_d;
    public ModelRenderer field_1293_e;
    public ModelRenderer field_1292_f;
    public ModelRenderer field_1291_g;
    public ModelRenderer field_1290_h;

    public ModelChicken() {
        byte var1 = 16;
        this.field_1289_a = new ModelRenderer(0, 0);
        this.field_1289_a.func_923_a(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
        this.field_1289_a.func_925_a(0.0F, (float)(-1 + var1), -4.0F);
        this.field_1291_g = new ModelRenderer(14, 0);
        this.field_1291_g.func_923_a(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
        this.field_1291_g.func_925_a(0.0F, (float)(-1 + var1), -4.0F);
        this.field_1290_h = new ModelRenderer(14, 4);
        this.field_1290_h.func_923_a(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
        this.field_1290_h.func_925_a(0.0F, (float)(-1 + var1), -4.0F);
        this.field_1288_b = new ModelRenderer(0, 9);
        this.field_1288_b.func_923_a(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
        this.field_1288_b.func_925_a(0.0F, (float)(0 + var1), 0.0F);
        this.field_1295_c = new ModelRenderer(26, 0);
        this.field_1295_c.func_921_a(-1.0F, 0.0F, -3.0F, 3, 5, 3);
        this.field_1295_c.func_925_a(-2.0F, (float)(3 + var1), 1.0F);
        this.field_1294_d = new ModelRenderer(26, 0);
        this.field_1294_d.func_921_a(-1.0F, 0.0F, -3.0F, 3, 5, 3);
        this.field_1294_d.func_925_a(1.0F, (float)(3 + var1), 1.0F);
        this.field_1293_e = new ModelRenderer(24, 13);
        this.field_1293_e.func_921_a(0.0F, 0.0F, -3.0F, 1, 4, 6);
        this.field_1293_e.func_925_a(-4.0F, (float)(-3 + var1), 0.0F);
        this.field_1292_f = new ModelRenderer(24, 13);
        this.field_1292_f.func_921_a(-1.0F, 0.0F, -3.0F, 1, 4, 6);
        this.field_1292_f.func_925_a(4.0F, (float)(-3 + var1), 0.0F);
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_1289_a.func_922_a(var6);
        this.field_1291_g.func_922_a(var6);
        this.field_1290_h.func_922_a(var6);
        this.field_1288_b.func_922_a(var6);
        this.field_1295_c.func_922_a(var6);
        this.field_1294_d.func_922_a(var6);
        this.field_1293_e.func_922_a(var6);
        this.field_1292_f.func_922_a(var6);
    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_1289_a.field_1407_d = -(var5 / 57.295776F);
        this.field_1289_a.field_1406_e = var4 / 57.295776F;
        this.field_1291_g.field_1407_d = this.field_1289_a.field_1407_d;
        this.field_1291_g.field_1406_e = this.field_1289_a.field_1406_e;
        this.field_1290_h.field_1407_d = this.field_1289_a.field_1407_d;
        this.field_1290_h.field_1406_e = this.field_1289_a.field_1406_e;
        this.field_1288_b.field_1407_d = 1.5707964F;
        this.field_1295_c.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 1.4F * var2;
        this.field_1294_d.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.field_1293_e.field_1405_f = var3;
        this.field_1292_f.field_1405_f = -var3;
    }
}
