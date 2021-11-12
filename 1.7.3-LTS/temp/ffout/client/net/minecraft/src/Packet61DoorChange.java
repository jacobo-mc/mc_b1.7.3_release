package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet61DoorChange extends Packet {
    public int field_28050_a;
    public int field_28049_b;
    public int field_28053_c;
    public int field_28052_d;
    public int field_28051_e;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_28050_a = var1.readInt();
        this.field_28053_c = var1.readInt();
        this.field_28052_d = var1.readByte();
        this.field_28051_e = var1.readInt();
        this.field_28049_b = var1.readInt();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_28050_a);
        var1.writeInt(this.field_28053_c);
        var1.writeByte(this.field_28052_d);
        var1.writeInt(this.field_28051_e);
        var1.writeInt(this.field_28049_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_28115_a(this);
    }

    public int func_329_a() {
        return 20;
    }
}
