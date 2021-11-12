package net.minecraft.src;

public class ItemMinecart extends Item {
    public int field_270_a;

    public ItemMinecart(int var1, int var2) {
        super(var1);
        this.field_233_aT = 1;
        this.field_270_a = var2;
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        int var8 = var3.func_444_a(var4, var5, var6);
        if (BlockRail.func_27030_c(var8)) {
            if (!var3.field_792_x) {
                var3.func_526_a(new EntityMinecart(var3, (double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), this.field_270_a));
            }

            --var1.field_853_a;
            return true;
        } else {
            return false;
        }
    }
}
