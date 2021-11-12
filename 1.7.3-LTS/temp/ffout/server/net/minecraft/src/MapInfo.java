package net.minecraft.src;

public class MapInfo {
    public final EntityPlayer field_28120_a;
    public int[] field_28119_b;
    public int[] field_28125_c;
    private int field_28123_e;
    private int field_28122_f;
    private byte[] field_28121_g;
    // $FF: synthetic field
    final MapData field_28124_d;

    public MapInfo(MapData var1, EntityPlayer var2) {
        this.field_28124_d = var1;
        this.field_28119_b = new int[128];
        this.field_28125_c = new int[128];
        this.field_28123_e = 0;
        this.field_28122_f = 0;
        this.field_28120_a = var2;

        for(int var3 = 0; var3 < this.field_28119_b.length; ++var3) {
            this.field_28119_b[var3] = 0;
            this.field_28125_c[var3] = 127;
        }

    }

    public byte[] func_28118_a(ItemStack var1) {
        int var3;
        int var10;
        if (--this.field_28122_f < 0) {
            this.field_28122_f = 4;
            byte[] var2 = new byte[this.field_28124_d.field_28157_i.size() * 3 + 1];
            var2[0] = 1;

            for(var3 = 0; var3 < this.field_28124_d.field_28157_i.size(); ++var3) {
                MapCoord var4 = (MapCoord)this.field_28124_d.field_28157_i.get(var3);
                var2[var3 * 3 + 1] = (byte)(var4.field_28202_a + (var4.field_28204_d & 15) * 16);
                var2[var3 * 3 + 2] = var4.field_28201_b;
                var2[var3 * 3 + 3] = var4.field_28205_c;
            }

            boolean var9 = true;
            if (this.field_28121_g != null && this.field_28121_g.length == var2.length) {
                for(var10 = 0; var10 < var2.length; ++var10) {
                    if (var2[var10] != this.field_28121_g[var10]) {
                        var9 = false;
                        break;
                    }
                }
            } else {
                var9 = false;
            }

            if (!var9) {
                this.field_28121_g = var2;
                return var2;
            }
        }

        for(int var8 = 0; var8 < 10; ++var8) {
            var3 = this.field_28123_e * 11 % 128;
            ++this.field_28123_e;
            if (this.field_28119_b[var3] >= 0) {
                var10 = this.field_28125_c[var3] - this.field_28119_b[var3] + 1;
                int var5 = this.field_28119_b[var3];
                byte[] var6 = new byte[var10 + 3];
                var6[0] = 0;
                var6[1] = (byte)var3;
                var6[2] = (byte)var5;

                for(int var7 = 0; var7 < var6.length - 3; ++var7) {
                    var6[var7 + 3] = this.field_28124_d.field_28160_f[(var7 + var5) * 128 + var3];
                }

                this.field_28125_c[var3] = -1;
                this.field_28119_b[var3] = -1;
                return var6;
            }
        }

        return null;
    }
}
