package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet131MapData extends Packet {
    public short field_28055_a;
    public short field_28054_b;
    public byte[] field_28056_c;

    public Packet131MapData() {
        this.field_472_j = true;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_28055_a = var1.readShort();
        this.field_28054_b = var1.readShort();
        this.field_28056_c = new byte[var1.readByte() & 255];
        var1.readFully(this.field_28056_c);
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_28055_a);
        var1.writeShort(this.field_28054_b);
        var1.writeByte(this.field_28056_c.length);
        var1.write(this.field_28056_c);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_28116_a(this);
    }

    public int func_329_a() {
        return 4 + this.field_28056_c.length;
    }
}
