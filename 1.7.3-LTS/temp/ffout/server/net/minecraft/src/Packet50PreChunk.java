package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet50PreChunk extends Packet {
    public int field_103_a;
    public int field_102_b;
    public boolean field_104_c;

    public Packet50PreChunk() {
        this.field_40_j = false;
    }

    public Packet50PreChunk(int var1, int var2, boolean var3) {
        this.field_40_j = false;
        this.field_103_a = var1;
        this.field_102_b = var2;
        this.field_104_c = var3;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_103_a = var1.readInt();
        this.field_102_b = var1.readInt();
        this.field_104_c = var1.read() != 0;
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_103_a);
        var1.writeInt(this.field_102_b);
        var1.write(this.field_104_c ? 1 : 0);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_29_a(this);
    }

    public int func_71_a() {
        return 9;
    }
}
