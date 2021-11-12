package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AchievementMap {
    public static AchievementMap field_25210_a = new AchievementMap();
    private Map field_25209_b = new HashMap();

    private AchievementMap() {
        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(AchievementMap.class.getResourceAsStream("/achievement/map.txt")));

            String var2;
            while((var2 = var1.readLine()) != null) {
                String[] var3 = var2.split(",");
                int var4 = Integer.parseInt(var3[0]);
                this.field_25209_b.put(var4, var3[1]);
            }

            var1.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public static String func_25208_a(int var0) {
        return (String)field_25210_a.field_25209_b.get(var0);
    }
}
