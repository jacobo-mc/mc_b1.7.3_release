package net.minecraft.src;

public class MovingObjectPosition {
    public EnumMovingObjectType field_927_a;
    public int field_926_b;
    public int field_932_c;
    public int field_931_d;
    public int field_930_e;
    public Vec3D field_929_f;
    public Entity field_928_g;

    public MovingObjectPosition(int var1, int var2, int var3, int var4, Vec3D var5) {
        this.field_927_a = EnumMovingObjectType.TILE;
        this.field_926_b = var1;
        this.field_932_c = var2;
        this.field_931_d = var3;
        this.field_930_e = var4;
        this.field_929_f = Vec3D.func_768_b(var5.field_1055_a, var5.field_1054_b, var5.field_1058_c);
    }

    public MovingObjectPosition(Entity var1) {
        this.field_927_a = EnumMovingObjectType.ENTITY;
        this.field_928_g = var1;
        this.field_929_f = Vec3D.func_768_b(var1.field_322_l, var1.field_321_m, var1.field_320_n);
    }
}
