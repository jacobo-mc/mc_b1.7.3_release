package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapStorage {
    private ISaveHandler field_28191_a;
    private Map field_28190_b = new HashMap();
    private List field_28193_c = new ArrayList();
    private Map field_28192_d = new HashMap();

    public MapStorage(ISaveHandler var1) {
        this.field_28191_a = var1;
        this.func_28187_b();
    }

    public MapDataBase func_28185_a(Class var1, String var2) {
        MapDataBase var3 = (MapDataBase)this.field_28190_b.get(var2);
        if (var3 != null) {
            return var3;
        } else {
            if (this.field_28191_a != null) {
                try {
                    File var4 = this.field_28191_a.func_28113_a(var2);
                    if (var4 != null && var4.exists()) {
                        try {
                            var3 = (MapDataBase)var1.getConstructor(String.class).newInstance(var2);
                        } catch (Exception var7) {
                            throw new RuntimeException("Failed to instantiate " + var1.toString(), var7);
                        }

                        FileInputStream var5 = new FileInputStream(var4);
                        NBTTagCompound var6 = CompressedStreamTools.func_1138_a(var5);
                        var5.close();
                        var3.func_28163_a(var6.func_743_k("data"));
                    }
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }

            if (var3 != null) {
                this.field_28190_b.put(var2, var3);
                this.field_28193_c.add(var3);
            }

            return var3;
        }
    }

    public void func_28184_a(String var1, MapDataBase var2) {
        if (var2 == null) {
            throw new RuntimeException("Can't set null data");
        } else {
            if (this.field_28190_b.containsKey(var1)) {
                this.field_28193_c.remove(this.field_28190_b.remove(var1));
            }

            this.field_28190_b.put(var1, var2);
            this.field_28193_c.add(var2);
        }
    }

    public void func_28188_a() {
        for(int var1 = 0; var1 < this.field_28193_c.size(); ++var1) {
            MapDataBase var2 = (MapDataBase)this.field_28193_c.get(var1);
            if (var2.func_28166_b()) {
                this.func_28189_a(var2);
                var2.func_28165_a(false);
            }
        }

    }

    private void func_28189_a(MapDataBase var1) {
        if (this.field_28191_a != null) {
            try {
                File var2 = this.field_28191_a.func_28113_a(var1.field_28168_a);
                if (var2 != null) {
                    NBTTagCompound var3 = new NBTTagCompound();
                    var1.func_28162_b(var3);
                    NBTTagCompound var4 = new NBTTagCompound();
                    var4.func_763_a("data", var3);
                    FileOutputStream var5 = new FileOutputStream(var2);
                    CompressedStreamTools.func_1143_a(var4, var5);
                    var5.close();
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

        }
    }

    private void func_28187_b() {
        try {
            this.field_28192_d.clear();
            if (this.field_28191_a == null) {
                return;
            }

            File var1 = this.field_28191_a.func_28113_a("idcounts");
            if (var1 != null && var1.exists()) {
                DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
                NBTTagCompound var3 = CompressedStreamTools.func_1141_a(var2);
                var2.close();
                Iterator var4 = var3.func_28110_c().iterator();

                while(var4.hasNext()) {
                    NBTBase var5 = (NBTBase)var4.next();
                    if (var5 instanceof NBTTagShort) {
                        NBTTagShort var6 = (NBTTagShort)var5;
                        String var7 = var6.func_737_b();
                        short var8 = var6.field_1088_a;
                        this.field_28192_d.put(var7, var8);
                    }
                }
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public int func_28186_a(String var1) {
        Short var2 = (Short)this.field_28192_d.get(var1);
        if (var2 == null) {
            var2 = Short.valueOf((short)0);
        } else {
            var2 = (short)(var2 + 1);
        }

        this.field_28192_d.put(var1, var2);
        if (this.field_28191_a == null) {
            return var2;
        } else {
            try {
                File var3 = this.field_28191_a.func_28113_a("idcounts");
                if (var3 != null) {
                    NBTTagCompound var4 = new NBTTagCompound();
                    Iterator var5 = this.field_28192_d.keySet().iterator();

                    while(var5.hasNext()) {
                        String var6 = (String)var5.next();
                        short var7 = (Short)this.field_28192_d.get(var6);
                        var4.func_749_a(var6, var7);
                    }

                    DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
                    CompressedStreamTools.func_1139_a(var4, var9);
                    var9.close();
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return var2;
        }
    }
}
