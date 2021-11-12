package net.minecraft.src;

public class EntityZombie extends EntityMob {
    public EntityZombie(World var1) {
        super(var1);
        this.field_9357_z = "/mob/zombie.png";
        this.field_9333_am = 0.5F;
        this.field_762_e = 5;
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

    protected String func_6389_d() {
        return "mob.zombie";
    }

    protected String func_6394_f_() {
        return "mob.zombiehurt";
    }

    protected String func_6390_f() {
        return "mob.zombiedeath";
    }

    protected int func_422_g() {
        return Item.field_251_J.field_291_aS;
    }
}
