package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyManager {
    public static Logger field_995_a = Logger.getLogger("Minecraft");
    private Properties field_994_b = new Properties();
    private File field_996_c;

    public PropertyManager(File var1) {
        this.field_996_c = var1;
        if (var1.exists()) {
            try {
                this.field_994_b.load(new FileInputStream(var1));
            } catch (Exception var3) {
                field_995_a.log(Level.WARNING, "Failed to load " + var1, var3);
                this.func_723_a();
            }
        } else {
            field_995_a.log(Level.WARNING, var1 + " does not exist");
            this.func_723_a();
        }

    }

    public void func_723_a() {
        field_995_a.log(Level.INFO, "Generating new properties file");
        this.func_721_b();
    }

    public void func_721_b() {
        try {
            this.field_994_b.store(new FileOutputStream(this.field_996_c), "Minecraft server properties");
        } catch (Exception var2) {
            field_995_a.log(Level.WARNING, "Failed to save " + this.field_996_c, var2);
            this.func_723_a();
        }

    }

    public String func_720_a(String var1, String var2) {
        if (!this.field_994_b.containsKey(var1)) {
            this.field_994_b.setProperty(var1, var2);
            this.func_721_b();
        }

        return this.field_994_b.getProperty(var1, var2);
    }

    public int func_722_a(String var1, int var2) {
        try {
            return Integer.parseInt(this.func_720_a(var1, "" + var2));
        } catch (Exception var4) {
            this.field_994_b.setProperty(var1, "" + var2);
            return var2;
        }
    }

    public boolean func_724_a(String var1, boolean var2) {
        try {
            return Boolean.parseBoolean(this.func_720_a(var1, "" + var2));
        } catch (Exception var4) {
            this.field_994_b.setProperty(var1, "" + var2);
            return var2;
        }
    }

    public void func_22118_b(String var1, boolean var2) {
        this.field_994_b.setProperty(var1, "" + var2);
        this.func_721_b();
    }
}
