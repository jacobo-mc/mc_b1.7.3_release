package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet1Login extends Packet {
    public int field_519_a;
    public String field_518_b;
    public long field_4074_d;
    public byte field_4073_e;

    public Packet1Login() {
    }

    public Packet1Login(String var1, int var2) {
        this.field_518_b = var1;
        this.field_519_a = var2;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_519_a = var1.readInt();
        this.field_518_b = func_27048_a(var1, 16);
        this.field_4074_d = var1.readLong();
        this.field_4073_e = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_519_a);
        func_27049_a(this.field_518_b, var1);
        var1.writeLong(this.field_4074_d);
        var1.writeByte(this.field_4073_e);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_4115_a(this);
    }

    public int func_329_a() {
        return 4 + this.field_518_b.length() + 4 + 5;
    }
}
