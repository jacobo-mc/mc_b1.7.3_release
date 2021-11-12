package net.minecraft.src;

import java.awt.image.BufferedImage;

public class ThreadDownloadImageData {
    public BufferedImage field_1706_a;
    public int field_1705_b = 1;
    public int field_1708_c = -1;
    public boolean field_1707_d = false;

    public ThreadDownloadImageData(String var1, ImageBuffer var2) {
        (new ThreadDownloadImage(this, var1, var2)).start();
    }
}
