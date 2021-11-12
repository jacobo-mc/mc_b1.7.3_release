package net.minecraft.src;

class NetworkReaderThread extends Thread {
    // $FF: synthetic field
    final NetworkManager field_827_a;

    NetworkReaderThread(NetworkManager var1, String var2) {
        super(var2);
        this.field_827_a = var1;
    }

    public void run() {
        synchronized(NetworkManager.field_1053_a) {
            ++NetworkManager.field_1052_b;
        }

        while(true) {
            boolean var12 = false;

            try {
                var12 = true;
                if (!NetworkManager.func_743_a(this.field_827_a)) {
                    var12 = false;
                    break;
                }

                if (NetworkManager.func_740_b(this.field_827_a)) {
                    var12 = false;
                    break;
                }

                while(NetworkManager.func_751_c(this.field_827_a)) {
                }

                try {
                    sleep(100L);
                } catch (InterruptedException var15) {
                }
            } finally {
                if (var12) {
                    synchronized(NetworkManager.field_1053_a) {
                        --NetworkManager.field_1052_b;
                    }
                }
            }
        }

        synchronized(NetworkManager.field_1053_a) {
            --NetworkManager.field_1052_b;
        }
    }
}
