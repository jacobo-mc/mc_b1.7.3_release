package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet31RelEntityMove extends Packet30Entity {
    public Packet31RelEntityMove() {
    }

    public Packet31RelEntityMove(int var1, byte var2, byte var3, byte var4) {
        super(var1);
        this.xPosition = var2;
        this.yPosition = var3;
        this.zPosition = var4;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        super.readPacketData(var1);
        this.xPosition = var1.readByte();
        this.yPosition = var1.readByte();
        this.zPosition = var1.readByte();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        super.writePacketData(var1);
        var1.writeByte(this.xPosition);
        var1.writeByte(this.yPosition);
        var1.writeByte(this.zPosition);
    }

    public int getPacketSize() {
        return 7;
    }
}
