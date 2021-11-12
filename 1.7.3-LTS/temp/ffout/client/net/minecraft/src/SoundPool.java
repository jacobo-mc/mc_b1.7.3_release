package net.minecraft.src;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SoundPool {
    private Random field_1661_c = new Random();
    private Map field_1660_d = new HashMap();
    private List field_1659_e = new ArrayList();
    public int field_1658_a = 0;
    public boolean field_1657_b = true;

    public SoundPoolEntry func_1117_a(String var1, File var2) {
        try {
            String var3 = var1;
            var1 = var1.substring(0, var1.indexOf("."));
            if (this.field_1657_b) {
                while(Character.isDigit(var1.charAt(var1.length() - 1))) {
                    var1 = var1.substring(0, var1.length() - 1);
                }
            }

            var1 = var1.replaceAll("/", ".");
            if (!this.field_1660_d.containsKey(var1)) {
                this.field_1660_d.put(var1, new ArrayList());
            }

            SoundPoolEntry var4 = new SoundPoolEntry(var3, var2.toURI().toURL());
            ((List)this.field_1660_d.get(var1)).add(var4);
            this.field_1659_e.add(var4);
            ++this.field_1658_a;
            return var4;
        } catch (MalformedURLException var5) {
            var5.printStackTrace();
            throw new RuntimeException(var5);
        }
    }

    public SoundPoolEntry func_1118_a(String var1) {
        List var2 = (List)this.field_1660_d.get(var1);
        return var2 == null ? null : (SoundPoolEntry)var2.get(this.field_1661_c.nextInt(var2.size()));
    }

    public SoundPoolEntry func_1116_a() {
        return this.field_1659_e.size() == 0 ? null : (SoundPoolEntry)this.field_1659_e.get(this.field_1661_c.nextInt(this.field_1659_e.size()));
    }
}
