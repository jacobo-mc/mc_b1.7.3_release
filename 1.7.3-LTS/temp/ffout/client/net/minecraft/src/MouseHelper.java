package net.minecraft.src;

import java.awt.Component;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public class MouseHelper {
    private Component field_1117_c;
    private Cursor field_1116_d;
    public int field_1114_a;
    public int field_1113_b;
    private int field_1115_e = 10;

    public MouseHelper(Component var1) {
        this.field_1117_c = var1;
        IntBuffer var2 = GLAllocation.func_1125_c(1);
        var2.put(0);
        var2.flip();
        IntBuffer var3 = GLAllocation.func_1125_c(1024);

        try {
            this.field_1116_d = new Cursor(32, 32, 16, 16, 1, var3, var2);
        } catch (LWJGLException var5) {
            var5.printStackTrace();
        }

    }

    public void func_774_a() {
        Mouse.setGrabbed(true);
        this.field_1114_a = 0;
        this.field_1113_b = 0;
    }

    public void func_773_b() {
        Mouse.setCursorPosition(this.field_1117_c.getWidth() / 2, this.field_1117_c.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void func_772_c() {
        this.field_1114_a = Mouse.getDX();
        this.field_1113_b = Mouse.getDY();
    }
}
