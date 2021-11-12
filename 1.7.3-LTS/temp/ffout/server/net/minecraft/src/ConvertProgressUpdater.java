package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ConvertProgressUpdater implements IProgressUpdate {
    private long field_22071_b;
    // $FF: synthetic field
    final MinecraftServer field_22072_a;

    public ConvertProgressUpdater(MinecraftServer var1) {
        this.field_22072_a = var1;
        this.field_22071_b = System.currentTimeMillis();
    }

    public void func_438_a(String var1) {
    }

    public void func_437_a(int var1) {
        if (System.currentTimeMillis() - this.field_22071_b >= 1000L) {
            this.field_22071_b = System.currentTimeMillis();
            MinecraftServer.field_6038_a.info("Converting... " + var1 + "%");
        }

    }

    public void func_439_b(String var1) {
    }
}
