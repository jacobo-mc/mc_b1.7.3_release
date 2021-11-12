package net.minecraft.src;

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class CanvasMinecraftApplet extends Canvas {
    // $FF: synthetic field
    final MinecraftApplet field_1696_a;

    public CanvasMinecraftApplet(MinecraftApplet var1) {
        this.field_1696_a = var1;
    }

    public synchronized void addNotify() {
        super.addNotify();
        this.field_1696_a.func_6233_a();
    }

    public synchronized void removeNotify() {
        this.field_1696_a.func_6232_b();
        super.removeNotify();
    }
}
