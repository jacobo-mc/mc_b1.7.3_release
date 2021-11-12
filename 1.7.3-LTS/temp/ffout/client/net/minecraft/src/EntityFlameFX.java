package net.minecraft.src;

public class EntityFlameFX extends EntityFX {
    private float field_672_a;

    public EntityFlameFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.field_608_an = this.field_608_an * 0.009999999776482582D + var8;
        this.field_607_ao = this.field_607_ao * 0.009999999776482582D + var10;
        this.field_606_ap = this.field_606_ap * 0.009999999776482582D + var12;
        double var10000 = var2 + (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.05F);
        var10000 = var4 + (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.05F);
        var10000 = var6 + (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.05F);
        this.field_672_a = this.field_665_g;
        this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
        this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        this.field_9314_ba = true;
        this.field_670_b = 48;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.field_20923_e + var2) / (float)this.field_666_f;
        this.field_665_g = this.field_672_a * (1.0F - var8 * var8 * 0.5F);
        super.func_406_a(var1, var2, var3, var4, var5, var6, var7);
    }

    public float func_382_a(float var1) {
        float var2 = ((float)this.field_20923_e + var1) / (float)this.field_666_f;
        if (var2 < 0.0F) {
            var2 = 0.0F;
        }

        if (var2 > 1.0F) {
            var2 = 1.0F;
        }

        float var3 = super.func_382_a(var1);
        return var3 * var2 + (1.0F - var2);
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        if (this.field_20923_e++ >= this.field_666_f) {
            this.func_395_F();
        }

        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        this.field_608_an *= 0.9599999785423279D;
        this.field_607_ao *= 0.9599999785423279D;
        this.field_606_ap *= 0.9599999785423279D;
        if (this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

    }
}
