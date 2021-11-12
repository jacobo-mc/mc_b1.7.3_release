package net.minecraft.src;

public class ItemBow extends Item {
    public ItemBow(int var1) {
        super(var1);
        this.field_233_aT = 1;
    }

    public ItemStack func_6152_a(ItemStack var1, World var2, EntityPlayer var3) {
        if (var3.field_416_aj.func_6127_b(Item.field_4148_j.field_234_aS)) {
            var2.func_506_a(var3, "random.bow", 1.0F, 1.0F / (field_4154_b.nextFloat() * 0.4F + 0.8F));
            if (!var2.field_792_x) {
                var2.func_526_a(new EntityArrow(var2, var3));
            }
        }

        return var1;
    }
}
