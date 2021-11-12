package net.minecraft.src;

public class ItemSpade extends ItemTool {
    private static Block[] blocksEffectiveAgainst;

    public ItemSpade(int var1, EnumToolMaterial var2) {
        super(var1, 1, var2, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block var1) {
        if (var1 == Block.snow) {
            return true;
        } else {
            return var1 == Block.blockSnow;
        }
    }

    static {
        blocksEffectiveAgainst = new Block[]{Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField};
    }
}
