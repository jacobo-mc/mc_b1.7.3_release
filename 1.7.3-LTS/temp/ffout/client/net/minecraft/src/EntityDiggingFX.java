package net.minecraft.src;

public class EntityDiggingFX extends EntityFX {
    private Block field_4082_a;
    private int field_32001_o = 0;

    public EntityDiggingFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12, Block var14, int var15, int var16) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.field_4082_a = var14;
        this.field_670_b = var14.func_232_a(0, var16);
        this.field_664_h = var14.field_357_bm;
        this.field_663_i = this.field_662_j = this.field_661_k = 0.6F;
        this.field_665_g /= 2.0F;
        this.field_32001_o = var15;
    }

    public EntityDiggingFX func_4041_a(int var1, int var2, int var3) {
        if (this.field_4082_a == Block.field_337_v) {
            return this;
        } else {
            int var4 = this.field_4082_a.func_207_d(this.field_615_ag, var1, var2, var3);
            this.field_663_i *= (float)(var4 >> 16 & 255) / 255.0F;
            this.field_662_j *= (float)(var4 >> 8 & 255) / 255.0F;
            this.field_661_k *= (float)(var4 & 255) / 255.0F;
            return this;
        }
    }

    public int func_404_c() {
        return 1;
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
