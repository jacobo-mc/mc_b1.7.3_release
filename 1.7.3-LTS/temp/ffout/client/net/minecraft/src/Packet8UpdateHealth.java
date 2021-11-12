package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet8UpdateHealth extends Packet {
    public int field_9275_a;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_9275_a = var1.readShort();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_9275_a);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_9446_a(this);
    }

    public int func_329_a() {
        return 2;
    }
}
