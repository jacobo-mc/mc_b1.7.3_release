package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet9Respawn extends Packet {
    public byte field_28045_a;

    public Packet9Respawn() {
    }

    public Packet9Respawn(byte var1) {
        this.field_28045_a = var1;
    }

    public void func_72_a(NetHandler var1) {
        var1.func_9002_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_28045_a = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_28045_a);
    }

    public int func_71_a() {
        return 1;
    }
}
