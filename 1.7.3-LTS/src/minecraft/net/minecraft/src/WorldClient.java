package net.minecraft.src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WorldClient extends World {
    private LinkedList field_1057_z = new LinkedList();
    private NetClientHandler sendQueue;
    private ChunkProviderClient field_20915_C;
    private MCHash field_1055_D = new MCHash();
    private Set field_20914_E = new HashSet();
    private Set field_1053_F = new HashSet();

    public WorldClient(NetClientHandler var1, long var2, int var4) {
        super(new SaveHandlerMP(), "MpServer", WorldProvider.getProviderForDimension(var4), var2);
        this.sendQueue = var1;
        this.setSpawnPoint(new ChunkCoordinates(8, 64, 8));
        this.field_28108_z = var1.mapStorage;
    }

    public void tick() {
        this.setWorldTime(this.getWorldTime() + 1L);
        int var1 = this.calculateSkylightSubtracted(1.0F);
        int var2;
        if (var1 != this.skylightSubtracted) {
            this.skylightSubtracted = var1;

            for(var2 = 0; var2 < this.worldAccesses.size(); ++var2) {
                ((IWorldAccess)this.worldAccesses.get(var2)).updateAllRenderers();
            }
        }

        for(var2 = 0; var2 < 10 && !this.field_1053_F.isEmpty(); ++var2) {
            Entity var3 = (Entity)this.field_1053_F.iterator().next();
            if (!this.loadedEntityList.contains(var3)) {
                this.entityJoinedWorld(var3);
            }
        }

        this.sendQueue.processReadPackets();

        for(var2 = 0; var2 < this.field_1057_z.size(); ++var2) {
            WorldBlockPositionType var4 = (WorldBlockPositionType)this.field_1057_z.get(var2);
            if (--var4.field_1206_d == 0) {
                super.setBlockAndMetadata(var4.field_1202_a, var4.field_1201_b, var4.field_1207_c, var4.field_1205_e, var4.field_1204_f);
                super.markBlockNeedsUpdate(var4.field_1202_a, var4.field_1201_b, var4.field_1207_c);
                this.field_1057_z.remove(var2--);
            }
        }

    }

    public void func_711_c(int var1, int var2, int var3, int var4, int var5, int var6) {
        for(int var7 = 0; var7 < this.field_1057_z.size(); ++var7) {
            WorldBlockPositionType var8 = (WorldBlockPositionType)this.field_1057_z.get(var7);
            if (var8.field_1202_a >= var1 && var8.field_1201_b >= var2 && var8.field_1207_c >= var3 && var8.field_1202_a <= var4 && var8.field_1201_b <= var5 && var8.field_1207_c <= var6) {
                this.field_1057_z.remove(var7--);
            }
        }

    }

    protected IChunkProvider getChunkProvider() {
        this.field_20915_C = new ChunkProviderClient(this);
        return this.field_20915_C;
    }

    public void setSpawnLocation() {
        this.setSpawnPoint(new ChunkCoordinates(8, 64, 8));
    }

    protected void updateBlocksAndPlayCaveSounds() {
    }

    public void scheduleBlockUpdate(int var1, int var2, int var3, int var4, int var5) {
    }

    public boolean TickUpdates(boolean var1) {
        return false;
    }

    public void doPreChunk(int var1, int var2, boolean var3) {
        if (var3) {
            this.field_20915_C.prepareChunk(var1, var2);
        } else {
            this.field_20915_C.unloadChunk(var1, var2);
        }

        if (!var3) {
            this.markBlocksDirty(var1 * 16, 0, var2 * 16, var1 * 16 + 15, 128, var2 * 16 + 15);
        }

    }

    public boolean entityJoinedWorld(Entity var1) {
        boolean var2 = super.entityJoinedWorld(var1);
        this.field_20914_E.add(var1);
        if (!var2) {
            this.field_1053_F.add(var1);
        }

        return var2;
    }

    public void setEntityDead(Entity var1) {
        super.setEntityDead(var1);
        this.field_20914_E.remove(var1);
    }

    protected void obtainEntitySkin(Entity var1) {
        super.obtainEntitySkin(var1);
        if (this.field_1053_F.contains(var1)) {
            this.field_1053_F.remove(var1);
        }

    }

    protected void releaseEntitySkin(Entity var1) {
        super.releaseEntitySkin(var1);
        if (this.field_20914_E.contains(var1)) {
            this.field_1053_F.add(var1);
        }

    }

    public void addEntityToWorld(int var1, Entity var2) {
        Entity var3 = this.getEntityByID(var1);
        if (var3 != null) {
            this.setEntityDead(var3);
        }

        this.field_20914_E.add(var2);
        var2.entityId = var1;
        if (!this.entityJoinedWorld(var2)) {
            this.field_1053_F.add(var2);
        }

        this.field_1055_D.addKey(var1, var2);
    }

    public Entity getEntityByID(int var1) {
        return (Entity)this.field_1055_D.lookup(var1);
    }

    public Entity removeEntityFromWorld(int var1) {
        Entity var2 = (Entity)this.field_1055_D.removeObject(var1);
        if (var2 != null) {
            this.field_20914_E.remove(var2);
            this.setEntityDead(var2);
        }

        return var2;
    }

    public boolean setBlockMetadata(int var1, int var2, int var3, int var4) {
        int var5 = this.getBlockId(var1, var2, var3);
        int var6 = this.getBlockMetadata(var1, var2, var3);
        if (super.setBlockMetadata(var1, var2, var3, var4)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, var1, var2, var3, var5, var6));
            return true;
        } else {
            return false;
        }
    }

    public boolean setBlockAndMetadata(int var1, int var2, int var3, int var4, int var5) {
        int var6 = this.getBlockId(var1, var2, var3);
        int var7 = this.getBlockMetadata(var1, var2, var3);
        if (super.setBlockAndMetadata(var1, var2, var3, var4, var5)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, var1, var2, var3, var6, var7));
            return true;
        } else {
            return false;
        }
    }

    public boolean setBlock(int var1, int var2, int var3, int var4) {
        int var5 = this.getBlockId(var1, var2, var3);
        int var6 = this.getBlockMetadata(var1, var2, var3);
        if (super.setBlock(var1, var2, var3, var4)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, var1, var2, var3, var5, var6));
            return true;
        } else {
            return false;
        }
    }

    public boolean setBlockAndMetadataAndInvalidate(int var1, int var2, int var3, int var4, int var5) {
        this.func_711_c(var1, var2, var3, var1, var2, var3);
        if (super.setBlockAndMetadata(var1, var2, var3, var4, var5)) {
            this.notifyBlockChange(var1, var2, var3, var4);
            return true;
        } else {
            return false;
        }
    }

    public void sendQuittingDisconnectingPacket() {
        this.sendQueue.quitWithPacket(new Packet255KickDisconnect("Quitting"));
    }

    protected void updateWeather() {
        if (!this.worldProvider.hasNoSky) {
            if (this.field_27168_F > 0) {
                --this.field_27168_F;
            }

            this.prevRainingStrength = this.rainingStrength;
            if (this.worldInfo.getRaining()) {
                this.rainingStrength = (float)((double)this.rainingStrength + 0.01D);
            } else {
                this.rainingStrength = (float)((double)this.rainingStrength - 0.01D);
            }

            if (this.rainingStrength < 0.0F) {
                this.rainingStrength = 0.0F;
            }

            if (this.rainingStrength > 1.0F) {
                this.rainingStrength = 1.0F;
            }

            this.prevThunderingStrength = this.thunderingStrength;
            if (this.worldInfo.getThundering()) {
                this.thunderingStrength = (float)((double)this.thunderingStrength + 0.01D);
            } else {
                this.thunderingStrength = (float)((double)this.thunderingStrength - 0.01D);
            }

            if (this.thunderingStrength < 0.0F) {
                this.thunderingStrength = 0.0F;
            }

            if (this.thunderingStrength > 1.0F) {
                this.thunderingStrength = 1.0F;
            }

        }
    }
}
