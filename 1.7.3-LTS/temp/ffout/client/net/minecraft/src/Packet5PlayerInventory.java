package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet5PlayerInventory extends Packet {
    public int field_571_a;
    public int field_21056_b;
    public int field_570_b;
    public int field_20044_c;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_571_a = var1.readInt();
        this.field_21056_b = var1.readShort();
        this.field_570_b = var1.readShort();
        this.field_20044_c = var1.readShort();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_571_a);
        var1.writeShort(this.field_21056_b);
        var1.writeShort(this.field_570_b);
        var1.writeShort(this.field_20044_c);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_843_a(this);
    }

    public int func_329_a() {
        return 8;
    }
}
