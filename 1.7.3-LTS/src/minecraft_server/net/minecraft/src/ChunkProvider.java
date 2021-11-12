package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChunkProvider implements IChunkProvider {
    private Set field_28062_a = new HashSet();
    private Chunk field_28061_b;
    private IChunkProvider chunkGenerator;
    private IChunkLoader field_28066_d;
    private Map field_28065_e = new HashMap();
    private List field_28064_f = new ArrayList();
    private World worldObj;

    public ChunkProvider(World var1, IChunkLoader var2, IChunkProvider var3) {
        this.field_28061_b = new EmptyChunk(var1, new byte['\u8000'], 0, 0);
        this.worldObj = var1;
        this.field_28066_d = var2;
        this.chunkGenerator = var3;
    }

    public boolean chunkExists(int var1, int var2) {
        return this.field_28065_e.containsKey(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
    }

    public Chunk loadChunk(int var1, int var2) {
        int var3 = ChunkCoordIntPair.chunkXZ2Int(var1, var2);
        this.field_28062_a.remove(var3);
        Chunk var4 = (Chunk)this.field_28065_e.get(var3);
        if (var4 == null) {
            var4 = this.func_28058_d(var1, var2);
            if (var4 == null) {
                if (this.chunkGenerator == null) {
                    var4 = this.field_28061_b;
                } else {
                    var4 = this.chunkGenerator.provideChunk(var1, var2);
                }
            }

            this.field_28065_e.put(var3, var4);
            this.field_28064_f.add(var4);
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
        Chunk var3 = (Chunk)this.field_28065_e.get(ChunkCoordIntPair.chunkXZ2Int(var1, var2));
        return var3 == null ? this.loadChunk(var1, var2) : var3;
    }

    private Chunk func_28058_d(int var1, int var2) {
        if (this.field_28066_d == null) {
            return null;
        } else {
            try {
                Chunk var3 = this.field_28066_d.loadChunk(this.worldObj, var1, var2);
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

    private void func_28060_a(Chunk var1) {
        if (this.field_28066_d != null) {
            try {
                this.field_28066_d.saveExtraChunkData(this.worldObj, var1);
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    private void func_28059_b(Chunk var1) {
        if (this.field_28066_d != null) {
            try {
                var1.lastSaveTime = this.worldObj.getWorldTime();
                this.field_28066_d.saveChunk(this.worldObj, var1);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        }
    }

    public void populate(IChunkProvider var1, int var2, int var3) {
        Chunk var4 = this.provideChunk(var2, var3);
        if (!var4.isTerrainPopulated) {
            var4.isTerrainPopulated = true;
            if (this.chunkGenerator != null) {
                this.chunkGenerator.populate(var1, var2, var3);
                var4.setChunkModified();
            }
        }

    }

    public boolean saveChunks(boolean var1, IProgressUpdate var2) {
        int var3 = 0;

        for(int var4 = 0; var4 < this.field_28064_f.size(); ++var4) {
            Chunk var5 = (Chunk)this.field_28064_f.get(var4);
            if (var1 && !var5.neverSave) {
                this.func_28060_a(var5);
            }

            if (var5.needsSaving(var1)) {
                this.func_28059_b(var5);
                var5.isModified = false;
                ++var3;
                if (var3 == 24 && !var1) {
                    return false;
                }
            }
        }

        if (var1) {
            if (this.field_28066_d == null) {
                return true;
            }

            this.field_28066_d.saveExtraData();
        }

        return true;
    }

    public boolean func_361_a() {
        for(int var1 = 0; var1 < 100; ++var1) {
            if (!this.field_28062_a.isEmpty()) {
                Integer var2 = (Integer)this.field_28062_a.iterator().next();
                Chunk var3 = (Chunk)this.field_28065_e.get(var2);
                var3.onChunkUnload();
                this.func_28059_b(var3);
                this.func_28060_a(var3);
                this.field_28062_a.remove(var2);
                this.field_28065_e.remove(var2);
                this.field_28064_f.remove(var3);
            }
        }

        if (this.field_28066_d != null) {
            this.field_28066_d.func_661_a();
        }

        return this.chunkGenerator.func_361_a();
    }

    public boolean func_364_b() {
        return true;
    }
}
