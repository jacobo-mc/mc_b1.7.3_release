package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet131MapData extends Packet {
    public short field_28052_a;
    public short field_28051_b;
    public byte[] field_28053_c;

    public Packet131MapData() {
        this.isChunkDataPacket = true;
    }

    public Packet131MapData(short var1, short var2, byte[] var3) {
        this.isChunkDataPacket = true;
        this.field_28052_a = var1;
        this.field_28051_b = var2;
        this.field_28053_c = var3;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.field_28052_a = var1.readShort();
        this.field_28051_b = var1.readShort();
        this.field_28053_c = new byte[var1.readByte() & 255];
        var1.readFully(this.field_28053_c);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_28052_a);
        var1.writeShort(this.field_28051_b);
        var1.writeByte(this.field_28053_c.length);
        var1.write(this.field_28053_c);
    }

    public void processPacket(NetHandler var1) {
        var1.func_28001_a(this);
    }

    public int getPacketSize() {
        return 4 + this.field_28053_c.length;
    }
}
