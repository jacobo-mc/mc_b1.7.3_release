package net.minecraft.src;

public class EntitySkeleton extends EntityMob {
    private static final ItemStack field_4119_a;

    public EntitySkeleton(World var1) {
        super(var1);
        this.field_9357_z = "/mob/skeleton.png";
    }

    protected String func_6389_d() {
        return "mob.skeleton";
    }

    protected String func_6394_f_() {
        return "mob.skeletonhurt";
    }

    protected String func_6390_f() {
        return "mob.skeletonhurt";
    }

    public void func_425_j() {
        if (this.field_615_ag.func_624_b()) {
            float var1 = this.func_382_a(1.0F);
            if (var1 > 0.5F && this.field_615_ag.func_647_i(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) && this.field_9312_bd.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
                this.field_9309_bg = 300;
            }
        }

        super.func_425_j();
    }

    protected void func_437_a(Entity var1, float var2) {
        if (var2 < 10.0F) {
            double var3 = var1.field_611_ak - this.field_611_ak;
            double var5 = var1.field_609_am - this.field_609_am;
            if (this.field_9330_P == 0) {
                EntityArrow var7 = new EntityArrow(this.field_615_ag, this);
                ++var7.field_610_al;
                double var8 = var1.field_610_al + (double)var1.func_373_s() - 0.20000000298023224D - var7.field_610_al;
                float var10 = MathHelper.func_1109_a(var3 * var3 + var5 * var5) * 0.2F;
                this.field_615_ag.func_623_a(this, "random.bow", 1.0F, 1.0F / (this.field_9312_bd.nextFloat() * 0.4F + 0.8F));
                this.field_615_ag.func_674_a(var7);
                var7.func_408_a(var3, var8 + (double)var10, var5, 0.6F, 12.0F);
                this.field_9330_P = 30;
            }

            this.field_605_aq = (float)(Math.atan2(var5, var3) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.field_750_g = true;
        }

    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
    }

    protected int func_422_g() {
        return Item.field_226_j.field_291_aS;
    }

    protected void func_21066_o() {
        int var1 = this.field_9312_bd.nextInt(3);

        int var2;
        for(var2 = 0; var2 < var1; ++var2) {
            this.func_367_b(Item.field_226_j.field_291_aS, 1);
        }

        var1 = this.field_9312_bd.nextInt(3);

        for(var2 = 0; var2 < var1; ++var2) {
            this.func_367_b(Item.field_21020_aV.field_291_aS, 1);
        }

    }

    public ItemStack func_4045_l() {
        return field_4119_a;
    }

    static {
        field_4119_a = new ItemStack(Item.field_227_i, 1);
    }
}
