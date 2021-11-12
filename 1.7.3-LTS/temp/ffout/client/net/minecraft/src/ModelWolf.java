package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelWolf extends ModelBase {
    public ModelRenderer field_25114_a;
    public ModelRenderer field_25113_b;
    public ModelRenderer field_25112_c;
    public ModelRenderer field_25111_d;
    public ModelRenderer field_25110_e;
    public ModelRenderer field_25109_f;
    ModelRenderer field_25108_g;
    ModelRenderer field_25107_h;
    ModelRenderer field_25106_i;
    ModelRenderer field_25105_j;
    ModelRenderer field_25104_k;

    public ModelWolf() {
        float var1 = 0.0F;
        float var2 = 13.5F;
        this.field_25114_a = new ModelRenderer(0, 0);
        this.field_25114_a.func_923_a(-3.0F, -3.0F, -2.0F, 6, 6, 4, var1);
        this.field_25114_a.func_925_a(-1.0F, var2, -7.0F);
        this.field_25113_b = new ModelRenderer(18, 14);
        this.field_25113_b.func_923_a(-4.0F, -2.0F, -3.0F, 6, 9, 6, var1);
        this.field_25113_b.func_925_a(0.0F, 14.0F, 2.0F);
        this.field_25104_k = new ModelRenderer(21, 0);
        this.field_25104_k.func_923_a(-4.0F, -3.0F, -3.0F, 8, 6, 7, var1);
        this.field_25104_k.func_925_a(-1.0F, 14.0F, 2.0F);
        this.field_25112_c = new ModelRenderer(0, 18);
        this.field_25112_c.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
        this.field_25112_c.func_925_a(-2.5F, 16.0F, 7.0F);
        this.field_25111_d = new ModelRenderer(0, 18);
        this.field_25111_d.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
        this.field_25111_d.func_925_a(0.5F, 16.0F, 7.0F);
        this.field_25110_e = new ModelRenderer(0, 18);
        this.field_25110_e.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
        this.field_25110_e.func_925_a(-2.5F, 16.0F, -4.0F);
        this.field_25109_f = new ModelRenderer(0, 18);
        this.field_25109_f.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
        this.field_25109_f.func_925_a(0.5F, 16.0F, -4.0F);
        this.field_25105_j = new ModelRenderer(9, 18);
        this.field_25105_j.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
        this.field_25105_j.func_925_a(-1.0F, 12.0F, 8.0F);
        this.field_25108_g = new ModelRenderer(16, 14);
        this.field_25108_g.func_923_a(-3.0F, -5.0F, 0.0F, 2, 2, 1, var1);
        this.field_25108_g.func_925_a(-1.0F, var2, -7.0F);
        this.field_25107_h = new ModelRenderer(16, 14);
        this.field_25107_h.func_923_a(1.0F, -5.0F, 0.0F, 2, 2, 1, var1);
        this.field_25107_h.func_925_a(-1.0F, var2, -7.0F);
        this.field_25106_i = new ModelRenderer(0, 10);
        this.field_25106_i.func_923_a(-2.0F, 0.0F, -5.0F, 3, 3, 4, var1);
        this.field_25106_i.func_925_a(-0.5F, var2, -7.0F);
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.func_864_b(var1, var2, var3, var4, var5, var6);
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_25114_a.func_25122_b(var6);
        this.field_25113_b.func_922_a(var6);
        this.field_25112_c.func_922_a(var6);
        this.field_25111_d.func_922_a(var6);
        this.field_25110_e.func_922_a(var6);
        this.field_25109_f.func_922_a(var6);
        this.field_25108_g.func_25122_b(var6);
        this.field_25107_h.func_25122_b(var6);
        this.field_25106_i.func_25122_b(var6);
        this.field_25105_j.func_25122_b(var6);
        this.field_25104_k.func_922_a(var6);
    }

    public void func_25103_a(EntityLiving var1, float var2, float var3, float var4) {
        EntityWolf var5 = (EntityWolf)var1;
        if (var5.func_25040_C()) {
            this.field_25105_j.field_1406_e = 0.0F;
        } else {
            this.field_25105_j.field_1406_e = MathHelper.func_1114_b(var2 * 0.6662F) * 1.4F * var3;
        }

        if (var5.func_25034_B()) {
            this.field_25104_k.func_925_a(-1.0F, 16.0F, -3.0F);
            this.field_25104_k.field_1407_d = 1.2566371F;
            this.field_25104_k.field_1406_e = 0.0F;
            this.field_25113_b.func_925_a(0.0F, 18.0F, 0.0F);
            this.field_25113_b.field_1407_d = 0.7853982F;
            this.field_25105_j.func_925_a(-1.0F, 21.0F, 6.0F);
            this.field_25112_c.func_925_a(-2.5F, 22.0F, 2.0F);
            this.field_25112_c.field_1407_d = 4.712389F;
            this.field_25111_d.func_925_a(0.5F, 22.0F, 2.0F);
            this.field_25111_d.field_1407_d = 4.712389F;
            this.field_25110_e.field_1407_d = 5.811947F;
            this.field_25110_e.func_925_a(-2.49F, 17.0F, -4.0F);
            this.field_25109_f.field_1407_d = 5.811947F;
            this.field_25109_f.func_925_a(0.51F, 17.0F, -4.0F);
        } else {
            this.field_25113_b.func_925_a(0.0F, 14.0F, 2.0F);
            this.field_25113_b.field_1407_d = 1.5707964F;
            this.field_25104_k.func_925_a(-1.0F, 14.0F, -3.0F);
            this.field_25104_k.field_1407_d = this.field_25113_b.field_1407_d;
            this.field_25105_j.func_925_a(-1.0F, 12.0F, 8.0F);
            this.field_25112_c.func_925_a(-2.5F, 16.0F, 7.0F);
            this.field_25111_d.func_925_a(0.5F, 16.0F, 7.0F);
            this.field_25110_e.func_925_a(-2.5F, 16.0F, -4.0F);
            this.field_25109_f.func_925_a(0.5F, 16.0F, -4.0F);
            this.field_25112_c.field_1407_d = MathHelper.func_1114_b(var2 * 0.6662F) * 1.4F * var3;
            this.field_25111_d.field_1407_d = MathHelper.func_1114_b(var2 * 0.6662F + 3.1415927F) * 1.4F * var3;
            this.field_25110_e.field_1407_d = MathHelper.func_1114_b(var2 * 0.6662F + 3.1415927F) * 1.4F * var3;
            this.field_25109_f.field_1407_d = MathHelper.func_1114_b(var2 * 0.6662F) * 1.4F * var3;
        }

        float var6 = var5.func_25033_c(var4) + var5.func_25042_a(var4, 0.0F);
        this.field_25114_a.field_1405_f = var6;
        this.field_25108_g.field_1405_f = var6;
        this.field_25107_h.field_1405_f = var6;
        this.field_25106_i.field_1405_f = var6;
        this.field_25104_k.field_1405_f = var5.func_25042_a(var4, -0.08F);
        this.field_25113_b.field_1405_f = var5.func_25042_a(var4, -0.16F);
        this.field_25105_j.field_1405_f = var5.func_25042_a(var4, -0.2F);
        if (var5.func_25039_v()) {
            float var7 = var5.func_382_a(var4) * var5.func_25043_b_(var4);
            GL11.glColor3f(var7, var7, var7);
        }

    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_25114_a.field_1407_d = var5 / 57.295776F;
        this.field_25114_a.field_1406_e = var4 / 57.295776F;
        this.field_25108_g.field_1406_e = this.field_25114_a.field_1406_e;
        this.field_25108_g.field_1407_d = this.field_25114_a.field_1407_d;
        this.field_25107_h.field_1406_e = this.field_25114_a.field_1406_e;
        this.field_25107_h.field_1407_d = this.field_25114_a.field_1407_d;
        this.field_25106_i.field_1406_e = this.field_25114_a.field_1406_e;
        this.field_25106_i.field_1407_d = this.field_25114_a.field_1407_d;
        this.field_25105_j.field_1407_d = var3;
    }
}
