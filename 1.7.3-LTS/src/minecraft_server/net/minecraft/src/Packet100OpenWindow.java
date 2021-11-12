package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet100OpenWindow extends Packet {
    public int windowId;
    public int inventoryType;
    public String windowTitle;
    public int slotsCount;

    public Packet100OpenWindow() {
    }

    public Packet100OpenWindow(int var1, int var2, String var3, int var4) {
        this.windowId = var1;
        this.inventoryType = var2;
        this.windowTitle = var3;
        this.slotsCount = var4;
    }

    public void processPacket(NetHandler var1) {
        var1.func_20004_a(this);
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.windowId = var1.readByte();
        this.inventoryType = var1.readByte();
        this.windowTitle = var1.readUTF();
        this.slotsCount = var1.readByte();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeByte(this.windowId);
        var1.writeByte(this.inventoryType);
        var1.writeUTF(this.windowTitle);
        var1.writeByte(this.slotsCount);
    }

    public int getPacketSize() {
        return 3 + this.windowTitle.length();
    }
}
