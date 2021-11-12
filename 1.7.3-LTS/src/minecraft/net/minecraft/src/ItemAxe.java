package net.minecraft.src;

public class ItemAxe extends ItemTool {
    private static Block[] blocksEffectiveAgainst;

    protected ItemAxe(int var1, EnumToolMaterial var2) {
        super(var1, 3, var2, blocksEffectiveAgainst);
    }

    static {
        blocksEffectiveAgainst = new Block[]{Block.planks, Block.bookShelf, Block.wood, Block.chest};
    }
}
