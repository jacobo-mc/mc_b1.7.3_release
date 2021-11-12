package net.minecraft.src;

public class ItemCloth extends ItemBlock {
    public ItemCloth(int var1) {
        super(var1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getIconFromDamage(int var1) {
        return Block.cloth.getBlockTextureFromSideAndMetadata(2, BlockCloth.getBlockFromDye(var1));
    }

    public int getPlacedBlockMetadata(int var1) {
        return var1;
    }

    public String getItemNameIS(ItemStack var1) {
        return super.getItemName() + "." + ItemDye.dyeColorNames[BlockCloth.getBlockFromDye(var1.getItemDamage())];
    }
}
