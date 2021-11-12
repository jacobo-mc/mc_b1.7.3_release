package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet50PreChunk extends Packet {
    public int field_505_a;
    public int field_504_b;
    public boolean field_506_c;

    public Packet50PreChunk() {
        this.field_472_j = false;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_505_a = var1.readInt();
        this.field_504_b = var1.readInt();
        this.field_506_c = var1.read() != 0;
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_505_a);
        var1.writeInt(this.field_504_b);
        var1.write(this.field_506_c ? 1 : 0);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_826_a(this);
    }

    public int func_329_a() {
        return 9;
    }
}
