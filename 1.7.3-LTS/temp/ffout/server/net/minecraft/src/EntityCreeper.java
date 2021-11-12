package net.minecraft.src;

public class EntityCreeper extends EntityMob {
    int field_406_a;
    int field_405_b;

    public EntityCreeper(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/creeper.png";
    }

    protected void func_21044_a() {
        super.func_21044_a();
        this.field_21045_af.func_21153_a(16, -1);
        this.field_21045_af.func_21153_a(17, (byte)0);
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        if (this.field_21045_af.func_21156_a(17) == 1) {
            var1.func_393_a("powered", true);
        }

    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        this.field_21045_af.func_21155_b(17, (byte)(var1.func_402_l("powered") ? 1 : 0));
    }

    protected void func_28013_b(Entity var1, float var2) {
        if (!this.field_9093_l.field_792_x) {
            if (this.field_406_a > 0) {
                this.func_21049_a(-1);
                --this.field_406_a;
                if (this.field_406_a < 0) {
                    this.field_406_a = 0;
                }
            }

        }
    }

    public void func_106_b_() {
        this.field_405_b = this.field_406_a;
        if (this.field_9093_l.field_792_x) {
            int var1 = this.func_21048_K();
            if (var1 > 0 && this.field_406_a == 0) {
                this.field_9093_l.func_506_a(this, "random.fuse", 1.0F, 0.5F);
            }

            this.field_406_a += var1;
            if (this.field_406_a < 0) {
                this.field_406_a = 0;
            }

            if (this.field_406_a >= 30) {
                this.field_406_a = 30;
            }
        }

        super.func_106_b_();
        if (this.field_389_ag == null && this.field_406_a > 0) {
            this.func_21049_a(-1);
            --this.field_406_a;
            if (this.field_406_a < 0) {
                this.field_406_a = 0;
            }
        }

    }

    protected String func_6100_e() {
        return "mob.creeper";
    }

    protected String func_6098_f() {
        return "mob.creeperdeath";
    }

    public void func_142_f(Entity var1) {
        super.func_142_f(var1);
        if (var1 instanceof EntitySkeleton) {
            this.func_128_a(Item.field_236_aQ.field_234_aS + this.field_9064_W.nextInt(2), 1);
        }

    }

    protected void func_157_a(Entity var1, float var2) {
        if (!this.field_9093_l.field_792_x) {
            int var3 = this.func_21048_K();
            if (var3 <= 0 && var2 < 3.0F || var3 > 0 && var2 < 7.0F) {
                if (this.field_406_a == 0) {
                    this.field_9093_l.func_506_a(this, "random.fuse", 1.0F, 0.5F);
                }

                this.func_21049_a(1);
                ++this.field_406_a;
                if (this.field_406_a >= 30) {
                    if (this.func_27014_t()) {
                        this.field_9093_l.func_12013_a(this, this.field_322_l, this.field_321_m, this.field_320_n, 6.0F);
                    } else {
                        this.field_9093_l.func_12013_a(this, this.field_322_l, this.field_321_m, this.field_320_n, 3.0F);
                    }

                    this.func_118_j();
                }

                this.field_387_ah = true;
            } else {
                this.func_21049_a(-1);
                --this.field_406_a;
                if (this.field_406_a < 0) {
                    this.field_406_a = 0;
                }
            }

        }
    }

    public boolean func_27014_t() {
        return this.field_21045_af.func_21156_a(17) == 1;
    }

    protected int func_149_g() {
        return Item.field_193_K.field_234_aS;
    }

    private int func_21048_K() {
        return this.field_21045_af.func_21156_a(16);
    }

    private void func_21049_a(int var1) {
        this.field_21045_af.func_21155_b(16, (byte)var1);
    }

    public void func_27009_a(EntityLightningBolt var1) {
        super.func_27009_a(var1);
        this.field_21045_af.func_21155_b(17, (byte)1);
    }
}
