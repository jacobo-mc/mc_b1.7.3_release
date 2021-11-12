package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class GLAllocation {
    private static List displayLists = new ArrayList();
    private static List textureNames = new ArrayList();

    public static synchronized int generateDisplayLists(int var0) {
        int var1 = GL11.glGenLists(var0);
        displayLists.add(var1);
        displayLists.add(var0);
        return var1;
    }

    public static synchronized void generateTextureNames(IntBuffer var0) {
        GL11.glGenTextures(var0);

        for(int var1 = var0.position(); var1 < var0.limit(); ++var1) {
            textureNames.add(var0.get(var1));
        }

    }

    public static synchronized void deleteDisplayLists(int var0) {
        int var1 = displayLists.indexOf(var0);
        GL11.glDeleteLists((Integer)displayLists.get(var1), (Integer)displayLists.get(var1 + 1));
        displayLists.remove(var1);
        displayLists.remove(var1);
    }

    public static synchronized void deleteTexturesAndDisplayLists() {
        for(int var0 = 0; var0 < displayLists.size(); var0 += 2) {
            GL11.glDeleteLists((Integer)displayLists.get(var0), (Integer)displayLists.get(var0 + 1));
        }

        IntBuffer var2 = createDirectIntBuffer(textureNames.size());
        var2.flip();
        GL11.glDeleteTextures(var2);

        for(int var1 = 0; var1 < textureNames.size(); ++var1) {
            var2.put((Integer)textureNames.get(var1));
        }

        var2.flip();
        GL11.glDeleteTextures(var2);
        displayLists.clear();
        textureNames.clear();
    }

    public static synchronized ByteBuffer createDirectByteBuffer(int var0) {
        ByteBuffer var1 = ByteBuffer.allocateDirect(var0).order(ByteOrder.nativeOrder());
        return var1;
    }

    public static IntBuffer createDirectIntBuffer(int var0) {
        return createDirectByteBuffer(var0 << 2).asIntBuffer();
    }

    public static FloatBuffer createDirectFloatBuffer(int var0) {
        return createDirectByteBuffer(var0 << 2).asFloatBuffer();
    }
}
