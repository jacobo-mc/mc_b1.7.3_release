package net.minecraft.src;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NetworkManager {
    public static final Object field_1478_a = new Object();
    public static int field_1477_b;
    public static int field_1476_c;
    private Object field_1475_d = new Object();
    private Socket field_12258_e;
    private final SocketAddress field_1474_e;
    private DataInputStream field_1473_f;
    private DataOutputStream field_1472_g;
    private boolean field_1471_h = true;
    private List field_1470_i = Collections.synchronizedList(new ArrayList());
    private List field_1469_j = Collections.synchronizedList(new ArrayList());
    private List field_1468_k = Collections.synchronizedList(new ArrayList());
    private NetHandler field_1467_l;
    private boolean field_1466_m = false;
    private Thread field_1465_n;
    private Thread field_1464_o;
    private boolean field_1463_p = false;
    private String field_1462_q = "";
    private Object[] field_20101_t;
    private int field_1461_r = 0;
    private int field_1460_s = 0;
    public static int[] field_28145_d = new int[256];
    public static int[] field_28144_e = new int[256];
    public int field_1459_t = 0;
    private int field_20100_w = 50;

    public NetworkManager(Socket var1, String var2, NetHandler var3) throws IOException {
        this.field_12258_e = var1;
        this.field_1474_e = var1.getRemoteSocketAddress();
        this.field_1467_l = var3;

        try {
            var1.setSoTimeout(30000);
            var1.setTrafficClass(24);
        } catch (SocketException var5) {
            System.err.println(var5.getMessage());
        }

        this.field_1473_f = new DataInputStream(var1.getInputStream());
        this.field_1472_g = new DataOutputStream(new BufferedOutputStream(var1.getOutputStream(), 5120));
        this.field_1464_o = new NetworkReaderThread(this, var2 + " read thread");
        this.field_1465_n = new NetworkWriterThread(this, var2 + " write thread");
        this.field_1464_o.start();
        this.field_1465_n.start();
    }

    public void func_972_a(Packet var1) {
        if (!this.field_1466_m) {
            synchronized(this.field_1475_d) {
                this.field_1460_s += var1.func_329_a() + 1;
                if (var1.field_472_j) {
                    this.field_1468_k.add(var1);
                } else {
                    this.field_1469_j.add(var1);
                }

            }
        }
    }

    private boolean func_964_b() {
        boolean var1 = false;

        try {
            int[] var10000;
            int var10001;
            Packet var2;
            if (!this.field_1469_j.isEmpty() && (this.field_1459_t == 0 || System.currentTimeMillis() - ((Packet)this.field_1469_j.get(0)).field_20018_j >= (long)this.field_1459_t)) {
                synchronized(this.field_1475_d) {
                    var2 = (Packet)this.field_1469_j.remove(0);
                    this.field_1460_s -= var2.func_329_a() + 1;
                }

                Packet.func_328_a(var2, this.field_1472_g);
                var10000 = field_28144_e;
                var10001 = var2.func_326_b();
                var10000[var10001] += var2.func_329_a() + 1;
                var1 = true;
            }

            if (this.field_20100_w-- <= 0 && !this.field_1468_k.isEmpty() && (this.field_1459_t == 0 || System.currentTimeMillis() - ((Packet)this.field_1468_k.get(0)).field_20018_j >= (long)this.field_1459_t)) {
                synchronized(this.field_1475_d) {
                    var2 = (Packet)this.field_1468_k.remove(0);
                    this.field_1460_s -= var2.func_329_a() + 1;
                }

                Packet.func_328_a(var2, this.field_1472_g);
                var10000 = field_28144_e;
                var10001 = var2.func_326_b();
                var10000[var10001] += var2.func_329_a() + 1;
                this.field_20100_w = 0;
                var1 = true;
            }

            return var1;
        } catch (Exception var8) {
            if (!this.field_1463_p) {
                this.func_970_a(var8);
            }

            return false;
        }
    }

    public void func_28139_a() {
        this.field_1464_o.interrupt();
        this.field_1465_n.interrupt();
    }

    private boolean func_973_c() {
        boolean var1 = false;

        try {
            Packet var2 = Packet.func_324_b(this.field_1473_f, this.field_1467_l.func_27247_c());
            if (var2 != null) {
                int[] var10000 = field_28145_d;
                int var10001 = var2.func_326_b();
                var10000[var10001] += var2.func_329_a() + 1;
                this.field_1470_i.add(var2);
                var1 = true;
            } else {
                this.func_974_a("disconnect.endOfStream");
            }

            return var1;
        } catch (Exception var3) {
            if (!this.field_1463_p) {
                this.func_970_a(var3);
            }

            return false;
        }
    }

    private void func_970_a(Exception var1) {
        var1.printStackTrace();
        this.func_974_a("disconnect.genericReason", "Internal exception: " + var1.toString());
    }

    public void func_974_a(String var1, Object... var2) {
        if (this.field_1471_h) {
            this.field_1463_p = true;
            this.field_1462_q = var1;
            this.field_20101_t = var2;
            (new NetworkMasterThread(this)).start();
            this.field_1471_h = false;

            try {
                this.field_1473_f.close();
                this.field_1473_f = null;
            } catch (Throwable var6) {
            }

            try {
                this.field_1472_g.close();
                this.field_1472_g = null;
            } catch (Throwable var5) {
            }

            try {
                this.field_12258_e.close();
                this.field_12258_e = null;
            } catch (Throwable var4) {
            }

        }
    }

    public void func_967_a() {
        if (this.field_1460_s > 1048576) {
            this.func_974_a("disconnect.overflow");
        }

        if (this.field_1470_i.isEmpty()) {
            if (this.field_1461_r++ == 1200) {
                this.func_974_a("disconnect.timeout");
            }
        } else {
            this.field_1461_r = 0;
        }

        int var1 = 100;

        while(!this.field_1470_i.isEmpty() && var1-- >= 0) {
            Packet var2 = (Packet)this.field_1470_i.remove(0);
            var2.func_323_a(this.field_1467_l);
        }

        this.func_28139_a();
        if (this.field_1463_p && this.field_1470_i.isEmpty()) {
            this.field_1467_l.func_823_a(this.field_1462_q, this.field_20101_t);
        }

    }

    public void func_28142_c() {
        this.func_28139_a();
        this.field_1466_m = true;
        this.field_1464_o.interrupt();
        (new ThreadCloseConnection(this)).start();
    }

    // $FF: synthetic method
    static boolean func_971_a(NetworkManager var0) {
        return var0.field_1471_h;
    }

    // $FF: synthetic method
    static boolean func_968_b(NetworkManager var0) {
        return var0.field_1466_m;
    }

    // $FF: synthetic method
    static boolean func_966_c(NetworkManager var0) {
        return var0.func_973_c();
    }

    // $FF: synthetic method
    static boolean func_965_d(NetworkManager var0) {
        return var0.func_964_b();
    }

    // $FF: synthetic method
    static DataOutputStream func_28140_f(NetworkManager var0) {
        return var0.field_1472_g;
    }

    // $FF: synthetic method
    static boolean func_28138_e(NetworkManager var0) {
        return var0.field_1463_p;
    }

    // $FF: synthetic method
    static void func_30005_a(NetworkManager var0, Exception var1) {
        var0.func_970_a(var1);
    }

    // $FF: synthetic method
    static Thread func_969_e(NetworkManager var0) {
        return var0.field_1464_o;
    }

    // $FF: synthetic method
    static Thread func_963_f(NetworkManager var0) {
        return var0.field_1465_n;
    }
}
