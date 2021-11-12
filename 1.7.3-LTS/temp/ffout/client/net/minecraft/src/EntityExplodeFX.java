package net.minecraft.src;

public class EntityExplodeFX extends EntityFX {
    public EntityExplodeFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.field_608_an = var8 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.field_607_ao = var10 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.field_606_ap = var12 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
        this.field_663_i = this.field_662_j = this.field_661_k = this.field_9312_bd.nextFloat() * 0.3F + 0.7F;
        this.field_665_g = this.field_9312_bd.nextFloat() * this.field_9312_bd.nextFloat() * 6.0F + 1.0F;
        this.field_666_f = (int)(16.0D / ((double)this.field_9312_bd.nextFloat() * 0.8D + 0.2D)) + 2;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        super.func_406_a(var1, var2, var3, var4, var5, var6, var7);
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        if (this.field_20923_e++ >= this.field_666_f) {
            this.func_395_F();
        }

        this.field_670_b = 7 - this.field_20923_e * 8 / this.field_666_f;
        this.field_607_ao += 0.004D;
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        this.field_608_an *= 0.8999999761581421D;
        this.field_607_ao *= 0.8999999761581421D;
        this.field_606_ap *= 0.8999999761581421D;
        if (this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

    }
}
