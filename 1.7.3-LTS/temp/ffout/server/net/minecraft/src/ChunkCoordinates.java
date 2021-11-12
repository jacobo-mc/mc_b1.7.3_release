package net.minecraft.src;

public class ChunkCoordinates implements Comparable {
    public int field_22216_a;
    public int field_529_a;
    public int field_528_b;

    public ChunkCoordinates() {
    }

    public ChunkCoordinates(int var1, int var2, int var3) {
        this.field_22216_a = var1;
        this.field_529_a = var2;
        this.field_528_b = var3;
    }

    public ChunkCoordinates(ChunkCoordinates var1) {
        this.field_22216_a = var1.field_22216_a;
        this.field_529_a = var1.field_529_a;
        this.field_528_b = var1.field_528_b;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkCoordinates)) {
            return false;
        } else {
            ChunkCoordinates var2 = (ChunkCoordinates)var1;
            return this.field_22216_a == var2.field_22216_a && this.field_529_a == var2.field_529_a && this.field_528_b == var2.field_528_b;
        }
    }

    public int hashCode() {
        return this.field_22216_a + this.field_528_b << 8 + this.field_529_a << 16;
    }

    public int func_22215_a(ChunkCoordinates var1) {
        if (this.field_529_a == var1.field_529_a) {
            return this.field_528_b == var1.field_528_b ? this.field_22216_a - var1.field_22216_a : this.field_528_b - var1.field_528_b;
        } else {
            return this.field_529_a - var1.field_529_a;
        }
    }

    public double func_27127_a(int var1, int var2, int var3) {
        int var4 = this.field_22216_a - var1;
        int var5 = this.field_529_a - var2;
        int var6 = this.field_528_b - var3;
        return Math.sqrt((double)(var4 * var4 + var5 * var5 + var6 * var6));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public int compareTo(Object var1) {
        return this.func_22215_a((ChunkCoordinates)var1);
    }
}
