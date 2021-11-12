package net.minecraft.src;

class NetworkReaderThread extends Thread {
    // $FF: synthetic field
    final NetworkManager netManager;

    NetworkReaderThread(NetworkManager var1, String var2) {
        super(var2);
        this.netManager = var1;
    }

    public void run() {
        synchronized(NetworkManager.threadSyncObject) {
            ++NetworkManager.numReadThreads;
        }

        while(true) {
            boolean var12 = false;

            try {
                var12 = true;
                if (!NetworkManager.isRunning(this.netManager)) {
                    var12 = false;
                    break;
                }

                if (NetworkManager.isServerTerminating(this.netManager)) {
                    var12 = false;
                    break;
                }

                while(NetworkManager.readNetworkPacket(this.netManager)) {
                }

                try {
                    sleep(100L);
                } catch (InterruptedException var15) {
                }
            } finally {
                if (var12) {
                    synchronized(NetworkManager.threadSyncObject) {
                        --NetworkManager.numReadThreads;
                    }
                }
            }
        }

        synchronized(NetworkManager.threadSyncObject) {
            --NetworkManager.numReadThreads;
        }
    }
}
