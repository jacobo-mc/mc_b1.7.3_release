package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet4UpdateTime extends Packet {
    public long field_564_a;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_564_a = var1.readLong();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeLong(this.field_564_a);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_846_a(this);
    }

    public int func_329_a() {
        return 8;
    }
}
