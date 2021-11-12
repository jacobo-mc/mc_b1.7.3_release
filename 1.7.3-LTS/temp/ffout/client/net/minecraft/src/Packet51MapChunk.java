package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Packet51MapChunk extends Packet {
    public int field_573_a;
    public int field_572_b;
    public int field_579_c;
    public int field_578_d;
    public int field_577_e;
    public int field_576_f;
    public byte[] field_575_g;
    private int field_574_h;

    public Packet51MapChunk() {
        this.field_472_j = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_573_a = var1.readInt();
        this.field_572_b = var1.readShort();
        this.field_579_c = var1.readInt();
        this.field_578_d = var1.read() + 1;
        this.field_577_e = var1.read() + 1;
        this.field_576_f = var1.read() + 1;
        this.field_574_h = var1.readInt();
        byte[] var2 = new byte[this.field_574_h];
        var1.readFully(var2);
        this.field_575_g = new byte[this.field_578_d * this.field_577_e * this.field_576_f * 5 / 2];
        Inflater var3 = new Inflater();
        var3.setInput(var2);

        try {
            var3.inflate(this.field_575_g);
        } catch (DataFormatException var8) {
            throw new IOException("Bad compressed data format");
        } finally {
            var3.end();
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_573_a);
        var1.writeShort(this.field_572_b);
        var1.writeInt(this.field_579_c);
        var1.write(this.field_578_d - 1);
        var1.write(this.field_577_e - 1);
        var1.write(this.field_576_f - 1);
        var1.writeInt(this.field_574_h);
        var1.write(this.field_575_g, 0, this.field_574_h);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_833_a(this);
    }

    public int func_329_a() {
        return 17 + this.field_574_h;
    }
}
