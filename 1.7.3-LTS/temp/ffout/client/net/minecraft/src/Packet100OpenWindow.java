package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet100OpenWindow extends Packet {
    public int field_20038_a;
    public int field_20037_b;
    public String field_20040_c;
    public int field_20039_d;

    public void func_323_a(NetHandler var1) {
        var1.func_20087_a(this);
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_20038_a = var1.readByte();
        this.field_20037_b = var1.readByte();
        this.field_20040_c = var1.readUTF();
        this.field_20039_d = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_20038_a);
        var1.writeByte(this.field_20037_b);
        var1.writeUTF(this.field_20040_c);
        var1.writeByte(this.field_20039_d);
    }

    public int func_329_a() {
        return 3 + this.field_20040_c.length();
    }
}
