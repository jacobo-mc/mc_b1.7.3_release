package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class AxisAlignedBB {
    private static List field_966_g = new ArrayList();
    private static int field_965_h = 0;
    public double field_964_a;
    public double field_963_b;
    public double field_970_c;
    public double field_969_d;
    public double field_968_e;
    public double field_967_f;

    public static AxisAlignedBB func_698_a(double var0, double var2, double var4, double var6, double var8, double var10) {
        return new AxisAlignedBB(var0, var2, var4, var6, var8, var10);
    }

    public static void func_703_a() {
        field_965_h = 0;
    }

    public static AxisAlignedBB func_693_b(double var0, double var2, double var4, double var6, double var8, double var10) {
        if (field_965_h >= field_966_g.size()) {
            field_966_g.add(func_698_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D));
        }

        return ((AxisAlignedBB)field_966_g.get(field_965_h++)).func_695_c(var0, var2, var4, var6, var8, var10);
    }

    private AxisAlignedBB(double var1, double var3, double var5, double var7, double var9, double var11) {
        this.field_964_a = var1;
        this.field_963_b = var3;
        this.field_970_c = var5;
        this.field_969_d = var7;
        this.field_968_e = var9;
        this.field_967_f = var11;
    }

    public AxisAlignedBB func_695_c(double var1, double var3, double var5, double var7, double var9, double var11) {
        this.field_964_a = var1;
        this.field_963_b = var3;
        this.field_970_c = var5;
        this.field_969_d = var7;
        this.field_968_e = var9;
        this.field_967_f = var11;
        return this;
    }

    public AxisAlignedBB func_700_a(double var1, double var3, double var5) {
        double var7 = this.field_964_a;
        double var9 = this.field_963_b;
        double var11 = this.field_970_c;
        double var13 = this.field_969_d;
        double var15 = this.field_968_e;
        double var17 = this.field_967_f;
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

        return func_693_b(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB func_708_b(double var1, double var3, double var5) {
        double var7 = this.field_964_a - var1;
        double var9 = this.field_963_b - var3;
        double var11 = this.field_970_c - var5;
        double var13 = this.field_969_d + var1;
        double var15 = this.field_968_e + var3;
        double var17 = this.field_967_f + var5;
        return func_693_b(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB func_696_c(double var1, double var3, double var5) {
        return func_693_b(this.field_964_a + var1, this.field_963_b + var3, this.field_970_c + var5, this.field_969_d + var1, this.field_968_e + var3, this.field_967_f + var5);
    }

    public double func_710_a(AxisAlignedBB var1, double var2) {
        if (var1.field_968_e > this.field_963_b && var1.field_963_b < this.field_968_e) {
            if (var1.field_967_f > this.field_970_c && var1.field_970_c < this.field_967_f) {
                double var4;
                if (var2 > 0.0D && var1.field_969_d <= this.field_964_a) {
                    var4 = this.field_964_a - var1.field_969_d;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.field_964_a >= this.field_969_d) {
                    var4 = this.field_969_d - var1.field_964_a;
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

    public double func_701_b(AxisAlignedBB var1, double var2) {
        if (var1.field_969_d > this.field_964_a && var1.field_964_a < this.field_969_d) {
            if (var1.field_967_f > this.field_970_c && var1.field_970_c < this.field_967_f) {
                double var4;
                if (var2 > 0.0D && var1.field_968_e <= this.field_963_b) {
                    var4 = this.field_963_b - var1.field_968_e;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.field_963_b >= this.field_968_e) {
                    var4 = this.field_968_e - var1.field_963_b;
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

    public double func_709_c(AxisAlignedBB var1, double var2) {
        if (var1.field_969_d > this.field_964_a && var1.field_964_a < this.field_969_d) {
            if (var1.field_968_e > this.field_963_b && var1.field_963_b < this.field_968_e) {
                double var4;
                if (var2 > 0.0D && var1.field_967_f <= this.field_970_c) {
                    var4 = this.field_970_c - var1.field_967_f;
                    if (var4 < var2) {
                        var2 = var4;
                    }
                }

                if (var2 < 0.0D && var1.field_970_c >= this.field_967_f) {
                    var4 = this.field_967_f - var1.field_970_c;
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

    public boolean func_704_a(AxisAlignedBB var1) {
        if (var1.field_969_d > this.field_964_a && var1.field_964_a < this.field_969_d) {
            if (var1.field_968_e > this.field_963_b && var1.field_963_b < this.field_968_e) {
                return var1.field_967_f > this.field_970_c && var1.field_970_c < this.field_967_f;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AxisAlignedBB func_702_d(double var1, double var3, double var5) {
        this.field_964_a += var1;
        this.field_963_b += var3;
        this.field_970_c += var5;
        this.field_969_d += var1;
        this.field_968_e += var3;
        this.field_967_f += var5;
        return this;
    }

    public boolean func_28183_a(Vec3D var1) {
        if (var1.field_1055_a > this.field_964_a && var1.field_1055_a < this.field_969_d) {
            if (var1.field_1054_b > this.field_963_b && var1.field_1054_b < this.field_968_e) {
                return var1.field_1058_c > this.field_970_c && var1.field_1058_c < this.field_967_f;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public AxisAlignedBB func_694_e(double var1, double var3, double var5) {
        double var7 = this.field_964_a + var1;
        double var9 = this.field_963_b + var3;
        double var11 = this.field_970_c + var5;
        double var13 = this.field_969_d - var1;
        double var15 = this.field_968_e - var3;
        double var17 = this.field_967_f - var5;
        return func_693_b(var7, var9, var11, var13, var15, var17);
    }

    public AxisAlignedBB func_711_b() {
        return func_693_b(this.field_964_a, this.field_963_b, this.field_970_c, this.field_969_d, this.field_968_e, this.field_967_f);
    }

    public MovingObjectPosition func_706_a(Vec3D var1, Vec3D var2) {
        Vec3D var3 = var1.func_766_a(var2, this.field_964_a);
        Vec3D var4 = var1.func_766_a(var2, this.field_969_d);
        Vec3D var5 = var1.func_763_b(var2, this.field_963_b);
        Vec3D var6 = var1.func_763_b(var2, this.field_968_e);
        Vec3D var7 = var1.func_762_c(var2, this.field_970_c);
        Vec3D var8 = var1.func_762_c(var2, this.field_967_f);
        if (!this.func_697_a(var3)) {
            var3 = null;
        }

        if (!this.func_697_a(var4)) {
            var4 = null;
        }

        if (!this.func_705_b(var5)) {
            var5 = null;
        }

        if (!this.func_705_b(var6)) {
            var6 = null;
        }

        if (!this.func_707_c(var7)) {
            var7 = null;
        }

        if (!this.func_707_c(var8)) {
            var8 = null;
        }

        Vec3D var9 = null;
        if (var3 != null && (var9 == null || var1.func_764_b(var3) < var1.func_764_b(var9))) {
            var9 = var3;
        }

        if (var4 != null && (var9 == null || var1.func_764_b(var4) < var1.func_764_b(var9))) {
            var9 = var4;
        }

        if (var5 != null && (var9 == null || var1.func_764_b(var5) < var1.func_764_b(var9))) {
            var9 = var5;
        }

        if (var6 != null && (var9 == null || var1.func_764_b(var6) < var1.func_764_b(var9))) {
            var9 = var6;
        }

        if (var7 != null && (var9 == null || var1.func_764_b(var7) < var1.func_764_b(var9))) {
            var9 = var7;
        }

        if (var8 != null && (var9 == null || var1.func_764_b(var8) < var1.func_764_b(var9))) {
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

    private boolean func_697_a(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1054_b >= this.field_963_b && var1.field_1054_b <= this.field_968_e && var1.field_1058_c >= this.field_970_c && var1.field_1058_c <= this.field_967_f;
        }
    }

    private boolean func_705_b(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1055_a >= this.field_964_a && var1.field_1055_a <= this.field_969_d && var1.field_1058_c >= this.field_970_c && var1.field_1058_c <= this.field_967_f;
        }
    }

    private boolean func_707_c(Vec3D var1) {
        if (var1 == null) {
            return false;
        } else {
            return var1.field_1055_a >= this.field_964_a && var1.field_1055_a <= this.field_969_d && var1.field_1054_b >= this.field_963_b && var1.field_1054_b <= this.field_968_e;
        }
    }

    public void func_699_b(AxisAlignedBB var1) {
        this.field_964_a = var1.field_964_a;
        this.field_963_b = var1.field_963_b;
        this.field_970_c = var1.field_970_c;
        this.field_969_d = var1.field_969_d;
        this.field_968_e = var1.field_968_e;
        this.field_967_f = var1.field_967_f;
    }

    public String toString() {
        return "box[" + this.field_964_a + ", " + this.field_963_b + ", " + this.field_970_c + " -> " + this.field_969_d + ", " + this.field_968_e + ", " + this.field_967_f + "]";
    }
}
