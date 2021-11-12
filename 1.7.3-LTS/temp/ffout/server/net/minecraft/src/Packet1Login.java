package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet1Login extends Packet {
    public int field_4024_a;
    public String field_113_b;
    public long field_4026_d;
    public byte field_4025_e;

    public Packet1Login() {
    }

    public Packet1Login(String var1, int var2, long var3, byte var5) {
        this.field_113_b = var1;
        this.field_4024_a = var2;
        this.field_4026_d = var3;
        this.field_4025_e = var5;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_4024_a = var1.readInt();
        this.field_113_b = func_27037_a(var1, 16);
        this.field_4026_d = var1.readLong();
        this.field_4025_e = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_4024_a);
        func_27038_a(this.field_113_b, var1);
        var1.writeLong(this.field_4026_d);
        var1.writeByte(this.field_4025_e);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4001_a(this);
    }

    public int func_71_a() {
        return 4 + this.field_113_b.length() + 4 + 5;
    }
}
