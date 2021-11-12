package net.minecraft.src;

public class EntitySnowShovelFX extends EntityFX {
    float field_27017_a;

    public EntitySnowShovelFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        this(var1, var2, var4, var6, var8, var10, var12, 1.0F);
    }

    public EntitySnowShovelFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.field_608_an *= 0.10000000149011612D;
        this.field_607_ao *= 0.10000000149011612D;
        this.field_606_ap *= 0.10000000149011612D;
        this.field_608_an += var8;
        this.field_607_ao += var10;
        this.field_606_ap += var12;
        this.field_663_i = this.field_662_j = this.field_661_k = 1.0F - (float)(Math.random() * 0.30000001192092896D);
        this.field_665_g *= 0.75F;
        this.field_665_g *= var14;
        this.field_27017_a = this.field_665_g;
        this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.field_666_f = (int)((float)this.field_666_f * var14);
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

        this.field_665_g = this.field_27017_a * var8;
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
        this.field_607_ao -= 0.03D;
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        this.field_608_an *= 0.9900000095367432D;
        this.field_607_ao *= 0.9900000095367432D;
        this.field_606_ap *= 0.9900000095367432D;
        if (this.field_9298_aH) {
            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

    }
}
