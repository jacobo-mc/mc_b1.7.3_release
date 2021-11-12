package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChunkProvider implements IChunkProvider {
    private Set droppedChunksSet = new HashSet();
    private Chunk emptyChunk;
    private IChunkProvider chunkProvider;
    private IChunkLoader chunkLoader;
    private Map chunkMap = new HashMap();
    private List chunkList = new ArrayList();
    private World worldObj;

    public ChunkProvider(World var1, IChunkLoader var2, IChunkProvider var3) {
        this.emptyChunk = new EmptyChunk(var1, new byte['\u8000'], 0, 0);
        this.worldObj = var1;
        this.chunkLoader = var2;
        this.chunkProvider = var3;
    }

    public boolean chunkExists(int var1, int var2) {
        return this.chunkMap.containsKey(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
    }

    public Chunk prepareChunk(int var1, int var2) {
        int var3 = ChunkCoordIntPair.chunkXZ2Int(var1, var2);
        this.droppedChunksSet.remove(var3);
        Chunk var4 = (Chunk)this.chunkMap.get(var3);
        if (var4 == null) {
            var4 = this.loadChunkFromFile(var1, var2);
            if (var4 == null) {
                if (this.chunkProvider == null) {
                    var4 = this.emptyChunk;
                } else {
                    var4 = this.chunkProvider.provideChunk(var1, var2);
                }
            }

            this.chunkMap.put(var3, var4);
            this.chunkList.add(var4);
            if (var4 != null) {
                var4.func_4143_d();
                var4.onChunkLoad();
            }

            if (!var4.isTerrainPopulated && this.chunkExists(var1 + 1, var2 + 1) && this.chunkExists(var1, var2 + 1) && this.chunkExists(var1 + 1, var2)) {
                this.populate(this, var1, var2);
            }

            if (this.chunkExists(var1 - 1, var2) && !this.provideChunk(var1 - 1, var2).isTerrainPopulated && this.chunkExists(var1 - 1, var2 + 1) && this.chunkExists(var1, var2 + 1) && this.chunkExists(var1 - 1, var2)) {
                this.populate(this, var1 - 1, var2);
            }

            if (this.chunkExists(var1, var2 - 1) && !this.provideChunk(var1, var2 - 1).isTerrainPopulated && this.chunkExists(var1 + 1, var2 - 1) && this.chunkExists(var1, var2 - 1) && this.chunkExists(var1 + 1, var2)) {
                this.populate(this, var1, var2 - 1);
            }

            if (this.chunkExists(var1 - 1, var2 - 1) && !this.provideChunk(var1 - 1, var2 - 1).isTerrainPopulated && this.chunkExists(var1 - 1, var2 - 1) && this.chunkExists(var1, var2 - 1) && this.chunkExists(var1 - 1, var2)) {
                this.populate(this, var1 - 1, var2 - 1);
            }
        }

        return var4;
    }

    public Chunk provideChunk(int var1, int var2) {
        Chunk var3 = (Chunk)this.chunkMap.get(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
        return var3 == null ? this.prepareChunk(var1, var2) : var3;
    }

    private Chunk loadChunkFromFile(int var1, int var2) {
        if (this.chunkLoader == null) {
            return null;
        } else {
            try {
                Chunk var3 = this.chunkLoader.loadChunk(this.worldObj, var1, var2);
                if (var3 != null) {
                    var3.lastSaveTime = this.worldObj.getWorldTime();
                }

                return var3;
            } catch (Exception var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    private void unloadAndSaveChunkData(Chunk var1) {
        if (this.chunkLoader != null) {
            try {
                this.chunkLoader.saveExtraChunkData(this.worldObj, var1);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    private void unloadAndSaveChunk(Chunk var1) {
        if (this.chunkLoader != null) {
            try {
                var1.lastSaveTime = this.worldObj.getWorldTime();
                this.chunkLoader.saveChunk(this.worldObj, var1);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }

    public void populate(IChunkProvider var1, int var2, int var3) {
        Chunk var4 = this.provideChunk(var2, var3);
        if (!var4.isTerrainPopulated) {
            var4.isTerrainPopulated = true;
            if (this.chunkProvider != null) {
                this.chunkProvider.populate(var1, var2, var3);
                var4.setChunkModified();
            }
        }

    }

    public boolean saveChunks(boolean var1, IProgressUpdate var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < this.chunkList.size(); ++var4) {
            Chunk var5 = (Chunk)this.chunkList.get(var4);
            if (var1 && !var5.neverSave) {
                this.unloadAndSaveChunkData(var5);
            }

            if (var5.needsSaving(var1)) {
                this.unloadAndSaveChunk(var5);
                var5.isModified = false;
                ++var3;
                if (var3 == 24 && !var1) {
                    return false;
                }
            }
        }

        if (var1) {
            if (this.chunkLoader == null) {
                return true;
            }

            this.chunkLoader.saveExtraData();
        }

        return true;
    }

    public boolean unload100OldestChunks() {
        for(int var1 = 0; var1 < 100; ++var1) {
            if (!this.droppedChunksSet.isEmpty()) {
                Integer var2 = (Integer)this.droppedChunksSet.iterator().next();
                Chunk var3 = (Chunk)this.chunkMap.get(var2);
                var3.onChunkUnload();
                this.unloadAndSaveChunk(var3);
                this.unloadAndSaveChunkData(var3);
                this.droppedChunksSet.remove(var2);
                this.chunkMap.remove(var2);
                this.chunkList.remove(var3);
            }
        }

        if (this.chunkLoader != null) {
            this.chunkLoader.chunkTick();
        }

        return this.chunkProvider.unload100OldestChunks();
    }

    public boolean canSave() {
        return true;
    }

    public String makeString() {
        return "ServerChunkCache: " + this.chunkMap.size() + " Drop: " + this.droppedChunksSet.size();
    }
}
