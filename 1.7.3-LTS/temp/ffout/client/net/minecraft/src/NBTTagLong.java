package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagLong extends NBTBase {
    public long field_1095_a;

    public NBTTagLong() {
    }

    public NBTTagLong(long var1) {
        this.field_1095_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeLong(this.field_1095_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1095_a = var1.readLong();
    }

    public byte func_733_a() {
        return 4;
    }

    public String toString() {
        return "" + this.field_1095_a;
    }
}
