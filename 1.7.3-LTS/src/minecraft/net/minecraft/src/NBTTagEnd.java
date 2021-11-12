package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagEnd extends NBTBase {
    void readTagContents(DataInput var1) throws IOException {
    }

    void writeTagContents(DataOutput var1) throws IOException {
    }

    public byte getType() {
        return 0;
    }

    public String toString() {
        return "END";
    }
}
