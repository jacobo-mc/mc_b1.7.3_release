package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet17Sleep extends Packet {
    public int field_22041_a;
    public int field_22040_b;
    public int field_22044_c;
    public int field_22043_d;
    public int field_22042_e;

    public Packet17Sleep() {
    }

    public Packet17Sleep(Entity var1, int var2, int var3, int var4, int var5) {
        this.field_22042_e = var2;
        this.field_22040_b = var3;
        this.field_22044_c = var4;
        this.field_22043_d = var5;
        this.field_22041_a = var1.entityId;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.field_22041_a = var1.readInt();
        this.field_22042_e = var1.readByte();
        this.field_22040_b = var1.readInt();
        this.field_22044_c = var1.readByte();
        this.field_22043_d = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.field_22041_a);
        var1.writeByte(this.field_22042_e);
        var1.writeInt(this.field_22040_b);
        var1.writeByte(this.field_22044_c);
        var1.writeInt(this.field_22043_d);
    }

    public void processPacket(NetHandler var1) {
        var1.func_22002_a(this);
    }

    public int getPacketSize() {
        return 14;
    }
}
