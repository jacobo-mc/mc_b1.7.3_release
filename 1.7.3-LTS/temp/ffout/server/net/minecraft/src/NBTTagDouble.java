package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTBase {
    public double field_735_a;

    public NBTTagDouble() {
    }

    public NBTTagDouble(double var1) {
        this.field_735_a = var1;
    }

    void func_381_a(DataOutput var1) throws IOException {
        var1.writeDouble(this.field_735_a);
    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_735_a = var1.readDouble();
    }

    public byte func_379_a() {
        return 6;
    }

    public String toString() {
        return "" + this.field_735_a;
    }
}
