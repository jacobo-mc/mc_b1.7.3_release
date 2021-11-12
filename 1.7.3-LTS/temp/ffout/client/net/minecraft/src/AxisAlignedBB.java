package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class AxisAlignedBB {
    private static List field_1700_g = new ArrayList();
    private static int field_1699_h = 0;
    public double field_1698_a;
    public double field_1697_b;
    public double field_1704_c;
    public double field_1703_d;
    public double field_1702_e;
    public double field_1701_f;

    public static AxisAlignedBB func_1168_a(double var0, double var2, double var4, double var6, double var8, double var10) {
        return new AxisAlignedBB(var0, var2, var4, var6, var8, var10);
    }

    public static void func_28196_a() {
        field_1700_g.clear();
        field_1699_h = 0;
    }

    public static void func_4149_a() {
        field_1699_h = 0;
    }

    public static AxisAlignedBB func_1161_b(double var0, double var2, double var4, double var6, double var8, double var10) {
        if (field_1699_h >= field_1700_g.size()) {
            field_1700_g.add(func_1168_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D));
        }

        return ((AxisAlignedBB)field_1700_g.get(field_1699_h++)).func_1165_c(var0, var2, var4, var6, var8, var10);
    }

    private AxisAlignedBB(double var1, double var3, double var5, double var7, double var9, double var11) {
        this.field_1698_a = var1;
        this.field_1697_b = var3;
        this.field_1704_c = var5;
        this.field_1703_d = var7;
        this.field_1702_e = var9;
        this.field_1701_f = var11;
    }

    public AxisAlignedBB func_1165_c(double var1, double var3, double var5, double var7, double var9, double var11) {
        this.field_1698_a = var1;
        this.field_1697_b = var3;
        this.field_1704_c = var5;
        this.field_1703_d = var7;
        this.field_1702_e = var9;
        this.field_1701_f = var11;
        return this;
    }

    public AxisAlignedBB func_1170_a(double var1, double var3, double var5) {
        double var7 = this.field_1698_a;
        double var9 = this.field_1697_b;
        double var11 = this.field_1704_c;
        double var13 = this.field_1703_d;
        double var15 = this.field_1702_e;
        double var17 = this.field_1701_f;
        if (var1 < 0.0D) {
            var7 += var1;
        }

        if (var1 > 0.0D) {
            var13 += var1;
        }

        if (var3 < 0.0D) {
            var9 += var3;
        }

        if (var3 > 0.0D) {
            var15 += var3;
        }

        if (var5 < 0.0D) {
            var11 += var5;
        }

        if (var5 > 0.0D) {
            var17 += var5;
        }

        return func_1161_b(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB func_1177_b(double var1, double var3, double var5) {
        double var7 = this.field_1698_a - var1;
        double var9 = this.field_1697_b - var3;
        double var11 = this.field_1704_c - var5;
        double var13 = this.field_1703_d + var1;
        double var15 = this.field_1702_e + var3;
        double var17 = this.field_1701_f + var5;
        return func_1161_b(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB func_1166_c(double var1, double var3, double var5) {
        return func_1161_b(this.field_1698_a + var1, this.field_1697_b + var3, this.field_1704_c + var5, this.field_1703_d + var1, this.field_1702_e + var3, this.field_1701_f + var5);
    }

    public double func_1163_a(AxisAlignedBB var1, double var2) {
        if (var1.field_1702_e > this.field_1697_b && var1.field_1697_b < this.field_1702_e) {
            if (var1.field_1701_f > this.field_1704_c && var1.field_1704_c < this.field_1701_f) {
                double var4;
                if (var2 > 0.0D && var1.field_1703_d <= this.field_1698_a) {
                    var4 = this.field_1698_a - var1.field_1703_d;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.field_1698_a >= this.field_1703_d) {
                    var4 = this.field_1703_d - var1.field_1698_a;
                    if (var4 > var2) {
                        var2 = var4;
                    }
                }

                return var2;
            } else {
                return var2;
            }
        } else {
            return var2;
        }
    }

    public double func_1172_b(AxisAlignedBB var1, double var2) {
        if (var1.field_1703_d > this.field_1698_a && var1.field_1698_a < this.field_1703_d) {
            if (var1.field_1701_f > this.field_1704_c && var1.field_1704_c < this.field_1701_f) {
                double var4;
                if (var2 > 0.0D && var1.field_1702_e <= this.field_1697_b) {
                    var4 = this.field_1697_b - var1.field_1702_e;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.field_1697_b >= this.field_1702_e) {
                    var4 = this.field_1702_e - var1.field_1697_b;
                    if (var4 > var2) {
                        var2 = var4;
                    }
                }

                return var2;
            } else {
                return var2;
            }
        } else {
            return var2;
        }
    }

    public double func_1162_c(AxisAlignedBB var1, double var2) {
        if (var1.field_1703_d > this.field_1698_a && var1.field_1698_a < this.field_1703_d) {
            if (var1.field_1702_e > this.field_1697_b && var1.field_1697_b < this.field_1702_e) {
                double var4;
                if (var2 > 0.0D && var1.field_1701_f <= this.field_1704_c) {
                    var4 = this.field_1704_c - var1.field_1701_f;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.field_1704_c >= this.field_1701_f) {
                    var4 = this.field_1701_f - var1.field_1704_c;
                    if (var4 > var2) {
                        var2 = var4;
                    }
                }

                return var2;
            } else {
                return var2;
            }
        } else {
            return var2;
        }
    }

    public boolean func_1178_a(AxisAlignedBB var1) {
        if (var1.field_1703_d > this.field_1698_a && var1.field_1698_a < this.field_1703_d) {
            if (var1.field_1702_e > this.field_1697_b && var1.field_1697_b < this.field_1702_e) {
                return var1.field_1701_f > this.field_1704_c && var1.field_1704_c < this.field_1701_f;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AxisAlignedBB func_1174_d(double var1, double var3, double var5) {
        this.field_1698_a += var1;
        this.field_1697_b += var3;
        this.field_1704_c += var5;
        this.field_1703_d += var1;
        this.field_1702_e += var3;
        this.field_1701_f += var5;
        return this;
    }

    public boolean func_4150_a(Vec3D var1) {
        if (var1.field_1776_a > this.field_1698_a && var1.field_1776_a < this.field_1703_d) {
            if (var1.field_1775_b > this.field_1697_b && var1.field_1775_b < this.field_1702_e) {
                return var1.field_1779_c > this.field_1704_c && var1.field_1779_c < this.field_1701_f;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public double func_1164_b() {
        double var1 = this.field_1703_d - this.field_1698_a;
        double var3 = this.field_1702_e - this.field_1697_b;
        double var5 = this.field_1701_f - this.field_1704_c;
        return (var1 + var3 + var5) / 3.0D;
    }

    public AxisAlignedBB func_28195_e(double var1, double var3, double var5) {
        double var7 = this.field_1698_a + var1;
        double var9 = this.field_1697_b + var3;
        double var11 = this.field_1704_c + var5;
        double var13 = this.field_1703_d - var1;
        double var15 = this.field_1702_e - var3;
        double var17 = this.field_1701_f - var5;
        return func_1161_b(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB func_1160_c() {
        return func_1161_b(this.field_1698_a, this.field_1697_b, this.field_1704_c, this.field_1703_d, this.field_1702_e, this.field_1701_f);
    }

    public MovingObjectPosition func_1169_a(Vec3D var1, Vec3D var2) {
        Vec3D var3 = var1.func_1247_a(var2, this.field_1698_a);
        Vec3D var4 = var1.func_1247_a(var2, this.field_1703_d);
        Vec3D var5 = var1.func_1250_b(var2, this.field_1697_b);
        Vec3D var6 = var1.func_1250_b(var2, this.field_1702_e);
        Vec3D var7 = var1.func_1256_c(var2, this.field_1704_c);
        Vec3D var8 = var1.func_1256_c(var2, this.field_1701_f);
        if (!this.func_1167_a(var3)) {
            var3 = null;
        }

        if (!this.func_1167_a(var4)) {
            var4 = null;
        }

        if (!this.func_1175_b(var5)) {
            var5 = null;
        }

        if (!this.func_1175_b(var6)) {
            var6 = null;
        }

        if (!this.func_1176_c(var7)) {
            var7 = null;
        }

        if (!this.func_1176_c(var8)) {
            var8 = null;
        }

        Vec3D var9 = null;
        if (var3 != null && (var9 == null || var1.func_1261_d(var3) < var1.func_1261_d(var9))) {
            var9 = var3;
        }

        if (var4 != null && (var9 == null || var1.func_1261_d(var4) < var1.func_1261_d(var9))) {
            var9 = var4;
        }

        if (var5 != null && (var9 == null || var1.func_1261_d(var5) < var1.func_1261_d(var9))) {
            var9 = var5;
        }

        if (var6 != null && (var9 == null || var1.func_1261_d(var6) < var1.func_1261_d(var9))) {
            var9 = var6;
        }

        if (var7 != null && (var9 == null || var1.func_1261_d(var7) < var1.func_1261_d(var9))) {
            var9 = var7;
        }

        if (var8 != null && (var9 == null || var1.func_1261_d(var8) < var1.func_1261_d(var9))) {
            var9 = var8;
        }

        if (var9 == null) {
            return null;
        } else {
            byte var10 = -1;
            if (var9 == var3) {
                var10 = 4;
            }

            if (var9 == var4) {
                var10 = 5;
            }

            if (var9 == var5) {
                var10 = 0;
            }

            if (var9 == var6) {
                var10 = 1;
            }

            if (var9 == var7) {
                var10 = 2;
            }

            if (var9 == var8) {
                var10 = 3;
            }

            return new MovingObjectPosition(0, 0, 0, var10, var9);
        }
    }

    private boolean func_1167_a(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1775_b >= this.field_1697_b && var1.field_1775_b <= this.field_1702_e && var1.field_1779_c >= this.field_1704_c && var1.field_1779_c <= this.field_1701_f;
        }
    }

    private boolean func_1175_b(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1776_a >= this.field_1698_a && var1.field_1776_a <= this.field_1703_d && var1.field_1779_c >= this.field_1704_c && var1.field_1779_c <= this.field_1701_f;
        }
    }

    private boolean func_1176_c(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1776_a >= this.field_1698_a && var1.field_1776_a <= this.field_1703_d && var1.field_1775_b >= this.field_1697_b && var1.field_1775_b <= this.field_1702_e;
        }
    }

    public void func_1171_b(AxisAlignedBB var1) {
        this.field_1698_a = var1.field_1698_a;
        this.field_1697_b = var1.field_1697_b;
        this.field_1704_c = var1.field_1704_c;
        this.field_1703_d = var1.field_1703_d;
        this.field_1702_e = var1.field_1702_e;
        this.field_1701_f = var1.field_1701_f;
    }

    public String toString() {
        return "box[" + this.field_1698_a + ", " + this.field_1697_b + ", " + this.field_1704_c + " -> " + this.field_1703_d + ", " + this.field_1702_e + ", " + this.field_1701_f + "]";
    }
}
