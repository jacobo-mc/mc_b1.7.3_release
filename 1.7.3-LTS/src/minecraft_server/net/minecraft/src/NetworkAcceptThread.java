package net.minecraft.src;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import net.minecraft.server.MinecraftServer;

class NetworkAcceptThread extends Thread {
    // $FF: synthetic field
    final MinecraftServer mcServer;
    // $FF: synthetic field
    final NetworkListenThread field_985_b;

    NetworkAcceptThread(NetworkListenThread var1, String var2, MinecraftServer var3) {
        super(var2);
        this.field_985_b = var1;
        this.mcServer = var3;
    }

    public void run() {
        HashMap var1 = new HashMap();

        while(this.field_985_b.field_973_b) {
            try {
                Socket var2 = NetworkListenThread.func_713_a(this.field_985_b).accept();
                if (var2 != null) {
                    InetAddress var3 = var2.getInetAddress();
                    if (var1.containsKey(var3) && !"127.0.0.1".equals(var3.getHostAddress()) && System.currentTimeMillis() - (Long)var1.get(var3) < 5000L) {
                        var1.put(var3, System.currentTimeMillis());
                        var2.close();
                    } else {
                        var1.put(var3, System.currentTimeMillis());
                        NetLoginHandler var4 = new NetLoginHandler(this.mcServer, var2, "Connection #" + NetworkListenThread.func_712_b(this.field_985_b));
                        NetworkListenThread.func_716_a(this.field_985_b, var4);
                    }
                }
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

    }
}
