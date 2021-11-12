package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ThreadSleepForever extends Thread {
    // $FF: synthetic field
    final Minecraft field_1588_a;

    public ThreadSleepForever(Minecraft var1, String var2) {
        super(var2);
        this.field_1588_a = var1;
        this.setDaemon(true);
        this.start();
    }

    public void run() {
        while(this.field_1588_a.field_6293_H) {
            try {
                Thread.sleep(2147483647L);
            } catch (InterruptedException var2) {
            }
        }

    }
}
