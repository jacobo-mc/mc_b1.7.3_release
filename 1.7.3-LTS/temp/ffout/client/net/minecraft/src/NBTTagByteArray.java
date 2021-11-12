package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByteArray extends NBTBase {
    public byte[] field_1096_a;

    public NBTTagByteArray() {
    }

    public NBTTagByteArray(byte[] var1) {
        this.field_1096_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeInt(this.field_1096_a.length);
        var1.write(this.field_1096_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        int var2 = var1.readInt();
        this.field_1096_a = new byte[var2];
        var1.readFully(this.field_1096_a);
    }

    public byte func_733_a() {
        return 7;
    }

    public String toString() {
        return "[" + this.field_1096_a.length + " bytes]";
    }
}
