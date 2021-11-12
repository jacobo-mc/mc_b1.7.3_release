package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet30Entity extends Packet {
    public int field_485_a;
    public byte field_484_b;
    public byte field_490_c;
    public byte field_489_d;
    public byte field_488_e;
    public byte field_487_f;
    public boolean field_486_g = false;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_485_a = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_485_a);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_827_a(this);
    }

    public int func_329_a() {
        return 4;
    }
}
