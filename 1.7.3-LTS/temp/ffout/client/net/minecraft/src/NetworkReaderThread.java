package net.minecraft.src;

class NetworkReaderThread extends Thread {
    // $FF: synthetic field
    final NetworkManager field_1085_a;

    NetworkReaderThread(NetworkManager var1, String var2) {
        super(var2);
        this.field_1085_a = var1;
    }

    public void run() {
        synchronized(NetworkManager.field_1478_a) {
            ++NetworkManager.field_1477_b;
        }

        while(true) {
            boolean var12 = false;

            try {
                var12 = true;
                if (!NetworkManager.func_971_a(this.field_1085_a)) {
                    var12 = false;
                    break;
                }

                if (NetworkManager.func_968_b(this.field_1085_a)) {
                    var12 = false;
                    break;
                }

                while(NetworkManager.func_966_c(this.field_1085_a)) {
                }

                try {
                    sleep(100L);
                } catch (InterruptedException var15) {
                }
            } finally {
                if (var12) {
                    synchronized(NetworkManager.field_1478_a) {
                        --NetworkManager.field_1477_b;
                    }
                }
            }
        }

        synchronized(NetworkManager.field_1478_a) {
            --NetworkManager.field_1477_b;
        }
    }
}
