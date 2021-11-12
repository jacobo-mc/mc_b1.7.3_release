package net.minecraft.src;

import java.io.File;
import java.util.regex.Matcher;

class ChunkFile implements Comparable {
    private final File chunkFile;
    private final int xChunk;
    private final int yChunk;

    public ChunkFile(File var1) {
        this.chunkFile = var1;
        Matcher var2 = ChunkFilePattern.dataFilenamePattern.matcher(var1.getName());
        if (var2.matches()) {
            this.xChunk = Integer.parseInt(var2.group(1), 36);
            this.yChunk = Integer.parseInt(var2.group(2), 36);
        } else {
            this.xChunk = 0;
            this.yChunk = 0;
        }

    }

    public int compareChunks(ChunkFile var1) {
        int var2 = this.xChunk >> 5;
        int var3 = var1.xChunk >> 5;
        if (var2 == var3) {
            int var4 = this.yChunk >> 5;
            int var5 = var1.yChunk >> 5;
            return var4 - var5;
        } else {
            return var2 - var3;
        }
    }

    public File getChunkFile() {
        return this.chunkFile;
    }

    public int getXChunk() {
        return this.xChunk;
    }

    public int getYChunk() {
        return this.yChunk;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.compareChunks((ChunkFile)var1);
    }
}
