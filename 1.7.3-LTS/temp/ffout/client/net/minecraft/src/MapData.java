package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData extends MapDataBase {
    public int field_28180_b;
    public int field_28179_c;
    public byte field_28178_d;
    public byte field_28177_e;
    public byte[] field_28176_f = new byte[16384];
    public int field_28175_g;
    public List field_28174_h = new ArrayList();
    private Map field_28172_j = new HashMap();
    public List field_28173_i = new ArrayList();

    public MapData(String var1) {
        super(var1);
    }

    public void func_28163_a(NBTTagCompound var1) {
        this.field_28178_d = var1.func_746_c("dimension");
        this.field_28180_b = var1.func_756_e("xCenter");
        this.field_28179_c = var1.func_756_e("zCenter");
        this.field_28177_e = var1.func_746_c("scale");
        if (this.field_28177_e < 0) {
            this.field_28177_e = 0;
        }

        if (this.field_28177_e > 4) {
            this.field_28177_e = 4;
        }

        short var2 = var1.func_745_d("width");
        short var3 = var1.func_745_d("height");
        if (var2 == 128 && var3 == 128) {
            this.field_28176_f = var1.func_759_j("colors");
        } else {
            byte[] var4 = var1.func_759_j("colors");
            this.field_28176_f = new byte[16384];
            int var5 = (128 - var2) / 2;
            int var6 = (128 - var3) / 2;

            for(int var7 = 0; var7 < var3; ++var7) {
                int var8 = var7 + var6;
                if (var8 >= 0 || var8 < 128) {
                    for(int var9 = 0; var9 < var2; ++var9) {
                        int var10 = var9 + var5;
                        if (var10 >= 0 || var10 < 128) {
                            this.field_28176_f[var10 + var8 * 128] = var4[var9 + var7 * var2];
                        }
                    }
                }
            }
        }

    }

    public void func_28162_b(NBTTagCompound var1) {
        var1.func_761_a("dimension", this.field_28178_d);
        var1.func_758_a("xCenter", this.field_28180_b);
        var1.func_758_a("zCenter", this.field_28179_c);
        var1.func_761_a("scale", this.field_28177_e);
        var1.func_749_a("width", (short)128);
        var1.func_749_a("height", (short)128);
        var1.func_747_a("colors", this.field_28176_f);
    }

    public void func_28169_a(EntityPlayer var1, ItemStack var2) {
        if (!this.field_28172_j.containsKey(var1)) {
            MapInfo var3 = new MapInfo(this, var1);
            this.field_28172_j.put(var1, var3);
            this.field_28174_h.add(var3);
        }

        this.field_28173_i.clear();

        for(int var14 = 0; var14 < this.field_28174_h.size(); ++var14) {
            MapInfo var4 = (MapInfo)this.field_28174_h.get(var14);
            if (!var4.field_28120_a.field_646_aA && var4.field_28120_a.field_778_b.func_28018_c(var2)) {
                float var5 = (float)(var4.field_28120_a.field_611_ak - (double)this.field_28180_b) / (float)(1 << this.field_28177_e);
                float var6 = (float)(var4.field_28120_a.field_609_am - (double)this.field_28179_c) / (float)(1 << this.field_28177_e);
                byte var7 = 64;
                byte var8 = 64;
                if (var5 >= (float)(-var7) && var6 >= (float)(-var8) && var5 <= (float)var7 && var6 <= (float)var8) {
                    byte var9 = 0;
                    byte var10 = (byte)((int)((double)(var5 * 2.0F) + 0.5D));
                    byte var11 = (byte)((int)((double)(var6 * 2.0F) + 0.5D));
                    byte var12 = (byte)((int)((double)(var1.field_605_aq * 16.0F / 360.0F) + 0.5D));
                    if (this.field_28178_d < 0) {
                        int var13 = this.field_28175_g / 10;
                        var12 = (byte)(var13 * var13 * 34187121 + var13 * 121 >> 15 & 15);
                    }

                    if (var4.field_28120_a.field_4129_m == this.field_28178_d) {
                        this.field_28173_i.add(new MapCoord(this, var9, var10, var11, var12));
                    }
                }
            } else {
                this.field_28172_j.remove(var4.field_28120_a);
                this.field_28174_h.remove(var4);
            }
        }

    }

    public void func_28170_a(int var1, int var2, int var3) {
        super.func_28164_a();

        for(int var4 = 0; var4 < this.field_28174_h.size(); ++var4) {
            MapInfo var5 = (MapInfo)this.field_28174_h.get(var4);
            if (var5.field_28119_b[var1] < 0 || var5.field_28119_b[var1] > var2) {
                var5.field_28119_b[var1] = var2;
            }

            if (var5.field_28124_c[var1] < 0 || var5.field_28124_c[var1] < var3) {
                var5.field_28124_c[var1] = var3;
            }
        }

    }

    public void func_28171_a(byte[] var1) {
        int var2;
        if (var1[0] == 0) {
            var2 = var1[1] & 255;
            int var3 = var1[2] & 255;

            for(int var4 = 0; var4 < var1.length - 3; ++var4) {
                this.field_28176_f[(var4 + var3) * 128 + var2] = var1[var4 + 3];
            }

            this.func_28164_a();
        } else if (var1[0] == 1) {
            this.field_28173_i.clear();

            for(var2 = 0; var2 < (var1.length - 1) / 3; ++var2) {
                byte var7 = (byte)(var1[var2 * 3 + 1] % 16);
                byte var8 = var1[var2 * 3 + 2];
                byte var5 = var1[var2 * 3 + 3];
                byte var6 = (byte)(var1[var2 * 3 + 1] / 16);
                this.field_28173_i.add(new MapCoord(this, var7, var8, var5, var6));
            }
        }

    }
}
