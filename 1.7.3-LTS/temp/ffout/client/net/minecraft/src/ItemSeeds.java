package net.minecraft.src;

public class ItemSeeds extends Item {
    private int field_318_a;

    public ItemSeeds(int var1, int var2) {
        super(var1);
        this.field_318_a = var2;
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var7 != 1) {
            return false;
        } else {
            int var8 = var3.func_600_a(var4, var5, var6);
            if (var8 == Block.field_446_aB.field_376_bc && var3.func_20084_d(var4, var5 + 1, var6)) {
                var3.func_690_d(var4, var5 + 1, var6, this.field_318_a);
                --var1.field_1615_a;
                return true;
            } else {
                return false;
            }
        }
    }
}
