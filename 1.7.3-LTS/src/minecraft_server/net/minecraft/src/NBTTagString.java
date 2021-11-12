package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagString extends NBTBase {
    public String stringValue;

    public NBTTagString() {
    }

    public NBTTagString(String var1) {
        this.stringValue = var1;
        if (var1 == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    void writeTagContents(DataOutput var1) throws IOException {
        var1.writeUTF(this.stringValue);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.stringValue = var1.readUTF();
    }

    public byte getType() {
        return 8;
    }

    public String toString() {
        return "" + this.stringValue;
    }
}
