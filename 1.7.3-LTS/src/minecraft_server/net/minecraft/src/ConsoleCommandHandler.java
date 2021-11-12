package net.minecraft.src;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ConsoleCommandHandler {
    private static Logger minecraftLogger = Logger.getLogger("Minecraft");
    private MinecraftServer minecraftServer;

    public ConsoleCommandHandler(MinecraftServer var1) {
        this.minecraftServer = var1;
    }

    public void handleCommand(ServerCommand var1) {
        String var2 = var1.command;
        ICommandListener var3 = var1.commandListener;
        String var4 = var3.getUsername();
        ServerConfigurationManager var5 = this.minecraftServer.configManager;
        if (!var2.toLowerCase().startsWith("help") && !var2.toLowerCase().startsWith("?")) {
            if (var2.toLowerCase().startsWith("list")) {
                var3.log("Connected players: " + var5.getPlayerList());
            } else if (var2.toLowerCase().startsWith("stop")) {
                this.sendNoticeToOps(var4, "Stopping the server..");
                this.minecraftServer.initiateShutdown();
            } else {
                int var6;
                WorldServer var7;
                if (var2.toLowerCase().startsWith("save-all")) {
                    this.sendNoticeToOps(var4, "Forcing save..");
                    if (var5 != null) {
                        var5.savePlayerStates();
                    }

                    for(var6 = 0; var6 < this.minecraftServer.worldMngr.length; ++var6) {
                        var7 = this.minecraftServer.worldMngr[var6];
                        var7.saveWorld(true, (IProgressUpdate)null);
                    }

                    this.sendNoticeToOps(var4, "Save complete.");
                } else if (var2.toLowerCase().startsWith("save-off")) {
                    this.sendNoticeToOps(var4, "Disabling level saving..");

                    for(var6 = 0; var6 < this.minecraftServer.worldMngr.length; ++var6) {
                        var7 = this.minecraftServer.worldMngr[var6];
                        var7.levelSaving = true;
                    }
                } else if (var2.toLowerCase().startsWith("save-on")) {
                    this.sendNoticeToOps(var4, "Enabling level saving..");

                    for(var6 = 0; var6 < this.minecraftServer.worldMngr.length; ++var6) {
                        var7 = this.minecraftServer.worldMngr[var6];
                        var7.levelSaving = false;
                    }
                } else {
                    String var13;
                    if (var2.toLowerCase().startsWith("op ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.opPlayer(var13);
                        this.sendNoticeToOps(var4, "Opping " + var13);
                        var5.sendChatMessageToPlayer(var13, "\u00a7eYou are now op!");
                    } else if (var2.toLowerCase().startsWith("deop ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.deopPlayer(var13);
                        var5.sendChatMessageToPlayer(var13, "\u00a7eYou are no longer op!");
                        this.sendNoticeToOps(var4, "De-opping " + var13);
                    } else if (var2.toLowerCase().startsWith("ban-ip ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.banIP(var13);
                        this.sendNoticeToOps(var4, "Banning ip " + var13);
                    } else if (var2.toLowerCase().startsWith("pardon-ip ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.pardonIP(var13);
                        this.sendNoticeToOps(var4, "Pardoning ip " + var13);
                    } else {
                        EntityPlayerMP var14;
                        if (var2.toLowerCase().startsWith("ban ")) {
                            var13 = var2.substring(var2.indexOf(" ")).trim();
                            var5.banPlayer(var13);
                            this.sendNoticeToOps(var4, "Banning " + var13);
                            var14 = var5.getPlayerEntity(var13);
                            if (var14 != null) {
                                var14.playerNetServerHandler.kickPlayer("Banned by admin");
                            }
                        } else if (var2.toLowerCase().startsWith("pardon ")) {
                            var13 = var2.substring(var2.indexOf(" ")).trim();
                            var5.pardonPlayer(var13);
                            this.sendNoticeToOps(var4, "Pardoning " + var13);
                        } else {
                            int var8;
                            if (var2.toLowerCase().startsWith("kick ")) {
                                var13 = var2.substring(var2.indexOf(" ")).trim();
                                var14 = null;

                                for(var8 = 0; var8 < var5.playerEntities.size(); ++var8) {
                                    EntityPlayerMP var9 = (EntityPlayerMP)var5.playerEntities.get(var8);
                                    if (var9.username.equalsIgnoreCase(var13)) {
                                        var14 = var9;
                                    }
                                }

                                if (var14 != null) {
                                    var14.playerNetServerHandler.kickPlayer("Kicked by admin");
                                    this.sendNoticeToOps(var4, "Kicking " + var14.username);
                                } else {
                                    var3.log("Can't find user " + var13 + ". No kick.");
                                }
                            } else {
                                EntityPlayerMP var15;
                                String[] var18;
                                if (var2.toLowerCase().startsWith("tp ")) {
                                    var18 = var2.split(" ");
                                    if (var18.length == 3) {
                                        var14 = var5.getPlayerEntity(var18[1]);
                                        var15 = var5.getPlayerEntity(var18[2]);
                                        if (var14 == null) {
                                            var3.log("Can't find user " + var18[1] + ". No tp.");
                                        } else if (var15 == null) {
                                            var3.log("Can't find user " + var18[2] + ". No tp.");
                                        } else if (var14.dimension != var15.dimension) {
                                            var3.log("User " + var18[1] + " and " + var18[2] + " are in different dimensions. No tp.");
                                        } else {
                                            var14.playerNetServerHandler.teleportTo(var15.posX, var15.posY, var15.posZ, var15.rotationYaw, var15.rotationPitch);
                                            this.sendNoticeToOps(var4, "Teleporting " + var18[1] + " to " + var18[2] + ".");
                                        }
                                    } else {
                                        var3.log("Syntax error, please provice a source and a target.");
                                    }
                                } else {
                                    String var16;
                                    int var17;
                                    if (var2.toLowerCase().startsWith("give ")) {
                                        var18 = var2.split(" ");
                                        if (var18.length != 3 && var18.length != 4) {
                                            return;
                                        }

                                        var16 = var18[1];
                                        var15 = var5.getPlayerEntity(var16);
                                        if (var15 != null) {
                                            try {
                                                var17 = Integer.parseInt(var18[2]);
                                                if (Item.itemsList[var17] != null) {
                                                    this.sendNoticeToOps(var4, "Giving " + var15.username + " some " + var17);
                                                    int var10 = 1;
                                                    if (var18.length > 3) {
                                                        var10 = this.tryParse(var18[3], 1);
                                                    }

                                                    if (var10 < 1) {
                                                        var10 = 1;
                                                    }

                                                    if (var10 > 64) {
                                                        var10 = 64;
                                                    }

                                                    var15.dropPlayerItem(new ItemStack(var17, var10, 0));
                                                } else {
                                                    var3.log("There's no item with id " + var17);
                                                }
                                            } catch (NumberFormatException var11) {
                                                var3.log("There's no item with id " + var18[2]);
                                            }
                                        } else {
                                            var3.log("Can't find user " + var16);
                                        }
                                    } else if (var2.toLowerCase().startsWith("time ")) {
                                        var18 = var2.split(" ");
                                        if (var18.length != 3) {
                                            return;
                                        }

                                        var16 = var18[1];

                                        try {
                                            var8 = Integer.parseInt(var18[2]);
                                            WorldServer var19;
                                            if ("add".equalsIgnoreCase(var16)) {
                                                for(var17 = 0; var17 < this.minecraftServer.worldMngr.length; ++var17) {
                                                    var19 = this.minecraftServer.worldMngr[var17];
                                                    var19.func_32005_b(var19.getWorldTime() + (long)var8);
                                                }

                                                this.sendNoticeToOps(var4, "Added " + var8 + " to time");
                                            } else if ("set".equalsIgnoreCase(var16)) {
                                                for(var17 = 0; var17 < this.minecraftServer.worldMngr.length; ++var17) {
                                                    var19 = this.minecraftServer.worldMngr[var17];
                                                    var19.func_32005_b((long)var8);
                                                }

                                                this.sendNoticeToOps(var4, "Set time to " + var8);
                                            } else {
                                                var3.log("Unknown method, use either \"add\" or \"set\"");
                                            }
                                        } catch (NumberFormatException var12) {
                                            var3.log("Unable to convert time value, " + var18[2]);
                                        }
                                    } else if (var2.toLowerCase().startsWith("say ")) {
                                        var2 = var2.substring(var2.indexOf(" ")).trim();
                                        minecraftLogger.info("[" + var4 + "] " + var2);
                                        var5.sendPacketToAllPlayers(new Packet3Chat("\u00a7d[Server] " + var2));
                                    } else if (var2.toLowerCase().startsWith("tell ")) {
                                        var18 = var2.split(" ");
                                        if (var18.length >= 3) {
                                            var2 = var2.substring(var2.indexOf(" ")).trim();
                                            var2 = var2.substring(var2.indexOf(" ")).trim();
                                            minecraftLogger.info("[" + var4 + "->" + var18[1] + "] " + var2);
                                            var2 = "\u00a77" + var4 + " whispers " + var2;
                                            minecraftLogger.info(var2);
                                            if (!var5.sendPacketToPlayer(var18[1], new Packet3Chat(var2))) {
                                                var3.log("There's no player by that name online.");
                                            }
                                        }
                                    } else if (var2.toLowerCase().startsWith("whitelist ")) {
                                        this.handleWhitelist(var4, var2, var3);
                                    } else {
                                        minecraftLogger.info("Unknown console command. Type \"help\" for help.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            this.printHelp(var3);
        }

    }

    private void handleWhitelist(String var1, String var2, ICommandListener var3) {
        String[] var4 = var2.split(" ");
        if (var4.length >= 2) {
            String var5 = var4[1].toLowerCase();
            if ("on".equals(var5)) {
                this.sendNoticeToOps(var1, "Turned on white-listing");
                this.minecraftServer.propertyManagerObj.setProperty("white-list", true);
            } else if ("off".equals(var5)) {
                this.sendNoticeToOps(var1, "Turned off white-listing");
                this.minecraftServer.propertyManagerObj.setProperty("white-list", false);
            } else if ("list".equals(var5)) {
                Set var6 = this.minecraftServer.configManager.getWhiteListedIPs();
                String var7 = "";

                String var9;
                for(Iterator var8 = var6.iterator(); var8.hasNext(); var7 = var7 + var9 + " ") {
                    var9 = (String)var8.next();
                }

                var3.log("White-listed players: " + var7);
            } else {
                String var10;
                if ("add".equals(var5) && var4.length == 3) {
                    var10 = var4[2].toLowerCase();
                    this.minecraftServer.configManager.addToWhiteList(var10);
                    this.sendNoticeToOps(var1, "Added " + var10 + " to white-list");
                } else if ("remove".equals(var5) && var4.length == 3) {
                    var10 = var4[2].toLowerCase();
                    this.minecraftServer.configManager.removeFromWhiteList(var10);
                    this.sendNoticeToOps(var1, "Removed " + var10 + " from white-list");
                } else if ("reload".equals(var5)) {
                    this.minecraftServer.configManager.reloadWhiteList();
                    this.sendNoticeToOps(var1, "Reloaded white-list from file");
                }
            }

        }
    }

    private void printHelp(ICommandListener var1) {
        var1.log("To run the server without a gui, start it like this:");
        var1.log("   java -Xmx1024M -Xms1024M -jar minecraft_server.jar nogui");
        var1.log("Console commands:");
        var1.log("   help  or  ?               shows this message");
        var1.log("   kick <player>             removes a player from the server");
        var1.log("   ban <player>              bans a player from the server");
        var1.log("   pardon <player>           pardons a banned player so that they can connect again");
        var1.log("   ban-ip <ip>               bans an IP address from the server");
        var1.log("   pardon-ip <ip>            pardons a banned IP address so that they can connect again");
        var1.log("   op <player>               turns a player into an op");
        var1.log("   deop <player>             removes op status from a player");
        var1.log("   tp <player1> <player2>    moves one player to the same location as another player");
        var1.log("   give <player> <id> [num]  gives a player a resource");
        var1.log("   tell <player> <message>   sends a private message to a player");
        var1.log("   stop                      gracefully stops the server");
        var1.log("   save-all                  forces a server-wide level save");
        var1.log("   save-off                  disables terrain saving (useful for backup scripts)");
        var1.log("   save-on                   re-enables terrain saving");
        var1.log("   list                      lists all currently connected players");
        var1.log("   say <message>             broadcasts a message to all players");
        var1.log("   time <add|set> <amount>   adds to or sets the world time (0-24000)");
    }

    private void sendNoticeToOps(String var1, String var2) {
        String var3 = var1 + ": " + var2;
        this.minecraftServer.configManager.sendChatMessageToAllOps("\u00a77(" + var3 + ")");
        minecraftLogger.info(var3);
    }

    private int tryParse(String var1, int var2) {
        try {
            return Integer.parseInt(var1);
        } catch (NumberFormatException var4) {
            return var2;
        }
    }
}
