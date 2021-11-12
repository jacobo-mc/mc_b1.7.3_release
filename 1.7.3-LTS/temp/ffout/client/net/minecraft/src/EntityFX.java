package net.minecraft.src;

public class EntityFX extends Entity {
    protected int field_670_b;
    protected float field_669_c;
    protected float field_668_d;
    protected int field_20923_e = 0;
    protected int field_666_f = 0;
    protected float field_665_g;
    protected float field_664_h;
    protected float field_663_i;
    protected float field_662_j;
    protected float field_661_k;
    public static double field_660_l;
    public static double field_659_m;
    public static double field_658_n;

    public EntityFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1);
        this.func_371_a(0.2F, 0.2F);
        this.field_9292_aO = this.field_643_aD / 2.0F;
        this.func_347_a(var2, var4, var6);
        this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
        this.field_608_an = var8 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        this.field_607_ao = var10 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        this.field_606_ap = var12 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        float var14 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
        float var15 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_607_ao * this.field_607_ao + this.field_606_ap * this.field_606_ap);
        this.field_608_an = this.field_608_an / (double)var15 * (double)var14 * 0.4000000059604645D;
        this.field_607_ao = this.field_607_ao / (double)var15 * (double)var14 * 0.4000000059604645D + 0.10000000149011612D;
        this.field_606_ap = this.field_606_ap / (double)var15 * (double)var14 * 0.4000000059604645D;
        this.field_669_c = this.field_9312_bd.nextFloat() * 3.0F;
        this.field_668_d = this.field_9312_bd.nextFloat() * 3.0F;
        this.field_665_g = (this.field_9312_bd.nextFloat() * 0.5F + 0.5F) * 2.0F;
        this.field_666_f = (int)(4.0F / (this.field_9312_bd.nextFloat() * 0.9F + 0.1F));
        this.field_20923_e = 0;
    }

    public EntityFX func_407_b(float var1) {
        this.field_608_an *= (double)var1;
        this.field_607_ao = (this.field_607_ao - 0.10000000149011612D) * (double)var1 + 0.10000000149011612D;
        this.field_606_ap *= (double)var1;
        return this;
    }

    public EntityFX func_405_d(float var1) {
        this.func_371_a(0.2F * var1, 0.2F * var1);
        this.field_665_g *= var1;
        return this;
    }

    protected boolean func_25021_m() {
        return false;
    }

    protected void func_21057_b() {
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        if (this.field_20923_e++ >= this.field_666_f) {
            this.func_395_F();
        }

        this.field_607_ao -= 0.04D * (double)this.field_664_h;
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        this.field_608_an *= 0.9800000190734863D;
        this.field_607_ao *= 0.9800000190734863D;
        this.field_606_ap *= 0.9800000190734863D;
        if (this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = (float)(this.field_670_b % 16) / 16.0F;
        float var9 = var8 + 0.0624375F;
        float var10 = (float)(this.field_670_b / 16) / 16.0F;
        float var11 = var10 + 0.0624375F;
        float var12 = 0.1F * this.field_665_g;
        float var13 = (float)(this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)var2 - field_660_l);
        float var14 = (float)(this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)var2 - field_659_m);
        float var15 = (float)(this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)var2 - field_658_n);
        float var16 = this.func_382_a(var2);
        var1.func_987_a(this.field_663_i * var16, this.field_662_j * var16, this.field_661_k * var16);
        var1.func_983_a((double)(var13 - var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 - var5 * var12 - var7 * var12), (double)var9, (double)var11);
        var1.func_983_a((double)(var13 - var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 - var5 * var12 + var7 * var12), (double)var9, (double)var10);
        var1.func_983_a((double)(var13 + var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 + var5 * var12 + var7 * var12), (double)var8, (double)var10);
        var1.func_983_a((double)(var13 + var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 + var5 * var12 - var7 * var12), (double)var8, (double)var11);
    }

    public int func_404_c() {
        return 0;
    }

    public void func_352_a(NBTTagCompound var1) {
    }

    public void func_357_b(NBTTagCompound var1) {
    }
}
