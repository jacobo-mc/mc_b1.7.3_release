package net.minecraft.src;

public class ItemBlock extends Item {
    private int field_330_a;

    public ItemBlock(int var1) {
        super(var1);
        this.field_330_a = var1 + 256;
        this.func_4022_a(Block.field_345_n[var1 + 256].func_218_a(2));
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
        } else if (var5 == 127 && Block.field_345_n[this.field_330_a].field_356_bn.func_878_a()) {
            return false;
        } else if (var3.func_695_a(this.field_330_a, var4, var5, var6, false, var7)) {
            Block var8 = Block.field_345_n[this.field_330_a];
            if (var3.func_688_b(var4, var5, var6, this.field_330_a, this.func_21012_a(var1.func_21181_i()))) {
                Block.field_345_n[this.field_330_a].func_258_d(var3, var4, var5, var6, var7);
                Block.field_345_n[this.field_330_a].func_4026_a(var3, var4, var5, var6, var2);
                var3.func_684_a((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var8.field_358_bl.func_1145_d(), (var8.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var8.field_358_bl.func_1144_c() * 0.8F);
                --var1.field_1615_a;
            }

            return true;
        } else {
            return false;
        }
    }

    public String func_21011_b(ItemStack var1) {
        return Block.field_345_n[this.field_330_a].func_20013_i();
    }

    public String func_20009_a() {
        return Block.field_345_n[this.field_330_a].func_20013_i();
    }
}
