package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class StatsSyncher {
    private volatile boolean field_27438_a = false;
    private volatile Map field_27437_b = null;
    private volatile Map field_27436_c = null;
    private StatFileWriter field_27435_d;
    private File field_27434_e;
    private File field_27433_f;
    private File field_27432_g;
    private File field_27431_h;
    private File field_27430_i;
    private File field_27429_j;
    private Session field_27428_k;
    private int field_27427_l = 0;
    private int field_27426_m = 0;

    public StatsSyncher(Session var1, StatFileWriter var2, File var3) {
        this.field_27434_e = new File(var3, "stats_" + var1.username.toLowerCase() + "_unsent.dat");
        this.field_27433_f = new File(var3, "stats_" + var1.username.toLowerCase() + ".dat");
        this.field_27430_i = new File(var3, "stats_" + var1.username.toLowerCase() + "_unsent.old");
        this.field_27429_j = new File(var3, "stats_" + var1.username.toLowerCase() + ".old");
        this.field_27432_g = new File(var3, "stats_" + var1.username.toLowerCase() + "_unsent.tmp");
        this.field_27431_h = new File(var3, "stats_" + var1.username.toLowerCase() + ".tmp");
        if (!var1.username.toLowerCase().equals(var1.username)) {
            this.func_28214_a(var3, "stats_" + var1.username + "_unsent.dat", this.field_27434_e);
            this.func_28214_a(var3, "stats_" + var1.username + ".dat", this.field_27433_f);
            this.func_28214_a(var3, "stats_" + var1.username + "_unsent.old", this.field_27430_i);
            this.func_28214_a(var3, "stats_" + var1.username + ".old", this.field_27429_j);
            this.func_28214_a(var3, "stats_" + var1.username + "_unsent.tmp", this.field_27432_g);
            this.func_28214_a(var3, "stats_" + var1.username + ".tmp", this.field_27431_h);
        }

        this.field_27435_d = var2;
        this.field_27428_k = var1;
        if (this.field_27434_e.exists()) {
            var2.func_27179_a(this.func_27415_a(this.field_27434_e, this.field_27432_g, this.field_27430_i));
        }

        this.func_27418_a();
    }

    private void func_28214_a(File var1, String var2, File var3) {
        File var4 = new File(var1, var2);
        if (var4.exists() && !var4.isDirectory() && !var3.exists()) {
            var4.renameTo(var3);
        }

    }

    private Map func_27415_a(File var1, File var2, File var3) {
        if (var1.exists()) {
            return this.func_27408_a(var1);
        } else if (var3.exists()) {
            return this.func_27408_a(var3);
        } else {
            return var2.exists() ? this.func_27408_a(var2) : null;
        }
    }

    private Map func_27408_a(File var1) {
        BufferedReader var2 = null;

        try {
            var2 = new BufferedReader(new FileReader(var1));
            String var3 = "";
            StringBuilder var4 = new StringBuilder();

            while((var3 = var2.readLine()) != null) {
                var4.append(var3);
            }

            Map var5 = StatFileWriter.func_27177_a(var4.toString());
            return var5;
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            if (var2 != null) {
                try {
                    var2.close();
                } catch (Exception var14) {
                    var14.printStackTrace();
                }
            }

        }

        return null;
    }

    private void func_27410_a(Map var1, File var2, File var3, File var4) throws IOException {
        PrintWriter var5 = new PrintWriter(new FileWriter(var3, false));

        try {
            var5.print(StatFileWriter.func_27185_a(this.field_27428_k.username, "local", var1));
        } finally {
            var5.close();
        }

        if (var4.exists()) {
            var4.delete();
        }

        if (var2.exists()) {
            var2.renameTo(var4);
        }

        var3.renameTo(var2);
    }

    public void func_27418_a() {
        if (this.field_27438_a) {
            throw new IllegalStateException("Can't get stats from server while StatsSyncher is busy!");
        } else {
            this.field_27427_l = 100;
            this.field_27438_a = true;
            (new ThreadStatSyncherReceive(this)).start();
        }
    }

    public void func_27424_a(Map var1) {
        if (this.field_27438_a) {
            throw new IllegalStateException("Can't save stats while StatsSyncher is busy!");
        } else {
            this.field_27427_l = 100;
            this.field_27438_a = true;
            (new ThreadStatSyncherSend(this, var1)).start();
        }
    }

    public void syncStatsFileWithMap(Map var1) {
        int var2 = 30;

        while(this.field_27438_a) {
            --var2;
            if (var2 <= 0) {
                break;
            }

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var10) {
                var10.printStackTrace();
            }
        }

        this.field_27438_a = true;

        try {
            this.func_27410_a(var1, this.field_27434_e, this.field_27432_g, this.field_27430_i);
        } catch (Exception var8) {
            var8.printStackTrace();
        } finally {
            this.field_27438_a = false;
        }

    }

    public boolean func_27420_b() {
        return this.field_27427_l <= 0 && !this.field_27438_a && this.field_27436_c == null;
    }

    public void func_27425_c() {
        if (this.field_27427_l > 0) {
            --this.field_27427_l;
        }

        if (this.field_27426_m > 0) {
            --this.field_27426_m;
        }

        if (this.field_27436_c != null) {
            this.field_27435_d.func_27187_c(this.field_27436_c);
            this.field_27436_c = null;
        }

        if (this.field_27437_b != null) {
            this.field_27435_d.func_27180_b(this.field_27437_b);
            this.field_27437_b = null;
        }

    }

    // $FF: synthetic method
    static Map func_27422_a(StatsSyncher var0) {
        return var0.field_27437_b;
    }

    // $FF: synthetic method
    static File func_27423_b(StatsSyncher var0) {
        return var0.field_27433_f;
    }

    // $FF: synthetic method
    static File func_27411_c(StatsSyncher var0) {
        return var0.field_27431_h;
    }

    // $FF: synthetic method
    static File func_27413_d(StatsSyncher var0) {
        return var0.field_27429_j;
    }

    // $FF: synthetic method
    static void func_27412_a(StatsSyncher var0, Map var1, File var2, File var3, File var4) throws IOException {
        var0.func_27410_a(var1, var2, var3, var4);
    }

    // $FF: synthetic method
    static Map func_27421_a(StatsSyncher var0, Map var1) {
        return var0.field_27437_b = var1;
    }

    // $FF: synthetic method
    static Map func_27409_a(StatsSyncher var0, File var1, File var2, File var3) {
        return var0.func_27415_a(var1, var2, var3);
    }

    // $FF: synthetic method
    static boolean func_27416_a(StatsSyncher var0, boolean var1) {
        return var0.field_27438_a = var1;
    }

    // $FF: synthetic method
    static File func_27414_e(StatsSyncher var0) {
        return var0.field_27434_e;
    }

    // $FF: synthetic method
    static File func_27417_f(StatsSyncher var0) {
        return var0.field_27432_g;
    }

    // $FF: synthetic method
    static File func_27419_g(StatsSyncher var0) {
        return var0.field_27430_i;
    }
}
