package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class PlayerManager {
    public List players = new ArrayList();
    private PlayerHash playerInstances = new PlayerHash();
    private List playerInstancesToUpdate = new ArrayList();
    private MinecraftServer mcServer;
    private int field_28110_e;
    private int playerViewRadius;
    private final int[][] field_22089_e = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public PlayerManager(MinecraftServer var1, int var2, int var3) {
        if (var3 > 15) {
            throw new IllegalArgumentException("Too big view radius!");
        } else if (var3 < 3) {
            throw new IllegalArgumentException("Too small view radius!");
        } else {
            this.playerViewRadius = var3;
            this.mcServer = var1;
            this.field_28110_e = var2;
        }
    }

    public WorldServer getMinecraftServer() {
        return this.mcServer.getWorldManager(this.field_28110_e);
    }

    public void updatePlayerInstances() {
        for(int var1 = 0; var1 < this.playerInstancesToUpdate.size(); ++var1) {
            ((PlayerInstance)this.playerInstancesToUpdate.get(var1)).onUpdate();
        }

        this.playerInstancesToUpdate.clear();
    }

    private PlayerInstance getPlayerInstance(int var1, int var2, boolean var3) {
        long var4 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
        PlayerInstance var6 = (PlayerInstance)this.playerInstances.getValueByKey(var4);
        if (var6 == null && var3) {
            var6 = new PlayerInstance(this, var1, var2);
            this.playerInstances.add(var4, var6);
        }

        return var6;
    }

    public void markBlockNeedsUpdate(int var1, int var2, int var3) {
        int var4 = var1 >> 4;
        int var5 = var3 >> 4;
        PlayerInstance var6 = this.getPlayerInstance(var4, var5, false);
        if (var6 != null) {
            var6.markBlockNeedsUpdate(var1 & 15, var2, var3 & 15);
        }

    }

    public void addPlayer(EntityPlayerMP var1) {
        int var2 = (int)var1.posX >> 4;
        int var3 = (int)var1.posZ >> 4;
        var1.field_9155_d = var1.posX;
        var1.field_9154_e = var1.posZ;
        int var4 = 0;
        int var5 = this.playerViewRadius;
        int var6 = 0;
        int var7 = 0;
        this.getPlayerInstance(var2, var3, true).addPlayer(var1);

        int var8;
        for(var8 = 1; var8 <= var5 * 2; ++var8) {
            for(int var9 = 0; var9 < 2; ++var9) {
                int[] var10 = this.field_22089_e[var4++ % 4];

                for(int var11 = 0; var11 < var8; ++var11) {
                    var6 += var10[0];
                    var7 += var10[1];
                    this.getPlayerInstance(var2 + var6, var3 + var7, true).addPlayer(var1);
                }
            }
        }

        var4 %= 4;

        for(var8 = 0; var8 < var5 * 2; ++var8) {
            var6 += this.field_22089_e[var4][0];
            var7 += this.field_22089_e[var4][1];
            this.getPlayerInstance(var2 + var6, var3 + var7, true).addPlayer(var1);
        }

        this.players.add(var1);
    }

    public void removePlayer(EntityPlayerMP var1) {
        int var2 = (int)var1.field_9155_d >> 4;
        int var3 = (int)var1.field_9154_e >> 4;

        for(int var4 = var2 - this.playerViewRadius; var4 <= var2 + this.playerViewRadius; ++var4) {
            for(int var5 = var3 - this.playerViewRadius; var5 <= var3 + this.playerViewRadius; ++var5) {
                PlayerInstance var6 = this.getPlayerInstance(var4, var5, false);
                if (var6 != null) {
                    var6.removePlayer(var1);
                }
            }
        }

        this.players.remove(var1);
    }

    private boolean func_544_a(int var1, int var2, int var3, int var4) {
        int var5 = var1 - var3;
        int var6 = var2 - var4;
        if (var5 >= -this.playerViewRadius && var5 <= this.playerViewRadius) {
            return var6 >= -this.playerViewRadius && var6 <= this.playerViewRadius;
        } else {
            return false;
        }
    }

    public void func_543_c(EntityPlayerMP var1) {
        int var2 = (int)var1.posX >> 4;
        int var3 = (int)var1.posZ >> 4;
        double var4 = var1.field_9155_d - var1.posX;
        double var6 = var1.field_9154_e - var1.posZ;
        double var8 = var4 * var4 + var6 * var6;
        if (var8 >= 64.0D) {
            int var10 = (int)var1.field_9155_d >> 4;
            int var11 = (int)var1.field_9154_e >> 4;
            int var12 = var2 - var10;
            int var13 = var3 - var11;
            if (var12 != 0 || var13 != 0) {
                for(int var14 = var2 - this.playerViewRadius; var14 <= var2 + this.playerViewRadius; ++var14) {
                    for(int var15 = var3 - this.playerViewRadius; var15 <= var3 + this.playerViewRadius; ++var15) {
                        if (!this.func_544_a(var14, var15, var10, var11)) {
                            this.getPlayerInstance(var14, var15, true).addPlayer(var1);
                        }

                        if (!this.func_544_a(var14 - var12, var15 - var13, var2, var3)) {
                            PlayerInstance var16 = this.getPlayerInstance(var14 - var12, var15 - var13, false);
                            if (var16 != null) {
                                var16.removePlayer(var1);
                            }
                        }
                    }
                }

                var1.field_9155_d = var1.posX;
                var1.field_9154_e = var1.posZ;
            }
        }
    }

    public int getMaxTrackingDistance() {
        return this.playerViewRadius * 16 - 16;
    }

    // $FF: synthetic method
    static PlayerHash getPlayerInstances(PlayerManager var0) {
        return var0.playerInstances;
    }

    // $FF: synthetic method
    static List getPlayerInstancesToUpdate(PlayerManager var0) {
        return var0.playerInstancesToUpdate;
    }
}
