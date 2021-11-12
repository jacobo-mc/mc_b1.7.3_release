package net.minecraft.src;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetLoginHandler extends NetHandler {
    public static Logger field_9_a = Logger.getLogger("Minecraft");
    private static Random field_6_d = new Random();
    public NetworkManager field_8_b;
    public boolean field_7_c = false;
    private MinecraftServer field_5_e;
    private int field_9005_f = 0;
    private String field_3_g = null;
    private Packet1Login field_9004_h = null;
    private String field_1_i = "";

    public NetLoginHandler(MinecraftServer var1, Socket var2, String var3) throws IOException {
        this.field_5_e = var1;
        this.field_8_b = new NetworkManager(var2, var3, this);
        this.field_8_b.field_1034_t = 0;
    }

    public void func_33_a() {
        if (this.field_9004_h != null) {
            this.func_6007_b(this.field_9004_h);
            this.field_9004_h = null;
        }

        if (this.field_9005_f++ == 600) {
            this.func_34_b("Took too long to log in");
        } else {
            this.field_8_b.func_747_a();
        }

    }

    public void func_34_b(String var1) {
        try {
            field_9_a.info("Disconnecting " + this.func_35_b() + ": " + var1);
            this.field_8_b.func_745_a(new Packet255KickDisconnect(var1));
            this.field_8_b.func_752_c();
            this.field_7_c = true;
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public void func_6004_a(Packet2Handshake var1) {
        if (this.field_5_e.field_6027_l) {
            this.field_1_i = Long.toHexString(field_6_d.nextLong());
            this.field_8_b.func_745_a(new Packet2Handshake(this.field_1_i));
        } else {
            this.field_8_b.func_745_a(new Packet2Handshake("-"));
        }

    }

    public void func_4001_a(Packet1Login var1) {
        this.field_3_g = var1.field_113_b;
        if (var1.field_4024_a != 14) {
            if (var1.field_4024_a > 14) {
                this.func_34_b("Outdated server!");
            } else {
                this.func_34_b("Outdated client!");
            }

        } else {
            if (!this.field_5_e.field_6027_l) {
                this.func_6007_b(var1);
            } else {
                (new ThreadLoginVerifier(this, var1)).start();
            }

        }
    }

    public void func_6007_b(Packet1Login var1) {
        EntityPlayerMP var2 = this.field_5_e.field_6033_f.func_619_a(this, var1.field_113_b);
        if (var2 != null) {
            this.field_5_e.field_6033_f.func_28166_b(var2);
            var2.func_28007_a(this.field_5_e.func_28004_a(var2.field_4110_as));
            field_9_a.info(this.func_35_b() + " logged in with entity id " + var2.field_331_c + " at (" + var2.field_322_l + ", " + var2.field_321_m + ", " + var2.field_320_n + ")");
            WorldServer var3 = this.field_5_e.func_28004_a(var2.field_4110_as);
            ChunkCoordinates var4 = var3.func_22078_l();
            NetServerHandler var5 = new NetServerHandler(this.field_5_e, this.field_8_b, var2);
            var5.func_39_b(new Packet1Login("", var2.field_331_c, var3.func_22079_j(), (byte)var3.field_4272_q.field_6165_g));
            var5.func_39_b(new Packet6SpawnPosition(var4.field_22216_a, var4.field_529_a, var4.field_528_b));
            this.field_5_e.field_6033_f.func_28170_a(var2, var3);
            this.field_5_e.field_6033_f.func_631_a(new Packet3Chat("\u00a7e" + var2.field_409_aq + " joined the game."));
            this.field_5_e.field_6033_f.func_627_a(var2);
            var5.func_41_a(var2.field_322_l, var2.field_321_m, var2.field_320_n, var2.field_316_r, var2.field_315_s);
            this.field_5_e.field_6036_c.func_4108_a(var5);
            var5.func_39_b(new Packet4UpdateTime(var3.func_22080_k()));
            var2.func_20057_k();
        }

        this.field_7_c = true;
    }

    public void func_6_a(String var1, Object[] var2) {
        field_9_a.info(this.func_35_b() + " lost connection");
        this.field_7_c = true;
    }

    public void func_6001_a(Packet var1) {
        this.func_34_b("Protocol error");
    }

    public String func_35_b() {
        return this.field_3_g != null ? this.field_3_g + " [" + this.field_8_b.func_755_b().toString() + "]" : this.field_8_b.func_755_b().toString();
    }

    public boolean func_27003_c() {
        return true;
    }

    // $FF: synthetic method
    static String func_32_a(NetLoginHandler var0) {
        return var0.field_1_i;
    }

    // $FF: synthetic method
    static Packet1Login func_31_a(NetLoginHandler var0, Packet1Login var1) {
        return var0.field_9004_h = var1;
    }
}
