package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet22Collect extends Packet {
    public int field_137_a;
    public int field_136_b;

    public Packet22Collect() {
    }

    public Packet22Collect(int var1, int var2) {
        this.field_137_a = var1;
        this.field_136_b = var2;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_137_a = var1.readInt();
        this.field_136_b = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_137_a);
        var1.writeInt(this.field_136_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_28_a(this);
    }

    public int func_71_a() {
        return 8;
    }
}
