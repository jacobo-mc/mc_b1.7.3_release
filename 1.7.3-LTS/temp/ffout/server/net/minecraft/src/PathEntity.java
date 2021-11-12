package net.minecraft.src;

public class PathEntity {
    private final PathPoint[] field_1004_b;
    public final int field_1005_a;
    private int field_1006_c;

    public PathEntity(PathPoint[] var1) {
        this.field_1004_b = var1;
        this.field_1005_a = var1.length;
    }

    public void func_728_a() {
        ++this.field_1006_c;
    }

    public boolean func_729_b() {
        return this.field_1006_c >= this.field_1004_b.length;
    }

    public PathPoint func_22211_c() {
        return this.field_1005_a > 0 ? this.field_1004_b[this.field_1005_a - 1] : null;
    }

    public Vec3D func_727_a(Entity var1) {
        double var2 = (double)this.field_1004_b[this.field_1006_c].field_1016_a + (double)((int)(var1.field_300_D + 1.0F)) * 0.5D;
        double var4 = (double)this.field_1004_b[this.field_1006_c].field_1015_b;
        double var6 = (double)this.field_1004_b[this.field_1006_c].field_1014_c + (double)((int)(var1.field_300_D + 1.0F)) * 0.5D;
        return Vec3D.func_768_b(var2, var4, var6);
    }
}
