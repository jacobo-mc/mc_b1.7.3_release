package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByte extends NBTBase {
    public byte field_1092_a;

    public NBTTagByte() {
    }

    public NBTTagByte(byte var1) {
        this.field_1092_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeByte(this.field_1092_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1092_a = var1.readByte();
    }

    public byte func_733_a() {
        return 1;
    }

    public String toString() {
        return "" + this.field_1092_a;
    }
}
