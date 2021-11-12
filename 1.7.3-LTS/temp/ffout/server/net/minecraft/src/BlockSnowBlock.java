package net.minecraft.src;

import java.util.Random;

public class BlockSnowBlock extends Block {
    protected BlockSnowBlock(int var1, int var2) {
        super(var1, var2, Material.field_507_t);
        this.func_231_a(true);
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_251_aB.field_234_aS;
    }

    public int func_244_a(Random var1) {
        return 4;
    }

    public void func_221_a(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.func_512_a(EnumSkyBlock.Block, var2, var3, var4) > 11) {
            this.func_247_a_(var1, var2, var3, var4, var1.func_446_b(var2, var3, var4));
            var1.func_508_d(var2, var3, var4, 0);
        }

    }
}
