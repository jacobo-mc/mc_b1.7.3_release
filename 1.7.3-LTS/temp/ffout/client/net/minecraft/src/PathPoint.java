package net.minecraft.src;

public class PathPoint {
    public final int field_1718_a;
    public final int field_1717_b;
    public final int field_1716_c;
    private final int field_1715_d;
    int field_1714_e = -1;
    float field_1713_f;
    float field_1712_g;
    float field_1711_h;
    PathPoint field_1710_i;
    public boolean field_1709_j = false;

    public PathPoint(int var1, int var2, int var3) {
        this.field_1718_a = var1;
        this.field_1717_b = var2;
        this.field_1716_c = var3;
        this.field_1715_d = func_22329_a(var1, var2, var3);
    }

    public static int func_22329_a(int var0, int var1, int var2) {
        return var1 & 255 | (var0 & 32767) << 8 | (var2 & 32767) << 24 | (var0 < 0 ? Integer.MIN_VALUE : 0) | (var2 < 0 ? '\u8000' : 0);
    }

    public float func_1180_a(PathPoint var1) {
        float var2 = (float)(var1.field_1718_a - this.field_1718_a);
        float var3 = (float)(var1.field_1717_b - this.field_1717_b);
        float var4 = (float)(var1.field_1716_c - this.field_1716_c);
        return MathHelper.func_1113_c(var2 * var2 + var3 * var3 + var4 * var4);
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof PathPoint)) {
            return false;
        } else {
            PathPoint var2 = (PathPoint)var1;
            return this.field_1715_d == var2.field_1715_d && this.field_1718_a == var2.field_1718_a && this.field_1717_b == var2.field_1717_b && this.field_1716_c == var2.field_1716_c;
        }
    }

    public int hashCode() {
        return this.field_1715_d;
    }

    public boolean func_1179_a() {
        return this.field_1714_e >= 0;
    }

    public String toString() {
        return this.field_1718_a + ", " + this.field_1717_b + ", " + this.field_1716_c;
    }
}
