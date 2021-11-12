package net.minecraft.src;

import java.util.Random;

public class BlockMobSpawner extends BlockContainer {
    protected BlockMobSpawner(int var1, int var2) {
        super(var1, var2, Material.field_523_d);
    }

    protected TileEntity func_294_a_() {
        return new TileEntityMobSpawner();
    }

    public int func_252_a(int var1, Random var2) {
        return 0;
    }

    public int func_244_a(Random var1) {
        return 0;
    }

    public boolean func_240_b() {
        return false;
    }
}
