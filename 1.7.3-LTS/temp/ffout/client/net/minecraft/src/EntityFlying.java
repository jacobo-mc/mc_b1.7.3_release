package net.minecraft.src;

public class EntityFlying extends EntityLiving {
    public EntityFlying(World var1) {
        super(var1);
    }

    protected void func_400_c(float var1) {
    }

    public void func_435_b(float var1, float var2) {
        if (this.func_27013_ag()) {
            this.func_351_a(var1, var2, 0.02F);
            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            this.field_608_an *= 0.800000011920929D;
            this.field_607_ao *= 0.800000011920929D;
            this.field_606_ap *= 0.800000011920929D;
        } else if (this.func_359_G()) {
            this.func_351_a(var1, var2, 0.02F);
            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            this.field_608_an *= 0.5D;
            this.field_607_ao *= 0.5D;
            this.field_606_ap *= 0.5D;
        } else {
            float var3 = 0.91F;
            if (this.field_9298_aH) {
                var3 = 0.54600006F;
                int var4 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
                if (var4 > 0) {
                    var3 = Block.field_345_n[var4].field_355_bo * 0.91F;
                }
            }

            float var8 = 0.16277136F / (var3 * var3 * var3);
            this.func_351_a(var1, var2, this.field_9298_aH ? 0.1F * var8 : 0.02F);
            var3 = 0.91F;
            if (this.field_9298_aH) {
                var3 = 0.54600006F;
                int var5 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
                if (var5 > 0) {
                    var3 = Block.field_345_n[var5].field_355_bo * 0.91F;
                }
            }

            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            this.field_608_an *= (double)var3;
            this.field_607_ao *= (double)var3;
            this.field_606_ap *= (double)var3;
        }

        this.field_705_Q = this.field_704_R;
        double var10 = this.field_611_ak - this.field_9285_at;
        double var9 = this.field_609_am - this.field_9283_av;
        float var7 = MathHelper.func_1109_a(var10 * var10 + var9 * var9) * 4.0F;
        if (var7 > 1.0F) {
            var7 = 1.0F;
        }

        this.field_704_R += (var7 - this.field_704_R) * 0.4F;
        this.field_703_S += this.field_704_R;
    }

    public boolean func_429_A() {
        return false;
    }
}
