package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public final class ThreadServerApplication extends Thread {
    // $FF: synthetic field
    final MinecraftServer mcServer;

    public ThreadServerApplication(String var1, MinecraftServer var2) {
        super(var1);
        this.mcServer = var2;
    }

    public void run() {
        this.mcServer.run();
    }
}
