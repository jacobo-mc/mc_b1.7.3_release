package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet61DoorChange extends Packet {
    public int field_28047_a;
    public int field_28046_b;
    public int field_28050_c;
    public int field_28049_d;
    public int field_28048_e;

    public Packet61DoorChange() {
    }

    public Packet61DoorChange(int var1, int var2, int var3, int var4, int var5) {
        this.field_28047_a = var1;
        this.field_28050_c = var2;
        this.field_28049_d = var3;
        this.field_28048_e = var4;
        this.field_28046_b = var5;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.field_28047_a = var1.readInt();
        this.field_28050_c = var1.readInt();
        this.field_28049_d = var1.readByte();
        this.field_28048_e = var1.readInt();
        this.field_28046_b = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_28047_a);
        var1.writeInt(this.field_28050_c);
        var1.writeByte(this.field_28049_d);
        var1.writeInt(this.field_28048_e);
        var1.writeInt(this.field_28046_b);
    }

    public void processPacket(NetHandler var1) {
        var1.func_28002_a(this);
    }

    public int getPacketSize() {
        return 20;
    }
}
