package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet53BlockChange extends Packet {
    public int field_492_a;
    public int field_491_b;
    public int field_495_c;
    public int field_494_d;
    public int field_493_e;

    public Packet53BlockChange() {
        this.field_472_j = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_492_a = var1.readInt();
        this.field_491_b = var1.read();
        this.field_495_c = var1.readInt();
        this.field_494_d = var1.read();
        this.field_493_e = var1.read();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_492_a);
        var1.write(this.field_491_b);
        var1.writeInt(this.field_495_c);
        var1.write(this.field_494_d);
        var1.write(this.field_493_e);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_822_a(this);
    }

    public int func_329_a() {
        return 11;
    }
}
