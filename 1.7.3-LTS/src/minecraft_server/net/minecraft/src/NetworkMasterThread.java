package net.minecraft.src;

class NetworkMasterThread extends Thread {
    // $FF: synthetic field
    final NetworkManager netManager;

    NetworkMasterThread(NetworkManager var1) {
        this.netManager = var1;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (NetworkManager.getReadThread(this.netManager).isAlive()) {
                try {
                    NetworkManager.getReadThread(this.netManager).stop();
                } catch (Throwable var3) {
                }
            }

            if (NetworkManager.getWriteThread(this.netManager).isAlive()) {
                try {
                    NetworkManager.getWriteThread(this.netManager).stop();
                } catch (Throwable var2) {
                }
            }
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }
}
