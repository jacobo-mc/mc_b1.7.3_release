package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet33RelEntityMoveLook extends Packet30Entity {
    public Packet33RelEntityMoveLook() {
        this.rotating = true;
    }

    public Packet33RelEntityMoveLook(int var1, byte var2, byte var3, byte var4, byte var5, byte var6) {
        super(var1);
        this.xPosition = var2;
        this.yPosition = var3;
        this.zPosition = var4;
        this.yaw = var5;
        this.pitch = var6;
        this.rotating = true;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        super.readPacketData(var1);
        this.xPosition = var1.readByte();
        this.yPosition = var1.readByte();
        this.zPosition = var1.readByte();
        this.yaw = var1.readByte();
        this.pitch = var1.readByte();
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        super.writePacketData(var1);
        var1.writeByte(this.xPosition);
        var1.writeByte(this.yPosition);
        var1.writeByte(this.zPosition);
        var1.writeByte(this.yaw);
        var1.writeByte(this.pitch);
    }

    public int getPacketSize() {
        return 9;
    }
}
