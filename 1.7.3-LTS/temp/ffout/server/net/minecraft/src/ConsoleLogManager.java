package net.minecraft.src;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleLogManager {
    public static Logger field_933_a = Logger.getLogger("Minecraft");

    public static void func_641_a() {
        ConsoleLogFormatter var0 = new ConsoleLogFormatter();
        field_933_a.setUseParentHandlers(false);
        ConsoleHandler var1 = new ConsoleHandler();
        var1.setFormatter(var0);
        field_933_a.addHandler(var1);

        try {
            FileHandler var2 = new FileHandler("server.log", true);
            var2.setFormatter(var0);
            field_933_a.addHandler(var2);
        } catch (Exception var3) {
            field_933_a.log(Level.WARNING, "Failed to log to server.log", var3);
        }

    }
}
