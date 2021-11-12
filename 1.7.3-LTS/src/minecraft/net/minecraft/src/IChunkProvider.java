package net.minecraft.src;

public interface IChunkProvider {
    boolean chunkExists(int var1, int var2);

    Chunk provideChunk(int var1, int var2);

    Chunk prepareChunk(int var1, int var2);

    void populate(IChunkProvider var1, int var2, int var3);

    boolean saveChunks(boolean var1, IProgressUpdate var2);

    boolean unload100OldestChunks();

    boolean canSave();

    String makeString();
}
