package net.minecraft.src;

import java.awt.EventQueue;
import java.awt.Frame;
import java.lang.reflect.Method;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/** Exercises the Mac window path with a real launcher-style AWT applet host. */
public final class QolNativeWindowTests {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static final class LauncherApplet extends MinecraftApplet {
        int starts, stops;
        public void startMainThread() { starts++; }
        public void shutdown() { stops++; }
        public String getParameter(String name) { return null; }
        public boolean isActive() { return false; }
    }

    private static final class TestClient extends Minecraft {
        TestClient(CanvasMinecraftApplet canvas, LauncherApplet applet) {
            super(applet, canvas, applet, 854, 480, false);
        }
        public void openDisplay() throws Exception { this.createDisplay(); }
        public void displayUnexpectedThrowable(UnexpectedThrowable failure) { throw new AssertionError("Window startup failed"); }
    }

    public static void main(String[] args) throws Exception {
        final LauncherApplet applet = new LauncherApplet();
        final CanvasMinecraftApplet canvas = new CanvasMinecraftApplet(applet);
        final Frame host = new Frame("Test launcher host");
        final TestClient mc = new TestClient(canvas, applet);
        try {
            EventQueue.invokeAndWait(() -> {
                host.add(applet); applet.add(canvas);
                host.setSize(854, 480); host.setVisible(true);
            });
            mc.openDisplay();
            EventQueue.invokeAndWait(() -> {});
            check(Display.isCreated() && Display.getParent() == null, "OpenGL drawable detached from AWT");
            check(mc.mcCanvas == null && !mc.hideQuitButton, "Native focus/close handling and Quit button enabled");
            check(!host.isVisible() && host.isDisplayable(), "Launcher host hidden, not disposed");
            check(applet.starts == 1 && applet.stops == 0, "Hiding host does not stop applet game thread");
            check(Display.isResizable(), "Native game window resizable");
            if (!Mouse.isCreated()) Mouse.create();
            MouseHelper mouse = new MouseHelper(null);
            mouse.grabMouseCursor();
            mouse.ungrabMouseCursor();
            check(!Mouse.isGrabbed(), "Pause/menu releases mouse without AWT Canvas");
            Method updateSize = Minecraft.class.getDeclaredMethod("updateDisplaySize");
            updateSize.setAccessible(true);
            Display.setDisplayMode(new DisplayMode(640, 360)); Display.update();
            updateSize.invoke(mc);
            check(mc.displayWidth == 640 && mc.displayHeight == 360, "Native resize updates GUI dimensions");
            mc.toggleFullscreen();
            check(Display.isFullscreen(), "Native fullscreen enabled");
            mc.toggleFullscreen();
            check(!Display.isFullscreen() && Display.getWidth() == 640 && Display.getHeight() == 360, "Fullscreen exit restores resized window");
            Display.setDisplayMode(new DisplayMode(640, 720)); Display.update();
            updateSize.invoke(mc);
            check(mc.displayWidth == 640 && mc.displayHeight == 720, "Growing window height updates GUI dimensions");
            mc.toggleFullscreen();
            check(Display.isFullscreen() && mc.displayWidth == Display.getWidth() && mc.displayHeight == Display.getHeight(), "Fullscreen dimensions match drawable");
            mc.toggleFullscreen();
            check(!Display.isFullscreen() && Display.getWidth() == 640 && Display.getHeight() == 720, "Fullscreen restores enlarged window dimensions");
            ClientWindow.setHostVisible(canvas, true);
            EventQueue.invokeAndWait(() -> {});
            check(host.isVisible(), "Crash-report host can be restored");
            System.out.println("PASS: native launcher window, applet lifecycle, mouse release, resize, fullscreen round trip");
        } finally {
            mc.running = false;
            Display.destroy();
            EventQueue.invokeAndWait(() -> host.dispose());
        }
    }
}
