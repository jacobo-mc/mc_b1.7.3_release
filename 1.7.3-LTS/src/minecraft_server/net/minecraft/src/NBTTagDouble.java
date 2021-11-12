package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTBase {
    public double doubleValue;

    public NBTTagDouble() {
    }

    public NBTTagDouble(double var1) {
        this.doubleValue = var1;
    }

    void writeTagContents(DataOutput var1) throws IOException {
        var1.writeDouble(this.doubleValue);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.doubleValue = var1.readDouble();
    }

    public byte getType() {
        return 6;
    }

    public String toString() {
        return "" + this.doubleValue;
    }
}
