package net.minecraft.src;

import java.io.IOException;
import java.util.Properties;

public class StringTranslate {
    private static StringTranslate field_25082_a = new StringTranslate();
    private Properties field_25081_b = new Properties();

    private StringTranslate() {
        try {
            this.field_25081_b.load(StringTranslate.class.getResourceAsStream("/lang/en_US.lang"));
            this.field_25081_b.load(StringTranslate.class.getResourceAsStream("/lang/stats_US.lang"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static StringTranslate func_25079_a() {
        return field_25082_a;
    }

    public String func_25080_a(String var1) {
        return this.field_25081_b.getProperty(var1, var1);
    }

    public String func_25078_a(String var1, Object... var2) {
        String var3 = this.field_25081_b.getProperty(var1, var1);
        return String.format(var3, var2);
    }
}
