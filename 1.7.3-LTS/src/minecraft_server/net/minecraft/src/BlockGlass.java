package net.minecraft.src;

import java.util.Random;

public class BlockGlass extends BlockBreakable {
    public BlockGlass(int var1, int var2, Material var3, boolean var4) {
        super(var1, var2, var3, var4);
    }

    public int quantityDropped(Random var1) {
        return 0;
    }
}
