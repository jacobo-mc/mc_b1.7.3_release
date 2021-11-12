package net.minecraft.src;

public class EntityPig extends EntityAnimal {
    public EntityPig(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/pig.png";
        this.func_113_a(0.9F, 0.9F);
    }

    protected void func_21044_a() {
        this.field_21045_af.func_21153_a(16, (byte)0);
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        var1.func_393_a("Saddle", this.func_21065_K());
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        this.func_21064_a(var1.func_402_l("Saddle"));
    }

    protected String func_6097_d() {
        return "mob.pig";
    }

    protected String func_6100_e() {
        return "mob.pig";
    }

    protected String func_6098_f() {
        return "mob.pigdeath";
    }

    public boolean func_6092_a(EntityPlayer var1) {
        if (!this.func_21065_K() || this.field_9093_l.field_792_x || this.field_328_f != null && this.field_328_f != var1) {
            return false;
        } else {
            var1.func_6094_e(this);
            return true;
        }
    }

    protected int func_149_g() {
        return this.field_9061_Z > 0 ? Item.field_4176_ap.field_234_aS : Item.field_215_ao.field_234_aS;
    }

    public boolean func_21065_K() {
        return (this.field_21045_af.func_21156_a(16) & 1) != 0;
    }

    public void func_21064_a(boolean var1) {
        if (var1) {
            this.field_21045_af.func_21155_b(16, (byte)1);
        } else {
            this.field_21045_af.func_21155_b(16, (byte)0);
        }

    }

    public void func_27009_a(EntityLightningBolt var1) {
        if (!this.field_9093_l.field_792_x) {
            EntityPigZombie var2 = new EntityPigZombie(this.field_9093_l);
            var2.func_107_c(this.field_322_l, this.field_321_m, this.field_320_n, this.field_316_r, this.field_315_s);
            this.field_9093_l.func_526_a(var2);
            this.func_118_j();
        }
    }

    protected void func_114_a(float var1) {
        super.func_114_a(var1);
        if (var1 > 5.0F && this.field_328_f instanceof EntityPlayer) {
            ((EntityPlayer)this.field_328_f).func_27017_a(AchievementList.field_27098_u);
        }

    }
}
