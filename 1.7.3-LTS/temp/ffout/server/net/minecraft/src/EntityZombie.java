package net.minecraft.src;

public class EntityZombie extends EntityMob {
    public EntityZombie(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/zombie.png";
        this.field_9126_bt = 0.5F;
        this.field_404_af = 5;
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

    protected String func_6097_d() {
        return "mob.zombie";
    }

    protected String func_6100_e() {
        return "mob.zombiehurt";
    }

    protected String func_6098_f() {
        return "mob.zombiedeath";
    }

    protected int func_149_g() {
        return Item.field_194_J.field_234_aS;
    }
}
