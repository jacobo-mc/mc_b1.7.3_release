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

    public String func_22178_a() {
        return "Old Format";
    }

    public List func_22176_b() {
        ArrayList var1 = new ArrayList();

        for(int var2 = 0; var2 < 5; ++var2) {
            String var3 = "World" + (var2 + 1);
            WorldInfo var4 = this.func_22173_b(var3);
            if (var4 != null) {
                var1.add(new SaveFormatComparator(var3, "", var4.func_22301_l(), var4.func_22306_g(), false));
            }
        }

        return var1;
    }

    public void func_22177_c() {
    }

    public WorldInfo func_22173_b(String var1) {
        File var2 = new File(this.field_22180_a, var1);
        if (!var2.exists()) {
            return null;
        } else {
            File var3 = new File(var2, "level.dat");
            NBTTagCompound var4;
            NBTTagCompound var5;
            if (var3.exists()) {
                try {
                    var4 = CompressedStreamTools.func_1138_a(new FileInputStream(var3));
                    var5 = var4.func_743_k("Data");
                    return new WorldInfo(var5);
                } catch (Exception var7) {
                    var7.printStackTrace();
                }
            }

            var3 = new File(var2, "level.dat_old");
            if (var3.exists()) {
                try {
                    var4 = CompressedStreamTools.func_1138_a(new FileInputStream(var3));
                    var5 = var4.func_743_k("Data");
                    return new WorldInfo(var5);
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }

            return null;
        }
    }

    public void func_22170_a(String var1, String var2) {
        File var3 = new File(this.field_22180_a, var1);
        if (var3.exists()) {
            File var4 = new File(var3, "level.dat");
            if (var4.exists()) {
                try {
                    NBTTagCompound var5 = CompressedStreamTools.func_1138_a(new FileInputStream(var4));
                    NBTTagCompound var6 = var5.func_743_k("Data");
                    var6.func_754_a("LevelName", var2);
                    CompressedStreamTools.func_1143_a(var5, new FileOutputStream(var4));
                } catch (Exception var7) {
                    var7.printStackTrace();
                }
            }

        }
    }

    public void func_22172_c(String var1) {
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

    public ISaveHandler func_22174_a(String var1, boolean var2) {
        return new SaveHandler(this.field_22180_a, var1, var2);
    }

    public boolean func_22175_a(String var1) {
        return false;
    }

    public boolean func_22171_a(String var1, IProgressUpdate var2) {
        return false;
    }
}
