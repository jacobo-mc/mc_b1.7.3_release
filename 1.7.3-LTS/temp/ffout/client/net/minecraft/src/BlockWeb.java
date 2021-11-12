package net.minecraft.src;

import java.util.Random;

public class BlockWeb extends Block {
    public BlockWeb(int var1, int var2) {
        super(var1, var2, Material.field_31068_A);
    }

    public void func_236_b(World var1, int var2, int var3, int var4, Entity var5) {
        var5.field_27016_ba = true;
    }

    public boolean func_217_b() {
        return false;
    }

    public AxisAlignedBB func_221_d(World var1, int var2, int var3, int var4) {
        return null;
    }

    public int func_210_f() {
        return 1;
    }

    public boolean func_242_c() {
        return false;
    }

    public int func_240_a(int var1, Random var2) {
        return Item.field_253_I.field_291_aS;
    }
}
