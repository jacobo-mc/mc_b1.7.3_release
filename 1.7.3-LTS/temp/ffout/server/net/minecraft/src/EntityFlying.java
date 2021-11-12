package net.minecraft.src;

public class EntityFlying extends EntityLiving {
    public EntityFlying(World var1) {
        super(var1);
    }

    protected void func_114_a(float var1) {
    }

    public void func_148_c(float var1, float var2) {
        if (this.func_27011_Z()) {
            this.func_90_a(var1, var2, 0.02F);
            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            this.field_319_o *= 0.800000011920929D;
            this.field_318_p *= 0.800000011920929D;
            this.field_317_q *= 0.800000011920929D;
        } else if (this.func_112_q()) {
            this.func_90_a(var1, var2, 0.02F);
            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            this.field_319_o *= 0.5D;
            this.field_318_p *= 0.5D;
            this.field_317_q *= 0.5D;
        } else {
            float var3 = 0.91F;
            if (this.field_9086_A) {
                var3 = 0.54600006F;
                int var4 = this.field_9093_l.func_444_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_312_v.field_963_b) - 1, MathHelper.func_584_b(this.field_320_n));
                if (var4 > 0) {
                    var3 = Block.field_542_n[var4].field_552_bo * 0.91F;
                }
            }

            float var8 = 0.16277136F / (var3 * var3 * var3);
            this.func_90_a(var1, var2, this.field_9086_A ? 0.1F * var8 : 0.02F);
            var3 = 0.91F;
            if (this.field_9086_A) {
                var3 = 0.54600006F;
                int var5 = this.field_9093_l.func_444_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_312_v.field_963_b) - 1, MathHelper.func_584_b(this.field_320_n));
                if (var5 > 0) {
                    var3 = Block.field_542_n[var5].field_552_bo * 0.91F;
                }
            }

            this.func_88_c(this.field_319_o, this.field_318_p, this.field_317_q);
            this.field_319_o *= (double)var3;
            this.field_318_p *= (double)var3;
            this.field_317_q *= (double)var3;
        }

        this.field_9142_bc = this.field_9141_bd;
        double var10 = this.field_322_l - this.field_9092_m;
        double var9 = this.field_320_n - this.field_9090_o;
        float var7 = MathHelper.func_583_a(var10 * var10 + var9 * var9) * 4.0F;
        if (var7 > 1.0F) {
            var7 = 1.0F;
        }

        this.field_9141_bd += (var7 - this.field_9141_bd) * 0.4F;
        this.field_386_ba += this.field_9141_bd;
    }

    public boolean func_144_E() {
        return false;
    }
}
