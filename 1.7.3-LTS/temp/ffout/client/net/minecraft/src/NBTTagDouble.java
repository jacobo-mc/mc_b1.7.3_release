package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTBase {
    public double field_1089_a;

    public NBTTagDouble() {
    }

    public NBTTagDouble(double var1) {
        this.field_1089_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeDouble(this.field_1089_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1089_a = var1.readDouble();
    }

    public byte func_733_a() {
        return 6;
    }

    public String toString() {
        return "" + this.field_1089_a;
    }
}
