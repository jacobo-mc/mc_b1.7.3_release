package net.minecraft.src;

public class ChunkCoordinates implements Comparable {
    public int posX;
    public int posY;
    public int posZ;

    public ChunkCoordinates() {
    }

    public ChunkCoordinates(int var1, int var2, int var3) {
        this.posX = var1;
        this.posY = var2;
        this.posZ = var3;
    }

    public ChunkCoordinates(ChunkCoordinates var1) {
        this.posX = var1.posX;
        this.posY = var1.posY;
        this.posZ = var1.posZ;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkCoordinates)) {
            return false;
        } else {
            ChunkCoordinates var2 = (ChunkCoordinates)var1;
            return this.posX == var2.posX && this.posY == var2.posY && this.posZ == var2.posZ;
        }
    }

    public int hashCode() {
        return this.posX + this.posZ << 8 + this.posY << 16;
    }

    public int compareChunkCoordinate(ChunkCoordinates var1) {
        if (this.posY == var1.posY) {
            return this.posZ == var1.posZ ? this.posX - var1.posX : this.posZ - var1.posZ;
        } else {
            return this.posY - var1.posY;
        }
    }

    public double getSqDistanceTo(int var1, int var2, int var3) {
        int var4 = this.posX - var1;
        int var5 = this.posY - var2;
        int var6 = this.posZ - var3;
        return Math.sqrt((double)(var4 * var4 + var5 * var5 + var6 * var6));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.compareChunkCoordinate((ChunkCoordinates)var1);
    }
}
