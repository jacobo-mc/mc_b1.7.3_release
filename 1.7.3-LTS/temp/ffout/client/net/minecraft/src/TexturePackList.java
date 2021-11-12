package net.minecraft.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;

public class TexturePackList {
    private List field_6533_b = new ArrayList();
    private TexturePackBase field_6539_c = new TexturePackDefault();
    public TexturePackBase field_6534_a;
    private Map field_6538_d = new HashMap();
    private Minecraft field_6537_e;
    private File field_6536_f;
    private String field_6535_g;

    public TexturePackList(Minecraft var1, File var2) {
        this.field_6537_e = var1;
        this.field_6536_f = new File(var2, "texturepacks");
        if (!this.field_6536_f.exists()) {
            this.field_6536_f.mkdirs();
        }

        this.field_6535_g = var1.field_6304_y.field_6524_j;
        this.func_6532_a();
        this.field_6534_a.func_6482_a();
    }

    public boolean func_6531_a(TexturePackBase var1) {
        if (var1 == this.field_6534_a) {
            return false;
        } else {
            this.field_6534_a.func_6480_b();
            this.field_6535_g = var1.field_6487_a;
            this.field_6534_a = var1;
            this.field_6537_e.field_6304_y.field_6524_j = this.field_6535_g;
            this.field_6537_e.field_6304_y.func_1041_b();
            this.field_6534_a.func_6482_a();
            return true;
        }
    }

    public void func_6532_a() {
        ArrayList var1 = new ArrayList();
        this.field_6534_a = null;
        var1.add(this.field_6539_c);
        if (this.field_6536_f.exists() && this.field_6536_f.isDirectory()) {
            File[] var2 = this.field_6536_f.listFiles();
            File[] var3 = var2;
            int var4 = var2.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                File var6 = var3[var5];
                if (var6.isFile() && var6.getName().toLowerCase().endsWith(".zip")) {
                    String var7 = var6.getName() + ":" + var6.length() + ":" + var6.lastModified();

                    try {
                        if (!this.field_6538_d.containsKey(var7)) {
                            TexturePackCustom var8 = new TexturePackCustom(var6);
                            var8.field_6488_d = var7;
                            this.field_6538_d.put(var7, var8);
                            var8.func_6485_a(this.field_6537_e);
                        }

                        TexturePackBase var12 = (TexturePackBase)this.field_6538_d.get(var7);
                        if (var12.field_6487_a.equals(this.field_6535_g)) {
                            this.field_6534_a = var12;
                        }

                        var1.add(var12);
                    } catch (IOException var9) {
                        var9.printStackTrace();
                    }
                }
            }
        }

        if (this.field_6534_a == null) {
            this.field_6534_a = this.field_6539_c;
        }

        this.field_6533_b.removeAll(var1);
        Iterator var10 = this.field_6533_b.iterator();

        while(var10.hasNext()) {
            TexturePackBase var11 = (TexturePackBase)var10.next();
            var11.func_6484_b(this.field_6537_e);
            this.field_6538_d.remove(var11.field_6488_d);
        }

        this.field_6533_b = var1;
    }

    public List func_6530_b() {
        return new ArrayList(this.field_6533_b);
    }
}
