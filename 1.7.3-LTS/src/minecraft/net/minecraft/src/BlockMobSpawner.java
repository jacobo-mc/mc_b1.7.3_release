package net.minecraft.src;

import java.util.Random;

public class BlockMobSpawner extends BlockContainer {
    protected BlockMobSpawner(int var1, int var2) {
        super(var1, var2, Material.rock);
    }

    protected TileEntity getBlockEntity() {
        return new TileEntityMobSpawner();
    }

    public int idDropped(int var1, Random var2) {
        return 0;
    }

    public int quantityDropped(Random var1) {
        return 0;
    }

    public boolean isOpaqueCube() {
        return false;
    }
}
