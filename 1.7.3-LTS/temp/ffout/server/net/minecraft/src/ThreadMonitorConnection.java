package net.minecraft.src;

class ThreadMonitorConnection extends Thread {
    // $FF: synthetic field
    final NetworkManager field_828_a;

    ThreadMonitorConnection(NetworkManager var1) {
        this.field_828_a = var1;
    }

    public void run() {
        try {
            Thread.sleep(2000L);
            if (NetworkManager.func_743_a(this.field_828_a)) {
                NetworkManager.func_748_f(this.field_828_a).interrupt();
                this.field_828_a.func_753_a("disconnect.closed");
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
