package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class PlayerNBTManager implements IPlayerFileData, ISaveHandler {
    private static final Logger field_1003_a = Logger.getLogger("Minecraft");
    private final File field_22099_b;
    private final File field_1002_b;
    private final File field_28112_d;
    private final long field_22100_d = System.currentTimeMillis();

    public PlayerNBTManager(File var1, String var2, boolean var3) {
        this.field_22099_b = new File(var1, var2);
        this.field_22099_b.mkdirs();
        this.field_1002_b = new File(this.field_22099_b, "players");
        this.field_28112_d = new File(this.field_22099_b, "data");
        this.field_28112_d.mkdirs();
        if (var3) {
            this.field_1002_b.mkdirs();
        }

        this.func_22098_f();
    }

    private void func_22098_f() {
        try {
            File var1 = new File(this.field_22099_b, "session.lock");
            DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

            try {
                var2.writeLong(this.field_22100_d);
            } finally {
                var2.close();
            }

        } catch (IOException var7) {
            var7.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    protected File func_22097_a() {
        return this.field_22099_b;
    }

    public void func_22091_b() {
        try {
            File var1 = new File(this.field_22099_b, "session.lock");
            DataInputStream var2 = new DataInputStream(new FileInputStream(var1));

            try {
                if (var2.readLong() != this.field_22100_d) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            } finally {
                var2.close();
            }

        } catch (IOException var7) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    public IChunkLoader func_22092_a(WorldProvider var1) {
        if (var1 instanceof WorldProviderHell) {
            File var2 = new File(this.field_22099_b, "DIM-1");
            var2.mkdirs();
            return new ChunkLoader(var2, true);
        } else {
            return new ChunkLoader(this.field_22099_b, true);
        }
    }

    public WorldInfo func_22096_c() {
        File var1 = new File(this.field_22099_b, "level.dat");
        NBTTagCompound var2;
        NBTTagCompound var3;
        if (var1.exists()) {
            try {
                var2 = CompressedStreamTools.func_770_a(new FileInputStream(var1));
                var3 = var2.func_397_j("Data");
                return new WorldInfo(var3);
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

        var1 = new File(this.field_22099_b, "level.dat_old");
        if (var1.exists()) {
            try {
                var2 = CompressedStreamTools.func_770_a(new FileInputStream(var1));
                var3 = var2.func_397_j("Data");
                return new WorldInfo(var3);
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        return null;
    }

    public void func_22095_a(WorldInfo var1, List var2) {
        NBTTagCompound var3 = var1.func_22183_a(var2);
        NBTTagCompound var4 = new NBTTagCompound();
        var4.func_399_a("Data", var3);

        try {
            File var5 = new File(this.field_22099_b, "level.dat_new");
            File var6 = new File(this.field_22099_b, "level.dat_old");
            File var7 = new File(this.field_22099_b, "level.dat");
            CompressedStreamTools.func_769_a(var4, new FileOutputStream(var5));
            if (var6.exists()) {
                var6.delete();
            }

            var7.renameTo(var6);
            if (var7.exists()) {
                var7.delete();
            }

            var5.renameTo(var7);
            if (var5.exists()) {
                var5.delete();
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }

    public void func_22094_a(WorldInfo var1) {
        NBTTagCompound var2 = var1.func_22185_a();
        NBTTagCompound var3 = new NBTTagCompound();
        var3.func_399_a("Data", var2);

        try {
            File var4 = new File(this.field_22099_b, "level.dat_new");
            File var5 = new File(this.field_22099_b, "level.dat_old");
            File var6 = new File(this.field_22099_b, "level.dat");
            CompressedStreamTools.func_769_a(var3, new FileOutputStream(var4));
            if (var5.exists()) {
                var5.delete();
            }

            var6.renameTo(var5);
            if (var6.exists()) {
                var6.delete();
            }

            var4.renameTo(var6);
            if (var4.exists()) {
                var4.delete();
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public void func_726_a(EntityPlayer var1) {
        try {
            NBTTagCompound var2 = new NBTTagCompound();
            var1.func_98_d(var2);
            File var3 = new File(this.field_1002_b, "_tmp_.dat");
            File var4 = new File(this.field_1002_b, var1.field_409_aq + ".dat");
            CompressedStreamTools.func_769_a(var2, new FileOutputStream(var3));
            if (var4.exists()) {
                var4.delete();
            }

            var3.renameTo(var4);
        } catch (Exception var5) {
            field_1003_a.warning("Failed to save player data for " + var1.field_409_aq);
        }

    }

    public void func_725_b(EntityPlayer var1) {
        NBTTagCompound var2 = this.func_25074_a(var1.field_409_aq);
        if (var2 != null) {
            var1.func_100_e(var2);
        }

    }

    public NBTTagCompound func_25074_a(String var1) {
        try {
            File var2 = new File(this.field_1002_b, var1 + ".dat");
            if (var2.exists()) {
                return CompressedStreamTools.func_770_a(new FileInputStream(var2));
            }
        } catch (Exception var3) {
            field_1003_a.warning("Failed to load player data for " + var1);
        }

        return null;
    }

    public IPlayerFileData func_22090_d() {
        return this;
    }

    public void func_22093_e() {
    }

    public File func_28111_b(String var1) {
        return new File(this.field_28112_d, var1 + ".dat");
    }
}
