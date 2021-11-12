package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ConvertProgressUpdater implements IProgressUpdate {
    private long lastTimeMillis;
    // $FF: synthetic field
    final MinecraftServer mcServer;

    public ConvertProgressUpdater(MinecraftServer var1) {
        this.mcServer = var1;
        this.lastTimeMillis = System.currentTimeMillis();
    }

    public void func_438_a(String var1) {
    }

    public void setLoadingProgress(int var1) {
        if (System.currentTimeMillis() - this.lastTimeMillis >= 1000L) {
            this.lastTimeMillis = System.currentTimeMillis();
            MinecraftServer.logger.info("Converting... " + var1 + "%");
        }

    }

    public void displayLoadingString(String var1) {
    }
}
