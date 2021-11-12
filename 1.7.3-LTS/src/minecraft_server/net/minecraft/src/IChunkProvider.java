package net.minecraft.src;

public interface IChunkProvider {
    boolean chunkExists(int var1, int var2);

    Chunk provideChunk(int var1, int var2);

    Chunk loadChunk(int var1, int var2);

    void populate(IChunkProvider var1, int var2, int var3);

    boolean saveChunks(boolean var1, IProgressUpdate var2);

    boolean func_361_a();

    boolean func_364_b();
}
