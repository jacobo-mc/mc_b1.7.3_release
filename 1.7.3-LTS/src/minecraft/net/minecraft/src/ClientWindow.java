package net.minecraft.src;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.util.Locale;

/** Keeps the macOS OpenGL drawable out of AWT's colour-converted Canvas. */
public final class ClientWindow {
    private ClientWindow() {}

    public static boolean useNativeWindow() {
        return useNativeWindow(System.getProperty("os.name", ""), System.getProperty("minecraft.nativeWindow"));
    }

    static boolean useNativeWindow(String os, String override) {
        return override == null ? os.toLowerCase(Locale.ROOT).contains("mac") : Boolean.parseBoolean(override);
    }

    public static void setHostVisible(Component component, final boolean visible) {
        while (component != null && !(component instanceof Window)) component = component.getParent();
        if (component == null) return;
        final Window window = (Window)component;
        Runnable change = new Runnable() {
            public void run() { window.setVisible(visible); }
        };
        // Do not dispose the host: removing the applet Canvas shuts down the game.
        if (EventQueue.isDispatchThread()) change.run();
        else EventQueue.invokeLater(change);
    }
}
