package net.minecraft.src;

public class ItemBlock extends Item {
    private int field_272_a;

    public ItemBlock(int var1) {
        super(var1);
        this.field_272_a = var1 + 256;
        this.func_4049_a(Block.field_542_n[var1 + 256].func_241_a(2));
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
        } else if (var5 == 127 && Block.field_542_n[this.field_272_a].field_553_bn.func_216_a()) {
            return false;
        } else if (var3.func_516_a(this.field_272_a, var4, var5, var6, false, var7)) {
            Block var8 = Block.field_542_n[this.field_272_a];
            if (var3.func_507_b(var4, var5, var6, this.field_272_a, this.func_21089_a(var1.func_21125_h()))) {
                Block.field_542_n[this.field_272_a].func_255_c(var3, var4, var5, var6, var7);
                Block.field_542_n[this.field_272_a].func_4027_a(var3, var4, var5, var6, var2);
                var3.func_502_a((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var8.field_555_bl.func_737_c(), (var8.field_555_bl.func_738_a() + 1.0F) / 2.0F, var8.field_555_bl.func_739_b() * 0.8F);
                --var1.field_853_a;
            }

            return true;
        } else {
            return false;
        }
    }

    public String func_20106_a() {
        return Block.field_542_n[this.field_272_a].func_20036_e();
    }
}
