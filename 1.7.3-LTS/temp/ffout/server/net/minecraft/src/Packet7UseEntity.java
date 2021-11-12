package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet7UseEntity extends Packet {
    public int field_9019_a;
    public int field_9018_b;
    public int field_9020_c;

    public void func_70_a(DataInputStream var1) throws IOException {
        this.field_9019_a = var1.readInt();
        this.field_9018_b = var1.readInt();
        this.field_9020_c = var1.readByte();
    }

    public void func_68_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_9019_a);
        var1.writeInt(this.field_9018_b);
        var1.writeByte(this.field_9020_c);
    }

    public void func_72_a(NetHandler var1) {
        var1.func_6006_a(this);
    }

    public int func_71_a() {
        return 9;
    }
}
