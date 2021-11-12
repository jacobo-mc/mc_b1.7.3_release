package net.minecraft.src;

import java.util.Random;

public class BlockIce extends BlockBreakable {
    public BlockIce(int var1, int var2) {
        super(var1, var2, Material.field_1320_r, false);
        this.field_355_bo = 0.98F;
        this.func_253_b(true);
    }

    public int func_234_g() {
        return 1;
    }

    public boolean func_260_c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
        return super.func_260_c(var1, var2, var3, var4, 1 - var5);
    }

    public void func_220_a_(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
        super.func_220_a_(var1, var2, var3, var4, var5, var6);
        Material var7 = var1.func_599_f(var3, var4 - 1, var5);
        if (var7.func_880_c() || var7.func_879_d()) {
            var1.func_690_d(var3, var4, var5, Block.field_401_B.field_376_bc);
        }

    }

    public int func_229_a(Random var1) {
        return 0;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_641_a(EnumSkyBlock.Block, var2, var3, var4) > 11 - Block.field_341_r[this.field_376_bc]) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, Block.field_399_C.field_376_bc);
        }

    }

    public int func_31029_h() {
        return 0;
    }
}
