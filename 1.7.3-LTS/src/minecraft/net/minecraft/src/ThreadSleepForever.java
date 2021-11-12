package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ThreadSleepForever extends Thread {
    // $FF: synthetic field
    final Minecraft mc;

    public ThreadSleepForever(Minecraft var1, String var2) {
        super(var2);
        this.mc = var1;
        this.setDaemon(true);
        this.start();
    }

    public void run() {
        while(this.mc.running) {
            try {
                Thread.sleep(2147483647L);
            } catch (InterruptedException var2) {
            }
        }

    }
}
