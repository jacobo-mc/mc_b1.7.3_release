package net.minecraft.src;

import java.nio.ByteOrder;
import java.nio.FloatBuffer;

final class VertexColors {
    private VertexColors() {}

    static void toFloats(int[] vertices, int count, FloatBuffer output, ByteOrder order) {
        output.clear();
        for (int vertex = 0; vertex < count; vertex++) {
            int color = vertices[vertex * 8 + 5];
            for (int channel = 0; channel < 4; channel++) {
                int shift = order == ByteOrder.LITTLE_ENDIAN ? channel * 8 : (3 - channel) * 8;
                output.put(((color >>> shift) & 255) / 255.0F);
            }
        }
        output.flip();
    }
}
