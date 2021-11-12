package net.minecraft.src;

public class ChunkPosition {
    public final int field_1111_a;
    public final int field_1110_b;
    public final int field_1112_c;

    public ChunkPosition(int var1, int var2, int var3) {
        this.field_1111_a = var1;
        this.field_1110_b = var2;
        this.field_1112_c = var3;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkPosition)) {
            return false;
        } else {
            ChunkPosition var2 = (ChunkPosition)var1;
            return var2.field_1111_a == this.field_1111_a && var2.field_1110_b == this.field_1110_b && var2.field_1112_c == this.field_1112_c;
        }
    }

    public int hashCode() {
        return this.field_1111_a * 8976890 + this.field_1110_b * 981131 + this.field_1112_c;
    }
}
