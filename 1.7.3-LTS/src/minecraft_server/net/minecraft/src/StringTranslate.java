package net.minecraft.src;

import java.io.IOException;
import java.util.Properties;

public class StringTranslate {
    private static StringTranslate instance = new StringTranslate();
    private Properties translateTable = new Properties();

    private StringTranslate() {
        try {
            this.translateTable.load(StringTranslate.class.getResourceAsStream("/lang/en_US.lang"));
            this.translateTable.load(StringTranslate.class.getResourceAsStream("/lang/stats_US.lang"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static StringTranslate getInstance() {
        return instance;
    }

    public String translateKey(String var1) {
        return this.translateTable.getProperty(var1, var1);
    }

    public String translateKeyFormat(String var1, Object... var2) {
        String var3 = this.translateTable.getProperty(var1, var1);
        return String.format(var3, var2);
    }
}
