package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet255KickDisconnect extends Packet {
    public String field_41_a;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String var1) {
        this.field_41_a = var1;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_41_a = func_27037_a(var1, 100);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        func_27038_a(this.field_41_a, var1);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4009_a(this);
    }

    public int func_71_a() {
        return this.field_41_a.length();
    }
}
