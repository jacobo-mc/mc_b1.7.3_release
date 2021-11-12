package net.minecraft.src;

public class PathPoint {
    public final int field_1016_a;
    public final int field_1015_b;
    public final int field_1014_c;
    private final int field_1013_d;
    int field_1012_e = -1;
    float field_1011_f;
    float field_1010_g;
    float field_1009_h;
    PathPoint field_1008_i;
    public boolean field_1007_j = false;

    public PathPoint(int var1, int var2, int var3) {
        this.field_1016_a = var1;
        this.field_1015_b = var2;
        this.field_1014_c = var3;
        this.field_1013_d = func_22203_a(var1, var2, var3);
    }

    public static int func_22203_a(int var0, int var1, int var2) {
        return var1 & 255 | (var0 & 32767) << 8 | (var2 & 32767) << 24 | (var0 < 0 ? Integer.MIN_VALUE : 0) | (var2 < 0 ? '\u8000' : 0);
    }

    public float func_731_a(PathPoint var1) {
        float var2 = (float)(var1.field_1016_a - this.field_1016_a);
        float var3 = (float)(var1.field_1015_b - this.field_1015_b);
        float var4 = (float)(var1.field_1014_c - this.field_1014_c);
        return MathHelper.func_586_c(var2 * var2 + var3 * var3 + var4 * var4);
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof PathPoint)) {
            return false;
        } else {
            PathPoint var2 = (PathPoint)var1;
            return this.field_1013_d == var2.field_1013_d && this.field_1016_a == var2.field_1016_a && this.field_1015_b == var2.field_1015_b && this.field_1014_c == var2.field_1014_c;
        }
    }

    public int hashCode() {
        return this.field_1013_d;
    }

    public boolean func_730_a() {
        return this.field_1012_e >= 0;
    }

    public String toString() {
        return this.field_1016_a + ", " + this.field_1015_b + ", " + this.field_1014_c;
    }
}
