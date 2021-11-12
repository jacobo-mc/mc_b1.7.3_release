package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagFloat extends NBTBase {
    public float field_739_a;

    public NBTTagFloat() {
    }

    public NBTTagFloat(float var1) {
        this.field_739_a = var1;
    }

    void func_381_a(DataOutput var1) throws IOException {
        var1.writeFloat(this.field_739_a);
    }

    void func_382_a(DataInput var1) throws IOException {
        this.field_739_a = var1.readFloat();
    }

    public byte func_379_a() {
        return 5;
    }

    public String toString() {
        return "" + this.field_739_a;
    }
}
