package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet131MapData extends Packet {
    public short field_28055_a;
    public short field_28054_b;
    public byte[] field_28056_c;

    public Packet131MapData() {
        this.isChunkDataPacket = true;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.field_28055_a = var1.readShort();
        this.field_28054_b = var1.readShort();
        this.field_28056_c = new byte[var1.readByte() & 255];
        var1.readFully(this.field_28056_c);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeShort(this.field_28055_a);
        var1.writeShort(this.field_28054_b);
        var1.writeByte(this.field_28056_c.length);
        var1.write(this.field_28056_c);
    }

    public void processPacket(NetHandler var1) {
        var1.handleMapData(this);
    }

    public int getPacketSize() {
        return 4 + this.field_28056_c.length;
    }
}
