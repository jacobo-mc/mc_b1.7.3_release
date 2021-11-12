package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagString extends NBTBase {
    public String field_732_a;

    public NBTTagString() {
    }

    public NBTTagString(String var1) {
        this.field_732_a = var1;
        if (var1 == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    void func_381_a(DataOutput var1) throws IOException {
        var1.writeUTF(this.field_732_a);
    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_732_a = var1.readUTF();
    }

    public byte func_379_a() {
        return 8;
    }

    public String toString() {
        return "" + this.field_732_a;
    }
}
