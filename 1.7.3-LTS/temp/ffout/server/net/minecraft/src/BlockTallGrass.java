package net.minecraft.src;

import java.util.Random;

public class BlockTallGrass extends BlockFlower {
    protected BlockTallGrass(int var1, int var2) {
        super(var1, var2);
        float var3 = 0.4F;
        this.func_229_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }

    public int func_22009_a(int var1, int var2) {
        if (var2 == 1) {
            return this.field_575_bb;
        } else if (var2 == 2) {
            return this.field_575_bb + 16 + 1;
        } else {
            return var2 == 0 ? this.field_575_bb + 16 : this.field_575_bb;
        }
    }

    public int func_252_a(int var1, Random var2) {
        return var2.nextInt(8) == 0 ? Item.field_187_Q.field_234_aS : -1;
    }
}
