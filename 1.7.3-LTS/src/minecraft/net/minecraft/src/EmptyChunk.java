package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class EmptyChunk extends Chunk {
    public EmptyChunk(World var1, int var2, int var3) {
        super(var1, var2, var3);
        this.neverSave = true;
    }

    public EmptyChunk(World var1, byte[] var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        this.neverSave = true;
    }

    public boolean isAtLocation(int var1, int var2) {
        return var1 == this.xPosition && var2 == this.zPosition;
    }

    public int getHeightValue(int var1, int var2) {
        return 0;
    }

    public void func_1014_a() {
    }

    public void generateHeightMap() {
    }

    public void generateSkylightMap() {
    }

    public void func_4143_d() {
    }

    public int getBlockID(int var1, int var2, int var3) {
        return 0;
    }

    public boolean setBlockIDWithMetadata(int var1, int var2, int var3, int var4, int var5) {
        return true;
    }

    public boolean setBlockID(int var1, int var2, int var3, int var4) {
        return true;
    }

    public int getBlockMetadata(int var1, int var2, int var3) {
        return 0;
    }

    public void setBlockMetadata(int var1, int var2, int var3, int var4) {
    }

    public int getSavedLightValue(EnumSkyBlock var1, int var2, int var3, int var4) {
        return 0;
    }

    public void setLightValue(EnumSkyBlock var1, int var2, int var3, int var4, int var5) {
    }

    public int getBlockLightValue(int var1, int var2, int var3, int var4) {
        return 0;
    }

    public void addEntity(Entity var1) {
    }

    public void removeEntity(Entity var1) {
    }

    public void removeEntityAtIndex(Entity var1, int var2) {
    }

    public boolean canBlockSeeTheSky(int var1, int var2, int var3) {
        return false;
    }

    public TileEntity getChunkBlockTileEntity(int var1, int var2, int var3) {
        return null;
    }

    public void addTileEntity(TileEntity var1) {
    }

    public void setChunkBlockTileEntity(int var1, int var2, int var3, TileEntity var4) {
    }

    public void removeChunkBlockTileEntity(int var1, int var2, int var3) {
    }

    public void onChunkLoad() {
    }

    public void onChunkUnload() {
    }

    public void setChunkModified() {
    }

    public void getEntitiesWithinAABBForEntity(Entity var1, AxisAlignedBB var2, List var3) {
    }

    public void getEntitiesOfTypeWithinAAAB(Class var1, AxisAlignedBB var2, List var3) {
    }

    public boolean needsSaving(boolean var1) {
        return false;
    }

    public int setChunkData(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = var5 - var2;
        int var10 = var6 - var3;
        int var11 = var7 - var4;
        int var12 = var9 * var10 * var11;
        return var12 + var12 / 2 * 3;
    }

    public Random getRandomWithSeed(long var1) {
        return new Random(this.worldObj.getRandomSeed() + (long)(this.xPosition * this.xPosition * 4987142) + (long)(this.xPosition * 5947611) + (long)(this.zPosition * this.zPosition) * 4392871L + (long)(this.zPosition * 389711) ^ var1);
    }

    public boolean isEmpty() {
        return true;
    }
}
