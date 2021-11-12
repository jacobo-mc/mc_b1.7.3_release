package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class WorldServer extends World {
    public ChunkProviderServer chunkProviderServer;
    public boolean field_819_z = false;
    public boolean levelSaving;
    private MinecraftServer mcServer;
    private MCHash field_20912_E = new MCHash();

    public WorldServer(MinecraftServer var1, ISaveHandler var2, String var3, int var4, long var5) {
        super(var2, var3, var5, WorldProvider.func_4091_a(var4));
        this.mcServer = var1;
    }

    public void updateEntityWithOptionalForce(Entity var1, boolean var2) {
        if (!this.mcServer.spawnPeacefulMobs && (var1 instanceof EntityAnimal || var1 instanceof EntityWaterMob)) {
            var1.setEntityDead();
        }

        if (var1.riddenByEntity == null || !(var1.riddenByEntity instanceof EntityPlayer)) {
            super.updateEntityWithOptionalForce(var1, var2);
        }

    }

    public void func_12017_b(Entity var1, boolean var2) {
        super.updateEntityWithOptionalForce(var1, var2);
    }

    protected IChunkProvider createChunkProvider() {
        IChunkLoader var1 = this.worldFile.func_22092_a(this.worldProvider);
        this.chunkProviderServer = new ChunkProviderServer(this, var1, this.worldProvider.getChunkProvider());
        return this.chunkProviderServer;
    }

    public List getTileEntityList(int var1, int var2, int var3, int var4, int var5, int var6) {
        ArrayList var7 = new ArrayList();

        for(int var8 = 0; var8 < this.loadedTileEntityList.size(); ++var8) {
            TileEntity var9 = (TileEntity)this.loadedTileEntityList.get(var8);
            if (var9.xCoord >= var1 && var9.yCoord >= var2 && var9.zCoord >= var3 && var9.xCoord < var4 && var9.yCoord < var5 && var9.zCoord < var6) {
                var7.add(var9);
            }
        }

        return var7;
    }

    public boolean canMineBlock(EntityPlayer var1, int var2, int var3, int var4) {
        int var5 = (int)MathHelper.abs((float)(var2 - this.worldInfo.getSpawnX()));
        int var6 = (int)MathHelper.abs((float)(var4 - this.worldInfo.getSpawnZ()));
        if (var5 > var6) {
            var6 = var5;
        }

        return var6 > 16 || this.mcServer.configManager.isOp(var1.username);
    }

    protected void obtainEntitySkin(Entity var1) {
        super.obtainEntitySkin(var1);
        this.field_20912_E.addKey(var1.entityId, var1);
    }

    protected void releaseEntitySkin(Entity var1) {
        super.releaseEntitySkin(var1);
        this.field_20912_E.removeObject(var1.entityId);
    }

    public Entity func_6158_a(int var1) {
        return (Entity)this.field_20912_E.lookup(var1);
    }

    public boolean addLightningBolt(Entity var1) {
        if (super.addLightningBolt(var1)) {
            this.mcServer.configManager.sendPacketToPlayersAroundPoint(var1.posX, var1.posY, var1.posZ, 512.0D, this.worldProvider.worldType, new Packet71Weather(var1));
            return true;
        } else {
            return false;
        }
    }

    public void sendTrackedEntityStatusUpdatePacket(Entity var1, byte var2) {
        Packet38EntityStatus var3 = new Packet38EntityStatus(var1.entityId, var2);
        this.mcServer.getEntityTracker(this.worldProvider.worldType).sendPacketToTrackedPlayersAndTrackedEntity(var1, var3);
    }

    public Explosion newExplosion(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
        Explosion var10 = new Explosion(this, var1, var2, var4, var6, var8);
        var10.isFlaming = var9;
        var10.doExplosion();
        var10.doEffects(false);
        this.mcServer.configManager.sendPacketToPlayersAroundPoint(var2, var4, var6, 64.0D, this.worldProvider.worldType, new Packet60Explosion(var2, var4, var6, var8, var10.destroyedBlockPositions));
        return var10;
    }

    public void playNoteAt(int var1, int var2, int var3, int var4, int var5) {
        super.playNoteAt(var1, var2, var3, var4, var5);
        this.mcServer.configManager.sendPacketToPlayersAroundPoint((double)var1, (double)var2, (double)var3, 64.0D, this.worldProvider.worldType, new Packet54PlayNoteBlock(var1, var2, var3, var4, var5));
    }

    public void func_30006_w() {
        this.worldFile.func_22093_e();
    }

    protected void updateWeather() {
        boolean var1 = this.func_27068_v();
        super.updateWeather();
        if (var1 != this.func_27068_v()) {
            if (var1) {
                this.mcServer.configManager.sendPacketToAllPlayers(new Packet70Bed(2));
            } else {
                this.mcServer.configManager.sendPacketToAllPlayers(new Packet70Bed(1));
            }
        }

    }
}
