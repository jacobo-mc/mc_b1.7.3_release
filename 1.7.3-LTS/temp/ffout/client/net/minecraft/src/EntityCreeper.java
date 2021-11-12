package net.minecraft.src;

public class EntityCreeper extends EntityMob {
    int field_764_a;
    int field_763_b;

    public EntityCreeper(World var1) {
        super(var1);
        this.field_9357_z = "/mob/creeper.png";
    }

    protected void func_21057_b() {
        super.func_21057_b();
        this.field_21064_bx.func_21124_a(16, -1);
        this.field_21064_bx.func_21124_a(17, (byte)0);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        if (this.field_21064_bx.func_21130_a(17) == 1) {
            var1.func_748_a("powered", true);
        }

    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.field_21064_bx.func_21129_b(17, (byte)(var1.func_760_m("powered") ? 1 : 0));
    }

    protected void func_28022_b(Entity var1, float var2) {
        if (!this.field_615_ag.field_1026_y) {
            if (this.field_764_a > 0) {
                this.func_21090_e(-1);
                --this.field_764_a;
                if (this.field_764_a < 0) {
                    this.field_764_a = 0;
                }
            }

        }
    }

    public void func_370_e_() {
        this.field_763_b = this.field_764_a;
        if (this.field_615_ag.field_1026_y) {
            int var1 = this.func_21091_q();
            if (var1 > 0 && this.field_764_a == 0) {
                this.field_615_ag.func_623_a(this, "random.fuse", 1.0F, 0.5F);
            }

            this.field_764_a += var1;
            if (this.field_764_a < 0) {
                this.field_764_a = 0;
            }

            if (this.field_764_a >= 30) {
                this.field_764_a = 30;
            }
        }

        super.func_370_e_();
        if (this.field_751_f == null && this.field_764_a > 0) {
            this.func_21090_e(-1);
            --this.field_764_a;
            if (this.field_764_a < 0) {
                this.field_764_a = 0;
            }
        }

    }

    protected String func_6394_f_() {
        return "mob.creeper";
    }

    protected String func_6390_f() {
        return "mob.creeperdeath";
    }

    public void func_419_b(Entity var1) {
        super.func_419_b(var1);
        if (var1 instanceof EntitySkeleton) {
            this.func_367_b(Item.field_293_aQ.field_291_aS + this.field_9312_bd.nextInt(2), 1);
        }

    }

    protected void func_437_a(Entity var1, float var2) {
        if (!this.field_615_ag.field_1026_y) {
            int var3 = this.func_21091_q();
            if (var3 <= 0 && var2 < 3.0F || var3 > 0 && var2 < 7.0F) {
                if (this.field_764_a == 0) {
                    this.field_615_ag.func_623_a(this, "random.fuse", 1.0F, 0.5F);
                }

                this.func_21090_e(1);
                ++this.field_764_a;
                if (this.field_764_a >= 30) {
                    if (this.func_27022_s()) {
                        this.field_615_ag.func_12243_a(this, this.field_611_ak, this.field_610_al, this.field_609_am, 6.0F);
                    } else {
                        this.field_615_ag.func_12243_a(this, this.field_611_ak, this.field_610_al, this.field_609_am, 3.0F);
                    }

                    this.func_395_F();
                }

                this.field_750_g = true;
            } else {
                this.func_21090_e(-1);
                --this.field_764_a;
                if (this.field_764_a < 0) {
                    this.field_764_a = 0;
                }
            }

        }
    }

    public boolean func_27022_s() {
        return this.field_21064_bx.func_21130_a(17) == 1;
    }

    public float func_440_b(float var1) {
        return ((float)this.field_763_b + (float)(this.field_764_a - this.field_763_b) * var1) / 28.0F;
    }

    protected int func_422_g() {
        return Item.field_250_K.field_291_aS;
    }

    private int func_21091_q() {
        return this.field_21064_bx.func_21130_a(16);
    }

    private void func_21090_e(int var1) {
        this.field_21064_bx.func_21129_b(16, (byte)var1);
    }

    public void func_27014_a(EntityLightningBolt var1) {
        super.func_27014_a(var1);
        this.field_21064_bx.func_21129_b(17, (byte)1);
    }
}
