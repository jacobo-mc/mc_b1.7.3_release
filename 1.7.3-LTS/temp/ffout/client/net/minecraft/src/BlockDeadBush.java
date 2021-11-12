package net.minecraft.src;

import java.util.Random;

public class BlockDeadBush extends BlockFlower {
    protected BlockDeadBush(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.4F;
        this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }

    protected boolean func_269_b(int var1) {
        return var1 == Block.field_393_F.field_376_bc;
    }

    public int func_232_a(int var1, int var2) {
        return this.field_378_bb;
    }

    public int func_240_a(int var1, Random var2) {
        return -1;
    }
}
