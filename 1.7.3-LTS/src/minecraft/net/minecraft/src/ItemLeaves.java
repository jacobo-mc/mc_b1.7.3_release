package net.minecraft.src;

public class ItemLeaves extends ItemBlock {
    public ItemLeaves(int var1) {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getPlacedBlockMetadata(int var1) {
        return var1 | 8;
    }

    public int getIconFromDamage(int var1) {
        return Block.leaves.getBlockTextureFromSideAndMetadata(0, var1);
    }

    public int getColorFromDamage(int var1) {
        if ((var1 & 1) == 1) {
            return ColorizerFoliage.getFoliageColorPine();
        } else {
            return (var1 & 2) == 2 ? ColorizerFoliage.getFoliageColorBirch() : ColorizerFoliage.getFoliageColorBasic();
        }
    }
}
