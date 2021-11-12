package net.minecraft.src;

import java.util.Random;

public class BlockBookshelf extends Block {
    public BlockBookshelf(int var1, int var2) {
        super(var1, var2, Material.field_1335_c);
    }

    public int func_218_a(int var1) {
        return var1 <= 1 ? 4 : this.field_378_bb;
    }

    public int func_229_a(Random var1) {
        return 0;
    }
}
