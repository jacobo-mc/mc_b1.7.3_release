package net.minecraft.src;

public class PathEntity {
    private final PathPoint[] field_1764_b;
    public final int field_1765_a;
    private int field_1766_c;

    public PathEntity(PathPoint[] var1) {
        this.field_1764_b = var1;
        this.field_1765_a = var1.length;
    }

    public void func_1206_a() {
        ++this.field_1766_c;
    }

    public boolean func_1207_b() {
        return this.field_1766_c >= this.field_1764_b.length;
    }

    public PathPoint func_22328_c() {
        return this.field_1765_a > 0 ? this.field_1764_b[this.field_1765_a - 1] : null;
    }

    public Vec3D func_1205_a(Entity var1) {
        double var2 = (double)this.field_1764_b[this.field_1766_c].field_1718_a + (double)((int)(var1.field_644_aC + 1.0F)) * 0.5D;
        double var4 = (double)this.field_1764_b[this.field_1766_c].field_1717_b;
        double var6 = (double)this.field_1764_b[this.field_1766_c].field_1716_c + (double)((int)(var1.field_644_aC + 1.0F)) * 0.5D;
        return Vec3D.func_1248_b(var2, var4, var6);
    }
}
