package net.minecraft.src;

public class EntityPig extends EntityAnimal {
    public EntityPig(World var1) {
        super(var1);
        this.field_9357_z = "/mob/pig.png";
        this.func_371_a(0.9F, 0.9F);
    }

    protected void func_21057_b() {
        this.field_21064_bx.func_21124_a(16, (byte)0);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_748_a("Saddle", this.func_21068_q());
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.func_21069_a(var1.func_760_m("Saddle"));
    }

    protected String func_6389_d() {
        return "mob.pig";
    }

    protected String func_6394_f_() {
        return "mob.pig";
    }

    protected String func_6390_f() {
        return "mob.pigdeath";
    }

    public boolean func_353_a(EntityPlayer var1) {
        if (!this.func_21068_q() || this.field_615_ag.field_1026_y || this.field_617_ae != null && this.field_617_ae != var1) {
            return false;
        } else {
            var1.func_6377_h(this);
            return true;
        }
    }

    protected int func_422_g() {
        return this.field_9309_bg > 0 ? Item.field_4017_ap.field_291_aS : Item.field_272_ao.field_291_aS;
    }

    public boolean func_21068_q() {
        return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
    }

    public void func_21069_a(boolean var1) {
        if (var1) {
            this.field_21064_bx.func_21129_b(16, (byte)1);
        } else {
            this.field_21064_bx.func_21129_b(16, (byte)0);
        }

    }

    public void func_27014_a(EntityLightningBolt var1) {
        if (!this.field_615_ag.field_1026_y) {
            EntityPigZombie var2 = new EntityPigZombie(this.field_615_ag);
            var2.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar);
            this.field_615_ag.func_674_a(var2);
            this.func_395_F();
        }
    }

    protected void func_400_c(float var1) {
        super.func_400_c(var1);
        if (var1 > 5.0F && this.field_617_ae instanceof EntityPlayer) {
            ((EntityPlayer)this.field_617_ae).func_27026_a(AchievementList.field_27375_u);
        }

    }
}
