package net.minecraft.src;

public class ItemFishingRod extends Item {
    public ItemFishingRod(int var1) {
        super(var1);
        this.func_21090_d(64);
        this.func_21086_c(1);
    }

    public ItemStack func_6152_a(ItemStack var1, World var2, EntityPlayer var3) {
        if (var3.field_6124_at != null) {
            int var4 = var3.field_6124_at.func_6143_c();
            var1.func_25125_a(var4, var3);
            var3.func_168_z();
        } else {
            var2.func_506_a(var3, "random.bow", 0.5F, 0.4F / (field_4154_b.nextFloat() * 0.4F + 0.8F));
            if (!var2.field_792_x) {
                var2.func_526_a(new EntityFish(var2, var3));
            }

            var3.func_168_z();
        }

        return var1;
    }
}
