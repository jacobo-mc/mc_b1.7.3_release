package net.minecraft.src;

import java.io.IOException;

class NetworkWriterThread extends Thread {
    // $FF: synthetic field
    final NetworkManager netManager;

    NetworkWriterThread(NetworkManager var1, String var2) {
        super(var2);
        this.netManager = var1;
    }

    public void run() {
        synchronized(NetworkManager.threadSyncObject) {
            ++NetworkManager.numWriteThreads;
        }

        while(true) {
            boolean var13 = false;

            try {
                var13 = true;
                if (!NetworkManager.isRunning(this.netManager)) {
                    var13 = false;
                    break;
                }

                while(NetworkManager.sendNetworkPacket(this.netManager)) {
                }

                try {
                    sleep(100L);
                } catch (InterruptedException var16) {
                }

                try {
                    if (NetworkManager.func_28140_f(this.netManager) != null) {
                        NetworkManager.func_28140_f(this.netManager).flush();
                    }
                } catch (IOException var18) {
                    if (!NetworkManager.func_28138_e(this.netManager)) {
                        NetworkManager.func_30005_a(this.netManager, var18);
                    }

                    var18.printStackTrace();
                }
            } finally {
                if (var13) {
                    synchronized(NetworkManager.threadSyncObject) {
                        --NetworkManager.numWriteThreads;
                    }
                }
            }
        }

        synchronized(NetworkManager.threadSyncObject) {
            --NetworkManager.numWriteThreads;
        }
    }
}
