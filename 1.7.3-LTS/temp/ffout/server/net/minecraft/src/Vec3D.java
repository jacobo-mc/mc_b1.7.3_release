package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class Vec3D {
    private static List field_1057_d = new ArrayList();
    private static int field_1056_e = 0;
    public double field_1055_a;
    public double field_1054_b;
    public double field_1058_c;

    public static Vec3D func_760_a(double var0, double var2, double var4) {
        return new Vec3D(var0, var2, var4);
    }

    public static void func_761_a() {
        field_1056_e = 0;
    }

    public static Vec3D func_768_b(double var0, double var2, double var4) {
        if (field_1056_e >= field_1057_d.size()) {
            field_1057_d.add(func_760_a(0.0D, 0.0D, 0.0D));
        }

        return ((Vec3D)field_1057_d.get(field_1056_e++)).func_756_e(var0, var2, var4);
    }

    private Vec3D(double var1, double var3, double var5) {
        if (var1 == -0.0D) {
            var1 = 0.0D;
        }

        if (var3 == -0.0D) {
            var3 = 0.0D;
        }

        if (var5 == -0.0D) {
            var5 = 0.0D;
        }

        this.field_1055_a = var1;
        this.field_1054_b = var3;
        this.field_1058_c = var5;
    }

    private Vec3D func_756_e(double var1, double var3, double var5) {
        this.field_1055_a = var1;
        this.field_1054_b = var3;
        this.field_1058_c = var5;
        return this;
    }

    public Vec3D func_758_b() {
        double var1 = (double)MathHelper.func_583_a(this.field_1055_a * this.field_1055_a + this.field_1054_b * this.field_1054_b + this.field_1058_c * this.field_1058_c);
        return var1 < 1.0E-4D ? func_768_b(0.0D, 0.0D, 0.0D) : func_768_b(this.field_1055_a / var1, this.field_1054_b / var1, this.field_1058_c / var1);
    }

    public Vec3D func_757_c(double var1, double var3, double var5) {
        return func_768_b(this.field_1055_a + var1, this.field_1054_b + var3, this.field_1058_c + var5);
    }

    public double func_767_a(Vec3D var1) {
        double var2 = var1.field_1055_a - this.field_1055_a;
        double var4 = var1.field_1054_b - this.field_1054_b;
        double var6 = var1.field_1058_c - this.field_1058_c;
        return (double)MathHelper.func_583_a(var2 * var2 + var4 * var4 + var6 * var6);
    }

    public double func_764_b(Vec3D var1) {
        double var2 = var1.field_1055_a - this.field_1055_a;
        double var4 = var1.field_1054_b - this.field_1054_b;
        double var6 = var1.field_1058_c - this.field_1058_c;
        return var2 * var2 + var4 * var4 + var6 * var6;
    }

    public double func_759_d(double var1, double var3, double var5) {
        double var7 = var1 - this.field_1055_a;
        double var9 = var3 - this.field_1054_b;
        double var11 = var5 - this.field_1058_c;
        return var7 * var7 + var9 * var9 + var11 * var11;
    }

    public double func_765_c() {
        return (double)MathHelper.func_583_a(this.field_1055_a * this.field_1055_a + this.field_1054_b * this.field_1054_b + this.field_1058_c * this.field_1058_c);
    }

    public Vec3D func_766_a(Vec3D var1, double var2) {
        double var4 = var1.field_1055_a - this.field_1055_a;
        double var6 = var1.field_1054_b - this.field_1054_b;
        double var8 = var1.field_1058_c - this.field_1058_c;
        if (var4 * var4 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double var10 = (var2 - this.field_1055_a) / var4;
            return var10 >= 0.0D && var10 <= 1.0D ? func_768_b(this.field_1055_a + var4 * var10, this.field_1054_b + var6 * var10, this.field_1058_c + var8 * var10) : null;
        }
    }

    public Vec3D func_763_b(Vec3D var1, double var2) {
        double var4 = var1.field_1055_a - this.field_1055_a;
        double var6 = var1.field_1054_b - this.field_1054_b;
        double var8 = var1.field_1058_c - this.field_1058_c;
        if (var6 * var6 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double var10 = (var2 - this.field_1054_b) / var6;
            return var10 >= 0.0D && var10 <= 1.0D ? func_768_b(this.field_1055_a + var4 * var10, this.field_1054_b + var6 * var10, this.field_1058_c + var8 * var10) : null;
        }
    }

    public Vec3D func_762_c(Vec3D var1, double var2) {
        double var4 = var1.field_1055_a - this.field_1055_a;
        double var6 = var1.field_1054_b - this.field_1054_b;
        double var8 = var1.field_1058_c - this.field_1058_c;
        if (var8 * var8 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double var10 = (var2 - this.field_1058_c) / var8;
            return var10 >= 0.0D && var10 <= 1.0D ? func_768_b(this.field_1055_a + var4 * var10, this.field_1054_b + var6 * var10, this.field_1058_c + var8 * var10) : null;
        }
    }

    public String toString() {
        return "(" + this.field_1055_a + ", " + this.field_1054_b + ", " + this.field_1058_c + ")";
    }
}
