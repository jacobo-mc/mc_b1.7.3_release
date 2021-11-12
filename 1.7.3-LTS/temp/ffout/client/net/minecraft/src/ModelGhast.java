package net.minecraft.src;

import java.util.Random;

public class ModelGhast extends ModelBase {
    ModelRenderer field_4258_a;
    ModelRenderer[] field_4257_b = new ModelRenderer[9];

    public ModelGhast() {
        byte var1 = -16;
        this.field_4258_a = new ModelRenderer(0, 0);
        this.field_4258_a.func_921_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
        ModelRenderer var10000 = this.field_4258_a;
        var10000.field_1409_b += (float)(24 + var1);
        Random var2 = new Random(1660L);

        for(int var3 = 0; var3 < this.field_4257_b.length; ++var3) {
            this.field_4257_b[var3] = new ModelRenderer(0, 0);
            float var4 = (((float)(var3 % 3) - (float)(var3 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
            float var5 = ((float)(var3 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
            int var6 = var2.nextInt(7) + 8;
            this.field_4257_b[var3].func_921_a(-1.0F, 0.0F, -1.0F, 2, var6, 2);
            this.field_4257_b[var3].field_1410_a = var4;
            this.field_4257_b[var3].field_1408_c = var5;
            this.field_4257_b[var3].field_1409_b = (float)(31 + var1);
        }

    }

    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        for(int var7 = 0; var7 < this.field_4257_b.length; ++var7) {
            this.field_4257_b[var7].field_1407_d = 0.2F * MathHelper.func_1106_a(var3 * 0.3F + (float)var7) + 0.4F;
        }

    }

    public void func_864_b(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.func_863_a(var1, var2, var3, var4, var5, var6);
        this.field_4258_a.func_922_a(var6);

        for(int var7 = 0; var7 < this.field_4257_b.length; ++var7) {
            this.field_4257_b[var7].func_922_a(var6);
        }

    }
}
