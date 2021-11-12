package net.minecraft.src;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

class ThreadDownloadImage extends Thread {
    // $FF: synthetic field
    final String field_1216_a;
    // $FF: synthetic field
    final ImageBuffer field_1215_b;
    // $FF: synthetic field
    final ThreadDownloadImageData field_1217_c;

    ThreadDownloadImage(ThreadDownloadImageData var1, String var2, ImageBuffer var3) {
        this.field_1217_c = var1;
        this.field_1216_a = var2;
        this.field_1215_b = var3;
    }

    public void run() {
        HttpURLConnection var1 = null;

        try {
            URL var2 = new URL(this.field_1216_a);
            var1 = (HttpURLConnection)var2.openConnection();
            var1.setDoInput(true);
            var1.setDoOutput(false);
            var1.connect();
            if (var1.getResponseCode() / 100 == 4) {
                return;
            }

            if (this.field_1215_b == null) {
                this.field_1217_c.field_1706_a = ImageIO.read(var1.getInputStream());
            } else {
                this.field_1217_c.field_1706_a = this.field_1215_b.func_883_a(ImageIO.read(var1.getInputStream()));
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        } finally {
            var1.disconnect();
        }

    }
}
