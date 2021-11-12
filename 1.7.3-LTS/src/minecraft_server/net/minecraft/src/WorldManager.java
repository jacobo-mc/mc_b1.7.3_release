package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class WorldManager implements IWorldAccess {
    private MinecraftServer mcServer;
    private WorldServer field_28134_b;

    public WorldManager(MinecraftServer var1, WorldServer var2) {
        this.mcServer = var1;
        this.field_28134_b = var2;
    }

    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
    }

    public void obtainEntitySkin(Entity var1) {
        this.mcServer.getEntityTracker(this.field_28134_b.worldProvider.worldType).trackEntity(var1);
    }

    public void releaseEntitySkin(Entity var1) {
        this.mcServer.getEntityTracker(this.field_28134_b.worldProvider.worldType).untrackEntity(var1);
    }

    public void playSound(String var1, double var2, double var4, double var6, float var8, float var9) {
    }

    public void markBlockRangeNeedsUpdate(int var1, int var2, int var3, int var4, int var5, int var6) {
    }

    public void updateAllRenderers() {
    }

    public void markBlockNeedsUpdate(int var1, int var2, int var3) {
        this.mcServer.configManager.markBlockNeedsUpdate(var1, var2, var3, this.field_28134_b.worldProvider.worldType);
    }

    public void playRecord(String var1, int var2, int var3, int var4) {
    }

    public void doNothingWithTileEntity(int var1, int var2, int var3, TileEntity var4) {
        this.mcServer.configManager.sentTileEntityToPlayer(var1, var2, var3, var4);
    }

    public void func_28133_a(EntityPlayer var1, int var2, int var3, int var4, int var5, int var6) {
        this.mcServer.configManager.func_28171_a(var1, (double)var3, (double)var4, (double)var5, 64.0D, this.field_28134_b.worldProvider.worldType, new Packet61DoorChange(var2, var3, var4, var5, var6));
    }
}
