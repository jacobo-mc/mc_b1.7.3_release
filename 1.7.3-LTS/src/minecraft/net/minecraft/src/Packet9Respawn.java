package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet9Respawn extends Packet {
    public byte respawnDimension;

    public Packet9Respawn() {
    }

    public Packet9Respawn(byte var1) {
        this.respawnDimension = var1;
    }

    public void processPacket(NetHandler var1) {
        var1.handleRespawn(this);
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.respawnDimension = var1.readByte();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeByte(this.respawnDimension);
    }

    public int getPacketSize() {
        return 1;
    }
}
