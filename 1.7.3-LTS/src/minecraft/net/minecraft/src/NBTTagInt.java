package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagInt extends NBTBase {
    public int intValue;

    public NBTTagInt() {
    }

    public NBTTagInt(int var1) {
        this.intValue = var1;
    }

    void writeTagContents(DataOutput var1) throws IOException {
        var1.writeInt(this.intValue);
    }

    void readTagContents(DataInput var1) throws IOException {
        this.intValue = var1.readInt();
    }

    public byte getType() {
        return 3;
    }

    public String toString() {
        return "" + this.intValue;
    }
}
