package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagShort extends NBTBase {
    public short field_1088_a;

    public NBTTagShort() {
    }

    public NBTTagShort(short var1) {
        this.field_1088_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeShort(this.field_1088_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1088_a = var1.readShort();
    }

    public byte func_733_a() {
        return 2;
    }

    public String toString() {
        return "" + this.field_1088_a;
    }
}
