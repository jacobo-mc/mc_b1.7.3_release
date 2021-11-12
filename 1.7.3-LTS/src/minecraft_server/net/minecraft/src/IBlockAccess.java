package net.minecraft.src;

public interface IBlockAccess {
    int getBlockId(int var1, int var2, int var3);

    TileEntity getBlockTileEntity(int var1, int var2, int var3);

    int getBlockMetadata(int var1, int var2, int var3);

    Material getBlockMaterial(int var1, int var2, int var3);

    boolean isBlockNormalCube(int var1, int var2, int var3);
}
