package net.minecraft.src;

import java.util.Random;

public class BlockBookshelf extends Block {
    public BlockBookshelf(int var1, int var2) {
        super(var1, var2, Material.field_524_c);
    }

    public int func_241_a(int var1) {
        return var1 <= 1 ? 4 : this.field_575_bb;
    }

    public int func_244_a(Random var1) {
        return 0;
    }
}
