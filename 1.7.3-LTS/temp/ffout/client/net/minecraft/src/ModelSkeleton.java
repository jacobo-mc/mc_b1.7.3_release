package net.minecraft.src;

public class ModelSkeleton extends ModelZombie {
    public ModelSkeleton() {
        float var1 = 0.0F;
        this.field_1283_d = new ModelRenderer(40, 16);
        this.field_1283_d.func_923_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
        this.field_1283_d.func_925_a(-5.0F, 2.0F, 0.0F);
        this.field_1282_e = new ModelRenderer(40, 16);
        this.field_1282_e.field_1404_g = true;
        this.field_1282_e.func_923_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
        this.field_1282_e.func_925_a(5.0F, 2.0F, 0.0F);
        this.field_1281_f = new ModelRenderer(0, 16);
        this.field_1281_f.func_923_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
        this.field_1281_f.func_925_a(-2.0F, 12.0F, 0.0F);
        this.field_1280_g = new ModelRenderer(0, 16);
        this.field_1280_g.field_1404_g = true;
        this.field_1280_g.func_923_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
        this.field_1280_g.func_925_a(2.0F, 12.0F, 0.0F);
    }
}
