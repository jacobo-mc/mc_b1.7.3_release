package net.minecraft.src;

import java.util.Random;

public class BlockWeb extends Block {
    public BlockWeb(int var1, int var2) {
        super(var1, var2, Material.field_31063_A);
    }

    public void func_263_a(World var1, int var2, int var3, int var4, Entity var5) {
        var5.field_27012_bb = true;
    }

    public boolean func_240_b() {
        return false;
    }

    public AxisAlignedBB func_248_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public boolean func_28025_b() {
        return false;
    }

    public int func_252_a(int var1, Random var2) {
        return Item.field_196_I.field_234_aS;
    }
}
