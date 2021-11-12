package net.minecraft.src;

import java.util.List;

public class EntityPigZombie extends EntityZombie {
    private int field_4106_a = 0;
    private int field_4105_b = 0;
    private static final ItemStack field_4107_c;

    public EntityPigZombie(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/pigzombie.png";
        this.field_9126_bt = 0.5F;
        this.field_404_af = 5;
        this.field_9079_ae = true;
    }

    public void func_106_b_() {
        this.field_9126_bt = this.field_389_ag != null ? 0.95F : 0.5F;
        if (this.field_4105_b > 0 && --this.field_4105_b == 0) {
            this.field_9093_l.func_506_a(this, "mob.zombiepig.zpigangry", this.func_6102_h() * 2.0F, ((this.field_9064_W.nextFloat() - this.field_9064_W.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }

        super.func_106_b_();
    }

    public boolean func_155_a() {
        return this.field_9093_l.field_804_l > 0 && this.field_9093_l.func_522_a(this.field_312_v) && this.field_9093_l.func_481_a(this, this.field_312_v).size() == 0 && !this.field_9093_l.func_469_b(this.field_312_v);
    }

    public void func_97_a(NBTTagCompound var1) {
        super.func_97_a(var1);
        var1.func_394_a("Anger", (short)this.field_4106_a);
    }

    public void func_99_b(NBTTagCompound var1) {
        super.func_99_b(var1);
        this.field_4106_a = var1.func_406_c("Anger");
    }

    protected Entity func_158_i() {
        return this.field_4106_a == 0 ? null : super.func_158_i();
    }

    public void func_153_y() {
        super.func_153_y();
    }

    public boolean func_121_a(Entity var1, int var2) {
        if (var1 instanceof EntityPlayer) {
            List var3 = this.field_9093_l.func_450_b(this, this.field_312_v.func_708_b(32.0D, 32.0D, 32.0D));

            for(int var4 = 0; var4 < var3.size(); ++var4) {
                Entity var5 = (Entity)var3.get(var4);
                if (var5 instanceof EntityPigZombie) {
                    EntityPigZombie var6 = (EntityPigZombie)var5;
                    var6.func_4047_h(var1);
                }
            }

            this.func_4047_h(var1);
        }

        return super.func_121_a(var1, var2);
    }

    private void func_4047_h(Entity var1) {
        this.field_389_ag = var1;
        this.field_4106_a = 400 + this.field_9064_W.nextInt(400);
        this.field_4105_b = this.field_9064_W.nextInt(40);
    }

    protected String func_6097_d() {
        return "mob.zombiepig.zpig";
    }

    protected String func_6100_e() {
        return "mob.zombiepig.zpighurt";
    }

    protected String func_6098_f() {
        return "mob.zombiepig.zpigdeath";
    }

    protected int func_149_g() {
        return Item.field_4176_ap.field_234_aS;
    }

    static {
        field_4107_c = new ItemStack(Item.field_4171_E, 1);
    }
}
