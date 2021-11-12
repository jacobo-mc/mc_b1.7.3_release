package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.client.Minecraft;

public final class GameWindowListener extends WindowAdapter {
    // $FF: synthetic field
    final Minecraft mc;
    // $FF: synthetic field
    final Thread mcThread;

    public GameWindowListener(Minecraft var1, Thread var2) {
        this.mc = var1;
        this.mcThread = var2;
    }

    public void windowClosing(WindowEvent var1) {
        this.mc.shutdown();

        try {
            this.mcThread.join();
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        System.exit(0);
    }
}
