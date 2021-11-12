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
    private static DateFormat field_4287_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static ByteBuffer field_4286_b;
    private static byte[] field_4289_c;
    private static int[] field_4288_d;

    public static String func_4148_a(File var0, int var1, int var2) {
        try {
            File var3 = new File(var0, "screenshots");
            var3.mkdir();
            if (field_4286_b == null || field_4286_b.capacity() < var1 * var2) {
                field_4286_b = BufferUtils.createByteBuffer(var1 * var2 * 3);
            }

            if (field_4288_d == null || field_4288_d.length < var1 * var2 * 3) {
                field_4289_c = new byte[var1 * var2 * 3];
                field_4288_d = new int[var1 * var2];
            }

            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            field_4286_b.clear();
            GL11.glReadPixels(0, 0, var1, var2, 6407, 5121, field_4286_b);
            field_4286_b.clear();
            String var4 = "" + field_4287_a.format(new Date());

            File var5;
            for(int var6 = 1; (var5 = new File(var3, var4 + (var6 == 1 ? "" : "_" + var6) + ".png")).exists(); ++var6) {
            }

            field_4286_b.get(field_4289_c);

            for(int var7 = 0; var7 < var1; ++var7) {
                for(int var8 = 0; var8 < var2; ++var8) {
                    int var9 = var7 + (var2 - var8 - 1) * var1;
                    int var10 = field_4289_c[var9 * 3 + 0] & 255;
                    int var11 = field_4289_c[var9 * 3 + 1] & 255;
                    int var12 = field_4289_c[var9 * 3 + 2] & 255;
                    int var13 = -16777216 | var10 << 16 | var11 << 8 | var12;
                    field_4288_d[var7 + var8 * var1] = var13;
                }
            }

            BufferedImage var15 = new BufferedImage(var1, var2, 1);
            var15.setRGB(0, 0, var1, var2, field_4288_d, 0, var1);
            ImageIO.write(var15, "png", var5);
            return "Saved screenshot as " + var5.getName();
        } catch (Exception var14) {
            var14.printStackTrace();
            return "Failed to save: " + var14;
        }
    }
}
