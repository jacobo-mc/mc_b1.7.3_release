package net.minecraft.src;

public class EntityRainFX extends EntityFX {
    public EntityRainFX(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
        this.field_608_an *= 0.30000001192092896D;
        this.field_607_ao = (double)((float)Math.random() * 0.2F + 0.1F);
        this.field_606_ap *= 0.30000001192092896D;
        this.field_663_i = 1.0F;
        this.field_662_j = 1.0F;
        this.field_661_k = 1.0F;
        this.field_670_b = 19 + this.field_9312_bd.nextInt(4);
        this.func_371_a(0.01F, 0.01F);
        this.field_664_h = 0.06F;
        this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
    }

    public void func_406_a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        super.func_406_a(var1, var2, var3, var4, var5, var6, var7);
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        this.field_607_ao -= (double)this.field_664_h;
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        this.field_608_an *= 0.9800000190734863D;
        this.field_607_ao *= 0.9800000190734863D;
        this.field_606_ap *= 0.9800000190734863D;
        if (this.field_666_f-- <= 0) {
            this.func_395_F();
        }

        if (this.field_9298_aH) {
            if (Math.random() < 0.5D) {
                this.func_395_F();
            }

            this.field_608_an *= 0.699999988079071D;
            this.field_606_ap *= 0.699999988079071D;
        }

        Material var1 = this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
        if (var1.func_879_d() || var1.func_878_a()) {
            double var2 = (double)((float)(MathHelper.func_1108_b(this.field_610_al) + 1) - BlockFluid.func_288_b(this.field_615_ag.func_602_e(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am))));
            if (this.field_610_al < var2) {
                this.func_395_F();
            }
        }

    }
}
