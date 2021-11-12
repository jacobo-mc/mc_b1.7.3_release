package net.minecraft.src;

public class EntityGiantZombie extends EntityMob {
    public EntityGiantZombie(World var1) {
        super(var1);
        this.field_9357_z = "/mob/zombie.png";
        this.field_9333_am = 0.5F;
        this.field_762_e = 50;
        this.field_9337_J *= 10;
        this.field_9292_aO *= 6.0F;
        this.func_371_a(this.field_644_aC * 6.0F, this.field_643_aD * 6.0F);
    }

    protected float func_439_a(int var1, int var2, int var3) {
        return this.field_615_ag.func_598_c(var1, var2, var3) - 0.5F;
    }
}
