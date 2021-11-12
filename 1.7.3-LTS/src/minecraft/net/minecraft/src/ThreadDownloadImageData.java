package net.minecraft.src;

import java.awt.image.BufferedImage;

public class ThreadDownloadImageData {
    public BufferedImage image;
    public int referenceCount = 1;
    public int textureName = -1;
    public boolean textureSetupComplete = false;

    public ThreadDownloadImageData(String var1, ImageBuffer var2) {
        (new ThreadDownloadImage(this, var1, var2)).start();
    }
}
