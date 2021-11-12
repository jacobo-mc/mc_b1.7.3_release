package net.minecraft.src;

import java.io.File;
import java.util.List;

public interface ISaveHandler {
    WorldInfo func_22096_c();

    void func_22091_b();

    IChunkLoader func_22092_a(WorldProvider var1);

    void func_22095_a(WorldInfo var1, List var2);

    void func_22094_a(WorldInfo var1);

    IPlayerFileData func_22090_d();

    void func_22093_e();

    File func_28111_b(String var1);
}
