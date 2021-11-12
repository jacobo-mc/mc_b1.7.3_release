package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet2Handshake extends Packet {
    public String field_141_a;

    public Packet2Handshake() {
    }

    public Packet2Handshake(String var1) {
        this.field_141_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_141_a = func_27037_a(var1, 32);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        func_27038_a(this.field_141_a, var1);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_6004_a(this);
    }

    public int func_71_a() {
        return 4 + this.field_141_a.length() + 4;
    }
}
