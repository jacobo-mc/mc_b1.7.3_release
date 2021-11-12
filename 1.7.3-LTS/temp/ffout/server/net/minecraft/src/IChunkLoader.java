package net.minecraft.src;

import java.io.IOException;

public interface IChunkLoader {
    Chunk func_659_a(World var1, int var2, int var3) throws IOException;

    void func_662_a(World var1, Chunk var2) throws IOException;

    void func_4104_b(World var1, Chunk var2) throws IOException;

    void func_661_a();

    void func_660_b();
}
