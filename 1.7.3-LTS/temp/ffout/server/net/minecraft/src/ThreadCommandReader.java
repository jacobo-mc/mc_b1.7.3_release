package net.minecraft.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.minecraft.server.MinecraftServer;

public class ThreadCommandReader extends Thread {
    // $FF: synthetic field
    final MinecraftServer field_1032_a;

    public ThreadCommandReader(MinecraftServer var1) {
        this.field_1032_a = var1;
    }

    public void run() {
        BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));
        String var2 = null;

        try {
            while(!this.field_1032_a.field_6032_g && MinecraftServer.func_6015_a(this.field_1032_a) && (var2 = var1.readLine()) != null) {
                this.field_1032_a.func_6010_a(var2, this.field_1032_a);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}
