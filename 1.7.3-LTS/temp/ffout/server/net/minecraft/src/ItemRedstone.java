package net.minecraft.src;

public class ItemRedstone extends Item {
    public ItemRedstone(int var1) {
        super(var1);
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.func_444_a(var4, var5, var6) != Block.field_625_aT.field_573_bc) {
            if (var7 == 0) {
                --var5;
            }

            if (var7 == 1) {
                ++var5;
            }

            if (var7 == 2) {
                --var6;
            }

            if (var7 == 3) {
                ++var6;
            }

            if (var7 == 4) {
                --var4;
            }

            if (var7 == 5) {
                ++var4;
            }

            if (!var3.func_20111_e(var4, var5, var6)) {
                return false;
            }
        }

        if (Block.field_591_aw.func_259_a(var3, var4, var5, var6)) {
            --var1.field_853_a;
            var3.func_508_d(var4, var5, var6, Block.field_591_aw.field_573_bc);
        }

        return true;
    }
}
