package net.minecraft.src;

import java.io.IOException;

class NetworkWriterThread extends Thread {
    // $FF: synthetic field
    final NetworkManager field_826_a;

    NetworkWriterThread(NetworkManager var1, String var2) {
        super(var2);
        this.field_826_a = var1;
    }

    public void run() {
        synchronized(NetworkManager.field_1053_a) {
            ++NetworkManager.field_1051_c;
        }

        while(true) {
            boolean var13 = false;

            try {
                var13 = true;
                if (!NetworkManager.func_743_a(this.field_826_a)) {
                    var13 = false;
                    break;
                }

                while(NetworkManager.func_749_d(this.field_826_a)) {
                }

                try {
                    sleep(100L);
                } catch (InterruptedException var16) {
                }

                try {
                    if (NetworkManager.func_28136_f(this.field_826_a) != null) {
                        NetworkManager.func_28136_f(this.field_826_a).flush();
                    }
                } catch (IOException var18) {
                    if (!NetworkManager.func_28135_e(this.field_826_a)) {
                        NetworkManager.func_30007_a(this.field_826_a, var18);
                    }

                    var18.printStackTrace();
                }
            } finally {
                if (var13) {
                    synchronized(NetworkManager.field_1053_a) {
                        --NetworkManager.field_1051_c;
                    }
                }
            }
        }

        synchronized(NetworkManager.field_1053_a) {
            --NetworkManager.field_1051_c;
        }
    }
}
