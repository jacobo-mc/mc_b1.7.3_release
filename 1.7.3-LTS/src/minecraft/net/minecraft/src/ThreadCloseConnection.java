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
            if (NetworkManager.isRunning(this.field_28109_a)) {
                NetworkManager.getWriteThread(this.field_28109_a).interrupt();
                this.field_28109_a.networkShutdown("disconnect.closed");
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
