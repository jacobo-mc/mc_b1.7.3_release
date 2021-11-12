package net.minecraft.src;

import java.util.Random;

public class BlockIce extends BlockBreakable {
    public BlockIce(int var1, int var2) {
        super(var1, var2, Material.field_509_r, false);
        this.field_552_bo = 0.98F;
        this.func_231_a(true);
    }

    public void func_12007_g(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        super.func_12007_g(var1, var2, var3, var4, var5, var6);
        Material var7 = var1.func_443_c(var3, var4 - 1, var5);
        if (var7.func_218_c() || var7.func_217_d()) {
            var1.func_508_d(var3, var4, var5, Block.field_598_B.field_573_bc);
        }

    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_512_a(EnumSkyBlock.Block, var2, var3, var4) > 11 - Block.field_538_r[this.field_573_bc]) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, Block.field_596_C.field_573_bc);
        }

    }

    public int func_31025_e() {
        return 0;
    }
}
