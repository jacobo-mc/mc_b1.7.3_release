package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ThreadSleepForever extends Thread {
    // $FF: synthetic field
    final MinecraftServer mc;

    public ThreadSleepForever(MinecraftServer var1) {
        this.mc = var1;
        this.setDaemon(true);
        this.start();
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(2147483647L);
            } catch (InterruptedException var2) {
            }
        }
    }
}
