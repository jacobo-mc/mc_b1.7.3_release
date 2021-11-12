package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagInt extends NBTBase {
    public int field_1093_a;

    public NBTTagInt() {
    }

    public NBTTagInt(int var1) {
        this.field_1093_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeInt(this.field_1093_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1093_a = var1.readInt();
    }

    public byte func_733_a() {
        return 3;
    }

    public String toString() {
        return "" + this.field_1093_a;
    }
}
