package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet5PlayerInventory extends Packet {
    public int entityID;
    public int slot;
    public int itemID;
    public int itemDamage;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.entityID = var1.readInt();
        this.slot = var1.readShort();
        this.itemID = var1.readShort();
        this.itemDamage = var1.readShort();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.entityID);
        var1.writeShort(this.slot);
        var1.writeShort(this.itemID);
        var1.writeShort(this.itemDamage);
    }

    public void processPacket(NetHandler var1) {
        var1.handlePlayerInventory(this);
    }

    public int getPacketSize() {
        return 8;
    }
}
