package net.minecraft.src;

public class ItemSeeds extends Item {
    private int field_271_a;

    public ItemSeeds(int var1, int var2) {
        super(var1);
        this.field_271_a = var2;
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var7 != 1) {
            return false;
        } else {
            int var8 = var3.func_444_a(var4, var5, var6);
            if (var8 == Block.field_643_aB.field_573_bc && var3.func_20111_e(var4, var5 + 1, var6)) {
                var3.func_508_d(var4, var5 + 1, var6, this.field_271_a);
                --var1.field_853_a;
                return true;
            } else {
                return false;
            }
        }
    }
}
