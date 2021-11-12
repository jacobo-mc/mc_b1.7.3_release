package net.minecraft.src;

public class PositionTextureVertex {
    public Vec3D field_1655_a;
    public float field_1654_b;
    public float field_1656_c;

    public PositionTextureVertex(float var1, float var2, float var3, float var4, float var5) {
        this(Vec3D.func_1260_a((double)var1, (double)var2, (double)var3), var4, var5);
    }

    public PositionTextureVertex func_1115_a(float var1, float var2) {
        return new PositionTextureVertex(this, var1, var2);
    }

    public PositionTextureVertex(PositionTextureVertex var1, float var2, float var3) {
        this.field_1655_a = var1.field_1655_a;
        this.field_1654_b = var2;
        this.field_1656_c = var3;
    }

    public PositionTextureVertex(Vec3D var1, float var2, float var3) {
        this.field_1655_a = var1;
        this.field_1654_b = var2;
        this.field_1656_c = var3;
    }
}
