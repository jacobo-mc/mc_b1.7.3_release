package net.minecraft.src;

class NetworkMasterThread extends Thread {
    // $FF: synthetic field
    final NetworkManager field_829_a;

    NetworkMasterThread(NetworkManager var1) {
        this.field_829_a = var1;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (NetworkManager.func_742_e(this.field_829_a).isAlive()) {
                try {
                    NetworkManager.func_742_e(this.field_829_a).stop();
                } catch (Throwable var3) {
                }
            }

            if (NetworkManager.func_748_f(this.field_829_a).isAlive()) {
                try {
                    NetworkManager.func_748_f(this.field_829_a).stop();
                } catch (Throwable var2) {
                }
            }
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }
}
