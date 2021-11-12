package net.minecraft.src;

public class EntitySlime extends EntityLiving implements IMob {
    public float field_768_a;
    public float field_767_b;
    private int field_769_d = 0;

    public EntitySlime(World var1) {
        super(var1);
        this.field_9357_z = "/mob/slime.png";
        int var2 = 1 << this.field_9312_bd.nextInt(3);
        this.field_9292_aO = 0.0F;
        this.field_769_d = this.field_9312_bd.nextInt(20) + 10;
        this.func_441_c(var2);
    }

    protected void func_21057_b() {
        super.func_21057_b();
        this.field_21064_bx.func_21124_a(16, new Byte((byte)1));
    }

    public void func_441_c(int var1) {
        this.field_21064_bx.func_21129_b(16, new Byte((byte)var1));
        this.func_371_a(0.6F * (float)var1, 0.6F * (float)var1);
        this.field_9337_J = var1 * var1;
        this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
    }

    public int func_25027_v() {
        return this.field_21064_bx.func_21130_a(16);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_758_a("Size", this.func_25027_v() - 1);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.func_441_c(var1.func_756_e("Size") + 1);
    }

    public void func_370_e_() {
        this.field_767_b = this.field_768_a;
        boolean var1 = this.field_9298_aH;
        super.func_370_e_();
        if (this.field_9298_aH && !var1) {
            int var2 = this.func_25027_v();

            for(int var3 = 0; var3 < var2 * 8; ++var3) {
                float var4 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
                float var5 = this.field_9312_bd.nextFloat() * 0.5F + 0.5F;
                float var6 = MathHelper.func_1106_a(var4) * (float)var2 * 0.5F * var5;
                float var7 = MathHelper.func_1114_b(var4) * (float)var2 * 0.5F * var5;
                this.field_615_ag.func_694_a("slime", this.field_611_ak + (double)var6, this.field_601_au.field_1697_b, this.field_609_am + (double)var7, 0.0D, 0.0D, 0.0D);
            }

            if (var2 > 2) {
                this.field_615_ag.func_623_a(this, "mob.slime", this.func_6393_h(), ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.field_768_a = -0.5F;
        }

        this.field_768_a *= 0.6F;
    }

    protected void func_418_b_() {
        this.func_27021_X();
        EntityPlayer var1 = this.field_615_ag.func_609_a(this, 16.0D);
        if (var1 != null) {
            this.func_426_b(var1, 10.0F, 20.0F);
        }

        if (this.field_9298_aH && this.field_769_d-- <= 0) {
            this.field_769_d = this.field_9312_bd.nextInt(20) + 10;
            if (var1 != null) {
                this.field_769_d /= 3;
            }

            this.field_9336_ak = true;
            if (this.func_25027_v() > 1) {
                this.field_615_ag.func_623_a(this, "mob.slime", this.func_6393_h(), ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }

            this.field_768_a = 1.0F;
            this.field_9342_ah = 1.0F - this.field_9312_bd.nextFloat() * 2.0F;
            this.field_9340_ai = (float)(1 * this.func_25027_v());
        } else {
            this.field_9336_ak = false;
            if (this.field_9298_aH) {
                this.field_9342_ah = this.field_9340_ai = 0.0F;
            }
        }

    }

    public void func_395_F() {
        int var1 = this.func_25027_v();
        if (!this.field_615_ag.field_1026_y && var1 > 1 && this.field_9337_J == 0) {
            for(int var2 = 0; var2 < 4; ++var2) {
                float var3 = ((float)(var2 % 2) - 0.5F) * (float)var1 / 4.0F;
                float var4 = ((float)(var2 / 2) - 0.5F) * (float)var1 / 4.0F;
                EntitySlime var5 = new EntitySlime(this.field_615_ag);
                var5.func_441_c(var1 / 2);
                var5.func_365_c(this.field_611_ak + (double)var3, this.field_610_al + 0.5D, this.field_609_am + (double)var4, this.field_9312_bd.nextFloat() * 360.0F, 0.0F);
                this.field_615_ag.func_674_a(var5);
            }
        }

        super.func_395_F();
    }

    public void func_6378_b(EntityPlayer var1) {
        int var2 = this.func_25027_v();
        if (var2 > 1 && this.func_420_c(var1) && (double)this.func_379_d(var1) < 0.6D * (double)var2 && var1.func_396_a(this, var2)) {
            this.field_615_ag.func_623_a(this, "mob.slimeattack", 1.0F, (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
        }

    }

    protected String func_6394_f_() {
        return "mob.slime";
    }

    protected String func_6390_f() {
        return "mob.slime";
    }

    protected int func_422_g() {
        return this.func_25027_v() == 1 ? Item.field_299_aK.field_291_aS : 0;
    }

    public boolean func_433_a() {
        Chunk var1 = this.field_615_ag.func_673_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_609_am));
        return (this.func_25027_v() == 1 || this.field_615_ag.field_1039_l > 0) && this.field_9312_bd.nextInt(10) == 0 && var1.func_997_a(987234911L).nextInt(10) == 0 && this.field_610_al < 16.0D;
    }

    protected float func_6393_h() {
        return 0.6F;
    }
}
