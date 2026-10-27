package net.minecraft.src;

import java.awt.image.BufferedImage;

public class ThreadDownloadImageData {
    public volatile BufferedImage image;
    public int referenceCount = 1;
    public int textureName = -1;
    public boolean textureSetupComplete = false;

    public ThreadDownloadImageData(String var1, ImageBuffer var2) {
        Thread downloader = new ThreadDownloadImage(this, var1, var2);
        downloader.setName("Skin/texture download");
        downloader.setDaemon(true);
        downloader.start();
    }
}
