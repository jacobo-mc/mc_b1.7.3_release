package net.minecraft.src;

import java.io.IOException;

public interface IChunkLoader {
    Chunk loadChunk(World var1, int var2, int var3) throws IOException;

    void saveChunk(World var1, Chunk var2) throws IOException;

    void saveExtraChunkData(World var1, Chunk var2) throws IOException;

    void func_661_a();

    void saveExtraData();
}
