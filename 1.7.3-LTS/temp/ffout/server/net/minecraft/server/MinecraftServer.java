package net.minecraft.server;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ConsoleCommandHandler;
import net.minecraft.src.ConsoleLogManager;
import net.minecraft.src.ConvertProgressUpdater;
import net.minecraft.src.EntityTracker;
import net.minecraft.src.ICommandListener;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.IUpdatePlayerListBox;
import net.minecraft.src.NetworkListenThread;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.PropertyManager;
import net.minecraft.src.SaveConverterMcRegion;
import net.minecraft.src.SaveOldDir;
import net.minecraft.src.ServerCommand;
import net.minecraft.src.ServerConfigurationManager;
import net.minecraft.src.ServerGUI;
import net.minecraft.src.StatList;
import net.minecraft.src.ThreadCommandReader;
import net.minecraft.src.ThreadServerApplication;
import net.minecraft.src.ThreadSleepForever;
import net.minecraft.src.Vec3D;
import net.minecraft.src.WorldManager;
import net.minecraft.src.WorldServer;
import net.minecraft.src.WorldServerMulti;

public class MinecraftServer implements Runnable, ICommandListener {
    public static Logger field_6038_a = Logger.getLogger("Minecraft");
    public static HashMap field_6037_b = new HashMap();
    public NetworkListenThread field_6036_c;
    public PropertyManager field_6035_d;
    public WorldServer[] field_6034_e;
    public ServerConfigurationManager field_6033_f;
    private ConsoleCommandHandler field_22005_o;
    private boolean field_6025_n = true;
    public boolean field_6032_g = false;
    int field_9014_h = 0;
    public String field_9013_i;
    public int field_9012_j;
    private List field_9010_p = new ArrayList();
    private List field_6023_p = Collections.synchronizedList(new ArrayList());
    public EntityTracker[] field_6028_k = new EntityTracker[2];
    public boolean field_6027_l;
    public boolean field_6026_m;
    public boolean field_9011_n;
    public boolean field_27005_o;

    public MinecraftServer() {
        new ThreadSleepForever(this);
    }

    private boolean func_6008_d() throws UnknownHostException {
        this.field_22005_o = new ConsoleCommandHandler(this);
        ThreadCommandReader var1 = new ThreadCommandReader(this);
        var1.setDaemon(true);
        var1.start();
        ConsoleLogManager.func_641_a();
        field_6038_a.info("Starting minecraft server version Beta 1.7.3");
        if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
            field_6038_a.warning("**** NOT ENOUGH RAM!");
            field_6038_a.warning("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
        }

        field_6038_a.info("Loading properties");
        this.field_6035_d = new PropertyManager(new File("server.properties"));
        String var2 = this.field_6035_d.func_720_a("server-ip", "");
        this.field_6027_l = this.field_6035_d.func_724_a("online-mode", true);
        this.field_6026_m = this.field_6035_d.func_724_a("spawn-animals", true);
        this.field_9011_n = this.field_6035_d.func_724_a("pvp", true);
        this.field_27005_o = this.field_6035_d.func_724_a("allow-flight", false);
        InetAddress var3 = null;
        if (var2.length() > 0) {
            var3 = InetAddress.getByName(var2);
        }

        int var4 = this.field_6035_d.func_722_a("server-port", 25565);
        field_6038_a.info("Starting Minecraft server on " + (var2.length() == 0 ? "*" : var2) + ":" + var4);

        try {
            this.field_6036_c = new NetworkListenThread(this, var3, var4);
        } catch (IOException var13) {
            field_6038_a.warning("**** FAILED TO BIND TO PORT!");
            field_6038_a.log(Level.WARNING, "The exception was: " + var13.toString());
            field_6038_a.warning("Perhaps a server is already running on that port?");
            return false;
        }

        if (!this.field_6027_l) {
            field_6038_a.warning("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            field_6038_a.warning("The server will make no attempt to authenticate usernames. Beware.");
            field_6038_a.warning("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            field_6038_a.warning("To change this, set \"online-mode\" to \"true\" in the server.settings file.");
        }

        this.field_6033_f = new ServerConfigurationManager(this);
        this.field_6028_k[0] = new EntityTracker(this, 0);
        this.field_6028_k[1] = new EntityTracker(this, -1);
        long var5 = System.nanoTime();
        String var7 = this.field_6035_d.func_720_a("level-name", "world");
        String var8 = this.field_6035_d.func_720_a("level-seed", "");
        long var9 = (new Random()).nextLong();
        if (var8.length() > 0) {
            try {
                var9 = Long.parseLong(var8);
            } catch (NumberFormatException var12) {
                var9 = (long)var8.hashCode();
            }
        }

        field_6038_a.info("Preparing level \"" + var7 + "\"");
        this.func_6017_c(new SaveConverterMcRegion(new File(".")), var7, var9);
        field_6038_a.info("Done (" + (System.nanoTime() - var5) + "ns)! For help, type \"help\" or \"?\"");
        return true;
    }

    private void func_6017_c(ISaveFormat var1, String var2, long var3) {
        if (var1.func_22102_a(var2)) {
            field_6038_a.info("Converting map!");
            var1.func_22101_a(var2, new ConvertProgressUpdater(this));
        }

        this.field_6034_e = new WorldServer[2];
        SaveOldDir var5 = new SaveOldDir(new File("."), var2, true);

        for(int var6 = 0; var6 < this.field_6034_e.length; ++var6) {
            if (var6 == 0) {
                this.field_6034_e[var6] = new WorldServer(this, var5, var2, var6 == 0 ? 0 : -1, var3);
            } else {
                this.field_6034_e[var6] = new WorldServerMulti(this, var5, var2, var6 == 0 ? 0 : -1, var3, this.field_6034_e[0]);
            }

            this.field_6034_e[var6].func_4072_a(new WorldManager(this, this.field_6034_e[var6]));
            this.field_6034_e[var6].field_804_l = this.field_6035_d.func_724_a("spawn-monsters", true) ? 1 : 0;
            this.field_6034_e[var6].func_21116_a(this.field_6035_d.func_724_a("spawn-monsters", true), this.field_6026_m);
            this.field_6033_f.func_618_a(this.field_6034_e);
        }

        short var18 = 196;
        long var7 = System.currentTimeMillis();

        for(int var9 = 0; var9 < this.field_6034_e.length; ++var9) {
            field_6038_a.info("Preparing start region for level " + var9);
            if (var9 == 0 || this.field_6035_d.func_724_a("allow-nether", true)) {
                WorldServer var10 = this.field_6034_e[var9];
                ChunkCoordinates var11 = var10.func_22078_l();

                for(int var12 = -var18; var12 <= var18 && this.field_6025_n; var12 += 16) {
                    for(int var13 = -var18; var13 <= var18 && this.field_6025_n; var13 += 16) {
                        long var14 = System.currentTimeMillis();
                        if (var14 < var7) {
                            var7 = var14;
                        }

                        if (var14 > var7 + 1000L) {
                            int var16 = (var18 * 2 + 1) * (var18 * 2 + 1);
                            int var17 = (var12 + var18) * (var18 * 2 + 1) + var13 + 1;
                            this.func_6019_a("Preparing spawn area", var17 * 100 / var16);
                            var7 = var14;
                        }

                        var10.field_20911_y.func_376_d(var11.field_22216_a + var12 >> 4, var11.field_528_b + var13 >> 4);

                        while(var10.func_6156_d() && this.field_6025_n) {
                        }
                    }
                }
            }
        }

        this.func_6011_e();
    }

    private void func_6019_a(String var1, int var2) {
        this.field_9013_i = var1;
        this.field_9012_j = var2;
        field_6038_a.info(var1 + ": " + var2 + "%");
    }

    private void func_6011_e() {
        this.field_9013_i = null;
        this.field_9012_j = 0;
    }

    private void func_6012_f() {
        field_6038_a.info("Saving chunks");

        for(int var1 = 0; var1 < this.field_6034_e.length; ++var1) {
            WorldServer var2 = this.field_6034_e[var1];
            var2.func_485_a(true, (IProgressUpdate)null);
            var2.func_30006_w();
        }

    }

    private void func_6013_g() {
        field_6038_a.info("Stopping server");
        if (this.field_6033_f != null) {
            this.field_6033_f.func_617_d();
        }

        for(int var1 = 0; var1 < this.field_6034_e.length; ++var1) {
            WorldServer var2 = this.field_6034_e[var1];
            if (var2 != null) {
                this.func_6012_f();
            }
        }

    }

    public void func_6016_a() {
        this.field_6025_n = false;
    }

    public void run() {
        try {
            if (this.func_6008_d()) {
                long var1 = System.currentTimeMillis();

                for(long var3 = 0L; this.field_6025_n; Thread.sleep(1L)) {
                    long var5 = System.currentTimeMillis();
                    long var7 = var5 - var1;
                    if (var7 > 2000L) {
                        field_6038_a.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        var7 = 2000L;
                    }

                    if (var7 < 0L) {
                        field_6038_a.warning("Time ran backwards! Did the system time change?");
                        var7 = 0L;
                    }

                    var3 += var7;
                    var1 = var5;
                    if (this.field_6034_e[0].func_22084_q()) {
                        this.func_6018_h();
                        var3 = 0L;
                    } else {
                        while(var3 > 50L) {
                            var3 -= 50L;
                            this.func_6018_h();
                        }
                    }
                }
            } else {
                while(this.field_6025_n) {
                    this.func_6021_b();

                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException var57) {
                        var57.printStackTrace();
                    }
                }
            }
        } catch (Throwable var58) {
            var58.printStackTrace();
            field_6038_a.log(Level.SEVERE, "Unexpected exception", var58);

            while(this.field_6025_n) {
                this.func_6021_b();

                try {
                    Thread.sleep(10L);
                } catch (InterruptedException var56) {
                    var56.printStackTrace();
                }
            }
        } finally {
            try {
                this.func_6013_g();
                this.field_6032_g = true;
            } catch (Throwable var54) {
                var54.printStackTrace();
            } finally {
                System.exit(0);
            }

        }

    }

    private void func_6018_h() {
        ArrayList var1 = new ArrayList();
        Iterator var2 = field_6037_b.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            int var4 = (Integer)field_6037_b.get(var3);
            if (var4 > 0) {
                field_6037_b.put(var3, var4 - 1);
            } else {
                var1.add(var3);
            }
        }

        int var6;
        for(var6 = 0; var6 < var1.size(); ++var6) {
            field_6037_b.remove(var1.get(var6));
        }

        AxisAlignedBB.func_703_a();
        Vec3D.func_761_a();
        ++this.field_9014_h;

        for(var6 = 0; var6 < this.field_6034_e.length; ++var6) {
            if (var6 == 0 || this.field_6035_d.func_724_a("allow-nether", true)) {
                WorldServer var7 = this.field_6034_e[var6];
                if (this.field_9014_h % 20 == 0) {
                    this.field_6033_f.func_28169_a(new Packet4UpdateTime(var7.func_22080_k()), var7.field_4272_q.field_6165_g);
                }

                var7.func_22077_g();

                while(var7.func_6156_d()) {
                }

                var7.func_459_b();
            }
        }

        this.field_6036_c.func_715_a();
        this.field_6033_f.func_637_b();

        for(var6 = 0; var6 < this.field_6028_k.length; ++var6) {
            this.field_6028_k[var6].func_607_a();
        }

        for(var6 = 0; var6 < this.field_9010_p.size(); ++var6) {
            ((IUpdatePlayerListBox)this.field_9010_p.get(var6)).func_690_a();
        }

        try {
            this.func_6021_b();
        } catch (Exception var5) {
            field_6038_a.log(Level.WARNING, "Unexpected exception while parsing console command", var5);
        }

    }

    public void func_6010_a(String var1, ICommandListener var2) {
        this.field_6023_p.add(new ServerCommand(var1, var2));
    }

    public void func_6021_b() {
        while(this.field_6023_p.size() > 0) {
            ServerCommand var1 = (ServerCommand)this.field_6023_p.remove(0);
            this.field_22005_o.func_22114_a(var1);
        }

    }

    public void func_6022_a(IUpdatePlayerListBox var1) {
        this.field_9010_p.add(var1);
    }

    public static void main(String[] var0) {
        StatList.func_27092_a();

        try {
            MinecraftServer var1 = new MinecraftServer();
            if (!GraphicsEnvironment.isHeadless() && (var0.length <= 0 || !var0[0].equals("nogui"))) {
                ServerGUI.func_46_a(var1);
            }

            (new ThreadServerApplication("Server thread", var1)).start();
        } catch (Exception var2) {
            field_6038_a.log(Level.SEVERE, "Failed to start the minecraft server", var2);
        }

    }

    public File func_6009_a(String var1) {
        return new File(var1);
    }

    public void func_2_b(String var1) {
        field_6038_a.info(var1);
    }

    public void func_25002_c(String var1) {
        field_6038_a.warning(var1);
    }

    public String func_1_c() {
        return "CONSOLE";
    }

    public WorldServer func_28004_a(int var1) {
        return var1 == -1 ? this.field_6034_e[1] : this.field_6034_e[0];
    }

    public EntityTracker func_28003_b(int var1) {
        return var1 == -1 ? this.field_6028_k[1] : this.field_6028_k[0];
    }

    // $FF: synthetic method
    public static boolean func_6015_a(MinecraftServer var0) {
        return var0.field_6025_n;
    }
}
