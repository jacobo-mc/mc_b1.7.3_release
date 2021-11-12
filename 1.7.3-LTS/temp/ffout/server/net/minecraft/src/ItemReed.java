package net.minecraft.src;

public class ItemReed extends Item {
    private int field_253_a;

    public ItemReed(int var1, Block var2) {
        super(var1);
        this.field_253_a = var2.field_573_bc;
    }

    public boolean func_78_a(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.func_444_a(var4, var5, var6) == Block.field_625_aT.field_573_bc) {
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

        if (var1.field_853_a == 0) {
            return false;
        } else {
            if (var3.func_516_a(this.field_253_a, var4, var5, var6, false, var7)) {
                Block var8 = Block.field_542_n[this.field_253_a];
                if (var3.func_508_d(var4, var5, var6, this.field_253_a)) {
                    Block.field_542_n[this.field_253_a].func_255_c(var3, var4, var5, var6, var7);
                    Block.field_542_n[this.field_253_a].func_4027_a(var3, var4, var5, var6, var2);
                    var3.func_502_a((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var8.field_555_bl.func_737_c(), (var8.field_555_bl.func_738_a() + 1.0F) / 2.0F, var8.field_555_bl.func_739_b() * 0.8F);
                    --var1.field_853_a;
                }
            }

            return true;
        }
    }
}
