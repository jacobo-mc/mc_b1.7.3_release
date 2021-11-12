package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

class ThreadLoginVerifier extends Thread {
    // $FF: synthetic field
    final Packet1Login field_972_a;
    // $FF: synthetic field
    final NetLoginHandler field_971_b;

    ThreadLoginVerifier(NetLoginHandler var1, Packet1Login var2) {
        this.field_971_b = var1;
        this.field_972_a = var2;
    }

    public void run() {
        try {
            String var1 = NetLoginHandler.func_32_a(this.field_971_b);
            URL var2 = new URL("http://www.minecraft.net/game/checkserver.jsp?user=" + URLEncoder.encode(this.field_972_a.field_113_b, "UTF-8") + "&serverId=" + URLEncoder.encode(var1, "UTF-8"));
            BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.openStream()));
            String var4 = var3.readLine();
            var3.close();
            if (var4.equals("YES")) {
                NetLoginHandler.func_31_a(this.field_971_b, this.field_972_a);
            } else {
                this.field_971_b.func_34_b("Failed to verify username!");
            }
        } catch (Exception var5) {
            this.field_971_b.func_34_b("Failed to verify username! [internal error " + var5 + "]");
            var5.printStackTrace();
        }

    }
}
