package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet40EntityMetadata extends Packet {
    public int entityId;
    private List field_21048_b;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.field_21048_b = DataWatcher.readWatchableObjects(var1);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        DataWatcher.writeObjectsInListToStream(this.field_21048_b, var1);
    }

    public void processPacket(NetHandler var1) {
        var1.handleEntityMetadata(this);
    }

    public int getPacketSize() {
        return 5;
    }

    public List func_21047_b() {
        return this.field_21048_b;
    }
}
