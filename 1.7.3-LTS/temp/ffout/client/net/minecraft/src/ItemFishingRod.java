package net.minecraft.src;

public class ItemFishingRod extends Item {
    public ItemFishingRod(int var1) {
        super(var1);
        this.func_21013_d(64);
        this.func_21009_c(1);
    }

    public boolean func_4017_a() {
        return true;
    }

    public boolean func_4023_b() {
        return true;
    }

    public ItemStack func_193_a(ItemStack var1, World var2, EntityPlayer var3) {
        if (var3.field_4128_n != null) {
            int var4 = var3.field_4128_n.func_4043_i();
            var1.func_25190_a(var4, var3);
            var3.func_457_w();
        } else {
            var2.func_623_a(var3, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
            if (!var2.field_1026_y) {
                var2.func_674_a(new EntityFish(var2, var3));
            }

            var3.func_457_w();
        }

        return var1;
    }
}
