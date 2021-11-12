package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class GLAllocation {
    private static List field_1671_a = new ArrayList();
    private static List field_1670_b = new ArrayList();

    public static synchronized int func_1124_a(int var0) {
        int var1 = GL11.glGenLists(var0);
        field_1671_a.add(var1);
        field_1671_a.add(var0);
        return var1;
    }

    public static synchronized void func_1128_a(IntBuffer var0) {
        GL11.glGenTextures(var0);

        for(int var1 = var0.position(); var1 < var0.limit(); ++var1) {
            field_1670_b.add(var0.get(var1));
        }

    }

    public static synchronized void func_28194_b(int var0) {
        int var1 = field_1671_a.indexOf(var0);
        GL11.glDeleteLists((Integer)field_1671_a.get(var1), (Integer)field_1671_a.get(var1 + 1));
        field_1671_a.remove(var1);
        field_1671_a.remove(var1);
    }

    public static synchronized void func_1126_a() {
        for(int var0 = 0; var0 < field_1671_a.size(); var0 += 2) {
            GL11.glDeleteLists((Integer)field_1671_a.get(var0), (Integer)field_1671_a.get(var0 + 1));
        }

        IntBuffer var2 = func_1125_c(field_1670_b.size());
        var2.flip();
        GL11.glDeleteTextures(var2);

        for(int var1 = 0; var1 < field_1670_b.size(); ++var1) {
            var2.put((Integer)field_1670_b.get(var1));
        }

        var2.flip();
        GL11.glDeleteTextures(var2);
        field_1671_a.clear();
        field_1670_b.clear();
    }

    public static synchronized ByteBuffer func_1127_b(int var0) {
        ByteBuffer var1 = ByteBuffer.allocateDirect(var0).order(ByteOrder.nativeOrder());
        return var1;
    }

    public static IntBuffer func_1125_c(int var0) {
        return func_1127_b(var0 << 2).asIntBuffer();
    }

    public static FloatBuffer func_1123_d(int var0) {
        return func_1127_b(var0 << 2).asFloatBuffer();
    }
}
