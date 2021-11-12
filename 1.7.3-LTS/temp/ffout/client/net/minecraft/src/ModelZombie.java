package net.minecraft.src;

public class ModelZombie extends ModelBiped {
    public void func_863_a(float var1, float var2, float var3, float var4, float var5, float var6) {
        super.func_863_a(var1, var2, var3, var4, var5, var6);
        float var7 = MathHelper.func_1106_a(this.field_1244_k * 3.1415927F);
        float var8 = MathHelper.func_1106_a((1.0F - (1.0F - this.field_1244_k) * (1.0F - this.field_1244_k)) * 3.1415927F);
        this.field_1283_d.field_1405_f = 0.0F;
        this.field_1282_e.field_1405_f = 0.0F;
        this.field_1283_d.field_1406_e = -(0.1F - var7 * 0.6F);
        this.field_1282_e.field_1406_e = 0.1F - var7 * 0.6F;
        this.field_1283_d.field_1407_d = -1.5707964F;
        this.field_1282_e.field_1407_d = -1.5707964F;
        ModelRenderer var10000 = this.field_1283_d;
        var10000.field_1407_d -= var7 * 1.2F - var8 * 0.4F;
        var10000 = this.field_1282_e;
        var10000.field_1407_d -= var7 * 1.2F - var8 * 0.4F;
        var10000 = this.field_1283_d;
        var10000.field_1405_f += MathHelper.func_1114_b(var3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.field_1282_e;
        var10000.field_1405_f -= MathHelper.func_1114_b(var3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.field_1283_d;
        var10000.field_1407_d += MathHelper.func_1106_a(var3 * 0.067F) * 0.05F;
        var10000 = this.field_1282_e;
        var10000.field_1407_d -= MathHelper.func_1106_a(var3 * 0.067F) * 0.05F;
    }
}
