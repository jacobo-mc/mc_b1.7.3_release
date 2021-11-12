package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet106Transaction extends Packet {
    public int field_20029_a;
    public short field_20028_b;
    public boolean field_20030_c;

    public Packet106Transaction() {
    }

    public Packet106Transaction(int var1, short var2, boolean var3) {
        this.field_20029_a = var1;
        this.field_20028_b = var2;
        this.field_20030_c = var3;
    }

    public void func_323_a(NetHandler var1) {
        var1.func_20089_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20029_a = var1.readByte();
        this.field_20028_b = var1.readShort();
        this.field_20030_c = var1.readByte() != 0;
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20029_a);
        var1.writeShort(this.field_20028_b);
        var1.writeByte(this.field_20030_c ? 1 : 0);
    }

    public int func_329_a() {
        return 4;
    }
}
