package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet4UpdateTime extends Packet {
    public long time;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.time = var1.readLong();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeLong(this.time);
    }

    public void processPacket(NetHandler var1) {
        var1.handleUpdateTime(this);
    }

    public int getPacketSize() {
        return 8;
    }
}
