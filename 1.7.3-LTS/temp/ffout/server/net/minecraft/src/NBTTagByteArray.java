package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByteArray extends NBTBase {
    public byte[] field_733_a;

    public NBTTagByteArray() {
    }

    public NBTTagByteArray(byte[] var1) {
        this.field_733_a = var1;
    }

    void func_381_a(DataOutput var1) throws IOException {
        var1.writeInt(this.field_733_a.length);
        var1.write(this.field_733_a);
    }

    void func_382_a(DataInput var1) throws IOException {
        int var2 = var1.readInt();
        this.field_733_a = new byte[var2];
        var1.readFully(this.field_733_a);
    }

    public byte func_379_a() {
        return 7;
    }

    public String toString() {
        return "[" + this.field_733_a.length + " bytes]";
    }
}
