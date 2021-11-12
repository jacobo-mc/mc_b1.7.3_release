package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet54PlayNoteBlock extends Packet {
    public int xLocation;
    public int yLocation;
    public int zLocation;
    public int instrumentType;
    public int pitch;

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xLocation = var1.readInt();
        this.yLocation = var1.readShort();
        this.zLocation = var1.readInt();
        this.instrumentType = var1.read();
        this.pitch = var1.read();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeInt(this.xLocation);
        var1.writeShort(this.yLocation);
        var1.writeInt(this.zLocation);
        var1.write(this.instrumentType);
        var1.write(this.pitch);
    }

    public void processPacket(NetHandler var1) {
        var1.handleNotePlay(this);
    }

    public int getPacketSize() {
        return 12;
    }
}
