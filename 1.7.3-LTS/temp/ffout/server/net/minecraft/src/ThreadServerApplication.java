package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public final class ThreadServerApplication extends Thread {
    // $FF: synthetic field
    final MinecraftServer field_1033_a;

    public ThreadServerApplication(String var1, MinecraftServer var2) {
        super(var1);
        this.field_1033_a = var2;
    }

    public void run() {
        this.field_1033_a.run();
    }
}
