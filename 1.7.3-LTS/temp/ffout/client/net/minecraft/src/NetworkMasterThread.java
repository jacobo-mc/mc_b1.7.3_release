package net.minecraft.src;

class NetworkMasterThread extends Thread {
    // $FF: synthetic field
    final NetworkManager field_1086_a;

    NetworkMasterThread(NetworkManager var1) {
        this.field_1086_a = var1;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (NetworkManager.func_969_e(this.field_1086_a).isAlive()) {
                try {
                    NetworkManager.func_969_e(this.field_1086_a).stop();
                } catch (Throwable var3) {
                }
            }

            if (NetworkManager.func_963_f(this.field_1086_a).isAlive()) {
                try {
                    NetworkManager.func_963_f(this.field_1086_a).stop();
                } catch (Throwable var2) {
                }
            }
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }
}
