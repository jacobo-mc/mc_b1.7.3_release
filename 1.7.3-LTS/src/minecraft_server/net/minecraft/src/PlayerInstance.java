package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

class PlayerInstance {
    private List players;
    private int chunkX;
    private int chunkZ;
    private ChunkCoordIntPair currentChunk;
    private short[] blocksToUpdate;
    private int numBlocksToUpdate;
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private int minZ;
    private int maxZ;
    // $FF: synthetic field
    final PlayerManager playerManager;

    public PlayerInstance(PlayerManager var1, int var2, int var3) {
        this.playerManager = var1;
        this.players = new ArrayList();
        this.blocksToUpdate = new short[10];
        this.numBlocksToUpdate = 0;
        this.chunkX = var2;
        this.chunkZ = var3;
        this.currentChunk = new ChunkCoordIntPair(var2, var3);
        var1.getMinecraftServer().chunkProviderServer.loadChunk(var2, var3);
    }

    public void addPlayer(EntityPlayerMP var1) {
        if (this.players.contains(var1)) {
            throw new IllegalStateException("Failed to add player. " + var1 + " already is in chunk " + this.chunkX + ", " + this.chunkZ);
        } else {
            var1.field_420_ah.add(this.currentChunk);
            var1.playerNetServerHandler.sendPacket(new Packet50PreChunk(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos, true));
            this.players.add(var1);
            var1.loadedChunks.add(this.currentChunk);
        }
    }

    public void removePlayer(EntityPlayerMP var1) {
        if (this.players.contains(var1)) {
            this.players.remove(var1);
            if (this.players.size() == 0) {
                long var2 = (long)this.chunkX + 2147483647L | (long)this.chunkZ + 2147483647L << 32;
                PlayerManager.getPlayerInstances(this.playerManager).remove(var2);
                if (this.numBlocksToUpdate > 0) {
                    PlayerManager.getPlayerInstancesToUpdate(this.playerManager).remove(this);
                }

                this.playerManager.getMinecraftServer().chunkProviderServer.func_374_c(this.chunkX, this.chunkZ);
            }

            var1.loadedChunks.remove(this.currentChunk);
            if (var1.field_420_ah.contains(this.currentChunk)) {
                var1.playerNetServerHandler.sendPacket(new Packet50PreChunk(this.chunkX, this.chunkZ, false));
            }

        }
    }

    public void markBlockNeedsUpdate(int var1, int var2, int var3) {
        if (this.numBlocksToUpdate == 0) {
            PlayerManager.getPlayerInstancesToUpdate(this.playerManager).add(this);
            this.minX = this.maxX = var1;
            this.minY = this.maxY = var2;
            this.minZ = this.maxZ = var3;
        }

        if (this.minX > var1) {
            this.minX = var1;
        }

        if (this.maxX < var1) {
            this.maxX = var1;
        }

        if (this.minY > var2) {
            this.minY = var2;
        }

        if (this.maxY < var2) {
            this.maxY = var2;
        }

        if (this.minZ > var3) {
            this.minZ = var3;
        }

        if (this.maxZ < var3) {
            this.maxZ = var3;
        }

        if (this.numBlocksToUpdate < 10) {
            short var4 = (short)(var1 << 12 | var3 << 8 | var2);

            for(int var5 = 0; var5 < this.numBlocksToUpdate; ++var5) {
                if (this.blocksToUpdate[var5] == var4) {
                    return;
                }
            }

            this.blocksToUpdate[this.numBlocksToUpdate++] = var4;
        }

    }

    public void sendPacketToPlayersInInstance(Packet var1) {
        for(int var2 = 0; var2 < this.players.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.players.get(var2);
            if (var3.field_420_ah.contains(this.currentChunk)) {
                var3.playerNetServerHandler.sendPacket(var1);
            }
        }

    }

    public void onUpdate() {
        WorldServer var1 = this.playerManager.getMinecraftServer();
        if (this.numBlocksToUpdate != 0) {
            int var2;
            int var3;
            int var4;
            if (this.numBlocksToUpdate == 1) {
                var2 = this.chunkX * 16 + this.minX;
                var3 = this.minY;
                var4 = this.chunkZ * 16 + this.minZ;
                this.sendPacketToPlayersInInstance(new Packet53BlockChange(var2, var3, var4, var1));
                if (Block.isBlockContainer[var1.getBlockId(var2, var3, var4)]) {
                    this.updateTileEntity(var1.getBlockTileEntity(var2, var3, var4));
                }
            } else {
                int var5;
                if (this.numBlocksToUpdate == 10) {
                    this.minY = this.minY / 2 * 2;
                    this.maxY = (this.maxY / 2 + 1) * 2;
                    var2 = this.minX + this.chunkX * 16;
                    var3 = this.minY;
                    var4 = this.minZ + this.chunkZ * 16;
                    var5 = this.maxX - this.minX + 1;
                    int var6 = this.maxY - this.minY + 2;
                    int var7 = this.maxZ - this.minZ + 1;
                    this.sendPacketToPlayersInInstance(new Packet51MapChunk(var2, var3, var4, var5, var6, var7, var1));
                    List var8 = var1.getTileEntityList(var2, var3, var4, var2 + var5, var3 + var6, var4 + var7);

                    for(int var9 = 0; var9 < var8.size(); ++var9) {
                        this.updateTileEntity((TileEntity)var8.get(var9));
                    }
                } else {
                    this.sendPacketToPlayersInInstance(new Packet52MultiBlockChange(this.chunkX, this.chunkZ, this.blocksToUpdate, this.numBlocksToUpdate, var1));

                    for(var2 = 0; var2 < this.numBlocksToUpdate; ++var2) {
                        var3 = this.chunkX * 16 + (this.numBlocksToUpdate >> 12 & 15);
                        var4 = this.numBlocksToUpdate & 255;
                        var5 = this.chunkZ * 16 + (this.numBlocksToUpdate >> 8 & 15);
                        if (Block.isBlockContainer[var1.getBlockId(var3, var4, var5)]) {
                            System.out.println("Sending!");
                            this.updateTileEntity(var1.getBlockTileEntity(var3, var4, var5));
                        }
                    }
                }
            }

            this.numBlocksToUpdate = 0;
        }
    }

    private void updateTileEntity(TileEntity var1) {
        if (var1 != null) {
            Packet var2 = var1.getDescriptionPacket();
            if (var2 != null) {
                this.sendPacketToPlayersInInstance(var2);
            }
        }

    }
}
