package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet7UseEntity extends Packet {
    public int field_9277_a;
    public int field_9276_b;
    public int field_9278_c;

    public Packet7UseEntity() {
    }

    public Packet7UseEntity(int var1, int var2, int var3) {
        this.field_9277_a = var1;
        this.field_9276_b = var2;
        this.field_9278_c = var3;
    }

    public void func_327_a(DataInputStream var1) throws IOException {
        this.field_9277_a = var1.readInt();
        this.field_9276_b = var1.readInt();
        this.field_9278_c = var1.readByte();
    }

    public void func_322_a(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_9277_a);
        var1.writeInt(this.field_9276_b);
        var1.writeByte(this.field_9278_c);
    }

    public void func_323_a(NetHandler var1) {
        var1.func_6499_a(this);
    }

    public int func_329_a() {
        return 9;
    }
}
