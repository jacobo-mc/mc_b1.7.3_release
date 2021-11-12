package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet105UpdateProgressbar extends Packet {
    public int field_20030_a;
    public int field_20029_b;
    public int field_20031_c;

    public Packet105UpdateProgressbar() {
    }

    public Packet105UpdateProgressbar(int var1, int var2, int var3) {
        this.field_20030_a = var1;
        this.field_20029_b = var2;
        this.field_20031_c = var3;
    }

    public void func_72_a(NetHandler var1) {
        var1.func_20002_a(this);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_20030_a = var1.readByte();
        this.field_20029_b = var1.readShort();
        this.field_20031_c = var1.readShort();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20030_a);
        var1.writeShort(this.field_20029_b);
        var1.writeShort(this.field_20031_c);
    }

    public int func_71_a() {
        return 5;
    }
}
