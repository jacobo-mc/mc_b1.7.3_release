package net.minecraft.src;

public class ModelBiped extends ModelBase {
    public ModelRenderer field_1286_a;
    public ModelRenderer field_1285_b;
    public ModelRenderer field_1284_c;
    public ModelRenderer field_1283_d;
    public ModelRenderer field_1282_e;
    public ModelRenderer field_1281_f;
    public ModelRenderer field_1280_g;
    public ModelRenderer field_20098_h;
    public ModelRenderer field_20097_i;
    public boolean field_1279_h;
    public boolean field_1278_i;
    public boolean field_1277_j;

    public ModelBiped() {
        this(0.0F);
    }

    public ModelBiped(float var1) {
        this(var1, 0.0F);
    }

    public ModelBiped(float var1, float var2) {
        this.field_1279_h = false;
        this.field_1278_i = false;
        this.field_1277_j = false;
        this.field_20097_i = new ModelRenderer(0, 0);
        this.field_20097_i.func_923_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
        this.field_20098_h = new ModelRenderer(24, 0);
        this.field_20098_h.func_923_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, var1);
        this.field_1286_a = new ModelRenderer(0, 0);
        this.field_1286_a.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
        this.field_1286_a.func_925_a(0.0F, 0.0F + var2, 0.0F);
        this.field_1285_b = new ModelRenderer(32, 0);
        this.field_1285_b.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1 + 0.5F);
        this.field_1285_b.func_925_a(0.0F, 0.0F + var2, 0.0F);
        this.field_1284_c = new ModelRenderer(16, 16);
        this.field_1284_c.func_923_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
        this.field_1284_c.func_925_a(0.0F, 0.0F + var2, 0.0F);
        this.field_1283_d = new ModelRenderer(40, 16);
        this.field_1283_d.func_923_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, var1);
        this.field_1283_d.func_925_a(-5.0F, 2.0F + var2, 0.0F);
        this.field_1282_e = new ModelRenderer(40, 16);
        this.field_1282_e.field_1404_g = true;
        this.field_1282_e.func_923_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1);
        this.field_1282_e.func_925_a(5.0F, 2.0F + var2, 0.0F);
        this.field_1281_f = new ModelRenderer(0, 16);
        this.field_1281_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
        this.field_1281_f.func_925_a(-2.0F, 12.0F + var2, 0.0F);
        this.field_1280_g = new ModelRenderer(0, 16);
        this.field_1280_g.field_1404_g = true;
        this.field_1280_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
        this.field_1280_g.func_925_a(2.0F, 12.0F + var2, 0.0F);
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_1286_a.func_922_a(var6);
        this.field_1284_c.func_922_a(var6);
        this.field_1283_d.func_922_a(var6);
        this.field_1282_e.func_922_a(var6);
        this.field_1281_f.func_922_a(var6);
        this.field_1280_g.func_922_a(var6);
        this.field_1285_b.func_922_a(var6);
    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_1286_a.field_1406_e = var4 / 57.295776F;
        this.field_1286_a.field_1407_d = var5 / 57.295776F;
        this.field_1285_b.field_1406_e = this.field_1286_a.field_1406_e;
        this.field_1285_b.field_1407_d = this.field_1286_a.field_1407_d;
        this.field_1283_d.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 2.0F * var2 * 0.5F;
        this.field_1282_e.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.field_1283_d.field_1405_f = 0.0F;
        this.field_1282_e.field_1405_f = 0.0F;
        this.field_1281_f.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F) * 1.4F * var2;
        this.field_1280_g.field_1407_d = MathHelper.func_1114_b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.field_1281_f.field_1406_e = 0.0F;
        this.field_1280_g.field_1406_e = 0.0F;
        ModelRenderer var10000;
        if (this.field_1243_l) {
            var10000 = this.field_1283_d;
            var10000.field_1407_d += -0.62831855F;
            var10000 = this.field_1282_e;
            var10000.field_1407_d += -0.62831855F;
            this.field_1281_f.field_1407_d = -1.2566371F;
            this.field_1280_g.field_1407_d = -1.2566371F;
            this.field_1281_f.field_1406_e = 0.31415927F;
            this.field_1280_g.field_1406_e = -0.31415927F;
        }

        if (this.field_1279_h) {
            this.field_1282_e.field_1407_d = this.field_1282_e.field_1407_d * 0.5F - 0.31415927F;
        }

        if (this.field_1278_i) {
            this.field_1283_d.field_1407_d = this.field_1283_d.field_1407_d * 0.5F - 0.31415927F;
        }

        this.field_1283_d.field_1406_e = 0.0F;
        this.field_1282_e.field_1406_e = 0.0F;
        if (this.field_1244_k > -9990.0F) {
            float var7 = this.field_1244_k;
            this.field_1284_c.field_1406_e = MathHelper.func_1106_a(MathHelper.func_1113_c(var7) * 3.1415927F * 2.0F) * 0.2F;
            this.field_1283_d.field_1408_c = MathHelper.func_1106_a(this.field_1284_c.field_1406_e) * 5.0F;
            this.field_1283_d.field_1410_a = -MathHelper.func_1114_b(this.field_1284_c.field_1406_e) * 5.0F;
            this.field_1282_e.field_1408_c = -MathHelper.func_1106_a(this.field_1284_c.field_1406_e) * 5.0F;
            this.field_1282_e.field_1410_a = MathHelper.func_1114_b(this.field_1284_c.field_1406_e) * 5.0F;
            var10000 = this.field_1283_d;
            var10000.field_1406_e += this.field_1284_c.field_1406_e;
            var10000 = this.field_1282_e;
            var10000.field_1406_e += this.field_1284_c.field_1406_e;
            var10000 = this.field_1282_e;
            var10000.field_1407_d += this.field_1284_c.field_1406_e;
            var7 = 1.0F - this.field_1244_k;
            var7 *= var7;
            var7 *= var7;
            var7 = 1.0F - var7;
            float var8 = MathHelper.func_1106_a(var7 * 3.1415927F);
            float var9 = MathHelper.func_1106_a(this.field_1244_k * 3.1415927F) * -(this.field_1286_a.field_1407_d - 0.7F) * 0.75F;
            var10000 = this.field_1283_d;
            var10000.field_1407_d = (float)((double)var10000.field_1407_d - ((double)var8 * 1.2D + (double)var9));
            var10000 = this.field_1283_d;
            var10000.field_1406_e += this.field_1284_c.field_1406_e * 2.0F;
            this.field_1283_d.field_1405_f = MathHelper.func_1106_a(this.field_1244_k * 3.1415927F) * -0.4F;
        }

        if (this.field_1277_j) {
            this.field_1284_c.field_1407_d = 0.5F;
            var10000 = this.field_1281_f;
            var10000.field_1407_d -= 0.0F;
            var10000 = this.field_1280_g;
            var10000.field_1407_d -= 0.0F;
            var10000 = this.field_1283_d;
            var10000.field_1407_d += 0.4F;
            var10000 = this.field_1282_e;
            var10000.field_1407_d += 0.4F;
            this.field_1281_f.field_1408_c = 4.0F;
            this.field_1280_g.field_1408_c = 4.0F;
            this.field_1281_f.field_1409_b = 9.0F;
            this.field_1280_g.field_1409_b = 9.0F;
            this.field_1286_a.field_1409_b = 1.0F;
        } else {
            this.field_1284_c.field_1407_d = 0.0F;
            this.field_1281_f.field_1408_c = 0.0F;
            this.field_1280_g.field_1408_c = 0.0F;
            this.field_1281_f.field_1409_b = 12.0F;
            this.field_1280_g.field_1409_b = 12.0F;
            this.field_1286_a.field_1409_b = 0.0F;
        }

        var10000 = this.field_1283_d;
        var10000.field_1405_f += MathHelper.func_1114_b(var3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.field_1282_e;
        var10000.field_1405_f -= MathHelper.func_1114_b(var3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.field_1283_d;
        var10000.field_1407_d += MathHelper.func_1106_a(var3 * 0.067F) * 0.05F;
        var10000 = this.field_1282_e;
        var10000.field_1407_d -= MathHelper.func_1106_a(var3 * 0.067F) * 0.05F;
    }

    public void func_20095_a(float var1) {
        this.field_20098_h.field_1406_e = this.field_1286_a.field_1406_e;
        this.field_20098_h.field_1407_d = this.field_1286_a.field_1407_d;
        this.field_20098_h.field_1410_a = 0.0F;
        this.field_20098_h.field_1409_b = 0.0F;
        this.field_20098_h.func_922_a(var1);
    }

    public void func_20096_b(float var1) {
        this.field_20097_i.func_922_a(var1);
    }
}
