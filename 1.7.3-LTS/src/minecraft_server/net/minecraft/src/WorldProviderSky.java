package net.minecraft.src;

public class WorldProviderSky extends WorldProvider {
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.field_28054_m, 0.5D, 0.0D);
        this.worldType = 1;
    }

    public IChunkProvider getChunkProvider() {
        return new ChunkProviderSky(this.worldObj, this.worldObj.getRandomSeed());
    }

    public float calculateCelestialAngle(long var1, float var3) {
        return 0.0F;
    }

    public boolean canCoordinateBeSpawn(int var1, int var2) {
        int var3 = this.worldObj.getFirstUncoveredBlock(var1, var2);
        return var3 == 0 ? false : Block.blocksList[var3].blockMaterial.getIsSolid();
    }
}
