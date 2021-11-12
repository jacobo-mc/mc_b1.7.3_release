package net.minecraft.src;

public class ItemPickaxe extends ItemTool {
    private static Block[] blocksEffectiveAgainst;

    protected ItemPickaxe(int var1, EnumToolMaterial var2) {
        super(var1, 2, var2, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block var1) {
        if (var1 == Block.obsidian) {
            return this.toolMaterial.getHarvestLevel() == 3;
        } else if (var1 != Block.blockDiamond && var1 != Block.oreDiamond) {
            if (var1 != Block.blockGold && var1 != Block.oreGold) {
                if (var1 != Block.blockSteel && var1 != Block.oreIron) {
                    if (var1 != Block.blockLapis && var1 != Block.oreLapis) {
                        if (var1 != Block.oreRedstone && var1 != Block.oreRedstoneGlowing) {
                            if (var1.blockMaterial == Material.rock) {
                                return true;
                            } else {
                                return var1.blockMaterial == Material.iron;
                            }
                        } else {
                            return this.toolMaterial.getHarvestLevel() >= 2;
                        }
                    } else {
                        return this.toolMaterial.getHarvestLevel() >= 1;
                    }
                } else {
                    return this.toolMaterial.getHarvestLevel() >= 1;
                }
            } else {
                return this.toolMaterial.getHarvestLevel() >= 2;
            }
        } else {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
    }

    static {
        blocksEffectiveAgainst = new Block[]{Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.bloodStone, Block.oreLapis, Block.blockLapis};
    }
}
