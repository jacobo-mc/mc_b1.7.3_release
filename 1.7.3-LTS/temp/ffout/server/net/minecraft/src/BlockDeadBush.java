package net.minecraft.src;

import java.util.Random;

public class BlockDeadBush extends BlockFlower {
    protected BlockDeadBush(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.4F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }

    protected boolean func_277_b(int var1) {
        return var1 == Block.field_590_F.field_573_bc;
    }

    public int func_22009_a(int var1, int var2) {
        return this.field_575_bb;
    }

    public int func_252_a(int var1, Random var2) {
        return -1;
    }
}
