package net.minecraft.src;

import java.io.IOException;

public interface IChunkLoader {
    Chunk func_813_a(World var1, int var2, int var3) throws IOException;

    void func_812_a(World var1, Chunk var2) throws IOException;

    void func_815_b(World var1, Chunk var2) throws IOException;

    void func_814_a();

    void func_811_b();
}
