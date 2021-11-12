package net.minecraft.src;

public class ChunkCoordIntPair {
    public final int field_152_a;
    public final int field_151_b;

    public ChunkCoordIntPair(int var1, int var2) {
        this.field_152_a = var1;
        this.field_151_b = var2;
    }

    public static int func_22006_a(int var0, int var1) {
        return (var0 < 0 ? Integer.MIN_VALUE : 0) | (var0 & 32767) << 16 | (var1 < 0 ? '\u8000' : 0) | var1 & 32767;
    }

    public int hashCode() {
        return func_22006_a(this.field_152_a, this.field_151_b);
    }

    public boolean equals(Object var1) {
        ChunkCoordIntPair var2 = (ChunkCoordIntPair)var1;
        return var2.field_152_a == this.field_152_a && var2.field_151_b == this.field_151_b;
    }
}
