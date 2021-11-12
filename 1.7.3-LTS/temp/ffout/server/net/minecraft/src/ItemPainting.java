package net.minecraft.src;

public class ItemPainting extends Item {
    public ItemPainting(int var1) {
        super(var1);
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var7 == 0) {
            return false;
        } else if (var7 == 1) {
            return false;
        } else {
            byte var8 = 0;
            if (var7 == 4) {
                var8 = 1;
            }

            if (var7 == 3) {
                var8 = 2;
            }

            if (var7 == 5) {
                var8 = 3;
            }

            EntityPainting var9 = new EntityPainting(var3, var4, var5, var6, var8);
            if (var9.func_181_b()) {
                if (!var3.field_792_x) {
                    var3.func_526_a(var9);
                }

                --var1.field_853_a;
            }

            return true;
        }
    }
}
