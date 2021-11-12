package net.minecraft.src;

public class BlockOreStorage extends Block {
    public BlockOreStorage(int var1, int var2) {
        super(var1, Material.iron);
        this.blockIndexInTexture = var2;
    }

    public int getBlockTextureFromSide(int var1) {
        return this.blockIndexInTexture;
    }
}
