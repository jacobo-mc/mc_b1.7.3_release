package net.minecraft.src;

import java.util.Random;

public class BlockClay extends Block {
    public BlockClay(int var1, int var2) {
        super(var1, var2, Material.field_1316_v);
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_303_aG.field_291_aS;
    }

    public int func_229_a(Random var1) {
        return 4;
    }
}
