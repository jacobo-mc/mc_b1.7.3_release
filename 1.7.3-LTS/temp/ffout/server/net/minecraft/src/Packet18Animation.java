package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet18Animation extends Packet {
    public int field_120_a;
    public int field_119_b;

    public Packet18Animation() {
    }

    public Packet18Animation(Entity var1, int var2) {
        this.field_120_a = var1.field_331_c;
        this.field_119_b = var2;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_120_a = var1.readInt();
        this.field_119_b = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_120_a);
        var1.writeByte(this.field_119_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_3_a(this);
    }

    public int func_71_a() {
        return 5;
    }
}
