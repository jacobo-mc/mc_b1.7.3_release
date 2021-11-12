package net.minecraft.src;

public class ChunkPosition {
    public final int field_846_a;
    public final int field_845_b;
    public final int field_847_c;

    public ChunkPosition(int var1, int var2, int var3) {
        this.field_846_a = var1;
        this.field_845_b = var2;
        this.field_847_c = var3;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkPosition)) {
            return false;
        } else {
            ChunkPosition var2 = (ChunkPosition)var1;
            return var2.field_846_a == this.field_846_a && var2.field_845_b == this.field_845_b && var2.field_847_c == this.field_847_c;
        }
    }

    public int hashCode() {
        return this.field_846_a * 8976890 + this.field_845_b * 981131 + this.field_847_c;
    }
}
