package net.minecraft.src;

public class ChunkCoordinates implements Comparable {
    public int x;
    public int y;
    public int z;

    public ChunkCoordinates() {
    }

    public ChunkCoordinates(int var1, int var2, int var3) {
        this.x = var1;
        this.y = var2;
        this.z = var3;
    }

    public ChunkCoordinates(ChunkCoordinates var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkCoordinates)) {
            return false;
        } else {
            ChunkCoordinates var2 = (ChunkCoordinates)var1;
            return this.x == var2.x && this.y == var2.y && this.z == var2.z;
        }
    }

    public int hashCode() {
        return this.x + this.z << 8 + this.y << 16;
    }

    public int compareChunkCoordinate(ChunkCoordinates var1) {
        if (this.y == var1.y) {
            return this.z == var1.z ? this.x - var1.x : this.z - var1.z;
        } else {
            return this.y - var1.y;
        }
    }

    public double getSqDistanceTo(int var1, int var2, int var3) {
        int var4 = this.x - var1;
        int var5 = this.y - var2;
        int var6 = this.z - var3;
        return Math.sqrt((double)(var4 * var4 + var5 * var5 + var6 * var6));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.compareChunkCoordinate((ChunkCoordinates)var1);
    }
}
