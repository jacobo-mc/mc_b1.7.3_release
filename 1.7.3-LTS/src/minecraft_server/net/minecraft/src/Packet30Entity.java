package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet30Entity extends Packet {
    public int entityId;
    public byte xPosition;
    public byte yPosition;
    public byte zPosition;
    public byte yaw;
    public byte pitch;
    public boolean rotating = false;

    public Packet30Entity() {
    }

    public Packet30Entity(int var1) {
        this.entityId = var1;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
    }

    public void processPacket(NetHandler var1) {
        var1.handleEntity(this);
    }

    public int getPacketSize() {
        return 4;
    }
}
