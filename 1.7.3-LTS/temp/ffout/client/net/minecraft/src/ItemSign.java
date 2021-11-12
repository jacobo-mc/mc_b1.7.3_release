package net.minecraft.src;

public class ItemSign extends Item {
    public ItemSign(int var1) {
        super(var1);
        this.field_290_aT = 1;
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var7 == 0) {
            return false;
        } else if (!var3.func_599_f(var4, var5, var6).func_878_a()) {
            return false;
        } else {
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

            if (!Block.field_443_aE.func_243_a(var3, var4, var5, var6)) {
                return false;
            } else {
                if (var7 == 1) {
                    var3.func_688_b(var4, var5, var6, Block.field_443_aE.field_376_bc, MathHelper.func_1108_b((double)((var2.field_605_aq + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15);
                } else {
                    var3.func_688_b(var4, var5, var6, Block.field_4068_aJ.field_376_bc, var7);
                }

                --var1.field_1615_a;
                TileEntitySign var8 = (TileEntitySign)var3.func_603_b(var4, var5, var6);
                if (var8 != null) {
                    var2.func_4052_a(var8);
                }

                return true;
            }
        }
    }
}
