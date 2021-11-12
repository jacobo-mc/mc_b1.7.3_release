package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet130UpdateSign extends Packet {
    public int field_20020_a;
    public int field_20019_b;
    public int field_20022_c;
    public String[] field_20021_d;

    public Packet130UpdateSign() {
        this.field_40_j = true;
    }

    public Packet130UpdateSign(int var1, int var2, int var3, String[] var4) {
        this.field_40_j = true;
        this.field_20020_a = var1;
        this.field_20019_b = var2;
        this.field_20022_c = var3;
        this.field_20021_d = var4;
    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_20020_a = var1.readInt();
        this.field_20019_b = var1.readShort();
        this.field_20022_c = var1.readInt();
        this.field_20021_d = new String[4];

        for(int var2 = 0; var2 < 4; ++var2) {
            this.field_20021_d[var2] = func_27037_a(var1, 15);
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_20020_a);
        var1.writeShort(this.field_20019_b);
        var1.writeInt(this.field_20022_c);

        for(int var2 = 0; var2 < 4; ++var2) {
            func_27038_a(this.field_20021_d[var2], var1);
        }

    }

    public void func_72_a(NetHandler var1) {
        var1.func_20005_a(this);
    }

    public int func_71_a() {
        int var1 = 0;

        for(int var2 = 0; var2 < 4; ++var2) {
            var1 += this.field_20021_d[var2].length();
        }

        return var1;
    }
}
