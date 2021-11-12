package net.minecraft.src;

public class EntityReddustFX extends EntityFX {
    float field_673_a;

    public EntityReddustFX(World var1, double var2, double var4, double var6, float var8, float var9, float var10) {
        this(var1, var2, var4, var6, 1.0F, var8, var9, var10);
    }

    public EntityReddustFX(World var1, double var2, double var4, double var6, float var8, float var9, float var10, float var11) {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.field_608_an *= 0.10000000149011612D;
        this.field_607_ao *= 0.10000000149011612D;
        this.field_606_ap *= 0.10000000149011612D;
        if (var9 == 0.0F) {
            var9 = 1.0F;
        }

        float var12 = (float)Math.random() * 0.4F + 0.6F;
        this.field_663_i = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * var9 * var12;
        this.field_662_j = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * var10 * var12;
        this.field_661_k = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * var11 * var12;
        this.field_665_g *= 0.75F;
        this.field_665_g *= var8;
        this.field_673_a = this.field_665_g;
        this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.field_666_f = (int)((float)this.field_666_f * var8);
        this.field_9314_ba = false;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.field_20923_e + var2) / (float)this.field_666_f * 32.0F;
        if (var8 < 0.0F) {
            var8 = 0.0F;
        }

        if (var8 > 1.0F) {
            var8 = 1.0F;
        }

        this.field_665_g = this.field_673_a * var8;
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
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        if (this.field_610_al == this.field_9284_au) {
            this.field_608_an *= 1.1D;
            this.field_606_ap *= 1.1D;
        }

        this.field_608_an *= 0.9599999785423279D;
        this.field_607_ao *= 0.9599999785423279D;
        this.field_606_ap *= 0.9599999785423279D;
        if (this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

    }
}
