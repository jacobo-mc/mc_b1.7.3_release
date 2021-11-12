package net.minecraft.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GuiStatsComponent extends JComponent {
    private int[] field_767_a = new int[256];
    private int field_766_b = 0;
    private String[] field_768_c = new String[10];

    public GuiStatsComponent() {
        this.setPreferredSize(new Dimension(256, 196));
        this.setMinimumSize(new Dimension(256, 196));
        this.setMaximumSize(new Dimension(256, 196));
        (new Timer(500, new GuiStatsListener(this))).start();
        this.setBackground(Color.BLACK);
    }

    private void func_436_a() {
        long var1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.field_768_c[0] = "Memory use: " + var1 / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.field_768_c[1] = "Threads: " + NetworkManager.field_1052_b + " + " + NetworkManager.field_1051_c;
        this.field_767_a[this.field_766_b++ & 255] = (int)(var1 * 100L / Runtime.getRuntime().maxMemory());
        this.repaint();
    }

    public void paint(Graphics var1) {
        var1.setColor(new Color(16777215));
        var1.fillRect(0, 0, 256, 192);

        int var2;
        for(var2 = 0; var2 < 256; ++var2) {
            int var3 = this.field_767_a[var2 + this.field_766_b & 255];
            var1.setColor(new Color(var3 + 28 << 16));
            var1.fillRect(var2, 100 - var3, 1, var3);
        }

        var1.setColor(Color.BLACK);

        for(var2 = 0; var2 < this.field_768_c.length; ++var2) {
            String var4 = this.field_768_c[var2];
            if (var4 != null) {
                var1.drawString(var4, 32, 116 + var2 * 16);
            }
        }

    }

    // $FF: synthetic method
    static void func_435_a(GuiStatsComponent var0) {
        var0.func_436_a();
    }
}
