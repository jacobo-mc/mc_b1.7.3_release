package net.minecraft.src;

import java.util.Random;

public class BlockClay extends Block {
    public BlockClay(int var1, int var2) {
        super(var1, var2, Material.field_505_v);
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_246_aG.field_234_aS;
    }

    public int func_244_a(Random var1) {
        return 4;
    }
}
