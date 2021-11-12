package net.minecraft.src;

public class ModelCow extends ModelQuadruped {
    ModelRenderer field_1268_a;
    ModelRenderer field_1267_b;
    ModelRenderer field_1269_c;

    public ModelCow() {
        super(12, 0.0F);
        this.field_1266_d = new ModelRenderer(0, 0);
        this.field_1266_d.func_923_a(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
        this.field_1266_d.func_925_a(0.0F, 4.0F, -8.0F);
        this.field_1267_b = new ModelRenderer(22, 0);
        this.field_1267_b.func_923_a(-4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        this.field_1267_b.func_925_a(0.0F, 3.0F, -7.0F);
        this.field_1269_c = new ModelRenderer(22, 0);
        this.field_1269_c.func_923_a(3.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
        this.field_1269_c.func_925_a(0.0F, 3.0F, -7.0F);
        this.field_1268_a = new ModelRenderer(52, 0);
        this.field_1268_a.func_923_a(-2.0F, -3.0F, 0.0F, 4, 6, 2, 0.0F);
        this.field_1268_a.func_925_a(0.0F, 14.0F, 6.0F);
        this.field_1268_a.field_1407_d = 1.5707964F;
        this.field_1265_e = new ModelRenderer(18, 4);
        this.field_1265_e.func_923_a(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.field_1265_e.func_925_a(0.0F, 5.0F, 2.0F);
        --this.field_1264_f.field_1410_a;
        ++this.field_1263_g.field_1410_a;
        ModelRenderer var10000 = this.field_1264_f;
        var10000.field_1408_c += 0.0F;
        var10000 = this.field_1263_g;
        var10000.field_1408_c += 0.0F;
        --this.field_1262_h.field_1410_a;
        ++this.field_1261_i.field_1410_a;
        --this.field_1262_h.field_1408_c;
        --this.field_1261_i.field_1408_c;
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.func_864_b(var1, var2, var3, var4, var5, var6);
        this.field_1267_b.func_922_a(var6);
        this.field_1269_c.func_922_a(var6);
        this.field_1268_a.func_922_a(var6);
    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_1267_b.field_1406_e = this.field_1266_d.field_1406_e;
        this.field_1267_b.field_1407_d = this.field_1266_d.field_1407_d;
        this.field_1269_c.field_1406_e = this.field_1266_d.field_1406_e;
        this.field_1269_c.field_1407_d = this.field_1266_d.field_1407_d;
    }
}
