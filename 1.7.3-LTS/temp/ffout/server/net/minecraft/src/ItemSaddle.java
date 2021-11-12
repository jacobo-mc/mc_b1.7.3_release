package net.minecraft.src;

public class ItemSaddle extends Item {
    public ItemSaddle(int var1) {
        super(var1);
        this.field_233_aT = 1;
    }

    public void func_9202_b(ItemStack var1, EntityLiving var2) {
        if (var2 instanceof EntityPig) {
            EntityPig var3 = (EntityPig)var2;
            if (!var3.func_21065_K()) {
                var3.func_21064_a(true);
                --var1.field_853_a;
            }
        }

    }

    public boolean func_9201_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        this.func_9202_b(var1, var2);
        return true;
    }
}
