package net.minecraft.src;

import java.util.List;

public class EntityLightningBolt extends EntityWeatherEffect {
    private int field_27018_b;
    public long field_27019_a = 0L;
    private int field_27020_c;

    public EntityLightningBolt(World var1, double var2, double var4, double var6) {
        super(var1);
        this.func_107_c(var2, var4, var6, 0.0F, 0.0F);
        this.field_27018_b = 2;
        this.field_27019_a = this.field_9064_W.nextLong();
        this.field_27020_c = this.field_9064_W.nextInt(3) + 1;
        if (var1.field_804_l >= 2 && var1.func_21118_a(MathHelper.func_584_b(var2), MathHelper.func_584_b(var4), MathHelper.func_584_b(var6), 10)) {
            int var8 = MathHelper.func_584_b(var2);
            int var9 = MathHelper.func_584_b(var4);
            int var10 = MathHelper.func_584_b(var6);
            if (var1.func_444_a(var8, var9, var10) == 0 && Block.field_599_as.func_259_a(var1, var8, var9, var10)) {
                var1.func_508_d(var8, var9, var10, Block.field_599_as.field_573_bc);
            }

            for(var8 = 0; var8 < 4; ++var8) {
                var9 = MathHelper.func_584_b(var2) + this.field_9064_W.nextInt(3) - 1;
                var10 = MathHelper.func_584_b(var4) + this.field_9064_W.nextInt(3) - 1;
                int var11 = MathHelper.func_584_b(var6) + this.field_9064_W.nextInt(3) - 1;
                if (var1.func_444_a(var9, var10, var11) == 0 && Block.field_599_as.func_259_a(var1, var9, var10, var11)) {
                    var1.func_508_d(var9, var10, var11, Block.field_599_as.field_573_bc);
                }
            }
        }

    }

    public void func_106_b_() {
        super.func_106_b_();
        if (this.field_27018_b == 2) {
            this.field_9093_l.func_502_a(this.field_322_l, this.field_321_m, this.field_320_n, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_9064_W.nextFloat() * 0.2F);
            this.field_9093_l.func_502_a(this.field_322_l, this.field_321_m, this.field_320_n, "random.explode", 2.0F, 0.5F + this.field_9064_W.nextFloat() * 0.2F);
        }

        --this.field_27018_b;
        if (this.field_27018_b < 0) {
            if (this.field_27020_c == 0) {
                this.func_118_j();
            } else if (this.field_27018_b < -this.field_9064_W.nextInt(10)) {
                --this.field_27020_c;
                this.field_27018_b = 1;
                this.field_27019_a = this.field_9064_W.nextLong();
                if (this.field_9093_l.func_21118_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n), 10)) {
                    int var1 = MathHelper.func_584_b(this.field_322_l);
                    int var2 = MathHelper.func_584_b(this.field_321_m);
                    int var3 = MathHelper.func_584_b(this.field_320_n);
                    if (this.field_9093_l.func_444_a(var1, var2, var3) == 0 && Block.field_599_as.func_259_a(this.field_9093_l, var1, var2, var3)) {
                        this.field_9093_l.func_508_d(var1, var2, var3, Block.field_599_as.field_573_bc);
                    }
                }
            }
        }

        if (this.field_27018_b >= 0) {
            double var6 = 3.0D;
            List var7 = this.field_9093_l.func_450_b(this, AxisAlignedBB.func_693_b(this.field_322_l - var6, this.field_321_m - var6, this.field_320_n - var6, this.field_322_l + var6, this.field_321_m + 6.0D + var6, this.field_320_n + var6));

            for(int var4 = 0; var4 < var7.size(); ++var4) {
                Entity var5 = (Entity)var7.get(var4);
                var5.func_27009_a(this);
            }

            this.field_9093_l.field_27080_i = 2;
        }

    }

    protected void func_21044_a() {
    }

    protected void func_99_b(NBTTagCompound var1) {
    }

    protected void func_97_a(NBTTagCompound var1) {
    }
}
