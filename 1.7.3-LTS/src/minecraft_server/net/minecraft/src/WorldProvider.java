package net.minecraft.src;

public abstract class WorldProvider {
    public World worldObj;
    public WorldChunkManager worldChunkMgr;
    public boolean field_6167_c = false;
    public boolean isHellWorld = false;
    public boolean field_4306_c = false;
    public float[] lightBrightnessTable = new float[16];
    public int worldType = 0;
    private float[] field_6164_h = new float[4];

    public final void registerWorld(World var1) {
        this.worldObj = var1;
        this.registerWorldChunkManager();
        this.generateLightBrightnessTable();
    }

    protected void generateLightBrightnessTable() {
        float var1 = 0.05F;

        for(int var2 = 0; var2 <= 15; ++var2) {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }

    }

    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManager(this.worldObj);
    }

    public IChunkProvider getChunkProvider() {
        return new ChunkProviderGenerate(this.worldObj, this.worldObj.getRandomSeed());
    }

    public boolean canCoordinateBeSpawn(int var1, int var2) {
        int var3 = this.worldObj.getFirstUncoveredBlock(var1, var2);
        return var3 == Block.sand.blockID;
    }

    public float calculateCelestialAngle(long var1, float var3) {
        int var4 = (int)(var1 % 24000L);
        float var5 = ((float)var4 + var3) / 24000.0F - 0.25F;
        if (var5 < 0.0F) {
            ++var5;
        }

        if (var5 > 1.0F) {
            --var5;
        }

        float var6 = var5;
        var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
        var5 = var6 + (var5 - var6) / 3.0F;
        return var5;
    }

    public boolean func_28108_d() {
        return true;
    }

    public static WorldProvider func_4091_a(int var0) {
        if (var0 == -1) {
            return new WorldProviderHell();
        } else if (var0 == 0) {
            return new WorldProviderSurface();
        } else {
            return var0 == 1 ? new WorldProviderSky() : null;
        }
    }
}
