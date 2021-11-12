package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByte extends NBTBase {
    public byte field_741_a;

    public NBTTagByte() {
    }

    public NBTTagByte(byte var1) {
        this.field_741_a = var1;
    }

    void func_381_a(DataOutput var1) throws IOException {
        var1.writeByte(this.field_741_a);
    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_741_a = var1.readByte();
    }

    public byte func_379_a() {
        return 1;
    }

    public String toString() {
        return "" + this.field_741_a;
    }
}
