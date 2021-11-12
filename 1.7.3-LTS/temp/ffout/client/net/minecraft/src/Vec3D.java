package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class Vec3D {
    private static List field_1778_d = new ArrayList();
    private static int field_1777_e = 0;
    public double field_1776_a;
    public double field_1775_b;
    public double field_1779_c;

    public static Vec3D func_1260_a(double var0, double var2, double var4) {
        return new Vec3D(var0, var2, var4);
    }

    public static void func_28215_a() {
        field_1778_d.clear();
        field_1777_e = 0;
    }

    public static void func_1259_a() {
        field_1777_e = 0;
    }

    public static Vec3D func_1248_b(double var0, double var2, double var4) {
        if (field_1777_e >= field_1778_d.size()) {
            field_1778_d.add(func_1260_a(0.0D, 0.0D, 0.0D));
        }

        return ((Vec3D)field_1778_d.get(field_1777_e++)).func_1254_e(var0, var2, var4);
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

        this.field_1776_a = var1;
        this.field_1775_b = var3;
        this.field_1779_c = var5;
    }

    private Vec3D func_1254_e(double var1, double var3, double var5) {
        this.field_1776_a = var1;
        this.field_1775_b = var3;
        this.field_1779_c = var5;
        return this;
    }

    public Vec3D func_1262_a(Vec3D var1) {
        return func_1248_b(var1.field_1776_a - this.field_1776_a, var1.field_1775_b - this.field_1775_b, var1.field_1779_c - this.field_1779_c);
    }

    public Vec3D func_1252_b() {
        double var1 = (double)MathHelper.func_1109_a(this.field_1776_a * this.field_1776_a + this.field_1775_b * this.field_1775_b + this.field_1779_c * this.field_1779_c);
        return var1 < 1.0E-4D ? func_1248_b(0.0D, 0.0D, 0.0D) : func_1248_b(this.field_1776_a / var1, this.field_1775_b / var1, this.field_1779_c / var1);
    }

    public Vec3D func_1246_b(Vec3D var1) {
        return func_1248_b(this.field_1775_b * var1.field_1779_c - this.field_1779_c * var1.field_1775_b, this.field_1779_c * var1.field_1776_a - this.field_1776_a * var1.field_1779_c, this.field_1776_a * var1.field_1775_b - this.field_1775_b * var1.field_1776_a);
    }

    public Vec3D func_1257_c(double var1, double var3, double var5) {
        return func_1248_b(this.field_1776_a + var1, this.field_1775_b + var3, this.field_1779_c + var5);
    }

    public double func_1251_c(Vec3D var1) {
        double var2 = var1.field_1776_a - this.field_1776_a;
        double var4 = var1.field_1775_b - this.field_1775_b;
        double var6 = var1.field_1779_c - this.field_1779_c;
        return (double)MathHelper.func_1109_a(var2 * var2 + var4 * var4 + var6 * var6);
    }

    public double func_1261_d(Vec3D var1) {
        double var2 = var1.field_1776_a - this.field_1776_a;
        double var4 = var1.field_1775_b - this.field_1775_b;
        double var6 = var1.field_1779_c - this.field_1779_c;
        return var2 * var2 + var4 * var4 + var6 * var6;
    }

    public double func_1255_d(double var1, double var3, double var5) {
        double var7 = var1 - this.field_1776_a;
        double var9 = var3 - this.field_1775_b;
        double var11 = var5 - this.field_1779_c;
        return var7 * var7 + var9 * var9 + var11 * var11;
    }

    public double func_1253_c() {
        return (double)MathHelper.func_1109_a(this.field_1776_a * this.field_1776_a + this.field_1775_b * this.field_1775_b + this.field_1779_c * this.field_1779_c);
    }

    public Vec3D func_1247_a(Vec3D var1, double var2) {
        double var4 = var1.field_1776_a - this.field_1776_a;
        double var6 = var1.field_1775_b - this.field_1775_b;
        double var8 = var1.field_1779_c - this.field_1779_c;
        if (var4 * var4 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double var10 = (var2 - this.field_1776_a) / var4;
            return var10 >= 0.0D && var10 <= 1.0D ? func_1248_b(this.field_1776_a + var4 * var10, this.field_1775_b + var6 * var10, this.field_1779_c + var8 * var10) : null;
        }
    }

    public Vec3D func_1250_b(Vec3D var1, double var2) {
        double var4 = var1.field_1776_a - this.field_1776_a;
        double var6 = var1.field_1775_b - this.field_1775_b;
        double var8 = var1.field_1779_c - this.field_1779_c;
        if (var6 * var6 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double var10 = (var2 - this.field_1775_b) / var6;
            return var10 >= 0.0D && var10 <= 1.0D ? func_1248_b(this.field_1776_a + var4 * var10, this.field_1775_b + var6 * var10, this.field_1779_c + var8 * var10) : null;
        }
    }

    public Vec3D func_1256_c(Vec3D var1, double var2) {
        double var4 = var1.field_1776_a - this.field_1776_a;
        double var6 = var1.field_1775_b - this.field_1775_b;
        double var8 = var1.field_1779_c - this.field_1779_c;
        if (var8 * var8 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double var10 = (var2 - this.field_1779_c) / var8;
            return var10 >= 0.0D && var10 <= 1.0D ? func_1248_b(this.field_1776_a + var4 * var10, this.field_1775_b + var6 * var10, this.field_1779_c + var8 * var10) : null;
        }
    }

    public String toString() {
        return "(" + this.field_1776_a + ", " + this.field_1775_b + ", " + this.field_1779_c + ")";
    }

    public void func_1258_a(float var1) {
        float var2 = MathHelper.func_1114_b(var1);
        float var3 = MathHelper.func_1106_a(var1);
        double var4 = this.field_1776_a;
        double var6 = this.field_1775_b * (double)var2 + this.field_1779_c * (double)var3;
        double var8 = this.field_1779_c * (double)var2 - this.field_1775_b * (double)var3;
        this.field_1776_a = var4;
        this.field_1775_b = var6;
        this.field_1779_c = var8;
    }

    public void func_1249_b(float var1) {
        float var2 = MathHelper.func_1114_b(var1);
        float var3 = MathHelper.func_1106_a(var1);
        double var4 = this.field_1776_a * (double)var2 + this.field_1779_c * (double)var3;
        double var6 = this.field_1775_b;
        double var8 = this.field_1779_c * (double)var2 - this.field_1776_a * (double)var3;
        this.field_1776_a = var4;
        this.field_1775_b = var6;
        this.field_1779_c = var8;
    }
}
