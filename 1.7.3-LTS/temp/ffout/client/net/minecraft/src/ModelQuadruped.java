package net.minecraft.src;

public class ModelQuadruped extends ModelBase {
    public ModelRenderer field_1266_d = new ModelRenderer(0, 0);
    public ModelRenderer field_1265_e;
    public ModelRenderer field_1264_f;
    public ModelRenderer field_1263_g;
    public ModelRenderer field_1262_h;
    public ModelRenderer field_1261_i;

    public ModelQuadruped(int var1, float var2) {
        this.field_1266_d.func_923_a(-4.0F, -4.0F, -8.0F, 8, 8, 8, var2);
        this.field_1266_d.func_925_a(0.0F, (float)(18 - var1), -6.0F);
        this.field_1265_e = new ModelRenderer(28, 8);
        this.field_1265_e.func_923_a(-5.0F, -10.0F, -7.0F, 10, 16, 8, var2);
        this.field_1265_e.func_925_a(0.0F, (float)(17 - var1), 2.0F);
        this.field_1264_f = new ModelRenderer(0, 16);
        this.field_1264_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.field_1264_f.func_925_a(-3.0F, (float)(24 - var1), 7.0F);
        this.field_1263_g = new ModelRenderer(0, 16);
        this.field_1263_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.field_1263_g.func_925_a(3.0F, (float)(24 - var1), 7.0F);
        this.field_1262_h = new ModelRenderer(0, 16);
        this.field_1262_h.func_923_a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.field_1262_h.func_925_a(-3.0F, (float)(24 - var1), -5.0F);
        this.field_1261_i = new ModelRenderer(0, 16);
        this.field_1261_i.func_923_a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
        this.field_1261_i.func_925_a(3.0F, (float)(24 - var1), -5.0F);
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_1266_d.func_922_a(var6);
        this.field_1265_e.func_922_a(var6);
        this.field_1264_f.func_922_a(var6);
        this.field_1263_g.func_922_a(var6);
        this.field_1262_h.func_922_a(var6);
        this.field_1261_i.func_922_a(var6);
    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_1266_d.field_1407_d = var5 / 57.295776F;
        this.field_1266_d.field_1406_e = var4 / 57.295776F;
        this.field_1265_e.field_1407_d = 1.5707964F;
        this.field_1264_f.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 1.4F * var2;
        this.field_1263_g.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.field_1262_h.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.field_1261_i.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 1.4F * var2;
    }
}
