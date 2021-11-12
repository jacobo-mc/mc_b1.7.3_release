package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet38EntityStatus extends Packet {
    public int field_9274_a;
    public byte field_9273_b;

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_9274_a = var1.readInt();
        this.field_9273_b = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_9274_a);
        var1.writeByte(this.field_9273_b);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_9447_a(this);
    }

    public int func_329_a() {
        return 5;
    }
}
