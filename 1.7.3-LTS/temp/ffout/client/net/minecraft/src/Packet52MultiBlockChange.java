package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet52MultiBlockChange extends Packet {
    public int field_479_a;
    public int field_478_b;
    public short[] field_483_c;
    public byte[] field_482_d;
    public byte[] field_481_e;
    public int field_480_f;

    public Packet52MultiBlockChange() {
        this.field_472_j = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_479_a = var1.readInt();
        this.field_478_b = var1.readInt();
        this.field_480_f = var1.readShort() & '\uffff';
        this.field_483_c = new short[this.field_480_f];
        this.field_482_d = new byte[this.field_480_f];
        this.field_481_e = new byte[this.field_480_f];

        for(int var2 = 0; var2 < this.field_480_f; ++var2) {
            this.field_483_c[var2] = var1.readShort();
        }

        var1.readFully(this.field_482_d);
        var1.readFully(this.field_481_e);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_479_a);
        var1.writeInt(this.field_478_b);
        var1.writeShort((short)this.field_480_f);

        for(int var2 = 0; var2 < this.field_480_f; ++var2) {
            var1.writeShort(this.field_483_c[var2]);
        }

        var1.write(this.field_482_d);
        var1.write(this.field_481_e);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_824_a(this);
    }

    public int func_329_a() {
        return 10 + this.field_480_f * 4;
    }
}
