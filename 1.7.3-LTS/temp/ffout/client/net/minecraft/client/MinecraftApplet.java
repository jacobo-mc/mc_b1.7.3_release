package net.minecraft.client;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import net.minecraft.src.CanvasMinecraftApplet;
import net.minecraft.src.MinecraftAppletImpl;
import net.minecraft.src.Session;

public class MinecraftApplet extends Applet {
    private Canvas field_6235_a;
    private Minecraft field_6234_b;
    private Thread field_6236_c = null;

    public void init() {
        this.field_6235_a = new CanvasMinecraftApplet(this);
        boolean var1 = false;
        if (this.getParameter("fullscreen") != null) {
            var1 = this.getParameter("fullscreen").equalsIgnoreCase("true");
        }

        this.field_6234_b = new MinecraftAppletImpl(this, this, this.field_6235_a, this, this.getWidth(), this.getHeight(), var1);
        this.field_6234_b.field_6319_j = this.getDocumentBase().getHost();
        if (this.getDocumentBase().getPort() > 0) {
            StringBuilder var10000 = new StringBuilder();
            Minecraft var10002 = this.field_6234_b;
            var10002.field_6319_j = var10000.append(var10002.field_6319_j).append(":").append(this.getDocumentBase().getPort()).toString();
        }

        if (this.getParameter("username") != null && this.getParameter("sessionid") != null) {
            this.field_6234_b.field_6320_i = new Session(this.getParameter("username"), this.getParameter("sessionid"));
            System.out.println("Setting user: " + this.field_6234_b.field_6320_i.field_1666_b + ", " + this.field_6234_b.field_6320_i.field_6543_c);
            if (this.getParameter("mppass") != null) {
                this.field_6234_b.field_6320_i.field_6542_d = this.getParameter("mppass");
            }
        } else {
            this.field_6234_b.field_6320_i = new Session("Player", "");
        }

        if (this.getParameter("server") != null && this.getParameter("port") != null) {
            this.field_6234_b.func_6258_a(this.getParameter("server"), Integer.parseInt(this.getParameter("port")));
        }

        this.field_6234_b.field_6317_l = true;
        this.setLayout(new BorderLayout());
        this.add(this.field_6235_a, "Center");
        this.field_6235_a.setFocusable(true);
        this.validate();
    }

    public void func_6233_a() {
        if (this.field_6236_c == null) {
            this.field_6236_c = new Thread(this.field_6234_b, "Minecraft main thread");
            this.field_6236_c.start();
        }
    }

    public void start() {
        if (this.field_6234_b != null) {
            this.field_6234_b.field_6316_m = false;
        }

    }

    public void stop() {
        if (this.field_6234_b != null) {
            this.field_6234_b.field_6316_m = true;
        }

    }

    public void destroy() {
        this.func_6232_b();
    }

    public void func_6232_b() {
        if (this.field_6236_c != null) {
            this.field_6234_b.func_6244_d();

            try {
                this.field_6236_c.join(10000L);
            } catch (InterruptedException var4) {
                try {
                    this.field_6234_b.func_6266_c();
                } catch (Exception var3) {
                    var3.printStackTrace();
                }
            }

            this.field_6236_c = null;
        }
    }

    public void func_6231_c() {
        this.field_6235_a = null;
        this.field_6234_b = null;
        this.field_6236_c = null;

        try {
            this.removeAll();
            this.validate();
        } catch (Exception var2) {
        }

    }
}
