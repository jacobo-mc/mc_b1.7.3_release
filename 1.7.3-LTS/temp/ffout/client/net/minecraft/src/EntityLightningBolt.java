package net.minecraft.src;

import java.util.List;

public class EntityLightningBolt extends EntityWeatherEffect {
    private int field_27028_b;
    public long field_27029_a = 0L;
    private int field_27030_c;

    public EntityLightningBolt(World var1, double var2, double var4, double var6) {
        super(var1);
        this.func_365_c(var2, var4, var6, 0.0F, 0.0F);
        this.field_27028_b = 2;
        this.field_27029_a = this.field_9312_bd.nextLong();
        this.field_27030_c = this.field_9312_bd.nextInt(3) + 1;
        if (var1.field_1039_l >= 2 && var1.func_21117_a(MathHelper.func_1108_b(var2), MathHelper.func_1108_b(var4), MathHelper.func_1108_b(var6), 10)) {
            int var8 = MathHelper.func_1108_b(var2);
            int var9 = MathHelper.func_1108_b(var4);
            int var10 = MathHelper.func_1108_b(var6);
            if (var1.func_600_a(var8, var9, var10) == 0 && Block.field_402_as.func_243_a(var1, var8, var9, var10)) {
                var1.func_690_d(var8, var9, var10, Block.field_402_as.field_376_bc);
            }

            for(var8 = 0; var8 < 4; ++var8) {
                var9 = MathHelper.func_1108_b(var2) + this.field_9312_bd.nextInt(3) - 1;
                var10 = MathHelper.func_1108_b(var4) + this.field_9312_bd.nextInt(3) - 1;
                int var11 = MathHelper.func_1108_b(var6) + this.field_9312_bd.nextInt(3) - 1;
                if (var1.func_600_a(var9, var10, var11) == 0 && Block.field_402_as.func_243_a(var1, var9, var10, var11)) {
                    var1.func_690_d(var9, var10, var11, Block.field_402_as.field_376_bc);
                }
            }
        }

    }

    public void func_370_e_() {
        super.func_370_e_();
        if (this.field_27028_b == 2) {
            this.field_615_ag.func_684_a(this.field_611_ak, this.field_610_al, this.field_609_am, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_9312_bd.nextFloat() * 0.2F);
            this.field_615_ag.func_684_a(this.field_611_ak, this.field_610_al, this.field_609_am, "random.explode", 2.0F, 0.5F + this.field_9312_bd.nextFloat() * 0.2F);
        }

        --this.field_27028_b;
        if (this.field_27028_b < 0) {
            if (this.field_27030_c == 0) {
                this.func_395_F();
            } else if (this.field_27028_b < -this.field_9312_bd.nextInt(10)) {
                --this.field_27030_c;
                this.field_27028_b = 1;
                this.field_27029_a = this.field_9312_bd.nextLong();
                if (this.field_615_ag.func_21117_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am), 10)) {
                    int var1 = MathHelper.func_1108_b(this.field_611_ak);
                    int var2 = MathHelper.func_1108_b(this.field_610_al);
                    int var3 = MathHelper.func_1108_b(this.field_609_am);
                    if (this.field_615_ag.func_600_a(var1, var2, var3) == 0 && Block.field_402_as.func_243_a(this.field_615_ag, var1, var2, var3)) {
                        this.field_615_ag.func_690_d(var1, var2, var3, Block.field_402_as.field_376_bc);
                    }
                }
            }
        }

        if (this.field_27028_b >= 0) {
            double var6 = 3.0D;
            List var7 = this.field_615_ag.func_659_b(this, AxisAlignedBB.func_1161_b(this.field_611_ak - var6, this.field_610_al - var6, this.field_609_am - var6, this.field_611_ak + var6, this.field_610_al + 6.0D + var6, this.field_609_am + var6));

            for(int var4 = 0; var4 < var7.size(); ++var4) {
                Entity var5 = (Entity)var7.get(var4);
                var5.func_27014_a(this);
            }

            this.field_615_ag.field_27172_i = 2;
        }

    }

    protected void func_21057_b() {
    }

    protected void func_357_b(NBTTagCompound var1) {
    }

    protected void func_352_a(NBTTagCompound var1) {
    }

    public boolean func_390_a(Vec3D var1) {
        return this.field_27028_b >= 0;
    }
}
