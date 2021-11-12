package net.minecraft.src;

public class ChunkPosition {
    public final int x;
    public final int y;
    public final int z;

    public ChunkPosition(int var1, int var2, int var3) {
        this.x = var1;
        this.y = var2;
        this.z = var3;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof ChunkPosition)) {
            return false;
        } else {
            ChunkPosition var2 = (ChunkPosition)var1;
            return var2.x == this.x && var2.y == this.y && var2.z == this.z;
        }
    }

    public int hashCode() {
        return this.x * 8976890 + this.y * 981131 + this.z;
    }
}
