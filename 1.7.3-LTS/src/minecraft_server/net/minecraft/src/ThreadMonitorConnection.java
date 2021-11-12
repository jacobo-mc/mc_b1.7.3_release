package net.minecraft.src;

class ThreadMonitorConnection extends Thread {
    // $FF: synthetic field
    final NetworkManager netManager;

    ThreadMonitorConnection(NetworkManager var1) {
        this.netManager = var1;
    }

    public void run() {
        try {
            Thread.sleep(2000L);
            if (NetworkManager.isRunning(this.netManager)) {
                NetworkManager.getWriteThread(this.netManager).interrupt();
                this.netManager.networkShutdown("disconnect.closed");
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
