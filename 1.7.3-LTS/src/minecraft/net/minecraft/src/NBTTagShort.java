package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagShort extends NBTBase {
    public short shortValue;

    public NBTTagShort() {
    }

    public NBTTagShort(short var1) {
        this.shortValue = var1;
    }

    void writeTagContents(DataOutput var1) throws IOException {
        var1.writeShort(this.shortValue);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.shortValue = var1.readShort();
    }

    public byte getType() {
        return 2;
    }

    public String toString() {
        return "" + this.shortValue;
    }
}
