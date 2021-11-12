package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet14BlockDig extends Packet {
    public int field_54_a;
    public int field_53_b;
    public int field_57_c;
    public int field_56_d;
    public int field_55_e;

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_55_e = var1.read();
        this.field_54_a = var1.readInt();
        this.field_53_b = var1.read();
        this.field_57_c = var1.readInt();
        this.field_56_d = var1.read();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.write(this.field_55_e);
        var1.writeInt(this.field_54_a);
        var1.write(this.field_53_b);
        var1.writeInt(this.field_57_c);
        var1.write(this.field_56_d);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_26_a(this);
    }

    public int func_71_a() {
        return 11;
    }
}
