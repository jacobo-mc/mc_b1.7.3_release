package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ThreadSleepForever extends Thread {
    // $FF: synthetic field
    final MinecraftServer field_1031_a;

    public ThreadSleepForever(MinecraftServer var1) {
        this.field_1031_a = var1;
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
