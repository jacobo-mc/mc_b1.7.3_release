package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet50PreChunk extends Packet {
    public int xPosition;
    public int yPosition;
    public boolean mode;

    public Packet50PreChunk() {
        this.isChunkDataPacket = false;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xPosition = var1.readInt();
        this.yPosition = var1.readInt();
        this.mode = var1.read() != 0;
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.xPosition);
        var1.writeInt(this.yPosition);
        var1.write(this.mode ? 1 : 0);
    }

    public void processPacket(NetHandler var1) {
        var1.handlePreChunk(this);
    }

    public int getPacketSize() {
        return 9;
    }
}
