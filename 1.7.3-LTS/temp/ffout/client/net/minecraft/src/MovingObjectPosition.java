package net.minecraft.src;

public class MovingObjectPosition {
    public EnumMovingObjectType field_1167_a;
    public int field_1166_b;
    public int field_1172_c;
    public int field_1171_d;
    public int field_1170_e;
    public Vec3D field_1169_f;
    public Entity field_1168_g;

    public MovingObjectPosition(int var1, int var2, int var3, int var4, Vec3D var5) {
        this.field_1167_a = EnumMovingObjectType.TILE;
        this.field_1166_b = var1;
        this.field_1172_c = var2;
        this.field_1171_d = var3;
        this.field_1170_e = var4;
        this.field_1169_f = Vec3D.func_1248_b(var5.field_1776_a, var5.field_1775_b, var5.field_1779_c);
    }

    public MovingObjectPosition(Entity var1) {
        this.field_1167_a = EnumMovingObjectType.ENTITY;
        this.field_1168_g = var1;
        this.field_1169_f = Vec3D.func_1248_b(var1.field_611_ak, var1.field_610_al, var1.field_609_am);
    }
}
