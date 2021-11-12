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
    public static Logger logger = Logger.getLogger("Minecraft");
    public static HashMap field_6037_b = new HashMap();
    public NetworkListenThread networkServer;
    public PropertyManager propertyManagerObj;
    public WorldServer[] worldMngr;
    public ServerConfigurationManager configManager;
    private ConsoleCommandHandler commandHandler;
    private boolean serverRunning = true;
    public boolean serverStopped = false;
    int deathTime = 0;
    public String currentTask;
    public int percentDone;
    private List field_9010_p = new ArrayList();
    private List commands = Collections.synchronizedList(new ArrayList());
    public EntityTracker[] entityTracker = new EntityTracker[2];
    public boolean onlineMode;
    public boolean spawnPeacefulMobs;
    public boolean pvpOn;
    public boolean allowFlight;

    public MinecraftServer() {
        new ThreadSleepForever(this);
    }

    private boolean startServer() throws UnknownHostException {
        this.commandHandler = new ConsoleCommandHandler(this);
        ThreadCommandReader var1 = new ThreadCommandReader(this);
        var1.setDaemon(true);
        var1.start();
        ConsoleLogManager.init();
        logger.info("Starting minecraft server version Beta 1.7.3");
        if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
            logger.warning("**** NOT ENOUGH RAM!");
            logger.warning("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
        }

        logger.info("Loading properties");
        this.propertyManagerObj = new PropertyManager(new File("server.properties"));
        String var2 = this.propertyManagerObj.getStringProperty("server-ip", "");
        this.onlineMode = this.propertyManagerObj.getBooleanProperty("online-mode", true);
        this.spawnPeacefulMobs = this.propertyManagerObj.getBooleanProperty("spawn-animals", true);
        this.pvpOn = this.propertyManagerObj.getBooleanProperty("pvp", true);
        this.allowFlight = this.propertyManagerObj.getBooleanProperty("allow-flight", false);
        InetAddress var3 = null;
        if (var2.length() > 0) {
            var3 = InetAddress.getByName(var2);
        }

        int var4 = this.propertyManagerObj.getIntProperty("server-port", 25565);
        logger.info("Starting Minecraft server on " + (var2.length() == 0 ? "*" : var2) + ":" + var4);

        try {
            this.networkServer = new NetworkListenThread(this, var3, var4);
        } catch (IOException var13) {
            logger.warning("**** FAILED TO BIND TO PORT!");
            logger.log(Level.WARNING, "The exception was: " + var13.toString());
            logger.warning("Perhaps a server is already running on that port?");
            return false;
        }

        if (!this.onlineMode) {
            logger.warning("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            logger.warning("The server will make no attempt to authenticate usernames. Beware.");
            logger.warning("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            logger.warning("To change this, set \"online-mode\" to \"true\" in the server.settings file.");
        }

        this.configManager = new ServerConfigurationManager(this);
        this.entityTracker[0] = new EntityTracker(this, 0);
        this.entityTracker[1] = new EntityTracker(this, -1);
        long var5 = System.nanoTime();
        String var7 = this.propertyManagerObj.getStringProperty("level-name", "world");
        String var8 = this.propertyManagerObj.getStringProperty("level-seed", "");
        long var9 = (new Random()).nextLong();
        if (var8.length() > 0) {
            try {
                var9 = Long.parseLong(var8);
            } catch (NumberFormatException var12) {
                var9 = (long)var8.hashCode();
            }
        }

        logger.info("Preparing level \"" + var7 + "\"");
        this.initWorld(new SaveConverterMcRegion(new File(".")), var7, var9);
        logger.info("Done (" + (System.nanoTime() - var5) + "ns)! For help, type \"help\" or \"?\"");
        return true;
    }

    private void initWorld(ISaveFormat var1, String var2, long var3) {
        if (var1.isOldSaveType(var2)) {
            logger.info("Converting map!");
            var1.converMapToMCRegion(var2, new ConvertProgressUpdater(this));
        }

        this.worldMngr = new WorldServer[2];
        SaveOldDir var5 = new SaveOldDir(new File("."), var2, true);

        for(int var6 = 0; var6 < this.worldMngr.length; ++var6) {
            if (var6 == 0) {
                this.worldMngr[var6] = new WorldServer(this, var5, var2, var6 == 0 ? 0 : -1, var3);
            } else {
                this.worldMngr[var6] = new WorldServerMulti(this, var5, var2, var6 == 0 ? 0 : -1, var3, this.worldMngr[0]);
            }

            this.worldMngr[var6].addWorldAccess(new WorldManager(this, this.worldMngr[var6]));
            this.worldMngr[var6].difficultySetting = this.propertyManagerObj.getBooleanProperty("spawn-monsters", true) ? 1 : 0;
            this.worldMngr[var6].setAllowedSpawnTypes(this.propertyManagerObj.getBooleanProperty("spawn-monsters", true), this.spawnPeacefulMobs);
            this.configManager.setPlayerManager(this.worldMngr);
        }

        short var18 = 196;
        long var7 = System.currentTimeMillis();

        for(int var9 = 0; var9 < this.worldMngr.length; ++var9) {
            logger.info("Preparing start region for level " + var9);
            if (var9 == 0 || this.propertyManagerObj.getBooleanProperty("allow-nether", true)) {
                WorldServer var10 = this.worldMngr[var9];
                ChunkCoordinates var11 = var10.getSpawnPoint();

                for(int var12 = -var18; var12 <= var18 && this.serverRunning; var12 += 16) {
                    for(int var13 = -var18; var13 <= var18 && this.serverRunning; var13 += 16) {
                        long var14 = System.currentTimeMillis();
                        if (var14 < var7) {
                            var7 = var14;
                        }

                        if (var14 > var7 + 1000L) {
                            int var16 = (var18 * 2 + 1) * (var18 * 2 + 1);
                            int var17 = (var12 + var18) * (var18 * 2 + 1) + var13 + 1;
                            this.outputPercentRemaining("Preparing spawn area", var17 * 100 / var16);
                            var7 = var14;
                        }

                        var10.chunkProviderServer.loadChunk(var11.posX + var12 >> 4, var11.posZ + var13 >> 4);

                        while(var10.func_6156_d() && this.serverRunning) {
                        }
                    }
                }
            }
        }

        this.clearCurrentTask();
    }

    private void outputPercentRemaining(String var1, int var2) {
        this.currentTask = var1;
        this.percentDone = var2;
        logger.info(var1 + ": " + var2 + "%");
    }

    private void clearCurrentTask() {
        this.currentTask = null;
        this.percentDone = 0;
    }

    private void saveServerWorld() {
        logger.info("Saving chunks");

        for(int var1 = 0; var1 < this.worldMngr.length; ++var1) {
            WorldServer var2 = this.worldMngr[var1];
            var2.saveWorld(true, (IProgressUpdate)null);
            var2.func_30006_w();
        }

    }

    private void stopServer() {
        logger.info("Stopping server");
        if (this.configManager != null) {
            this.configManager.savePlayerStates();
        }

        for(int var1 = 0; var1 < this.worldMngr.length; ++var1) {
            WorldServer var2 = this.worldMngr[var1];
            if (var2 != null) {
                this.saveServerWorld();
            }
        }

    }

    public void initiateShutdown() {
        this.serverRunning = false;
    }

    public void run() {
        try {
            if (this.startServer()) {
                long var1 = System.currentTimeMillis();

                for(long var3 = 0L; this.serverRunning; Thread.sleep(1L)) {
                    long var5 = System.currentTimeMillis();
                    long var7 = var5 - var1;
                    if (var7 > 2000L) {
                        logger.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        var7 = 2000L;
                    }

                    if (var7 < 0L) {
                        logger.warning("Time ran backwards! Did the system time change?");
                        var7 = 0L;
                    }

                    var3 += var7;
                    var1 = var5;
                    if (this.worldMngr[0].isAllPlayersFullyAsleep()) {
                        this.doTick();
                        var3 = 0L;
                    } else {
                        while(var3 > 50L) {
                            var3 -= 50L;
                            this.doTick();
                        }
                    }
                }
            } else {
                while(this.serverRunning) {
                    this.commandLineParser();

                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException var57) {
                        var57.printStackTrace();
                    }
                }
            }
        } catch (Throwable var58) {
            var58.printStackTrace();
            logger.log(Level.SEVERE, "Unexpected exception", var58);

            while(this.serverRunning) {
                this.commandLineParser();

                try {
                    Thread.sleep(10L);
                } catch (InterruptedException var56) {
                    var56.printStackTrace();
                }
            }
        } finally {
            try {
                this.stopServer();
                this.serverStopped = true;
            } catch (Throwable var54) {
                var54.printStackTrace();
            } finally {
                System.exit(0);
            }

        }

    }

    private void doTick() {
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

        AxisAlignedBB.clearBoundingBoxPool();
        Vec3D.initialize();
        ++this.deathTime;

        for(var6 = 0; var6 < this.worldMngr.length; ++var6) {
            if (var6 == 0 || this.propertyManagerObj.getBooleanProperty("allow-nether", true)) {
                WorldServer var7 = this.worldMngr[var6];
                if (this.deathTime % 20 == 0) {
                    this.configManager.sendPacketToAllPlayersInDimension(new Packet4UpdateTime(var7.getWorldTime()), var7.worldProvider.worldType);
                }

                var7.tick();

                while(var7.func_6156_d()) {
                }

                var7.updateEntities();
            }
        }

        this.networkServer.handleNetworkListenThread();
        this.configManager.onTick();

        for(var6 = 0; var6 < this.entityTracker.length; ++var6) {
            this.entityTracker[var6].updateTrackedEntities();
        }

        for(var6 = 0; var6 < this.field_9010_p.size(); ++var6) {
            ((IUpdatePlayerListBox)this.field_9010_p.get(var6)).update();
        }

        try {
            this.commandLineParser();
        } catch (Exception var5) {
            logger.log(Level.WARNING, "Unexpected exception while parsing console command", var5);
        }

    }

    public void addCommand(String var1, ICommandListener var2) {
        this.commands.add(new ServerCommand(var1, var2));
    }

    public void commandLineParser() {
        while(this.commands.size() > 0) {
            ServerCommand var1 = (ServerCommand)this.commands.remove(0);
            this.commandHandler.handleCommand(var1);
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
                ServerGUI.initGui(var1);
            }

            (new ThreadServerApplication("Server thread", var1)).start();
        } catch (Exception var2) {
            logger.log(Level.SEVERE, "Failed to start the minecraft server", var2);
        }

    }

    public File getFile(String var1) {
        return new File(var1);
    }

    public void log(String var1) {
        logger.info(var1);
    }

    public void logWarning(String var1) {
        logger.warning(var1);
    }

    public String getUsername() {
        return "CONSOLE";
    }

    public WorldServer getWorldManager(int var1) {
        return var1 == -1 ? this.worldMngr[1] : this.worldMngr[0];
    }

    public EntityTracker getEntityTracker(int var1) {
        return var1 == -1 ? this.entityTracker[1] : this.entityTracker[0];
    }

    // $FF: synthetic method
    public static boolean isServerRunning(MinecraftServer var0) {
        return var0.serverRunning;
    }
}
