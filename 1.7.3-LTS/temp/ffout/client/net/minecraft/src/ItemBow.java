package net.minecraft.src;

public class ItemBow extends Item {
    public ItemBow(int var1) {
        super(var1);
        this.field_290_aT = 1;
    }

    public ItemStack func_193_a(ItemStack var1, World var2, EntityPlayer var3) {
        if (var3.field_778_b.func_510_b(Item.field_226_j.field_291_aS)) {
            var2.func_623_a(var3, "random.bow", 1.0F, 1.0F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
            if (!var2.field_1026_y) {
                var2.func_674_a(new EntityArrow(var2, var3));
            }
        }

        return var1;
    }
}
