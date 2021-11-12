package net.minecraft.src;

public class EntitySkeleton extends EntityMob {
    private static final ItemStack field_4108_a;

    public EntitySkeleton(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/skeleton.png";
    }

    protected String func_6097_d() {
        return "mob.skeleton";
    }

    protected String func_6100_e() {
        return "mob.skeletonhurt";
    }

    protected String func_6098_f() {
        return "mob.skeletonhurt";
    }

    public void func_153_y() {
        if (this.field_9093_l.func_453_a()) {
            float var1 = this.func_108_b(1.0F);
            if (var1 > 0.5F && this.field_9093_l.func_497_g(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_321_m), MathHelper.func_584_b(this.field_320_n)) && this.field_9064_W.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
                this.field_9061_Z = 300;
            }
        }

        super.func_153_y();
    }

    protected void func_157_a(Entity var1, float var2) {
        if (var2 < 10.0F) {
            double var3 = var1.field_322_l - this.field_322_l;
            double var5 = var1.field_320_n - this.field_320_n;
            if (this.field_9103_aW == 0) {
                EntityArrow var7 = new EntityArrow(this.field_9093_l, this);
                ++var7.field_321_m;
                double var8 = var1.field_321_m + (double)var1.func_104_p() - 0.20000000298023224D - var7.field_321_m;
                float var10 = MathHelper.func_583_a(var3 * var3 + var5 * var5) * 0.2F;
                this.field_9093_l.func_506_a(this, "random.bow", 1.0F, 1.0F / (this.field_9064_W.nextFloat() * 0.4F + 0.8F));
                this.field_9093_l.func_526_a(var7);
                var7.func_177_a(var3, var8 + (double)var10, var5, 0.6F, 12.0F);
                this.field_9103_aW = 30;
            }

            this.field_316_r = (float)(Math.atan2(var5, var3) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.field_387_ah = true;
        }

    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
    }

    protected int func_149_g() {
        return Item.field_4148_j.field_234_aS;
    }

    protected void func_21047_g_() {
        int var1 = this.field_9064_W.nextInt(3);

        int var2;
        for(var2 = 0; var2 < var1; ++var2) {
            this.func_128_a(Item.field_4148_j.field_234_aS, 1);
        }

        var1 = this.field_9064_W.nextInt(3);

        for(var2 = 0; var2 < var1; ++var2) {
            this.func_128_a(Item.field_21096_aV.field_234_aS, 1);
        }

    }

    static {
        field_4108_a = new ItemStack(Item.field_4149_i, 1);
    }
}
