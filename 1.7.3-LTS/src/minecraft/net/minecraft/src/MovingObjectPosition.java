package net.minecraft.src;

public class MovingObjectPosition {
    public EnumMovingObjectType typeOfHit;
    public int blockX;
    public int blockY;
    public int blockZ;
    public int sideHit;
    public Vec3D hitVec;
    public Entity entityHit;

    public MovingObjectPosition(int var1, int var2, int var3, int var4, Vec3D var5) {
        this.typeOfHit = EnumMovingObjectType.TILE;
        this.blockX = var1;
        this.blockY = var2;
        this.blockZ = var3;
        this.sideHit = var4;
        this.hitVec = Vec3D.createVector(var5.xCoord, var5.yCoord, var5.zCoord);
    }

    public MovingObjectPosition(Entity var1) {
        this.typeOfHit = EnumMovingObjectType.ENTITY;
        this.entityHit = var1;
        this.hitVec = Vec3D.createVector(var1.posX, var1.posY, var1.posZ);
    }
}
