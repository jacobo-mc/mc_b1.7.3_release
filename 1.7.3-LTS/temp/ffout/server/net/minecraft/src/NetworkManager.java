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
    public static final Object field_1053_a = new Object();
    public static int field_1052_b;
    public static int field_1051_c;
    private Object field_1050_d = new Object();
    private Socket field_1049_e;
    private final SocketAddress field_12032_f;
    private DataInputStream field_1048_f;
    private DataOutputStream field_1047_g;
    private boolean field_1046_h = true;
    private List field_1045_i = Collections.synchronizedList(new ArrayList());
    private List field_1044_j = Collections.synchronizedList(new ArrayList());
    private List field_1043_k = Collections.synchronizedList(new ArrayList());
    private NetHandler field_1042_l;
    private boolean field_1041_m = false;
    private Thread field_1040_n;
    private Thread field_1039_o;
    private boolean field_1038_p = false;
    private String field_1037_q = "";
    private Object[] field_20176_t;
    private int field_1036_r = 0;
    private int field_1035_s = 0;
    public static int[] field_28141_d = new int[256];
    public static int[] field_28140_e = new int[256];
    public int field_1034_t = 0;
    private int field_20175_w = 50;

    public NetworkManager(Socket var1, String var2, NetHandler var3) throws IOException {
        this.field_1049_e = var1;
        this.field_12032_f = var1.getRemoteSocketAddress();
        this.field_1042_l = var3;

        try {
            var1.setSoTimeout(30000);
            var1.setTrafficClass(24);
        } catch (SocketException var5) {
            System.err.println(var5.getMessage());
        }

        this.field_1048_f = new DataInputStream(var1.getInputStream());
        this.field_1047_g = new DataOutputStream(new BufferedOutputStream(var1.getOutputStream(), 5120));
        this.field_1039_o = new NetworkReaderThread(this, var2 + " read thread");
        this.field_1040_n = new NetworkWriterThread(this, var2 + " write thread");
        this.field_1039_o.start();
        this.field_1040_n.start();
    }

    public void func_754_a(NetHandler var1) {
        this.field_1042_l = var1;
    }

    public void func_745_a(Packet var1) {
        if (!this.field_1041_m) {
            synchronized(this.field_1050_d) {
                this.field_1035_s += var1.func_71_a() + 1;
                if (var1.field_40_j) {
                    this.field_1043_k.add(var1);
                } else {
                    this.field_1044_j.add(var1);
                }

            }
        }
    }

    private boolean func_746_e() {
        boolean var1 = false;

        try {
            int[] var10000;
            int var10001;
            Packet var2;
            if (!this.field_1044_j.isEmpty() && (this.field_1034_t == 0 || System.currentTimeMillis() - ((Packet)this.field_1044_j.get(0)).field_20009_j >= (long)this.field_1034_t)) {
                synchronized(this.field_1050_d) {
                    var2 = (Packet)this.field_1044_j.remove(0);
                    this.field_1035_s -= var2.func_71_a() + 1;
                }

                Packet.func_66_a(var2, this.field_1047_g);
                var10000 = field_28140_e;
                var10001 = var2.func_69_b();
                var10000[var10001] += var2.func_71_a() + 1;
                var1 = true;
            }

            if (this.field_20175_w-- <= 0 && !this.field_1043_k.isEmpty() && (this.field_1034_t == 0 || System.currentTimeMillis() - ((Packet)this.field_1043_k.get(0)).field_20009_j >= (long)this.field_1034_t)) {
                synchronized(this.field_1050_d) {
                    var2 = (Packet)this.field_1043_k.remove(0);
                    this.field_1035_s -= var2.func_71_a() + 1;
                }

                Packet.func_66_a(var2, this.field_1047_g);
                var10000 = field_28140_e;
                var10001 = var2.func_69_b();
                var10000[var10001] += var2.func_71_a() + 1;
                this.field_20175_w = 0;
                var1 = true;
            }

            return var1;
        } catch (Exception var8) {
            if (!this.field_1038_p) {
                this.func_750_a(var8);
            }

            return false;
        }
    }

    public void func_28138_a() {
        this.field_1039_o.interrupt();
        this.field_1040_n.interrupt();
    }

    private boolean func_741_f() {
        boolean var1 = false;

        try {
            Packet var2 = Packet.func_65_b(this.field_1048_f, this.field_1042_l.func_27003_c());
            if (var2 != null) {
                int[] var10000 = field_28141_d;
                int var10001 = var2.func_69_b();
                var10000[var10001] += var2.func_71_a() + 1;
                this.field_1045_i.add(var2);
                var1 = true;
            } else {
                this.func_753_a("disconnect.endOfStream");
            }

            return var1;
        } catch (Exception var3) {
            if (!this.field_1038_p) {
                this.func_750_a(var3);
            }

            return false;
        }
    }

    private void func_750_a(Exception var1) {
        var1.printStackTrace();
        this.func_753_a("disconnect.genericReason", "Internal exception: " + var1.toString());
    }

    public void func_753_a(String var1, Object... var2) {
        if (this.field_1046_h) {
            this.field_1038_p = true;
            this.field_1037_q = var1;
            this.field_20176_t = var2;
            (new NetworkMasterThread(this)).start();
            this.field_1046_h = false;

            try {
                this.field_1048_f.close();
                this.field_1048_f = null;
            } catch (Throwable var6) {
            }

            try {
                this.field_1047_g.close();
                this.field_1047_g = null;
            } catch (Throwable var5) {
            }

            try {
                this.field_1049_e.close();
                this.field_1049_e = null;
            } catch (Throwable var4) {
            }

        }
    }

    public void func_747_a() {
        if (this.field_1035_s > 1048576) {
            this.func_753_a("disconnect.overflow");
        }

        if (this.field_1045_i.isEmpty()) {
            if (this.field_1036_r++ == 1200) {
                this.func_753_a("disconnect.timeout");
            }
        } else {
            this.field_1036_r = 0;
        }

        int var1 = 100;

        while(!this.field_1045_i.isEmpty() && var1-- >= 0) {
            Packet var2 = (Packet)this.field_1045_i.remove(0);
            var2.func_72_a(this.field_1042_l);
        }

        this.func_28138_a();
        if (this.field_1038_p && this.field_1045_i.isEmpty()) {
            this.field_1042_l.func_6_a(this.field_1037_q, this.field_20176_t);
        }

    }

    public SocketAddress func_755_b() {
        return this.field_12032_f;
    }

    public void func_752_c() {
        this.func_28138_a();
        this.field_1041_m = true;
        this.field_1039_o.interrupt();
        (new ThreadMonitorConnection(this)).start();
    }

    public int func_744_d() {
        return this.field_1043_k.size();
    }

    // $FF: synthetic method
    static boolean func_743_a(NetworkManager var0) {
        return var0.field_1046_h;
    }

    // $FF: synthetic method
    static boolean func_740_b(NetworkManager var0) {
        return var0.field_1041_m;
    }

    // $FF: synthetic method
    static boolean func_751_c(NetworkManager var0) {
        return var0.func_741_f();
    }

    // $FF: synthetic method
    static boolean func_749_d(NetworkManager var0) {
        return var0.func_746_e();
    }

    // $FF: synthetic method
    static DataOutputStream func_28136_f(NetworkManager var0) {
        return var0.field_1047_g;
    }

    // $FF: synthetic method
    static boolean func_28135_e(NetworkManager var0) {
        return var0.field_1038_p;
    }

    // $FF: synthetic method
    static void func_30007_a(NetworkManager var0, Exception var1) {
        var0.func_750_a(var1);
    }

    // $FF: synthetic method
    static Thread func_742_e(NetworkManager var0) {
        return var0.field_1039_o;
    }

    // $FF: synthetic method
    static Thread func_748_f(NetworkManager var0) {
        return var0.field_1040_n;
    }
}
