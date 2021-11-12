package net.minecraft.src;

import java.util.Random;

public class BlockLockedChest extends Block {
    protected BlockLockedChest(int var1) {
        super(var1, Material.wood);
        this.blockIndexInTexture = 26;
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture - 1;
        } else if (var1 == 0) {
            return this.blockIndexInTexture - 1;
        } else {
            return var1 == 3 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture;
        }
    }

    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        return true;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        var1.setBlockWithNotify(var2, var3, var4, 0);
    }
}
