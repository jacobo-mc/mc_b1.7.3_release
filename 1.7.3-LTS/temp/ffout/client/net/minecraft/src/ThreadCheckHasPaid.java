package net.minecraft.src;

import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.Minecraft;

public class ThreadCheckHasPaid extends Thread {
    // $FF: synthetic field
    final Minecraft field_28146_a;

    public ThreadCheckHasPaid(Minecraft var1) {
        this.field_28146_a = var1;
    }

    public void run() {
        try {
            HttpURLConnection var1 = (HttpURLConnection)(new URL("https://login.minecraft.net/session?name=" + this.field_28146_a.field_6320_i.field_1666_b + "&session=" + this.field_28146_a.field_6320_i.field_6543_c)).openConnection();
            var1.connect();
            if (var1.getResponseCode() == 400) {
                Minecraft.field_28005_H = System.currentTimeMillis();
            }

            var1.disconnect();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
