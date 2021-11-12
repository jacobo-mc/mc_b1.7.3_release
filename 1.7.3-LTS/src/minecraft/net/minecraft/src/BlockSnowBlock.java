package net.minecraft.src;

import java.util.Random;

public class BlockSnowBlock extends Block {
    protected BlockSnowBlock(int var1, int var2) {
        super(var1, var2, Material.builtSnow);
        this.setTickOnLoad(true);
    }

    public int idDropped(int var1, Random var2) {
        return Item.snowball.shiftedIndex;
    }

    public int quantityDropped(Random var1) {
        return 4;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        if (var1.getSavedLightValue(EnumSkyBlock.Block, var2, var3, var4) > 11) {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }

    }
}
