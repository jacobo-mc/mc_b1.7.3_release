package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChunkProviderServer implements IChunkProvider {
    private Set field_725_a = new HashSet();
    private Chunk dummyChunk;
    private IChunkProvider serverChunkGenerator;
    private IChunkLoader field_729_d;
    public boolean chunkLoadOverride = false;
    private Map id2ChunkMap = new HashMap();
    private List field_727_f = new ArrayList();
    private WorldServer world;

    public ChunkProviderServer(WorldServer var1, IChunkLoader var2, IChunkProvider var3) {
        this.dummyChunk = new EmptyChunk(var1, new byte['\u8000'], 0, 0);
        this.world = var1;
        this.field_729_d = var2;
        this.serverChunkGenerator = var3;
    }

    public boolean chunkExists(int var1, int var2) {
        return this.id2ChunkMap.containsKey(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
    }

    public void func_374_c(int var1, int var2) {
        ChunkCoordinates var3 = this.world.getSpawnPoint();
        int var4 = var1 * 16 + 8 - var3.posX;
        int var5 = var2 * 16 + 8 - var3.posZ;
        short var6 = 128;
        if (var4 < -var6 || var4 > var6 || var5 < -var6 || var5 > var6) {
            this.field_725_a.add(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
        }

    }

    public Chunk loadChunk(int var1, int var2) {
        int var3 = ChunkCoordIntPair.chunkXZ2Int(var1, var2);
        this.field_725_a.remove(var3);
        Chunk var4 = (Chunk)this.id2ChunkMap.get(var3);
        if (var4 == null) {
            var4 = this.func_4063_e(var1, var2);
            if (var4 == null) {
                if (this.serverChunkGenerator == null) {
                    var4 = this.dummyChunk;
                } else {
                    var4 = this.serverChunkGenerator.provideChunk(var1, var2);
                }
            }

            this.id2ChunkMap.put(var3, var4);
            this.field_727_f.add(var4);
            if (var4 != null) {
                var4.func_4053_c();
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
        Chunk var3 = (Chunk)this.id2ChunkMap.get(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
        if (var3 == null) {
            return !this.world.worldChunkLoadOverride && !this.chunkLoadOverride ? this.dummyChunk : this.loadChunk(var1, var2);
        } else {
            return var3;
        }
    }

    private Chunk func_4063_e(int var1, int var2) {
        if (this.field_729_d == null) {
            return null;
        } else {
            try {
                Chunk var3 = this.field_729_d.loadChunk(this.world, var1, var2);
                if (var3 != null) {
                    var3.lastSaveTime = this.world.getWorldTime();
                }

                return var3;
            } catch (Exception var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    private void func_375_a(Chunk var1) {
        if (this.field_729_d != null) {
            try {
                this.field_729_d.saveExtraChunkData(this.world, var1);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    private void func_373_b(Chunk var1) {
        if (this.field_729_d != null) {
            try {
                var1.lastSaveTime = this.world.getWorldTime();
                this.field_729_d.saveChunk(this.world, var1);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }

    public void populate(IChunkProvider var1, int var2, int var3) {
        Chunk var4 = this.provideChunk(var2, var3);
        if (!var4.isTerrainPopulated) {
            var4.isTerrainPopulated = true;
            if (this.serverChunkGenerator != null) {
                this.serverChunkGenerator.populate(var1, var2, var3);
                var4.setChunkModified();
            }
        }

    }

    public boolean saveChunks(boolean var1, IProgressUpdate var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < this.field_727_f.size(); ++var4) {
            Chunk var5 = (Chunk)this.field_727_f.get(var4);
            if (var1 && !var5.neverSave) {
                this.func_375_a(var5);
            }

            if (var5.needsSaving(var1)) {
                this.func_373_b(var5);
                var5.isModified = false;
                ++var3;
                if (var3 == 24 && !var1) {
                    return false;
                }
            }
        }

        if (var1) {
            if (this.field_729_d == null) {
                return true;
            }

            this.field_729_d.saveExtraData();
        }

        return true;
    }

    public boolean func_361_a() {
        if (!this.world.levelSaving) {
            for(int var1 = 0; var1 < 100; ++var1) {
                if (!this.field_725_a.isEmpty()) {
                    Integer var2 = (Integer)this.field_725_a.iterator().next();
                    Chunk var3 = (Chunk)this.id2ChunkMap.get(var2);
                    var3.onChunkUnload();
                    this.func_373_b(var3);
                    this.func_375_a(var3);
                    this.field_725_a.remove(var2);
                    this.id2ChunkMap.remove(var2);
                    this.field_727_f.remove(var3);
                }
            }

            if (this.field_729_d != null) {
                this.field_729_d.func_661_a();
            }
        }

        return this.serverChunkGenerator.func_361_a();
    }

    public boolean func_364_b() {
        return !this.world.levelSaving;
    }
}
