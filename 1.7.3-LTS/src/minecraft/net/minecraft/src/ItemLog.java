package net.minecraft.src;

public class ItemLog extends ItemBlock {
    public ItemLog(int var1) {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getIconFromDamage(int var1) {
        return Block.wood.getBlockTextureFromSideAndMetadata(2, var1);
    }

    public int getPlacedBlockMetadata(int var1) {
        return var1;
    }
}
