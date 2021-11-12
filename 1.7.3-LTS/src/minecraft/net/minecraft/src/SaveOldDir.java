package net.minecraft.src;

import java.io.File;
import java.util.List;

public class SaveOldDir extends SaveHandler {
    public SaveOldDir(File var1, String var2, boolean var3) {
        super(var1, var2, var3);
    }

    public IChunkLoader getChunkLoader(WorldProvider var1) {
        File var2 = this.getSaveDirectory();
        if (var1 instanceof WorldProviderHell) {
            File var3 = new File(var2, "DIM-1");
            var3.mkdirs();
            return new McRegionChunkLoader(var3);
        } else {
            return new McRegionChunkLoader(var2);
        }
    }

    public void saveWorldInfoAndPlayer(WorldInfo var1, List var2) {
        var1.setSaveVersion(19132);
        super.saveWorldInfoAndPlayer(var1, var2);
    }
}
