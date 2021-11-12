package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData extends MapDataBase {
    public int field_28164_b;
    public int field_28163_c;
    public byte field_28162_d;
    public byte field_28161_e;
    public byte[] field_28160_f = new byte[16384];
    public int field_28159_g;
    public List field_28158_h = new ArrayList();
    private Map field_28156_j = new HashMap();
    public List field_28157_i = new ArrayList();

    public MapData(String var1) {
        super(var1);
    }

    public void func_28148_a(NBTTagCompound var1) {
        this.field_28162_d = var1.getByte("dimension");
        this.field_28164_b = var1.getInteger("xCenter");
        this.field_28163_c = var1.getInteger("zCenter");
        this.field_28161_e = var1.getByte("scale");
        if (this.field_28161_e < 0) {
            this.field_28161_e = 0;
        }

        if (this.field_28161_e > 4) {
            this.field_28161_e = 4;
        }

        short var2 = var1.getShort("width");
        short var3 = var1.getShort("height");
        if (var2 == 128 && var3 == 128) {
            this.field_28160_f = var1.getByteArray("colors");
        } else {
            byte[] var4 = var1.getByteArray("colors");
            this.field_28160_f = new byte[16384];
            int var5 = (128 - var2) / 2;
            int var6 = (128 - var3) / 2;

            for(int var7 = 0; var7 < var3; ++var7) {
                int var8 = var7 + var6;
                if (var8 >= 0 || var8 < 128) {
                    for(int var9 = 0; var9 < var2; ++var9) {
                        int var10 = var9 + var5;
                        if (var10 >= 0 || var10 < 128) {
                            this.field_28160_f[var10 + var8 * 128] = var4[var9 + var7 * var2];
                        }
                    }
                }
            }
        }

    }

    public void func_28147_b(NBTTagCompound var1) {
        var1.setByte("dimension", this.field_28162_d);
        var1.setInteger("xCenter", this.field_28164_b);
        var1.setInteger("zCenter", this.field_28163_c);
        var1.setByte("scale", this.field_28161_e);
        var1.setShort("width", (short)128);
        var1.setShort("height", (short)128);
        var1.setByteArray("colors", this.field_28160_f);
    }

    public void func_28155_a(EntityPlayer var1, ItemStack var2) {
        if (!this.field_28156_j.containsKey(var1)) {
            MapInfo var3 = new MapInfo(this, var1);
            this.field_28156_j.put(var1, var3);
            this.field_28158_h.add(var3);
        }

        this.field_28157_i.clear();

        for(int var14 = 0; var14 < this.field_28158_h.size(); ++var14) {
            MapInfo var4 = (MapInfo)this.field_28158_h.get(var14);
            if (!var4.field_28120_a.isDead && var4.field_28120_a.inventory.func_28010_c(var2)) {
                float var5 = (float)(var4.field_28120_a.posX - (double)this.field_28164_b) / (float)(1 << this.field_28161_e);
                float var6 = (float)(var4.field_28120_a.posZ - (double)this.field_28163_c) / (float)(1 << this.field_28161_e);
                byte var7 = 64;
                byte var8 = 64;
                if (var5 >= (float)(-var7) && var6 >= (float)(-var8) && var5 <= (float)var7 && var6 <= (float)var8) {
                    byte var9 = 0;
                    byte var10 = (byte)((int)((double)(var5 * 2.0F) + 0.5D));
                    byte var11 = (byte)((int)((double)(var6 * 2.0F) + 0.5D));
                    byte var12 = (byte)((int)((double)(var1.rotationYaw * 16.0F / 360.0F) + 0.5D));
                    if (this.field_28162_d < 0) {
                        int var13 = this.field_28159_g / 10;
                        var12 = (byte)(var13 * var13 * 34187121 + var13 * 121 >> 15 & 15);
                    }

                    if (var4.field_28120_a.dimension == this.field_28162_d) {
                        this.field_28157_i.add(new MapCoord(this, var9, var10, var11, var12));
                    }
                }
            } else {
                this.field_28156_j.remove(var4.field_28120_a);
                this.field_28158_h.remove(var4);
            }
        }

    }

    public byte[] func_28154_a(ItemStack var1, World var2, EntityPlayer var3) {
        MapInfo var4 = (MapInfo)this.field_28156_j.get(var3);
        if (var4 == null) {
            return null;
        } else {
            byte[] var5 = var4.func_28118_a(var1);
            return var5;
        }
    }

    public void func_28153_a(int var1, int var2, int var3) {
        super.func_28146_a();

        for(int var4 = 0; var4 < this.field_28158_h.size(); ++var4) {
            MapInfo var5 = (MapInfo)this.field_28158_h.get(var4);
            if (var5.field_28119_b[var1] < 0 || var5.field_28119_b[var1] > var2) {
                var5.field_28119_b[var1] = var2;
            }

            if (var5.field_28125_c[var1] < 0 || var5.field_28125_c[var1] < var3) {
                var5.field_28125_c[var1] = var3;
            }
        }

    }
}
