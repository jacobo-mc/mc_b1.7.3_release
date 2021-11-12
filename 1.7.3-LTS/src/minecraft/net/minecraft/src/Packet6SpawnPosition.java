package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SpawnPosition extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xPosition = var1.readInt();
        this.yPosition = var1.readInt();
        this.zPosition = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.xPosition);
        var1.writeInt(this.yPosition);
        var1.writeInt(this.zPosition);
    }

    public void processPacket(NetHandler var1) {
        var1.handleSpawnPosition(this);
    }

    public int getPacketSize() {
        return 12;
    }
}
