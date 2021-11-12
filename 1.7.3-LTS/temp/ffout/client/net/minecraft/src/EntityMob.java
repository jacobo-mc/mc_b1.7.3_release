package net.minecraft.src;

public class EntityMob extends EntityCreature implements IMob {
    protected int field_762_e = 2;

    public EntityMob(World var1) {
        super(var1);
        this.field_9337_J = 20;
    }

    public void func_425_j() {
        float var1 = this.func_382_a(1.0F);
        if (var1 > 0.5F) {
            this.field_9344_ag += 2;
        }

        super.func_425_j();
    }

    public void func_370_e_() {
        super.func_370_e_();
        if (!this.field_615_ag.field_1026_y && this.field_615_ag.field_1039_l == 0) {
            this.func_395_F();
        }

    }

    protected Entity func_438_i() {
        EntityPlayer var1 = this.field_615_ag.func_609_a(this, 16.0D);
        return var1 != null && this.func_420_c(var1) ? var1 : null;
    }

    public boolean func_396_a(Entity var1, int var2) {
        if (super.func_396_a(var1, var2)) {
            if (this.field_617_ae != var1 && this.field_616_af != var1) {
                if (var1 != this) {
                    this.field_751_f = var1;
                }

                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected void func_437_a(Entity var1, float var2) {
        if (this.field_9330_P <= 0 && var2 < 2.0F && var1.field_601_au.field_1702_e > this.field_601_au.field_1697_b && var1.field_601_au.field_1697_b < this.field_601_au.field_1702_e) {
            this.field_9330_P = 20;
            var1.func_396_a(this, this.field_762_e);
        }

    }

    protected float func_439_a(int var1, int var2, int var3) {
        return 0.5F - this.field_615_ag.func_598_c(var1, var2, var3);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    public boolean func_433_a() {
        int var1 = MathHelper.func_1108_b(this.field_611_ak);
        int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
        int var3 = MathHelper.func_1108_b(this.field_609_am);
        if (this.field_615_ag.func_641_a(EnumSkyBlock.Sky, var1, var2, var3) > this.field_9312_bd.nextInt(32)) {
            return false;
        } else {
            int var4 = this.field_615_ag.func_618_j(var1, var2, var3);
            if (this.field_615_ag.func_27160_B()) {
                int var5 = this.field_615_ag.field_1046_e;
                this.field_615_ag.field_1046_e = 10;
                var4 = this.field_615_ag.func_618_j(var1, var2, var3);
                this.field_615_ag.field_1046_e = var5;
            }

            return var4 <= this.field_9312_bd.nextInt(8) && super.func_433_a();
        }
    }
}
