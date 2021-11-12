package net.minecraft.src;

public class ItemSapling extends ItemBlock {
    public ItemSapling(int var1) {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getPlacedBlockMetadata(int var1) {
        return var1;
    }

    public int getIconFromDamage(int var1) {
        return Block.sapling.getBlockTextureFromSideAndMetadata(0, var1);
    }
}
