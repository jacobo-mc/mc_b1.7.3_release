package net.minecraft.src;

public class ItemRedstone extends Item {
    public ItemRedstone(int var1) {
        super(var1);
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.func_600_a(var4, var5, var6) != Block.field_428_aT.field_376_bc) {
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

            if (!var3.func_20084_d(var4, var5, var6)) {
                return false;
            }
        }

        if (Block.field_394_aw.func_243_a(var3, var4, var5, var6)) {
            --var1.field_1615_a;
            var3.func_690_d(var4, var5, var6, Block.field_394_aw.field_376_bc);
        }

        return true;
    }
}
