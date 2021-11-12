package net.minecraft.src;

public class EntityPortalFX extends EntityFX {
    private float field_4083_a;
    private double field_4086_p;
    private double field_4085_q;
    private double field_4084_r;

    public EntityPortalFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.field_608_an = var8;
        this.field_607_ao = var10;
        this.field_606_ap = var12;
        this.field_4086_p = this.field_611_ak = var2;
        this.field_4085_q = this.field_610_al = var4;
        this.field_4084_r = this.field_609_am = var6;
        float var14 = this.field_9312_bd.nextFloat() * 0.6F + 0.4F;
        this.field_4083_a = this.field_665_g = this.field_9312_bd.nextFloat() * 0.2F + 0.5F;
        this.field_663_i = this.field_662_j = this.field_661_k = 1.0F * var14;
        this.field_662_j *= 0.3F;
        this.field_663_i *= 0.9F;
        this.field_666_f = (int)(Math.random() * 10.0D) + 40;
        this.field_9314_ba = true;
        this.field_670_b = (int)(Math.random() * 8.0D);
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.field_20923_e + var2) / (float)this.field_666_f;
        var8 = 1.0F - var8;
        var8 *= var8;
        var8 = 1.0F - var8;
        this.field_665_g = this.field_4083_a * var8;
        super.func_406_a(var1, var2, var3, var4, var5, var6, var7);
    }

    public float func_382_a(float var1) {
        float var2 = super.func_382_a(var1);
        float var3 = (float)this.field_20923_e / (float)this.field_666_f;
        var3 *= var3;
        var3 *= var3;
        return var2 * (1.0F - var3) + var3;
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        float var1 = (float)this.field_20923_e / (float)this.field_666_f;
        float var2 = var1;
        var1 = -var1 + var1 * var1 * 2.0F;
        var1 = 1.0F - var1;
        this.field_611_ak = this.field_4086_p + this.field_608_an * (double)var1;
        this.field_610_al = this.field_4085_q + this.field_607_ao * (double)var1 + (double)(1.0F - var2);
        this.field_609_am = this.field_4084_r + this.field_606_ap * (double)var1;
        if (this.field_20923_e++ >= this.field_666_f) {
            this.func_395_F();
        }

    }
}
