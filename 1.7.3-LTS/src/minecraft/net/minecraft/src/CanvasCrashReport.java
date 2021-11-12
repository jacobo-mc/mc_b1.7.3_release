package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Dimension;

class CanvasCrashReport extends Canvas {
    public CanvasCrashReport(int var1) {
        this.setPreferredSize(new Dimension(var1, var1));
        this.setMinimumSize(new Dimension(var1, var1));
    }
}
