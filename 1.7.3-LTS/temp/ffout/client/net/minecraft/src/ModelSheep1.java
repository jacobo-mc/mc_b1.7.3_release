package net.minecraft.src;

public class ModelSheep1 extends ModelQuadruped {
    public ModelSheep1() {
        super(12, 0.0F);
        this.field_1266_d = new ModelRenderer(0, 0);
        this.field_1266_d.func_923_a(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
        this.field_1266_d.func_925_a(0.0F, 6.0F, -8.0F);
        this.field_1265_e = new ModelRenderer(28, 8);
        this.field_1265_e.func_923_a(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
        this.field_1265_e.func_925_a(0.0F, 5.0F, 2.0F);
        float var1 = 0.5F;
        this.field_1264_f = new ModelRenderer(0, 16);
        this.field_1264_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1264_f.func_925_a(-3.0F, 12.0F, 7.0F);
        this.field_1263_g = new ModelRenderer(0, 16);
        this.field_1263_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1263_g.func_925_a(3.0F, 12.0F, 7.0F);
        this.field_1262_h = new ModelRenderer(0, 16);
        this.field_1262_h.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1262_h.func_925_a(-3.0F, 12.0F, -5.0F);
        this.field_1261_i = new ModelRenderer(0, 16);
        this.field_1261_i.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
        this.field_1261_i.func_925_a(3.0F, 12.0F, -5.0F);
    }
}
