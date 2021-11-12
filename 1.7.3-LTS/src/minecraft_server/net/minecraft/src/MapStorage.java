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
    private ISaveHandler field_28180_a;
    private Map field_28179_b = new HashMap();
    private List field_28182_c = new ArrayList();
    private Map field_28181_d = new HashMap();

    public MapStorage(ISaveHandler var1) {
        this.field_28180_a = var1;
        this.func_28174_b();
    }

    public MapDataBase func_28178_a(Class var1, String var2) {
        MapDataBase var3 = (MapDataBase)this.field_28179_b.get(var2);
        if (var3 != null) {
            return var3;
        } else {
            if (this.field_28180_a != null) {
                try {
                    File var4 = this.field_28180_a.func_28111_b(var2);
                    if (var4 != null && var4.exists()) {
                        try {
                            var3 = (MapDataBase)var1.getConstructor(String.class).newInstance(var2);
                        } catch (Exception var7) {
                            throw new RuntimeException("Failed to instantiate " + var1.toString(), var7);
                        }

                        FileInputStream var5 = new FileInputStream(var4);
                        NBTTagCompound var6 = CompressedStreamTools.func_770_a(var5);
                        var5.close();
                        var3.func_28148_a(var6.getCompoundTag("data"));
                    }
                } catch (Exception var8) {
                    var8.printStackTrace();
                }
            }

            if (var3 != null) {
                this.field_28179_b.put(var2, var3);
                this.field_28182_c.add(var3);
            }

            return var3;
        }
    }

    public void func_28177_a(String var1, MapDataBase var2) {
        if (var2 == null) {
            throw new RuntimeException("Can't set null data");
        } else {
            if (this.field_28179_b.containsKey(var1)) {
                this.field_28182_c.remove(this.field_28179_b.remove(var1));
            }

            this.field_28179_b.put(var1, var2);
            this.field_28182_c.add(var2);
        }
    }

    public void func_28176_a() {
        for(int var1 = 0; var1 < this.field_28182_c.size(); ++var1) {
            MapDataBase var2 = (MapDataBase)this.field_28182_c.get(var1);
            if (var2.func_28150_b()) {
                this.func_28175_a(var2);
                var2.func_28149_a(false);
            }
        }

    }

    private void func_28175_a(MapDataBase var1) {
        if (this.field_28180_a != null) {
            try {
                File var2 = this.field_28180_a.func_28111_b(var1.field_28152_a);
                if (var2 != null) {
                    NBTTagCompound var3 = new NBTTagCompound();
                    var1.func_28147_b(var3);
                    NBTTagCompound var4 = new NBTTagCompound();
                    var4.setCompoundTag("data", var3);
                    FileOutputStream var5 = new FileOutputStream(var2);
                    CompressedStreamTools.writeGzippedCompoundToOutputStream(var4, var5);
                    var5.close();
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

        }
    }

    private void func_28174_b() {
        try {
            this.field_28181_d.clear();
            if (this.field_28180_a == null) {
                return;
            }

            File var1 = this.field_28180_a.func_28111_b("idcounts");
            if (var1 != null && var1.exists()) {
                DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
                NBTTagCompound var3 = CompressedStreamTools.func_774_a(var2);
                var2.close();
                Iterator var4 = var3.func_28107_c().iterator();

                while(var4.hasNext()) {
                    NBTBase var5 = (NBTBase)var4.next();
                    if (var5 instanceof NBTTagShort) {
                        NBTTagShort var6 = (NBTTagShort)var5;
                        String var7 = var6.getKey();
                        short var8 = var6.shortValue;
                        this.field_28181_d.put(var7, var8);
                    }
                }
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }

    public int func_28173_a(String var1) {
        Short var2 = (Short)this.field_28181_d.get(var1);
        if (var2 == null) {
            var2 = Short.valueOf((short)0);
        } else {
            var2 = (short)(var2 + 1);
        }

        this.field_28181_d.put(var1, var2);
        if (this.field_28180_a == null) {
            return var2;
        } else {
            try {
                File var3 = this.field_28180_a.func_28111_b("idcounts");
                if (var3 != null) {
                    NBTTagCompound var4 = new NBTTagCompound();
                    Iterator var5 = this.field_28181_d.keySet().iterator();

                    while(var5.hasNext()) {
                        String var6 = (String)var5.next();
                        short var7 = (Short)this.field_28181_d.get(var6);
                        var4.setShort(var6, var7);
                    }

                    DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
                    CompressedStreamTools.func_771_a(var4, var9);
                    var9.close();
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return var2;
        }
    }
}
