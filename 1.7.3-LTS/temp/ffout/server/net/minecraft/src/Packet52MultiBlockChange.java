package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet52MultiBlockChange extends Packet {
    public int field_48_a;
    public int field_47_b;
    public short[] field_52_c;
    public byte[] field_51_d;
    public byte[] field_50_e;
    public int field_49_f;

    public Packet52MultiBlockChange() {
        this.field_40_j = true;
    }

    public Packet52MultiBlockChange(int var1, int var2, short[] var3, int var4, World var5) {
        this.field_40_j = true;
        this.field_48_a = var1;
        this.field_47_b = var2;
        this.field_49_f = var4;
        this.field_52_c = new short[var4];
        this.field_51_d = new byte[var4];
        this.field_50_e = new byte[var4];
        Chunk var6 = var5.func_525_b(var1, var2);

        for(int var7 = 0; var7 < var4; ++var7) {
            int var8 = var3[var7] >> 12 & 15;
            int var9 = var3[var7] >> 8 & 15;
            int var10 = var3[var7] & 255;
            this.field_52_c[var7] = var3[var7];
            this.field_51_d[var7] = (byte)var6.func_344_a(var8, var10, var9);
            this.field_50_e[var7] = (byte)var6.func_356_b(var8, var10, var9);
        }

    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_48_a = var1.readInt();
        this.field_47_b = var1.readInt();
        this.field_49_f = var1.readShort() & '\uffff';
        this.field_52_c = new short[this.field_49_f];
        this.field_51_d = new byte[this.field_49_f];
        this.field_50_e = new byte[this.field_49_f];

        for(int var2 = 0; var2 < this.field_49_f; ++var2) {
            this.field_52_c[var2] = var1.readShort();
        }

        var1.readFully(this.field_51_d);
        var1.readFully(this.field_50_e);
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_48_a);
        var1.writeInt(this.field_47_b);
        var1.writeShort((short)this.field_49_f);

        for(int var2 = 0; var2 < this.field_49_f; ++var2) {
            var1.writeShort(this.field_52_c[var2]);
        }

        var1.write(this.field_51_d);
        var1.write(this.field_50_e);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_13_a(this);
    }

    public int func_71_a() {
        return 10 + this.field_49_f * 4;
    }
}
