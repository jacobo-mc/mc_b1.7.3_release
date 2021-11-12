package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet53BlockChange extends Packet {
    public int field_90_a;
    public int field_89_b;
    public int field_93_c;
    public int field_92_d;
    public int field_91_e;

    public Packet53BlockChange() {
        this.field_40_j = true;
    }

    public Packet53BlockChange(int var1, int var2, int var3, World var4) {
        this.field_40_j = true;
        this.field_90_a = var1;
        this.field_89_b = var2;
        this.field_93_c = var3;
        this.field_92_d = var4.func_444_a(var1, var2, var3);
        this.field_91_e = var4.func_446_b(var1, var2, var3);
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_90_a = var1.readInt();
        this.field_89_b = var1.read();
        this.field_93_c = var1.readInt();
        this.field_92_d = var1.read();
        this.field_91_e = var1.read();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_90_a);
        var1.write(this.field_89_b);
        var1.writeInt(this.field_93_c);
        var1.write(this.field_92_d);
        var1.write(this.field_91_e);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_12_a(this);
    }

    public int func_71_a() {
        return 11;
    }
}
