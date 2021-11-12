package net.minecraft.src;

public class EntityNoteFX extends EntityFX {
    float field_21065_a;

    public EntityNoteFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        this(var1, var2, var4, var6, var8, var10, var12, 2.0F);
    }

    public EntityNoteFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14) {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.field_608_an *= 0.009999999776482582D;
        this.field_607_ao *= 0.009999999776482582D;
        this.field_606_ap *= 0.009999999776482582D;
        this.field_607_ao += 0.2D;
        this.field_663_i = MathHelper.func_1106_a(((float)var8 + 0.0F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
        this.field_662_j = MathHelper.func_1106_a(((float)var8 + 0.33333334F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
        this.field_661_k = MathHelper.func_1106_a(((float)var8 + 0.6666667F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
        this.field_665_g *= 0.75F;
        this.field_665_g *= var14;
        this.field_21065_a = this.field_665_g;
        this.field_666_f = 6;
        this.field_9314_ba = false;
        this.field_670_b = 64;
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        float var8 = ((float)this.field_20923_e + var2) / (float)this.field_666_f * 32.0F;
        if (var8 < 0.0F) {
            var8 = 0.0F;
        }

        if (var8 > 1.0F) {
            var8 = 1.0F;
        }

        this.field_665_g = this.field_21065_a * var8;
        super.func_406_a(var1, var2, var3, var4, var5, var6, var7);
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        if (this.field_20923_e++ >= this.field_666_f) {
            this.func_395_F();
        }

        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        if (this.field_610_al == this.field_9284_au) {
            this.field_608_an *= 1.1D;
            this.field_606_ap *= 1.1D;
        }

        this.field_608_an *= 0.6600000262260437D;
        this.field_607_ao *= 0.6600000262260437D;
        this.field_606_ap *= 0.6600000262260437D;
        if (this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

    }
}
