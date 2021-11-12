package net.minecraft.src;

public class EntitySlime extends EntityLiving implements IMob {
    public float field_401_a;
    public float field_400_b;
    private int field_402_ae = 0;

    public EntitySlime(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/slime.png";
        int var2 = 1 << this.field_9064_W.nextInt(3);
        this.field_9076_H = 0.0F;
        this.field_402_ae = this.field_9064_W.nextInt(20) + 10;
        this.func_160_c(var2);
    }

    protected void func_21044_a() {
        super.func_21044_a();
        this.field_21045_af.func_21153_a(16, new Byte((byte)1));
    }

    public void func_160_c(int var1) {
        this.field_21045_af.func_21155_b(16, new Byte((byte)var1));
        this.func_113_a(0.6F * (float)var1, 0.6F * (float)var1);
        this.field_9109_aQ = var1 * var1;
        this.func_86_a(this.field_322_l, this.field_321_m, this.field_320_n);
    }

    public int func_25027_m() {
        return this.field_21045_af.func_21156_a(16);
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        var1.func_405_a("Size", this.func_25027_m() - 1);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        this.func_160_c(var1.func_395_d("Size") + 1);
    }

    public void func_106_b_() {
        this.field_400_b = this.field_401_a;
        boolean var1 = this.field_9086_A;
        super.func_106_b_();
        if (this.field_9086_A && !var1) {
            int var2 = this.func_25027_m();

            for(int var3 = 0; var3 < var2 * 8; ++var3) {
                float var4 = this.field_9064_W.nextFloat() * 3.1415927F * 2.0F;
                float var5 = this.field_9064_W.nextFloat() * 0.5F + 0.5F;
                float var6 = MathHelper.func_585_a(var4) * (float)var2 * 0.5F * var5;
                float var7 = MathHelper.func_582_b(var4) * (float)var2 * 0.5F * var5;
                this.field_9093_l.func_514_a("slime", this.field_322_l + (double)var6, this.field_312_v.field_963_b, this.field_320_n + (double)var7, 0.0D, 0.0D, 0.0D);
            }

            if (var2 > 2) {
                this.field_9093_l.func_506_a(this, "mob.slime", this.func_6102_h(), ((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.field_401_a = -0.5F;
        }

        this.field_401_a *= 0.6F;
    }

    protected void func_152_d_() {
        this.func_27013_Q();
        EntityPlayer var1 = this.field_9093_l.func_472_a(this, 16.0D);
        if (var1 != null) {
            this.func_147_b(var1, 10.0F, 20.0F);
        }

        if (this.field_9086_A && this.field_402_ae-- <= 0) {
            this.field_402_ae = this.field_9064_W.nextInt(20) + 10;
            if (var1 != null) {
                this.field_402_ae /= 3;
            }

            this.field_9128_br = true;
            if (this.func_25027_m() > 1) {
                this.field_9093_l.func_506_a(this, "mob.slime", this.func_6102_h(), ((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }

            this.field_401_a = 1.0F;
            this.field_9131_bo = 1.0F - this.field_9064_W.nextFloat() * 2.0F;
            this.field_9130_bp = (float)(1 * this.func_25027_m());
        } else {
            this.field_9128_br = false;
            if (this.field_9086_A) {
                this.field_9131_bo = this.field_9130_bp = 0.0F;
            }
        }

    }

    public void func_118_j() {
        int var1 = this.func_25027_m();
        if (!this.field_9093_l.field_792_x && var1 > 1 && this.field_9109_aQ == 0) {
            for(int var2 = 0; var2 < 4; ++var2) {
                float var3 = ((float)(var2 % 2) - 0.5F) * (float)var1 / 4.0F;
                float var4 = ((float)(var2 / 2) - 0.5F) * (float)var1 / 4.0F;
                EntitySlime var5 = new EntitySlime(this.field_9093_l);
                var5.func_160_c(var1 / 2);
                var5.func_107_c(this.field_322_l + (double)var3, this.field_321_m + 0.5D, this.field_320_n + (double)var4, this.field_9064_W.nextFloat() * 360.0F, 0.0F);
                this.field_9093_l.func_526_a(var5);
            }
        }

        super.func_118_j();
    }

    public void func_6093_b(EntityPlayer var1) {
        int var2 = this.func_25027_m();
        if (var2 > 1 && this.func_145_g(var1) && (double)this.func_94_a(var1) < 0.6D * (double)var2 && var1.func_121_a(this, var2)) {
            this.field_9093_l.func_506_a(this, "mob.slimeattack", 1.0F, (this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F);
        }

    }

    protected String func_6100_e() {
        return "mob.slime";
    }

    protected String func_6098_f() {
        return "mob.slime";
    }

    protected int func_149_g() {
        return this.func_25027_m() == 1 ? Item.field_242_aK.field_234_aS : 0;
    }

    public boolean func_155_a() {
        Chunk var1 = this.field_9093_l.func_492_a(MathHelper.func_584_b(this.field_322_l), MathHelper.func_584_b(this.field_320_n));
        return (this.func_25027_m() == 1 || this.field_9093_l.field_804_l > 0) && this.field_9064_W.nextInt(10) == 0 && var1.func_334_a(987234911L).nextInt(10) == 0 && this.field_321_m < 16.0D;
    }

    protected float func_6102_h() {
        return 0.6F;
    }
}
