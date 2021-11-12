package net.minecraft.src;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class NetworkListenThread {
    public static Logger field_974_a = Logger.getLogger("Minecraft");
    private ServerSocket field_979_d;
    private Thread field_978_e;
    public volatile boolean field_973_b = false;
    private int field_977_f = 0;
    private ArrayList field_976_g = new ArrayList();
    private ArrayList field_975_h = new ArrayList();
    public MinecraftServer field_980_c;

    public NetworkListenThread(MinecraftServer var1, InetAddress var2, int var3) throws IOException {
        this.field_980_c = var1;
        this.field_979_d = new ServerSocket(var3, 0, var2);
        this.field_979_d.setPerformancePreferences(0, 2, 1);
        this.field_973_b = true;
        this.field_978_e = new NetworkAcceptThread(this, "Listen thread", var1);
        this.field_978_e.start();
    }

    public void func_4108_a(NetServerHandler var1) {
        this.field_975_h.add(var1);
    }

    private void func_717_a(NetLoginHandler var1) {
        if (var1 == null) {
            throw new IllegalArgumentException("Got null pendingconnection!");
        } else {
            this.field_976_g.add(var1);
        }
    }

    public void func_715_a() {
        int var1;
        for(var1 = 0; var1 < this.field_976_g.size(); ++var1) {
            NetLoginHandler var2 = (NetLoginHandler)this.field_976_g.get(var1);

            try {
                var2.func_33_a();
            } catch (Exception var5) {
                var2.func_34_b("Internal server error");
                field_974_a.log(Level.WARNING, "Failed to handle packet: " + var5, var5);
            }

            if (var2.field_7_c) {
                this.field_976_g.remove(var1--);
            }

            var2.field_8_b.func_28138_a();
        }

        for(var1 = 0; var1 < this.field_975_h.size(); ++var1) {
            NetServerHandler var6 = (NetServerHandler)this.field_975_h.get(var1);

            try {
                var6.func_42_a();
            } catch (Exception var4) {
                field_974_a.log(Level.WARNING, "Failed to handle packet: " + var4, var4);
                var6.func_43_c("Internal server error");
            }

            if (var6.field_18_c) {
                this.field_975_h.remove(var1--);
            }

            var6.field_19_b.func_28138_a();
        }

    }

    // $FF: synthetic method
    static ServerSocket func_713_a(NetworkListenThread var0) {
        return var0.field_979_d;
    }

    // $FF: synthetic method
    static int func_712_b(NetworkListenThread var0) {
        return var0.field_977_f++;
    }

    // $FF: synthetic method
    static void func_716_a(NetworkListenThread var0, NetLoginHandler var1) {
        var0.func_717_a(var1);
    }
}
