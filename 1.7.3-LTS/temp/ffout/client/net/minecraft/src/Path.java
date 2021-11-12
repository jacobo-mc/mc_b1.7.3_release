package net.minecraft.src;

public class Path {
    private PathPoint[] field_1556_a = new PathPoint[1024];
    private int field_1555_b = 0;

    public PathPoint func_1034_a(PathPoint var1) {
        if (var1.field_1714_e >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        } else {
            if (this.field_1555_b == this.field_1556_a.length) {
                PathPoint[] var2 = new PathPoint[this.field_1555_b << 1];
                System.arraycopy(this.field_1556_a, 0, var2, 0, this.field_1555_b);
                this.field_1556_a = var2;
            }

            this.field_1556_a[this.field_1555_b] = var1;
            var1.field_1714_e = this.field_1555_b;
            this.func_1033_a(this.field_1555_b++);
            return var1;
        }
    }

    public void func_1038_a() {
        this.field_1555_b = 0;
    }

    public PathPoint func_1036_b() {
        PathPoint var1 = this.field_1556_a[0];
        this.field_1556_a[0] = this.field_1556_a[--this.field_1555_b];
        this.field_1556_a[this.field_1555_b] = null;
        if (this.field_1555_b > 0) {
            this.func_1037_b(0);
        }

        var1.field_1714_e = -1;
        return var1;
    }

    public void func_1035_a(PathPoint var1, float var2) {
        float var3 = var1.field_1711_h;
        var1.field_1711_h = var2;
        if (var2 < var3) {
            this.func_1033_a(var1.field_1714_e);
        } else {
            this.func_1037_b(var1.field_1714_e);
        }

    }

    private void func_1033_a(int var1) {
        PathPoint var2 = this.field_1556_a[var1];

        int var4;
        for(float var3 = var2.field_1711_h; var1 > 0; var1 = var4) {
            var4 = var1 - 1 >> 1;
            PathPoint var5 = this.field_1556_a[var4];
            if (var3 >= var5.field_1711_h) {
                break;
            }

            this.field_1556_a[var1] = var5;
            var5.field_1714_e = var1;
        }

        this.field_1556_a[var1] = var2;
        var2.field_1714_e = var1;
    }

    private void func_1037_b(int var1) {
        PathPoint var2 = this.field_1556_a[var1];
        float var3 = var2.field_1711_h;

        while(true) {
            int var4 = 1 + (var1 << 1);
            int var5 = var4 + 1;
            if (var4 >= this.field_1555_b) {
                break;
            }

            PathPoint var6 = this.field_1556_a[var4];
            float var7 = var6.field_1711_h;
            PathPoint var8;
            float var9;
            if (var5 >= this.field_1555_b) {
                var8 = null;
                var9 = Float.POSITIVE_INFINITY;
            } else {
                var8 = this.field_1556_a[var5];
                var9 = var8.field_1711_h;
            }

            if (var7 < var9) {
                if (var7 >= var3) {
                    break;
                }

                this.field_1556_a[var1] = var6;
                var6.field_1714_e = var1;
                var1 = var4;
            } else {
                if (var9 >= var3) {
                    break;
                }

                this.field_1556_a[var1] = var8;
                var8.field_1714_e = var1;
                var1 = var5;
            }
        }

        this.field_1556_a[var1] = var2;
        var2.field_1714_e = var1;
    }

    public boolean func_1039_c() {
        return this.field_1555_b == 0;
    }
}
