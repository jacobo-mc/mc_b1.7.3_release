package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet130UpdateSign extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public String[] signLines;

    public Packet130UpdateSign() {
        this.isChunkDataPacket = true;
    }

    public Packet130UpdateSign(int var1, int var2, int var3, String[] var4) {
        this.isChunkDataPacket = true;
        this.xPosition = var1;
        this.yPosition = var2;
        this.zPosition = var3;
        this.signLines = var4;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xPosition = var1.readInt();
        this.yPosition = var1.readShort();
        this.zPosition = var1.readInt();
        this.signLines = new String[4];

        for(int var2 = 0; var2 < 4; ++var2) {
            this.signLines[var2] = readString(var1, 15);
        }

    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.xPosition);
        var1.writeShort(this.yPosition);
        var1.writeInt(this.zPosition);

        for(int var2 = 0; var2 < 4; ++var2) {
            writeString(this.signLines[var2], var1);
        }

    }

    public void processPacket(NetHandler var1) {
        var1.handleUpdateSign(this);
    }

    public int getPacketSize() {
        int var1 = 0;

        for(int var2 = 0; var2 < 4; ++var2) {
            var1 += this.signLines[var2].length();
        }

        return var1;
    }
}
