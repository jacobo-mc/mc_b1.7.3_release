package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int speedX;
    public int speedY;
    public int speedZ;
    public int type;
    public int throwerEntityId;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.type = var1.readByte();
        this.xPosition = var1.readInt();
        this.yPosition = var1.readInt();
        this.zPosition = var1.readInt();
        this.throwerEntityId = var1.readInt();
        if (this.throwerEntityId > 0) {
            this.speedX = var1.readShort();
            this.speedY = var1.readShort();
            this.speedZ = var1.readShort();
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        var1.writeByte(this.type);
        var1.writeInt(this.xPosition);
        var1.writeInt(this.yPosition);
        var1.writeInt(this.zPosition);
        var1.writeInt(this.throwerEntityId);
        if (this.throwerEntityId > 0) {
            var1.writeShort(this.speedX);
            var1.writeShort(this.speedY);
            var1.writeShort(this.speedZ);
        }

    }

    public void processPacket(NetHandler var1) {
        var1.handleVehicleSpawn(this);
    }

    public int getPacketSize() {
        return 21 + this.throwerEntityId > 0 ? 6 : 0;
    }
}
