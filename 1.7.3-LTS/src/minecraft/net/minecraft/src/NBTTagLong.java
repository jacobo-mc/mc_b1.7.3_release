package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagLong extends NBTBase {
    public long longValue;

    public NBTTagLong() {
    }

    public NBTTagLong(long var1) {
        this.longValue = var1;
    }

    void writeTagContents(DataOutput var1) throws IOException {
        var1.writeLong(this.longValue);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.longValue = var1.readLong();
    }

    public byte getType() {
        return 4;
    }

    public String toString() {
        return "" + this.longValue;
    }
}
