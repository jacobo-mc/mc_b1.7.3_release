package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagFloat extends NBTBase {
    public float field_1097_a;

    public NBTTagFloat() {
    }

    public NBTTagFloat(float var1) {
        this.field_1097_a = var1;
    }

    void func_735_a(DataOutput var1) throws IOException {
        var1.writeFloat(this.field_1097_a);
    }

    void func_736_a(DataInput var1) throws IOException {
        this.field_1097_a = var1.readFloat();
    }

    public byte func_733_a() {
        return 5;
    }

    public String toString() {
        return "" + this.field_1097_a;
    }
}
