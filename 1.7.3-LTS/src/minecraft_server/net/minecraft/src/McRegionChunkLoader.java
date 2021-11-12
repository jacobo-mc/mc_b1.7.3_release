package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class McRegionChunkLoader implements IChunkLoader {
    private final File worldFolder;

    public McRegionChunkLoader(File var1) {
        this.worldFolder = var1;
    }

    public Chunk loadChunk(World var1, int var2, int var3) throws IOException {
        DataInputStream var4 = RegionFileCache.func_22124_c(this.worldFolder, var2, var3);
        if (var4 != null) {
            NBTTagCompound var5 = CompressedStreamTools.func_774_a(var4);
            if (!var5.hasKey("Level")) {
                System.out.println("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
                return null;
            } else if (!var5.getCompoundTag("Level").hasKey("Blocks")) {
                System.out.println("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
                return null;
            } else {
                Chunk var6 = ChunkLoader.loadChunkIntoWorldFromCompound(var1, var5.getCompoundTag("Level"));
                if (!var6.isAtLocation(var2, var3)) {
                    System.out.println("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.xPosition + ", " + var6.zPosition + ")");
                    var5.setInteger("xPos", var2);
                    var5.setInteger("zPos", var3);
                    var6 = ChunkLoader.loadChunkIntoWorldFromCompound(var1, var5.getCompoundTag("Level"));
                }

                var6.func_25083_h();
                return var6;
            }
        } else {
            return null;
        }
    }

    public void saveChunk(World var1, Chunk var2) throws IOException {
        var1.checkSessionLock();

        try {
            DataOutputStream var3 = RegionFileCache.func_22120_d(this.worldFolder, var2.xPosition, var2.zPosition);
            NBTTagCompound var4 = new NBTTagCompound();
            NBTTagCompound var5 = new NBTTagCompound();
            var4.setTag("Level", var5);
            ChunkLoader.storeChunkInCompound(var2, var1, var5);
            CompressedStreamTools.func_771_a(var4, var3);
            var3.close();
            WorldInfo var6 = var1.getWorldInfo();
            var6.setSizeOnDisk(var6.getSizeOnDisk() + (long)RegionFileCache.func_22121_b(this.worldFolder, var2.xPosition, var2.zPosition));
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public void saveExtraChunkData(World var1, Chunk var2) throws IOException {
    }

    public void func_661_a() {
    }

    public void saveExtraData() {
    }
}
