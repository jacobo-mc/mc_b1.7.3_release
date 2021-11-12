package net.minecraft.src;

public class ItemSaddle extends Item {
    public ItemSaddle(int var1) {
        super(var1);
        this.field_290_aT = 1;
    }

    public void func_4019_b(ItemStack var1, EntityLiving var2) {
        if (var2 instanceof EntityPig) {
            EntityPig var3 = (EntityPig)var2;
            if (!var3.func_21068_q()) {
                var3.func_21069_a(true);
                --var1.field_1615_a;
            }
        }

    }

    public boolean func_4021_a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        this.func_4019_b(var1, var2);
        return true;
    }
}
