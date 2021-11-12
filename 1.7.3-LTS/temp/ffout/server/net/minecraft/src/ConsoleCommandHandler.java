package net.minecraft.src;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ConsoleCommandHandler {
    private static Logger field_22117_a = Logger.getLogger("Minecraft");
    private MinecraftServer field_22116_b;

    public ConsoleCommandHandler(MinecraftServer var1) {
        this.field_22116_b = var1;
    }

    public void func_22114_a(ServerCommand var1) {
        String var2 = var1.field_1060_a;
        ICommandListener var3 = var1.field_1059_b;
        String var4 = var3.func_1_c();
        ServerConfigurationManager var5 = this.field_22116_b.field_6033_f;
        if (!var2.toLowerCase().startsWith("help") && !var2.toLowerCase().startsWith("?")) {
            if (var2.toLowerCase().startsWith("list")) {
                var3.func_2_b("Connected players: " + var5.func_633_c());
            } else if (var2.toLowerCase().startsWith("stop")) {
                this.func_22115_a(var4, "Stopping the server..");
                this.field_22116_b.func_6016_a();
            } else {
                int var6;
                WorldServer var7;
                if (var2.toLowerCase().startsWith("save-all")) {
                    this.func_22115_a(var4, "Forcing save..");
                    if (var5 != null) {
                        var5.func_617_d();
                    }

                    for(var6 = 0; var6 < this.field_22116_b.field_6034_e.length; ++var6) {
                        var7 = this.field_22116_b.field_6034_e[var6];
                        var7.func_485_a(true, (IProgressUpdate)null);
                    }

                    this.func_22115_a(var4, "Save complete.");
                } else if (var2.toLowerCase().startsWith("save-off")) {
                    this.func_22115_a(var4, "Disabling level saving..");

                    for(var6 = 0; var6 < this.field_22116_b.field_6034_e.length; ++var6) {
                        var7 = this.field_22116_b.field_6034_e[var6];
                        var7.field_816_A = true;
                    }
                } else if (var2.toLowerCase().startsWith("save-on")) {
                    this.func_22115_a(var4, "Enabling level saving..");

                    for(var6 = 0; var6 < this.field_22116_b.field_6034_e.length; ++var6) {
                        var7 = this.field_22116_b.field_6034_e[var6];
                        var7.field_816_A = false;
                    }
                } else {
                    String var13;
                    if (var2.toLowerCase().startsWith("op ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.func_22164_e(var13);
                        this.func_22115_a(var4, "Opping " + var13);
                        var5.func_628_a(var13, "\u00a7eYou are now op!");
                    } else if (var2.toLowerCase().startsWith("deop ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.func_22165_f(var13);
                        var5.func_628_a(var13, "\u00a7eYou are no longer op!");
                        this.func_22115_a(var4, "De-opping " + var13);
                    } else if (var2.toLowerCase().startsWith("ban-ip ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.func_22162_c(var13);
                        this.func_22115_a(var4, "Banning ip " + var13);
                    } else if (var2.toLowerCase().startsWith("pardon-ip ")) {
                        var13 = var2.substring(var2.indexOf(" ")).trim();
                        var5.func_22163_d(var13);
                        this.func_22115_a(var4, "Pardoning ip " + var13);
                    } else {
                        EntityPlayerMP var14;
                        if (var2.toLowerCase().startsWith("ban ")) {
                            var13 = var2.substring(var2.indexOf(" ")).trim();
                            var5.func_22159_a(var13);
                            this.func_22115_a(var4, "Banning " + var13);
                            var14 = var5.func_620_h(var13);
                            if (var14 != null) {
                                var14.field_20908_a.func_43_c("Banned by admin");
                            }
                        } else if (var2.toLowerCase().startsWith("pardon ")) {
                            var13 = var2.substring(var2.indexOf(" ")).trim();
                            var5.func_22161_b(var13);
                            this.func_22115_a(var4, "Pardoning " + var13);
                        } else {
                            int var8;
                            if (var2.toLowerCase().startsWith("kick ")) {
                                var13 = var2.substring(var2.indexOf(" ")).trim();
                                var14 = null;

                                for(var8 = 0; var8 < var5.field_924_b.size(); ++var8) {
                                    EntityPlayerMP var9 = (EntityPlayerMP)var5.field_924_b.get(var8);
                                    if (var9.field_409_aq.equalsIgnoreCase(var13)) {
                                        var14 = var9;
                                    }
                                }

                                if (var14 != null) {
                                    var14.field_20908_a.func_43_c("Kicked by admin");
                                    this.func_22115_a(var4, "Kicking " + var14.field_409_aq);
                                } else {
                                    var3.func_2_b("Can't find user " + var13 + ". No kick.");
                                }
                            } else {
                                EntityPlayerMP var15;
                                String[] var18;
                                if (var2.toLowerCase().startsWith("tp ")) {
                                    var18 = var2.split(" ");
                                    if (var18.length == 3) {
                                        var14 = var5.func_620_h(var18[1]);
                                        var15 = var5.func_620_h(var18[2]);
                                        if (var14 == null) {
                                            var3.func_2_b("Can't find user " + var18[1] + ". No tp.");
                                        } else if (var15 == null) {
                                            var3.func_2_b("Can't find user " + var18[2] + ". No tp.");
                                        } else if (var14.field_4110_as != var15.field_4110_as) {
                                            var3.func_2_b("User " + var18[1] + " and " + var18[2] + " are in different dimensions. No tp.");
                                        } else {
                                            var14.field_20908_a.func_41_a(var15.field_322_l, var15.field_321_m, var15.field_320_n, var15.field_316_r, var15.field_315_s);
                                            this.func_22115_a(var4, "Teleporting " + var18[1] + " to " + var18[2] + ".");
                                        }
                                    } else {
                                        var3.func_2_b("Syntax error, please provice a source and a target.");
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
                                        var15 = var5.func_620_h(var16);
                                        if (var15 != null) {
                                            try {
                                                var17 = Integer.parseInt(var18[2]);
                                                if (Item.field_176_c[var17] != null) {
                                                    this.func_22115_a(var4, "Giving " + var15.field_409_aq + " some " + var17);
                                                    int var10 = 1;
                                                    if (var18.length > 3) {
                                                        var10 = this.func_22112_a(var18[3], 1);
                                                    }

                                                    if (var10 < 1) {
                                                        var10 = 1;
                                                    }

                                                    if (var10 > 64) {
                                                        var10 = 64;
                                                    }

                                                    var15.func_20044_b(new ItemStack(var17, var10, 0));
                                                } else {
                                                    var3.func_2_b("There's no item with id " + var17);
                                                }
                                            } catch (NumberFormatException var11) {
                                                var3.func_2_b("There's no item with id " + var18[2]);
                                            }
                                        } else {
                                            var3.func_2_b("Can't find user " + var16);
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
                                                for(var17 = 0; var17 < this.field_22116_b.field_6034_e.length; ++var17) {
                                                    var19 = this.field_22116_b.field_6034_e[var17];
                                                    var19.func_32005_b(var19.func_22080_k() + (long)var8);
                                                }

                                                this.func_22115_a(var4, "Added " + var8 + " to time");
                                            } else if ("set".equalsIgnoreCase(var16)) {
                                                for(var17 = 0; var17 < this.field_22116_b.field_6034_e.length; ++var17) {
                                                    var19 = this.field_22116_b.field_6034_e[var17];
                                                    var19.func_32005_b((long)var8);
                                                }

                                                this.func_22115_a(var4, "Set time to " + var8);
                                            } else {
                                                var3.func_2_b("Unknown method, use either \"add\" or \"set\"");
                                            }
                                        } catch (NumberFormatException var12) {
                                            var3.func_2_b("Unable to convert time value, " + var18[2]);
                                        }
                                    } else if (var2.toLowerCase().startsWith("say ")) {
                                        var2 = var2.substring(var2.indexOf(" ")).trim();
                                        field_22117_a.info("[" + var4 + "] " + var2);
                                        var5.func_631_a(new Packet3Chat("\u00a7d[Server] " + var2));
                                    } else if (var2.toLowerCase().startsWith("tell ")) {
                                        var18 = var2.split(" ");
                                        if (var18.length >= 3) {
                                            var2 = var2.substring(var2.indexOf(" ")).trim();
                                            var2 = var2.substring(var2.indexOf(" ")).trim();
                                            field_22117_a.info("[" + var4 + "->" + var18[1] + "] " + var2);
                                            var2 = "\u00a77" + var4 + " whispers " + var2;
                                            field_22117_a.info(var2);
                                            if (!var5.func_621_a(var18[1], new Packet3Chat(var2))) {
                                                var3.func_2_b("There's no player by that name online.");
                                            }
                                        }
                                    } else if (var2.toLowerCase().startsWith("whitelist ")) {
                                        this.func_22113_a(var4, var2, var3);
                                    } else {
                                        field_22117_a.info("Unknown console command. Type \"help\" for help.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            this.func_22111_a(var3);
        }

    }

    private void func_22113_a(String var1, String var2, ICommandListener var3) {
        String[] var4 = var2.split(" ");
        if (var4.length >= 2) {
            String var5 = var4[1].toLowerCase();
            if ("on".equals(var5)) {
                this.func_22115_a(var1, "Turned on white-listing");
                this.field_22116_b.field_6035_d.func_22118_b("white-list", true);
            } else if ("off".equals(var5)) {
                this.func_22115_a(var1, "Turned off white-listing");
                this.field_22116_b.field_6035_d.func_22118_b("white-list", false);
            } else if ("list".equals(var5)) {
                Set var6 = this.field_22116_b.field_6033_f.func_22167_e();
                String var7 = "";

                String var9;
                for(Iterator var8 = var6.iterator(); var8.hasNext(); var7 = var7 + var9 + " ") {
                    var9 = (String)var8.next();
                }

                var3.func_2_b("White-listed players: " + var7);
            } else {
                String var10;
                if ("add".equals(var5) && var4.length == 3) {
                    var10 = var4[2].toLowerCase();
                    this.field_22116_b.field_6033_f.func_22169_k(var10);
                    this.func_22115_a(var1, "Added " + var10 + " to white-list");
                } else if ("remove".equals(var5) && var4.length == 3) {
                    var10 = var4[2].toLowerCase();
                    this.field_22116_b.field_6033_f.func_22170_l(var10);
                    this.func_22115_a(var1, "Removed " + var10 + " from white-list");
                } else if ("reload".equals(var5)) {
                    this.field_22116_b.field_6033_f.func_22171_f();
                    this.func_22115_a(var1, "Reloaded white-list from file");
                }
            }

        }
    }

    private void func_22111_a(ICommandListener var1) {
        var1.func_2_b("To run the server without a gui, start it like this:");
        var1.func_2_b("   java -Xmx1024M -Xms1024M -jar minecraft_server.jar nogui");
        var1.func_2_b("Console commands:");
        var1.func_2_b("   help  or  ?               shows this message");
        var1.func_2_b("   kick <player>             removes a player from the server");
        var1.func_2_b("   ban <player>              bans a player from the server");
        var1.func_2_b("   pardon <player>           pardons a banned player so that they can connect again");
        var1.func_2_b("   ban-ip <ip>               bans an IP address from the server");
        var1.func_2_b("   pardon-ip <ip>            pardons a banned IP address so that they can connect again");
        var1.func_2_b("   op <player>               turns a player into an op");
        var1.func_2_b("   deop <player>             removes op status from a player");
        var1.func_2_b("   tp <player1> <player2>    moves one player to the same location as another player");
        var1.func_2_b("   give <player> <id> [num]  gives a player a resource");
        var1.func_2_b("   tell <player> <message>   sends a private message to a player");
        var1.func_2_b("   stop                      gracefully stops the server");
        var1.func_2_b("   save-all                  forces a server-wide level save");
        var1.func_2_b("   save-off                  disables terrain saving (useful for backup scripts)");
        var1.func_2_b("   save-on                   re-enables terrain saving");
        var1.func_2_b("   list                      lists all currently connected players");
        var1.func_2_b("   say <message>             broadcasts a message to all players");
        var1.func_2_b("   time <add|set> <amount>   adds to or sets the world time (0-24000)");
    }

    private void func_22115_a(String var1, String var2) {
        String var3 = var1 + ": " + var2;
        this.field_22116_b.field_6033_f.func_630_i("\u00a77(" + var3 + ")");
        field_22117_a.info(var3);
    }

    private int func_22112_a(String var1, int var2) {
        try {
            return Integer.parseInt(var1);
        } catch (NumberFormatException var4) {
            return var2;
        }
    }
}
