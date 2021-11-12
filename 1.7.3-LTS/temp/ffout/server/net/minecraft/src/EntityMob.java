package net.minecraft.src;

public class EntityMob extends EntityCreature implements IMob {
    protected int field_404_af = 2;

    public EntityMob(World var1) {
        super(var1);
        this.field_9109_aQ = 20;
    }

    public void func_153_y() {
        float var1 = this.func_108_b(1.0F);
        if (var1 > 0.5F) {
            this.field_9132_bn += 2;
        }

        super.func_153_y();
    }

    public void func_106_b_() {
        super.func_106_b_();
        if (!this.field_9093_l.field_792_x && this.field_9093_l.field_804_l == 0) {
            this.func_118_j();
        }

    }

    protected Entity func_158_i() {
        EntityPlayer var1 = this.field_9093_l.func_472_a(this, 16.0D);
        return var1 != null && this.func_145_g(var1) ? var1 : null;
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (super.func_121_a(var1, var2)) {
            if (this.field_328_f != var1 && this.field_327_g != var1) {
                if (var1 != this) {
                    this.field_389_ag = var1;
                }

                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected void func_157_a(Entity var1, float var2) {
        if (this.field_9103_aW <= 0 && var2 < 2.0F && var1.field_312_v.field_968_e > this.field_312_v.field_963_b && var1.field_312_v.field_963_b < this.field_312_v.field_968_e) {
            this.field_9103_aW = 20;
            var1.func_121_a(this, this.field_404_af);
        }

    }

    protected float func_159_a(int var1, int var2, int var3) {
        return 0.5F - this.field_9093_l.func_455_j(var1, var2, var3);
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    public boolean func_155_a() {
        int var1 = MathHelper.func_584_b(this.field_322_l);
        int var2 = MathHelper.func_584_b(this.field_312_v.field_963_b);
        int var3 = MathHelper.func_584_b(this.field_320_n);
        if (this.field_9093_l.func_512_a(EnumSkyBlock.Sky, var1, var2, var3) > this.field_9064_W.nextInt(32)) {
            return false;
        } else {
            int var4 = this.field_9093_l.func_495_h(var1, var2, var3);
            if (this.field_9093_l.func_27067_u()) {
                int var5 = this.field_9093_l.field_811_e;
                this.field_9093_l.field_811_e = 10;
                var4 = this.field_9093_l.func_495_h(var1, var2, var3);
                this.field_9093_l.field_811_e = var5;
            }

            return var4 <= this.field_9064_W.nextInt(8) && super.func_155_a();
        }
    }
}
