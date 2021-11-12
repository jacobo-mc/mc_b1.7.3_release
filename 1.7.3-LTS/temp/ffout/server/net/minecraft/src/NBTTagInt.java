package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagInt extends NBTBase {
    public int field_742_a;

    public NBTTagInt() {
    }

    public NBTTagInt(int var1) {
        this.field_742_a = var1;
    }

    void func_381_a(DataOutput var1) throws IOException {
        var1.writeInt(this.field_742_a);
    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_742_a = var1.readInt();
    }

    public byte func_379_a() {
        return 3;
    }

    public String toString() {
        return "" + this.field_742_a;
    }
}
