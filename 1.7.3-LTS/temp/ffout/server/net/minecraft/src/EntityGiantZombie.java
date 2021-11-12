package net.minecraft.src;

public class EntityGiantZombie extends EntityMob {
    public EntityGiantZombie(World var1) {
        super(var1);
        this.field_9119_aG = "/mob/zombie.png";
        this.field_9126_bt = 0.5F;
        this.field_404_af = 50;
        this.field_9109_aQ *= 10;
        this.field_9076_H *= 6.0F;
        this.func_113_a(this.field_300_D * 6.0F, this.field_298_E * 6.0F);
    }

    protected float func_159_a(int var1, int var2, int var3) {
        return this.field_9093_l.func_455_j(var1, var2, var3) - 0.5F;
    }
}
