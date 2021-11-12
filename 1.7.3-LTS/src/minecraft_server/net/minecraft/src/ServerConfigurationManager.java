package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ServerConfigurationManager {
    public static Logger logger = Logger.getLogger("Minecraft");
    public List playerEntities = new ArrayList();
    private MinecraftServer mcServer;
    private PlayerManager[] playerManagerObj = new PlayerManager[2];
    private int maxPlayers;
    private Set bannedPlayers = new HashSet();
    private Set bannedIPs = new HashSet();
    private Set ops = new HashSet();
    private Set whiteListedIPs = new HashSet();
    private File bannedPlayersFile;
    private File ipBanFile;
    private File opFile;
    private File whitelistPlayersFile;
    private IPlayerFileData playerNBTManagerObj;
    private boolean whiteListEnforced;

    public ServerConfigurationManager(MinecraftServer var1) {
        this.mcServer = var1;
        this.bannedPlayersFile = var1.getFile("banned-players.txt");
        this.ipBanFile = var1.getFile("banned-ips.txt");
        this.opFile = var1.getFile("ops.txt");
        this.whitelistPlayersFile = var1.getFile("white-list.txt");
        int var2 = var1.propertyManagerObj.getIntProperty("view-distance", 10);
        this.playerManagerObj[0] = new PlayerManager(var1, 0, var2);
        this.playerManagerObj[1] = new PlayerManager(var1, -1, var2);
        this.maxPlayers = var1.propertyManagerObj.getIntProperty("max-players", 20);
        this.whiteListEnforced = var1.propertyManagerObj.getBooleanProperty("white-list", false);
        this.readBannedPlayers();
        this.loadBannedList();
        this.loadOps();
        this.loadWhiteList();
        this.writeBannedPlayers();
        this.saveBannedList();
        this.saveOps();
        this.saveWhiteList();
    }

    public void setPlayerManager(WorldServer[] var1) {
        this.playerNBTManagerObj = var1[0].getWorldFile().func_22090_d();
    }

    public void func_28172_a(EntityPlayerMP var1) {
        this.playerManagerObj[0].removePlayer(var1);
        this.playerManagerObj[1].removePlayer(var1);
        this.getPlayerManager(var1.dimension).addPlayer(var1);
        WorldServer var2 = this.mcServer.getWorldManager(var1.dimension);
        var2.chunkProviderServer.loadChunk((int)var1.posX >> 4, (int)var1.posZ >> 4);
    }

    public int getMaxTrackingDistance() {
        return this.playerManagerObj[0].getMaxTrackingDistance();
    }

    private PlayerManager getPlayerManager(int var1) {
        return var1 == -1 ? this.playerManagerObj[1] : this.playerManagerObj[0];
    }

    public void readPlayerDataFromFile(EntityPlayerMP var1) {
        this.playerNBTManagerObj.readPlayerData(var1);
    }

    public void playerLoggedIn(EntityPlayerMP var1) {
        this.playerEntities.add(var1);
        WorldServer var2 = this.mcServer.getWorldManager(var1.dimension);
        var2.chunkProviderServer.loadChunk((int)var1.posX >> 4, (int)var1.posZ >> 4);

        while(var2.getCollidingBoundingBoxes(var1, var1.boundingBox).size() != 0) {
            var1.setPosition(var1.posX, var1.posY + 1.0D, var1.posZ);
        }

        var2.entityJoinedWorld(var1);
        this.getPlayerManager(var1.dimension).addPlayer(var1);
    }

    public void func_613_b(EntityPlayerMP var1) {
        this.getPlayerManager(var1.dimension).func_543_c(var1);
    }

    public void playerLoggedOut(EntityPlayerMP var1) {
        this.playerNBTManagerObj.writePlayerData(var1);
        this.mcServer.getWorldManager(var1.dimension).removePlayerForLogoff(var1);
        this.playerEntities.remove(var1);
        this.getPlayerManager(var1.dimension).removePlayer(var1);
    }

    public EntityPlayerMP login(NetLoginHandler var1, String var2) {
        if (this.bannedPlayers.contains(var2.trim().toLowerCase())) {
            var1.kickUser("You are banned from this server!");
            return null;
        } else if (!this.isAllowedToLogin(var2)) {
            var1.kickUser("You are not white-listed on this server!");
            return null;
        } else {
            String var3 = var1.netManager.getRemoteAddress().toString();
            var3 = var3.substring(var3.indexOf("/") + 1);
            var3 = var3.substring(0, var3.indexOf(":"));
            if (this.bannedIPs.contains(var3)) {
                var1.kickUser("Your IP address is banned from this server!");
                return null;
            } else if (this.playerEntities.size() >= this.maxPlayers) {
                var1.kickUser("The server is full!");
                return null;
            } else {
                for(int var4 = 0; var4 < this.playerEntities.size(); ++var4) {
                    EntityPlayerMP var5 = (EntityPlayerMP)this.playerEntities.get(var4);
                    if (var5.username.equalsIgnoreCase(var2)) {
                        var5.playerNetServerHandler.kickPlayer("You logged in from another location");
                    }
                }

                return new EntityPlayerMP(this.mcServer, this.mcServer.getWorldManager(0), var2, new ItemInWorldManager(this.mcServer.getWorldManager(0)));
            }
        }
    }

    public EntityPlayerMP recreatePlayerEntity(EntityPlayerMP var1, int var2) {
        this.mcServer.getEntityTracker(var1.dimension).removeTrackedPlayerSymmetric(var1);
        this.mcServer.getEntityTracker(var1.dimension).untrackEntity(var1);
        this.getPlayerManager(var1.dimension).removePlayer(var1);
        this.playerEntities.remove(var1);
        this.mcServer.getWorldManager(var1.dimension).removePlayer(var1);
        ChunkCoordinates var3 = var1.getSpawnChunk();
        var1.dimension = var2;
        EntityPlayerMP var4 = new EntityPlayerMP(this.mcServer, this.mcServer.getWorldManager(var1.dimension), var1.username, new ItemInWorldManager(this.mcServer.getWorldManager(var1.dimension)));
        var4.entityId = var1.entityId;
        var4.playerNetServerHandler = var1.playerNetServerHandler;
        WorldServer var5 = this.mcServer.getWorldManager(var1.dimension);
        if (var3 != null) {
            ChunkCoordinates var6 = EntityPlayer.func_25051_a(this.mcServer.getWorldManager(var1.dimension), var3);
            if (var6 != null) {
                var4.setLocationAndAngles((double)((float)var6.posX + 0.5F), (double)((float)var6.posY + 0.1F), (double)((float)var6.posZ + 0.5F), 0.0F, 0.0F);
                var4.setSpawnChunk(var3);
            } else {
                var4.playerNetServerHandler.sendPacket(new Packet70Bed(0));
            }
        }

        var5.chunkProviderServer.loadChunk((int)var4.posX >> 4, (int)var4.posZ >> 4);

        while(var5.getCollidingBoundingBoxes(var4, var4.boundingBox).size() != 0) {
            var4.setPosition(var4.posX, var4.posY + 1.0D, var4.posZ);
        }

        var4.playerNetServerHandler.sendPacket(new Packet9Respawn((byte)var4.dimension));
        var4.playerNetServerHandler.teleportTo(var4.posX, var4.posY, var4.posZ, var4.rotationYaw, var4.rotationPitch);
        this.func_28170_a(var4, var5);
        this.getPlayerManager(var4.dimension).addPlayer(var4);
        var5.entityJoinedWorld(var4);
        this.playerEntities.add(var4);
        var4.func_20057_k();
        var4.func_22068_s();
        return var4;
    }

    public void sendPlayerToOtherDimension(EntityPlayerMP var1) {
        WorldServer var2 = this.mcServer.getWorldManager(var1.dimension);
        boolean var3 = false;
        byte var11;
        if (var1.dimension == -1) {
            var11 = 0;
        } else {
            var11 = -1;
        }

        var1.dimension = var11;
        WorldServer var4 = this.mcServer.getWorldManager(var1.dimension);
        var1.playerNetServerHandler.sendPacket(new Packet9Respawn((byte)var1.dimension));
        var2.removePlayer(var1);
        var1.isDead = false;
        double var5 = var1.posX;
        double var7 = var1.posZ;
        double var9 = 8.0D;
        if (var1.dimension == -1) {
            var5 /= var9;
            var7 /= var9;
            var1.setLocationAndAngles(var5, var1.posY, var7, var1.rotationYaw, var1.rotationPitch);
            if (var1.isEntityAlive()) {
                var2.updateEntityWithOptionalForce(var1, false);
            }
        } else {
            var5 *= var9;
            var7 *= var9;
            var1.setLocationAndAngles(var5, var1.posY, var7, var1.rotationYaw, var1.rotationPitch);
            if (var1.isEntityAlive()) {
                var2.updateEntityWithOptionalForce(var1, false);
            }
        }

        if (var1.isEntityAlive()) {
            var4.entityJoinedWorld(var1);
            var1.setLocationAndAngles(var5, var1.posY, var7, var1.rotationYaw, var1.rotationPitch);
            var4.updateEntityWithOptionalForce(var1, false);
            var4.chunkProviderServer.chunkLoadOverride = true;
            (new Teleporter()).setExitLocation(var4, var1);
            var4.chunkProviderServer.chunkLoadOverride = false;
        }

        this.func_28172_a(var1);
        var1.playerNetServerHandler.teleportTo(var1.posX, var1.posY, var1.posZ, var1.rotationYaw, var1.rotationPitch);
        var1.setWorldHandler(var4);
        this.func_28170_a(var1, var4);
        this.func_30008_g(var1);
    }

    public void onTick() {
        for(int var1 = 0; var1 < this.playerManagerObj.length; ++var1) {
            this.playerManagerObj[var1].updatePlayerInstances();
        }

    }

    public void markBlockNeedsUpdate(int var1, int var2, int var3, int var4) {
        this.getPlayerManager(var4).markBlockNeedsUpdate(var1, var2, var3);
    }

    public void sendPacketToAllPlayers(Packet var1) {
        for(int var2 = 0; var2 < this.playerEntities.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.playerEntities.get(var2);
            var3.playerNetServerHandler.sendPacket(var1);
        }

    }

    public void sendPacketToAllPlayersInDimension(Packet var1, int var2) {
        for(int var3 = 0; var3 < this.playerEntities.size(); ++var3) {
            EntityPlayerMP var4 = (EntityPlayerMP)this.playerEntities.get(var3);
            if (var4.dimension == var2) {
                var4.playerNetServerHandler.sendPacket(var1);
            }
        }

    }

    public String getPlayerList() {
        String var1 = "";

        for(int var2 = 0; var2 < this.playerEntities.size(); ++var2) {
            if (var2 > 0) {
                var1 = var1 + ", ";
            }

            var1 = var1 + ((EntityPlayerMP)this.playerEntities.get(var2)).username;
        }

        return var1;
    }

    public void banPlayer(String var1) {
        this.bannedPlayers.add(var1.toLowerCase());
        this.writeBannedPlayers();
    }

    public void pardonPlayer(String var1) {
        this.bannedPlayers.remove(var1.toLowerCase());
        this.writeBannedPlayers();
    }

    private void readBannedPlayers() {
        try {
            this.bannedPlayers.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.bannedPlayersFile));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.bannedPlayers.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            logger.warning("Failed to load ban list: " + var3);
        }

    }

    private void writeBannedPlayers() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.bannedPlayersFile, false));
            Iterator var2 = this.bannedPlayers.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            logger.warning("Failed to save ban list: " + var4);
        }

    }

    public void banIP(String var1) {
        this.bannedIPs.add(var1.toLowerCase());
        this.saveBannedList();
    }

    public void pardonIP(String var1) {
        this.bannedIPs.remove(var1.toLowerCase());
        this.saveBannedList();
    }

    private void loadBannedList() {
        try {
            this.bannedIPs.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.ipBanFile));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.bannedIPs.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            logger.warning("Failed to load ip ban list: " + var3);
        }

    }

    private void saveBannedList() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.ipBanFile, false));
            Iterator var2 = this.bannedIPs.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            logger.warning("Failed to save ip ban list: " + var4);
        }

    }

    public void opPlayer(String var1) {
        this.ops.add(var1.toLowerCase());
        this.saveOps();
    }

    public void deopPlayer(String var1) {
        this.ops.remove(var1.toLowerCase());
        this.saveOps();
    }

    private void loadOps() {
        try {
            this.ops.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.opFile));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.ops.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            logger.warning("Failed to load ip ban list: " + var3);
        }

    }

    private void saveOps() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.opFile, false));
            Iterator var2 = this.ops.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            logger.warning("Failed to save ip ban list: " + var4);
        }

    }

    private void loadWhiteList() {
        try {
            this.whiteListedIPs.clear();
            BufferedReader var1 = new BufferedReader(new FileReader(this.whitelistPlayersFile));
            String var2 = "";

            while((var2 = var1.readLine()) != null) {
                this.whiteListedIPs.add(var2.trim().toLowerCase());
            }

            var1.close();
        } catch (Exception var3) {
            logger.warning("Failed to load white-list: " + var3);
        }

    }

    private void saveWhiteList() {
        try {
            PrintWriter var1 = new PrintWriter(new FileWriter(this.whitelistPlayersFile, false));
            Iterator var2 = this.whiteListedIPs.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                var1.println(var3);
            }

            var1.close();
        } catch (Exception var4) {
            logger.warning("Failed to save white-list: " + var4);
        }

    }

    public boolean isAllowedToLogin(String var1) {
        var1 = var1.trim().toLowerCase();
        return !this.whiteListEnforced || this.ops.contains(var1) || this.whiteListedIPs.contains(var1);
    }

    public boolean isOp(String var1) {
        return this.ops.contains(var1.trim().toLowerCase());
    }

    public EntityPlayerMP getPlayerEntity(String var1) {
        for(int var2 = 0; var2 < this.playerEntities.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.playerEntities.get(var2);
            if (var3.username.equalsIgnoreCase(var1)) {
                return var3;
            }
        }

        return null;
    }

    public void sendChatMessageToPlayer(String var1, String var2) {
        EntityPlayerMP var3 = this.getPlayerEntity(var1);
        if (var3 != null) {
            var3.playerNetServerHandler.sendPacket(new Packet3Chat(var2));
        }

    }

    public void sendPacketToPlayersAroundPoint(double var1, double var3, double var5, double var7, int var9, Packet var10) {
        this.func_28171_a((EntityPlayer)null, var1, var3, var5, var7, var9, var10);
    }

    public void func_28171_a(EntityPlayer var1, double var2, double var4, double var6, double var8, int var10, Packet var11) {
        for(int var12 = 0; var12 < this.playerEntities.size(); ++var12) {
            EntityPlayerMP var13 = (EntityPlayerMP)this.playerEntities.get(var12);
            if (var13 != var1 && var13.dimension == var10) {
                double var14 = var2 - var13.posX;
                double var16 = var4 - var13.posY;
                double var18 = var6 - var13.posZ;
                if (var14 * var14 + var16 * var16 + var18 * var18 < var8 * var8) {
                    var13.playerNetServerHandler.sendPacket(var11);
                }
            }
        }

    }

    public void sendChatMessageToAllOps(String var1) {
        Packet3Chat var2 = new Packet3Chat(var1);

        for(int var3 = 0; var3 < this.playerEntities.size(); ++var3) {
            EntityPlayerMP var4 = (EntityPlayerMP)this.playerEntities.get(var3);
            if (this.isOp(var4.username)) {
                var4.playerNetServerHandler.sendPacket(var2);
            }
        }

    }

    public boolean sendPacketToPlayer(String var1, Packet var2) {
        EntityPlayerMP var3 = this.getPlayerEntity(var1);
        if (var3 != null) {
            var3.playerNetServerHandler.sendPacket(var2);
            return true;
        } else {
            return false;
        }
    }

    public void savePlayerStates() {
        for(int var1 = 0; var1 < this.playerEntities.size(); ++var1) {
            this.playerNBTManagerObj.writePlayerData((EntityPlayer)this.playerEntities.get(var1));
        }

    }

    public void sentTileEntityToPlayer(int var1, int var2, int var3, TileEntity var4) {
    }

    public void addToWhiteList(String var1) {
        this.whiteListedIPs.add(var1);
        this.saveWhiteList();
    }

    public void removeFromWhiteList(String var1) {
        this.whiteListedIPs.remove(var1);
        this.saveWhiteList();
    }

    public Set getWhiteListedIPs() {
        return this.whiteListedIPs;
    }

    public void reloadWhiteList() {
        this.loadWhiteList();
    }

    public void func_28170_a(EntityPlayerMP var1, WorldServer var2) {
        var1.playerNetServerHandler.sendPacket(new Packet4UpdateTime(var2.getWorldTime()));
        if (var2.func_27068_v()) {
            var1.playerNetServerHandler.sendPacket(new Packet70Bed(1));
        }

    }

    public void func_30008_g(EntityPlayerMP var1) {
        var1.func_28017_a(var1.personalCraftingInventory);
        var1.func_30001_B();
    }
}
