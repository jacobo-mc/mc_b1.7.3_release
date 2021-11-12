package net.minecraft.src;

public class BlockCloth extends Block {
    public BlockCloth() {
        super(35, 64, Material.cloth);
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
        if (var2 == 0) {
            return this.blockIndexInTexture;
        } else {
            var2 = ~(var2 & 15);
            return 113 + ((var2 & 8) >> 3) + (var2 & 7) * 16;
        }
    }

    protected int damageDropped(int var1) {
        return var1;
    }

    public static int getBlockFromDye(int var0) {
        return ~var0 & 15;
    }

    public static int getDyeFromBlock(int var0) {
        return ~var0 & 15;
    }
}
