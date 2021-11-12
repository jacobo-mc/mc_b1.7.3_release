package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet100OpenWindow extends Packet {
    public int field_20013_a;
    public int field_20012_b;
    public String field_20015_c;
    public int field_20014_d;

    public Packet100OpenWindow() {
    }

    public Packet100OpenWindow(int var1, int var2, String var3, int var4) {
        this.field_20013_a = var1;
        this.field_20012_b = var2;
        this.field_20015_c = var3;
        this.field_20014_d = var4;
    }

    public void func_72_a(NetHandler var1) {
        var1.func_20004_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_20013_a = var1.readByte();
        this.field_20012_b = var1.readByte();
        this.field_20015_c = var1.readUTF();
        this.field_20014_d = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20013_a);
        var1.writeByte(this.field_20012_b);
        var1.writeUTF(this.field_20015_c);
        var1.writeByte(this.field_20014_d);
    }

    public int func_71_a() {
        return 3 + this.field_20015_c.length();
    }
}
