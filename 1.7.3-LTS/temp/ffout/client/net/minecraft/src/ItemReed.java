package net.minecraft.src;

public class ItemReed extends Item {
    private int field_320_a;

    public ItemReed(int var1, Block var2) {
        super(var1);
        this.field_320_a = var2.field_376_bc;
    }

    public boolean func_192_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.func_600_a(var4, var5, var6) == Block.field_428_aT.field_376_bc) {
            var7 = 0;
        } else {
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
        }

        if (var1.field_1615_a == 0) {
            return false;
        } else {
            if (var3.func_695_a(this.field_320_a, var4, var5, var6, false, var7)) {
                Block var8 = Block.field_345_n[this.field_320_a];
                if (var3.func_690_d(var4, var5, var6, this.field_320_a)) {
                    Block.field_345_n[this.field_320_a].func_258_d(var3, var4, var5, var6, var7);
                    Block.field_345_n[this.field_320_a].func_4026_a(var3, var4, var5, var6, var2);
                    var3.func_684_a((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var8.field_358_bl.func_1145_d(), (var8.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var8.field_358_bl.func_1144_c() * 0.8F);
                    --var1.field_1615_a;
                }
            }

            return true;
        }
    }
}
