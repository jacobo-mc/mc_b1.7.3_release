package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;

class ThreadConnectToServer extends Thread {
    // $FF: synthetic field
    final Minecraft field_1102_a;
    // $FF: synthetic field
    final String field_1101_b;
    // $FF: synthetic field
    final int field_1104_c;
    // $FF: synthetic field
    final GuiConnecting field_1103_d;

    ThreadConnectToServer(GuiConnecting var1, Minecraft var2, String var3, int var4) {
        this.field_1103_d = var1;
        this.field_1102_a = var2;
        this.field_1101_b = var3;
        this.field_1104_c = var4;
    }

    public void run() {
        try {
            GuiConnecting.func_582_a(this.field_1103_d, new NetClientHandler(this.field_1102_a, this.field_1101_b, this.field_1104_c));
            if (GuiConnecting.func_581_a(this.field_1103_d)) {
                return;
            }

            GuiConnecting.func_583_b(this.field_1103_d).func_847_a(new Packet2Handshake(this.field_1102_a.field_6320_i.field_1666_b));
        } catch (UnknownHostException var2) {
            if (GuiConnecting.func_581_a(this.field_1103_d)) {
                return;
            }

            this.field_1102_a.func_6272_a(new GuiConnectFailed("connect.failed", "disconnect.genericReason", new Object[]{"Unknown host '" + this.field_1101_b + "'"}));
        } catch (ConnectException var3) {
            if (GuiConnecting.func_581_a(this.field_1103_d)) {
                return;
            }

            this.field_1102_a.func_6272_a(new GuiConnectFailed("connect.failed", "disconnect.genericReason", new Object[]{var3.getMessage()}));
        } catch (Exception var4) {
            if (GuiConnecting.func_581_a(this.field_1103_d)) {
                return;
            }

            var4.printStackTrace();
            this.field_1102_a.func_6272_a(new GuiConnectFailed("connect.failed", "disconnect.genericReason", new Object[]{var4.toString()}));
        }

    }
}
