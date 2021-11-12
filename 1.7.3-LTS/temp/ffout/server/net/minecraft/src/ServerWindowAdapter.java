package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.server.MinecraftServer;

final class ServerWindowAdapter extends WindowAdapter {
    // $FF: synthetic field
    final MinecraftServer field_997_a;

    ServerWindowAdapter(MinecraftServer var1) {
        this.field_997_a = var1;
    }

    public void windowClosing(WindowEvent var1) {
        this.field_997_a.func_6016_a();

        while(!this.field_997_a.field_6032_g) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }
        }

        System.exit(0);
    }
}
