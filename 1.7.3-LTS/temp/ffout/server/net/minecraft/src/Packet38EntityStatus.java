package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet38EntityStatus extends Packet {
    public int field_9016_a;
    public byte field_9015_b;

    public Packet38EntityStatus() {
    }

    public Packet38EntityStatus(int var1, byte var2) {
        this.field_9016_a = var1;
        this.field_9015_b = var2;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_9016_a = var1.readInt();
        this.field_9015_b = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_9016_a);
        var1.writeByte(this.field_9015_b);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_9001_a(this);
    }

    public int func_71_a() {
        return 5;
    }
}
