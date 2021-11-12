package net.minecraft.src;

public class ModelSlime extends ModelBase {
    ModelRenderer field_1258_a;
    ModelRenderer field_1257_b;
    ModelRenderer field_1260_c;
    ModelRenderer field_1259_d;

    public ModelSlime(int var1) {
        this.field_1258_a = new ModelRenderer(0, var1);
        this.field_1258_a.func_921_a(-4.0F, 16.0F, -4.0F, 8, 8, 8);
        if (var1 > 0) {
            this.field_1258_a = new ModelRenderer(0, var1);
            this.field_1258_a.func_921_a(-3.0F, 17.0F, -3.0F, 6, 6, 6);
            this.field_1257_b = new ModelRenderer(32, 0);
            this.field_1257_b.func_921_a(-3.25F, 18.0F, -3.5F, 2, 2, 2);
            this.field_1260_c = new ModelRenderer(32, 4);
            this.field_1260_c.func_921_a(1.25F, 18.0F, -3.5F, 2, 2, 2);
            this.field_1259_d = new ModelRenderer(32, 8);
            this.field_1259_d.func_921_a(0.0F, 21.0F, -3.5F, 1, 1, 1);
        }

    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_1258_a.func_922_a(var6);
        if (this.field_1257_b != null) {
            this.field_1257_b.func_922_a(var6);
            this.field_1260_c.func_922_a(var6);
            this.field_1259_d.func_922_a(var6);
        }

    }
}
