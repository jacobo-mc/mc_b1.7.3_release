package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet30Entity extends Packet {
    public int field_83_a;
    public byte field_82_b;
    public byte field_88_c;
    public byte field_87_d;
    public byte field_86_e;
    public byte field_85_f;
    public boolean field_84_g = false;

    public Packet30Entity() {
    }

    public Packet30Entity(int var1) {
        this.field_83_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_83_a = var1.readInt();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_83_a);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_30_a(this);
    }

    public int func_71_a() {
        return 4;
    }
}
