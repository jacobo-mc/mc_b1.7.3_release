package net.minecraft.src;

public class EntityBubbleFX extends EntityFX {
    public EntityBubbleFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.field_663_i = 1.0F;
        this.field_662_j = 1.0F;
        this.field_661_k = 1.0F;
        this.field_670_b = 32;
        this.func_371_a(0.02F, 0.02F);
        this.field_665_g *= this.field_9312_bd.nextFloat() * 0.6F + 0.2F;
        this.field_608_an = var8 * 0.20000000298023224D + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
        this.field_607_ao = var10 * 0.20000000298023224D + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
        this.field_606_ap = var12 * 0.20000000298023224D + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
        this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
    }

    public void func_370_e_() {
        this.field_9285_at = this.field_611_ak;
        this.field_9284_au = this.field_610_al;
        this.field_9283_av = this.field_609_am;
        this.field_607_ao += 0.002D;
        this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
        this.field_608_an *= 0.8500000238418579D;
        this.field_607_ao *= 0.8500000238418579D;
        this.field_606_ap *= 0.8500000238418579D;
        if (this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) != Material.field_1332_f) {
            this.func_395_F();
        }

        if (this.field_666_f-- <= 0) {
            this.func_395_F();
        }

    }
}
