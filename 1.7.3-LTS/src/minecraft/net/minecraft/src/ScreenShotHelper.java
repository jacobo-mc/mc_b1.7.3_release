package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static ByteBuffer buffer;
    private static byte[] pixelData;
    private static int[] imageData;

    public static String saveScreenshot(File var0, int var1, int var2) {
        try {
            File var3 = new File(var0, "screenshots");
            var3.mkdir();
            if (buffer == null || buffer.capacity() < var1 * var2) {
                buffer = BufferUtils.createByteBuffer(var1 * var2 * 3);
            }

            if (imageData == null || imageData.length < var1 * var2 * 3) {
                pixelData = new byte[var1 * var2 * 3];
                imageData = new int[var1 * var2];
            }

            GL11.glPixelStorei(3333 /*GL_PACK_ALIGNMENT*/, 1);
            GL11.glPixelStorei(3317 /*GL_UNPACK_ALIGNMENT*/, 1);
            buffer.clear();
            GL11.glReadPixels(0, 0, var1, var2, 6407 /*GL_RGB*/, 5121 /*GL_UNSIGNED_BYTE*/, buffer);
            buffer.clear();
            String var4 = "" + dateFormat.format(new Date());

            File var5;
            for(int var6 = 1; (var5 = new File(var3, var4 + (var6 == 1 ? "" : "_" + var6) + ".png")).exists(); ++var6) {
            }

            buffer.get(pixelData);

            for(int var7 = 0; var7 < var1; ++var7) {
                for(int var8 = 0; var8 < var2; ++var8) {
                    int var9 = var7 + (var2 - var8 - 1) * var1;
                    int var10 = pixelData[var9 * 3 + 0] & 255;
                    int var11 = pixelData[var9 * 3 + 1] & 255;
                    int var12 = pixelData[var9 * 3 + 2] & 255;
                    int var13 = -16777216 | var10 << 16 | var11 << 8 | var12;
                    imageData[var7 + var8 * var1] = var13;
                }
            }

            BufferedImage var15 = new BufferedImage(var1, var2, 1);
            var15.setRGB(0, 0, var1, var2, imageData, 0, var1);
            ImageIO.write(var15, "png", var5);
            return "Saved screenshot as " + var5.getName();
        } catch (Exception var14) {
            var14.printStackTrace();
            return "Failed to save: " + var14;
        }
    }
}
