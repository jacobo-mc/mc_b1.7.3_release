package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet105UpdateProgressbar extends Packet {
    public int field_20032_a;
    public int field_20031_b;
    public int field_20033_c;

    public void func_323_a(NetHandler var1) {
        var1.func_20090_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20032_a = var1.readByte();
        this.field_20031_b = var1.readShort();
        this.field_20033_c = var1.readShort();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20032_a);
        var1.writeShort(this.field_20031_b);
        var1.writeShort(this.field_20033_c);
    }

    public int func_329_a() {
        return 5;
    }
}
