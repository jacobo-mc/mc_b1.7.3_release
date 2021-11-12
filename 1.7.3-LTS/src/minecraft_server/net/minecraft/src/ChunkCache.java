package net.minecraft.src;

public class ChunkCache implements IBlockAccess {
    private int chunkX;
    private int chunkZ;
    private Chunk[][] chunkArray;
    private World worldObj;

    public ChunkCache(World var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        this.worldObj = var1;
        this.chunkX = var2 >> 4;
        this.chunkZ = var4 >> 4;
        int var8 = var5 >> 4;
        int var9 = var7 >> 4;
        this.chunkArray = new Chunk[var8 - this.chunkX + 1][var9 - this.chunkZ + 1];

        for(int var10 = this.chunkX; var10 <= var8; ++var10) {
            for(int var11 = this.chunkZ; var11 <= var9; ++var11) {
                this.chunkArray[var10 - this.chunkX][var11 - this.chunkZ] = var1.getChunkFromChunkCoords(var10, var11);
            }
        }

    }

    public int getBlockId(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else if (var2 >= 128) {
            return 0;
        } else {
            int var4 = (var1 >> 4) - this.chunkX;
            int var5 = (var3 >> 4) - this.chunkZ;
            if (var4 >= 0 && var4 < this.chunkArray.length && var5 >= 0 && var5 < this.chunkArray[var4].length) {
                Chunk var6 = this.chunkArray[var4][var5];
                return var6 == null ? 0 : var6.getBlockID(var1 & 15, var2, var3 & 15);
            } else {
                return 0;
            }
        }
    }

    public TileEntity getBlockTileEntity(int var1, int var2, int var3) {
        int var4 = (var1 >> 4) - this.chunkX;
        int var5 = (var3 >> 4) - this.chunkZ;
        return this.chunkArray[var4][var5].getChunkBlockTileEntity(var1 & 15, var2, var3 & 15);
    }

    public int getBlockMetadata(int var1, int var2, int var3) {
        if (var2 < 0) {
            return 0;
        } else if (var2 >= 128) {
            return 0;
        } else {
            int var4 = (var1 >> 4) - this.chunkX;
            int var5 = (var3 >> 4) - this.chunkZ;
            return this.chunkArray[var4][var5].getBlockMetadata(var1 & 15, var2, var3 & 15);
        }
    }

    public Material getBlockMaterial(int var1, int var2, int var3) {
        int var4 = this.getBlockId(var1, var2, var3);
        return var4 == 0 ? Material.air : Block.blocksList[var4].blockMaterial;
    }

    public boolean isBlockNormalCube(int var1, int var2, int var3) {
        Block var4 = Block.blocksList[this.getBlockId(var1, var2, var3)];
        if (var4 == null) {
            return false;
        } else {
            return var4.blockMaterial.getIsSolid() && var4.isACube();
        }
    }
}
