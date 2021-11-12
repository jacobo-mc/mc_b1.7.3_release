package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn extends Packet {
    public int field_500_a;
    public int field_499_b;
    public int field_503_c;
    public int field_502_d;
    public int field_28047_e;
    public int field_28046_f;
    public int field_28045_g;
    public int field_501_e;
    public int field_28044_i;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_500_a = var1.readInt();
        this.field_501_e = var1.readByte();
        this.field_499_b = var1.readInt();
        this.field_503_c = var1.readInt();
        this.field_502_d = var1.readInt();
        this.field_28044_i = var1.readInt();
        if (this.field_28044_i > 0) {
            this.field_28047_e = var1.readShort();
            this.field_28046_f = var1.readShort();
            this.field_28045_g = var1.readShort();
        }

    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_500_a);
        var1.writeByte(this.field_501_e);
        var1.writeInt(this.field_499_b);
        var1.writeInt(this.field_503_c);
        var1.writeInt(this.field_502_d);
        var1.writeInt(this.field_28044_i);
        if (this.field_28044_i > 0) {
            var1.writeShort(this.field_28047_e);
            var1.writeShort(this.field_28046_f);
            var1.writeShort(this.field_28045_g);
        }

    }

    public void func_323_a(NetHandler var1) {
        var1.func_835_a(this);
    }

    public int func_329_a() {
        return 21 + this.field_28044_i > 0 ? 6 : 0;
    }
}
