package net.minecraft.src;

import java.io.File;
import java.util.List;

public interface ISaveHandler {
    WorldInfo loadWorldInfo();

    void checkSessionLock();

    IChunkLoader getChunkLoader(WorldProvider var1);

    void saveWorldInfoAndPlayer(WorldInfo var1, List var2);

    void saveWorldInfo(WorldInfo var1);

    File getMapFile(String var1);
}
