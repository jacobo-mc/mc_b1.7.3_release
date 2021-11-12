package net.minecraft.src;

import java.io.IOException;

class NetworkWriterThread extends Thread {
    // $FF: synthetic field
    final NetworkManager field_1063_a;

    NetworkWriterThread(NetworkManager var1, String var2) {
        super(var2);
        this.field_1063_a = var1;
    }

    public void run() {
        synchronized(NetworkManager.field_1478_a) {
            ++NetworkManager.field_1476_c;
        }

        while(true) {
            boolean var13 = false;

            try {
                var13 = true;
                if (!NetworkManager.func_971_a(this.field_1063_a)) {
                    var13 = false;
                    break;
                }

                while(NetworkManager.func_965_d(this.field_1063_a)) {
                }

                try {
                    sleep(100L);
                } catch (InterruptedException var16) {
                }

                try {
                    if (NetworkManager.func_28140_f(this.field_1063_a) != null) {
                        NetworkManager.func_28140_f(this.field_1063_a).flush();
                    }
                } catch (IOException var18) {
                    if (!NetworkManager.func_28138_e(this.field_1063_a)) {
                        NetworkManager.func_30005_a(this.field_1063_a, var18);
                    }

                    var18.printStackTrace();
                }
            } finally {
                if (var13) {
                    synchronized(NetworkManager.field_1478_a) {
                        --NetworkManager.field_1476_c;
                    }
                }
            }
        }

        synchronized(NetworkManager.field_1478_a) {
            --NetworkManager.field_1476_c;
        }
    }
}
