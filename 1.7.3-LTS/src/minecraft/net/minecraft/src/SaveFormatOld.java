package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveFormatOld implements ISaveFormat {
    protected final File field_22180_a;

    public SaveFormatOld(File var1) {
        if (!var1.exists()) {
            var1.mkdirs();
        }

        this.field_22180_a = var1;
    }

    public String getWorldFormat() {
        return "Old Format";
    }

    public List getSaveList() {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < 5; ++var2) {
            String var3 = "World" + (var2 + 1);
            WorldInfo var4 = this.getWorldInfo(var3);
            if (var4 != null) {
                var1.add(new SaveFormatComparator(var3, "", var4.getLastTimePlayed(), var4.getSizeOnDisk(), false));
            }
        }

        return var1;
    }

    public void flushCache() {
    }

    public WorldInfo getWorldInfo(String var1) {
        File var2 = new File(this.field_22180_a, var1);
        if (!var2.exists()) {
            return null;
        } else {
            File var3 = new File(var2, "level.dat");
            NBTTagCompound var4;
            NBTTagCompound var5;
            if (var3.exists()) {
                try {
                    var4 = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(var3));
                    var5 = var4.getCompoundTag("Data");
                    return new WorldInfo(var5);
                } catch (Exception var7) {
                    var7.printStackTrace();
                }
            }

            var3 = new File(var2, "level.dat_old");
            if (var3.exists()) {
                try {
                    var4 = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(var3));
                    var5 = var4.getCompoundTag("Data");
                    return new WorldInfo(var5);
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }

            return null;
        }
    }

    public void renameWorld(String var1, String var2) {
        File var3 = new File(this.field_22180_a, var1);
        if (var3.exists()) {
            File var4 = new File(var3, "level.dat");
            if (var4.exists()) {
                try {
                    NBTTagCompound var5 = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(var4));
                    NBTTagCompound var6 = var5.getCompoundTag("Data");
                    var6.setString("LevelName", var2);
                    CompressedStreamTools.writeGzippedCompoundToOutputStream(var5, new FileOutputStream(var4));
                } catch (Exception var7) {
                    var7.printStackTrace();
                }
            }

        }
    }

    public void deleteWorldDirectory(String var1) {
        File var2 = new File(this.field_22180_a, var1);
        if (var2.exists()) {
            func_22179_a(var2.listFiles());
            var2.delete();
        }
    }

    protected static void func_22179_a(File[] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
            if (var0[var1].isDirectory()) {
                func_22179_a(var0[var1].listFiles());
            }

            var0[var1].delete();
        }

    }

    public ISaveHandler getSaveLoader(String var1, boolean var2) {
        return new SaveHandler(this.field_22180_a, var1, var2);
    }

    public boolean isOldMapFormat(String var1) {
        return false;
    }

    public boolean convertMapFormat(String var1, IProgressUpdate var2) {
        return false;
    }
}
