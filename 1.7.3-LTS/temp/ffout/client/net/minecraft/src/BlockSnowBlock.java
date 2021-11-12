package net.minecraft.src;

import java.util.Random;

public class BlockSnowBlock extends Block {
    protected BlockSnowBlock(int var1, int var2) {
        super(var1, var2, Material.field_1318_t);
        this.func_253_b(true);
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_308_aB.field_291_aS;
    }

    public int func_229_a(Random var1) {
        return 4;
    }

    public void func_208_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_641_a(EnumSkyBlock.Block, var2, var3, var4) > 11) {
            this.func_259_b_(var1, var2, var3, var4, var1.func_602_e(var2, var3, var4));
            var1.func_690_d(var2, var3, var4, 0);
        }

    }
}
