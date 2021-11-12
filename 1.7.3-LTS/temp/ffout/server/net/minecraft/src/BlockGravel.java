package net.minecraft.src;

import java.util.Random;

public class BlockGravel extends BlockSand {
    public BlockGravel(int var1, int var2) {
        super(var1, var2);
    }

    public int func_252_a(int var1, Random var2) {
        return var2.nextInt(10) == 0 ? Item.field_216_an.field_234_aS : this.field_573_bc;
    }
}
