package net.minecraft.src;

public class ModelMinecart extends ModelBase {
    public ModelRenderer[] field_1256_a = new ModelRenderer[7];

    public ModelMinecart() {
        this.field_1256_a[0] = new ModelRenderer(0, 10);
        this.field_1256_a[1] = new ModelRenderer(0, 0);
        this.field_1256_a[2] = new ModelRenderer(0, 0);
        this.field_1256_a[3] = new ModelRenderer(0, 0);
        this.field_1256_a[4] = new ModelRenderer(0, 0);
        this.field_1256_a[5] = new ModelRenderer(44, 10);
        byte var1 = 20;
        byte var2 = 8;
        byte var3 = 16;
        byte var4 = 4;
        this.field_1256_a[0].func_923_a((float)(-var1 / 2), (float)(-var3 / 2), -1.0F, var1, var3, 2, 0.0F);
        this.field_1256_a[0].func_925_a(0.0F, (float)(0 + var4), 0.0F);
        this.field_1256_a[5].func_923_a((float)(-var1 / 2 + 1), (float)(-var3 / 2 + 1), -1.0F, var1 - 2, var3 - 2, 1, 0.0F);
        this.field_1256_a[5].func_925_a(0.0F, (float)(0 + var4), 0.0F);
        this.field_1256_a[1].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
        this.field_1256_a[1].func_925_a((float)(-var1 / 2 + 1), (float)(0 + var4), 0.0F);
        this.field_1256_a[2].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
        this.field_1256_a[2].func_925_a((float)(var1 / 2 - 1), (float)(0 + var4), 0.0F);
        this.field_1256_a[3].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
        this.field_1256_a[3].func_925_a(0.0F, (float)(0 + var4), (float)(-var3 / 2 + 1));
        this.field_1256_a[4].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
        this.field_1256_a[4].func_925_a(0.0F, (float)(0 + var4), (float)(var3 / 2 - 1));
        this.field_1256_a[0].field_1407_d = 1.5707964F;
        this.field_1256_a[1].field_1406_e = 4.712389F;
        this.field_1256_a[2].field_1406_e = 1.5707964F;
        this.field_1256_a[3].field_1406_e = 3.1415927F;
        this.field_1256_a[5].field_1407_d = -1.5707964F;
    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.field_1256_a[5].field_1409_b = 4.0F - var3;

        for(int var7 = 0; var7 < 6; ++var7) {
            this.field_1256_a[var7].func_922_a(var6);
        }

    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
    }
}
