package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Packet51MapChunk extends Packet {
    public int field_106_a;
    public int field_105_b;
    public int field_112_c;
    public int field_111_d;
    public int field_110_e;
    public int field_109_f;
    public byte[] field_108_g;
    private int field_107_h;

    public Packet51MapChunk() {
        this.field_40_j = true;
    }

    public Packet51MapChunk(int var1, int var2, int var3, int var4, int var5, int var6, World var7) {
        this.field_40_j = true;
        this.field_106_a = var1;
        this.field_105_b = var2;
        this.field_112_c = var3;
        this.field_111_d = var4;
        this.field_110_e = var5;
        this.field_109_f = var6;
        byte[] var8 = var7.func_504_c(var1, var2, var3, var4, var5, var6);
        Deflater var9 = new Deflater(-1);

        try {
            var9.setInput(var8);
            var9.finish();
            this.field_108_g = new byte[var4 * var5 * var6 * 5 / 2];
            this.field_107_h = var9.deflate(this.field_108_g);
        } finally {
            var9.end();
        }

    }

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_106_a = var1.readInt();
        this.field_105_b = var1.readShort();
        this.field_112_c = var1.readInt();
        this.field_111_d = var1.read() + 1;
        this.field_110_e = var1.read() + 1;
        this.field_109_f = var1.read() + 1;
        this.field_107_h = var1.readInt();
        byte[] var2 = new byte[this.field_107_h];
        var1.readFully(var2);
        this.field_108_g = new byte[this.field_111_d * this.field_110_e * this.field_109_f * 5 / 2];
        Inflater var3 = new Inflater();
        var3.setInput(var2);

        try {
            var3.inflate(this.field_108_g);
        } catch (DataFormatException var8) {
            throw new IOException("Bad compressed data format");
        } finally {
            var3.end();
        }

    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_106_a);
        var1.writeShort(this.field_105_b);
        var1.writeInt(this.field_112_c);
        var1.write(this.field_111_d - 1);
        var1.write(this.field_110_e - 1);
        var1.write(this.field_109_f - 1);
        var1.writeInt(this.field_107_h);
        var1.write(this.field_108_g, 0, this.field_107_h);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_4_a(this);
    }

    public int func_71_a() {
        return 17 + this.field_107_h;
    }
}
