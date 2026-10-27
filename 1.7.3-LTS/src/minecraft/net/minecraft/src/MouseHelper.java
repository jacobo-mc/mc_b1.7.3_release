package net.minecraft.src;

import java.awt.Component;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class MouseHelper {
    private Component windowComponent;
    private Cursor cursor;
    public int deltaX;
    public int deltaY;
    private int field_1115_e = 10;

    public MouseHelper(Component var1) {
        this.windowComponent = var1;
        IntBuffer var2 = GLAllocation.createDirectIntBuffer(1);
        var2.put(0);
        var2.flip();
        IntBuffer var3 = GLAllocation.createDirectIntBuffer(1024);

        try {
            this.cursor = new Cursor(32, 32, 16, 16, 1, var3, var2);
        } catch (LWJGLException var5) {
            var5.printStackTrace();
        }

    }

    public void grabMouseCursor() {
        Mouse.setGrabbed(true);
        this.deltaX = 0;
        this.deltaY = 0;
    }

    public void ungrabMouseCursor() {
        int width = this.windowComponent == null ? Display.getWidth() : this.windowComponent.getWidth();
        int height = this.windowComponent == null ? Display.getHeight() : this.windowComponent.getHeight();
        Mouse.setCursorPosition(Math.max(1, width) / 2, Math.max(1, height) / 2);
        Mouse.setGrabbed(false);
    }

    public void mouseXYChange() {
        this.deltaX = Mouse.getDX();
        this.deltaY = Mouse.getDY();
    }
}
