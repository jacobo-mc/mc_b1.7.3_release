package net.minecraft.src;

public class EntitySlimeFX extends EntityFX {
    public EntitySlimeFX(World var1, double var2, double var4, double var6, Item var8) {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.field_670_b = var8.func_27009_a(0);
        this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
        this.field_664_h = Block.field_426_aV.field_357_bm;
        this.field_665_g /= 2.0F;
    }

    public int func_404_c() {
        return 2;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)(this.field_670_b % 16) + this.field_669_c / 4.0F) / 16.0F;
        float var9 = var8 + 0.015609375F;
        float var10 = ((float)(this.field_670_b / 16) + this.field_668_d / 4.0F) / 16.0F;
        float var11 = var10 + 0.015609375F;
        float var12 = 0.1F * this.field_665_g;
        float var13 = (float)(this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)var2 - field_660_l);
        float var14 = (float)(this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)var2 - field_659_m);
        float var15 = (float)(this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)var2 - field_658_n);
        float var16 = this.func_382_a(var2);
        var1.func_987_a(var16 * this.field_663_i, var16 * this.field_662_j, var16 * this.field_661_k);
        var1.func_983_a((double)(var13 - var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 - var5 * var12 - var7 * var12), (double)var8, (double)var11);
        var1.func_983_a((double)(var13 - var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 - var5 * var12 + var7 * var12), (double)var8, (double)var10);
        var1.func_983_a((double)(var13 + var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 + var5 * var12 + var7 * var12), (double)var9, (double)var10);
        var1.func_983_a((double)(var13 + var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 + var5 * var12 - var7 * var12), (double)var9, (double)var11);
    }
}
