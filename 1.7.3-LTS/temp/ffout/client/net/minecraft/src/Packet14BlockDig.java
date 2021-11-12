package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet14BlockDig extends Packet {
    public int field_542_a;
    public int field_541_b;
    public int field_545_c;
    public int field_544_d;
    public int field_543_e;

    public Packet14BlockDig() {
    }

    public Packet14BlockDig(int var1, int var2, int var3, int var4, int var5) {
        this.field_543_e = var1;
        this.field_542_a = var2;
        this.field_541_b = var3;
        this.field_545_c = var4;
        this.field_544_d = var5;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_543_e = var1.read();
        this.field_542_a = var1.readInt();
        this.field_541_b = var1.read();
        this.field_545_c = var1.readInt();
        this.field_544_d = var1.read();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.write(this.field_543_e);
        var1.writeInt(this.field_542_a);
        var1.write(this.field_541_b);
        var1.writeInt(this.field_545_c);
        var1.write(this.field_544_d);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_821_a(this);
    }

    public int func_329_a() {
        return 11;
    }
}
