package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class Packet40EntityMetadata extends Packet {
    public int entityId;
    private List field_21018_b;

    public Packet40EntityMetadata() {
    }

    public Packet40EntityMetadata(int var1, DataWatcher var2) {
        this.entityId = var1;
        this.field_21018_b = var2.getChangedObjects();
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityId = var1.readInt();
        this.field_21018_b = DataWatcher.readWatchableObjects(var1);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityId);
        DataWatcher.writeObjectsInListToStream(this.field_21018_b, var1);
    }

    public void processPacket(NetHandler var1) {
        var1.func_21002_a(this);
    }

    public int getPacketSize() {
        return 5;
    }
}
