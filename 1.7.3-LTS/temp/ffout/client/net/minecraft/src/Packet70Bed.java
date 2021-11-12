package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet70Bed extends Packet {
    public static final String[] field_25020_a = new String[]{"tile.bed.notValid", null, null};
    public int field_25019_b;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_25019_b = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeByte(this.field_25019_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_25118_a(this);
    }

    public int func_329_a() {
        return 1;
    }
}
