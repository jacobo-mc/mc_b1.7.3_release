package net.minecraft.src;

public class BlockSandStone extends Block {
    public BlockSandStone(int var1) {
        super(var1, 192, Material.rock);
    }

    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return this.blockIndexInTexture - 16;
        } else {
            return var1 == 0 ? this.blockIndexInTexture + 16 : this.blockIndexInTexture;
        }
    }
}
