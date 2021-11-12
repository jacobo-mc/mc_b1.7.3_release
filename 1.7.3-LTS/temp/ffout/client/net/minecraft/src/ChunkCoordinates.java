package net.minecraft.src;

public class ChunkCoordinates implements Comparable {
    public int field_22395_a;
    public int field_22394_b;
    public int field_22396_c;

    public ChunkCoordinates() {
    }

    public ChunkCoordinates(int var1, int var2, int var3) {
        this.field_22395_a = var1;
        this.field_22394_b = var2;
        this.field_22396_c = var3;
    }

    public ChunkCoordinates(ChunkCoordinates var1) {
        this.field_22395_a = var1.field_22395_a;
        this.field_22394_b = var1.field_22394_b;
        this.field_22396_c = var1.field_22396_c;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkCoordinates)) {
            return false;
        } else {
            ChunkCoordinates var2 = (ChunkCoordinates)var1;
            return this.field_22395_a == var2.field_22395_a && this.field_22394_b == var2.field_22394_b && this.field_22396_c == var2.field_22396_c;
        }
    }

    public int hashCode() {
        return this.field_22395_a + this.field_22396_c << 8 + this.field_22394_b << 16;
    }

    public int func_22393_a(ChunkCoordinates var1) {
        if (this.field_22394_b == var1.field_22394_b) {
            return this.field_22396_c == var1.field_22396_c ? this.field_22395_a - var1.field_22395_a : this.field_22396_c - var1.field_22396_c;
        } else {
            return this.field_22394_b - var1.field_22394_b;
        }
    }

    public double func_27439_a(int var1, int var2, int var3) {
        int var4 = this.field_22395_a - var1;
        int var5 = this.field_22394_b - var2;
        int var6 = this.field_22396_c - var3;
        return Math.sqrt((double)(var4 * var4 + var5 * var5 + var6 * var6));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_22393_a((ChunkCoordinates)var1);
    }
}
