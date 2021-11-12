package net.minecraft.src;

import java.util.List;

public class WorldInfo {
    private long randomSeed;
    private int spawnX;
    private int spawnY;
    private int spawnZ;
    private long worldTime;
    private long lastTimePlayed;
    private long sizeOnDisk;
    private NBTTagCompound field_22195_h;
    private int field_22194_i;
    private String levelName;
    private int saveVersion;
    private boolean isRaining;
    private int rainTime;
    private boolean isThundering;
    private int thunderTime;

    public WorldInfo(NBTTagCompound var1) {
        this.randomSeed = var1.getLong("RandomSeed");
        this.spawnX = var1.getInteger("SpawnX");
        this.spawnY = var1.getInteger("SpawnY");
        this.spawnZ = var1.getInteger("SpawnZ");
        this.worldTime = var1.getLong("Time");
        this.lastTimePlayed = var1.getLong("LastPlayed");
        this.sizeOnDisk = var1.getLong("SizeOnDisk");
        this.levelName = var1.getString("LevelName");
        this.saveVersion = var1.getInteger("version");
        this.rainTime = var1.getInteger("rainTime");
        this.isRaining = var1.getBoolean("raining");
        this.thunderTime = var1.getInteger("thunderTime");
        this.isThundering = var1.getBoolean("thundering");
        if (var1.hasKey("Player")) {
            this.field_22195_h = var1.getCompoundTag("Player");
            this.field_22194_i = this.field_22195_h.getInteger("Dimension");
        }

    }

    public WorldInfo(long var1, String var3) {
        this.randomSeed = var1;
        this.levelName = var3;
    }

    public WorldInfo(WorldInfo var1) {
        this.randomSeed = var1.randomSeed;
        this.spawnX = var1.spawnX;
        this.spawnY = var1.spawnY;
        this.spawnZ = var1.spawnZ;
        this.worldTime = var1.worldTime;
        this.lastTimePlayed = var1.lastTimePlayed;
        this.sizeOnDisk = var1.sizeOnDisk;
        this.field_22195_h = var1.field_22195_h;
        this.field_22194_i = var1.field_22194_i;
        this.levelName = var1.levelName;
        this.saveVersion = var1.saveVersion;
        this.rainTime = var1.rainTime;
        this.isRaining = var1.isRaining;
        this.thunderTime = var1.thunderTime;
        this.isThundering = var1.isThundering;
    }

    public NBTTagCompound func_22185_a() {
        NBTTagCompound var1 = new NBTTagCompound();
        this.saveNBTTag(var1, this.field_22195_h);
        return var1;
    }

    public NBTTagCompound func_22183_a(List var1) {
        NBTTagCompound var2 = new NBTTagCompound();
        EntityPlayer var3 = null;
        NBTTagCompound var4 = null;
        if (var1.size() > 0) {
            var3 = (EntityPlayer)var1.get(0);
        }

        if (var3 != null) {
            var4 = new NBTTagCompound();
            var3.writeToNBT(var4);
        }

        this.saveNBTTag(var2, var4);
        return var2;
    }

    private void saveNBTTag(NBTTagCompound var1, NBTTagCompound var2) {
        var1.setLong("RandomSeed", this.randomSeed);
        var1.setInteger("SpawnX", this.spawnX);
        var1.setInteger("SpawnY", this.spawnY);
        var1.setInteger("SpawnZ", this.spawnZ);
        var1.setLong("Time", this.worldTime);
        var1.setLong("SizeOnDisk", this.sizeOnDisk);
        var1.setLong("LastPlayed", System.currentTimeMillis());
        var1.setString("LevelName", this.levelName);
        var1.setInteger("version", this.saveVersion);
        var1.setInteger("rainTime", this.rainTime);
        var1.setBoolean("raining", this.isRaining);
        var1.setInteger("thunderTime", this.thunderTime);
        var1.setBoolean("thundering", this.isThundering);
        if (var2 != null) {
            var1.setCompoundTag("Player", var2);
        }

    }

    public long getRandomSeed() {
        return this.randomSeed;
    }

    public int getSpawnX() {
        return this.spawnX;
    }

    public int getSpawnY() {
        return this.spawnY;
    }

    public int getSpawnZ() {
        return this.spawnZ;
    }

    public long getWorldTime() {
        return this.worldTime;
    }

    public long getSizeOnDisk() {
        return this.sizeOnDisk;
    }

    public int getDimension() {
        return this.field_22194_i;
    }

    public void setWorldTime(long var1) {
        this.worldTime = var1;
    }

    public void setSizeOnDisk(long var1) {
        this.sizeOnDisk = var1;
    }

    public void setSpawnPosition(int var1, int var2, int var3) {
        this.spawnX = var1;
        this.spawnY = var2;
        this.spawnZ = var3;
    }

    public void setLevelName(String var1) {
        this.levelName = var1;
    }

    public int getVersion() {
        return this.saveVersion;
    }

    public void setVersion(int var1) {
        this.saveVersion = var1;
    }

    public boolean getIsThundering() {
        return this.isThundering;
    }

    public void setIsThundering(boolean var1) {
        this.isThundering = var1;
    }

    public int getThunderTime() {
        return this.thunderTime;
    }

    public void setThunderTime(int var1) {
        this.thunderTime = var1;
    }

    public boolean getIsRaining() {
        return this.isRaining;
    }

    public void setIsRaining(boolean var1) {
        this.isRaining = var1;
    }

    public int getRainTime() {
        return this.rainTime;
    }

    public void setRainTime(int var1) {
        this.rainTime = var1;
    }
}
