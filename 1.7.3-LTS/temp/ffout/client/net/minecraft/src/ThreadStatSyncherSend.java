package net.minecraft.src;

import java.util.Map;

class ThreadStatSyncherSend extends Thread {
    // $FF: synthetic field
    final Map field_27233_a;
    // $FF: synthetic field
    final StatsSyncher field_27232_b;

    ThreadStatSyncherSend(StatsSyncher var1, Map var2) {
        this.field_27232_b = var1;
        this.field_27233_a = var2;
    }

    public void run() {
        try {
            StatsSyncher.func_27412_a(this.field_27232_b, this.field_27233_a, StatsSyncher.func_27414_e(this.field_27232_b), StatsSyncher.func_27417_f(this.field_27232_b), StatsSyncher.func_27419_g(this.field_27232_b));
        } catch (Exception var5) {
            var5.printStackTrace();
        } finally {
            StatsSyncher.func_27416_a(this.field_27232_b, false);
        }

    }
}
