package net.minecraft.src;

class ThreadCloseConnection extends Thread {
    // $FF: synthetic field
    final NetworkManager field_28109_a;

    ThreadCloseConnection(NetworkManager var1) {
        this.field_28109_a = var1;
    }

    public void run() {
        try {
            Thread.sleep(2000L);
            if (NetworkManager.func_971_a(this.field_28109_a)) {
                NetworkManager.func_963_f(this.field_28109_a).interrupt();
                this.field_28109_a.func_974_a("disconnect.closed");
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
