package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class PlayerManager {
    public List field_9216_a = new ArrayList();
    private PlayerHash field_9215_b = new PlayerHash();
    private List field_833_c = new ArrayList();
    private MinecraftServer field_832_d;
    private int field_28110_e;
    private int field_28109_f;
    private final int[][] field_22089_e = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public PlayerManager(MinecraftServer var1, int var2, int var3) {
        if (var3 > 15) {
            throw new IllegalArgumentException("Too big view radius!");
        } else if (var3 < 3) {
            throw new IllegalArgumentException("Too small view radius!");
        } else {
            this.field_28109_f = var3;
            this.field_832_d = var1;
            this.field_28110_e = var2;
        }
    }

    public WorldServer func_540_a() {
        return this.field_832_d.func_28004_a(this.field_28110_e);
    }

    public void func_538_a() {
        for(int var1 = 0; var1 < this.field_833_c.size(); ++var1) {
            ((PlayerInstance)this.field_833_c.get(var1)).func_777_a();
        }

        this.field_833_c.clear();
    }

    private PlayerInstance func_537_a(int var1, int var2, boolean var3) {
        long var4 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
        PlayerInstance var6 = (PlayerInstance)this.field_9215_b.func_677_a(var4);
        if (var6 == null && var3) {
            var6 = new PlayerInstance(this, var1, var2);
            this.field_9215_b.func_675_a(var4, var6);
        }

        return var6;
    }

    public void func_535_a(int var1, int var2, int var3) {
        int var4 = var1 >> 4;
        int var5 = var3 >> 4;
        PlayerInstance var6 = this.func_537_a(var4, var5, false);
        if (var6 != null) {
            var6.func_775_a(var1 & 15, var2, var3 & 15);
        }

    }

    public void func_9214_a(EntityPlayerMP var1) {
        int var2 = (int)var1.field_322_l >> 4;
        int var3 = (int)var1.field_320_n >> 4;
        var1.field_9155_d = var1.field_322_l;
        var1.field_9154_e = var1.field_320_n;
        int var4 = 0;
        int var5 = this.field_28109_f;
        int var6 = 0;
        int var7 = 0;
        this.func_537_a(var2, var3, true).func_779_a(var1);

        int var8;
        for(var8 = 1; var8 <= var5 * 2; ++var8) {
            for(int var9 = 0; var9 < 2; ++var9) {
                int[] var10 = this.field_22089_e[var4++ % 4];

                for(int var11 = 0; var11 < var8; ++var11) {
                    var6 += var10[0];
                    var7 += var10[1];
                    this.func_537_a(var2 + var6, var3 + var7, true).func_779_a(var1);
                }
            }
        }

        var4 %= 4;

        for(var8 = 0; var8 < var5 * 2; ++var8) {
            var6 += this.field_22089_e[var4][0];
            var7 += this.field_22089_e[var4][1];
            this.func_537_a(var2 + var6, var3 + var7, true).func_779_a(var1);
        }

        this.field_9216_a.add(var1);
    }

    public void func_9213_b(EntityPlayerMP var1) {
        int var2 = (int)var1.field_9155_d >> 4;
        int var3 = (int)var1.field_9154_e >> 4;

        for(int var4 = var2 - this.field_28109_f; var4 <= var2 + this.field_28109_f; ++var4) {
            for(int var5 = var3 - this.field_28109_f; var5 <= var3 + this.field_28109_f; ++var5) {
                PlayerInstance var6 = this.func_537_a(var4, var5, false);
                if (var6 != null) {
                    var6.func_778_b(var1);
                }
            }
        }

        this.field_9216_a.remove(var1);
    }

    private boolean func_544_a(int var1, int var2, int var3, int var4) {
        int var5 = var1 - var3;
        int var6 = var2 - var4;
        if (var5 >= -this.field_28109_f && var5 <= this.field_28109_f) {
            return var6 >= -this.field_28109_f && var6 <= this.field_28109_f;
        } else {
            return false;
        }
    }

    public void func_543_c(EntityPlayerMP var1) {
        int var2 = (int)var1.field_322_l >> 4;
        int var3 = (int)var1.field_320_n >> 4;
        double var4 = var1.field_9155_d - var1.field_322_l;
        double var6 = var1.field_9154_e - var1.field_320_n;
        double var8 = var4 * var4 + var6 * var6;
        if (var8 >= 64.0D) {
            int var10 = (int)var1.field_9155_d >> 4;
            int var11 = (int)var1.field_9154_e >> 4;
            int var12 = var2 - var10;
            int var13 = var3 - var11;
            if (var12 != 0 || var13 != 0) {
                for(int var14 = var2 - this.field_28109_f; var14 <= var2 + this.field_28109_f; ++var14) {
                    for(int var15 = var3 - this.field_28109_f; var15 <= var3 + this.field_28109_f; ++var15) {
                        if (!this.func_544_a(var14, var15, var10, var11)) {
                            this.func_537_a(var14, var15, true).func_779_a(var1);
                        }

                        if (!this.func_544_a(var14 - var12, var15 - var13, var2, var3)) {
                            PlayerInstance var16 = this.func_537_a(var14 - var12, var15 - var13, false);
                            if (var16 != null) {
                                var16.func_778_b(var1);
                            }
                        }
                    }
                }

                var1.field_9155_d = var1.field_322_l;
                var1.field_9154_e = var1.field_320_n;
            }
        }
    }

    public int func_542_b() {
        return this.field_28109_f * 16 - 16;
    }

    // $FF: synthetic method
    static PlayerHash func_539_b(PlayerManager var0) {
        return var0.field_9215_b;
    }

    // $FF: synthetic method
    static List func_533_c(PlayerManager var0) {
        return var0.field_833_c;
    }
}
