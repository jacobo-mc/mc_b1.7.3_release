package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByte extends NBTBase {
    public byte byteValue;

    public NBTTagByte() {
    }

    public NBTTagByte(byte var1) {
        this.byteValue = var1;
    }

    void writeTagContents(DataOutput var1) throws IOException {
        var1.writeByte(this.byteValue);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.byteValue = var1.readByte();
    }

    public byte getType() {
        return 1;
    }

    public String toString() {
        return "" + this.byteValue;
    }
}
