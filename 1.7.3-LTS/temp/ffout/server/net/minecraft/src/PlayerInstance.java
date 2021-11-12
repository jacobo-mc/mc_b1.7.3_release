package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

class PlayerInstance {
    private List field_1072_b;
    private int field_1071_c;
    private int field_1070_d;
    private ChunkCoordIntPair field_1069_e;
    private short[] field_1068_f;
    private int field_1067_g;
    private int field_1066_h;
    private int field_1065_i;
    private int field_1064_j;
    private int field_1063_k;
    private int field_1062_l;
    private int field_1061_m;
    // $FF: synthetic field
    final PlayerManager field_1073_a;

    public PlayerInstance(PlayerManager var1, int var2, int var3) {
        this.field_1073_a = var1;
        this.field_1072_b = new ArrayList();
        this.field_1068_f = new short[10];
        this.field_1067_g = 0;
        this.field_1071_c = var2;
        this.field_1070_d = var3;
        this.field_1069_e = new ChunkCoordIntPair(var2, var3);
        var1.func_540_a().field_20911_y.func_376_d(var2, var3);
    }

    public void func_779_a(EntityPlayerMP var1) {
        if (this.field_1072_b.contains(var1)) {
            throw new IllegalStateException("Failed to add player. " + var1 + " already is in chunk " + this.field_1071_c + ", " + this.field_1070_d);
        } else {
            var1.field_420_ah.add(this.field_1069_e);
            var1.field_20908_a.func_39_b(new Packet50PreChunk(this.field_1069_e.field_152_a, this.field_1069_e.field_151_b, true));
            this.field_1072_b.add(var1);
            var1.field_422_ag.add(this.field_1069_e);
        }
    }

    public void func_778_b(EntityPlayerMP var1) {
        if (this.field_1072_b.contains(var1)) {
            this.field_1072_b.remove(var1);
            if (this.field_1072_b.size() == 0) {
                long var2 = (long)this.field_1071_c + 2147483647L | (long)this.field_1070_d + 2147483647L << 32;
                PlayerManager.func_539_b(this.field_1073_a).func_670_b(var2);
                if (this.field_1067_g > 0) {
                    PlayerManager.func_533_c(this.field_1073_a).remove(this);
                }

                this.field_1073_a.func_540_a().field_20911_y.func_374_c(this.field_1071_c, this.field_1070_d);
            }

            var1.field_422_ag.remove(this.field_1069_e);
            if (var1.field_420_ah.contains(this.field_1069_e)) {
                var1.field_20908_a.func_39_b(new Packet50PreChunk(this.field_1071_c, this.field_1070_d, false));
            }

        }
    }

    public void func_775_a(int var1, int var2, int var3) {
        if (this.field_1067_g == 0) {
            PlayerManager.func_533_c(this.field_1073_a).add(this);
            this.field_1066_h = this.field_1065_i = var1;
            this.field_1064_j = this.field_1063_k = var2;
            this.field_1062_l = this.field_1061_m = var3;
        }

        if (this.field_1066_h > var1) {
            this.field_1066_h = var1;
        }

        if (this.field_1065_i < var1) {
            this.field_1065_i = var1;
        }

        if (this.field_1064_j > var2) {
            this.field_1064_j = var2;
        }

        if (this.field_1063_k < var2) {
            this.field_1063_k = var2;
        }

        if (this.field_1062_l > var3) {
            this.field_1062_l = var3;
        }

        if (this.field_1061_m < var3) {
            this.field_1061_m = var3;
        }

        if (this.field_1067_g < 10) {
            short var4 = (short)(var1 << 12 | var3 << 8 | var2);

            for(int var5 = 0; var5 < this.field_1067_g; ++var5) {
                if (this.field_1068_f[var5] == var4) {
                    return;
                }
            }

            this.field_1068_f[this.field_1067_g++] = var4;
        }

    }

    public void func_776_a(Packet var1) {
        for(int var2 = 0; var2 < this.field_1072_b.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.field_1072_b.get(var2);
            if (var3.field_420_ah.contains(this.field_1069_e)) {
                var3.field_20908_a.func_39_b(var1);
            }
        }

    }

    public void func_777_a() {
        WorldServer var1 = this.field_1073_a.func_540_a();
        if (this.field_1067_g != 0) {
            int var2;
            int var3;
            int var4;
            if (this.field_1067_g == 1) {
                var2 = this.field_1071_c * 16 + this.field_1066_h;
                var3 = this.field_1064_j;
                var4 = this.field_1070_d * 16 + this.field_1062_l;
                this.func_776_a(new Packet53BlockChange(var2, var3, var4, var1));
                if (Block.field_539_q[var1.func_444_a(var2, var3, var4)]) {
                    this.func_20178_a(var1.func_451_k(var2, var3, var4));
                }
            } else {
                int var5;
                if (this.field_1067_g == 10) {
                    this.field_1064_j = this.field_1064_j / 2 * 2;
                    this.field_1063_k = (this.field_1063_k / 2 + 1) * 2;
                    var2 = this.field_1066_h + this.field_1071_c * 16;
                    var3 = this.field_1064_j;
                    var4 = this.field_1062_l + this.field_1070_d * 16;
                    var5 = this.field_1065_i - this.field_1066_h + 1;
                    int var6 = this.field_1063_k - this.field_1064_j + 2;
                    int var7 = this.field_1061_m - this.field_1062_l + 1;
                    this.func_776_a(new Packet51MapChunk(var2, var3, var4, var5, var6, var7, var1));
                    List var8 = var1.func_532_d(var2, var3, var4, var2 + var5, var3 + var6, var4 + var7);

                    for(int var9 = 0; var9 < var8.size(); ++var9) {
                        this.func_20178_a((TileEntity)var8.get(var9));
                    }
                } else {
                    this.func_776_a(new Packet52MultiBlockChange(this.field_1071_c, this.field_1070_d, this.field_1068_f, this.field_1067_g, var1));

                    for(var2 = 0; var2 < this.field_1067_g; ++var2) {
                        var3 = this.field_1071_c * 16 + (this.field_1067_g >> 12 & 15);
                        var4 = this.field_1067_g & 255;
                        var5 = this.field_1070_d * 16 + (this.field_1067_g >> 8 & 15);
                        if (Block.field_539_q[var1.func_444_a(var3, var4, var5)]) {
                            System.out.println("Sending!");
                            this.func_20178_a(var1.func_451_k(var3, var4, var5));
                        }
                    }
                }
            }

            this.field_1067_g = 0;
        }
    }

    private void func_20178_a(TileEntity var1) {
        if (var1 != null) {
            Packet var2 = var1.func_20070_f();
            if (var2 != null) {
                this.func_776_a(var2);
            }
        }

    }
}
