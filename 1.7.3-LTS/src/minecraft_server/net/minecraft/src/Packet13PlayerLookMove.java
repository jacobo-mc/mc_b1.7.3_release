package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet13PlayerLookMove extends Packet10Flying {
    public Packet13PlayerLookMove() {
        this.rotating = true;
        this.moving = true;
    }

    public Packet13PlayerLookMove(double var1, double var3, double var5, double var7, float var9, float var10, boolean var11) {
        this.xPosition = var1;
        this.yPosition = var3;
        this.stance = var5;
        this.zPosition = var7;
        this.yaw = var9;
        this.pitch = var10;
        this.onGround = var11;
        this.rotating = true;
        this.moving = true;
    }

    public void readPacketData(DataInputStream var1) throws IOException {
        this.xPosition = var1.readDouble();
        this.yPosition = var1.readDouble();
        this.stance = var1.readDouble();
        this.zPosition = var1.readDouble();
        this.yaw = var1.readFloat();
        this.pitch = var1.readFloat();
        super.readPacketData(var1);
    }

    public void writePacketData(DataOutputStream var1) throws IOException {
        var1.writeDouble(this.xPosition);
        var1.writeDouble(this.yPosition);
        var1.writeDouble(this.stance);
        var1.writeDouble(this.zPosition);
        var1.writeFloat(this.yaw);
        var1.writeFloat(this.pitch);
        super.writePacketData(var1);
    }

    public int getPacketSize() {
        return 41;
    }
}
