package net.minecraft.src;

import java.util.Random;

public class BlockGravel extends BlockSand {
    public BlockGravel(int var1, int var2) {
        super(var1, var2);
    }

    public int func_240_a(int var1, Random var2) {
        return var2.nextInt(10) == 0 ? Item.field_273_an.field_291_aS : this.field_376_bc;
    }
}
