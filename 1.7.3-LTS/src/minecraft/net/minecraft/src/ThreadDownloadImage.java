package net.minecraft.src;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class ThreadDownloadImage extends Thread {
    final String location;
    final ImageBuffer buffer;
    final ThreadDownloadImageData imageData;

    ThreadDownloadImage(ThreadDownloadImageData data, String location, ImageBuffer buffer) {
        this.imageData = data;
        this.location = location;
        this.buffer = buffer;
    }

    public void run() {
        HttpURLConnection connection = null;
        try {
            BufferedImage image;
            if (SkinService.isProfileUrl(this.location)) {
                image = SkinService.download(this.location);
            } else {
                connection = (HttpURLConnection)new URL(this.location).openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() != 200) return;
                try (InputStream stream = connection.getInputStream()) { image = ImageIO.read(stream); }
            }
            if (image != null) this.imageData.image = this.buffer == null ? image : this.buffer.parseUserSkin(image);
        } catch (Exception failure) {
            // Default Steve remains available on timeouts, missing profiles, or malformed images.
            System.err.println("Could not download player texture: " + failure.getClass().getSimpleName());
        } finally {
            if (connection != null) connection.disconnect();
        }
    }
}
