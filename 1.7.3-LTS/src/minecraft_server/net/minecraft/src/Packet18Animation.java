package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet18Animation extends Packet {
    public int entityId;
    public int animate;

    public Packet18Animation() {
    }

    public Packet18Animation(Entity var1, int var2) {
        this.entityId = var1.entityId;
        this.animate = var2;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.animate = var1.readByte();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        var1.writeByte(this.animate);
    }

    public void processPacket(NetHandler var1) {
        var1.handleArmAnimation(this);
    }

    public int getPacketSize() {
        return 5;
    }
}
