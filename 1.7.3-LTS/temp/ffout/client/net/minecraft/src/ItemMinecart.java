package net.minecraft.src;

public class ItemMinecart extends Item {
    public int field_317_a;

    public ItemMinecart(int var1, int var2) {
        super(var1);
        this.field_290_aT = 1;
        this.field_317_a = var2;
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        int var8 = var3.func_600_a(var4, var5, var6);
        if (BlockRail.func_27041_c(var8)) {
            if (!var3.field_1026_y) {
                var3.func_674_a(new EntityMinecart(var3, (double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), this.field_317_a));
            }

            --var1.field_1615_a;
            return true;
        } else {
            return false;
        }
    }
}
