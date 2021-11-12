package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet39AttachEntity extends Packet {
    public int entityId;
    public int vehicleEntityId;

    public int getPacketSize() {
        return 8;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.vehicleEntityId = var1.readInt();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        var1.writeInt(this.vehicleEntityId);
    }

    public void processPacket(NetHandler var1) {
        var1.handleAttachEntity(this);
    }
}
