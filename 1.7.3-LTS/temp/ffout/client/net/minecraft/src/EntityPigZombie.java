package net.minecraft.src;

import java.util.List;

public class EntityPigZombie extends EntityZombie {
    private int field_4117_a = 0;
    private int field_4116_b = 0;
    private static final ItemStack field_4118_c;

    public EntityPigZombie(World var1) {
        super(var1);
        this.field_9357_z = "/mob/pigzombie.png";
        this.field_9333_am = 0.5F;
        this.field_762_e = 5;
        this.field_9304_bm = true;
    }

    public void func_370_e_() {
        this.field_9333_am = this.field_751_f != null ? 0.95F : 0.5F;
        if (this.field_4116_b > 0 && --this.field_4116_b == 0) {
            this.field_615_ag.func_623_a(this, "mob.zombiepig.zpigangry", this.func_6393_h() * 2.0F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }

        super.func_370_e_();
    }

    public boolean func_433_a() {
        return this.field_615_ag.field_1039_l > 0 && this.field_615_ag.func_604_a(this.field_601_au) && this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au);
    }

    public void func_352_a(NBTTagCompound var1) {
        super.func_352_a(var1);
        var1.func_749_a("Anger", (short)this.field_4117_a);
    }

    public void func_357_b(NBTTagCompound var1) {
        super.func_357_b(var1);
        this.field_4117_a = var1.func_745_d("Anger");
    }

    protected Entity func_438_i() {
        return this.field_4117_a == 0 ? null : super.func_438_i();
    }

    public void func_425_j() {
        super.func_425_j();
    }

    public boolean func_396_a(Entity var1, int var2) {
        if (var1 instanceof EntityPlayer) {
            List var3 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(32.0D, 32.0D, 32.0D));

            for(int var4 = 0; var4 < var3.size(); ++var4) {
                Entity var5 = (Entity)var3.get(var4);
                if (var5 instanceof EntityPigZombie) {
                    EntityPigZombie var6 = (EntityPigZombie)var5;
                    var6.func_4049_h(var1);
                }
            }

            this.func_4049_h(var1);
        }

        return super.func_396_a(var1, var2);
    }

    private void func_4049_h(Entity var1) {
        this.field_751_f = var1;
        this.field_4117_a = 400 + this.field_9312_bd.nextInt(400);
        this.field_4116_b = this.field_9312_bd.nextInt(40);
    }

    protected String func_6389_d() {
        return "mob.zombiepig.zpig";
    }

    protected String func_6394_f_() {
        return "mob.zombiepig.zpighurt";
    }

    protected String func_6390_f() {
        return "mob.zombiepig.zpigdeath";
    }

    protected int func_422_g() {
        return Item.field_4017_ap.field_291_aS;
    }

    public ItemStack func_4045_l() {
        return field_4118_c;
    }

    static {
        field_4118_c = new ItemStack(Item.field_261_E, 1);
    }
}
