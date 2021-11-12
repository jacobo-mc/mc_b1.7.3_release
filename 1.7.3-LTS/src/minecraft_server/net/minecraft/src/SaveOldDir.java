package net.minecraft.src;

import java.io.File;
import java.util.List;

public class SaveOldDir extends PlayerNBTManager {
    public SaveOldDir(File var1, String var2, boolean var3) {
        super(var1, var2, var3);
    }

    public IChunkLoader func_22092_a(WorldProvider var1) {
        File var2 = this.getWorldDir();
        if (var1 instanceof WorldProviderHell) {
            File var3 = new File(var2, "DIM-1");
            var3.mkdirs();
            return new McRegionChunkLoader(var3);
        } else {
            return new McRegionChunkLoader(var2);
        }
    }

    public void func_22095_a(WorldInfo var1, List var2) {
        var1.setVersion(19132);
        super.func_22095_a(var1, var2);
    }

    public void func_22093_e() {
        RegionFileCache.func_22122_a();
    }
}
